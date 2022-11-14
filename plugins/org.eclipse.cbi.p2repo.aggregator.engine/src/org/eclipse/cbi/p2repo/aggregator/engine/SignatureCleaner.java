/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.engine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import org.bouncycastle.bcpg.ArmoredInputStream;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPRuntimeOperationException;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.bc.BcPGPObjectFactory;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.eclipse.cbi.p2repo.cli.AbstractCommand;
import org.eclipse.cbi.p2repo.p2.util.P2Utils;
import org.eclipse.cbi.p2repo.util.IOUtils;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.internal.p2.artifact.processors.pgp.PGPPublicKeyStore;
import org.eclipse.equinox.internal.p2.artifact.processors.pgp.PGPSignatureVerifier;
import org.eclipse.equinox.internal.p2.artifact.repository.Activator;
import org.eclipse.equinox.internal.p2.artifact.repository.simple.SimpleArtifactRepository;
import org.eclipse.equinox.internal.p2.core.helpers.LogHelper;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.repository.artifact.ArtifactKeyQuery;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.eclipse.equinox.p2.repository.artifact.spi.ArtifactDescriptor;
import org.eclipse.equinox.p2.repository.spi.PGPPublicKeyService;
import org.eclipse.equinox.spi.p2.publisher.PublisherHelper;
import org.kohsuke.args4j.Option;

public class SignatureCleaner extends AbstractCommand {
	private static final boolean IGNORE_FEATURE_PGP_SIGNATURE = "true"
			.equals(System.getProperty("org.eclipse.cbi.p2repo.aggregator.ignoreFeaturePGPSignature"));

	public enum PGPActionType {
		DISCARD, KEEP, REPLACE, MERGE
	}

	@Option(name = "--repositoryLocation", usage = "The repository to clean.")
	private String repositoryLocation;

	@Option(name = "--rejectedFingerprints", usage = "A comma-separated list of SHA-256 signature fingerprints considered insecure.")
	private String rejectedFingerprints;

	@Option(name = "--pgpAction", usage = "Specify how to handle PGP keys and signatues. DISCARD them, KEEP the current ones, REPLACE the current ones with the originals, or MERGE the current ones with the originals.")
	private PGPActionType pgpAction = PGPActionType.REPLACE;

	@Override
	public String getShortDescription() {
		return "Cleans up the signatures in the repository as produced when built with --signerFingerprints";
	}

	@Override
	protected int run(IProgressMonitor monitor) throws Exception {
		Path agentLocation = Files.createTempDirectory("signature-clearner");
		IProvisioningAgent provisioningAgent = P2Utils.createDedicatedProvisioningAgent(agentLocation.toUri());
		IArtifactRepositoryManager repositoryManager = P2Utils.getRepositoryManager(provisioningAgent,
				IArtifactRepositoryManager.class);
		try {
			IArtifactRepository repository = repositoryManager.loadRepository(Path.of(repositoryLocation).toUri(),
					monitor);

			Set<String> rejectedFingerprints = this.rejectedFingerprints == null ? Set.of()
					: new HashSet<>(Arrays.asList(this.rejectedFingerprints.split(",")));

			IQueryResult<IArtifactKey> keys = repository.query(ArtifactKeyQuery.ALL_KEYS, monitor);
			for (IArtifactKey key : keys) {
				IArtifactDescriptor[] artifactDescriptors = repository.getArtifactDescriptors(key);
				for (IArtifactDescriptor artifactDescriptor : artifactDescriptors) {
					ArtifactDescriptor descriptor = (ArtifactDescriptor) artifactDescriptor;

					String pgpPublicKeys = descriptor.getProperty(PGPSignatureVerifier.PGP_SIGNER_KEYS_PROPERTY_NAME);
					String pgpSignatures = descriptor.getProperty(PGPSignatureVerifier.PGP_SIGNATURES_PROPERTY_NAME);

					String cbiPGPPublicKeys = descriptor.getProperty(MirrorGenerator.SIGNER_PGP_PUBLIC_KEYS);
					String cbiPGPSignatures = descriptor.getProperty(MirrorGenerator.SIGNER_PGP_SIGNATURES);

					String signerFingerprints = descriptor.getProperty(MirrorGenerator.SIGNER_FINGERPRINTS);
					if (signerFingerprints != null) {
						descriptor.setProperty(MirrorGenerator.SIGNER_FINGERPRINTS, null);
						Set<String> fingerprints = rejectedFingerprints == null ? Set.of()
								: new HashSet<>(Arrays.asList(signerFingerprints.split(" ")));
						fingerprints.removeAll(rejectedFingerprints);
						boolean discardPGP = !fingerprints.isEmpty();
						if (!discardPGP) {
							LogUtils.info("All signatures rejected " + artifactDescriptor);
							if (IGNORE_FEATURE_PGP_SIGNATURE
									&& PublisherHelper.ECLIPSE_FEATURE_CLASSIFIER.equals(key.getClassifier())) {
								LogUtils.info("Ignore feature PGP signatures " + artifactDescriptor);
								discardPGP = true;
							}
						}

						if (discardPGP) {
							// If there are valid jar signatures, remove the PGP signature, but only if there wasn't originally one.
							// E.g., jars that are only JCE-signed from Maven are also PGP signed.
							if (pgpPublicKeys != null && cbiPGPPublicKeys == null) {
								descriptor.setProperty(PGPSignatureVerifier.PGP_SIGNER_KEYS_PROPERTY_NAME, null);
								pgpPublicKeys = null;
							}
							if (pgpSignatures != null && cbiPGPSignatures == null) {
								descriptor.setProperty(PGPSignatureVerifier.PGP_SIGNATURES_PROPERTY_NAME, null);
								pgpSignatures = null;
							}
						}
					}

					if (cbiPGPPublicKeys != null) {
						descriptor.setProperty(MirrorGenerator.SIGNER_PGP_PUBLIC_KEYS, null);
						descriptor.setProperty(PGPSignatureVerifier.PGP_SIGNER_KEYS_PROPERTY_NAME,
								getComposedPGPKeys(pgpPublicKeys, cbiPGPPublicKeys));
					}

					if (cbiPGPSignatures != null) {
						descriptor.setProperty(MirrorGenerator.SIGNER_PGP_SIGNATURES, null);

						descriptor.setProperty(PGPSignatureVerifier.PGP_SIGNATURES_PROPERTY_NAME,
								getCompositeSignatures(pgpSignatures, cbiPGPSignatures));
					}
				}
			}

			((SimpleArtifactRepository) repository).save();
			MirrorGenerator.xzCompress(repository);
		} finally {
			P2Utils.ungetRepositoryManager(provisioningAgent, repositoryManager);
			P2Utils.stopProvisioningAgent(provisioningAgent);
			IOUtils.delete(agentLocation);
		}

		return 0;
	}

	@SuppressWarnings("unchecked")
	private String getComposedPGPKeys(String key1, String key2) throws IOException {
		switch (pgpAction) {
			case DISCARD: {
				return null;
			}
			case KEEP: {
				if (key1 != null) {
					return key1;
				}
				break;
			}
			case REPLACE: {
				if (key2 != null) {
					return key2;
				}
				break;
			}
			case MERGE: {
			}
		}

		if (key1 == null) {
			return key2;
		}

		if (key2 == null) {
			return key1;
		}

		PGPPublicKeyStore keyStore = new PGPPublicKeyStore();
		for (String key : new String[] { key1, key2 }) {
			try (InputStream stream = PGPUtil
					.getDecoderStream(new ByteArrayInputStream(key.getBytes(StandardCharsets.US_ASCII)))) {
				new JcaPGPObjectFactory(stream).iterator().forEachRemaining(o -> {
					if (o instanceof PGPPublicKeyRingCollection) {
						collectKeys((PGPPublicKeyRingCollection) o, keyStore::addKey);
					}
					if (o instanceof PGPPublicKeyRing) {
						collectKeys((PGPPublicKeyRing) o, keyStore::addKey);
					}
					if (o instanceof PGPPublicKey) {
						keyStore.addKey((PGPPublicKey) o);
					}
				});
			} catch (IOException | PGPRuntimeOperationException e) {
				LogHelper.log(new Status(IStatus.ERROR, Activator.ID, e.getMessage(), e));
			}
		}

		String result = keyStore.toArmoredString().replace("\r\n", "\n")
				.replaceAll("(-----BEGIN [^-]+-----)\nVersion: [^\n]*", "$1").trim();
		return result;
	}

	private static void collectKeys(PGPPublicKeyRingCollection pgpPublicKeyRingCollection,
			Consumer<PGPPublicKey> collector) {
		pgpPublicKeyRingCollection.iterator().forEachRemaining(keyring -> collectKeys(keyring, collector));
	}

	private static void collectKeys(PGPPublicKeyRing pgpPublicKeyRing, Consumer<PGPPublicKey> collector) {
		pgpPublicKeyRing.getPublicKeys().forEachRemaining(collector::accept);
	}

	private String getCompositeSignatures(String signature1, String signature2) throws IOException, PGPException {
		switch (pgpAction) {
			case DISCARD: {
				return null;
			}
			case KEEP: {
				if (signature1 != null) {
					return signature1;
				}
				break;
			}
			case REPLACE: {
				if (signature2 != null) {
					return signature2;
				}
				break;
			}
			case MERGE: {
			}
		}

		if (signature1 == null) {

			return signature2;
		}

		if (signature2 == null) {
			return signature1;
		}

		Map<String, PGPSignature> signatures = new LinkedHashMap<>();
		for (String signature : new String[] { signature1, signature2 }) {
			try (InputStream in = new ArmoredInputStream(
					new ByteArrayInputStream(signature.getBytes(StandardCharsets.US_ASCII)))) {
				PGPObjectFactory pgpFactory = new BcPGPObjectFactory(in);
				Object o = pgpFactory.nextObject();
				PGPSignatureList signatureList = new PGPSignatureList(new PGPSignature[0]);
				if (o instanceof PGPCompressedData) {
					PGPCompressedData pgpCompressData = (PGPCompressedData) o;
					pgpFactory = new BcPGPObjectFactory(pgpCompressData.getDataStream());
					signatureList = (PGPSignatureList) pgpFactory.nextObject();
				} else if (o instanceof PGPSignatureList) {
					signatureList = (PGPSignatureList) o;
				}
				for (Iterator<PGPSignature> it = signatureList.iterator(); it.hasNext();) {
					PGPSignature s = it.next();
					signatures.put(PGPPublicKeyService.toHex(s.getEncoded()), s);
				}
			}
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try (ArmoredOutputStream aOut = new ArmoredOutputStream(out)) {
			BCPGOutputStream bOut = new BCPGOutputStream(aOut);
			for (PGPSignature pgpSignature : signatures.values()) {
				pgpSignature.encode(bOut);
			}
		}

		String result = new String(out.toByteArray(), StandardCharsets.US_ASCII).replace("\r\n", "\n")
				.replaceAll("(-----BEGIN [^-]+-----)\nVersion: [^\n]*", "$1").trim();
		return result;
	}
}
