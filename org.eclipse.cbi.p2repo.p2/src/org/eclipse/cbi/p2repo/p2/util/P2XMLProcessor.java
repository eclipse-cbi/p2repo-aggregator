/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.util;

import java.util.Map;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class P2XMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public P2XMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		P2Package.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the P2ResourceFactoryImpl factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new P2ResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new P2ResourceFactoryImpl());
		}
		return registrations;
	}

} // P2XMLProcessor
