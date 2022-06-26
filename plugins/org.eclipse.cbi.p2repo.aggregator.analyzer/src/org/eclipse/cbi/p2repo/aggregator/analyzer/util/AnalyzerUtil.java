/**
 * Copyright (c) 2022 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.analyzer.util;

import java.util.Date;

import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public final class AnalyzerUtil {

	private AnalyzerUtil() {
		throw new RuntimeException("Not instantiable");
	}

	public static Float getAgeInDays(ContributionAnalysis contributionAnalysis) {
		long lastModified = contributionAnalysis.getLastModified();
		if (lastModified != Long.MIN_VALUE) {
			return getAgeInDays(lastModified);
		}
		return null;
	}

	public static Float getGitRepositoryAgeInDays(ContributionAnalysis contributionAnalysis) {
		Float result = null;
		for (TreeIterator<EObject> eAllContents = contributionAnalysis.eAllContents(); eAllContents.hasNext();) {
			EObject eObject = eAllContents.next();
			if (eObject instanceof GitRepository) {
				Float ageInDays = getAgeInDays((GitRepository) eObject);
				if (ageInDays != null) {
					if (result == null) {
						result = ageInDays;
					} else {
						result = Math.min(ageInDays, result);
					}
				}
			}
		}
		return result;
	}

	public static Float getAgeInDays(GitRepository gitRepository) {
		long lastModified = gitRepository.getLastModified();
		if (lastModified != Long.MIN_VALUE) {
			return getAgeInDays(lastModified);
		}
		return null;
	}

	public static float getAgeInDays(long lastModified) {
		long now = System.currentTimeMillis();
		long ageInMillis = Math.max(0, now - lastModified);
		float ageInDays = ((float) ageInMillis) / 1000 / 60 / 60 / 24;
		return ageInDays;
	}

	public static String format(Date date) {
		return AnalyzerFactory.eINSTANCE.convertToString(AnalyzerPackage.Literals.DATE, date);
	}

}
