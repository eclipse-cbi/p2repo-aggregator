/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.b3.beeLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.b3.beeLang.BeeLangPackage
 * @generated
 */
public interface BeeLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BeeLangFactory eINSTANCE = org.eclipse.b3.beeLang.impl.BeeLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Bee Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bee Model</em>'.
   * @generated
   */
  BeeModel createBeeModel();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  BeeLangPackage getBeeLangPackage();

} //BeeLangFactory
