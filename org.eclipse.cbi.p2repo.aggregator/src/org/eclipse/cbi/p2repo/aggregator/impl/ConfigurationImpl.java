/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator.impl;

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.Architecture;
import org.eclipse.cbi.p2repo.aggregator.Configuration;
import org.eclipse.cbi.p2repo.aggregator.OperatingSystem;
import org.eclipse.cbi.p2repo.aggregator.WindowSystem;
import org.eclipse.cbi.p2repo.aggregator.util.GeneralUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.ConfigurationImpl#isBranchEnabled <em>Branch Enabled</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.ConfigurationImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.ConfigurationImpl#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.ConfigurationImpl#getWindowSystem <em>Window System</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.ConfigurationImpl#getArchitecture <em>Architecture</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #isBranchEnabled() <em>Branch Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBranchEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BRANCH_ENABLED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final int ENABLED_EFLAG = 1 << 0;

	/**
	 * The default value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getOperatingSystem()
	 * @generated
	 * @ordered
	 */
	protected static final OperatingSystem OPERATING_SYSTEM_EDEFAULT = OperatingSystem.WIN32;

	/**
	 * The offset of the flags representing the value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int OPERATING_SYSTEM_EFLAG_OFFSET = 1;

	/**
	 * The flags representing the default value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int OPERATING_SYSTEM_EFLAG_DEFAULT = OPERATING_SYSTEM_EDEFAULT
			.ordinal() << OPERATING_SYSTEM_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link OperatingSystem Operating System}'
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final OperatingSystem[] OPERATING_SYSTEM_EFLAG_VALUES = OperatingSystem.values();

	/**
	 * The flags representing the value of the '{@link #getOperatingSystem() <em>Operating System</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getOperatingSystem()
	 * @generated
	 * @ordered
	 */
	protected static final int OPERATING_SYSTEM_EFLAG = 0x7 << OPERATING_SYSTEM_EFLAG_OFFSET;

	/**
	 * The default value of the '{@link #getWindowSystem() <em>Window System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWindowSystem()
	 * @generated
	 * @ordered
	 */
	protected static final WindowSystem WINDOW_SYSTEM_EDEFAULT = WindowSystem.WIN32;

	/**
	 * The offset of the flags representing the value of the '{@link #getWindowSystem() <em>Window System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int WINDOW_SYSTEM_EFLAG_OFFSET = 4;

	/**
	 * The flags representing the default value of the '{@link #getWindowSystem() <em>Window System</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int WINDOW_SYSTEM_EFLAG_DEFAULT = WINDOW_SYSTEM_EDEFAULT
			.ordinal() << WINDOW_SYSTEM_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link WindowSystem Window System}'
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final WindowSystem[] WINDOW_SYSTEM_EFLAG_VALUES = WindowSystem.values();

	/**
	 * The flags representing the value of the '{@link #getWindowSystem() <em>Window System</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getWindowSystem()
	 * @generated
	 * @ordered
	 */
	protected static final int WINDOW_SYSTEM_EFLAG = 0x7 << WINDOW_SYSTEM_EFLAG_OFFSET;

	/**
	 * The default value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final Architecture ARCHITECTURE_EDEFAULT = Architecture.X86;

	/**
	 * The offset of the flags representing the value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int ARCHITECTURE_EFLAG_OFFSET = 7;

	/**
	 * The flags representing the default value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int ARCHITECTURE_EFLAG_DEFAULT = ARCHITECTURE_EDEFAULT
			.ordinal() << ARCHITECTURE_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link Architecture Architecture}' <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 * @ordered
	 */
	private static final Architecture[] ARCHITECTURE_EFLAG_VALUES = Architecture.values();

	/**
	 * The flags representing the value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final int ARCHITECTURE_EFLAG = 0xf << ARCHITECTURE_EFLAG_OFFSET;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
		eFlags |= ENABLED_EFLAG;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AggregatorPackage.CONFIGURATION__BRANCH_ENABLED:
				return isBranchEnabled();
			case AggregatorPackage.CONFIGURATION__ENABLED:
				return isEnabled();
			case AggregatorPackage.CONFIGURATION__OPERATING_SYSTEM:
				return getOperatingSystem();
			case AggregatorPackage.CONFIGURATION__WINDOW_SYSTEM:
				return getWindowSystem();
			case AggregatorPackage.CONFIGURATION__ARCHITECTURE:
				return getArchitecture();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AggregatorPackage.CONFIGURATION__BRANCH_ENABLED:
				return isSetBranchEnabled();
			case AggregatorPackage.CONFIGURATION__ENABLED:
				return ((eFlags & ENABLED_EFLAG) != 0) != ENABLED_EDEFAULT;
			case AggregatorPackage.CONFIGURATION__OPERATING_SYSTEM:
				return (eFlags & OPERATING_SYSTEM_EFLAG) != OPERATING_SYSTEM_EFLAG_DEFAULT;
			case AggregatorPackage.CONFIGURATION__WINDOW_SYSTEM:
				return (eFlags & WINDOW_SYSTEM_EFLAG) != WINDOW_SYSTEM_EFLAG_DEFAULT;
			case AggregatorPackage.CONFIGURATION__ARCHITECTURE:
				return (eFlags & ARCHITECTURE_EFLAG) != ARCHITECTURE_EFLAG_DEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AggregatorPackage.CONFIGURATION__ENABLED:
				setEnabled((Boolean) newValue);
				return;
			case AggregatorPackage.CONFIGURATION__OPERATING_SYSTEM:
				setOperatingSystem((OperatingSystem) newValue);
				return;
			case AggregatorPackage.CONFIGURATION__WINDOW_SYSTEM:
				setWindowSystem((WindowSystem) newValue);
				return;
			case AggregatorPackage.CONFIGURATION__ARCHITECTURE:
				setArchitecture((Architecture) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AggregatorPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AggregatorPackage.CONFIGURATION__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case AggregatorPackage.CONFIGURATION__OPERATING_SYSTEM:
				setOperatingSystem(OPERATING_SYSTEM_EDEFAULT);
				return;
			case AggregatorPackage.CONFIGURATION__WINDOW_SYSTEM:
				setWindowSystem(WINDOW_SYSTEM_EDEFAULT);
				return;
			case AggregatorPackage.CONFIGURATION__ARCHITECTURE:
				setArchitecture(ARCHITECTURE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Architecture getArchitecture() {
		return ARCHITECTURE_EFLAG_VALUES[(eFlags & ARCHITECTURE_EFLAG) >>> ARCHITECTURE_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getName() {
		StringBuilder bld = new StringBuilder();
		bld.append(OPERATING_SYSTEM_EFLAG_VALUES[(eFlags & OPERATING_SYSTEM_EFLAG) >>> OPERATING_SYSTEM_EFLAG_OFFSET]);
		bld.append(',');
		bld.append(WINDOW_SYSTEM_EFLAG_VALUES[(eFlags & WINDOW_SYSTEM_EFLAG) >>> WINDOW_SYSTEM_EFLAG_OFFSET]);
		bld.append(',');
		bld.append(ARCHITECTURE_EFLAG_VALUES[(eFlags & ARCHITECTURE_EFLAG) >>> ARCHITECTURE_EFLAG_OFFSET]);
		return bld.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperatingSystem getOperatingSystem() {
		return OPERATING_SYSTEM_EFLAG_VALUES[(eFlags & OPERATING_SYSTEM_EFLAG) >>> OPERATING_SYSTEM_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getOSGiEnvironmentString() {
		StringBuilder bld = new StringBuilder();
		bld.append("osgi.os="); //$NON-NLS-1$
		bld.append(OPERATING_SYSTEM_EFLAG_VALUES[(eFlags & OPERATING_SYSTEM_EFLAG) >>> OPERATING_SYSTEM_EFLAG_OFFSET]);
		bld.append(",osgi.ws="); //$NON-NLS-1$
		bld.append(WINDOW_SYSTEM_EFLAG_VALUES[(eFlags & WINDOW_SYSTEM_EFLAG) >>> WINDOW_SYSTEM_EFLAG_OFFSET]);
		bld.append(",osgi.arch="); //$NON-NLS-1$
		bld.append(ARCHITECTURE_EFLAG_VALUES[(eFlags & ARCHITECTURE_EFLAG) >>> ARCHITECTURE_EFLAG_OFFSET]);
		return bld.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WindowSystem getWindowSystem() {
		return WINDOW_SYSTEM_EFLAG_VALUES[(eFlags & WINDOW_SYSTEM_EFLAG) >>> WINDOW_SYSTEM_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isBranchEnabled() {
		return GeneralUtils.isBranchEnabled(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		return (eFlags & ENABLED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isSetBranchEnabled() {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArchitecture(Architecture newArchitecture) {
		Architecture oldArchitecture = ARCHITECTURE_EFLAG_VALUES[(eFlags
				& ARCHITECTURE_EFLAG) >>> ARCHITECTURE_EFLAG_OFFSET];
		if (newArchitecture == null)
			newArchitecture = ARCHITECTURE_EDEFAULT;
		eFlags = eFlags & ~ARCHITECTURE_EFLAG | newArchitecture.ordinal() << ARCHITECTURE_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.CONFIGURATION__ARCHITECTURE,
					oldArchitecture, newArchitecture));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = (eFlags & ENABLED_EFLAG) != 0;
		if (newEnabled)
			eFlags |= ENABLED_EFLAG;
		else
			eFlags &= ~ENABLED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.CONFIGURATION__ENABLED, oldEnabled,
					newEnabled));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperatingSystem(OperatingSystem newOperatingSystem) {
		OperatingSystem oldOperatingSystem = OPERATING_SYSTEM_EFLAG_VALUES[(eFlags
				& OPERATING_SYSTEM_EFLAG) >>> OPERATING_SYSTEM_EFLAG_OFFSET];
		if (newOperatingSystem == null)
			newOperatingSystem = OPERATING_SYSTEM_EDEFAULT;
		eFlags = eFlags & ~OPERATING_SYSTEM_EFLAG | newOperatingSystem.ordinal() << OPERATING_SYSTEM_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.CONFIGURATION__OPERATING_SYSTEM,
					oldOperatingSystem, newOperatingSystem));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWindowSystem(WindowSystem newWindowSystem) {
		WindowSystem oldWindowSystem = WINDOW_SYSTEM_EFLAG_VALUES[(eFlags
				& WINDOW_SYSTEM_EFLAG) >>> WINDOW_SYSTEM_EFLAG_OFFSET];
		if (newWindowSystem == null)
			newWindowSystem = WINDOW_SYSTEM_EDEFAULT;
		eFlags = eFlags & ~WINDOW_SYSTEM_EFLAG | newWindowSystem.ordinal() << WINDOW_SYSTEM_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.CONFIGURATION__WINDOW_SYSTEM,
					oldWindowSystem, newWindowSystem));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (enabled: ");
		result.append((eFlags & ENABLED_EFLAG) != 0);
		result.append(", operatingSystem: ");
		result.append(
				OPERATING_SYSTEM_EFLAG_VALUES[(eFlags & OPERATING_SYSTEM_EFLAG) >>> OPERATING_SYSTEM_EFLAG_OFFSET]);
		result.append(", windowSystem: ");
		result.append(WINDOW_SYSTEM_EFLAG_VALUES[(eFlags & WINDOW_SYSTEM_EFLAG) >>> WINDOW_SYSTEM_EFLAG_OFFSET]);
		result.append(", architecture: ");
		result.append(ARCHITECTURE_EFLAG_VALUES[(eFlags & ARCHITECTURE_EFLAG) >>> ARCHITECTURE_EFLAG_OFFSET]);
		result.append(')');
		return result.toString();
	}

} // ConfigurationImpl
