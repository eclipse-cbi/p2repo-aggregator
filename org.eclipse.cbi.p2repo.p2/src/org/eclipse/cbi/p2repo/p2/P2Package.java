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
package org.eclipse.cbi.p2repo.p2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.p2.P2Factory
 * @model kind="package"
 * @generated
 */
public interface P2Package extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.IArtifactKey <em>IArtifact Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.IArtifactKey
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactKey()
		 * @generated
		 */
		EClass IARTIFACT_KEY = eINSTANCE.getIArtifactKey();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IARTIFACT_KEY__CLASSIFIER = eINSTANCE.getIArtifactKey_Classifier();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IARTIFACT_KEY__ID = eINSTANCE.getIArtifactKey_Id();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IARTIFACT_KEY__VERSION = eINSTANCE.getIArtifactKey_Version();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.repository.artifact.IArtifactRepository <em>IArtifact Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.repository.artifact.IArtifactRepository
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactRepository()
		 * @generated
		 */
		EClass IARTIFACT_REPOSITORY = eINSTANCE.getIArtifactRepository();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.ICopyright <em>ICopyright</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.ICopyright
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getICopyright()
		 * @generated
		 */
		EClass ICOPYRIGHT = eINSTANCE.getICopyright();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICOPYRIGHT__LOCATION = eINSTANCE.getICopyright_Location();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICOPYRIGHT__BODY = eINSTANCE.getICopyright_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository <em>IFile Artifact Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIFileArtifactRepository()
		 * @generated
		 */
		EClass IFILE_ARTIFACT_REPOSITORY = eINSTANCE.getIFileArtifactRepository();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit <em>IInstallable Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnit()
		 * @generated
		 */
		EClass IINSTALLABLE_UNIT = eINSTANCE.getIInstallableUnit();

		/**
		 * The meta object literal for the '<em><b>Artifacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__ARTIFACTS = eINSTANCE.getIInstallableUnit_Artifacts();

		/**
		 * The meta object literal for the '<em><b>Copyright</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__COPYRIGHT = eINSTANCE.getIInstallableUnit_Copyright();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IINSTALLABLE_UNIT__FILTER = eINSTANCE.getIInstallableUnit_Filter();

		/**
		 * The meta object literal for the '<em><b>Fragments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__FRAGMENTS = eINSTANCE.getIInstallableUnit_Fragments();

		/**
		 * The meta object literal for the '<em><b>Licenses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__LICENSES = eINSTANCE.getIInstallableUnit_Licenses();

		/**
		 * The meta object literal for the '<em><b>Meta Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__META_REQUIREMENTS = eINSTANCE.getIInstallableUnit_MetaRequirements();

		/**
		 * The meta object literal for the '<em><b>Provided Capabilities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__PROVIDED_CAPABILITIES = eINSTANCE.getIInstallableUnit_ProvidedCapabilities();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__REQUIREMENTS = eINSTANCE.getIInstallableUnit_Requirements();

		/**
		 * The meta object literal for the '<em><b>Touchpoint Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__TOUCHPOINT_DATA = eINSTANCE.getIInstallableUnit_TouchpointData();

		/**
		 * The meta object literal for the '<em><b>Touchpoint Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__TOUCHPOINT_TYPE = eINSTANCE.getIInstallableUnit_TouchpointType();

		/**
		 * The meta object literal for the '<em><b>Update Descriptor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT__UPDATE_DESCRIPTOR = eINSTANCE.getIInstallableUnit_UpdateDescriptor();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IINSTALLABLE_UNIT__RESOLVED = eINSTANCE.getIInstallableUnit_Resolved();

		/**
		 * The meta object literal for the '<em><b>Singleton</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IINSTALLABLE_UNIT__SINGLETON = eINSTANCE.getIInstallableUnit_Singleton();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitFragment <em>IInstallable Unit Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitFragment
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnitFragment()
		 * @generated
		 */
		EClass IINSTALLABLE_UNIT_FRAGMENT = eINSTANCE.getIInstallableUnitFragment();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitPatch <em>IInstallable Unit Patch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitPatch
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnitPatch()
		 * @generated
		 */
		EClass IINSTALLABLE_UNIT_PATCH = eINSTANCE.getIInstallableUnitPatch();

		/**
		 * The meta object literal for the '<em><b>Requirements Change</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE = eINSTANCE
				.getIInstallableUnitPatch_RequirementsChange();

		/**
		 * The meta object literal for the '<em><b>Life Cycle</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT_PATCH__LIFE_CYCLE = eINSTANCE.getIInstallableUnitPatch_LifeCycle();

		/**
		 * The meta object literal for the '<em><b>Applies To</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IINSTALLABLE_UNIT_PATCH__APPLIES_TO = eINSTANCE.getIInstallableUnitPatch_AppliesTo();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.ILicense <em>ILicense</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.ILicense
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getILicense()
		 * @generated
		 */
		EClass ILICENSE = eINSTANCE.getILicense();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILICENSE__LOCATION = eINSTANCE.getILicense_Location();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILICENSE__BODY = eINSTANCE.getILicense_Body();

		/**
		 * The meta object literal for the '<em><b>UUID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILICENSE__UUID = eINSTANCE.getILicense_UUID();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.IProvidedCapability <em>IProvided Capability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.IProvidedCapability
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProvidedCapability()
		 * @generated
		 */
		EClass IPROVIDED_CAPABILITY = eINSTANCE.getIProvidedCapability();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROVIDED_CAPABILITY__NAME = eINSTANCE.getIProvidedCapability_Name();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROVIDED_CAPABILITY__NAMESPACE = eINSTANCE.getIProvidedCapability_Namespace();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROVIDED_CAPABILITY__VERSION = eINSTANCE.getIProvidedCapability_Version();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.IRequirement <em>IRequirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.IRequirement
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRequirement()
		 * @generated
		 */
		EClass IREQUIREMENT = eINSTANCE.getIRequirement();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREQUIREMENT__FILTER = eINSTANCE.getIRequirement_Filter();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREQUIREMENT__MAX = eINSTANCE.getIRequirement_Max();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREQUIREMENT__MIN = eINSTANCE.getIRequirement_Min();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREQUIREMENT__MATCHES = eINSTANCE.getIRequirement_Matches();

		/**
		 * The meta object literal for the '<em><b>Greedy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREQUIREMENT__GREEDY = eINSTANCE.getIRequirement_Greedy();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREQUIREMENT__DESCRIPTION = eINSTANCE.getIRequirement_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.internal.p2.metadata.IRequiredCapability <em>IRequired Capability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.internal.p2.metadata.IRequiredCapability
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRequiredCapability()
		 * @generated
		 */
		EClass IREQUIRED_CAPABILITY = eINSTANCE.getIRequiredCapability();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREQUIRED_CAPABILITY__NAME = eINSTANCE.getIRequiredCapability_Name();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREQUIRED_CAPABILITY__NAMESPACE = eINSTANCE.getIRequiredCapability_Namespace();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREQUIRED_CAPABILITY__RANGE = eINSTANCE.getIRequiredCapability_Range();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.IRequirementChange <em>IRequirement Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.IRequirementChange
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRequirementChange()
		 * @generated
		 */
		EClass IREQUIREMENT_CHANGE = eINSTANCE.getIRequirementChange();

		/**
		 * The meta object literal for the '<em><b>Apply On</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IREQUIREMENT_CHANGE__APPLY_ON = eINSTANCE.getIRequirementChange_ApplyOn();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IREQUIREMENT_CHANGE__NEW_VALUE = eINSTANCE.getIRequirementChange_NewValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.ITouchpointData <em>ITouchpoint Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.ITouchpointData
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getITouchpointData()
		 * @generated
		 */
		EClass ITOUCHPOINT_DATA = eINSTANCE.getITouchpointData();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.ITouchpointInstruction <em>ITouchpoint Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.ITouchpointInstruction
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getITouchpointInstruction()
		 * @generated
		 */
		EClass ITOUCHPOINT_INSTRUCTION = eINSTANCE.getITouchpointInstruction();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITOUCHPOINT_INSTRUCTION__BODY = eINSTANCE.getITouchpointInstruction_Body();

		/**
		 * The meta object literal for the '<em><b>Import Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITOUCHPOINT_INSTRUCTION__IMPORT_ATTRIBUTE = eINSTANCE.getITouchpointInstruction_ImportAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.ITouchpointType <em>ITouchpoint Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.ITouchpointType
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getITouchpointType()
		 * @generated
		 */
		EClass ITOUCHPOINT_TYPE = eINSTANCE.getITouchpointType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITOUCHPOINT_TYPE__ID = eINSTANCE.getITouchpointType_Id();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITOUCHPOINT_TYPE__VERSION = eINSTANCE.getITouchpointType_Version();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.IVersionedId <em>IVersioned Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.IVersionedId
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIVersionedId()
		 * @generated
		 */
		EClass IVERSIONED_ID = eINSTANCE.getIVersionedId();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IVERSIONED_ID__ID = eINSTANCE.getIVersionedId_Id();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IVERSIONED_ID__VERSION = eINSTANCE.getIVersionedId_Version();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.metadata.IUpdateDescriptor <em>IUpdate Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.IUpdateDescriptor
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIUpdateDescriptor()
		 * @generated
		 */
		EClass IUPDATE_DESCRIPTOR = eINSTANCE.getIUpdateDescriptor();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IUPDATE_DESCRIPTOR__DESCRIPTION = eINSTANCE.getIUpdateDescriptor_Description();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IUPDATE_DESCRIPTOR__SEVERITY = eINSTANCE.getIUpdateDescriptor_Severity();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IUPDATE_DESCRIPTOR__LOCATION = eINSTANCE.getIUpdateDescriptor_Location();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactKeyImpl <em>Artifact Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.ArtifactKeyImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getArtifactKey()
		 * @generated
		 */
		EClass ARTIFACT_KEY = eINSTANCE.getArtifactKey();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactDescriptorImpl <em>Artifact Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.ArtifactDescriptorImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getArtifactDescriptor()
		 * @generated
		 */
		EClass ARTIFACT_DESCRIPTOR = eINSTANCE.getArtifactDescriptor();

		/**
		 * The meta object literal for the '<em><b>Property Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT_DESCRIPTOR__PROPERTY_MAP = eINSTANCE.getArtifactDescriptor_PropertyMap();

		/**
		 * The meta object literal for the '<em><b>Processing Step List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST = eINSTANCE.getArtifactDescriptor_ProcessingStepList();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactRepositoryImpl <em>Artifact Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.ArtifactRepositoryImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getArtifactRepository()
		 * @generated
		 */
		EClass ARTIFACT_REPOSITORY = eINSTANCE.getArtifactRepository();

		/**
		 * The meta object literal for the '<em><b>Artifact Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT_REPOSITORY__ARTIFACT_MAP = eINSTANCE.getArtifactRepository_ArtifactMap();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactsByKeyImpl <em>Artifacts By Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.ArtifactsByKeyImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getArtifactsByKey()
		 * @generated
		 */
		EClass ARTIFACTS_BY_KEY = eINSTANCE.getArtifactsByKey();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACTS_BY_KEY__KEY = eINSTANCE.getArtifactsByKey_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACTS_BY_KEY__VALUE = eINSTANCE.getArtifactsByKey_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.CopyrightImpl <em>Copyright</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.CopyrightImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getCopyright()
		 * @generated
		 */
		EClass COPYRIGHT = eINSTANCE.getCopyright();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl <em>Metadata Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getMetadataRepository()
		 * @generated
		 */
		EClass METADATA_REPOSITORY = eINSTANCE.getMetadataRepository();

		/**
		 * The meta object literal for the '<em><b>Installable Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METADATA_REPOSITORY__INSTALLABLE_UNITS = eINSTANCE.getMetadataRepository_InstallableUnits();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METADATA_REPOSITORY__REFERENCES = eINSTANCE.getMetadataRepository_References();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.ProcessingStepDescriptorImpl <em>Processing Step Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.ProcessingStepDescriptorImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getProcessingStepDescriptor()
		 * @generated
		 */
		EClass PROCESSING_STEP_DESCRIPTOR = eINSTANCE.getProcessingStepDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl <em>Installable Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getInstallableUnit()
		 * @generated
		 */
		EClass INSTALLABLE_UNIT = eINSTANCE.getInstallableUnit();

		/**
		 * The meta object literal for the '<em><b>Property Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTALLABLE_UNIT__PROPERTY_MAP = eINSTANCE.getInstallableUnit_PropertyMap();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitFragmentImpl <em>Installable Unit Fragment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.InstallableUnitFragmentImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getInstallableUnitFragment()
		 * @generated
		 */
		EClass INSTALLABLE_UNIT_FRAGMENT = eINSTANCE.getInstallableUnitFragment();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTALLABLE_UNIT_FRAGMENT__HOST = eINSTANCE.getInstallableUnitFragment_Host();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitPatchImpl <em>Installable Unit Patch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.InstallableUnitPatchImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getInstallableUnitPatch()
		 * @generated
		 */
		EClass INSTALLABLE_UNIT_PATCH = eINSTANCE.getInstallableUnitPatch();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.LicenseImpl <em>License</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.LicenseImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getLicense()
		 * @generated
		 */
		EClass LICENSE = eINSTANCE.getLicense();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.MappingRuleImpl <em>Mapping Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.MappingRuleImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getMappingRule()
		 * @generated
		 */
		EClass MAPPING_RULE = eINSTANCE.getMappingRule();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RULE__FILTER = eINSTANCE.getMappingRule_Filter();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RULE__OUTPUT = eINSTANCE.getMappingRule_Output();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.ProvidedCapabilityImpl <em>Provided Capability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.ProvidedCapabilityImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getProvidedCapability()
		 * @generated
		 */
		EClass PROVIDED_CAPABILITY = eINSTANCE.getProvidedCapability();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Property Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__PROPERTY_MAP = eINSTANCE.getRepository_PropertyMap();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.RequiredCapabilityImpl <em>Required Capability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.RequiredCapabilityImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRequiredCapability()
		 * @generated
		 */
		EClass REQUIRED_CAPABILITY = eINSTANCE.getRequiredCapability();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.RequirementImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.RequiredPropertiesMatchImpl <em>Required Properties Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.RequiredPropertiesMatchImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRequiredPropertiesMatch()
		 * @since 1.1
		 * @generated
		 */
		EClass REQUIRED_PROPERTIES_MATCH = eINSTANCE.getRequiredPropertiesMatch();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 1.1
		 * @generated
		 */
		EAttribute REQUIRED_PROPERTIES_MATCH__NAMESPACE = eINSTANCE.getRequiredPropertiesMatch_Namespace();

		/**
		 * The meta object literal for the '<em><b>Properties Match</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 1.1
		 * @generated
		 */
		EAttribute REQUIRED_PROPERTIES_MATCH__PROPERTIES_MATCH = eINSTANCE.getRequiredPropertiesMatch_PropertiesMatch();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.RequirementChangeImpl <em>Requirement Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.RequirementChangeImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRequirementChange()
		 * @generated
		 */
		EClass REQUIREMENT_CHANGE = eINSTANCE.getRequirementChange();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.SimpleArtifactRepositoryImpl <em>Simple Artifact Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.SimpleArtifactRepositoryImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getSimpleArtifactRepository()
		 * @generated
		 */
		EClass SIMPLE_ARTIFACT_REPOSITORY = eINSTANCE.getSimpleArtifactRepository();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_ARTIFACT_REPOSITORY__RULES = eINSTANCE.getSimpleArtifactRepository_Rules();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.SimpleArtifactDescriptorImpl <em>Simple Artifact Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.SimpleArtifactDescriptorImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getSimpleArtifactDescriptor()
		 * @generated
		 */
		EClass SIMPLE_ARTIFACT_DESCRIPTOR = eINSTANCE.getSimpleArtifactDescriptor();

		/**
		 * The meta object literal for the '<em><b>Repository Property Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_ARTIFACT_DESCRIPTOR__REPOSITORY_PROPERTY_MAP = eINSTANCE
				.getSimpleArtifactDescriptor_RepositoryPropertyMap();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.TouchpointDataImpl <em>Touchpoint Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.TouchpointDataImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getTouchpointData()
		 * @generated
		 */
		EClass TOUCHPOINT_DATA = eINSTANCE.getTouchpointData();

		/**
		 * The meta object literal for the '<em><b>Instruction Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOUCHPOINT_DATA__INSTRUCTION_MAP = eINSTANCE.getTouchpointData_InstructionMap();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.TouchpointInstructionImpl <em>Touchpoint Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.TouchpointInstructionImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getTouchpointInstruction()
		 * @generated
		 */
		EClass TOUCHPOINT_INSTRUCTION = eINSTANCE.getTouchpointInstruction();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.TouchpointTypeImpl <em>Touchpoint Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.TouchpointTypeImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getTouchpointType()
		 * @generated
		 */
		EClass TOUCHPOINT_TYPE = eINSTANCE.getTouchpointType();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.UpdateDescriptorImpl <em>Update Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.UpdateDescriptorImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getUpdateDescriptor()
		 * @generated
		 */
		EClass UPDATE_DESCRIPTOR = eINSTANCE.getUpdateDescriptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.PropertyImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__KEY = eINSTANCE.getProperty_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.InstructionMapImpl <em>Instruction Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.InstructionMapImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getInstructionMap()
		 * @generated
		 */
		EClass INSTRUCTION_MAP = eINSTANCE.getInstructionMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTRUCTION_MAP__KEY = eINSTANCE.getInstructionMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTRUCTION_MAP__VALUE = eINSTANCE.getInstructionMap_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.query.IQueryable <em>IQueryable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.query.IQueryable
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIQueryable()
		 * @generated
		 */
		EClass IQUERYABLE = eINSTANCE.getIQueryable();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.repository.metadata.IMetadataRepository <em>IMetadata Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.repository.metadata.IMetadataRepository
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIMetadataRepository()
		 * @generated
		 */
		EClass IMETADATA_REPOSITORY = eINSTANCE.getIMetadataRepository();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor <em>IProcessing Step Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProcessingStepDescriptor()
		 * @generated
		 */
		EClass IPROCESSING_STEP_DESCRIPTOR = eINSTANCE.getIProcessingStepDescriptor();

		/**
		 * The meta object literal for the '<em><b>Processor Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROCESSING_STEP_DESCRIPTOR__PROCESSOR_ID = eINSTANCE.getIProcessingStepDescriptor_ProcessorId();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROCESSING_STEP_DESCRIPTOR__DATA = eINSTANCE.getIProcessingStepDescriptor_Data();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPROCESSING_STEP_DESCRIPTOR__REQUIRED = eINSTANCE.getIProcessingStepDescriptor_Required();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.repository.IRepository <em>IRepository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.repository.IRepository
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRepository()
		 * @generated
		 */
		EClass IREPOSITORY = eINSTANCE.getIRepository();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY__LOCATION = eINSTANCE.getIRepository_Location();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY__NAME = eINSTANCE.getIRepository_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY__TYPE = eINSTANCE.getIRepository_Type();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY__VERSION = eINSTANCE.getIRepository_Version();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY__DESCRIPTION = eINSTANCE.getIRepository_Description();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY__PROVIDER = eINSTANCE.getIRepository_Provider();

		/**
		 * The meta object literal for the '<em><b>Modifiable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY__MODIFIABLE = eINSTANCE.getIRepository_Modifiable();

		/**
		 * The meta object literal for the '<em><b>Provisioning Agent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY__PROVISIONING_AGENT = eINSTANCE.getIRepository_ProvisioningAgent();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.repository.IRepositoryReference <em>IRepository Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.repository.IRepositoryReference
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRepositoryReference()
		 * @generated
		 */
		EClass IREPOSITORY_REFERENCE = eINSTANCE.getIRepositoryReference();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY_REFERENCE__LOCATION = eINSTANCE.getIRepositoryReference_Location();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY_REFERENCE__TYPE = eINSTANCE.getIRepositoryReference_Type();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY_REFERENCE__OPTIONS = eINSTANCE.getIRepositoryReference_Options();

		/**
		 * The meta object literal for the '<em><b>Nickname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IREPOSITORY_REFERENCE__NICKNAME = eINSTANCE.getIRepositoryReference_Nickname();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryReferenceImpl <em>Repository Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.RepositoryReferenceImpl
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRepositoryReference()
		 * @generated
		 */
		EClass REPOSITORY_REFERENCE = eINSTANCE.getRepositoryReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.core.runtime.IAdaptable <em>IAdaptable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IAdaptable
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIAdaptable()
		 * @generated
		 */
		EClass IADAPTABLE = eINSTANCE.getIAdaptable();

		/**
		 * The meta object literal for the '{@link org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor <em>IArtifact Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactDescriptor()
		 * @generated
		 */
		EClass IARTIFACT_DESCRIPTOR = eINSTANCE.getIArtifactDescriptor();

		/**
		 * The meta object literal for the '<em><b>Artifact Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IARTIFACT_DESCRIPTOR__ARTIFACT_KEY = eINSTANCE.getIArtifactDescriptor_ArtifactKey();

		/**
		 * The meta object literal for the '{@link java.lang.Comparable <em>Comparable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Comparable
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getComparable()
		 * @generated
		 */
		EClass COMPARABLE = eINSTANCE.getComparable();

		/**
		 * The meta object literal for the '<em>Version</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.Version
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getVersion()
		 * @generated
		 */
		EDataType VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em>Version Range</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.VersionRange
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getVersionRange()
		 * @generated
		 */
		EDataType VERSION_RANGE = eINSTANCE.getVersionRange();

		/**
		 * The meta object literal for the '<em>IInstallable Unit Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnitArray()
		 * @generated
		 */
		EDataType IINSTALLABLE_UNIT_ARRAY = eINSTANCE.getIInstallableUnitArray();

		/**
		 * The meta object literal for the '<em>Collection</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Collection
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getCollection()
		 * @generated
		 */
		EDataType COLLECTION = eINSTANCE.getCollection();

		/**
		 * The meta object literal for the '<em>IProvided Capability Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProvidedCapabilityArray()
		 * @generated
		 */
		EDataType IPROVIDED_CAPABILITY_ARRAY = eINSTANCE.getIProvidedCapabilityArray();

		/**
		 * The meta object literal for the '<em>IInstallable Unit Fragment Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnitFragmentArray()
		 * @generated
		 */
		EDataType IINSTALLABLE_UNIT_FRAGMENT_ARRAY = eINSTANCE.getIInstallableUnitFragmentArray();

		/**
		 * The meta object literal for the '<em>IArtifact Key Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactKeyArray()
		 * @generated
		 */
		EDataType IARTIFACT_KEY_ARRAY = eINSTANCE.getIArtifactKeyArray();

		/**
		 * The meta object literal for the '<em>IArtifact Request Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactRequestArray()
		 * @generated
		 */
		EDataType IARTIFACT_REQUEST_ARRAY = eINSTANCE.getIArtifactRequestArray();

		/**
		 * The meta object literal for the '<em>IFilter Expression</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.expression.IFilterExpression
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIFilterExpression()
		 * @since 1.1
		 * @generated
		 */
		EDataType IFILTER_EXPRESSION = eINSTANCE.getIFilterExpression();

		/**
		 * The meta object literal for the '<em>ITouchpoint Data Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getITouchpointDataArray()
		 * @generated
		 */
		EDataType ITOUCHPOINT_DATA_ARRAY = eINSTANCE.getITouchpointDataArray();

		/**
		 * The meta object literal for the '<em>IRequirement Array Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRequirementArrayArray()
		 * @generated
		 */
		EDataType IREQUIREMENT_ARRAY_ARRAY = eINSTANCE.getIRequirementArrayArray();

		/**
		 * The meta object literal for the '<em>IPool</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.core.IPool
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIPool()
		 * @generated
		 */
		EDataType IPOOL = eINSTANCE.getIPool();

		/**
		 * The meta object literal for the '<em>IProcessing Descriptor Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProcessingDescriptorArray()
		 * @generated
		 */
		EDataType IPROCESSING_DESCRIPTOR_ARRAY = eINSTANCE.getIProcessingDescriptorArray();

		/**
		 * The meta object literal for the '<em>String Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getStringArray()
		 * @generated
		 */
		EDataType STRING_ARRAY = eINSTANCE.getStringArray();

		/**
		 * The meta object literal for the '<em>Untyped Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getUntypedMap()
		 * @generated
		 */
		EDataType UNTYPED_MAP = eINSTANCE.getUntypedMap();

		/**
		 * The meta object literal for the '<em>Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Map
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getMap()
		 * @generated
		 */
		EDataType MAP = eINSTANCE.getMap();

		/**
		 * The meta object literal for the '<em>Output Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.OutputStream
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getOutputStream()
		 * @generated
		 */
		EDataType OUTPUT_STREAM = eINSTANCE.getOutputStream();

		/**
		 * The meta object literal for the '<em>ILicense Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getILicenseArray()
		 * @generated
		 */
		EDataType ILICENSE_ARRAY = eINSTANCE.getILicenseArray();

		/**
		 * The meta object literal for the '<em>IQuery Result</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.query.IQueryResult
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIQueryResult()
		 * @generated
		 */
		EDataType IQUERY_RESULT = eINSTANCE.getIQueryResult();

		/**
		 * The meta object literal for the '<em>IQuery</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.query.IQuery
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIQuery()
		 * @generated
		 */
		EDataType IQUERY = eINSTANCE.getIQuery();

		/**
		 * The meta object literal for the '<em>Collector</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.query.Collector
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getCollector()
		 * @generated
		 */
		EDataType COLLECTOR = eINSTANCE.getCollector();

		/**
		 * The meta object literal for the '<em>File</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.File
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getFile()
		 * @generated
		 */
		EDataType FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em>Filter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.expression.IMatchExpression
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getFilter()
		 * @since 1.1
		 * @generated
		 */
		EDataType FILTER = eINSTANCE.getFilter();

		/**
		 * The meta object literal for the '<em>IArtifact Descriptor Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactDescriptorArray()
		 * @generated
		 */
		EDataType IARTIFACT_DESCRIPTOR_ARRAY = eINSTANCE.getIArtifactDescriptorArray();

		/**
		 * The meta object literal for the '<em>IProgress Monitor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IProgressMonitor
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProgressMonitor()
		 * @generated
		 */
		EDataType IPROGRESS_MONITOR = eINSTANCE.getIProgressMonitor();

		/**
		 * The meta object literal for the '<em>IRunnable With Progress</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.repository.IRunnableWithProgress
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRunnableWithProgress()
		 * @generated
		 */
		EDataType IRUNNABLE_WITH_PROGRESS = eINSTANCE.getIRunnableWithProgress();

		/**
		 * The meta object literal for the '<em>IStatus</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.IStatus
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIStatus()
		 * @generated
		 */
		EDataType ISTATUS = eINSTANCE.getIStatus();

		/**
		 * The meta object literal for the '<em>IMatch Expression</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.metadata.expression.IMatchExpression
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIMatchExpression()
		 * @generated
		 */
		EDataType IMATCH_EXPRESSION = eINSTANCE.getIMatchExpression();

		/**
		 * The meta object literal for the '<em>IProvisioning Agent</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.equinox.p2.core.IProvisioningAgent
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProvisioningAgent()
		 * @generated
		 */
		EDataType IPROVISIONING_AGENT = eINSTANCE.getIProvisioningAgent();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.net.URI
		 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "p2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/cbi/p2repo/2010/p2/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "p2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	P2Package eINSTANCE = org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.IArtifactKey <em>IArtifact Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.IArtifactKey
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactKey()
	 * @generated
	 */
	int IARTIFACT_KEY = 8;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_KEY__CLASSIFIER = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_KEY__ID = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_KEY__VERSION = 2;

	/**
	 * The number of structural features of the '<em>IArtifact Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_KEY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.ICopyright <em>ICopyright</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.ICopyright
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getICopyright()
	 * @generated
	 */
	int ICOPYRIGHT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.IVersionedId <em>IVersioned Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.IVersionedId
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIVersionedId()
	 * @generated
	 */
	int IVERSIONED_ID = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit <em>IInstallable Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnit()
	 * @generated
	 */
	int IINSTALLABLE_UNIT = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitFragment <em>IInstallable Unit Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitFragment
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnitFragment()
	 * @generated
	 */
	int IINSTALLABLE_UNIT_FRAGMENT = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitPatch <em>IInstallable Unit Patch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitPatch
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnitPatch()
	 * @generated
	 */
	int IINSTALLABLE_UNIT_PATCH = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.ILicense <em>ILicense</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.ILicense
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getILicense()
	 * @generated
	 */
	int ILICENSE = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.IProvidedCapability <em>IProvided Capability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.IProvidedCapability
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProvidedCapability()
	 * @generated
	 */
	int IPROVIDED_CAPABILITY = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.IRequirement <em>IRequirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.IRequirement
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRequirement()
	 * @generated
	 */
	int IREQUIREMENT = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.internal.p2.metadata.IRequiredCapability <em>IRequired Capability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.internal.p2.metadata.IRequiredCapability
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRequiredCapability()
	 * @generated
	 */
	int IREQUIRED_CAPABILITY = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.IRequirementChange <em>IRequirement Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.IRequirementChange
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRequirementChange()
	 * @generated
	 */
	int IREQUIREMENT_CHANGE = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.ITouchpointData <em>ITouchpoint Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointData
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getITouchpointData()
	 * @generated
	 */
	int ITOUCHPOINT_DATA = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.ITouchpointInstruction <em>ITouchpoint Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointInstruction
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getITouchpointInstruction()
	 * @generated
	 */
	int ITOUCHPOINT_INSTRUCTION = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.ITouchpointType <em>ITouchpoint Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointType
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getITouchpointType()
	 * @generated
	 */
	int ITOUCHPOINT_TYPE = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.metadata.IUpdateDescriptor <em>IUpdate Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.IUpdateDescriptor
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIUpdateDescriptor()
	 * @generated
	 */
	int IUPDATE_DESCRIPTOR = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactKeyImpl <em>Artifact Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.ArtifactKeyImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getArtifactKey()
	 * @generated
	 */
	int ARTIFACT_KEY = 0;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_KEY__CLASSIFIER = IARTIFACT_KEY__CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_KEY__ID = IARTIFACT_KEY__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_KEY__VERSION = IARTIFACT_KEY__VERSION;

	/**
	 * The number of structural features of the '<em>Artifact Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_KEY_FEATURE_COUNT = IARTIFACT_KEY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor <em>IArtifact Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactDescriptor()
	 * @generated
	 */
	int IARTIFACT_DESCRIPTOR = 7;

	/**
	 * The feature id for the '<em><b>Artifact Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_DESCRIPTOR__ARTIFACT_KEY = 0;

	/**
	 * The number of structural features of the '<em>IArtifact Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_DESCRIPTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactDescriptorImpl <em>Artifact Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.ArtifactDescriptorImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getArtifactDescriptor()
	 * @generated
	 */
	int ARTIFACT_DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Artifact Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_DESCRIPTOR__ARTIFACT_KEY = IARTIFACT_DESCRIPTOR__ARTIFACT_KEY;

	/**
	 * The feature id for the '<em><b>Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_DESCRIPTOR__PROPERTY_MAP = IARTIFACT_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processing Step List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST = IARTIFACT_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Artifact Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_DESCRIPTOR_FEATURE_COUNT = IARTIFACT_DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.CopyrightImpl <em>Copyright</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.CopyrightImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getCopyright()
	 * @generated
	 */
	int COPYRIGHT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.core.runtime.IAdaptable <em>IAdaptable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IAdaptable
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIAdaptable()
	 * @generated
	 */
	int IADAPTABLE = 6;

	/**
	 * The number of structural features of the '<em>IAdaptable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IADAPTABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.repository.IRepository <em>IRepository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.repository.IRepository
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRepository()
	 * @generated
	 */
	int IREPOSITORY = 24;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY__LOCATION = IADAPTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY__NAME = IADAPTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY__TYPE = IADAPTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY__VERSION = IADAPTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY__DESCRIPTION = IADAPTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY__PROVIDER = IADAPTABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY__MODIFIABLE = IADAPTABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Provisioning Agent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY__PROVISIONING_AGENT = IADAPTABLE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>IRepository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY_FEATURE_COUNT = IADAPTABLE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.repository.artifact.IArtifactRepository <em>IArtifact Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.repository.artifact.IArtifactRepository
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactRepository()
	 * @generated
	 */
	int IARTIFACT_REPOSITORY = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactRepositoryImpl <em>Artifact Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.ArtifactRepositoryImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getArtifactRepository()
	 * @generated
	 */
	int ARTIFACT_REPOSITORY = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.repository.metadata.IMetadataRepository <em>IMetadata Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.repository.metadata.IMetadataRepository
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIMetadataRepository()
	 * @generated
	 */
	int IMETADATA_REPOSITORY = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor <em>IProcessing Step Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProcessingStepDescriptor()
	 * @generated
	 */
	int IPROCESSING_STEP_DESCRIPTOR = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl <em>Metadata Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getMetadataRepository()
	 * @generated
	 */
	int METADATA_REPOSITORY = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.ProcessingStepDescriptorImpl <em>Processing Step Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.ProcessingStepDescriptorImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getProcessingStepDescriptor()
	 * @generated
	 */
	int PROCESSING_STEP_DESCRIPTOR = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl <em>Installable Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getInstallableUnit()
	 * @generated
	 */
	int INSTALLABLE_UNIT = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitFragmentImpl <em>Installable Unit Fragment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.InstallableUnitFragmentImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getInstallableUnitFragment()
	 * @generated
	 */
	int INSTALLABLE_UNIT_FRAGMENT = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitPatchImpl <em>Installable Unit Patch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.InstallableUnitPatchImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getInstallableUnitPatch()
	 * @generated
	 */
	int INSTALLABLE_UNIT_PATCH = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.LicenseImpl <em>License</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.LicenseImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getLicense()
	 * @generated
	 */
	int LICENSE = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.ProvidedCapabilityImpl <em>Provided Capability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.ProvidedCapabilityImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getProvidedCapability()
	 * @generated
	 */
	int PROVIDED_CAPABILITY = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.RequirementImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 43;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.RequiredCapabilityImpl <em>Required Capability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.RequiredCapabilityImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRequiredCapability()
	 * @generated
	 */
	int REQUIRED_CAPABILITY = 42;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.RequirementChangeImpl <em>Requirement Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.RequirementChangeImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRequirementChange()
	 * @generated
	 */
	int REQUIREMENT_CHANGE = 45;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.TouchpointDataImpl <em>Touchpoint Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.TouchpointDataImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getTouchpointData()
	 * @generated
	 */
	int TOUCHPOINT_DATA = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.TouchpointInstructionImpl <em>Touchpoint Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.TouchpointInstructionImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getTouchpointInstruction()
	 * @generated
	 */
	int TOUCHPOINT_INSTRUCTION = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.TouchpointTypeImpl <em>Touchpoint Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.TouchpointTypeImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getTouchpointType()
	 * @generated
	 */
	int TOUCHPOINT_TYPE = 50;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.UpdateDescriptorImpl <em>Update Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.UpdateDescriptorImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getUpdateDescriptor()
	 * @generated
	 */
	int UPDATE_DESCRIPTOR = 51;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.PropertyImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.InstructionMapImpl <em>Instruction Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.InstructionMapImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getInstructionMap()
	 * @generated
	 */
	int INSTRUCTION_MAP = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.query.IQueryable <em>IQueryable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.query.IQueryable
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIQueryable()
	 * @generated
	 */
	int IQUERYABLE = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.repository.IRepositoryReference <em>IRepository Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.repository.IRepositoryReference
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRepositoryReference()
	 * @generated
	 */
	int IREPOSITORY_REFERENCE = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryReferenceImpl <em>Repository Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.RepositoryReferenceImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRepositoryReference()
	 * @generated
	 */
	int REPOSITORY_REFERENCE = 41;

	/**
	 * The meta object id for the '{@link java.lang.Comparable <em>Comparable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Comparable
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getComparable()
	 * @generated
	 */
	int COMPARABLE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 40;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__LOCATION = IREPOSITORY__LOCATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__NAME = IREPOSITORY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__TYPE = IREPOSITORY__TYPE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__VERSION = IREPOSITORY__VERSION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__DESCRIPTION = IREPOSITORY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__PROVIDER = IREPOSITORY__PROVIDER;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__MODIFIABLE = IREPOSITORY__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Provisioning Agent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__PROVISIONING_AGENT = IREPOSITORY__PROVISIONING_AGENT;

	/**
	 * The feature id for the '<em><b>Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__PROPERTY_MAP = IREPOSITORY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = IREPOSITORY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__LOCATION = REPOSITORY__LOCATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__NAME = REPOSITORY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__TYPE = REPOSITORY__TYPE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__VERSION = REPOSITORY__VERSION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__DESCRIPTION = REPOSITORY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__PROVIDER = REPOSITORY__PROVIDER;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__MODIFIABLE = REPOSITORY__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Provisioning Agent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__PROVISIONING_AGENT = REPOSITORY__PROVISIONING_AGENT;

	/**
	 * The feature id for the '<em><b>Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__PROPERTY_MAP = REPOSITORY__PROPERTY_MAP;

	/**
	 * The feature id for the '<em><b>Artifact Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY__ARTIFACT_MAP = REPOSITORY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Artifact Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_REPOSITORY_FEATURE_COUNT = REPOSITORY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactsByKeyImpl <em>Artifacts By Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.ArtifactsByKeyImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getArtifactsByKey()
	 * @generated
	 */
	int ARTIFACTS_BY_KEY = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACTS_BY_KEY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACTS_BY_KEY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Artifacts By Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACTS_BY_KEY_FEATURE_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Comparable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARABLE_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICOPYRIGHT__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICOPYRIGHT__BODY = 1;

	/**
	 * The number of structural features of the '<em>ICopyright</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICOPYRIGHT_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPYRIGHT__LOCATION = ICOPYRIGHT__LOCATION;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPYRIGHT__BODY = ICOPYRIGHT__BODY;

	/**
	 * The number of structural features of the '<em>Copyright</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPYRIGHT_FEATURE_COUNT = ICOPYRIGHT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_REPOSITORY__LOCATION = IREPOSITORY__LOCATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_REPOSITORY__NAME = IREPOSITORY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_REPOSITORY__TYPE = IREPOSITORY__TYPE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_REPOSITORY__VERSION = IREPOSITORY__VERSION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_REPOSITORY__DESCRIPTION = IREPOSITORY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_REPOSITORY__PROVIDER = IREPOSITORY__PROVIDER;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_REPOSITORY__MODIFIABLE = IREPOSITORY__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Provisioning Agent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_REPOSITORY__PROVISIONING_AGENT = IREPOSITORY__PROVISIONING_AGENT;

	/**
	 * The number of structural features of the '<em>IArtifact Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IARTIFACT_REPOSITORY_FEATURE_COUNT = IREPOSITORY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository <em>IFile Artifact Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIFileArtifactRepository()
	 * @generated
	 */
	int IFILE_ARTIFACT_REPOSITORY = 11;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILE_ARTIFACT_REPOSITORY__LOCATION = IARTIFACT_REPOSITORY__LOCATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILE_ARTIFACT_REPOSITORY__NAME = IARTIFACT_REPOSITORY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILE_ARTIFACT_REPOSITORY__TYPE = IARTIFACT_REPOSITORY__TYPE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILE_ARTIFACT_REPOSITORY__VERSION = IARTIFACT_REPOSITORY__VERSION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILE_ARTIFACT_REPOSITORY__DESCRIPTION = IARTIFACT_REPOSITORY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILE_ARTIFACT_REPOSITORY__PROVIDER = IARTIFACT_REPOSITORY__PROVIDER;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILE_ARTIFACT_REPOSITORY__MODIFIABLE = IARTIFACT_REPOSITORY__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Provisioning Agent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILE_ARTIFACT_REPOSITORY__PROVISIONING_AGENT = IARTIFACT_REPOSITORY__PROVISIONING_AGENT;

	/**
	 * The number of structural features of the '<em>IFile Artifact Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IFILE_ARTIFACT_REPOSITORY_FEATURE_COUNT = IARTIFACT_REPOSITORY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVERSIONED_ID__ID = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVERSIONED_ID__VERSION = 1;

	/**
	 * The number of structural features of the '<em>IVersioned Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IVERSIONED_ID_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__ID = IVERSIONED_ID__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__VERSION = IVERSIONED_ID__VERSION;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__ARTIFACTS = IVERSIONED_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__COPYRIGHT = IVERSIONED_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__FILTER = IVERSIONED_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__FRAGMENTS = IVERSIONED_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Licenses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__LICENSES = IVERSIONED_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Meta Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__META_REQUIREMENTS = IVERSIONED_ID_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Provided Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__PROVIDED_CAPABILITIES = IVERSIONED_ID_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__REQUIREMENTS = IVERSIONED_ID_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Touchpoint Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__TOUCHPOINT_DATA = IVERSIONED_ID_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Touchpoint Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__TOUCHPOINT_TYPE = IVERSIONED_ID_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Update Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__UPDATE_DESCRIPTOR = IVERSIONED_ID_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__RESOLVED = IVERSIONED_ID_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT__SINGLETON = IVERSIONED_ID_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>IInstallable Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FEATURE_COUNT = IVERSIONED_ID_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__ID = IINSTALLABLE_UNIT__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__VERSION = IINSTALLABLE_UNIT__VERSION;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__ARTIFACTS = IINSTALLABLE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__COPYRIGHT = IINSTALLABLE_UNIT__COPYRIGHT;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__FILTER = IINSTALLABLE_UNIT__FILTER;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__FRAGMENTS = IINSTALLABLE_UNIT__FRAGMENTS;

	/**
	 * The feature id for the '<em><b>Licenses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__LICENSES = IINSTALLABLE_UNIT__LICENSES;

	/**
	 * The feature id for the '<em><b>Meta Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__META_REQUIREMENTS = IINSTALLABLE_UNIT__META_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Provided Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__PROVIDED_CAPABILITIES = IINSTALLABLE_UNIT__PROVIDED_CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__REQUIREMENTS = IINSTALLABLE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Touchpoint Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__TOUCHPOINT_DATA = IINSTALLABLE_UNIT__TOUCHPOINT_DATA;

	/**
	 * The feature id for the '<em><b>Touchpoint Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__TOUCHPOINT_TYPE = IINSTALLABLE_UNIT__TOUCHPOINT_TYPE;

	/**
	 * The feature id for the '<em><b>Update Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__UPDATE_DESCRIPTOR = IINSTALLABLE_UNIT__UPDATE_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__RESOLVED = IINSTALLABLE_UNIT__RESOLVED;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT__SINGLETON = IINSTALLABLE_UNIT__SINGLETON;

	/**
	 * The number of structural features of the '<em>IInstallable Unit Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_FRAGMENT_FEATURE_COUNT = IINSTALLABLE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__ID = IINSTALLABLE_UNIT__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__VERSION = IINSTALLABLE_UNIT__VERSION;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__ARTIFACTS = IINSTALLABLE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__COPYRIGHT = IINSTALLABLE_UNIT__COPYRIGHT;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__FILTER = IINSTALLABLE_UNIT__FILTER;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__FRAGMENTS = IINSTALLABLE_UNIT__FRAGMENTS;

	/**
	 * The feature id for the '<em><b>Licenses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__LICENSES = IINSTALLABLE_UNIT__LICENSES;

	/**
	 * The feature id for the '<em><b>Meta Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__META_REQUIREMENTS = IINSTALLABLE_UNIT__META_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Provided Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__PROVIDED_CAPABILITIES = IINSTALLABLE_UNIT__PROVIDED_CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__REQUIREMENTS = IINSTALLABLE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Touchpoint Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__TOUCHPOINT_DATA = IINSTALLABLE_UNIT__TOUCHPOINT_DATA;

	/**
	 * The feature id for the '<em><b>Touchpoint Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__TOUCHPOINT_TYPE = IINSTALLABLE_UNIT__TOUCHPOINT_TYPE;

	/**
	 * The feature id for the '<em><b>Update Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__UPDATE_DESCRIPTOR = IINSTALLABLE_UNIT__UPDATE_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__RESOLVED = IINSTALLABLE_UNIT__RESOLVED;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__SINGLETON = IINSTALLABLE_UNIT__SINGLETON;

	/**
	 * The feature id for the '<em><b>Requirements Change</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE = IINSTALLABLE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Life Cycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__LIFE_CYCLE = IINSTALLABLE_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Applies To</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH__APPLIES_TO = IINSTALLABLE_UNIT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>IInstallable Unit Patch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IINSTALLABLE_UNIT_PATCH_FEATURE_COUNT = IINSTALLABLE_UNIT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILICENSE__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILICENSE__BODY = 1;

	/**
	 * The feature id for the '<em><b>UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILICENSE__UUID = 2;

	/**
	 * The number of structural features of the '<em>ILicense</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILICENSE_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__ID = IINSTALLABLE_UNIT__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__VERSION = IINSTALLABLE_UNIT__VERSION;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__ARTIFACTS = IINSTALLABLE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__COPYRIGHT = IINSTALLABLE_UNIT__COPYRIGHT;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__FILTER = IINSTALLABLE_UNIT__FILTER;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__FRAGMENTS = IINSTALLABLE_UNIT__FRAGMENTS;

	/**
	 * The feature id for the '<em><b>Licenses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__LICENSES = IINSTALLABLE_UNIT__LICENSES;

	/**
	 * The feature id for the '<em><b>Meta Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__META_REQUIREMENTS = IINSTALLABLE_UNIT__META_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Provided Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__PROVIDED_CAPABILITIES = IINSTALLABLE_UNIT__PROVIDED_CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__REQUIREMENTS = IINSTALLABLE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Touchpoint Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__TOUCHPOINT_DATA = IINSTALLABLE_UNIT__TOUCHPOINT_DATA;

	/**
	 * The feature id for the '<em><b>Touchpoint Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__TOUCHPOINT_TYPE = IINSTALLABLE_UNIT__TOUCHPOINT_TYPE;

	/**
	 * The feature id for the '<em><b>Update Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__UPDATE_DESCRIPTOR = IINSTALLABLE_UNIT__UPDATE_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__RESOLVED = IINSTALLABLE_UNIT__RESOLVED;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__SINGLETON = IINSTALLABLE_UNIT__SINGLETON;

	/**
	 * The feature id for the '<em><b>Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT__PROPERTY_MAP = IINSTALLABLE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Installable Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FEATURE_COUNT = IINSTALLABLE_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__ID = INSTALLABLE_UNIT__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__VERSION = INSTALLABLE_UNIT__VERSION;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__ARTIFACTS = INSTALLABLE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__COPYRIGHT = INSTALLABLE_UNIT__COPYRIGHT;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__FILTER = INSTALLABLE_UNIT__FILTER;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__FRAGMENTS = INSTALLABLE_UNIT__FRAGMENTS;

	/**
	 * The feature id for the '<em><b>Licenses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__LICENSES = INSTALLABLE_UNIT__LICENSES;

	/**
	 * The feature id for the '<em><b>Meta Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__META_REQUIREMENTS = INSTALLABLE_UNIT__META_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Provided Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__PROVIDED_CAPABILITIES = INSTALLABLE_UNIT__PROVIDED_CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__REQUIREMENTS = INSTALLABLE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Touchpoint Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__TOUCHPOINT_DATA = INSTALLABLE_UNIT__TOUCHPOINT_DATA;

	/**
	 * The feature id for the '<em><b>Touchpoint Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__TOUCHPOINT_TYPE = INSTALLABLE_UNIT__TOUCHPOINT_TYPE;

	/**
	 * The feature id for the '<em><b>Update Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__UPDATE_DESCRIPTOR = INSTALLABLE_UNIT__UPDATE_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__RESOLVED = INSTALLABLE_UNIT__RESOLVED;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__SINGLETON = INSTALLABLE_UNIT__SINGLETON;

	/**
	 * The feature id for the '<em><b>Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__PROPERTY_MAP = INSTALLABLE_UNIT__PROPERTY_MAP;

	/**
	 * The feature id for the '<em><b>Host</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT__HOST = INSTALLABLE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Installable Unit Fragment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_FRAGMENT_FEATURE_COUNT = INSTALLABLE_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__ID = INSTALLABLE_UNIT__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__VERSION = INSTALLABLE_UNIT__VERSION;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__ARTIFACTS = INSTALLABLE_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Copyright</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__COPYRIGHT = INSTALLABLE_UNIT__COPYRIGHT;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__FILTER = INSTALLABLE_UNIT__FILTER;

	/**
	 * The feature id for the '<em><b>Fragments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__FRAGMENTS = INSTALLABLE_UNIT__FRAGMENTS;

	/**
	 * The feature id for the '<em><b>Licenses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__LICENSES = INSTALLABLE_UNIT__LICENSES;

	/**
	 * The feature id for the '<em><b>Meta Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__META_REQUIREMENTS = INSTALLABLE_UNIT__META_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Provided Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__PROVIDED_CAPABILITIES = INSTALLABLE_UNIT__PROVIDED_CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__REQUIREMENTS = INSTALLABLE_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Touchpoint Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__TOUCHPOINT_DATA = INSTALLABLE_UNIT__TOUCHPOINT_DATA;

	/**
	 * The feature id for the '<em><b>Touchpoint Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__TOUCHPOINT_TYPE = INSTALLABLE_UNIT__TOUCHPOINT_TYPE;

	/**
	 * The feature id for the '<em><b>Update Descriptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__UPDATE_DESCRIPTOR = INSTALLABLE_UNIT__UPDATE_DESCRIPTOR;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__RESOLVED = INSTALLABLE_UNIT__RESOLVED;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__SINGLETON = INSTALLABLE_UNIT__SINGLETON;

	/**
	 * The feature id for the '<em><b>Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__PROPERTY_MAP = INSTALLABLE_UNIT__PROPERTY_MAP;

	/**
	 * The feature id for the '<em><b>Requirements Change</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE = INSTALLABLE_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Life Cycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__LIFE_CYCLE = INSTALLABLE_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Applies To</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH__APPLIES_TO = INSTALLABLE_UNIT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Installable Unit Patch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_PATCH_FEATURE_COUNT = INSTALLABLE_UNIT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Instruction Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_MAP_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMETADATA_REPOSITORY__LOCATION = IREPOSITORY__LOCATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMETADATA_REPOSITORY__NAME = IREPOSITORY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMETADATA_REPOSITORY__TYPE = IREPOSITORY__TYPE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMETADATA_REPOSITORY__VERSION = IREPOSITORY__VERSION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMETADATA_REPOSITORY__DESCRIPTION = IREPOSITORY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMETADATA_REPOSITORY__PROVIDER = IREPOSITORY__PROVIDER;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMETADATA_REPOSITORY__MODIFIABLE = IREPOSITORY__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Provisioning Agent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMETADATA_REPOSITORY__PROVISIONING_AGENT = IREPOSITORY__PROVISIONING_AGENT;

	/**
	 * The number of structural features of the '<em>IMetadata Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMETADATA_REPOSITORY_FEATURE_COUNT = IREPOSITORY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESSING_STEP_DESCRIPTOR__PROCESSOR_ID = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESSING_STEP_DESCRIPTOR__DATA = 1;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESSING_STEP_DESCRIPTOR__REQUIRED = 2;

	/**
	 * The number of structural features of the '<em>IProcessing Step Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROCESSING_STEP_DESCRIPTOR_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROVIDED_CAPABILITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROVIDED_CAPABILITY__NAMESPACE = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROVIDED_CAPABILITY__VERSION = 2;

	/**
	 * The number of structural features of the '<em>IProvided Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPROVIDED_CAPABILITY_FEATURE_COUNT = 3;

	/**
	 * The number of structural features of the '<em>IQueryable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IQUERYABLE_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY_REFERENCE__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY_REFERENCE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY_REFERENCE__OPTIONS = 2;

	/**
	 * The feature id for the '<em><b>Nickname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY_REFERENCE__NICKNAME = 3;

	/**
	 * The number of structural features of the '<em>IRepository Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREPOSITORY_REFERENCE_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__FILTER = 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__MAX = 1;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__MIN = 2;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__MATCHES = 3;

	/**
	 * The feature id for the '<em><b>Greedy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__GREEDY = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__DESCRIPTION = 5;

	/**
	 * The number of structural features of the '<em>IRequirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT_FEATURE_COUNT = 6;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY__FILTER = IREQUIREMENT__FILTER;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY__MAX = IREQUIREMENT__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY__MIN = IREQUIREMENT__MIN;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY__MATCHES = IREQUIREMENT__MATCHES;

	/**
	 * The feature id for the '<em><b>Greedy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY__GREEDY = IREQUIREMENT__GREEDY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY__DESCRIPTION = IREQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY__NAME = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY__NAMESPACE = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY__RANGE = IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>IRequired Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIRED_CAPABILITY_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Apply On</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT_CHANGE__APPLY_ON = 0;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT_CHANGE__NEW_VALUE = 1;

	/**
	 * The number of structural features of the '<em>IRequirement Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT_CHANGE_FEATURE_COUNT = 2;

	/**
	 * The number of structural features of the '<em>ITouchpoint Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITOUCHPOINT_DATA_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITOUCHPOINT_INSTRUCTION__BODY = 0;

	/**
	 * The feature id for the '<em><b>Import Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITOUCHPOINT_INSTRUCTION__IMPORT_ATTRIBUTE = 1;

	/**
	 * The number of structural features of the '<em>ITouchpoint Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITOUCHPOINT_INSTRUCTION_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITOUCHPOINT_TYPE__ID = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITOUCHPOINT_TYPE__VERSION = 1;

	/**
	 * The number of structural features of the '<em>ITouchpoint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITOUCHPOINT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUPDATE_DESCRIPTOR__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUPDATE_DESCRIPTOR__SEVERITY = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUPDATE_DESCRIPTOR__LOCATION = 2;

	/**
	 * The number of structural features of the '<em>IUpdate Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IUPDATE_DESCRIPTOR_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__LOCATION = ILICENSE__LOCATION;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__BODY = ILICENSE__BODY;

	/**
	 * The feature id for the '<em><b>UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE__UUID = ILICENSE__UUID;

	/**
	 * The number of structural features of the '<em>License</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LICENSE_FEATURE_COUNT = ILICENSE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.MappingRuleImpl <em>Mapping Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.MappingRuleImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getMappingRule()
	 * @generated
	 */
	int MAPPING_RULE = 35;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE__FILTER = 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE__OUTPUT = 1;

	/**
	 * The number of structural features of the '<em>Mapping Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RULE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__LOCATION = REPOSITORY__LOCATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__NAME = REPOSITORY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__TYPE = REPOSITORY__TYPE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__VERSION = REPOSITORY__VERSION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__DESCRIPTION = REPOSITORY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__PROVIDER = REPOSITORY__PROVIDER;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__MODIFIABLE = REPOSITORY__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Provisioning Agent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__PROVISIONING_AGENT = REPOSITORY__PROVISIONING_AGENT;

	/**
	 * The feature id for the '<em><b>Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__PROPERTY_MAP = REPOSITORY__PROPERTY_MAP;

	/**
	 * The feature id for the '<em><b>Installable Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__INSTALLABLE_UNITS = REPOSITORY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY__REFERENCES = REPOSITORY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Metadata Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_FEATURE_COUNT = REPOSITORY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Processor Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_STEP_DESCRIPTOR__PROCESSOR_ID = IPROCESSING_STEP_DESCRIPTOR__PROCESSOR_ID;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_STEP_DESCRIPTOR__DATA = IPROCESSING_STEP_DESCRIPTOR__DATA;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_STEP_DESCRIPTOR__REQUIRED = IPROCESSING_STEP_DESCRIPTOR__REQUIRED;

	/**
	 * The number of structural features of the '<em>Processing Step Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_STEP_DESCRIPTOR_FEATURE_COUNT = IPROCESSING_STEP_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_CAPABILITY__NAME = IPROVIDED_CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_CAPABILITY__NAMESPACE = IPROVIDED_CAPABILITY__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_CAPABILITY__VERSION = IPROVIDED_CAPABILITY__VERSION;

	/**
	 * The number of structural features of the '<em>Provided Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_CAPABILITY_FEATURE_COUNT = IPROVIDED_CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_REFERENCE__LOCATION = IREPOSITORY_REFERENCE__LOCATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_REFERENCE__TYPE = IREPOSITORY_REFERENCE__TYPE;

	/**
	 * The feature id for the '<em><b>Options</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_REFERENCE__OPTIONS = IREPOSITORY_REFERENCE__OPTIONS;

	/**
	 * The feature id for the '<em><b>Nickname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_REFERENCE__NICKNAME = IREPOSITORY_REFERENCE__NICKNAME;

	/**
	 * The number of structural features of the '<em>Repository Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_REFERENCE_FEATURE_COUNT = IREPOSITORY_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__FILTER = IREQUIREMENT__FILTER;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MAX = IREQUIREMENT__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MIN = IREQUIREMENT__MIN;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MATCHES = IREQUIREMENT__MATCHES;

	/**
	 * The feature id for the '<em><b>Greedy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__GREEDY = IREQUIREMENT__GREEDY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DESCRIPTION = IREQUIREMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY__FILTER = REQUIREMENT__FILTER;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY__MAX = REQUIREMENT__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY__MIN = REQUIREMENT__MIN;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY__MATCHES = REQUIREMENT__MATCHES;

	/**
	 * The feature id for the '<em><b>Greedy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY__GREEDY = REQUIREMENT__GREEDY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY__DESCRIPTION = REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY__NAME = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY__NAMESPACE = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY__RANGE = REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Required Capability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CAPABILITY_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.RequiredPropertiesMatchImpl <em>Required Properties Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.RequiredPropertiesMatchImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getRequiredPropertiesMatch()
	 * @since 1.1
	 * @generated
	 */
	int REQUIRED_PROPERTIES_MATCH = 44;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_PROPERTIES_MATCH__FILTER = REQUIREMENT__FILTER;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_PROPERTIES_MATCH__MAX = REQUIREMENT__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_PROPERTIES_MATCH__MIN = REQUIREMENT__MIN;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_PROPERTIES_MATCH__MATCHES = REQUIREMENT__MATCHES;

	/**
	 * The feature id for the '<em><b>Greedy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_PROPERTIES_MATCH__GREEDY = REQUIREMENT__GREEDY;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_PROPERTIES_MATCH__DESCRIPTION = REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 1.1
	 * @generated
	 * @ordered
	 */
	int REQUIRED_PROPERTIES_MATCH__NAMESPACE = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 1.1
	 * @generated
	 * @ordered
	 */
	int REQUIRED_PROPERTIES_MATCH__PROPERTIES_MATCH = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Required Properties Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 1.1
	 * @generated
	 * @ordered
	 */
	int REQUIRED_PROPERTIES_MATCH_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Apply On</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_CHANGE__APPLY_ON = IREQUIREMENT_CHANGE__APPLY_ON;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_CHANGE__NEW_VALUE = IREQUIREMENT_CHANGE__NEW_VALUE;

	/**
	 * The number of structural features of the '<em>Requirement Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_CHANGE_FEATURE_COUNT = IREQUIREMENT_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.SimpleArtifactRepositoryImpl <em>Simple Artifact Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.SimpleArtifactRepositoryImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getSimpleArtifactRepository()
	 * @generated
	 */
	int SIMPLE_ARTIFACT_REPOSITORY = 46;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__LOCATION = ARTIFACT_REPOSITORY__LOCATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__NAME = ARTIFACT_REPOSITORY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__TYPE = ARTIFACT_REPOSITORY__TYPE;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__VERSION = ARTIFACT_REPOSITORY__VERSION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__DESCRIPTION = ARTIFACT_REPOSITORY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__PROVIDER = ARTIFACT_REPOSITORY__PROVIDER;

	/**
	 * The feature id for the '<em><b>Modifiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__MODIFIABLE = ARTIFACT_REPOSITORY__MODIFIABLE;

	/**
	 * The feature id for the '<em><b>Provisioning Agent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__PROVISIONING_AGENT = ARTIFACT_REPOSITORY__PROVISIONING_AGENT;

	/**
	 * The feature id for the '<em><b>Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__PROPERTY_MAP = ARTIFACT_REPOSITORY__PROPERTY_MAP;

	/**
	 * The feature id for the '<em><b>Artifact Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__ARTIFACT_MAP = ARTIFACT_REPOSITORY__ARTIFACT_MAP;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY__RULES = ARTIFACT_REPOSITORY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Artifact Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_REPOSITORY_FEATURE_COUNT = ARTIFACT_REPOSITORY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.impl.SimpleArtifactDescriptorImpl <em>Simple Artifact Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.SimpleArtifactDescriptorImpl
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getSimpleArtifactDescriptor()
	 * @generated
	 */
	int SIMPLE_ARTIFACT_DESCRIPTOR = 47;

	/**
	 * The feature id for the '<em><b>Artifact Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_DESCRIPTOR__ARTIFACT_KEY = ARTIFACT_DESCRIPTOR__ARTIFACT_KEY;

	/**
	 * The feature id for the '<em><b>Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_DESCRIPTOR__PROPERTY_MAP = ARTIFACT_DESCRIPTOR__PROPERTY_MAP;

	/**
	 * The feature id for the '<em><b>Processing Step List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST = ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST;

	/**
	 * The feature id for the '<em><b>Repository Property Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_DESCRIPTOR__REPOSITORY_PROPERTY_MAP = ARTIFACT_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Artifact Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_ARTIFACT_DESCRIPTOR_FEATURE_COUNT = ARTIFACT_DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instruction Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUCHPOINT_DATA__INSTRUCTION_MAP = ITOUCHPOINT_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Touchpoint Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUCHPOINT_DATA_FEATURE_COUNT = ITOUCHPOINT_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUCHPOINT_INSTRUCTION__BODY = ITOUCHPOINT_INSTRUCTION__BODY;

	/**
	 * The feature id for the '<em><b>Import Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUCHPOINT_INSTRUCTION__IMPORT_ATTRIBUTE = ITOUCHPOINT_INSTRUCTION__IMPORT_ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>Touchpoint Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUCHPOINT_INSTRUCTION_FEATURE_COUNT = ITOUCHPOINT_INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUCHPOINT_TYPE__ID = ITOUCHPOINT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUCHPOINT_TYPE__VERSION = ITOUCHPOINT_TYPE__VERSION;

	/**
	 * The number of structural features of the '<em>Touchpoint Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOUCHPOINT_TYPE_FEATURE_COUNT = ITOUCHPOINT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_DESCRIPTOR__DESCRIPTION = IUPDATE_DESCRIPTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_DESCRIPTOR__SEVERITY = IUPDATE_DESCRIPTOR__SEVERITY;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_DESCRIPTOR__LOCATION = IUPDATE_DESCRIPTOR__LOCATION;

	/**
	 * The number of structural features of the '<em>Update Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_DESCRIPTOR_FEATURE_COUNT = IUPDATE_DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>Version</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.Version
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 80;

	/**
	 * The meta object id for the '<em>Version Range</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.VersionRange
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getVersionRange()
	 * @generated
	 */
	int VERSION_RANGE = 81;

	/**
	 * The meta object id for the '<em>IInstallable Unit Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnitArray()
	 * @generated
	 */
	int IINSTALLABLE_UNIT_ARRAY = 60;

	/**
	 * The meta object id for the '<em>Collection</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Collection
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 52;

	/**
	 * The meta object id for the '<em>IProvided Capability Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProvidedCapabilityArray()
	 * @generated
	 */
	int IPROVIDED_CAPABILITY_ARRAY = 66;

	/**
	 * The meta object id for the '<em>IInstallable Unit Fragment Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIInstallableUnitFragmentArray()
	 * @generated
	 */
	int IINSTALLABLE_UNIT_FRAGMENT_ARRAY = 61;

	/**
	 * The meta object id for the '<em>IArtifact Key Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactKeyArray()
	 * @generated
	 */
	int IARTIFACT_KEY_ARRAY = 57;

	/**
	 * The meta object id for the '<em>IArtifact Request Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactRequestArray()
	 * @generated
	 */
	int IARTIFACT_REQUEST_ARRAY = 58;

	/**
	 * The meta object id for the '<em>IFilter Expression</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.expression.IFilterExpression
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIFilterExpression()
	 * @since 1.1
	 * @generated
	 */
	int IFILTER_EXPRESSION = 59;

	/**
	 * The meta object id for the '<em>ITouchpoint Data Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getITouchpointDataArray()
	 * @generated
	 */
	int ITOUCHPOINT_DATA_ARRAY = 74;

	/**
	 * The meta object id for the '<em>IRequirement Array Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRequirementArrayArray()
	 * @generated
	 */
	int IREQUIREMENT_ARRAY_ARRAY = 68;

	/**
	 * The meta object id for the '<em>IPool</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.core.IPool
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIPool()
	 * @generated
	 */
	int IPOOL = 69;

	/**
	 * The meta object id for the '<em>IProcessing Descriptor Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProcessingDescriptorArray()
	 * @generated
	 */
	int IPROCESSING_DESCRIPTOR_ARRAY = 70;

	/**
	 * The meta object id for the '<em>String Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getStringArray()
	 * @generated
	 */
	int STRING_ARRAY = 77;

	/**
	 * The meta object id for the '<em>Untyped Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getUntypedMap()
	 * @generated
	 */
	int UNTYPED_MAP = 78;

	/**
	 * The meta object id for the '<em>Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Map
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getMap()
	 * @generated
	 */
	int MAP = 75;

	/**
	 * The meta object id for the '<em>Output Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.OutputStream
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getOutputStream()
	 * @generated
	 */
	int OUTPUT_STREAM = 76;

	/**
	 * The meta object id for the '<em>ILicense Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getILicenseArray()
	 * @generated
	 */
	int ILICENSE_ARRAY = 62;

	/**
	 * The meta object id for the '<em>IQuery Result</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.query.IQueryResult
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIQueryResult()
	 * @generated
	 */
	int IQUERY_RESULT = 65;

	/**
	 * The meta object id for the '<em>IQuery</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.query.IQuery
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIQuery()
	 * @generated
	 */
	int IQUERY = 64;

	/**
	 * The meta object id for the '<em>Collector</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.query.Collector
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getCollector()
	 * @generated
	 */
	int COLLECTOR = 53;

	/**
	 * The meta object id for the '<em>File</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.File
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getFile()
	 * @generated
	 */
	int FILE = 54;

	/**
	 * The meta object id for the '<em>Filter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.expression.IMatchExpression
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getFilter()
	 * @since 1.1
	 * @generated
	 */
	int FILTER = 55;

	/**
	 * The meta object id for the '<em>IArtifact Descriptor Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIArtifactDescriptorArray()
	 * @generated
	 */
	int IARTIFACT_DESCRIPTOR_ARRAY = 56;

	/**
	 * The meta object id for the '<em>IProgress Monitor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IProgressMonitor
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProgressMonitor()
	 * @generated
	 */
	int IPROGRESS_MONITOR = 71;

	/**
	 * The meta object id for the '<em>IRunnable With Progress</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.repository.IRunnableWithProgress
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIRunnableWithProgress()
	 * @generated
	 */
	int IRUNNABLE_WITH_PROGRESS = 72;

	/**
	 * The meta object id for the '<em>IStatus</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.IStatus
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIStatus()
	 * @generated
	 */
	int ISTATUS = 73;

	/**
	 * The meta object id for the '<em>IMatch Expression</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.metadata.expression.IMatchExpression
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIMatchExpression()
	 * @generated
	 */
	int IMATCH_EXPRESSION = 63;

	/**
	 * The meta object id for the '<em>IProvisioning Agent</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.equinox.p2.core.IProvisioningAgent
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getIProvisioningAgent()
	 * @generated
	 */
	int IPROVISIONING_AGENT = 67;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.net.URI
	 * @see org.eclipse.cbi.p2repo.p2.impl.P2PackageImpl#getURI()
	 * @generated
	 */
	int URI = 79;

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.ArtifactDescriptor <em>Artifact Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact Descriptor</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.ArtifactDescriptor
	 * @generated
	 */
	EClass getArtifactDescriptor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.p2.ArtifactDescriptor#getProcessingStepList <em>Processing Step List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processing Step List</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.ArtifactDescriptor#getProcessingStepList()
	 * @see #getArtifactDescriptor()
	 * @generated
	 */
	EReference getArtifactDescriptor_ProcessingStepList();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.cbi.p2repo.p2.ArtifactDescriptor#getPropertyMap <em>Property Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Property Map</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.ArtifactDescriptor#getPropertyMap()
	 * @see #getArtifactDescriptor()
	 * @generated
	 */
	EReference getArtifactDescriptor_PropertyMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.ArtifactKey <em>Artifact Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact Key</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.ArtifactKey
	 * @generated
	 */
	EClass getArtifactKey();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.ArtifactRepository <em>Artifact Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact Repository</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.ArtifactRepository
	 * @generated
	 */
	EClass getArtifactRepository();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.cbi.p2repo.p2.ArtifactRepository#getArtifactMap <em>Artifact Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Artifact Map</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.ArtifactRepository#getArtifactMap()
	 * @see #getArtifactRepository()
	 * @generated
	 */
	EReference getArtifactRepository_ArtifactMap();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Artifacts By Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifacts By Key</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.eclipse.cbi.p2repo.p2.IArtifactKey" keyContainment="true" keyResolveProxies="true" keyRequired="true"
	 *        valueType="org.eclipse.cbi.p2repo.p2.IArtifactDescriptor" valueContainment="true" valueResolveProxies="true" valueMany="true"
	 * @generated
	 */
	EClass getArtifactsByKey();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getArtifactsByKey()
	 * @generated
	 */
	EReference getArtifactsByKey_Key();

	/**
	 * Returns the meta object for the containment reference list '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getArtifactsByKey()
	 * @generated
	 */
	EReference getArtifactsByKey_Value();

	/**
	 * Returns the meta object for data type '{@link java.util.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Collection</em>'.
	 * @see java.util.Collection
	 * @model instanceClass="java.util.Collection" typeParameters="T"
	 * @generated
	 */
	EDataType getCollection();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.query.Collector <em>Collector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Collector</em>'.
	 * @see org.eclipse.equinox.p2.query.Collector
	 * @model instanceClass="org.eclipse.equinox.p2.query.Collector" serializeable="false"
	 * @generated
	 */
	EDataType getCollector();

	/**
	 * Returns the meta object for class '{@link java.lang.Comparable <em>Comparable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comparable</em>'.
	 * @see java.lang.Comparable
	 * @model instanceClass="java.lang.Comparable" typeParameters="T"
	 * @generated
	 */
	EClass getComparable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.Copyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copyright</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.Copyright
	 * @generated
	 */
	EClass getCopyright();

	/**
	 * Returns the meta object for data type '{@link java.io.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>File</em>'.
	 * @see java.io.File
	 * @model instanceClass="java.io.File"
	 * @generated
	 */
	EDataType getFile();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.metadata.expression.IMatchExpression <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @since 1.1
	 * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>Filter</em>'.
	 * @see org.eclipse.equinox.p2.metadata.expression.IMatchExpression
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.expression.IMatchExpression&lt;org.eclipse.equinox.p2.metadata.IInstallableUnit&gt;"
	 * @generated
	 */
	EDataType getFilter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.core.runtime.IAdaptable <em>IAdaptable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IAdaptable</em>'.
	 * @see org.eclipse.core.runtime.IAdaptable
	 * @model instanceClass="org.eclipse.core.runtime.IAdaptable"
	 * @generated
	 */
	EClass getIAdaptable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor <em>IArtifact Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IArtifact Descriptor</em>'.
	 * @see org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor
	 * @model instanceClass="org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor"
	 * @generated
	 */
	EClass getIArtifactDescriptor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor#getArtifactKey <em>Artifact Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Artifact Key</em>'.
	 * @see org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor#getArtifactKey()
	 * @see #getIArtifactDescriptor()
	 * @generated
	 */
	EReference getIArtifactDescriptor_ArtifactKey();

	/**
	 * Returns the meta object for data type '<em>IArtifact Descriptor Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IArtifact Descriptor Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor[]"
	 * @generated
	 */
	EDataType getIArtifactDescriptorArray();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.IArtifactKey <em>IArtifact Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IArtifact Key</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IArtifactKey
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IArtifactKey"
	 * @generated
	 */
	EClass getIArtifactKey();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IArtifactKey#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classifier</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IArtifactKey#getClassifier()
	 * @see #getIArtifactKey()
	 * @generated
	 */
	EAttribute getIArtifactKey_Classifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IArtifactKey#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IArtifactKey#getId()
	 * @see #getIArtifactKey()
	 * @generated
	 */
	EAttribute getIArtifactKey_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IArtifactKey#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IArtifactKey#getVersion()
	 * @see #getIArtifactKey()
	 * @generated
	 */
	EAttribute getIArtifactKey_Version();

	/**
	 * Returns the meta object for data type '<em>IArtifact Key Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IArtifact Key Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IArtifactKey[]"
	 * @generated
	 */
	EDataType getIArtifactKeyArray();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.repository.artifact.IArtifactRepository <em>IArtifact Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IArtifact Repository</em>'.
	 * @see org.eclipse.equinox.p2.repository.artifact.IArtifactRepository
	 * @model instanceClass="org.eclipse.equinox.p2.repository.artifact.IArtifactRepository" superTypes="org.eclipse.cbi.p2repo.p2.IRepository&lt;org.eclipse.cbi.p2repo.p2.IArtifactKey&gt;"
	 * @generated
	 */
	EClass getIArtifactRepository();

	/**
	 * Returns the meta object for data type '<em>IArtifact Request Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IArtifact Request Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.repository.artifact.IArtifactRequest[]"
	 * @generated
	 */
	EDataType getIArtifactRequestArray();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.metadata.expression.IFilterExpression <em>IFilter Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @since 1.1
	 * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>IFilter Expression</em>'.
	 * @see org.eclipse.equinox.p2.metadata.expression.IFilterExpression
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.expression.IFilterExpression"
	 * @generated
	 */
	EDataType getIFilterExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.ICopyright <em>ICopyright</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ICopyright</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ICopyright
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.ICopyright"
	 * @generated
	 */
	EClass getICopyright();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.ICopyright#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ICopyright#getBody()
	 * @see #getICopyright()
	 * @generated
	 */
	EAttribute getICopyright_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.ICopyright#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ICopyright#getLocation()
	 * @see #getICopyright()
	 * @generated
	 */
	EAttribute getICopyright_Location();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository <em>IFile Artifact Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IFile Artifact Repository</em>'.
	 * @see org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository
	 * @model instanceClass="org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository" superTypes="org.eclipse.cbi.p2repo.p2.IArtifactRepository"
	 * @generated
	 */
	EClass getIFileArtifactRepository();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit <em>IInstallable Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IInstallable Unit</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IInstallableUnit" superTypes="org.eclipse.cbi.p2repo.p2.IVersionedId org.eclipse.cbi.p2repo.p2.Comparable&lt;org.eclipse.cbi.p2repo.p2.IInstallableUnit&gt;"
	 * @generated
	 */
	EClass getIInstallableUnit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getArtifacts <em>Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Artifacts</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getArtifacts()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_Artifacts();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getCopyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Copyright</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getCopyright()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_Copyright();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getFilter()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EAttribute getIInstallableUnit_Filter();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getFragments <em>Fragments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fragments</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getFragments()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_Fragments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getLicenses <em>Licenses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Licenses</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getLicenses()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_Licenses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getMetaRequirements <em>Meta Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Meta Requirements</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getMetaRequirements()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_MetaRequirements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getProvidedCapabilities <em>Provided Capabilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided Capabilities</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getProvidedCapabilities()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_ProvidedCapabilities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getRequirements()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_Requirements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#isResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#isResolved()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EAttribute getIInstallableUnit_Resolved();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#isSingleton <em>Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Singleton</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#isSingleton()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EAttribute getIInstallableUnit_Singleton();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getTouchpointData <em>Touchpoint Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Touchpoint Data</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getTouchpointData()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_TouchpointData();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getTouchpointType <em>Touchpoint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Touchpoint Type</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getTouchpointType()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_TouchpointType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.equinox.p2.metadata.IInstallableUnit#getUpdateDescriptor <em>Update Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Update Descriptor</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnit#getUpdateDescriptor()
	 * @see #getIInstallableUnit()
	 * @generated
	 */
	EReference getIInstallableUnit_UpdateDescriptor();

	/**
	 * Returns the meta object for data type '<em>IInstallable Unit Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IInstallable Unit Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IInstallableUnit[]"
	 * @generated
	 */
	EDataType getIInstallableUnitArray();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitFragment <em>IInstallable Unit Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IInstallable Unit Fragment</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitFragment
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IInstallableUnitFragment" superTypes="org.eclipse.cbi.p2repo.p2.IInstallableUnit"
	 * @generated
	 */
	EClass getIInstallableUnitFragment();

	/**
	 * Returns the meta object for data type '<em>IInstallable Unit Fragment Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IInstallable Unit Fragment Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IInstallableUnitFragment[]"
	 * @generated
	 */
	EDataType getIInstallableUnitFragmentArray();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitPatch <em>IInstallable Unit Patch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IInstallable Unit Patch</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitPatch
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IInstallableUnitPatch" superTypes="org.eclipse.cbi.p2repo.p2.IInstallableUnit"
	 * @generated
	 */
	EClass getIInstallableUnitPatch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitPatch <em>Applies To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applies To</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitPatch
	 * @see #getIInstallableUnitPatch()
	 * @generated
	 */
	EReference getIInstallableUnitPatch_AppliesTo();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitPatch#getLifeCycle <em>Life Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Life Cycle</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitPatch#getLifeCycle()
	 * @see #getIInstallableUnitPatch()
	 * @generated
	 */
	EReference getIInstallableUnitPatch_LifeCycle();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.equinox.p2.metadata.IInstallableUnitPatch#getRequirementsChange <em>Requirements Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requirements Change</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IInstallableUnitPatch#getRequirementsChange()
	 * @see #getIInstallableUnitPatch()
	 * @generated
	 */
	EReference getIInstallableUnitPatch_RequirementsChange();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.ILicense <em>ILicense</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ILicense</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ILicense
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.ILicense"
	 * @generated
	 */
	EClass getILicense();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.ILicense#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ILicense#getBody()
	 * @see #getILicense()
	 * @generated
	 */
	EAttribute getILicense_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.ILicense#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ILicense#getLocation()
	 * @see #getILicense()
	 * @generated
	 */
	EAttribute getILicense_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.ILicense#getUUID <em>UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UUID</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ILicense#getUUID()
	 * @see #getILicense()
	 * @generated
	 */
	EAttribute getILicense_UUID();

	/**
	 * Returns the meta object for data type '<em>ILicense Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ILicense Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.ILicense[]"
	 * @generated
	 */
	EDataType getILicenseArray();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.metadata.expression.IMatchExpression <em>IMatch Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IMatch Expression</em>'.
	 * @see org.eclipse.equinox.p2.metadata.expression.IMatchExpression
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.expression.IMatchExpression" typeParameters="T"
	 * @generated
	 */
	EDataType getIMatchExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.repository.metadata.IMetadataRepository <em>IMetadata Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IMetadata Repository</em>'.
	 * @see org.eclipse.equinox.p2.repository.metadata.IMetadataRepository
	 * @model instanceClass="org.eclipse.equinox.p2.repository.metadata.IMetadataRepository" superTypes="org.eclipse.cbi.p2repo.p2.IRepository&lt;org.eclipse.cbi.p2repo.p2.IInstallableUnit&gt;"
	 * @generated
	 */
	EClass getIMetadataRepository();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.InstallableUnit <em>Installable Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Installable Unit</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.InstallableUnit
	 * @generated
	 */
	EClass getInstallableUnit();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.cbi.p2repo.p2.InstallableUnit#getPropertyMap <em>Property Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Property Map</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.InstallableUnit#getPropertyMap()
	 * @see #getInstallableUnit()
	 * @generated
	 */
	EReference getInstallableUnit_PropertyMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.InstallableUnitFragment <em>Installable Unit Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Installable Unit Fragment</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.InstallableUnitFragment
	 * @generated
	 */
	EClass getInstallableUnitFragment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.p2.InstallableUnitFragment#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Host</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.InstallableUnitFragment#getHost()
	 * @see #getInstallableUnitFragment()
	 * @generated
	 */
	EReference getInstallableUnitFragment_Host();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.InstallableUnitPatch <em>Installable Unit Patch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Installable Unit Patch</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.InstallableUnitPatch
	 * @generated
	 */
	EClass getInstallableUnitPatch();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Instruction Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueType="org.eclipse.cbi.p2repo.p2.ITouchpointInstruction" valueContainment="true" valueResolveProxies="true"
	 * @generated
	 */
	EClass getInstructionMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getInstructionMap()
	 * @generated
	 */
	EAttribute getInstructionMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getInstructionMap()
	 * @generated
	 */
	EReference getInstructionMap_Value();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.core.IPool <em>IPool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IPool</em>'.
	 * @see org.eclipse.equinox.p2.core.IPool
	 * @model instanceClass="org.eclipse.equinox.p2.core.IPool" serializeable="false" typeParameters="T"
	 * @generated
	 */
	EDataType getIPool();

	/**
	 * Returns the meta object for data type '<em>IProcessing Descriptor Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IProcessing Descriptor Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor[]"
	 * @generated
	 */
	EDataType getIProcessingDescriptorArray();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor <em>IProcessing Step Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProcessing Step Descriptor</em>'.
	 * @see org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor
	 * @model instanceClass="org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor"
	 * @generated
	 */
	EClass getIProcessingStepDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor#getData()
	 * @see #getIProcessingStepDescriptor()
	 * @generated
	 */
	EAttribute getIProcessingStepDescriptor_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor#getProcessorId <em>Processor Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processor Id</em>'.
	 * @see org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor#getProcessorId()
	 * @see #getIProcessingStepDescriptor()
	 * @generated
	 */
	EAttribute getIProcessingStepDescriptor_ProcessorId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor#isRequired()
	 * @see #getIProcessingStepDescriptor()
	 * @generated
	 */
	EAttribute getIProcessingStepDescriptor_Required();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IProgressMonitor <em>IProgress Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IProgress Monitor</em>'.
	 * @see org.eclipse.core.runtime.IProgressMonitor
	 * @model instanceClass="org.eclipse.core.runtime.IProgressMonitor" serializeable="false"
	 * @generated
	 */
	EDataType getIProgressMonitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.IProvidedCapability <em>IProvided Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IProvided Capability</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IProvidedCapability
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IProvidedCapability"
	 * @generated
	 */
	EClass getIProvidedCapability();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IProvidedCapability#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IProvidedCapability#getName()
	 * @see #getIProvidedCapability()
	 * @generated
	 */
	EAttribute getIProvidedCapability_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IProvidedCapability#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IProvidedCapability#getNamespace()
	 * @see #getIProvidedCapability()
	 * @generated
	 */
	EAttribute getIProvidedCapability_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IProvidedCapability#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IProvidedCapability#getVersion()
	 * @see #getIProvidedCapability()
	 * @generated
	 */
	EAttribute getIProvidedCapability_Version();

	/**
	 * Returns the meta object for data type '<em>IProvided Capability Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IProvided Capability Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IProvidedCapability[]"
	 * @generated
	 */
	EDataType getIProvidedCapabilityArray();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.core.IProvisioningAgent <em>IProvisioning Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IProvisioning Agent</em>'.
	 * @see org.eclipse.equinox.p2.core.IProvisioningAgent
	 * @model instanceClass="org.eclipse.equinox.p2.core.IProvisioningAgent"
	 * @generated
	 */
	EDataType getIProvisioningAgent();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.query.IQuery <em>IQuery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IQuery</em>'.
	 * @see org.eclipse.equinox.p2.query.IQuery
	 * @model instanceClass="org.eclipse.equinox.p2.query.IQuery" serializeable="false" typeParameters="T"
	 * @generated
	 */
	EDataType getIQuery();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.query.IQueryable <em>IQueryable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IQueryable</em>'.
	 * @see org.eclipse.equinox.p2.query.IQueryable
	 * @model instanceClass="org.eclipse.equinox.p2.query.IQueryable" typeParameters="T"
	 * @generated
	 */
	EClass getIQueryable();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.query.IQueryResult <em>IQuery Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IQuery Result</em>'.
	 * @see org.eclipse.equinox.p2.query.IQueryResult
	 * @model instanceClass="org.eclipse.equinox.p2.query.IQueryResult" typeParameters="T"
	 * @generated
	 */
	EDataType getIQueryResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.repository.IRepository <em>IRepository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IRepository</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepository
	 * @model instanceClass="org.eclipse.equinox.p2.repository.IRepository" typeParameters="T" superTypes="org.eclipse.cbi.p2repo.p2.IAdaptable org.eclipse.cbi.p2repo.p2.IQueryable&lt;T&gt;"
	 * @generated
	 */
	EClass getIRepository();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepository#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepository#getDescription()
	 * @see #getIRepository()
	 * @generated
	 */
	EAttribute getIRepository_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepository#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepository#getLocation()
	 * @see #getIRepository()
	 * @generated
	 */
	EAttribute getIRepository_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepository#isModifiable <em>Modifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifiable</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepository#isModifiable()
	 * @see #getIRepository()
	 * @generated
	 */
	EAttribute getIRepository_Modifiable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepository#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepository#getName()
	 * @see #getIRepository()
	 * @generated
	 */
	EAttribute getIRepository_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepository#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepository#getProvider()
	 * @see #getIRepository()
	 * @generated
	 */
	EAttribute getIRepository_Provider();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepository#getProvisioningAgent <em>Provisioning Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provisioning Agent</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepository#getProvisioningAgent()
	 * @see #getIRepository()
	 * @generated
	 */
	EAttribute getIRepository_ProvisioningAgent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepository#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepository#getType()
	 * @see #getIRepository()
	 * @generated
	 */
	EAttribute getIRepository_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepository#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepository#getVersion()
	 * @see #getIRepository()
	 * @generated
	 */
	EAttribute getIRepository_Version();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.repository.IRepositoryReference <em>IRepository Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IRepository Reference</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepositoryReference
	 * @model instanceClass="org.eclipse.equinox.p2.repository.IRepositoryReference"
	 * @generated
	 */
	EClass getIRepositoryReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepositoryReference#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepositoryReference#getLocation()
	 * @see #getIRepositoryReference()
	 * @generated
	 */
	EAttribute getIRepositoryReference_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepositoryReference#getNickname <em>Nickname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nickname</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepositoryReference#getNickname()
	 * @see #getIRepositoryReference()
	 * @generated
	 */
	EAttribute getIRepositoryReference_Nickname();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepositoryReference#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Options</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepositoryReference#getOptions()
	 * @see #getIRepositoryReference()
	 * @generated
	 */
	EAttribute getIRepositoryReference_Options();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.repository.IRepositoryReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRepositoryReference#getType()
	 * @see #getIRepositoryReference()
	 * @generated
	 */
	EAttribute getIRepositoryReference_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.internal.p2.metadata.IRequiredCapability <em>IRequired Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IRequired Capability</em>'.
	 * @see org.eclipse.equinox.internal.p2.metadata.IRequiredCapability
	 * @model instanceClass="org.eclipse.equinox.internal.p2.metadata.IRequiredCapability" superTypes="org.eclipse.cbi.p2repo.p2.IRequirement"
	 * @generated
	 */
	EClass getIRequiredCapability();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.internal.p2.metadata.IRequiredCapability#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.equinox.internal.p2.metadata.IRequiredCapability#getName()
	 * @see #getIRequiredCapability()
	 * @generated
	 */
	EAttribute getIRequiredCapability_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.internal.p2.metadata.IRequiredCapability#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.eclipse.equinox.internal.p2.metadata.IRequiredCapability#getNamespace()
	 * @see #getIRequiredCapability()
	 * @generated
	 */
	EAttribute getIRequiredCapability_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.internal.p2.metadata.IRequiredCapability#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see org.eclipse.equinox.internal.p2.metadata.IRequiredCapability#getRange()
	 * @see #getIRequiredCapability()
	 * @generated
	 */
	EAttribute getIRequiredCapability_Range();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.IRequirement <em>IRequirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IRequirement</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirement
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IRequirement"
	 * @generated
	 */
	EClass getIRequirement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IRequirement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirement#getDescription()
	 * @see #getIRequirement()
	 * @generated
	 */
	EAttribute getIRequirement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IRequirement#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirement#getFilter()
	 * @see #getIRequirement()
	 * @generated
	 */
	EAttribute getIRequirement_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IRequirement#isGreedy <em>Greedy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Greedy</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirement#isGreedy()
	 * @see #getIRequirement()
	 * @generated
	 */
	EAttribute getIRequirement_Greedy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IRequirement#getMatches <em>Matches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matches</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirement#getMatches()
	 * @see #getIRequirement()
	 * @generated
	 */
	EAttribute getIRequirement_Matches();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IRequirement#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirement#getMax()
	 * @see #getIRequirement()
	 * @generated
	 */
	EAttribute getIRequirement_Max();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IRequirement#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirement#getMin()
	 * @see #getIRequirement()
	 * @generated
	 */
	EAttribute getIRequirement_Min();

	/**
	 * Returns the meta object for data type '<em>IRequirement Array Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IRequirement Array Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IRequirement[][]"
	 * @generated
	 */
	EDataType getIRequirementArrayArray();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.IRequirementChange <em>IRequirement Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IRequirement Change</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirementChange
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IRequirementChange"
	 * @generated
	 */
	EClass getIRequirementChange();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.equinox.p2.metadata.IRequirementChange <em>Apply On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Apply On</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirementChange
	 * @see #getIRequirementChange()
	 * @generated
	 */
	EReference getIRequirementChange_ApplyOn();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.equinox.p2.metadata.IRequirementChange <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Value</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IRequirementChange
	 * @see #getIRequirementChange()
	 * @generated
	 */
	EReference getIRequirementChange_NewValue();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.repository.IRunnableWithProgress <em>IRunnable With Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IRunnable With Progress</em>'.
	 * @see org.eclipse.equinox.p2.repository.IRunnableWithProgress
	 * @model instanceClass="org.eclipse.equinox.p2.repository.IRunnableWithProgress"
	 * @generated
	 */
	EDataType getIRunnableWithProgress();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.IStatus <em>IStatus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IStatus</em>'.
	 * @see org.eclipse.core.runtime.IStatus
	 * @model instanceClass="org.eclipse.core.runtime.IStatus"
	 * @generated
	 */
	EDataType getIStatus();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.ITouchpointData <em>ITouchpoint Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITouchpoint Data</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointData
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.ITouchpointData"
	 * @generated
	 */
	EClass getITouchpointData();

	/**
	 * Returns the meta object for data type '<em>ITouchpoint Data Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ITouchpoint Data Array</em>'.
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.ITouchpointData[]"
	 * @generated
	 */
	EDataType getITouchpointDataArray();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.ITouchpointInstruction <em>ITouchpoint Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITouchpoint Instruction</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointInstruction
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.ITouchpointInstruction"
	 * @generated
	 */
	EClass getITouchpointInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.ITouchpointInstruction#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointInstruction#getBody()
	 * @see #getITouchpointInstruction()
	 * @generated
	 */
	EAttribute getITouchpointInstruction_Body();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.ITouchpointInstruction#getImportAttribute <em>Import Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import Attribute</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointInstruction#getImportAttribute()
	 * @see #getITouchpointInstruction()
	 * @generated
	 */
	EAttribute getITouchpointInstruction_ImportAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.ITouchpointType <em>ITouchpoint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ITouchpoint Type</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointType
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.ITouchpointType"
	 * @generated
	 */
	EClass getITouchpointType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.ITouchpointType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointType#getId()
	 * @see #getITouchpointType()
	 * @generated
	 */
	EAttribute getITouchpointType_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.ITouchpointType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.equinox.p2.metadata.ITouchpointType#getVersion()
	 * @see #getITouchpointType()
	 * @generated
	 */
	EAttribute getITouchpointType_Version();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.IUpdateDescriptor <em>IUpdate Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IUpdate Descriptor</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IUpdateDescriptor
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IUpdateDescriptor"
	 * @generated
	 */
	EClass getIUpdateDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IUpdateDescriptor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IUpdateDescriptor#getDescription()
	 * @see #getIUpdateDescriptor()
	 * @generated
	 */
	EAttribute getIUpdateDescriptor_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IUpdateDescriptor#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IUpdateDescriptor#getLocation()
	 * @see #getIUpdateDescriptor()
	 * @generated
	 */
	EAttribute getIUpdateDescriptor_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IUpdateDescriptor#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IUpdateDescriptor#getSeverity()
	 * @see #getIUpdateDescriptor()
	 * @generated
	 */
	EAttribute getIUpdateDescriptor_Severity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.equinox.p2.metadata.IVersionedId <em>IVersioned Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IVersioned Id</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IVersionedId
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.IVersionedId"
	 * @generated
	 */
	EClass getIVersionedId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IVersionedId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IVersionedId#getId()
	 * @see #getIVersionedId()
	 * @generated
	 */
	EAttribute getIVersionedId_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.equinox.p2.metadata.IVersionedId#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.equinox.p2.metadata.IVersionedId#getVersion()
	 * @see #getIVersionedId()
	 * @generated
	 */
	EAttribute getIVersionedId_Version();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.License <em>License</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>License</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.License
	 * @generated
	 */
	EClass getLicense();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map" typeParameters="K V"
	 * @generated
	 */
	EDataType getMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.MappingRule <em>Mapping Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Rule</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.MappingRule
	 * @generated
	 */
	EClass getMappingRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.MappingRule#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.MappingRule#getFilter()
	 * @see #getMappingRule()
	 * @generated
	 */
	EAttribute getMappingRule_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.MappingRule#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.MappingRule#getOutput()
	 * @see #getMappingRule()
	 * @generated
	 */
	EAttribute getMappingRule_Output();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.MetadataRepository <em>Metadata Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metadata Repository</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.MetadataRepository
	 * @generated
	 */
	EClass getMetadataRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.p2.MetadataRepository#getInstallableUnits <em>Installable Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Installable Units</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.MetadataRepository#getInstallableUnits()
	 * @see #getMetadataRepository()
	 * @generated
	 */
	EReference getMetadataRepository_InstallableUnits();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.p2.MetadataRepository#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.MetadataRepository#getReferences()
	 * @see #getMetadataRepository()
	 * @generated
	 */
	EReference getMetadataRepository_References();

	/**
	 * Returns the meta object for data type '{@link java.io.OutputStream <em>Output Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Output Stream</em>'.
	 * @see java.io.OutputStream
	 * @model instanceClass="java.io.OutputStream"
	 * @generated
	 */
	EDataType getOutputStream();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	P2Factory getP2Factory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.ProcessingStepDescriptor <em>Processing Step Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Step Descriptor</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.ProcessingStepDescriptor
	 * @generated
	 */
	EClass getProcessingStepDescriptor();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.ProvidedCapability <em>Provided Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provided Capability</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.ProvidedCapability
	 * @generated
	 */
	EClass getProvidedCapability();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.cbi.p2repo.p2.Repository#getPropertyMap <em>Property Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Property Map</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.Repository#getPropertyMap()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_PropertyMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.RepositoryReference <em>Repository Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository Reference</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.RepositoryReference
	 * @generated
	 */
	EClass getRepositoryReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.RequiredCapability <em>Required Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Capability</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.RequiredCapability
	 * @generated
	 */
	EClass getRequiredCapability();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch <em>Required Properties Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Properties Match</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch
	 * @since 1.1
	 * @generated
	 */
	EClass getRequiredPropertiesMatch();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch#getNamespace()
	 * @see #getRequiredPropertiesMatch()
	 * @since 1.1
	 * @generated
	 */
	EAttribute getRequiredPropertiesMatch_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch#getPropertiesMatch <em>Properties Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Properties Match</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch#getPropertiesMatch()
	 * @see #getRequiredPropertiesMatch()
	 * @since 1.1
	 * @generated
	 */
	EAttribute getRequiredPropertiesMatch_PropertiesMatch();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.RequirementChange <em>Requirement Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement Change</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.RequirementChange
	 * @generated
	 */
	EClass getRequirementChange();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.SimpleArtifactDescriptor <em>Simple Artifact Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Artifact Descriptor</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.SimpleArtifactDescriptor
	 * @generated
	 */
	EClass getSimpleArtifactDescriptor();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.cbi.p2repo.p2.SimpleArtifactDescriptor#getRepositoryPropertyMap <em>Repository Property Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Repository Property Map</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.SimpleArtifactDescriptor#getRepositoryPropertyMap()
	 * @see #getSimpleArtifactDescriptor()
	 * @generated
	 */
	EReference getSimpleArtifactDescriptor_RepositoryPropertyMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.SimpleArtifactRepository <em>Simple Artifact Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Artifact Repository</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.SimpleArtifactRepository
	 * @generated
	 */
	EClass getSimpleArtifactRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.p2.SimpleArtifactRepository#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.SimpleArtifactRepository#getRules()
	 * @see #getSimpleArtifactRepository()
	 * @generated
	 */
	EReference getSimpleArtifactRepository_Rules();

	/**
	 * Returns the meta object for data type '<em>String Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Array</em>'.
	 * @model instanceClass="java.lang.String[]"
	 * @generated
	 */
	EDataType getStringArray();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.TouchpointData <em>Touchpoint Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Touchpoint Data</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.TouchpointData
	 * @generated
	 */
	EClass getTouchpointData();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.cbi.p2repo.p2.TouchpointData#getInstructionMap <em>Instruction Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Instruction Map</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.TouchpointData#getInstructionMap()
	 * @see #getTouchpointData()
	 * @generated
	 */
	EReference getTouchpointData_InstructionMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.TouchpointInstruction <em>Touchpoint Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Touchpoint Instruction</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.TouchpointInstruction
	 * @generated
	 */
	EClass getTouchpointInstruction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.TouchpointType <em>Touchpoint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Touchpoint Type</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.TouchpointType
	 * @generated
	 */
	EClass getTouchpointType();

	/**
	 * Returns the meta object for data type '{@link java.util.Map <em>Untyped Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Untyped Map</em>'.
	 * @see java.util.Map
	 * @model instanceClass="java.util.Map"
	 * @generated
	 */
	EDataType getUntypedMap();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.UpdateDescriptor <em>Update Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Descriptor</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.UpdateDescriptor
	 * @generated
	 */
	EClass getUpdateDescriptor();

	/**
	 * Returns the meta object for data type '{@link java.net.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see java.net.URI
	 * @model instanceClass="java.net.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.metadata.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Version</em>'.
	 * @see org.eclipse.equinox.p2.metadata.Version
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.Version"
	 * @generated
	 */
	EDataType getVersion();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.equinox.p2.metadata.VersionRange <em>Version Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Version Range</em>'.
	 * @see org.eclipse.equinox.p2.metadata.VersionRange
	 * @model instanceClass="org.eclipse.equinox.p2.metadata.VersionRange"
	 * @generated
	 */
	EDataType getVersionRange();

} // P2Package
