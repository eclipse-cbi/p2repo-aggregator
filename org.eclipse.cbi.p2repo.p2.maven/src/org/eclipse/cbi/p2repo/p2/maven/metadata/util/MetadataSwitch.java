/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata.util;

import org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin;
import org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning;
import org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage
 * @generated
 */
public class MetadataSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetadataPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public MetadataSwitch() {
		if (modelPackage == null) {
			modelPackage = MetadataPackage.eINSTANCE;
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta
	 * Data</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta
	 *         Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaData(MetaData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlugin(Plugin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plugins Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plugins Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePluginsType(PluginsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Versioning</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Versioning</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVersioning(Versioning object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Versions Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Versions Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVersionsType(VersionsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshot(Snapshot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshotVersion(SnapshotVersion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot Versions Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot Versions Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshotVersionsType(SnapshotVersionsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MetadataPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot) theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case MetadataPackage.META_DATA: {
				MetaData metaData = (MetaData) theEObject;
				T result = caseMetaData(metaData);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case MetadataPackage.PLUGIN: {
				Plugin plugin = (Plugin) theEObject;
				T result = casePlugin(plugin);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case MetadataPackage.PLUGINS_TYPE: {
				PluginsType pluginsType = (PluginsType) theEObject;
				T result = casePluginsType(pluginsType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case MetadataPackage.SNAPSHOT: {
				Snapshot snapshot = (Snapshot) theEObject;
				T result = caseSnapshot(snapshot);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case MetadataPackage.SNAPSHOT_VERSION: {
				SnapshotVersion snapshotVersion = (SnapshotVersion) theEObject;
				T result = caseSnapshotVersion(snapshotVersion);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case MetadataPackage.SNAPSHOT_VERSIONS_TYPE: {
				SnapshotVersionsType snapshotVersionsType = (SnapshotVersionsType) theEObject;
				T result = caseSnapshotVersionsType(snapshotVersionsType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case MetadataPackage.VERSIONING: {
				Versioning versioning = (Versioning) theEObject;
				T result = caseVersioning(versioning);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case MetadataPackage.VERSIONS_TYPE: {
				VersionsType versionsType = (VersionsType) theEObject;
				T result = caseVersionsType(versionsType);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param ePackage
	 *            the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

} // MetadataSwitch
