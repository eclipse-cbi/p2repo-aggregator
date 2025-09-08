/**
 * Copyright (c) 2025 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.engine.maven;

import static org.eclipse.equinox.p2.repository.spi.PGPPublicKeyService.toHex;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.CompressionAlgorithmTags;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.bcpg.sig.KeyFlags;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKeyRingGenerator;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPRuntimeOperationException;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyDecryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyEncryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider;
import org.bouncycastle.openpgp.operator.bc.BcPGPKeyPair;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.equinox.p2.repository.spi.PGPPublicKeyService;

public class BouncyCastleSigner {

	static {
		if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
			Security.addProvider(new BouncyCastleProvider());
		}
	}

	private String keyname;

	private String passphrase;

	private String publicKeys;

	private String secretKeys;

	private PGPSecretKey secretKey;

	private PGPPrivateKey privateKey;

	/**
	 * Create an empty instance that needs to be configured before it is used.
	 * 
	 * @see #configure(String, String, String, String)
	 * @see #configureFromPGPInfo(String, File)
	 * @see #configureNewUserIDs(String, String...)
	 */
	public BouncyCastleSigner() {
	}

	public BouncyCastleSigner configure(String keyname, String passphrase, String publicKeys, String secretKeys)
			throws IOException, PGPException {
		this.keyname = keyname == null ? null : keyname.toLowerCase();
		this.passphrase = passphrase;
		this.publicKeys = publicKeys;
		this.secretKeys = secretKeys;
		initPrivateKey();
		return this;
	}

	/**
	 * Configure the new key ring by loading the key ring information as saved by {@link #dump(Path)}.
	 * 
	 * @throws IOException
	 * @throws PGPException
	 * 
	 * @see #main(String[])
	 */
	private BouncyCastleSigner configureFromPGPInfo(String keyname, File pgpInfo) throws PGPException, IOException {
		this.keyname = keyname;
		initFromPGPInfo(pgpInfo);
		return this;
	}

	/**
	 * This configure a new key ring for this passphrase for the given user IDs.
	 * 
	 * @throws IOException
	 * @throws PGPException
	 */
	private BouncyCastleSigner configureNewUserIDs(String passphrase, String... userIDs)
			throws PGPException, IOException {
		this.passphrase = passphrase;
		init(userIDs);
		return this;
	}

	private SignatureStore generateSignature(File file) throws PGPException, IOException {
		var publicKey = secretKey.getPublicKey();
		var signatureGenerator = new PGPSignatureGenerator(
				new JcaPGPContentSignerBuilder(publicKey.getAlgorithm(), HashAlgorithmTags.SHA256)
						.setProvider(BouncyCastleProvider.PROVIDER_NAME),
				publicKey);
		signatureGenerator.init(PGPSignature.BINARY_DOCUMENT, privateKey);
		var subpackets = new PGPSignatureSubpacketGenerator();
		subpackets.setIssuerFingerprint(false, publicKey);
		var userIDs = publicKey.getUserIDs();
		if (userIDs.hasNext()) {
			subpackets.addSignerUserID(false, userIDs.next());
		}
		signatureGenerator.setHashedSubpackets(subpackets.generate());
		signatureGenerator.init(PGPSignature.BINARY_DOCUMENT, privateKey);

		try (var in = Files.newInputStream(file.toPath())) {
			var buffer = new byte[8192];
			int read;
			while ((read = in.read(buffer)) >= 0) {
				signatureGenerator.update(buffer, 0, read);
			}
		}

		var signatureStore = SignatureStore.create(signatureGenerator.generate());
		return signatureStore;
	}

	public void generateSignatureForFile(File file, File signature) throws IOException, PGPException {
		Files.writeString(signature.toPath(), generateSignature(file).toArmoredString());
	}

	private void initFromPGPInfo(File pgpInfo) throws PGPException, IOException {
		var lines = Files.readAllLines(pgpInfo.toPath(), StandardCharsets.US_ASCII);
		passphrase = lines.get(0);
		var index = lines.indexOf("-----END PGP PUBLIC KEY BLOCK-----");
		publicKeys = String.join("\n", lines.subList(1, index + 1));
		secretKeys = String.join("\n", lines.subList(index + 1, lines.size()));
		initPrivateKey();
	}

	private void initPrivateKey() throws IOException, PGPException {
		var keyStore = KeyStore.create("");
		try (var stream = PGPUtil
				.getDecoderStream(new ByteArrayInputStream(secretKeys.getBytes(StandardCharsets.US_ASCII)))) {
			for (var object : new JcaPGPObjectFactory(stream)) {
				if (object instanceof PGPSecretKeyRing secretKeyRing) {
					if (publicKeys == null) {
						for (var key : secretKeyRing) {
							var publicKey = key.getPublicKey();
							LogUtils.info("Secret key available for public key: " + toHex(publicKey.getFingerprint()));
							keyStore.add(publicKey);
						}
					}
					if (secretKey == null) {
						secretKey = getSecretKey(secretKeyRing);
						if (secretKey != null) {
							var fingerprint = secretKey.getPublicKey().getFingerprint();
							LogUtils.info("Trying to get the private key of the secret key of public key: "
									+ toHex(fingerprint));
							privateKey = getPrivateKey(secretKey);
							if (privateKey == null) {
								LogUtils.info("Could not a create private key for the secret key of public key: "
										+ toHex(fingerprint));
								secretKey = null;
							} else {
								LogUtils.info(
										"Got the private key of the secret key of public key: " + toHex(fingerprint));
							}
						}
					}
				}
			}
		}

		if (secretKey == null) {
			throw new PGPException("A secret key for keyname '" + keyname + "' not found.");
		}

		if (publicKeys == null) {
			publicKeys = keyStore.toArmoredString();
		}
	}

	/**
	 * Initializes by generating a key ring for the given user ID.
	 */
	private void init(String... userIDs) throws PGPException, IOException {
		var keyPairGenerator = new RSAKeyPairGenerator();
		keyPairGenerator
				.init(new RSAKeyGenerationParameters(BigInteger.valueOf(0x10001), new SecureRandom(), 4096, 12));

		var now = new Date(0);
		var publicKeyRings = new ArrayList<PGPPublicKeyRing>();
		var secretKeyRings = new ArrayList<PGPSecretKeyRing>();
		var ids = new LinkedHashMap<String, PGPPublicKeyRing>();
		for (var userID : userIDs) {
			var signingKeyPair = new BcPGPKeyPair(PublicKeyPacket.VERSION_4, PGPPublicKey.RSA_GENERAL,
					keyPairGenerator.generateKeyPair(), now);
			var signatureSubpacketGenerator = new PGPSignatureSubpacketGenerator();
			signatureSubpacketGenerator.setKeyFlags(false, KeyFlags.SIGN_DATA | KeyFlags.CERTIFY_OTHER);
			signatureSubpacketGenerator.setPreferredSymmetricAlgorithms(false,
					new int[] { SymmetricKeyAlgorithmTags.AES_256, SymmetricKeyAlgorithmTags.AES_128 });
			signatureSubpacketGenerator.setPreferredHashAlgorithms(false,
					new int[] { HashAlgorithmTags.SHA512, HashAlgorithmTags.SHA256 });
			signatureSubpacketGenerator.setPreferredCompressionAlgorithms(false,
					new int[] { CompressionAlgorithmTags.ZIP, CompressionAlgorithmTags.BZIP2 });

			var encryptionKeyPair = new BcPGPKeyPair(PublicKeyPacket.VERSION_4, PGPPublicKey.RSA_GENERAL,
					keyPairGenerator.generateKeyPair(), now);
			var encryptionSubpacketGenerator = new PGPSignatureSubpacketGenerator();
			encryptionSubpacketGenerator.setKeyFlags(false, KeyFlags.ENCRYPT_COMMS | KeyFlags.ENCRYPT_STORAGE);

			var digestCalculator = new BcPGPDigestCalculatorProvider().get(HashAlgorithmTags.SHA1);
			var signatureSubpacketVector = signatureSubpacketGenerator.generate();
			var contentSignerBuilder = new BcPGPContentSignerBuilder(PGPPublicKey.RSA_GENERAL,
					HashAlgorithmTags.SHA256);
			var secretKeyEncryptorBuilder = new BcPBESecretKeyEncryptorBuilder(SymmetricKeyAlgorithmTags.AES_256);
			var keyRingGenerator = new PGPKeyRingGenerator(PGPPublicKey.RSA_GENERAL, signingKeyPair, userID,
					digestCalculator, signatureSubpacketVector, null, contentSignerBuilder,
					secretKeyEncryptorBuilder.build(passphrase.toCharArray()));
			keyRingGenerator.addSubKey(encryptionKeyPair, encryptionSubpacketGenerator.generate(), null);
			var publicKeyRing = keyRingGenerator.generatePublicKeyRing();
			ids.put(userID, publicKeyRing);
			publicKeyRings.add(publicKeyRing);
			secretKeyRings.add(keyRingGenerator.generateSecretKeyRing());
		}

		var publicKeyOut = new ByteArrayOutputStream();
		var builder = ArmoredOutputStream.builder();
		ids.entrySet().stream().map(it -> it.getKey() + " " + toHex(it.getValue().getPublicKey().getFingerprint()))
				.forEach(it -> builder.addComment("Key: " + it));
		try (var targetStream = builder.setVersion(null).build(publicKeyOut)) {
			new PGPPublicKeyRingCollection(publicKeyRings).encode(targetStream);
		}

		var secretKeyOut = new ByteArrayOutputStream();
		try (var targetStream = builder.setVersion(null).build(secretKeyOut)) {
			new PGPSecretKeyRingCollection(secretKeyRings).encode(targetStream);
		}

		publicKeys = publicKeyOut.toString(StandardCharsets.US_ASCII);
		secretKeys = secretKeyOut.toString(StandardCharsets.US_ASCII);

		secretKey = getSecretKey(secretKeyRings.get(0));
		privateKey = getPrivateKey(this.secretKey);
	}

	private PGPSecretKey getSecretKey(PGPSecretKeyRing secretKeyRing) throws PGPException {
		for (var secretKeys = secretKeyRing.getSecretKeys(); secretKeys.hasNext();) {
			var pgpSecretKey = secretKeys.next();
			if (!pgpSecretKey.isPrivateKeyEmpty() && pgpSecretKey.isSigningKey()) {
				if (keyname == null) {
					return pgpSecretKey;
				}

				// Match the key's fingerprint.
				var publicKey = pgpSecretKey.getPublicKey();
				var fingerprint = toHex(publicKey.getFingerprint());
				if (fingerprint.endsWith(keyname)) {
					return pgpSecretKey;
				}

				// Match the key ID of any subkey bindings.
				for (var subkeyBindings = publicKey.getSignaturesOfType(PGPSignature.SUBKEY_BINDING); subkeyBindings
						.hasNext();) {
					var pgpSignature = subkeyBindings.next();
					if (keyname == null || toHex(pgpSignature.getKeyID()).endsWith(keyname)) {
						return pgpSecretKey;
					}
				}
			}
		}
		return null;
	}

	private PGPPrivateKey getPrivateKey(PGPSecretKey pgpSecretKey) throws PGPException {
		var pbeSecretKeyDecryptor = new BcPBESecretKeyDecryptorBuilder(new BcPGPDigestCalculatorProvider())
				.build(passphrase.toCharArray());
		return pgpSecretKey.extractPrivateKey(pbeSecretKeyDecryptor);
	}

	private void dump(Path target) throws IOException {
		try (var out = new PrintStream(Files.newOutputStream(target))) {
			out.println(passphrase);
			out.print(publicKeys);
			out.print(secretKeys);
		}
	}

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			// Creates a file with multiple public and private keys that can be used for testing.
			var target = Files.createTempFile("pgp", ".info");
			new BouncyCastleSigner()
					.configureNewUserIDs("passphrase", "Tester1 <tester1@example.com>", "Tester2 <tester2@example.com>")
					.dump(target);
			new BouncyCastleSigner().configureFromPGPInfo(null, target.toFile());
			Files.copy(target, System.out);
		} else {
			var signer = new BouncyCastleSigner();
			signer.configureFromPGPInfo(args[0], new File(args[2]));
			var target = Files.createTempFile("pgp", ".info");
			target = Path.of(args[3]);
			SignatureStore signature = signer.generateSignature(target.toFile());
			System.out.println(signature.toArmoredString());
		}
	}

	private static class KeyStore {
		private Map<String, PGPPublicKey> keys = new TreeMap<>();

		public static KeyStore create(String... keys) {
			var keyStore = new KeyStore();
			keyStore.add(keys);
			return keyStore;
		}

		private KeyStore() {
		}

		public void add(PGPPublicKey key) {
			keys.put(PGPPublicKeyService.toHexFingerprint(key), key);
		}

		public void add(String... keys) {
			for (var key : keys) {
				if (key != null) {
					readKeys(key).forEach(this::add);
				}
			}
		}

		public String toArmoredString() throws IOException {
			var out = new ByteArrayOutputStream();
			try (var armoredOut = ArmoredOutputStream.builder().setVersion(null).build(out)) {
				for (var key : keys.values()) {
					key.encode(armoredOut);
				}
			}
			return out.toString(StandardCharsets.US_ASCII);
		}

		@SuppressWarnings("unchecked")
		private static Set<PGPPublicKey> readKeys(String keys) {
			if (keys == null) {
				return Set.of();
			}
			var result = new HashSet<PGPPublicKey>();
			try (var stream = PGPUtil
					.getDecoderStream(new ByteArrayInputStream(keys.getBytes(StandardCharsets.US_ASCII)))) {
				new JcaPGPObjectFactory(stream).forEach(o -> {
					if (o instanceof PGPPublicKeyRingCollection pgpPublicKeyRingCollection) {
						collectKeys(pgpPublicKeyRingCollection, result::add);
					}
					if (o instanceof PGPPublicKeyRing pgpPublicKeyRing) {
						collectKeys(pgpPublicKeyRing, result::add);
					}
					if (o instanceof PGPPublicKey pgpPublicKey) {
						result.add(pgpPublicKey);
					}
				});
			} catch (IOException | PGPRuntimeOperationException e) {
				throw new RuntimeException(e);
			}
			return result;
		}

		private static void collectKeys(PGPPublicKeyRingCollection pgpPublicKeyRingCollection,
				Consumer<PGPPublicKey> collector) {
			pgpPublicKeyRingCollection.forEach(keyring -> collectKeys(keyring, collector));
		}

		private static void collectKeys(PGPPublicKeyRing pgpPublicKeyRing, Consumer<PGPPublicKey> collector) {
			pgpPublicKeyRing.getPublicKeys().forEachRemaining(collector::accept);
		}
	}

	private static class SignatureStore {
		private final Map<String, PGPSignature> signatures = new TreeMap<>();

		public static SignatureStore create(PGPSignature... signatures) {
			var store = new SignatureStore();
			for (var signature : signatures) {
				store.add(signature);
			}
			return store;
		}

		private SignatureStore() {
		}

		public void add(PGPSignature signature) {
			try {
				signatures.put(toHex(signature.getEncoded()), signature);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public String toArmoredString() throws IOException {
			var out = new ByteArrayOutputStream();
			try (var armoredOut = ArmoredOutputStream.builder().setVersion(null).build(out)) {
				for (var signatures : signatures.values()) {
					signatures.encode(armoredOut);
				}
			}
			return out.toString(StandardCharsets.US_ASCII);
		}
	}
}
