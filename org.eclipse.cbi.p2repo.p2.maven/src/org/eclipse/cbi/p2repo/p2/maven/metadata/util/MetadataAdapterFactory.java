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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage
 * @generated
 */
public class MetadataAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetadataPackage modelPackage;

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetadataSwitch<Adapter> modelSwitch = new MetadataSwitch<>() {
		@Override
		public Adapter caseDocumentRoot(DocumentRoot object) {
			return createDocumentRootAdapter();
		}

		@Override
		public Adapter caseMetaData(MetaData object) {
			return createMetaDataAdapter();
		}

		@Override
		public Adapter casePlugin(Plugin object) {
			return createPluginAdapter();
		}

		@Override
		public Adapter casePluginsType(PluginsType object) {
			return createPluginsTypeAdapter();
		}

		@Override
		public Adapter caseSnapshot(Snapshot object) {
			return createSnapshotAdapter();
		}

		@Override
		public Adapter caseSnapshotVersion(SnapshotVersion object) {
			return createSnapshotVersionAdapter();
		}

		@Override
		public Adapter caseSnapshotVersionsType(SnapshotVersionsType object) {
			return createSnapshotVersionsTypeAdapter();
		}

		@Override
		public Adapter caseVersioning(Versioning object) {
			return createVersioningAdapter();
		}

		@Override
		public Adapter caseVersionsType(VersionsType object) {
			return createVersionsTypeAdapter();
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
	public MetadataAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MetadataPackage.eINSTANCE;
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData
	 * @generated
	 */
	public Adapter createMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin
	 * @generated
	 */
	public Adapter createPluginAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType <em>Plugins Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType
	 * @generated
	 */
	public Adapter createPluginsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning <em>Versioning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning
	 * @generated
	 */
	public Adapter createVersioningAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType <em>Versions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType
	 * @generated
	 */
	public Adapter createVersionsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot
	 * @generated
	 */
	public Adapter createSnapshotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion <em>Snapshot Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion
	 * @generated
	 */
	public Adapter createSnapshotVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType <em>Snapshot Versions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType
	 * @generated
	 */
	public Adapter createSnapshotVersionsTypeAdapter() {
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

} // MetadataAdapterFactory
