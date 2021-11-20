/**
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.p2.maven;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.cbi.p2repo.p2.maven.pom.Build;
import org.eclipse.cbi.p2repo.p2.maven.pom.CiManagement;
import org.eclipse.cbi.p2repo.p2.maven.pom.ContributorsType;
import org.eclipse.cbi.p2repo.p2.maven.pom.DependenciesType;
import org.eclipse.cbi.p2repo.p2.maven.pom.DependencyManagement;
import org.eclipse.cbi.p2repo.p2.maven.pom.DevelopersType;
import org.eclipse.cbi.p2repo.p2.maven.pom.DistributionManagement;
import org.eclipse.cbi.p2repo.p2.maven.pom.IssueManagement;
import org.eclipse.cbi.p2repo.p2.maven.pom.LicensesType;
import org.eclipse.cbi.p2repo.p2.maven.pom.MailingListsType;
import org.eclipse.cbi.p2repo.p2.maven.pom.Model;
import org.eclipse.cbi.p2repo.p2.maven.pom.ModulesType;
import org.eclipse.cbi.p2repo.p2.maven.pom.Organization;
import org.eclipse.cbi.p2repo.p2.maven.pom.Parent;
import org.eclipse.cbi.p2repo.p2.maven.pom.PluginRepositoriesType;
import org.eclipse.cbi.p2repo.p2.maven.pom.Prerequisites;
import org.eclipse.cbi.p2repo.p2.maven.pom.ProfilesType;
import org.eclipse.cbi.p2repo.p2.maven.pom.PropertiesType;
import org.eclipse.cbi.p2repo.p2.maven.pom.Reporting;
import org.eclipse.cbi.p2repo.p2.maven.pom.ReportsType;
import org.eclipse.cbi.p2repo.p2.maven.pom.RepositoriesType;
import org.eclipse.cbi.p2repo.p2.maven.pom.Scm;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
abstract class ResolvedModelBase implements Model {
	@Override
	public EList<Adapter> eAdapters() {
		throw new UnsupportedOperationException();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EClass eClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EObject eContainer() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EReference eContainmentFeature() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EList<EObject> eContents() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean eDeliver() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object eInvoke(EOperation arg0, EList<?> arg1) throws InvocationTargetException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean eIsProxy() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eNotify(Notification notification) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Resource eResource() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setArtifactId(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBuild(Build value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCiManagement(CiManagement value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setContributors(ContributorsType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDependencies(DependenciesType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDependencyManagement(DependencyManagement value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDescription(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDevelopers(DevelopersType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDistributionManagement(DistributionManagement value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setGroupId(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setInceptionYear(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIssueManagement(IssueManagement value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLicenses(LicensesType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMailingLists(MailingListsType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setModelVersion(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setModules(ModulesType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setName(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOrganization(Organization value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPackaging(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setParent(Parent value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPluginRepositories(PluginRepositoriesType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPrerequisites(Prerequisites value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setProfiles(ProfilesType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setProperties(PropertiesType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setReporting(Reporting value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setReports(ReportsType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setRepositories(RepositoriesType value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setScm(Scm value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUrl(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setVersion(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void unsetPackaging() {
		throw new UnsupportedOperationException();
	}

}
