/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator.impl;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.InfosProvider;
import org.eclipse.cbi.p2repo.aggregator.MavenItem;
import org.eclipse.cbi.p2repo.aggregator.MavenMapping;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.equinox.p2.metadata.Version;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Maven Mapping</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl#getNamePattern <em>Name Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl#getVersionPattern <em>Version Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl#getVersionTemplate <em>Version Template</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MavenMappingImpl extends MinimalEObjectImpl.Container implements MavenMapping {

	static final String MAVEN_SOURCES_CLASSIFIER = "sources";

	private static final String P2_SOURCE_SUFFIX = ".source";

	private Pattern compiledPattern;

	private Pattern compiledVersionPattern;

	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getErrors() <em>Errors</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected EList<String> errors;

	/**
	 * The cached value of the '{@link #getWarnings() <em>Warnings</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getWarnings()
	 * @generated
	 * @ordered
	 */
	protected EList<String> warnings;

	/**
	 * The cached value of the '{@link #getInfos() <em>Infos</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<String> infos;

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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getNamePattern()
	 * @generated
	 * @ordered
	 */
	protected String namePattern = NAME_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected String groupId = GROUP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getArtifactId() <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getArtifactId()
	 * @generated
	 * @ordered
	 */
	protected static final String ARTIFACT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArtifactId() <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getArtifactId()
	 * @generated
	 * @ordered
	 */
	protected String artifactId = ARTIFACT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionPattern() <em>Version Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersionPattern() <em>Version Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionPattern()
	 * @generated
	 * @ordered
	 */
	protected String versionPattern = VERSION_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionTemplate() <em>Version Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersionTemplate() <em>Version Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionTemplate()
	 * @generated
	 * @ordered
	 */
	protected String versionTemplate = VERSION_TEMPLATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MavenMappingImpl() {
		super();
	}

	public MavenMappingImpl(String namePattern, String groupId, String artifactId) {
		setNamePattern(namePattern);
		setGroupId(groupId);
		setArtifactId(artifactId);
	}

	private void checkReplacements(Pattern pattern, String... replacements) {
		String emptyString = "";
		String auxGroup = "(.*)";
		Matcher matcher = compiledPattern.matcher(emptyString);
		StringBuilder auxPatternBuilder = new StringBuilder();
		for (int i = matcher.groupCount(); i > 0; i--)
			auxPatternBuilder.append(auxGroup);

		Pattern auxPattern = Pattern.compile(auxPatternBuilder.toString());
		Matcher auxMatcher = auxPattern.matcher(emptyString);
		for (String replacement : replacements)
			auxMatcher.replaceAll(replacement);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == InfosProvider.class) {
			switch (derivedFeatureID) {
				case AggregatorPackage.MAVEN_MAPPING__ERRORS:
					return AggregatorPackage.INFOS_PROVIDER__ERRORS;
				case AggregatorPackage.MAVEN_MAPPING__WARNINGS:
					return AggregatorPackage.INFOS_PROVIDER__WARNINGS;
				case AggregatorPackage.MAVEN_MAPPING__INFOS:
					return AggregatorPackage.INFOS_PROVIDER__INFOS;
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
		if (baseClass == InfosProvider.class) {
			switch (baseFeatureID) {
				case AggregatorPackage.INFOS_PROVIDER__ERRORS:
					return AggregatorPackage.MAVEN_MAPPING__ERRORS;
				case AggregatorPackage.INFOS_PROVIDER__WARNINGS:
					return AggregatorPackage.MAVEN_MAPPING__WARNINGS;
				case AggregatorPackage.INFOS_PROVIDER__INFOS:
					return AggregatorPackage.MAVEN_MAPPING__INFOS;
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
			case AggregatorPackage.MAVEN_MAPPING__STATUS:
				return getStatus();
			case AggregatorPackage.MAVEN_MAPPING__ERRORS:
				return getErrors();
			case AggregatorPackage.MAVEN_MAPPING__WARNINGS:
				return getWarnings();
			case AggregatorPackage.MAVEN_MAPPING__INFOS:
				return getInfos();
			case AggregatorPackage.MAVEN_MAPPING__NAME_PATTERN:
				return getNamePattern();
			case AggregatorPackage.MAVEN_MAPPING__GROUP_ID:
				return getGroupId();
			case AggregatorPackage.MAVEN_MAPPING__ARTIFACT_ID:
				return getArtifactId();
			case AggregatorPackage.MAVEN_MAPPING__VERSION_PATTERN:
				return getVersionPattern();
			case AggregatorPackage.MAVEN_MAPPING__VERSION_TEMPLATE:
				return getVersionTemplate();
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
			case AggregatorPackage.MAVEN_MAPPING__STATUS:
				return getStatus() != null;
			case AggregatorPackage.MAVEN_MAPPING__ERRORS:
				return errors != null && !errors.isEmpty();
			case AggregatorPackage.MAVEN_MAPPING__WARNINGS:
				return warnings != null && !warnings.isEmpty();
			case AggregatorPackage.MAVEN_MAPPING__INFOS:
				return infos != null && !infos.isEmpty();
			case AggregatorPackage.MAVEN_MAPPING__NAME_PATTERN:
				return NAME_PATTERN_EDEFAULT == null ? namePattern != null : !NAME_PATTERN_EDEFAULT.equals(namePattern);
			case AggregatorPackage.MAVEN_MAPPING__GROUP_ID:
				return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
			case AggregatorPackage.MAVEN_MAPPING__ARTIFACT_ID:
				return ARTIFACT_ID_EDEFAULT == null ? artifactId != null : !ARTIFACT_ID_EDEFAULT.equals(artifactId);
			case AggregatorPackage.MAVEN_MAPPING__VERSION_PATTERN:
				return VERSION_PATTERN_EDEFAULT == null ? versionPattern != null
						: !VERSION_PATTERN_EDEFAULT.equals(versionPattern);
			case AggregatorPackage.MAVEN_MAPPING__VERSION_TEMPLATE:
				return VERSION_TEMPLATE_EDEFAULT == null ? versionTemplate != null
						: !VERSION_TEMPLATE_EDEFAULT.equals(versionTemplate);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AggregatorPackage.MAVEN_MAPPING__ERRORS:
				getErrors().clear();
				getErrors().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.MAVEN_MAPPING__WARNINGS:
				getWarnings().clear();
				getWarnings().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.MAVEN_MAPPING__INFOS:
				getInfos().clear();
				getInfos().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.MAVEN_MAPPING__NAME_PATTERN:
				setNamePattern((String) newValue);
				return;
			case AggregatorPackage.MAVEN_MAPPING__GROUP_ID:
				setGroupId((String) newValue);
				return;
			case AggregatorPackage.MAVEN_MAPPING__ARTIFACT_ID:
				setArtifactId((String) newValue);
				return;
			case AggregatorPackage.MAVEN_MAPPING__VERSION_PATTERN:
				setVersionPattern((String) newValue);
				return;
			case AggregatorPackage.MAVEN_MAPPING__VERSION_TEMPLATE:
				setVersionTemplate((String) newValue);
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
		return AggregatorPackage.Literals.MAVEN_MAPPING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AggregatorPackage.MAVEN_MAPPING__ERRORS:
				getErrors().clear();
				return;
			case AggregatorPackage.MAVEN_MAPPING__WARNINGS:
				getWarnings().clear();
				return;
			case AggregatorPackage.MAVEN_MAPPING__INFOS:
				getInfos().clear();
				return;
			case AggregatorPackage.MAVEN_MAPPING__NAME_PATTERN:
				setNamePattern(NAME_PATTERN_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_MAPPING__GROUP_ID:
				setGroupId(GROUP_ID_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_MAPPING__ARTIFACT_ID:
				setArtifactId(ARTIFACT_ID_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_MAPPING__VERSION_PATTERN:
				setVersionPattern(VERSION_PATTERN_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_MAPPING__VERSION_TEMPLATE:
				setVersionTemplate(VERSION_TEMPLATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getArtifactId() {
		return artifactId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getErrors() {
		if (errors == null) {
			errors = new EDataTypeUniqueEList<>(String.class, this, AggregatorPackage.MAVEN_MAPPING__ERRORS);
		}
		return errors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGroupId() {
		return groupId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getInfos() {
		if (infos == null) {
			infos = new EDataTypeUniqueEList<>(String.class, this, AggregatorPackage.MAVEN_MAPPING__INFOS);
		}
		return infos;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNamePattern() {
		return namePattern;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Status getStatus() {
		try {
			String pattern = StringUtils.trimmedOrNull(getNamePattern());
			if (pattern == null || StringUtils.trimmedOrNull(getGroupId()) == null
					|| StringUtils.trimmedOrNull(getArtifactId()) == null)
				return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN);

			compiledPattern = Pattern.compile(pattern);
			checkReplacements(compiledPattern, getGroupId(), getArtifactId());
			return AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK);
		} catch (PatternSyntaxException e) {
			return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN);
		} catch (IndexOutOfBoundsException e) {
			return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersionPattern() {
		return versionPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersionTemplate() {
		return versionTemplate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getWarnings() {
		if (warnings == null) {
			warnings = new EDataTypeUniqueEList<>(String.class, this, AggregatorPackage.MAVEN_MAPPING__WARNINGS);
		}
		return warnings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public MavenItem map(String installableUnitID, Version version) {
		if (compiledPattern != null) {
			// map osgi name suffix ".source" to maven classifier "sources":
			boolean isSource = installableUnitID.endsWith(P2_SOURCE_SUFFIX);
			if (isSource) {
				installableUnitID = installableUnitID.substring(0,
						installableUnitID.length() - P2_SOURCE_SUFFIX.length());
			}

			Matcher m = compiledPattern.matcher(installableUnitID);
			if (m.matches()) {
				MavenItem item = AggregatorFactory.eINSTANCE.createMavenItem();
				item.setGroupId(m.replaceFirst(getGroupId()));
				item.setArtifactId(m.replaceFirst(getArtifactId()));
				item.setMavenMapping(this);
				if (isSource) {
					item.setClassifier(MAVEN_SOURCES_CLASSIFIER);
				}
				String mappedVersion = mapVersion(version);
				if (mappedVersion != null) {
					item.setMappedVersion(mappedVersion);
				}
				return item;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String mapVersion(Version version) {
		if (this.versionPattern != null && this.versionTemplate != null) {
			if (this.compiledVersionPattern == null)
				this.compiledVersionPattern = Pattern.compile(this.versionPattern);
			Matcher vm = this.compiledVersionPattern.matcher(version.getOriginal());
			if (vm.matches()) {
				return vm.replaceFirst(this.versionTemplate);
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArtifactId(String newArtifactId) {
		String oldArtifactId = artifactId;
		artifactId = newArtifactId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_MAPPING__ARTIFACT_ID,
					oldArtifactId, artifactId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroupId(String newGroupId) {
		String oldGroupId = groupId;
		groupId = newGroupId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_MAPPING__GROUP_ID, oldGroupId,
					groupId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void setNamePattern(String newNamePattern) {
		String oldNamePattern = namePattern;
		namePattern = newNamePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_MAPPING__NAME_PATTERN,
					oldNamePattern, namePattern));

		if (newNamePattern != null) {
			if (!newNamePattern.equals(oldNamePattern))
				try {
					compiledPattern = Pattern.compile(StringUtils.trimmedOrNull(newNamePattern));
				} catch (PatternSyntaxException e) {
					// ignore
				}
		} else
			compiledPattern = null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionPattern(String newVersionPattern) {
		String oldVersionPattern = versionPattern;
		versionPattern = newVersionPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_MAPPING__VERSION_PATTERN,
					oldVersionPattern, versionPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionTemplate(String newVersionTemplate) {
		String oldVersionTemplate = versionTemplate;
		versionTemplate = newVersionTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_MAPPING__VERSION_TEMPLATE,
					oldVersionTemplate, versionTemplate));
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
		result.append(" (errors: ");
		result.append(errors);
		result.append(", warnings: ");
		result.append(warnings);
		result.append(", infos: ");
		result.append(infos);
		result.append(", namePattern: ");
		result.append(namePattern);
		result.append(", groupId: ");
		result.append(groupId);
		result.append(", artifactId: ");
		result.append(artifactId);
		result.append(", versionPattern: ");
		result.append(versionPattern);
		result.append(", versionTemplate: ");
		result.append(versionTemplate);
		result.append(')');
		return result.toString();
	}

} // MavenMappingImpl
