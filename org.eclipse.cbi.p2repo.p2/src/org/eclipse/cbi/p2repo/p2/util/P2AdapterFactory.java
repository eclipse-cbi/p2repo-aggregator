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
package org.eclipse.cbi.p2repo.p2.util;

import java.util.Map;

import org.eclipse.cbi.p2repo.p2.ArtifactDescriptor;
import org.eclipse.cbi.p2repo.p2.ArtifactKey;
import org.eclipse.cbi.p2repo.p2.ArtifactRepository;
import org.eclipse.cbi.p2repo.p2.Copyright;
import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.p2.InstallableUnitFragment;
import org.eclipse.cbi.p2repo.p2.InstallableUnitPatch;
import org.eclipse.cbi.p2repo.p2.License;
import org.eclipse.cbi.p2repo.p2.MappingRule;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.ProcessingStepDescriptor;
import org.eclipse.cbi.p2repo.p2.ProvidedCapability;
import org.eclipse.cbi.p2repo.p2.Repository;
import org.eclipse.cbi.p2repo.p2.RepositoryReference;
import org.eclipse.cbi.p2repo.p2.RequiredCapability;
import org.eclipse.cbi.p2repo.p2.Requirement;
import org.eclipse.cbi.p2repo.p2.RequirementChange;
import org.eclipse.cbi.p2repo.p2.SimpleArtifactDescriptor;
import org.eclipse.cbi.p2repo.p2.SimpleArtifactRepository;
import org.eclipse.cbi.p2repo.p2.TouchpointData;
import org.eclipse.cbi.p2repo.p2.TouchpointInstruction;
import org.eclipse.cbi.p2repo.p2.TouchpointType;
import org.eclipse.cbi.p2repo.p2.UpdateDescriptor;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.internal.p2.metadata.IRequiredCapability;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.ICopyright;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IInstallableUnitFragment;
import org.eclipse.equinox.p2.metadata.IInstallableUnitPatch;
import org.eclipse.equinox.p2.metadata.ILicense;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.IRequirementChange;
import org.eclipse.equinox.p2.metadata.ITouchpointData;
import org.eclipse.equinox.p2.metadata.ITouchpointInstruction;
import org.eclipse.equinox.p2.metadata.ITouchpointType;
import org.eclipse.equinox.p2.metadata.IUpdateDescriptor;
import org.eclipse.equinox.p2.metadata.IVersionedId;
import org.eclipse.equinox.p2.query.IQueryable;
import org.eclipse.equinox.p2.repository.IRepository;
import org.eclipse.equinox.p2.repository.IRepositoryReference;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.p2.P2Package
 * @generated
 */
public class P2AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static P2Package modelPackage;

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected P2Switch<Adapter> modelSwitch = new P2Switch<>() {
		@Override
		public Adapter caseArtifactKey(ArtifactKey object) {
			return createArtifactKeyAdapter();
		}

		@Override
		public Adapter caseArtifactDescriptor(ArtifactDescriptor object) {
			return createArtifactDescriptorAdapter();
		}

		@Override
		public Adapter caseArtifactRepository(ArtifactRepository object) {
			return createArtifactRepositoryAdapter();
		}

		@Override
		public Adapter caseArtifactsByKey(Map.Entry<IArtifactKey, EList<IArtifactDescriptor>> object) {
			return createArtifactsByKeyAdapter();
		}

		@Override
		public <T> Adapter caseComparable(Comparable<T> object) {
			return createComparableAdapter();
		}

		@Override
		public Adapter caseCopyright(Copyright object) {
			return createCopyrightAdapter();
		}

		@Override
		public Adapter caseIAdaptable(IAdaptable object) {
			return createIAdaptableAdapter();
		}

		@Override
		public Adapter caseIArtifactDescriptor(IArtifactDescriptor object) {
			return createIArtifactDescriptorAdapter();
		}

		@Override
		public Adapter caseIArtifactKey(IArtifactKey object) {
			return createIArtifactKeyAdapter();
		}

		@Override
		public Adapter caseIArtifactRepository(IArtifactRepository object) {
			return createIArtifactRepositoryAdapter();
		}

		@Override
		public Adapter caseICopyright(ICopyright object) {
			return createICopyrightAdapter();
		}

		@Override
		public Adapter caseIFileArtifactRepository(IFileArtifactRepository object) {
			return createIFileArtifactRepositoryAdapter();
		}

		@Override
		public Adapter caseIInstallableUnit(IInstallableUnit object) {
			return createIInstallableUnitAdapter();
		}

		@Override
		public Adapter caseIInstallableUnitFragment(IInstallableUnitFragment object) {
			return createIInstallableUnitFragmentAdapter();
		}

		@Override
		public Adapter caseIInstallableUnitPatch(IInstallableUnitPatch object) {
			return createIInstallableUnitPatchAdapter();
		}

		@Override
		public Adapter caseILicense(ILicense object) {
			return createILicenseAdapter();
		}

		@Override
		public Adapter caseInstallableUnit(InstallableUnit object) {
			return createInstallableUnitAdapter();
		}

		@Override
		public Adapter caseInstallableUnitFragment(InstallableUnitFragment object) {
			return createInstallableUnitFragmentAdapter();
		}

		@Override
		public Adapter caseInstallableUnitPatch(InstallableUnitPatch object) {
			return createInstallableUnitPatchAdapter();
		}

		@Override
		public Adapter caseInstructionMap(Map.Entry<String, ITouchpointInstruction> object) {
			return createInstructionMapAdapter();
		}

		@Override
		public Adapter caseIMetadataRepository(IMetadataRepository object) {
			return createIMetadataRepositoryAdapter();
		}

		@Override
		public Adapter caseIProcessingStepDescriptor(IProcessingStepDescriptor object) {
			return createIProcessingStepDescriptorAdapter();
		}

		@Override
		public Adapter caseIProvidedCapability(IProvidedCapability object) {
			return createIProvidedCapabilityAdapter();
		}

		@Override
		public <T> Adapter caseIQueryable(IQueryable<T> object) {
			return createIQueryableAdapter();
		}

		@Override
		public <T> Adapter caseIRepository(IRepository<T> object) {
			return createIRepositoryAdapter();
		}

		@Override
		public Adapter caseIRepositoryReference(IRepositoryReference object) {
			return createIRepositoryReferenceAdapter();
		}

		@Override
		public Adapter caseIRequirement(IRequirement object) {
			return createIRequirementAdapter();
		}

		@Override
		public Adapter caseIRequiredCapability(IRequiredCapability object) {
			return createIRequiredCapabilityAdapter();
		}

		@Override
		public Adapter caseIRequirementChange(IRequirementChange object) {
			return createIRequirementChangeAdapter();
		}

		@Override
		public Adapter caseITouchpointData(ITouchpointData object) {
			return createITouchpointDataAdapter();
		}

		@Override
		public Adapter caseITouchpointInstruction(ITouchpointInstruction object) {
			return createITouchpointInstructionAdapter();
		}

		@Override
		public Adapter caseITouchpointType(ITouchpointType object) {
			return createITouchpointTypeAdapter();
		}

		@Override
		public Adapter caseIVersionedId(IVersionedId object) {
			return createIVersionedIdAdapter();
		}

		@Override
		public Adapter caseIUpdateDescriptor(IUpdateDescriptor object) {
			return createIUpdateDescriptorAdapter();
		}

		@Override
		public Adapter caseLicense(License object) {
			return createLicenseAdapter();
		}

		@Override
		public Adapter caseMappingRule(MappingRule object) {
			return createMappingRuleAdapter();
		}

		@Override
		public Adapter caseMetadataRepository(MetadataRepository object) {
			return createMetadataRepositoryAdapter();
		}

		@Override
		public Adapter caseProcessingStepDescriptor(ProcessingStepDescriptor object) {
			return createProcessingStepDescriptorAdapter();
		}

		@Override
		public Adapter caseProperty(Map.Entry<String, String> object) {
			return createPropertyAdapter();
		}

		@Override
		public Adapter caseProvidedCapability(ProvidedCapability object) {
			return createProvidedCapabilityAdapter();
		}

		@Override
		public <T> Adapter caseRepository(Repository<T> object) {
			return createRepositoryAdapter();
		}

		@Override
		public Adapter caseRepositoryReference(RepositoryReference object) {
			return createRepositoryReferenceAdapter();
		}

		@Override
		public Adapter caseRequiredCapability(RequiredCapability object) {
			return createRequiredCapabilityAdapter();
		}

		@Override
		public Adapter caseRequirement(Requirement object) {
			return createRequirementAdapter();
		}

		@Override
		public Adapter caseRequirementChange(RequirementChange object) {
			return createRequirementChangeAdapter();
		}

		@Override
		public Adapter caseSimpleArtifactRepository(SimpleArtifactRepository object) {
			return createSimpleArtifactRepositoryAdapter();
		}

		@Override
		public Adapter caseSimpleArtifactDescriptor(SimpleArtifactDescriptor object) {
			return createSimpleArtifactDescriptorAdapter();
		}

		@Override
		public Adapter caseTouchpointData(TouchpointData object) {
			return createTouchpointDataAdapter();
		}

		@Override
		public Adapter caseTouchpointInstruction(TouchpointInstruction object) {
			return createTouchpointInstructionAdapter();
		}

		@Override
		public Adapter caseTouchpointType(TouchpointType object) {
			return createTouchpointTypeAdapter();
		}

		@Override
		public Adapter caseUpdateDescriptor(UpdateDescriptor object) {
			return createUpdateDescriptorAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public P2AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = P2Package.eINSTANCE;
		}
	}

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.ArtifactDescriptor <em>Artifact Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.ArtifactDescriptor
	 * @generated
	 */
	public Adapter createArtifactDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.ArtifactKey <em>Artifact Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.ArtifactKey
	 * @generated
	 */
	public Adapter createArtifactKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.ArtifactRepository <em>Artifact Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.ArtifactRepository
	 * @generated
	 */
	public Adapter createArtifactRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Artifacts By Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createArtifactsByKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.lang.Comparable <em>Comparable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.lang.Comparable
	 * @generated
	 */
	public Adapter createComparableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.Copyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.Copyright
	 * @generated
	 */
	public Adapter createCopyrightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.core.runtime.IAdaptable <em>IAdaptable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.core.runtime.IAdaptable
	 * @generated
	 */
	public Adapter createIAdaptableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor <em>IArtifact Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor
	 * @generated
	 */
	public Adapter createIArtifactDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.IArtifactKey <em>IArtifact Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.IArtifactKey
	 * @generated
	 */
	public Adapter createIArtifactKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.repository.artifact.IArtifactRepository <em>IArtifact Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.repository.artifact.IArtifactRepository
	 * @generated
	 */
	public Adapter createIArtifactRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.ICopyright <em>ICopyright</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.ICopyright
	 * @generated
	 */
	public Adapter createICopyrightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository <em>IFile Artifact Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository
	 * @generated
	 */
	public Adapter createIFileArtifactRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit <em>IInstallable Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit
	 * @generated
	 */
	public Adapter createIInstallableUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitFragment <em>IInstallable Unit Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitFragment
	 * @generated
	 */
	public Adapter createIInstallableUnitFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitPatch <em>IInstallable Unit Patch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitPatch
	 * @generated
	 */
	public Adapter createIInstallableUnitPatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.ILicense <em>ILicense</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.ILicense
	 * @generated
	 */
	public Adapter createILicenseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.repository.metadata.IMetadataRepository <em>IMetadata Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.repository.metadata.IMetadataRepository
	 * @generated
	 */
	public Adapter createIMetadataRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.InstallableUnit <em>Installable Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.InstallableUnit
	 * @generated
	 */
	public Adapter createInstallableUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.InstallableUnitFragment <em>Installable Unit Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.InstallableUnitFragment
	 * @generated
	 */
	public Adapter createInstallableUnitFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.InstallableUnitPatch <em>Installable Unit Patch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.InstallableUnitPatch
	 * @generated
	 */
	public Adapter createInstallableUnitPatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Instruction Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createInstructionMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor <em>IProcessing Step Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor
	 * @generated
	 */
	public Adapter createIProcessingStepDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.IProvidedCapability <em>IProvided Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.IProvidedCapability
	 * @generated
	 */
	public Adapter createIProvidedCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.query.IQueryable <em>IQueryable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.query.IQueryable
	 * @generated
	 */
	public Adapter createIQueryableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.repository.IRepository <em>IRepository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.repository.IRepository
	 * @generated
	 */
	public Adapter createIRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.repository.IRepositoryReference <em>IRepository Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.repository.IRepositoryReference
	 * @generated
	 */
	public Adapter createIRepositoryReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.internal.p2.metadata.IRequiredCapability <em>IRequired Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.internal.p2.metadata.IRequiredCapability
	 * @generated
	 */
	public Adapter createIRequiredCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.IRequirement <em>IRequirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.IRequirement
	 * @generated
	 */
	public Adapter createIRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.IRequirementChange <em>IRequirement Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.IRequirementChange
	 * @generated
	 */
	public Adapter createIRequirementChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.ITouchpointData <em>ITouchpoint Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointData
	 * @generated
	 */
	public Adapter createITouchpointDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.ITouchpointInstruction <em>ITouchpoint Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointInstruction
	 * @generated
	 */
	public Adapter createITouchpointInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.ITouchpointType <em>ITouchpoint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointType
	 * @generated
	 */
	public Adapter createITouchpointTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.IUpdateDescriptor <em>IUpdate Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.IUpdateDescriptor
	 * @generated
	 */
	public Adapter createIUpdateDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.equinox.p2.metadata.IVersionedId <em>IVersioned Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.equinox.p2.metadata.IVersionedId
	 * @generated
	 */
	public Adapter createIVersionedIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.License <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.License
	 * @generated
	 */
	public Adapter createLicenseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.MappingRule <em>Mapping Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.MappingRule
	 * @generated
	 */
	public Adapter createMappingRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.MetadataRepository <em>Metadata Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.MetadataRepository
	 * @generated
	 */
	public Adapter createMetadataRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.ProcessingStepDescriptor <em>Processing Step Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.ProcessingStepDescriptor
	 * @generated
	 */
	public Adapter createProcessingStepDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.ProvidedCapability <em>Provided Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.ProvidedCapability
	 * @generated
	 */
	public Adapter createProvidedCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.Repository
	 * @generated
	 */
	public Adapter createRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.RepositoryReference <em>Repository Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.RepositoryReference
	 * @generated
	 */
	public Adapter createRepositoryReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.RequiredCapability <em>Required Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.RequiredCapability
	 * @generated
	 */
	public Adapter createRequiredCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.RequirementChange <em>Requirement Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.RequirementChange
	 * @generated
	 */
	public Adapter createRequirementChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.SimpleArtifactDescriptor <em>Simple Artifact Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.SimpleArtifactDescriptor
	 * @generated
	 */
	public Adapter createSimpleArtifactDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.SimpleArtifactRepository <em>Simple Artifact Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.SimpleArtifactRepository
	 * @generated
	 */
	public Adapter createSimpleArtifactRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.TouchpointData <em>Touchpoint Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.TouchpointData
	 * @generated
	 */
	public Adapter createTouchpointDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.TouchpointInstruction <em>Touchpoint Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.TouchpointInstruction
	 * @generated
	 */
	public Adapter createTouchpointInstructionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.TouchpointType <em>Touchpoint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.TouchpointType
	 * @generated
	 */
	public Adapter createTouchpointTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.UpdateDescriptor <em>Update Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.UpdateDescriptor
	 * @generated
	 */
	public Adapter createUpdateDescriptorAdapter() {
		return null;
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

} // P2AdapterFactory
