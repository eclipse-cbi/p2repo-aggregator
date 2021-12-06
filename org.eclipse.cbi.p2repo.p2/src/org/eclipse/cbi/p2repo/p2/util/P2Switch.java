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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.p2.P2Package
 * @generated
 */
public class P2Switch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static P2Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public P2Switch() {
		if (modelPackage == null) {
			modelPackage = P2Package.eINSTANCE;
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseArtifactDescriptor(ArtifactDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseArtifactKey(ArtifactKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifact Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifact Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseArtifactRepository(ArtifactRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Artifacts By Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Artifacts By Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseArtifactsByKey(Map.Entry<IArtifactKey, EList<IArtifactDescriptor>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseComparable(Comparable<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Copyright</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Copyright</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCopyright(Copyright object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAdaptable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAdaptable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIAdaptable(IAdaptable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IArtifact Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IArtifact Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIArtifactDescriptor(IArtifactDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IArtifact Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IArtifact Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIArtifactKey(IArtifactKey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IArtifact Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IArtifact Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIArtifactRepository(IArtifactRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ICopyright</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ICopyright</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseICopyright(ICopyright object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFile Artifact Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFile Artifact Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIFileArtifactRepository(IFileArtifactRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInstallable Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInstallable Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIInstallableUnit(IInstallableUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInstallable Unit Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInstallable Unit Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIInstallableUnitFragment(IInstallableUnitFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IInstallable Unit Patch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IInstallable Unit Patch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIInstallableUnitPatch(IInstallableUnitPatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ILicense</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ILicense</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseILicense(ILicense object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMetadata Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMetadata Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIMetadataRepository(IMetadataRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Installable Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Installable Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInstallableUnit(InstallableUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Installable Unit Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Installable Unit Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInstallableUnitFragment(InstallableUnitFragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Installable Unit Patch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Installable Unit Patch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInstallableUnitPatch(InstallableUnitPatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instruction Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instruction Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInstructionMap(Map.Entry<String, ITouchpointInstruction> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcessing Step Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcessing Step Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProcessingStepDescriptor(IProcessingStepDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProvided Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProvided Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProvidedCapability(IProvidedCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IQueryable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IQueryable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseIQueryable(IQueryable<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRepository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRepository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseIRepository(IRepository<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRepository Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRepository Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIRepositoryReference(IRepositoryReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRequired Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRequired Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIRequiredCapability(IRequiredCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRequirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRequirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIRequirement(IRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRequirement Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRequirement Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIRequirementChange(IRequirementChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITouchpoint Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITouchpoint Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseITouchpointData(ITouchpointData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITouchpoint Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITouchpoint Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseITouchpointInstruction(ITouchpointInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITouchpoint Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITouchpoint Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseITouchpointType(ITouchpointType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IUpdate Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IUpdate Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIUpdateDescriptor(IUpdateDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVersioned Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVersioned Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIVersionedId(IVersionedId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>License</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>License</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLicense(License object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMappingRule(MappingRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metadata Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metadata Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMetadataRepository(MetadataRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing Step Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing Step Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProcessingStepDescriptor(ProcessingStepDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProperty(Map.Entry<String, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Provided Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provided Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProvidedCapability(ProvidedCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseRepository(Repository<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repository Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repository Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRepositoryReference(RepositoryReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Required Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Required Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRequiredCapability(RequiredCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRequirement(Requirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement Change</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRequirementChange(RequirementChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Artifact Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Artifact Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSimpleArtifactDescriptor(SimpleArtifactDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Artifact Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Artifact Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSimpleArtifactRepository(SimpleArtifactRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Touchpoint Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Touchpoint Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTouchpointData(TouchpointData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Touchpoint Instruction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Touchpoint Instruction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTouchpointInstruction(TouchpointInstruction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Touchpoint Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Touchpoint Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTouchpointType(TouchpointType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUpdateDescriptor(UpdateDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case P2Package.ARTIFACT_KEY: {
				ArtifactKey artifactKey = (ArtifactKey) theEObject;
				T1 result = caseArtifactKey(artifactKey);
				if (result == null)
					result = caseIArtifactKey(artifactKey);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.ARTIFACT_DESCRIPTOR: {
				ArtifactDescriptor artifactDescriptor = (ArtifactDescriptor) theEObject;
				T1 result = caseArtifactDescriptor(artifactDescriptor);
				if (result == null)
					result = caseIArtifactDescriptor(artifactDescriptor);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.ARTIFACT_REPOSITORY: {
				ArtifactRepository artifactRepository = (ArtifactRepository) theEObject;
				T1 result = caseArtifactRepository(artifactRepository);
				if (result == null)
					result = caseRepository(artifactRepository);
				if (result == null)
					result = caseIArtifactRepository(artifactRepository);
				if (result == null)
					result = caseIRepository(artifactRepository);
				if (result == null)
					result = caseIAdaptable(artifactRepository);
				if (result == null)
					result = caseIQueryable(artifactRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.ARTIFACTS_BY_KEY: {
				@SuppressWarnings("unchecked")
				Map.Entry<IArtifactKey, EList<IArtifactDescriptor>> artifactsByKey = (Map.Entry<IArtifactKey, EList<IArtifactDescriptor>>) theEObject;
				T1 result = caseArtifactsByKey(artifactsByKey);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.COMPARABLE: {
				Comparable<?> comparable = (Comparable<?>) theEObject;
				T1 result = caseComparable(comparable);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.COPYRIGHT: {
				Copyright copyright = (Copyright) theEObject;
				T1 result = caseCopyright(copyright);
				if (result == null)
					result = caseICopyright(copyright);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IADAPTABLE: {
				IAdaptable iAdaptable = (IAdaptable) theEObject;
				T1 result = caseIAdaptable(iAdaptable);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IARTIFACT_DESCRIPTOR: {
				IArtifactDescriptor iArtifactDescriptor = (IArtifactDescriptor) theEObject;
				T1 result = caseIArtifactDescriptor(iArtifactDescriptor);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IARTIFACT_KEY: {
				IArtifactKey iArtifactKey = (IArtifactKey) theEObject;
				T1 result = caseIArtifactKey(iArtifactKey);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IARTIFACT_REPOSITORY: {
				IArtifactRepository iArtifactRepository = (IArtifactRepository) theEObject;
				T1 result = caseIArtifactRepository(iArtifactRepository);
				if (result == null)
					result = caseIRepository(iArtifactRepository);
				if (result == null)
					result = caseIAdaptable(iArtifactRepository);
				if (result == null)
					result = caseIQueryable(iArtifactRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.ICOPYRIGHT: {
				ICopyright iCopyright = (ICopyright) theEObject;
				T1 result = caseICopyright(iCopyright);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IFILE_ARTIFACT_REPOSITORY: {
				IFileArtifactRepository iFileArtifactRepository = (IFileArtifactRepository) theEObject;
				T1 result = caseIFileArtifactRepository(iFileArtifactRepository);
				if (result == null)
					result = caseIArtifactRepository(iFileArtifactRepository);
				if (result == null)
					result = caseIRepository(iFileArtifactRepository);
				if (result == null)
					result = caseIAdaptable(iFileArtifactRepository);
				if (result == null)
					result = caseIQueryable(iFileArtifactRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IINSTALLABLE_UNIT: {
				IInstallableUnit iInstallableUnit = (IInstallableUnit) theEObject;
				T1 result = caseIInstallableUnit(iInstallableUnit);
				if (result == null)
					result = caseIVersionedId(iInstallableUnit);
				if (result == null)
					result = caseComparable(iInstallableUnit);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IINSTALLABLE_UNIT_FRAGMENT: {
				IInstallableUnitFragment iInstallableUnitFragment = (IInstallableUnitFragment) theEObject;
				T1 result = caseIInstallableUnitFragment(iInstallableUnitFragment);
				if (result == null)
					result = caseIInstallableUnit(iInstallableUnitFragment);
				if (result == null)
					result = caseIVersionedId(iInstallableUnitFragment);
				if (result == null)
					result = caseComparable(iInstallableUnitFragment);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IINSTALLABLE_UNIT_PATCH: {
				IInstallableUnitPatch iInstallableUnitPatch = (IInstallableUnitPatch) theEObject;
				T1 result = caseIInstallableUnitPatch(iInstallableUnitPatch);
				if (result == null)
					result = caseIInstallableUnit(iInstallableUnitPatch);
				if (result == null)
					result = caseIVersionedId(iInstallableUnitPatch);
				if (result == null)
					result = caseComparable(iInstallableUnitPatch);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.ILICENSE: {
				ILicense iLicense = (ILicense) theEObject;
				T1 result = caseILicense(iLicense);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.INSTALLABLE_UNIT: {
				InstallableUnit installableUnit = (InstallableUnit) theEObject;
				T1 result = caseInstallableUnit(installableUnit);
				if (result == null)
					result = caseIInstallableUnit(installableUnit);
				if (result == null)
					result = caseIVersionedId(installableUnit);
				if (result == null)
					result = caseComparable(installableUnit);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.INSTALLABLE_UNIT_FRAGMENT: {
				InstallableUnitFragment installableUnitFragment = (InstallableUnitFragment) theEObject;
				T1 result = caseInstallableUnitFragment(installableUnitFragment);
				if (result == null)
					result = caseInstallableUnit(installableUnitFragment);
				if (result == null)
					result = caseIInstallableUnitFragment(installableUnitFragment);
				if (result == null)
					result = caseIInstallableUnit(installableUnitFragment);
				if (result == null)
					result = caseIVersionedId(installableUnitFragment);
				if (result == null)
					result = caseComparable(installableUnitFragment);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.INSTALLABLE_UNIT_PATCH: {
				InstallableUnitPatch installableUnitPatch = (InstallableUnitPatch) theEObject;
				T1 result = caseInstallableUnitPatch(installableUnitPatch);
				if (result == null)
					result = caseInstallableUnit(installableUnitPatch);
				if (result == null)
					result = caseIInstallableUnitPatch(installableUnitPatch);
				if (result == null)
					result = caseIInstallableUnit(installableUnitPatch);
				if (result == null)
					result = caseIVersionedId(installableUnitPatch);
				if (result == null)
					result = caseComparable(installableUnitPatch);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.INSTRUCTION_MAP: {
				@SuppressWarnings("unchecked")
				Map.Entry<String, ITouchpointInstruction> instructionMap = (Map.Entry<String, ITouchpointInstruction>) theEObject;
				T1 result = caseInstructionMap(instructionMap);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IMETADATA_REPOSITORY: {
				IMetadataRepository iMetadataRepository = (IMetadataRepository) theEObject;
				T1 result = caseIMetadataRepository(iMetadataRepository);
				if (result == null)
					result = caseIRepository(iMetadataRepository);
				if (result == null)
					result = caseIAdaptable(iMetadataRepository);
				if (result == null)
					result = caseIQueryable(iMetadataRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IPROCESSING_STEP_DESCRIPTOR: {
				IProcessingStepDescriptor iProcessingStepDescriptor = (IProcessingStepDescriptor) theEObject;
				T1 result = caseIProcessingStepDescriptor(iProcessingStepDescriptor);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IPROVIDED_CAPABILITY: {
				IProvidedCapability iProvidedCapability = (IProvidedCapability) theEObject;
				T1 result = caseIProvidedCapability(iProvidedCapability);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IQUERYABLE: {
				IQueryable<?> iQueryable = (IQueryable<?>) theEObject;
				T1 result = caseIQueryable(iQueryable);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IREPOSITORY: {
				IRepository<?> iRepository = (IRepository<?>) theEObject;
				T1 result = caseIRepository(iRepository);
				if (result == null)
					result = caseIAdaptable(iRepository);
				if (result == null)
					result = caseIQueryable(iRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IREPOSITORY_REFERENCE: {
				IRepositoryReference iRepositoryReference = (IRepositoryReference) theEObject;
				T1 result = caseIRepositoryReference(iRepositoryReference);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IREQUIREMENT: {
				IRequirement iRequirement = (IRequirement) theEObject;
				T1 result = caseIRequirement(iRequirement);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IREQUIRED_CAPABILITY: {
				IRequiredCapability iRequiredCapability = (IRequiredCapability) theEObject;
				T1 result = caseIRequiredCapability(iRequiredCapability);
				if (result == null)
					result = caseIRequirement(iRequiredCapability);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IREQUIREMENT_CHANGE: {
				IRequirementChange iRequirementChange = (IRequirementChange) theEObject;
				T1 result = caseIRequirementChange(iRequirementChange);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.ITOUCHPOINT_DATA: {
				ITouchpointData iTouchpointData = (ITouchpointData) theEObject;
				T1 result = caseITouchpointData(iTouchpointData);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.ITOUCHPOINT_INSTRUCTION: {
				ITouchpointInstruction iTouchpointInstruction = (ITouchpointInstruction) theEObject;
				T1 result = caseITouchpointInstruction(iTouchpointInstruction);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.ITOUCHPOINT_TYPE: {
				ITouchpointType iTouchpointType = (ITouchpointType) theEObject;
				T1 result = caseITouchpointType(iTouchpointType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IVERSIONED_ID: {
				IVersionedId iVersionedId = (IVersionedId) theEObject;
				T1 result = caseIVersionedId(iVersionedId);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.IUPDATE_DESCRIPTOR: {
				IUpdateDescriptor iUpdateDescriptor = (IUpdateDescriptor) theEObject;
				T1 result = caseIUpdateDescriptor(iUpdateDescriptor);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.LICENSE: {
				License license = (License) theEObject;
				T1 result = caseLicense(license);
				if (result == null)
					result = caseILicense(license);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.MAPPING_RULE: {
				MappingRule mappingRule = (MappingRule) theEObject;
				T1 result = caseMappingRule(mappingRule);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.METADATA_REPOSITORY: {
				MetadataRepository metadataRepository = (MetadataRepository) theEObject;
				T1 result = caseMetadataRepository(metadataRepository);
				if (result == null)
					result = caseRepository(metadataRepository);
				if (result == null)
					result = caseIMetadataRepository(metadataRepository);
				if (result == null)
					result = caseIRepository(metadataRepository);
				if (result == null)
					result = caseIAdaptable(metadataRepository);
				if (result == null)
					result = caseIQueryable(metadataRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.PROCESSING_STEP_DESCRIPTOR: {
				ProcessingStepDescriptor processingStepDescriptor = (ProcessingStepDescriptor) theEObject;
				T1 result = caseProcessingStepDescriptor(processingStepDescriptor);
				if (result == null)
					result = caseIProcessingStepDescriptor(processingStepDescriptor);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.PROPERTY: {
				@SuppressWarnings("unchecked")
				Map.Entry<String, String> property = (Map.Entry<String, String>) theEObject;
				T1 result = caseProperty(property);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.PROVIDED_CAPABILITY: {
				ProvidedCapability providedCapability = (ProvidedCapability) theEObject;
				T1 result = caseProvidedCapability(providedCapability);
				if (result == null)
					result = caseIProvidedCapability(providedCapability);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.REPOSITORY: {
				Repository<?> repository = (Repository<?>) theEObject;
				T1 result = caseRepository(repository);
				if (result == null)
					result = caseIRepository(repository);
				if (result == null)
					result = caseIAdaptable(repository);
				if (result == null)
					result = caseIQueryable(repository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.REPOSITORY_REFERENCE: {
				RepositoryReference repositoryReference = (RepositoryReference) theEObject;
				T1 result = caseRepositoryReference(repositoryReference);
				if (result == null)
					result = caseIRepositoryReference(repositoryReference);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.REQUIRED_CAPABILITY: {
				RequiredCapability requiredCapability = (RequiredCapability) theEObject;
				T1 result = caseRequiredCapability(requiredCapability);
				if (result == null)
					result = caseRequirement(requiredCapability);
				if (result == null)
					result = caseIRequiredCapability(requiredCapability);
				if (result == null)
					result = caseIRequirement(requiredCapability);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.REQUIREMENT: {
				Requirement requirement = (Requirement) theEObject;
				T1 result = caseRequirement(requirement);
				if (result == null)
					result = caseIRequirement(requirement);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.REQUIREMENT_CHANGE: {
				RequirementChange requirementChange = (RequirementChange) theEObject;
				T1 result = caseRequirementChange(requirementChange);
				if (result == null)
					result = caseIRequirementChange(requirementChange);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.SIMPLE_ARTIFACT_REPOSITORY: {
				SimpleArtifactRepository simpleArtifactRepository = (SimpleArtifactRepository) theEObject;
				T1 result = caseSimpleArtifactRepository(simpleArtifactRepository);
				if (result == null)
					result = caseArtifactRepository(simpleArtifactRepository);
				if (result == null)
					result = caseIFileArtifactRepository(simpleArtifactRepository);
				if (result == null)
					result = caseRepository(simpleArtifactRepository);
				if (result == null)
					result = caseIArtifactRepository(simpleArtifactRepository);
				if (result == null)
					result = caseIRepository(simpleArtifactRepository);
				if (result == null)
					result = caseIAdaptable(simpleArtifactRepository);
				if (result == null)
					result = caseIQueryable(simpleArtifactRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.SIMPLE_ARTIFACT_DESCRIPTOR: {
				SimpleArtifactDescriptor simpleArtifactDescriptor = (SimpleArtifactDescriptor) theEObject;
				T1 result = caseSimpleArtifactDescriptor(simpleArtifactDescriptor);
				if (result == null)
					result = caseArtifactDescriptor(simpleArtifactDescriptor);
				if (result == null)
					result = caseIArtifactDescriptor(simpleArtifactDescriptor);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.TOUCHPOINT_DATA: {
				TouchpointData touchpointData = (TouchpointData) theEObject;
				T1 result = caseTouchpointData(touchpointData);
				if (result == null)
					result = caseITouchpointData(touchpointData);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.TOUCHPOINT_INSTRUCTION: {
				TouchpointInstruction touchpointInstruction = (TouchpointInstruction) theEObject;
				T1 result = caseTouchpointInstruction(touchpointInstruction);
				if (result == null)
					result = caseITouchpointInstruction(touchpointInstruction);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.TOUCHPOINT_TYPE: {
				TouchpointType touchpointType = (TouchpointType) theEObject;
				T1 result = caseTouchpointType(touchpointType);
				if (result == null)
					result = caseITouchpointType(touchpointType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2Package.UPDATE_DESCRIPTOR: {
				UpdateDescriptor updateDescriptor = (UpdateDescriptor) theEObject;
				T1 result = caseUpdateDescriptor(updateDescriptor);
				if (result == null)
					result = caseIUpdateDescriptor(updateDescriptor);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

} // P2Switch
