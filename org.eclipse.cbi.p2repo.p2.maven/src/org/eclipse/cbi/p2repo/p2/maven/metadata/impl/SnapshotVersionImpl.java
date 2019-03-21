/**
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata.impl;

import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Snapshot Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl#getUpdated <em>Updated</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SnapshotVersionImpl extends EObjectImpl implements SnapshotVersion {
	/**
	 * The default value of the '{@link #getClassifier() <em>Classifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifier()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSIFIER_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifier()
	 * @generated
	 * @ordered
	 */
	protected String classifier = CLASSIFIER_EDEFAULT;

	/**
	 * This is true if the Classifier attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean classifierESet;

	/**
	 * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected String extension = EXTENSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpdated() <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final String UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpdated() <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdated()
	 * @generated
	 * @ordered
	 */
	protected String updated = UPDATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnapshotVersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetadataPackage.Literals.SNAPSHOT_VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClassifier() {
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassifier(String newClassifier) {
		String oldClassifier = classifier;
		classifier = newClassifier;
		boolean oldClassifierESet = classifierESet;
		classifierESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SNAPSHOT_VERSION__CLASSIFIER,
					oldClassifier, classifier, !oldClassifierESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetClassifier() {
		String oldClassifier = classifier;
		boolean oldClassifierESet = classifierESet;
		classifier = CLASSIFIER_EDEFAULT;
		classifierESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetadataPackage.SNAPSHOT_VERSION__CLASSIFIER,
					oldClassifier, CLASSIFIER_EDEFAULT, oldClassifierESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClassifier() {
		return classifierESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtension(String newExtension) {
		String oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SNAPSHOT_VERSION__EXTENSION,
					oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SNAPSHOT_VERSION__VALUE, oldValue,
					value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUpdated() {
		return updated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpdated(String newUpdated) {
		String oldUpdated = updated;
		updated = newUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SNAPSHOT_VERSION__UPDATED, oldUpdated,
					updated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetadataPackage.SNAPSHOT_VERSION__CLASSIFIER:
				return getClassifier();
			case MetadataPackage.SNAPSHOT_VERSION__EXTENSION:
				return getExtension();
			case MetadataPackage.SNAPSHOT_VERSION__VALUE:
				return getValue();
			case MetadataPackage.SNAPSHOT_VERSION__UPDATED:
				return getUpdated();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetadataPackage.SNAPSHOT_VERSION__CLASSIFIER:
				setClassifier((String) newValue);
				return;
			case MetadataPackage.SNAPSHOT_VERSION__EXTENSION:
				setExtension((String) newValue);
				return;
			case MetadataPackage.SNAPSHOT_VERSION__VALUE:
				setValue((String) newValue);
				return;
			case MetadataPackage.SNAPSHOT_VERSION__UPDATED:
				setUpdated((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetadataPackage.SNAPSHOT_VERSION__CLASSIFIER:
				unsetClassifier();
				return;
			case MetadataPackage.SNAPSHOT_VERSION__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
				return;
			case MetadataPackage.SNAPSHOT_VERSION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case MetadataPackage.SNAPSHOT_VERSION__UPDATED:
				setUpdated(UPDATED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetadataPackage.SNAPSHOT_VERSION__CLASSIFIER:
				return isSetClassifier();
			case MetadataPackage.SNAPSHOT_VERSION__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
			case MetadataPackage.SNAPSHOT_VERSION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case MetadataPackage.SNAPSHOT_VERSION__UPDATED:
				return UPDATED_EDEFAULT == null ? updated != null : !UPDATED_EDEFAULT.equals(updated);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (classifier: ");
		if (classifierESet)
			result.append(classifier);
		else
			result.append("<unset>");
		result.append(", extension: ");
		result.append(extension);
		result.append(", value: ");
		result.append(value);
		result.append(", updated: ");
		result.append(updated);
		result.append(')');
		return result.toString();
	}

} //SnapshotVersionImpl
