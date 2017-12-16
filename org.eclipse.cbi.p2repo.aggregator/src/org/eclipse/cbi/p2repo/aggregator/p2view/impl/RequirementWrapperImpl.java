/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator.p2view.impl;

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.LabelProvider;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.RequirementWrapper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;
import org.osgi.framework.Filter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Requirement Wrapper</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RequirementWrapperImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RequirementWrapperImpl#getMax <em>Max</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RequirementWrapperImpl#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RequirementWrapperImpl#getMatches <em>Matches</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RequirementWrapperImpl#isGreedy <em>Greedy</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RequirementWrapperImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RequirementWrapperImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RequirementWrapperImpl#getGenuine <em>Genuine</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementWrapperImpl extends MinimalEObjectImpl.Container implements RequirementWrapper {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected IMatchExpression<IInstallableUnit> filter;

	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected int max = MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected int min = MIN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMatches() <em>Matches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatches()
	 * @generated
	 * @ordered
	 */
	protected IMatchExpression<IInstallableUnit> matches;

	/**
	 * The default value of the '{@link #isGreedy() <em>Greedy</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isGreedy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GREEDY_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isGreedy() <em>Greedy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGreedy()
	 * @generated
	 * @ordered
	 */
	protected static final int GREEDY_EFLAG = 1 << 0;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGenuine() <em>Genuine</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getGenuine()
	 * @generated
	 * @ordered
	 */
	protected IRequirement genuine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementWrapperImpl() {
		super();
		eFlags |= GREEDY_EFLAG;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected RequirementWrapperImpl(IRequirement req) {
		super();
		genuine = req;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == LabelProvider.class) {
			switch (derivedFeatureID) {
				case P2viewPackage.REQUIREMENT_WRAPPER__LABEL:
					return AggregatorPackage.LABEL_PROVIDER__LABEL;
				default:
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == LabelProvider.class) {
			switch (baseFeatureID) {
				case AggregatorPackage.LABEL_PROVIDER__LABEL:
					return P2viewPackage.REQUIREMENT_WRAPPER__LABEL;
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2viewPackage.REQUIREMENT_WRAPPER__FILTER:
				return getFilter();
			case P2viewPackage.REQUIREMENT_WRAPPER__MAX:
				return getMax();
			case P2viewPackage.REQUIREMENT_WRAPPER__MIN:
				return getMin();
			case P2viewPackage.REQUIREMENT_WRAPPER__MATCHES:
				return getMatches();
			case P2viewPackage.REQUIREMENT_WRAPPER__GREEDY:
				return isGreedy();
			case P2viewPackage.REQUIREMENT_WRAPPER__DESCRIPTION:
				return getDescription();
			case P2viewPackage.REQUIREMENT_WRAPPER__LABEL:
				return getLabel();
			case P2viewPackage.REQUIREMENT_WRAPPER__GENUINE:
				return getGenuine();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case P2viewPackage.REQUIREMENT_WRAPPER__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case P2viewPackage.REQUIREMENT_WRAPPER__GENUINE:
				return genuine != null;
			default:
				return ((InternalEObject) genuine).eIsSet(featureID);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2viewPackage.REQUIREMENT_WRAPPER__FILTER:
				setFilter((IMatchExpression<IInstallableUnit>) newValue);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__MAX:
				setMax((Integer) newValue);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__MIN:
				setMin((Integer) newValue);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__MATCHES:
				setMatches((IMatchExpression<IInstallableUnit>) newValue);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__GREEDY:
				setGreedy((Boolean) newValue);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__LABEL:
				setLabel((String) newValue);
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
		return P2viewPackage.Literals.REQUIREMENT_WRAPPER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2viewPackage.REQUIREMENT_WRAPPER__FILTER:
				setFilter((IMatchExpression<IInstallableUnit>) null);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__MAX:
				setMax(MAX_EDEFAULT);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__MIN:
				setMin(MIN_EDEFAULT);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__MATCHES:
				setMatches((IMatchExpression<IInstallableUnit>) null);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__GREEDY:
				setGreedy(GREEDY_EDEFAULT);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case P2viewPackage.REQUIREMENT_WRAPPER__LABEL:
				setLabel(LABEL_EDEFAULT);
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
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IMatchExpression<IInstallableUnit> getFilter() {
		return genuine.getFilter();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IRequirement getGenuine() {
		return genuine;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IMatchExpression<IInstallableUnit> getMatches() {
		return genuine.getMatches();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public int getMax() {
		return genuine.getMax();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public int getMin() {
		return genuine.getMin();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isGreedy() {
		return genuine.isGreedy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isMatch(IInstallableUnit installableUnit) {
		return genuine.isMatch(installableUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.REQUIREMENT_WRAPPER__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public void setFilter(Filter newFilter) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter(IMatchExpression<IInstallableUnit> newFilter) {
		IMatchExpression<IInstallableUnit> oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.REQUIREMENT_WRAPPER__FILTER, oldFilter,
					filter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public void setGreedy(boolean newGreedy) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.REQUIREMENT_WRAPPER__LABEL, oldLabel,
					label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatches(IMatchExpression<IInstallableUnit> newMatches) {
		IMatchExpression<IInstallableUnit> oldMatches = matches;
		matches = newMatches;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.REQUIREMENT_WRAPPER__MATCHES,
					oldMatches, matches));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public void setMax(int newMax) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public void setMin(int newMin) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (filter: ");
		result.append(getFilter());
		result.append(", min: ");
		result.append(getMin());
		result.append(", max: ");
		result.append(getMax());
		result.append(", greedy: ");
		result.append(isGreedy());
		result.append(", label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} // RequirementWrapperImpl
