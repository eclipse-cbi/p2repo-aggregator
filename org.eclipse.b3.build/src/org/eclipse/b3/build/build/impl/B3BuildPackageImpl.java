/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.build.build.impl;

import org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage;

import org.eclipse.b3.build.build.AliasedRequiredCapability;
import org.eclipse.b3.build.build.B3BuildFactory;
import org.eclipse.b3.build.build.B3BuildPackage;
import org.eclipse.b3.build.build.BuildConcernContext;
import org.eclipse.b3.build.build.BuildContext;
import org.eclipse.b3.build.build.BuildResultReference;
import org.eclipse.b3.build.build.BuildUnit;
import org.eclipse.b3.build.build.Builder;

import org.eclipse.b3.build.build.BuilderConcernContext;
import org.eclipse.b3.build.build.BuilderInput;
import org.eclipse.b3.build.build.BuilderNamePredicate;
import org.eclipse.b3.build.build.BuilderReference;
import org.eclipse.b3.build.build.Capability;
import org.eclipse.b3.build.build.CapabilityPredicate;
import org.eclipse.b3.build.build.CompoundBuildResultReference;
import org.eclipse.b3.build.build.CompoundPathVector;
import org.eclipse.b3.build.build.ContainerConfiguration;
import org.eclipse.b3.build.build.IProvidedCapabilityContainer;
import org.eclipse.b3.build.build.IRequiredCapabilityContainer;
import org.eclipse.b3.build.build.ImplementsPredicate;
import org.eclipse.b3.build.build.InputPredicate;
import org.eclipse.b3.build.build.NamePredicate;
import org.eclipse.b3.build.build.NameSpacePredicate;
import org.eclipse.b3.build.build.OutputPredicate;
import org.eclipse.b3.build.build.DirectBuildResultReference;
import org.eclipse.b3.build.build.IndirectBuildResultReference;
import org.eclipse.b3.build.build.PathGroup;
import org.eclipse.b3.build.build.PathVector;
import org.eclipse.b3.build.build.PathVectorElement;
import org.eclipse.b3.build.build.Prerequisite;
import org.eclipse.b3.build.build.ProvidesPredicate;
import org.eclipse.b3.build.build.RepositoryConfiguration;
import org.eclipse.b3.build.build.RepositoryDeclaration;
import org.eclipse.b3.build.build.RequiredCapability;
import org.eclipse.b3.build.build.RequiresPredicate;
import org.eclipse.b3.build.build.ResolutionStrategy;
import org.eclipse.b3.build.build.ResolutionStrategyBest;
import org.eclipse.b3.build.build.ResolutionStrategyFirst;
import org.eclipse.b3.build.build.Synchronization;
import org.eclipse.b3.build.build.SynchronizedBuilder;
import org.eclipse.b3.build.build.UnitConcernContext;
import org.eclipse.b3.build.build.UnitNamePredicate;
import org.eclipse.b3.build.build.UnitBuildResultReference;
import org.eclipse.b3.build.build.VersionedCapability;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.equinox.internal.provisional.p2.core.Version;
import org.eclipse.equinox.internal.provisional.p2.core.VersionRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class B3BuildPackageImpl extends EPackageImpl implements B3BuildPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionedCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiredCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathVectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundPathVectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathVectorElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synchronizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synchronizedBuilderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolutionStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolutionStrategyFirstEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolutionStrategyBestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildConcernContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiresPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass capabilityPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementsPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providesPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameSpacePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitNamePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderNamePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitConcernContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderConcernContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aliasedRequiredCapabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iRequiredCapabilityContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iProvidedCapabilityContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prerequisiteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildResultReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundBuildResultReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builderReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType versionRangeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType versionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.b3.build.build.B3BuildPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private B3BuildPackageImpl() {
		super(eNS_URI, B3BuildFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link B3BuildPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static B3BuildPackage init() {
		if (isInited) return (B3BuildPackage)EPackage.Registry.INSTANCE.getEPackage(B3BuildPackage.eNS_URI);

		// Obtain or create and register package
		B3BuildPackageImpl theB3BuildPackage = (B3BuildPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof B3BuildPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new B3BuildPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		B3backendPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theB3BuildPackage.createPackageContents();

		// Initialize created meta-data
		theB3BuildPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theB3BuildPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(B3BuildPackage.eNS_URI, theB3BuildPackage);
		return theB3BuildPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuildUnit() {
		return buildUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildUnit_Builders() {
		return (EReference)buildUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuildUnit_Documentation() {
		return (EAttribute)buildUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuildUnit_ExecutionMode() {
		return (EAttribute)buildUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildUnit_MetaRequiredCapabilities() {
		return (EReference)buildUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildUnit_Implements() {
		return (EReference)buildUnitEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildUnit_Concerns() {
		return (EReference)buildUnitEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildUnit_DefaultProperties() {
		return (EReference)buildUnitEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildUnit_PropertySets() {
		return (EReference)buildUnitEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildUnit_Synchronizations() {
		return (EReference)buildUnitEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildUnit_Repositories() {
		return (EReference)buildUnitEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildUnit_Containers() {
		return (EReference)buildUnitEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilder() {
		return builderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilder_PostcondExpr() {
		return (EReference)builderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilder_PrecondExpr() {
		return (EReference)builderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilder_Input() {
		return (EReference)builderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilder_Output() {
		return (EReference)builderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilder_DefaultProperties() {
		return (EReference)builderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionedCapability() {
		return versionedCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionedCapability_Version() {
		return (EAttribute)versionedCapabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapability() {
		return capabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCapability_Name() {
		return (EAttribute)capabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCapability_NameSpace() {
		return (EAttribute)capabilityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCapability_CondExpr() {
		return (EReference)capabilityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiredCapability() {
		return requiredCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiredCapability_VersionRange() {
		return (EAttribute)requiredCapabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathVector() {
		return pathVectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathVector_CondExpr() {
		return (EReference)pathVectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathVector_BasePath() {
		return (EAttribute)pathVectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathVector_Paths() {
		return (EAttribute)pathVectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundPathVector() {
		return compoundPathVectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundPathVector_PathVectors() {
		return (EReference)compoundPathVectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathVectorElement() {
		return pathVectorElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynchronization() {
		return synchronizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynchronization_Builders() {
		return (EReference)synchronizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynchronizedBuilder() {
		return synchronizedBuilderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronizedBuilder_NameSpace() {
		return (EAttribute)synchronizedBuilderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronizedBuilder_Name() {
		return (EAttribute)synchronizedBuilderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSynchronizedBuilder_BuilderName() {
		return (EAttribute)synchronizedBuilderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepositoryConfiguration() {
		return repositoryConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepositoryDeclaration() {
		return repositoryDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepositoryDeclaration_Documentation() {
		return (EAttribute)repositoryDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepositoryDeclaration_Location() {
		return (EAttribute)repositoryDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryDeclaration_ResolverType() {
		return (EReference)repositoryDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepositoryDeclaration_ContextBlock() {
		return (EReference)repositoryDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolutionStrategy() {
		return resolutionStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolutionStrategy_Repositories() {
		return (EReference)resolutionStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolutionStrategyFirst() {
		return resolutionStrategyFirstEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolutionStrategyBest() {
		return resolutionStrategyBestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerConfiguration() {
		return containerConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContainerConfiguration_Documentation() {
		return (EAttribute)containerConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContainerConfiguration_Name() {
		return (EAttribute)containerConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerConfiguration_AgentType() {
		return (EReference)containerConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerConfiguration_ContextBlock() {
		return (EReference)containerConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuildContext() {
		return buildContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuildConcernContext() {
		return buildConcernContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiresPredicate() {
		return requiresPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiresPredicate_CapabilityPredicate() {
		return (EReference)requiresPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiresPredicate_Meta() {
		return (EAttribute)requiresPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCapabilityPredicate() {
		return capabilityPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCapabilityPredicate_NameSpacePattern() {
		return (EReference)capabilityPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCapabilityPredicate_VersionRange() {
		return (EAttribute)capabilityPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCapabilityPredicate_NamePredicate() {
		return (EReference)capabilityPredicateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCapabilityPredicate_NameSpacePredicate() {
		return (EReference)capabilityPredicateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementsPredicate() {
		return implementsPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementsPredicate_Type() {
		return (EReference)implementsPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvidesPredicate() {
		return providesPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidesPredicate_CapabilityPredicate() {
		return (EReference)providesPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamePredicate() {
		return namePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamePredicate_Name() {
		return (EAttribute)namePredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamePredicate_NamePattern() {
		return (EReference)namePredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameSpacePredicate() {
		return nameSpacePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameSpacePredicate_NameSpace() {
		return (EAttribute)nameSpacePredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitNamePredicate() {
		return unitNamePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilderNamePredicate() {
		return builderNamePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderNamePredicate_NamePredicate() {
		return (EReference)builderNamePredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputPredicate() {
		return inputPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputPredicate_CapabilityPredicate() {
		return (EReference)inputPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputPredicate_BuilderPredicate() {
		return (EReference)inputPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitConcernContext() {
		return unitConcernContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitConcernContext_BuilderContexts() {
		return (EReference)unitConcernContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitConcernContext_Query() {
		return (EReference)unitConcernContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitConcernContext_RequiresRemovals() {
		return (EReference)unitConcernContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitConcernContext_ProvidesRemovals() {
		return (EReference)unitConcernContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilderConcernContext() {
		return builderConcernContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderConcernContext_Query() {
		return (EReference)builderConcernContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderConcernContext_InputAdditions() {
		return (EReference)builderConcernContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderConcernContext_InputRemovals() {
		return (EReference)builderConcernContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderConcernContext_OutputAdditions() {
		return (EReference)builderConcernContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderConcernContext_OutputRemovals() {
		return (EReference)builderConcernContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderConcernContext_FuncExpr() {
		return (EReference)builderConcernContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputPredicate() {
		return outputPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputPredicate_PathVector() {
		return (EReference)outputPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputPredicate_PathPattern() {
		return (EReference)outputPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAliasedRequiredCapability() {
		return aliasedRequiredCapabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAliasedRequiredCapability_Alias() {
		return (EAttribute)aliasedRequiredCapabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIRequiredCapabilityContainer() {
		return iRequiredCapabilityContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIRequiredCapabilityContainer_RequiredCapabilities() {
		return (EReference)iRequiredCapabilityContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIProvidedCapabilityContainer() {
		return iProvidedCapabilityContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIProvidedCapabilityContainer_ProvidedCapabilities() {
		return (EReference)iProvidedCapabilityContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilderInput() {
		return builderInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderInput_PrecondExpr() {
		return (EReference)builderInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderInput_PostcondExpr() {
		return (EReference)builderInputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderInput_Prerequisites() {
		return (EReference)builderInputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathGroup() {
		return pathGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathGroup_Annotations() {
		return (EReference)pathGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathGroup_PathVectors() {
		return (EReference)pathGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrerequisite() {
		return prerequisiteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrerequisite_CondExpr() {
		return (EReference)prerequisiteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrerequisite_Alias() {
		return (EAttribute)prerequisiteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrerequisite_WithExpr() {
		return (EReference)prerequisiteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrerequisite_BuildResult() {
		return (EReference)prerequisiteEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuildResultReference() {
		return buildResultReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundBuildResultReference() {
		return compoundBuildResultReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundBuildResultReference_Prerequisites() {
		return (EReference)compoundBuildResultReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuilderReference() {
		return builderReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderReference_Parameters() {
		return (EReference)builderReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuilderReference_BuilderName() {
		return (EAttribute)builderReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderReference_RequiredCapability() {
		return (EReference)builderReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuilderReference_RequiredCapabilityReference() {
		return (EReference)builderReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVersionRange() {
		return versionRangeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getVersion() {
		return versionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B3BuildFactory getB3BuildFactory() {
		return (B3BuildFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		buildUnitEClass = createEClass(BUILD_UNIT);
		createEReference(buildUnitEClass, BUILD_UNIT__BUILDERS);
		createEAttribute(buildUnitEClass, BUILD_UNIT__DOCUMENTATION);
		createEAttribute(buildUnitEClass, BUILD_UNIT__EXECUTION_MODE);
		createEReference(buildUnitEClass, BUILD_UNIT__META_REQUIRED_CAPABILITIES);
		createEReference(buildUnitEClass, BUILD_UNIT__IMPLEMENTS);
		createEReference(buildUnitEClass, BUILD_UNIT__CONCERNS);
		createEReference(buildUnitEClass, BUILD_UNIT__DEFAULT_PROPERTIES);
		createEReference(buildUnitEClass, BUILD_UNIT__PROPERTY_SETS);
		createEReference(buildUnitEClass, BUILD_UNIT__SYNCHRONIZATIONS);
		createEReference(buildUnitEClass, BUILD_UNIT__REPOSITORIES);
		createEReference(buildUnitEClass, BUILD_UNIT__CONTAINERS);

		builderEClass = createEClass(BUILDER);
		createEReference(builderEClass, BUILDER__POSTCOND_EXPR);
		createEReference(builderEClass, BUILDER__PRECOND_EXPR);
		createEReference(builderEClass, BUILDER__INPUT);
		createEReference(builderEClass, BUILDER__OUTPUT);
		createEReference(builderEClass, BUILDER__DEFAULT_PROPERTIES);

		versionedCapabilityEClass = createEClass(VERSIONED_CAPABILITY);
		createEAttribute(versionedCapabilityEClass, VERSIONED_CAPABILITY__VERSION);

		builderInputEClass = createEClass(BUILDER_INPUT);
		createEReference(builderInputEClass, BUILDER_INPUT__PRECOND_EXPR);
		createEReference(builderInputEClass, BUILDER_INPUT__POSTCOND_EXPR);
		createEReference(builderInputEClass, BUILDER_INPUT__PREREQUISITES);

		pathGroupEClass = createEClass(PATH_GROUP);
		createEReference(pathGroupEClass, PATH_GROUP__ANNOTATIONS);
		createEReference(pathGroupEClass, PATH_GROUP__PATH_VECTORS);

		prerequisiteEClass = createEClass(PREREQUISITE);
		createEReference(prerequisiteEClass, PREREQUISITE__COND_EXPR);
		createEAttribute(prerequisiteEClass, PREREQUISITE__ALIAS);
		createEReference(prerequisiteEClass, PREREQUISITE__WITH_EXPR);
		createEReference(prerequisiteEClass, PREREQUISITE__BUILD_RESULT);

		buildResultReferenceEClass = createEClass(BUILD_RESULT_REFERENCE);

		compoundBuildResultReferenceEClass = createEClass(COMPOUND_BUILD_RESULT_REFERENCE);
		createEReference(compoundBuildResultReferenceEClass, COMPOUND_BUILD_RESULT_REFERENCE__PREREQUISITES);

		builderReferenceEClass = createEClass(BUILDER_REFERENCE);
		createEReference(builderReferenceEClass, BUILDER_REFERENCE__PARAMETERS);
		createEAttribute(builderReferenceEClass, BUILDER_REFERENCE__BUILDER_NAME);
		createEReference(builderReferenceEClass, BUILDER_REFERENCE__REQUIRED_CAPABILITY);
		createEReference(builderReferenceEClass, BUILDER_REFERENCE__REQUIRED_CAPABILITY_REFERENCE);

		capabilityEClass = createEClass(CAPABILITY);
		createEAttribute(capabilityEClass, CAPABILITY__NAME);
		createEAttribute(capabilityEClass, CAPABILITY__NAME_SPACE);
		createEReference(capabilityEClass, CAPABILITY__COND_EXPR);

		requiredCapabilityEClass = createEClass(REQUIRED_CAPABILITY);
		createEAttribute(requiredCapabilityEClass, REQUIRED_CAPABILITY__VERSION_RANGE);

		pathVectorEClass = createEClass(PATH_VECTOR);
		createEReference(pathVectorEClass, PATH_VECTOR__COND_EXPR);
		createEAttribute(pathVectorEClass, PATH_VECTOR__BASE_PATH);
		createEAttribute(pathVectorEClass, PATH_VECTOR__PATHS);

		compoundPathVectorEClass = createEClass(COMPOUND_PATH_VECTOR);
		createEReference(compoundPathVectorEClass, COMPOUND_PATH_VECTOR__PATH_VECTORS);

		pathVectorElementEClass = createEClass(PATH_VECTOR_ELEMENT);

		synchronizationEClass = createEClass(SYNCHRONIZATION);
		createEReference(synchronizationEClass, SYNCHRONIZATION__BUILDERS);

		synchronizedBuilderEClass = createEClass(SYNCHRONIZED_BUILDER);
		createEAttribute(synchronizedBuilderEClass, SYNCHRONIZED_BUILDER__NAME_SPACE);
		createEAttribute(synchronizedBuilderEClass, SYNCHRONIZED_BUILDER__NAME);
		createEAttribute(synchronizedBuilderEClass, SYNCHRONIZED_BUILDER__BUILDER_NAME);

		repositoryConfigurationEClass = createEClass(REPOSITORY_CONFIGURATION);

		repositoryDeclarationEClass = createEClass(REPOSITORY_DECLARATION);
		createEAttribute(repositoryDeclarationEClass, REPOSITORY_DECLARATION__DOCUMENTATION);
		createEAttribute(repositoryDeclarationEClass, REPOSITORY_DECLARATION__LOCATION);
		createEReference(repositoryDeclarationEClass, REPOSITORY_DECLARATION__RESOLVER_TYPE);
		createEReference(repositoryDeclarationEClass, REPOSITORY_DECLARATION__CONTEXT_BLOCK);

		resolutionStrategyEClass = createEClass(RESOLUTION_STRATEGY);
		createEReference(resolutionStrategyEClass, RESOLUTION_STRATEGY__REPOSITORIES);

		resolutionStrategyFirstEClass = createEClass(RESOLUTION_STRATEGY_FIRST);

		resolutionStrategyBestEClass = createEClass(RESOLUTION_STRATEGY_BEST);

		containerConfigurationEClass = createEClass(CONTAINER_CONFIGURATION);
		createEAttribute(containerConfigurationEClass, CONTAINER_CONFIGURATION__DOCUMENTATION);
		createEAttribute(containerConfigurationEClass, CONTAINER_CONFIGURATION__NAME);
		createEReference(containerConfigurationEClass, CONTAINER_CONFIGURATION__AGENT_TYPE);
		createEReference(containerConfigurationEClass, CONTAINER_CONFIGURATION__CONTEXT_BLOCK);

		buildContextEClass = createEClass(BUILD_CONTEXT);

		buildConcernContextEClass = createEClass(BUILD_CONCERN_CONTEXT);

		requiresPredicateEClass = createEClass(REQUIRES_PREDICATE);
		createEReference(requiresPredicateEClass, REQUIRES_PREDICATE__CAPABILITY_PREDICATE);
		createEAttribute(requiresPredicateEClass, REQUIRES_PREDICATE__META);

		capabilityPredicateEClass = createEClass(CAPABILITY_PREDICATE);
		createEReference(capabilityPredicateEClass, CAPABILITY_PREDICATE__NAME_SPACE_PATTERN);
		createEAttribute(capabilityPredicateEClass, CAPABILITY_PREDICATE__VERSION_RANGE);
		createEReference(capabilityPredicateEClass, CAPABILITY_PREDICATE__NAME_PREDICATE);
		createEReference(capabilityPredicateEClass, CAPABILITY_PREDICATE__NAME_SPACE_PREDICATE);

		implementsPredicateEClass = createEClass(IMPLEMENTS_PREDICATE);
		createEReference(implementsPredicateEClass, IMPLEMENTS_PREDICATE__TYPE);

		providesPredicateEClass = createEClass(PROVIDES_PREDICATE);
		createEReference(providesPredicateEClass, PROVIDES_PREDICATE__CAPABILITY_PREDICATE);

		namePredicateEClass = createEClass(NAME_PREDICATE);
		createEAttribute(namePredicateEClass, NAME_PREDICATE__NAME);
		createEReference(namePredicateEClass, NAME_PREDICATE__NAME_PATTERN);

		nameSpacePredicateEClass = createEClass(NAME_SPACE_PREDICATE);
		createEAttribute(nameSpacePredicateEClass, NAME_SPACE_PREDICATE__NAME_SPACE);

		unitNamePredicateEClass = createEClass(UNIT_NAME_PREDICATE);

		builderNamePredicateEClass = createEClass(BUILDER_NAME_PREDICATE);
		createEReference(builderNamePredicateEClass, BUILDER_NAME_PREDICATE__NAME_PREDICATE);

		inputPredicateEClass = createEClass(INPUT_PREDICATE);
		createEReference(inputPredicateEClass, INPUT_PREDICATE__CAPABILITY_PREDICATE);
		createEReference(inputPredicateEClass, INPUT_PREDICATE__BUILDER_PREDICATE);

		unitConcernContextEClass = createEClass(UNIT_CONCERN_CONTEXT);
		createEReference(unitConcernContextEClass, UNIT_CONCERN_CONTEXT__BUILDER_CONTEXTS);
		createEReference(unitConcernContextEClass, UNIT_CONCERN_CONTEXT__QUERY);
		createEReference(unitConcernContextEClass, UNIT_CONCERN_CONTEXT__REQUIRES_REMOVALS);
		createEReference(unitConcernContextEClass, UNIT_CONCERN_CONTEXT__PROVIDES_REMOVALS);

		builderConcernContextEClass = createEClass(BUILDER_CONCERN_CONTEXT);
		createEReference(builderConcernContextEClass, BUILDER_CONCERN_CONTEXT__QUERY);
		createEReference(builderConcernContextEClass, BUILDER_CONCERN_CONTEXT__INPUT_ADDITIONS);
		createEReference(builderConcernContextEClass, BUILDER_CONCERN_CONTEXT__INPUT_REMOVALS);
		createEReference(builderConcernContextEClass, BUILDER_CONCERN_CONTEXT__OUTPUT_ADDITIONS);
		createEReference(builderConcernContextEClass, BUILDER_CONCERN_CONTEXT__OUTPUT_REMOVALS);
		createEReference(builderConcernContextEClass, BUILDER_CONCERN_CONTEXT__FUNC_EXPR);

		outputPredicateEClass = createEClass(OUTPUT_PREDICATE);
		createEReference(outputPredicateEClass, OUTPUT_PREDICATE__PATH_VECTOR);
		createEReference(outputPredicateEClass, OUTPUT_PREDICATE__PATH_PATTERN);

		aliasedRequiredCapabilityEClass = createEClass(ALIASED_REQUIRED_CAPABILITY);
		createEAttribute(aliasedRequiredCapabilityEClass, ALIASED_REQUIRED_CAPABILITY__ALIAS);

		iRequiredCapabilityContainerEClass = createEClass(IREQUIRED_CAPABILITY_CONTAINER);
		createEReference(iRequiredCapabilityContainerEClass, IREQUIRED_CAPABILITY_CONTAINER__REQUIRED_CAPABILITIES);

		iProvidedCapabilityContainerEClass = createEClass(IPROVIDED_CAPABILITY_CONTAINER);
		createEReference(iProvidedCapabilityContainerEClass, IPROVIDED_CAPABILITY_CONTAINER__PROVIDED_CAPABILITIES);

		// Create data types
		versionRangeEDataType = createEDataType(VERSION_RANGE);
		versionEDataType = createEDataType(VERSION);
		uriEDataType = createEDataType(URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		B3backendPackage theB3backendPackage = (B3backendPackage)EPackage.Registry.INSTANCE.getEPackage(B3backendPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		buildUnitEClass.getESuperTypes().add(this.getVersionedCapability());
		buildUnitEClass.getESuperTypes().add(theB3backendPackage.getBFunctionContainer());
		buildUnitEClass.getESuperTypes().add(this.getIRequiredCapabilityContainer());
		buildUnitEClass.getESuperTypes().add(this.getIProvidedCapabilityContainer());
		builderEClass.getESuperTypes().add(theB3backendPackage.getB3Function());
		builderEClass.getESuperTypes().add(this.getIProvidedCapabilityContainer());
		versionedCapabilityEClass.getESuperTypes().add(this.getCapability());
		compoundBuildResultReferenceEClass.getESuperTypes().add(this.getBuildResultReference());
		builderReferenceEClass.getESuperTypes().add(this.getBuildResultReference());
		requiredCapabilityEClass.getESuperTypes().add(this.getCapability());
		compoundPathVectorEClass.getESuperTypes().add(this.getPathVector());
		pathVectorElementEClass.getESuperTypes().add(this.getPathVector());
		repositoryDeclarationEClass.getESuperTypes().add(this.getRepositoryConfiguration());
		resolutionStrategyEClass.getESuperTypes().add(this.getRepositoryConfiguration());
		resolutionStrategyFirstEClass.getESuperTypes().add(this.getResolutionStrategy());
		resolutionStrategyBestEClass.getESuperTypes().add(this.getResolutionStrategy());
		buildContextEClass.getESuperTypes().add(theB3backendPackage.getBExecutionContext());
		buildConcernContextEClass.getESuperTypes().add(theB3backendPackage.getBConcernContext());
		requiresPredicateEClass.getESuperTypes().add(theB3backendPackage.getBExpression());
		capabilityPredicateEClass.getESuperTypes().add(theB3backendPackage.getBExpression());
		implementsPredicateEClass.getESuperTypes().add(theB3backendPackage.getBExpression());
		providesPredicateEClass.getESuperTypes().add(theB3backendPackage.getBExpression());
		unitNamePredicateEClass.getESuperTypes().add(this.getCapabilityPredicate());
		builderNamePredicateEClass.getESuperTypes().add(theB3backendPackage.getBExpression());
		inputPredicateEClass.getESuperTypes().add(theB3backendPackage.getBExpression());
		unitConcernContextEClass.getESuperTypes().add(this.getBuildConcernContext());
		unitConcernContextEClass.getESuperTypes().add(this.getIRequiredCapabilityContainer());
		unitConcernContextEClass.getESuperTypes().add(this.getIProvidedCapabilityContainer());
		builderConcernContextEClass.getESuperTypes().add(this.getBuildConcernContext());
		outputPredicateEClass.getESuperTypes().add(theB3backendPackage.getBExpression());
		aliasedRequiredCapabilityEClass.getESuperTypes().add(this.getRequiredCapability());

		// Initialize classes and features; add operations and parameters
		initEClass(buildUnitEClass, BuildUnit.class, "BuildUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuildUnit_Builders(), this.getBuilder(), null, "builders", null, 0, -1, BuildUnit.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuildUnit_Documentation(), ecorePackage.getEString(), "documentation", null, 0, 1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuildUnit_ExecutionMode(), theB3backendPackage.getExecutionMode(), "executionMode", null, 0, 1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildUnit_MetaRequiredCapabilities(), this.getRequiredCapability(), null, "metaRequiredCapabilities", null, 0, -1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildUnit_Implements(), theB3backendPackage.getIType(), null, "implements", null, 0, -1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildUnit_Concerns(), theB3backendPackage.getBConcern(), null, "concerns", null, 0, -1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildUnit_DefaultProperties(), theB3backendPackage.getBPropertySet(), null, "defaultProperties", null, 0, 1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildUnit_PropertySets(), theB3backendPackage.getBPropertySet(), null, "propertySets", null, 0, -1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildUnit_Synchronizations(), this.getSynchronization(), null, "synchronizations", null, 0, -1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildUnit_Repositories(), this.getRepositoryConfiguration(), null, "repositories", null, 0, -1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildUnit_Containers(), this.getContainerConfiguration(), null, "containers", null, 0, -1, BuildUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builderEClass, Builder.class, "Builder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuilder_PostcondExpr(), theB3backendPackage.getBExpression(), null, "postcondExpr", null, 0, 1, Builder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilder_PrecondExpr(), theB3backendPackage.getBExpression(), null, "precondExpr", null, 0, 1, Builder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilder_Input(), this.getBuilderInput(), null, "input", null, 0, 1, Builder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilder_Output(), this.getPathGroup(), null, "output", null, 0, 1, Builder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilder_DefaultProperties(), theB3backendPackage.getBPropertySet(), null, "defaultProperties", null, 0, 1, Builder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionedCapabilityEClass, VersionedCapability.class, "VersionedCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionedCapability_Version(), this.getVersion(), "version", null, 0, 1, VersionedCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builderInputEClass, BuilderInput.class, "BuilderInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuilderInput_PrecondExpr(), theB3backendPackage.getBExpression(), null, "precondExpr", null, 0, 1, BuilderInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderInput_PostcondExpr(), theB3backendPackage.getBExpression(), null, "postcondExpr", null, 0, 1, BuilderInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderInput_Prerequisites(), this.getPrerequisite(), null, "prerequisites", null, 0, -1, BuilderInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathGroupEClass, PathGroup.class, "PathGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathGroup_Annotations(), theB3backendPackage.getBPropertySet(), null, "annotations", null, 0, 1, PathGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPathGroup_PathVectors(), this.getPathVector(), null, "pathVectors", null, 0, -1, PathGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(prerequisiteEClass, Prerequisite.class, "Prerequisite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrerequisite_CondExpr(), theB3backendPackage.getBExpression(), null, "condExpr", null, 0, 1, Prerequisite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrerequisite_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, Prerequisite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrerequisite_WithExpr(), theB3backendPackage.getBWithExpression(), null, "withExpr", null, 0, 1, Prerequisite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrerequisite_BuildResult(), this.getBuildResultReference(), null, "buildResult", null, 0, 1, Prerequisite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(buildResultReferenceEClass, BuildResultReference.class, "BuildResultReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compoundBuildResultReferenceEClass, CompoundBuildResultReference.class, "CompoundBuildResultReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundBuildResultReference_Prerequisites(), this.getPrerequisite(), null, "prerequisites", null, 0, -1, CompoundBuildResultReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builderReferenceEClass, BuilderReference.class, "BuilderReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuilderReference_Parameters(), theB3backendPackage.getBParameterList(), null, "parameters", null, 0, 1, BuilderReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilderReference_BuilderName(), ecorePackage.getEString(), "builderName", null, 0, 1, BuilderReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderReference_RequiredCapability(), this.getRequiredCapability(), null, "requiredCapability", null, 0, 1, BuilderReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderReference_RequiredCapabilityReference(), this.getAliasedRequiredCapability(), null, "requiredCapabilityReference", null, 0, 1, BuilderReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(capabilityEClass, Capability.class, "Capability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCapability_Name(), ecorePackage.getEString(), "name", null, 0, 1, Capability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCapability_NameSpace(), ecorePackage.getEString(), "nameSpace", null, 0, 1, Capability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCapability_CondExpr(), theB3backendPackage.getBExpression(), null, "condExpr", null, 0, 1, Capability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requiredCapabilityEClass, RequiredCapability.class, "RequiredCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequiredCapability_VersionRange(), this.getVersionRange(), "versionRange", null, 0, 1, RequiredCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathVectorEClass, PathVector.class, "PathVector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathVector_CondExpr(), theB3backendPackage.getBExpression(), null, "condExpr", null, 0, 1, PathVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPathVector_BasePath(), ecorePackage.getEString(), "basePath", null, 0, 1, PathVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPathVector_Paths(), ecorePackage.getEString(), "paths", null, 0, -1, PathVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compoundPathVectorEClass, CompoundPathVector.class, "CompoundPathVector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundPathVector_PathVectors(), this.getPathVector(), null, "pathVectors", null, 0, -1, CompoundPathVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathVectorElementEClass, PathVectorElement.class, "PathVectorElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(synchronizationEClass, Synchronization.class, "Synchronization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSynchronization_Builders(), this.getSynchronizedBuilder(), null, "builders", null, 0, -1, Synchronization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(synchronizedBuilderEClass, SynchronizedBuilder.class, "SynchronizedBuilder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSynchronizedBuilder_NameSpace(), ecorePackage.getEString(), "nameSpace", null, 0, 1, SynchronizedBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronizedBuilder_Name(), ecorePackage.getEString(), "name", null, 0, 1, SynchronizedBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSynchronizedBuilder_BuilderName(), ecorePackage.getEString(), "builderName", null, 0, 1, SynchronizedBuilder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repositoryConfigurationEClass, RepositoryConfiguration.class, "RepositoryConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(repositoryDeclarationEClass, RepositoryDeclaration.class, "RepositoryDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRepositoryDeclaration_Documentation(), ecorePackage.getEString(), "documentation", null, 0, 1, RepositoryDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepositoryDeclaration_Location(), this.getURI(), "location", null, 0, 1, RepositoryDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepositoryDeclaration_ResolverType(), theB3backendPackage.getIType(), null, "resolverType", null, 0, 1, RepositoryDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepositoryDeclaration_ContextBlock(), theB3backendPackage.getBExpression(), null, "contextBlock", null, 0, 1, RepositoryDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resolutionStrategyEClass, ResolutionStrategy.class, "ResolutionStrategy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolutionStrategy_Repositories(), this.getRepositoryConfiguration(), null, "repositories", null, 0, -1, ResolutionStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resolutionStrategyFirstEClass, ResolutionStrategyFirst.class, "ResolutionStrategyFirst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resolutionStrategyBestEClass, ResolutionStrategyBest.class, "ResolutionStrategyBest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containerConfigurationEClass, ContainerConfiguration.class, "ContainerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContainerConfiguration_Documentation(), ecorePackage.getEString(), "documentation", null, 0, 1, ContainerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContainerConfiguration_Name(), ecorePackage.getEString(), "name", null, 0, 1, ContainerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainerConfiguration_AgentType(), theB3backendPackage.getIType(), null, "agentType", null, 1, 1, ContainerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainerConfiguration_ContextBlock(), theB3backendPackage.getBExpression(), null, "contextBlock", null, 0, 1, ContainerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(buildContextEClass, BuildContext.class, "BuildContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(buildContextEClass, null, "defineBuildUnit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBuildUnit(), "unit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theB3backendPackage.getB3EngineException());

		op = addEOperation(buildContextEClass, this.getBuildUnit(), "getBuildUnitProxy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBuildUnit(), "unit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theB3backendPackage.getB3EngineException());

		op = addEOperation(buildContextEClass, null, "getBuildUnitInterface", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBuildUnit(), "unit", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theB3backendPackage.getB3EngineException());
		EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(this.getBuildUnit());
		g2.setEUpperBound(g3);
		initEOperation(op, g1);

		initEClass(buildConcernContextEClass, BuildConcernContext.class, "BuildConcernContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(requiresPredicateEClass, RequiresPredicate.class, "RequiresPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequiresPredicate_CapabilityPredicate(), this.getCapabilityPredicate(), null, "capabilityPredicate", null, 1, 1, RequiresPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequiresPredicate_Meta(), ecorePackage.getEBoolean(), "meta", null, 0, 1, RequiresPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(capabilityPredicateEClass, CapabilityPredicate.class, "CapabilityPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCapabilityPredicate_NameSpacePattern(), theB3backendPackage.getBExpression(), null, "nameSpacePattern", null, 0, 1, CapabilityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCapabilityPredicate_VersionRange(), this.getVersionRange(), "versionRange", null, 0, 1, CapabilityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCapabilityPredicate_NamePredicate(), this.getNamePredicate(), null, "namePredicate", null, 0, 1, CapabilityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCapabilityPredicate_NameSpacePredicate(), this.getNamePredicate(), null, "nameSpacePredicate", null, 0, 1, CapabilityPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementsPredicateEClass, ImplementsPredicate.class, "ImplementsPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImplementsPredicate_Type(), theB3backendPackage.getIType(), null, "type", null, 0, 1, ImplementsPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(providesPredicateEClass, ProvidesPredicate.class, "ProvidesPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvidesPredicate_CapabilityPredicate(), this.getCapabilityPredicate(), null, "capabilityPredicate", null, 0, 1, ProvidesPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namePredicateEClass, NamePredicate.class, "NamePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamePredicate_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamePredicate_NamePattern(), theB3backendPackage.getBExpression(), null, "namePattern", null, 0, 1, NamePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameSpacePredicateEClass, NameSpacePredicate.class, "NameSpacePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameSpacePredicate_NameSpace(), ecorePackage.getEString(), "nameSpace", null, 0, 1, NameSpacePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitNamePredicateEClass, UnitNamePredicate.class, "UnitNamePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(builderNamePredicateEClass, BuilderNamePredicate.class, "BuilderNamePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuilderNamePredicate_NamePredicate(), this.getNamePredicate(), null, "namePredicate", null, 0, 1, BuilderNamePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputPredicateEClass, InputPredicate.class, "InputPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputPredicate_CapabilityPredicate(), this.getCapabilityPredicate(), null, "capabilityPredicate", null, 0, 1, InputPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInputPredicate_BuilderPredicate(), this.getNamePredicate(), null, "builderPredicate", null, 1, 1, InputPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitConcernContextEClass, UnitConcernContext.class, "UnitConcernContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitConcernContext_BuilderContexts(), this.getBuilderConcernContext(), null, "builderContexts", null, 0, -1, UnitConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitConcernContext_Query(), theB3backendPackage.getBExpression(), null, "query", null, 0, 1, UnitConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitConcernContext_RequiresRemovals(), this.getRequiresPredicate(), null, "requiresRemovals", null, 0, -1, UnitConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitConcernContext_ProvidesRemovals(), this.getProvidesPredicate(), null, "providesRemovals", null, 0, -1, UnitConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builderConcernContextEClass, BuilderConcernContext.class, "BuilderConcernContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuilderConcernContext_Query(), theB3backendPackage.getBExpression(), null, "query", null, 0, 1, BuilderConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderConcernContext_InputAdditions(), this.getPrerequisite(), null, "inputAdditions", null, 0, -1, BuilderConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderConcernContext_InputRemovals(), this.getInputPredicate(), null, "inputRemovals", null, 0, -1, BuilderConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderConcernContext_OutputAdditions(), this.getPathVector(), null, "outputAdditions", null, 0, -1, BuilderConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderConcernContext_OutputRemovals(), this.getOutputPredicate(), null, "outputRemovals", null, 0, -1, BuilderConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuilderConcernContext_FuncExpr(), theB3backendPackage.getBExpression(), null, "funcExpr", null, 0, 1, BuilderConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputPredicateEClass, OutputPredicate.class, "OutputPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputPredicate_PathVector(), this.getPathVectorElement(), null, "pathVector", null, 0, 1, OutputPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutputPredicate_PathPattern(), theB3backendPackage.getBExpression(), null, "pathPattern", null, 0, 1, OutputPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aliasedRequiredCapabilityEClass, AliasedRequiredCapability.class, "AliasedRequiredCapability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAliasedRequiredCapability_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, AliasedRequiredCapability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iRequiredCapabilityContainerEClass, IRequiredCapabilityContainer.class, "IRequiredCapabilityContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIRequiredCapabilityContainer_RequiredCapabilities(), this.getRequiredCapability(), null, "requiredCapabilities", null, 0, -1, IRequiredCapabilityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iProvidedCapabilityContainerEClass, IProvidedCapabilityContainer.class, "IProvidedCapabilityContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIProvidedCapabilityContainer_ProvidedCapabilities(), this.getCapability(), null, "providedCapabilities", null, 0, -1, IProvidedCapabilityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(versionRangeEDataType, VersionRange.class, "VersionRange", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(versionEDataType, Version.class, "Version", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, java.net.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //B3BuildPackageImpl
