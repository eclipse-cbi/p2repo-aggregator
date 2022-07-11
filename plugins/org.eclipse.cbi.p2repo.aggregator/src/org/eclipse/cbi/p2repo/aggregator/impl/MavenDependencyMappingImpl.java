/**
 * Copyright (c) 2022 Eclipse Foundation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.impl;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.InfosProvider;
import org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem;
import org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.equinox.p2.metadata.VersionRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Maven Dependency Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getIuNamePattern <em>Iu Name Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getNamespacePattern <em>Namespace Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getNamePattern <em>Name Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getVersionRangePattern <em>Version Range Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenDependencyMappingImpl#getVersionRangeTemplate <em>Version Range Template</em>}</li>
 * </ul>
 *
 * @since 1.1.0
 * @generated
 */
public class MavenDependencyMappingImpl extends MinimalEObjectImpl.Container implements MavenDependencyMapping {

	private Pattern compiledIUNamePattern;

	private Pattern compiledNamespacePattern;

	private Pattern compiledNamePattern;

	private Pattern compiledVersionRangePattern;

	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getErrors() <em>Errors</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected EList<String> errors;

	/**
	 * The cached value of the '{@link #getWarnings() <em>Warnings</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarnings()
	 * @generated
	 * @ordered
	 */
	protected EList<String> warnings;

	/**
	 * The cached value of the '{@link #getInfos() <em>Infos</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<String> infos;

	/**
	 * The default value of the '{@link #getIuNamePattern() <em>Iu Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIuNamePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String IU_NAME_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIuNamePattern() <em>Iu Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIuNamePattern()
	 * @generated
	 * @ordered
	 */
	protected String iuNamePattern = IU_NAME_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamespacePattern() <em>Namespace Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespacePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespacePattern() <em>Namespace Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespacePattern()
	 * @generated
	 * @ordered
	 */
	protected String namespacePattern = NAMESPACE_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamePattern() <em>Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamePattern() <em>Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamePattern()
	 * @generated
	 * @ordered
	 */
	protected String namePattern = NAME_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected String groupId = GROUP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getArtifactId() <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifactId()
	 * @generated
	 * @ordered
	 */
	protected static final String ARTIFACT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArtifactId() <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifactId()
	 * @generated
	 * @ordered
	 */
	protected String artifactId = ARTIFACT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionRangePattern() <em>Version Range Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionRangePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_RANGE_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersionRangePattern() <em>Version Range Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionRangePattern()
	 * @generated
	 * @ordered
	 */
	protected String versionRangePattern = VERSION_RANGE_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionRangeTemplate() <em>Version Range Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionRangeTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_RANGE_TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersionRangeTemplate() <em>Version Range Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionRangeTemplate()
	 * @generated
	 * @ordered
	 */
	protected String versionRangeTemplate = VERSION_RANGE_TEMPLATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MavenDependencyMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AggregatorPackage.Literals.MAVEN_DEPENDENCY_MAPPING;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Status getStatus() {
		try {
			String iuNamePattern = StringUtils.trimmedOrNull(getIuNamePattern());
			if (iuNamePattern != null) {
				compiledNamespacePattern = Pattern.compile(iuNamePattern);
			}

			String namespacePattern = StringUtils.trimmedOrNull(getNamespacePattern());
			String namePattern = StringUtils.trimmedOrNull(getNamePattern());
			if (namePattern == null || namespacePattern == null || StringUtils.trimmedOrNull(getGroupId()) == null
					|| StringUtils.trimmedOrNull(getArtifactId()) == null) {
				return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN, "Incomplete");
			}

			compiledNamespacePattern = Pattern.compile(namespacePattern);

			compiledNamePattern = Pattern.compile(namePattern);
			MavenMappingImpl.checkReplacements(compiledNamePattern, getGroupId(), getArtifactId());

			String versionRangePattern = StringUtils.trimmedOrNull(getVersionRangePattern());
			if (versionRangePattern != null) {
				compiledVersionRangePattern = Pattern.compile(versionRangePattern);
				String versionRangeTemplate = getVersionRangeTemplate();
				if (versionRangeTemplate != null) {
					MavenMappingImpl.checkReplacements(compiledVersionRangePattern, versionRangeTemplate);
				}
			}

			return AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK);
		} catch (PatternSyntaxException e) {
			return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN, e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN, e.getMessage());
		} catch (IllegalArgumentException e) {
			return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN, e.getMessage());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getErrors() {
		if (errors == null) {
			errors = new EDataTypeUniqueEList<>(String.class, this,
					AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ERRORS);
		}
		return errors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getWarnings() {
		if (warnings == null) {
			warnings = new EDataTypeUniqueEList<>(String.class, this,
					AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__WARNINGS);
		}
		return warnings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getInfos() {
		if (infos == null) {
			infos = new EDataTypeUniqueEList<>(String.class, this,
					AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__INFOS);
		}
		return infos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIuNamePattern() {
		return iuNamePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIuNamePatternGen(String newIuNamePattern) {
		String oldIuNamePattern = iuNamePattern;
		iuNamePattern = newIuNamePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__IU_NAME_PATTERN, oldIuNamePattern, iuNamePattern));
	}

	@Override
	public void setIuNamePattern(String newIuNamePattern) {
		setIuNamePatternGen(newIuNamePattern);
		newIuNamePattern = StringUtils.trimmedOrNull(newIuNamePattern);
		if (newIuNamePattern != null) {
			try {
				compiledIUNamePattern = Pattern.compile(StringUtils.trimmedOrNull(newIuNamePattern));
			} catch (PatternSyntaxException e) {
				// ignore
			}
		} else {
			compiledIUNamePattern = null;

		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNamespacePattern() {
		return namespacePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespacePatternGen(String newNamespacePattern) {
		String oldNamespacePattern = namespacePattern;
		namespacePattern = newNamespacePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAMESPACE_PATTERN, oldNamespacePattern,
					namespacePattern));
	}

	@Override
	public void setNamespacePattern(String newNamespacePattern) {
		setNamespacePatternGen(newNamespacePattern);
		if (newNamespacePattern != null) {
			try {
				compiledNamespacePattern = Pattern.compile(StringUtils.trimmedOrNull(newNamespacePattern));
			} catch (PatternSyntaxException e) {
				// ignore
			}
		} else {
			compiledNamespacePattern = null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNamePattern() {
		return namePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamePatternGen(String newNamePattern) {
		String oldNamePattern = namePattern;
		namePattern = newNamePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAME_PATTERN, oldNamePattern, namePattern));
	}

	@Override
	public void setNamePattern(String newNamePattern) {
		setNamePatternGen(newNamePattern);
		if (newNamePattern != null) {
			try {
				compiledNamePattern = Pattern.compile(StringUtils.trimmedOrNull(newNamePattern));
			} catch (PatternSyntaxException e) {
				// ignore
			}
		} else {
			compiledNamePattern = null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGroupId() {
		return groupId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroupId(String newGroupId) {
		String oldGroupId = groupId;
		groupId = newGroupId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__GROUP_ID,
					oldGroupId, groupId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getArtifactId() {
		return artifactId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArtifactId(String newArtifactId) {
		String oldArtifactId = artifactId;
		artifactId = newArtifactId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ARTIFACT_ID, oldArtifactId, artifactId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersionRangePattern() {
		return versionRangePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionRangePatternGen(String newVersionRangePattern) {
		String oldVersionRangePattern = versionRangePattern;
		versionRangePattern = newVersionRangePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_PATTERN, oldVersionRangePattern,
					versionRangePattern));
	}

	@Override
	public void setVersionRangePattern(String newVersionRangePattern) {
		setVersionRangePatternGen(newVersionRangePattern);
		if (newVersionRangePattern != null) {
			try {
				compiledVersionRangePattern = Pattern.compile(StringUtils.trimmedOrNull(newVersionRangePattern));
			} catch (PatternSyntaxException e) {
				// ignore
			}
		} else {
			compiledVersionRangePattern = null;
		}

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersionRangeTemplate() {
		return versionRangeTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionRangeTemplate(String newVersionRangeTemplate) {
		String oldVersionRangeTemplate = versionRangeTemplate;
		versionRangeTemplate = newVersionRangeTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_TEMPLATE, oldVersionRangeTemplate,
					versionRangeTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public MavenDependencyItem map(String iuName, String requirementNamespace, String requirementName,
			VersionRange versionRange) {
		if ((compiledIUNamePattern == null || compiledIUNamePattern.matcher(iuName).matches())
				&& compiledNamespacePattern.matcher(requirementNamespace).matches()) {
			Matcher matcher = compiledNamePattern.matcher(requirementName);
			if (matcher.matches()) {
				MavenDependencyItem item = AggregatorFactory.eINSTANCE.createMavenDependencyItem();
				item.setGroupId(matcher.replaceFirst(getGroupId()));
				item.setArtifactId(matcher.replaceFirst(getArtifactId()));
				item.setMavenDependencyMapping(this);
				if (compiledVersionRangePattern != null) {
					Matcher versionRangeMatcher = compiledVersionRangePattern.matcher(versionRange.toString());
					if (versionRangeMatcher.matches()) {
						if (versionRangeTemplate != null) {
							String replacement = versionRangeMatcher.replaceFirst(versionRangeTemplate);
							item.setMappedVersionRange(replacement);
						}
					} else {
						return null;
					}
				}
				return item;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__STATUS:
				return getStatus();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ERRORS:
				return getErrors();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__WARNINGS:
				return getWarnings();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__INFOS:
				return getInfos();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__IU_NAME_PATTERN:
				return getIuNamePattern();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAMESPACE_PATTERN:
				return getNamespacePattern();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAME_PATTERN:
				return getNamePattern();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__GROUP_ID:
				return getGroupId();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ARTIFACT_ID:
				return getArtifactId();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_PATTERN:
				return getVersionRangePattern();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_TEMPLATE:
				return getVersionRangeTemplate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ERRORS:
				getErrors().clear();
				getErrors().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__WARNINGS:
				getWarnings().clear();
				getWarnings().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__INFOS:
				getInfos().clear();
				getInfos().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__IU_NAME_PATTERN:
				setIuNamePattern((String) newValue);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAMESPACE_PATTERN:
				setNamespacePattern((String) newValue);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAME_PATTERN:
				setNamePattern((String) newValue);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__GROUP_ID:
				setGroupId((String) newValue);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ARTIFACT_ID:
				setArtifactId((String) newValue);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_PATTERN:
				setVersionRangePattern((String) newValue);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_TEMPLATE:
				setVersionRangeTemplate((String) newValue);
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
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ERRORS:
				getErrors().clear();
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__WARNINGS:
				getWarnings().clear();
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__INFOS:
				getInfos().clear();
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__IU_NAME_PATTERN:
				setIuNamePattern(IU_NAME_PATTERN_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAMESPACE_PATTERN:
				setNamespacePattern(NAMESPACE_PATTERN_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAME_PATTERN:
				setNamePattern(NAME_PATTERN_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__GROUP_ID:
				setGroupId(GROUP_ID_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ARTIFACT_ID:
				setArtifactId(ARTIFACT_ID_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_PATTERN:
				setVersionRangePattern(VERSION_RANGE_PATTERN_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_TEMPLATE:
				setVersionRangeTemplate(VERSION_RANGE_TEMPLATE_EDEFAULT);
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
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__STATUS:
				return getStatus() != null;
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ERRORS:
				return errors != null && !errors.isEmpty();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__WARNINGS:
				return warnings != null && !warnings.isEmpty();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__INFOS:
				return infos != null && !infos.isEmpty();
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__IU_NAME_PATTERN:
				return IU_NAME_PATTERN_EDEFAULT == null ? iuNamePattern != null
						: !IU_NAME_PATTERN_EDEFAULT.equals(iuNamePattern);
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAMESPACE_PATTERN:
				return NAMESPACE_PATTERN_EDEFAULT == null ? namespacePattern != null
						: !NAMESPACE_PATTERN_EDEFAULT.equals(namespacePattern);
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAME_PATTERN:
				return NAME_PATTERN_EDEFAULT == null ? namePattern != null : !NAME_PATTERN_EDEFAULT.equals(namePattern);
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__GROUP_ID:
				return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ARTIFACT_ID:
				return ARTIFACT_ID_EDEFAULT == null ? artifactId != null : !ARTIFACT_ID_EDEFAULT.equals(artifactId);
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_PATTERN:
				return VERSION_RANGE_PATTERN_EDEFAULT == null ? versionRangePattern != null
						: !VERSION_RANGE_PATTERN_EDEFAULT.equals(versionRangePattern);
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_TEMPLATE:
				return VERSION_RANGE_TEMPLATE_EDEFAULT == null ? versionRangeTemplate != null
						: !VERSION_RANGE_TEMPLATE_EDEFAULT.equals(versionRangeTemplate);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == InfosProvider.class) {
			switch (derivedFeatureID) {
				case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ERRORS:
					return AggregatorPackage.INFOS_PROVIDER__ERRORS;
				case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__WARNINGS:
					return AggregatorPackage.INFOS_PROVIDER__WARNINGS;
				case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__INFOS:
					return AggregatorPackage.INFOS_PROVIDER__INFOS;
				default:
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == InfosProvider.class) {
			switch (baseFeatureID) {
				case AggregatorPackage.INFOS_PROVIDER__ERRORS:
					return AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ERRORS;
				case AggregatorPackage.INFOS_PROVIDER__WARNINGS:
					return AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__WARNINGS;
				case AggregatorPackage.INFOS_PROVIDER__INFOS:
					return AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__INFOS;
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (errors: ");
		result.append(errors);
		result.append(", warnings: ");
		result.append(warnings);
		result.append(", infos: ");
		result.append(infos);
		result.append(", iuNamePattern: ");
		result.append(iuNamePattern);
		result.append(", namespacePattern: ");
		result.append(namespacePattern);
		result.append(", namePattern: ");
		result.append(namePattern);
		result.append(", groupId: ");
		result.append(groupId);
		result.append(", artifactId: ");
		result.append(artifactId);
		result.append(", versionRangePattern: ");
		result.append(versionRangePattern);
		result.append(", versionRangeTemplate: ");
		result.append(versionRangeTemplate);
		result.append(')');
		return result.toString();
	}

} // MavenDependencyMappingImpl
