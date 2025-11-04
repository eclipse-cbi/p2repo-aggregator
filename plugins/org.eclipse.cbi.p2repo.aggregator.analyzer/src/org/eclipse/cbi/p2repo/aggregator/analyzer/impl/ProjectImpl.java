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
package org.eclipse.cbi.p2repo.aggregator.analyzer.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Project;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getSite <em>Site</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getNews <em>News</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getReleaseDate <em>Release Date</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getRank <em>Rank</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getContribution <em>Contribution</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ProjectImpl#getSubprojects <em>Subprojects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends MinimalEObjectImpl.Container implements Project {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSite() <em>Site</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSite()
	 * @generated
	 * @ordered
	 */
	protected static final URI SITE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSite() <em>Site</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSite()
	 * @generated
	 * @ordered
	 */
	protected URI site = SITE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final URI VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected URI version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNews() <em>News</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNews()
	 * @generated
	 * @ordered
	 */
	protected static final URI NEWS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNews() <em>News</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNews()
	 * @generated
	 * @ordered
	 */
	protected URI news = NEWS_EDEFAULT;

	/**
	 * The default value of the '{@link #getReleaseDate() <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date RELEASE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReleaseDate() <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseDate()
	 * @generated
	 * @ordered
	 */
	protected Date releaseDate = RELEASE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRank() <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRank()
	 * @generated
	 * @ordered
	 */
	protected static final int RANK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRank() <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRank()
	 * @generated
	 * @ordered
	 */
	protected int rank = RANK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tags;

	/**
	 * The cached value of the '{@link #getRepositories() <em>Repositories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositories()
	 * @generated
	 * @ordered
	 */
	protected EList<GitRepository> repositories;

	/**
	 * The cached value of the '{@link #getSubprojects() <em>Subprojects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubprojects()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> subprojects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public URI getSite() {
		return site;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSite(URI newSite) {
		URI oldSite = site;
		site = newSite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT__SITE, oldSite, site));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public URI getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(URI newVersion) {
		URI oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT__VERSION, oldVersion,
					version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public URI getNews() {
		return news;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNews(URI newNews) {
		URI oldNews = news;
		news = newNews;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT__NEWS, oldNews, news));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReleaseDate(Date newReleaseDate) {
		Date oldReleaseDate = releaseDate;
		releaseDate = newReleaseDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT__RELEASE_DATE, oldReleaseDate,
					releaseDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRank() {
		return rank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRank(int newRank) {
		int oldRank = rank;
		rank = newRank;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT__RANK, oldRank, rank));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getTags() {
		if (tags == null) {
			tags = new EDataTypeUniqueEList<>(String.class, this, AnalyzerPackage.PROJECT__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ContributionAnalysis getContribution() {
		for (EObject eContainer = eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
			if (eContainer instanceof ContributionAnalysis) {
				return (ContributionAnalysis) eContainer;
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
	public Project getParent() {
		if (eContainerFeatureID() != AnalyzerPackage.PROJECT__PARENT)
			return null;
		return (Project) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GitRepository> getRepositories() {
		if (repositories == null) {
			repositories = new EObjectContainmentWithInverseEList<>(GitRepository.class, this,
					AnalyzerPackage.PROJECT__REPOSITORIES, AnalyzerPackage.GIT_REPOSITORY__PROJECT);
		}
		return repositories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Project> getSubprojects() {
		if (subprojects == null) {
			subprojects = new EObjectContainmentWithInverseEList<>(Project.class, this,
					AnalyzerPackage.PROJECT__SUBPROJECTS, AnalyzerPackage.PROJECT__PARENT);
		}
		return subprojects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Project> getAllProjects() {
		return ECollections.toEList((Iterator<Project>) new AbstractTreeIterator<Project>(this) {
			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<? extends Project> getChildren(Object object) {
				return ((Project) object).getSubprojects().iterator();
			}
		});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Analysis getAnalysis() {
		for (EObject eContainer = eContainer(); eContainer != null; eContainer = eContainer.eContainer()) {
			if (eContainer instanceof Analysis analysis) {
				return analysis;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.PROJECT__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, AnalyzerPackage.PROJECT__PARENT, msgs);
			case AnalyzerPackage.PROJECT__REPOSITORIES:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getRepositories()).basicAdd(otherEnd, msgs);
			case AnalyzerPackage.PROJECT__SUBPROJECTS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubprojects()).basicAdd(otherEnd, msgs);
			default:
				return super.eInverseAdd(otherEnd, featureID, msgs);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.PROJECT__PARENT:
				return eBasicSetContainer(null, AnalyzerPackage.PROJECT__PARENT, msgs);
			case AnalyzerPackage.PROJECT__REPOSITORIES:
				return ((InternalEList<?>) getRepositories()).basicRemove(otherEnd, msgs);
			case AnalyzerPackage.PROJECT__SUBPROJECTS:
				return ((InternalEList<?>) getSubprojects()).basicRemove(otherEnd, msgs);
			default:
				return super.eInverseRemove(otherEnd, featureID, msgs);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case AnalyzerPackage.PROJECT__PARENT:
				return eInternalContainer().eInverseRemove(this, AnalyzerPackage.PROJECT__SUBPROJECTS, Project.class,
						msgs);
			default:
				return super.eBasicRemoveFromContainerFeature(msgs);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalyzerPackage.PROJECT__NAME:
				return getName();
			case AnalyzerPackage.PROJECT__SITE:
				return getSite();
			case AnalyzerPackage.PROJECT__VERSION:
				return getVersion();
			case AnalyzerPackage.PROJECT__NEWS:
				return getNews();
			case AnalyzerPackage.PROJECT__RELEASE_DATE:
				return getReleaseDate();
			case AnalyzerPackage.PROJECT__RANK:
				return getRank();
			case AnalyzerPackage.PROJECT__TAGS:
				return getTags();
			case AnalyzerPackage.PROJECT__CONTRIBUTION:
				return getContribution();
			case AnalyzerPackage.PROJECT__PARENT:
				return getParent();
			case AnalyzerPackage.PROJECT__REPOSITORIES:
				return getRepositories();
			case AnalyzerPackage.PROJECT__SUBPROJECTS:
				return getSubprojects();
			default:
				return super.eGet(featureID, resolve, coreType);
		}
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
			case AnalyzerPackage.PROJECT__NAME:
				setName((String) newValue);
				return;
			case AnalyzerPackage.PROJECT__SITE:
				setSite((URI) newValue);
				return;
			case AnalyzerPackage.PROJECT__VERSION:
				setVersion((URI) newValue);
				return;
			case AnalyzerPackage.PROJECT__NEWS:
				setNews((URI) newValue);
				return;
			case AnalyzerPackage.PROJECT__RELEASE_DATE:
				setReleaseDate((Date) newValue);
				return;
			case AnalyzerPackage.PROJECT__RANK:
				setRank((Integer) newValue);
				return;
			case AnalyzerPackage.PROJECT__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends String>) newValue);
				return;
			case AnalyzerPackage.PROJECT__REPOSITORIES:
				getRepositories().clear();
				getRepositories().addAll((Collection<? extends GitRepository>) newValue);
				return;
			case AnalyzerPackage.PROJECT__SUBPROJECTS:
				getSubprojects().clear();
				getSubprojects().addAll((Collection<? extends Project>) newValue);
				return;
			default:
				super.eSet(featureID, newValue);
				return;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AnalyzerPackage.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AnalyzerPackage.PROJECT__SITE:
				setSite(SITE_EDEFAULT);
				return;
			case AnalyzerPackage.PROJECT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case AnalyzerPackage.PROJECT__NEWS:
				setNews(NEWS_EDEFAULT);
				return;
			case AnalyzerPackage.PROJECT__RELEASE_DATE:
				setReleaseDate(RELEASE_DATE_EDEFAULT);
				return;
			case AnalyzerPackage.PROJECT__RANK:
				setRank(RANK_EDEFAULT);
				return;
			case AnalyzerPackage.PROJECT__TAGS:
				getTags().clear();
				return;
			case AnalyzerPackage.PROJECT__REPOSITORIES:
				getRepositories().clear();
				return;
			case AnalyzerPackage.PROJECT__SUBPROJECTS:
				getSubprojects().clear();
				return;
			default:
				super.eUnset(featureID);
				return;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AnalyzerPackage.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AnalyzerPackage.PROJECT__SITE:
				return SITE_EDEFAULT == null ? site != null : !SITE_EDEFAULT.equals(site);
			case AnalyzerPackage.PROJECT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case AnalyzerPackage.PROJECT__NEWS:
				return NEWS_EDEFAULT == null ? news != null : !NEWS_EDEFAULT.equals(news);
			case AnalyzerPackage.PROJECT__RELEASE_DATE:
				return RELEASE_DATE_EDEFAULT == null ? releaseDate != null : !RELEASE_DATE_EDEFAULT.equals(releaseDate);
			case AnalyzerPackage.PROJECT__RANK:
				return rank != RANK_EDEFAULT;
			case AnalyzerPackage.PROJECT__TAGS:
				return tags != null && !tags.isEmpty();
			case AnalyzerPackage.PROJECT__CONTRIBUTION:
				return getContribution() != null;
			case AnalyzerPackage.PROJECT__PARENT:
				return getParent() != null;
			case AnalyzerPackage.PROJECT__REPOSITORIES:
				return repositories != null && !repositories.isEmpty();
			case AnalyzerPackage.PROJECT__SUBPROJECTS:
				return subprojects != null && !subprojects.isEmpty();
			default:
				return super.eIsSet(featureID);
		}
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
		result.append(" (name: ");
		result.append(name);
		result.append(", site: ");
		result.append(site);
		result.append(", version: ");
		result.append(version);
		result.append(", news: ");
		result.append(news);
		result.append(", releaseDate: ");
		result.append(releaseDate);
		result.append(", rank: ");
		result.append(rank);
		result.append(", tags: ");
		result.append(tags);
		result.append(')');
		return result.toString();
	}

} // ProjectImpl
