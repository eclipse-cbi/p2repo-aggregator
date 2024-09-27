/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.presentation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference;
import org.eclipse.cbi.p2repo.aggregator.p2.util.MetadataRepositoryResourceImpl;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewFactory;
import org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser;
import org.eclipse.cbi.p2repo.aggregator.p2view.provider.P2viewItemProviderAdapterFactory;
import org.eclipse.cbi.p2repo.aggregator.provider.AggregatorItemProviderAdapterFactory;
import org.eclipse.cbi.p2repo.aggregator.provider.TooltipTextProvider;
import org.eclipse.cbi.p2repo.aggregator.transformer.ui.TransformationWizard;
import org.eclipse.cbi.p2repo.aggregator.util.AggregatorResource;
import org.eclipse.cbi.p2repo.aggregator.util.AggregatorResourceFactoryImpl;
import org.eclipse.cbi.p2repo.aggregator.util.AggregatorResourceImpl;
import org.eclipse.cbi.p2repo.aggregator.util.ResourceDiagnosticImpl;
import org.eclipse.cbi.p2repo.aggregator.util.ResourceUtils;
import org.eclipse.cbi.p2repo.aggregator.util.StatusProviderAdapterFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceSetItemProvider;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.edit.ui.util.IRevertablePart;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * This is an example of a Aggregator model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AggregatorEditor extends MultiPageEditorPart implements IEditingDomainProvider, ISelectionProvider,
		IMenuListener, IViewerProvider, IGotoMarker, IRevertablePart {

	static class MDRComparator implements Comparator<MetadataRepositoryReference> {
		@Override
		public int compare(MetadataRepositoryReference mdr1, MetadataRepositoryReference mdr2) {
			String location1 = mdr1 != null ? mdr1.getResolvedLocation() : null;
			if (location1 == null)
				location1 = "";
			String location2 = mdr2 != null ? mdr2.getResolvedLocation() : null;
			if (location2 == null)
				location2 = "";

			return location1.compareTo(location2);
		}
	}

	static class SortComparator extends ViewerComparator {
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			return super.compare(viewer, e1, e2);
		}
	}

	@SuppressWarnings("serial")
	static class OverrideMap<K, V> extends HashMap<K, V> {

		protected Map<? extends K, ? extends V> base;

		public OverrideMap(Map<? extends K, ? extends V> m) {
			super(m);
		}

		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean containsKey(Object key) {
			return super.containsKey(key) || base.containsKey(key);
		}

		@Override
		public boolean containsValue(Object value) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Set<java.util.Map.Entry<K, V>> entrySet() {
			throw new UnsupportedOperationException();
		}

		@Override
		public V get(Object key) {
			if (super.containsKey(key))
				return super.get(key);
			return base.get(key);
		}

		@Override
		public boolean isEmpty() {
			return super.isEmpty() && base.isEmpty();
		}

		@Override
		public Set<K> keySet() {
			throw new UnsupportedOperationException();
		}

		public Map<K, V> override(Map<? extends K, ? extends V> base) {
			this.base = base;
			return this;
		}

		@Override
		public V put(K key, V value) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void putAll(Map<? extends K, ? extends V> m) {
			throw new UnsupportedOperationException();
		}

		@Override
		public V remove(Object key) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int size() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Collection<V> values() {
			throw new UnsupportedOperationException();
		}

	}

	static class RepositoryLoaderJob extends Job {
		private final List<MetadataRepositoryReference> repositoriesToLoad;

		RepositoryLoaderJob(List<MetadataRepositoryReference> repositoriesToLoad) {
			super("Loading repositories...");
			this.repositoriesToLoad = new ArrayList<>(repositoriesToLoad);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			try {
				Collections.sort(repositoriesToLoad, new MDRComparator());

				// initialize all resources in alphabetical order
				for (MetadataRepositoryReference repo : repositoriesToLoad) {
					MetadataRepositoryResourceImpl res = (MetadataRepositoryResourceImpl) MetadataRepositoryResourceImpl
							.getResourceForNatureAndLocation(repo.getNature(), repo.getResolvedLocation(),
									repo.getAggregation());
					if (monitor.isCanceled())
						break;
					if (res != null)
						res.startAsynchronousLoad(false);
				}

				return Status.OK_STATUS;
			} finally {
				if (monitor != null)
					monitor.done();
			}
		}
	}

	public static final String AGGREGATOR_EDITOR_ID = "org.eclipse.cbi.p2repo.aggregator.presentation.AggregatorEditorID";

	public static final String AGGREGATOR_EDITOR_SCOPE = "org.eclipse.cbi.p2repo.aggregator.presentation.aggregatorEditorScope";

	public static final String AGGREGATOR_PROBLEM_MARKER = "org.eclipse.cbi.p2repo.aggregator.editor.diagnostic";

	public static final String AGGREGATOR_PERSISTENT_PROBLEM_MARKER = "org.eclipse.cbi.p2repo.aggregator.editor.diagnostic.persistent";

	public static final String AGGREGATOR_NONPERSISTENT_PROBLEM_MARKER = "org.eclipse.cbi.p2repo.aggregator.editor.diagnostic.nonpersistent";

	protected static Collection<Object> CLIPBOARD;

	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key) {
		return AggregatorEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key, Object s1) {
		return AggregatorEditorPlugin.INSTANCE.getString(key, new Object[] { s1 });
	}

	private IContextActivation contextActivation;

	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * This is the one adapter factory used for providing views of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This is the content outline page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IContentOutlinePage contentOutlinePage;

	/**
	 * This is a kludge...
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStatusLineManager contentOutlineStatusLineManager;

	/**
	 * This is the content outline page's viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer contentOutlineViewer;

	/**
	 * This is the property sheet page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected List<PropertySheetPage> propertySheetPages = new ArrayList<>();

	protected PropertySheetPage propertySheetPage;

	/**
	 * This is the viewer that shadows the selection in the content outline.
	 * The parent relation must be correctly defined for this to work.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer selectionViewer;

	/**
	 * This keeps track of the active content viewer, which may be either one of the viewers in the pages or the content outline viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Viewer currentViewer;

	/**
	 * This listens to which ever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionChangedListener selectionChangedListener;

	/**
	 * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are listening to this editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<>();

	/**
	 * This keeps track of the selection of the editor as a whole.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelection editorSelection = StructuredSelection.EMPTY;

	/**
	 * The MarkerHelper is responsible for creating workspace resource markers presented in Eclipse's Problems View.
	 *
	 *
	 * @generated NOT
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper() {

		@Override
		protected String getMarkerID() {
			return AGGREGATOR_PROBLEM_MARKER;
		}

	};

	protected AggregatorMarkerHelper managedMarkerHelper = new AggregatorMarkerHelper();

	private Pattern findIUIdPattern;

	private VersionRange findIUVersionRange;

	private boolean updateMarkers;

	private boolean updateMarkersIsRunning;

	private Job repositoryLoadingJob;

	/**
	 * This listens for when the outline becomes active
	 *
	 * @generated NOT
	 */
	protected IPartListener partListener = new IPartListener() {

		@Override
		public void partActivated(IWorkbenchPart p) {
			if (p instanceof ContentOutline) {
				if (((ContentOutline) p).getCurrentPage() == contentOutlinePage) {
					getActionBarContributor().setActiveEditor(AggregatorEditor.this);

					setCurrentViewer(contentOutlineViewer);
				}
			} else if (p instanceof PropertySheet) {
				if (((PropertySheet) p).getCurrentPage() == getPropertySheetPage()) {
					getActionBarContributor().setActiveEditor(AggregatorEditor.this);
					handleActivate();
				}
			} else if (p == AggregatorEditor.this) {
				handleActivate();
			}
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart p) {
			// Ignore.
		}

		@Override
		public void partClosed(IWorkbenchPart p) {
			// Ignore.
		}

		@Override
		public void partDeactivated(IWorkbenchPart p) {
			handleDeactivate();
		}

		@Override
		public void partOpened(IWorkbenchPart p) {
			// Ignore.
		}

	};

	/**
	 * Resources that have been removed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> removedResources = new ArrayList<>();

	/**
	 * Resources that have been changed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> changedResources = new ArrayList<>();

	/**
	 * Resources that have been saved.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> savedResources = new ArrayList<>();

	/**
	 * Map to store the diagnostic associated with a resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<>();

	protected Map<Resource, Diagnostic> managedResourceToDiagnosticMap = new LinkedHashMap<>();

	protected RepositoryBrowser repositoryBrowser;

	/**
	 * Controls whether the problem indication should be updated.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean updateProblemIndication = true;

	/**
	 * Adapter used to update the problem indication when resources are demanded loaded.
	 *
	 * @generated NOT
	 */
	protected EContentAdapter problemIndicationAdapter = new EContentAdapter() {

		private boolean analysisStarted = false;

		@Override
		public void notifyChanged(Notification notification) {
			if (!(notification.getNotifier() instanceof Resource))
				return;

			int featureID = notification.getFeatureID(Resource.class);

			// If a repository is loaded, force updating the context menu by setting selection to current selection
			if (featureID == Resource.RESOURCE__IS_LOADED) {
				getSite().getShell().getDisplay().asyncExec(new Runnable() {

					@Override
					public void run() {
						setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
					}

				});
			}

			switch (featureID) {
				case AggregatorResource.RESOURCE__ANALYSIS_STARTED:
					analysisStarted = true;
					break;
				case AggregatorResource.RESOURCE__ANALYSIS_FINISHED:
					analysisStarted = false;
				case Resource.RESOURCE__RESOURCE_SET:
				case Resource.RESOURCE__IS_LOADED:
				case Resource.RESOURCE__ERRORS:
				case Resource.RESOURCE__WARNINGS: {
					Resource resource = (Resource) notification.getNotifier();

					// filter out notifications when analysing aggregator repository
					if (resource instanceof AggregatorResourceImpl && analysisStarted)
						return;

					if (resource instanceof AggregatorResourceImpl) {
						Diagnostic diagnostic = analyzeResourceProblems(resource, null);

						if (diagnostic.getSeverity() != Diagnostic.OK) {
							resourceToDiagnosticMap.put(resource, diagnostic);
						} else {
							resourceToDiagnosticMap.remove(resource);
						}

						if (updateProblemIndication) {
							getSite().getShell().getDisplay().asyncExec(new Runnable() {

								@Override
								public void run() {
									updateProblemIndication();
								}

							});
						}
					}

					if (resource.getResourceSet() == null)
						managedResourceToDiagnosticMap.remove(resource);
					else {
						Diagnostic diagnostic = analyzeResourceProblems(resource, null, true);

						if (diagnostic.getSeverity() != Diagnostic.OK)
							managedResourceToDiagnosticMap.put(resource, diagnostic);
						else
							managedResourceToDiagnosticMap.remove(resource);
					}

					updateMarkers();
					break;
				}
			}
		}

		@Override
		protected void setTarget(Resource target) {
			basicSetTarget(target);
		}

		@Override
		protected void unsetTarget(Resource target) {
			basicUnsetTarget(target);
		}

		private void updateMarkers() {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					synchronized (AggregatorEditor.this) {
						while (updateMarkers)
							try {
								updateMarkers = false;
								updateMarkersIsRunning = true;

								// only aggregatorResource is a file and can be used for markers
								Resource aggregatorResource = editingDomain.getResourceSet().getResources().get(0);
								BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.OK,
										"org.eclipse.cbi.p2repo.aggregator.editor", 0, null, null);

								for (Diagnostic diagnostic : managedResourceToDiagnosticMap.values())
									basicDiagnostic.add(diagnostic);

								managedMarkerHelper.deleteMarkers(aggregatorResource);
								if (basicDiagnostic.getSeverity() != Diagnostic.OK) {
									try {
										managedMarkerHelper.createMarkers(aggregatorResource, basicDiagnostic);
									} catch (CoreException exception) {
										AggregatorEditorPlugin.INSTANCE.log(exception);
									}
								}
							} finally {
								updateMarkersIsRunning = false;
							}
					}
				}

			};

			if (updateMarkers)
				return;

			updateMarkers = true;

			if (updateMarkersIsRunning)
				return;

			new Thread(runnable).start();
		}

	};

	/**
	 * This listens for workspace changes.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();
			try {
				class ResourceDeltaVisitor implements IResourceDeltaVisitor {
					protected ResourceSet resourceSet = editingDomain.getResourceSet();
					protected Collection<Resource> changedResources = new ArrayList<>();
					protected Collection<Resource> removedResources = new ArrayList<>();

					@Override
					public boolean visit(IResourceDelta delta) {
						if (delta.getResource().getType() == IResource.FILE) {
							if (delta.getKind() == IResourceDelta.REMOVED || delta.getKind() == IResourceDelta.CHANGED
									&& delta.getFlags() != IResourceDelta.MARKERS) {
								Resource resource = resourceSet.getResource(
										URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
								if (resource != null) {
									if (delta.getKind() == IResourceDelta.REMOVED) {
										removedResources.add(resource);
									} else if (!savedResources.remove(resource)) {
										changedResources.add(resource);
									}
								}
							}
							return false;
						}

						return true;
					}

					public Collection<Resource> getChangedResources() {
						return changedResources;
					}

					public Collection<Resource> getRemovedResources() {
						return removedResources;
					}
				}

				final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
				delta.accept(visitor);

				if (!visitor.getRemovedResources().isEmpty()) {
					getSite().getShell().getDisplay().asyncExec(new Runnable() {
						@Override
						public void run() {
							removedResources.addAll(visitor.getRemovedResources());
							if (!isDirty()) {
								getSite().getPage().closeEditor(AggregatorEditor.this, false);
							}
						}
					});
				}

				if (!visitor.getChangedResources().isEmpty()) {
					getSite().getShell().getDisplay().asyncExec(new Runnable() {
						@Override
						public void run() {
							changedResources.addAll(visitor.getChangedResources());
							if (getSite().getPage().getActiveEditor() == AggregatorEditor.this) {
								handleActivate();
							}
						}
					});
				}
			} catch (CoreException exception) {
				AggregatorEditorPlugin.INSTANCE.log(exception);
			}
		}
	};

	/**
	 * This creates a model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatorEditor() {
		super();
		initializeEditingDomain();
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/**
	 * Returns a diagnostic describing the errors and warnings listed in the resource and the specified exception (if
	 * any).
	 *
	 * @generated NOT
	 */
	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
		return analyzeResourceProblems(resource, exception, false);
	}

	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception, boolean managedProblems) {
		if (resource != null && (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty())) {
			synchronized (resource) {
				BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.ERROR,
						"org.eclipse.cbi.p2repo.aggregator.editor", 0,
						getString("_UI_CreateModelError_message", resource.getURI()),
						new Object[] { exception == null ? (Object) resource : exception });
				Diagnostic diagnostic = computeDiagnostic(resource, true, true, managedProblems);

				if (diagnostic.getSeverity() == Diagnostic.OK
						&& (diagnostic.getChildren() == null || diagnostic.getChildren().size() == 0))
					return Diagnostic.OK_INSTANCE;

				basicDiagnostic.merge(diagnostic);
				return basicDiagnostic;
			}
		} else if (exception != null) {
			return new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.cbi.p2repo.aggregator.editor", 0,
					getString("_UI_CreateModelError_message", resource == null ? null : resource.getURI()),
					new Object[] { exception });
		} else {
			return Diagnostic.OK_INSTANCE;
		}
	}

	private Diagnostic computeDiagnostic(Resource resource, boolean includeWarnings, boolean includeInfos,
			boolean managedProblems) {
		if (resource.getErrors().isEmpty() && (!includeWarnings || resource.getWarnings().isEmpty()))
			return Diagnostic.OK_INSTANCE;

		BasicDiagnostic basicDiagnostic = new BasicDiagnostic();
		for (Resource.Diagnostic resourceDiagnostic : resource.getErrors()) {
			if (managedProblems) {
				if (!(resourceDiagnostic instanceof ResourceDiagnosticImpl))
					continue;
			} else {
				if (resourceDiagnostic instanceof ResourceDiagnosticImpl)
					continue;
			}

			Diagnostic diagnostic = null;
			if (resourceDiagnostic instanceof Throwable) {
				diagnostic = BasicDiagnostic.toDiagnostic((Throwable) resourceDiagnostic);
			} else {
				String messagePrefix = "";

				if (resourceDiagnostic instanceof ResourceDiagnosticImpl)
					messagePrefix = getLabelPrefix(resourceDiagnostic.getLocation());

				diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.emf.ecore.resource", 0,
						messagePrefix + resourceDiagnostic.getMessage(), new Object[] { resourceDiagnostic });
			}
			basicDiagnostic.add(diagnostic);
		}

		if (includeWarnings) {
			for (Resource.Diagnostic resourceDiagnostic : resource.getWarnings()) {
				if (managedProblems) {
					if (!(resourceDiagnostic instanceof ResourceDiagnosticImpl))
						continue;
				} else {
					if (resourceDiagnostic instanceof ResourceDiagnosticImpl)
						continue;
				}

				Diagnostic diagnostic = null;
				if (resourceDiagnostic instanceof Throwable) {
					diagnostic = BasicDiagnostic.toDiagnostic((Throwable) resourceDiagnostic);
				} else {
					String messagePrefix = "";

					if (resourceDiagnostic instanceof ResourceDiagnosticImpl)
						messagePrefix = getLabelPrefix(resourceDiagnostic.getLocation());

					diagnostic = new BasicDiagnostic(Diagnostic.WARNING, "org.eclipse.emf.ecore.resource", 0,
							messagePrefix + resourceDiagnostic.getMessage(), new Object[] { resourceDiagnostic });
				}
				basicDiagnostic.add(diagnostic);
			}
		}

		if (includeInfos && resource instanceof AggregatorResource) {
			for (Resource.Diagnostic resourceDiagnostic : ((AggregatorResource) resource).getInfos()) {
				if (managedProblems) {
					if (!(resourceDiagnostic instanceof ResourceDiagnosticImpl))
						continue;
				} else {
					if (resourceDiagnostic instanceof ResourceDiagnosticImpl)
						continue;
				}

				Diagnostic diagnostic = null;
				if (resourceDiagnostic instanceof Throwable) {
					diagnostic = BasicDiagnostic.toDiagnostic((Throwable) resourceDiagnostic);
				} else {
					String messagePrefix = "";

					if (resourceDiagnostic instanceof ResourceDiagnosticImpl)
						messagePrefix = getLabelPrefix(resourceDiagnostic.getLocation());

					diagnostic = new BasicDiagnostic(Diagnostic.INFO, "org.eclipse.emf.ecore.resource", 0,
							messagePrefix + resourceDiagnostic.getMessage(), new Object[] { resourceDiagnostic });
				}
				basicDiagnostic.add(diagnostic);
			}
		}

		return basicDiagnostic;
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well registering the menu for extension.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance(), LocalSelectionTransfer.getTransfer(),
				FileTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
	}

	/**
	 * Get model instance resource and then initialize all repositories contained in the model using a progress bar.
	 */
	public void createModel() {
		// get model instance resource
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Exception exception = null;
		Resource resource = null;
		ResourceSet resourceSet = editingDomain.getResourceSet();
		if (ResourceUtils.isCurrentModel(resourceURI)
				|| DetachContributionResourceAction.CONTRIBUTION_FILE_EXTENSION.equals(resourceURI.fileExtension()))
			try {
				// Load the resource through the editing domain.
				//
				resource = resourceSet.getResource(resourceURI, true);
			} catch (Exception e) {
				exception = e;
				resource = resourceSet.getResource(resourceURI, false);
			}
		else {
			TransformationWizard tz = new TransformationWizard(resourceURI);
			tz.init(getEditorSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection) getSelection());

			WizardDialog wd = new WizardDialog(getEditorSite().getShell(), tz);
			wd.setHelpAvailable(false);

			if (wd.open() == 0) {
				resource = tz.getTargetResource();
				resourceSet.getResources().add(resource);

				IFile modelFile = tz.getModelFile();
				setPartName(modelFile.getName());
				setInput(new FileEditorInput(modelFile));
			} else {
				throw new RuntimeException("Deprecated resource was not transformed");
			}

			// initialize all repositories
			resourceURI = EditUIUtil.getURI(getEditorInput());
			resource = resourceSet.getResource(resourceURI, false);
		}

		if (resource == null)
			return;

		EList<EObject> contents = resource.getContents();
		if (contents.size() != 1)
			return;

		// make sure detached resources are resolved
		EcoreUtil.resolveAll(resource);
		for (Resource otherResource : new ArrayList<>(resourceSet.getResources())) {
			Diagnostic diagnostic = analyzeResourceProblems(otherResource, null);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				resourceToDiagnosticMap.put(otherResource, diagnostic);
			} else {
				resourceToDiagnosticMap.remove(otherResource);
			}
		}

		EObject obj = contents.get(0);

		if (obj instanceof Contribution) {
			for (Resource otherResource : new ArrayList<>(resourceSet.getResources())) {
				EList<EObject> otherResourceContents = otherResource.getContents();
				if (contents.size() == 1) {
					EObject eObject = otherResourceContents.get(0);
					if (eObject instanceof Aggregation) {
						try {
							IEditorPart editor = openEditor(eObject);
							if (editor instanceof AggregatorEditor) {
								getContainer().getDisplay().asyncExec(() -> {
									URI objURI = EcoreUtil.getURI(obj);
									AggregatorEditor aggregatorEditor = (AggregatorEditor) editor;
									EObject otherContribution = aggregatorEditor.getEditingDomain().getResourceSet()
											.getEObject(objURI, true);
									aggregatorEditor.setSelectionToViewer(Collections.singleton(otherContribution));
									aggregatorEditor.selectionViewer.expandToLevel(otherContribution, 2);
									getEditorSite().getPage().closeEditor(this, false);
								});
							}
						} catch (PartInitException e) {
							AggregatorEditorPlugin.INSTANCE.log(exception);
						}
					}
				}
			}
		}

		if (!(obj instanceof Aggregation))
			return;

		EcoreUtil.resolveAll(resourceSet);

		resourceSet.eAdapters().add(problemIndicationAdapter);

		Aggregation aggregation = (Aggregation) obj;
		repositoryBrowser = P2viewFactory.eINSTANCE.createRepositoryBrowser(aggregation);

		// initialize item providers for all MDR references so that they could handle notifications from
		// repository loaders
		// + set all proxies to null so that no one tries to resolve them (the MDR's will be set by loaders)
		for (MetadataRepositoryReference mdrReference : aggregation.getAllMetadataRepositoryReferences(false)) {
			mdrReference.setMetadataRepository(null);
			adapterFactory.adapt(mdrReference, IItemLabelProvider.class);
		}

		repositoryLoadingJob = new RepositoryLoaderJob(aggregation.getAllMetadataRepositoryReferences(true));
		repositoryLoadingJob.setSystem(true);
	}

	/**
	 * This is the method used by the framework to install your own controls.
	 *
	 * @generated NOT
	 */
	@Override
	public void createPages() {
		createPagesGen();

		Runnable showPropertiesView = () -> {
			try {
				getEditorSite().getPage().showView("org.eclipse.ui.views.PropertySheet", null,
						IWorkbenchPage.VIEW_VISIBLE);
			} catch (PartInitException exception) {
				AggregatorEditorPlugin.INSTANCE.log(exception);
			}
		};
		showPropertiesView.run();

		selectionViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				TreePath path = ((TreeSelection) event.getSelection()).getPaths()[0];

				if (selectionViewer.getExpandedState(path))
					selectionViewer.collapseToLevel(path, 1);
				else
					selectionViewer.expandToLevel(path, 1);

				showPropertiesView.run();
			}

		});

		selectionViewer.getTree().addMouseMoveListener(new MouseMoveListener() {

			private TreeItem lastTreeItem;

			@Override
			public void mouseMove(MouseEvent e) {
				TreeItem item = selectionViewer.getTree().getItem(new Point(e.x, e.y));

				if (item == lastTreeItem)
					return;

				String toolTipText = null;

				if (item != null && item.getData() != null) {
					Object unwrappedData = AdapterFactoryEditingDomain.unwrap(item.getData());
					IEditingDomainItemProvider provider = (IEditingDomainItemProvider) adapterFactory
							.getRootAdapterFactory().adapt(unwrappedData, IEditingDomainItemProvider.class);
					if (provider instanceof TooltipTextProvider)
						toolTipText = ((TooltipTextProvider) provider).getTooltipText(unwrappedData);
				}

				selectionViewer.getTree().setToolTipText(toolTipText);

				lastTreeItem = item;
			}

		});

		Object[] elements = ((IStructuredContentProvider) selectionViewer.getContentProvider())
				.getElements(selectionViewer.getInput());
		if (elements.length > 0) {
			selectionViewer.setSelection(new StructuredSelection(elements[0]), true);
		}

		if (repositoryLoadingJob != null) {
			repositoryLoadingJob.schedule();
			repositoryLoadingJob = null;
		}
	}

	/**
	 * This is the method used by the framework to install your own controls.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPagesGen() {
		// Creates the model from the editor input
		//
		createModel();

		// Only creates the other pages if there is something that can be edited
		//
		if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
			// Create a page for the selection tree view.
			//
			Tree tree = new Tree(getContainer(), SWT.MULTI);
			selectionViewer = new TreeViewer(tree);
			setCurrentViewer(selectionViewer);

			selectionViewer.setUseHashlookup(true);
			selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			selectionViewer.setLabelProvider(
					new AdapterFactoryLabelProvider.FontAndColorProvider(adapterFactory, selectionViewer));
			selectionViewer.setInput(editingDomain.getResourceSet());
			selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)),
					true);

			new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

			createContextMenuFor(selectionViewer);
			int pageIndex = addPage(tree);
			setPageText(pageIndex, getString("_UI_SelectionPage_label"));

			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					if (!getContainer().isDisposed()) {
						setActivePage(0);
					}
				}
			});
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener(new ControlAdapter() {
			boolean guard = false;

			@Override
			public void controlResized(ControlEvent event) {
				if (!guard) {
					guard = true;
					hideTabs();
					guard = false;
				}
			}
		});

		getSite().getShell().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				updateProblemIndication();
			}
		});
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose() {
		updateProblemIndication = false;

		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);

		getSite().getPage().removePartListener(partListener);

		adapterFactory.dispose();

		if (getActionBarContributor().getActiveEditor() == this) {
			getActionBarContributor().setActiveEditor(null);
		}

		for (PropertySheetPage propertySheetPage : propertySheetPages) {
			propertySheetPage.dispose();
		}

		if (contentOutlinePage != null) {
			contentOutlinePage.dispose();
		}

		super.dispose();
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);

		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			// This is the method that gets invoked when the operation runs.
			//
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				List<Resource> resources = editingDomain.getResourceSet().getResources();
				for (int i = 0; i < resources.size(); ++i) {
					Resource resource = resources.get(i);
					if ((first || !resource.getContents().isEmpty() || isPersisted(resource))
							&& !editingDomain.isReadOnly(resource)) {
						try {
							long timeStamp = resource.getTimeStamp();
							resource.save(saveOptions);
							if (resource.getTimeStamp() != timeStamp) {
								savedResources.add(resource);
							}
						} catch (Exception exception) {
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
						first = false;
					}
				}
			}
		};

		updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			AggregatorEditorPlugin.INSTANCE.log(exception);
		}
		updateProblemIndication = true;
		updateProblemIndication();
	}

	/**
	 * This also changes the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor = getActionBars().getStatusLineManager() != null
				? getActionBars().getStatusLineManager().getProgressMonitor()
				: new NullProgressMonitor();
		doSave(progressMonitor);
	}

	public boolean findNextIU(boolean forward) {
		if (findIUIdPattern == null || findIUVersionRange == null)
			return false;

		TreeSelection treeSelection = (TreeSelection) getSelection();
		Object[] currentSelection = null;
		if (treeSelection != null && treeSelection.getPaths().length > 0) {
			TreePath path = treeSelection.getPaths()[0];
			currentSelection = new Object[path.getSegmentCount()];
			for (int i = 0; i < path.getSegmentCount(); i++)
				currentSelection[i] = path.getSegment(i);
		}

		boolean firstResourceFound = false;
		Object[] foundNode = null;

		List<Resource> resources = new ArrayList<>(editingDomain.getResourceSet().getResources());
		if (!forward)
			Collections.reverse(resources);

		for (Resource resource : resources) {
			if (!(resource instanceof MetadataRepositoryResourceImpl))
				continue;

			if (!firstResourceFound)
				if (currentSelection == null || !(currentSelection[0] instanceof MetadataRepositoryResourceImpl)
						|| resource == currentSelection[0])
					firstResourceFound = true;
				else
					continue;

			foundNode = ((MetadataRepositoryResourceImpl) resource).findIUPresentation(findIUIdPattern,
					findIUVersionRange, currentSelection, forward);
			if (foundNode != null)
				break;
		}

		if (foundNode != null) {
			if (foundNode[0] instanceof MetadataRepositoryStructuredView) {
				Object[] fullPath = new Object[foundNode.length + 1];
				fullPath[0] = repositoryBrowser;
				System.arraycopy(foundNode, 0, fullPath, 1, foundNode.length);
				foundNode = fullPath;
			}
			getViewer().setSelection(new TreeSelection(new TreePath(foundNode)), true);
			return true;
		}

		return false;
	}

	private Resource findResource(URI uri) {
		if (uri == null)
			return null;

		for (Resource resource : new ArrayList<>(editingDomain.getResourceSet().getResources()))
			if (uri.equals(resource.getURI()))
				return resource;

		return null;
	}

	/**
	 * This is here for the listener to be able to call it.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor) getEditorSite().getActionBarContributor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}

	/**
	 * This is how the framework determines which interfaces we implement.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T> T getAdapter(Class<T> key) {
		if (key.equals(IContentOutlinePage.class)) {
			return showOutlineView() ? key.cast(getContentOutlinePage()) : null;
		} else if (key.equals(IPropertySheetPage.class)) {
			return key.cast(getPropertySheetPage());
		} else if (key.equals(IGotoMarker.class)) {
			return key.cast(this);
		} else {
			return super.getAdapter(key);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * This accesses a cached version of the content outliner.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			// The content outline is just a tree.
			//
			class MyContentOutlinePage extends ContentOutlinePage {
				@Override
				public void createControl(Composite parent) {
					super.createControl(parent);
					contentOutlineViewer = getTreeViewer();
					contentOutlineViewer.addSelectionChangedListener(this);

					// Set up the tree viewer.
					//
					contentOutlineViewer.setUseHashlookup(true);
					contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
					contentOutlineViewer.setLabelProvider(
							new AdapterFactoryLabelProvider.FontAndColorProvider(adapterFactory, contentOutlineViewer));
					contentOutlineViewer.setInput(editingDomain.getResourceSet());

					// Make sure our popups work.
					//
					createContextMenuFor(contentOutlineViewer);

					if (!editingDomain.getResourceSet().getResources().isEmpty()) {
						// Select the root object in the view.
						//
						contentOutlineViewer.setSelection(
								new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
					}
				}

				@Override
				public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager,
						IStatusLineManager statusLineManager) {
					super.makeContributions(menuManager, toolBarManager, statusLineManager);
					contentOutlineStatusLineManager = statusLineManager;
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this, actionBars);
				}
			}

			contentOutlinePage = new MyContentOutlinePage();

			// Listen to selection so that we can handle it is a special way.
			//
			contentOutlinePage.addSelectionChangedListener(new ISelectionChangedListener() {
				// This ensures that we handle selections correctly.
				//
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					handleContentOutlineSelection(event.getSelection());
				}
			});
		}

		return contentOutlinePage;
	}

	/**
	 * This returns the editing domain as required by the {@link IEditingDomainProvider} interface.
	 * This is important for implementing the static methods of {@link AdapterFactoryEditingDomain}
	 * and for supporting {@link org.eclipse.emf.edit.ui.action.CommandAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class ReverseAdapterFactoryContentProvider extends AdapterFactoryContentProvider {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ReverseAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Object[] getElements(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Object[] getChildren(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public boolean hasChildren(Object object) {
			Object parent = super.getParent(object);
			return parent != null;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Object getParent(Object object) {
			return null;
		}
	}

	private String getLabelPrefix(String location) {
		if (location != null) {
			URI uri = URI.createURI(location);
			if (uri != null && uri.fragment() != null) {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				synchronized (resourceSet) {
					EObject eObject = resourceSet.getEObject(uri, true);
					if (eObject != null) {
						IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.getRootAdapterFactory()
								.adapt(eObject, IItemLabelProvider.class);

						if (labelProvider != null)
							return labelProvider.getText(eObject) + ": ";
					}
				}
			}
		}

		return "";
	}

	/**
	 * This accesses a cached version of the property sheet.
	 *
	 * @generated NOT
	 */
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage = new ExtendedPropertySheetPage(editingDomain) {

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this, actionBars);
				}

				@Override
				public void setSelectionToViewer(List<?> selection) {
					AggregatorEditor.this.setSelectionToViewer(selection);
					AggregatorEditor.this.setFocus();
				}

			};
			propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory) {

				@Override
				protected IPropertySource createPropertySource(final Object object,
						IItemPropertySource itemPropertySource) {
					return new PropertySource(object, itemPropertySource) {

						@Override
						protected IPropertyDescriptor createPropertyDescriptor(
								IItemPropertyDescriptor itemPropertyDescriptor) {
							return new PropertyDescriptor(object, itemPropertyDescriptor) {

								@Override
								public CellEditor createPropertyEditor(Composite composite) {
									if (!itemPropertyDescriptor.canSetProperty(object)) {
										return null;
									}

									final EStructuralFeature feature = (EStructuralFeature) itemPropertyDescriptor
											.getFeature(object);
									final EClassifier eType = feature.getEType();

									if (VersionRange.class.isAssignableFrom(eType.getInstanceClass())) {
										final ILabelProvider editLabelProvider = getEditLabelProvider();

										return new ExtendedDialogCellEditor(composite, editLabelProvider) {

											@Override
											protected Object openDialogBox(Control cellEditorWindow) {
												VersionRangeEditorDialog dialog = new VersionRangeEditorDialog(
														cellEditorWindow.getShell(), editLabelProvider, doGetValue(),
														object);
												dialog.open();
												return dialog.getResult();
											}

										};
									}

									return super.createPropertyEditor(composite);
								}

							};
						}

					};
				}

			});
		}

		return propertySheetPage;
	}

	RepositoryBrowser getRepositoryBrowser() {
		return repositoryBrowser;
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to return this editor's overall selection.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ISelection getSelection() {
		return editorSelection;
	}

	/**
	 * This returns the viewer as required by the {@link IViewerProvider} interface.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Viewer getViewer() {
		return currentViewer;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public void gotoMarker(IMarker marker) {
		try {
			if (marker.getType().equals(EValidator.MARKER) || marker.getType().startsWith(AGGREGATOR_PROBLEM_MARKER)) {
				String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
				if (uriAttribute != null) {
					URI uri = URI.createURI(uriAttribute);
					if (uri.fragment() != null) {
						EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
						if (eObject != null)
							setSelectionToViewer(Collections.singleton(editingDomain.getWrapper(eObject)));
					} else {
						Resource resource = findResource(uri);
						if (resource != null)
							setSelectionToViewer(Collections.singleton(resource));
					}
				}
			}
		} catch (CoreException exception) {
			AggregatorEditorPlugin.INSTANCE.log(exception);
		}
	}

	/**
	 * Handles activation of the editor or it's associated views.
	 *
	 * @generated NOT
	 */
	protected void handleActivate() {
		// Recompute the read only state.
		//
		if (editingDomain.getResourceToReadOnlyMap() != null) {
			editingDomain.getResourceToReadOnlyMap().clear();

			// Refresh any actions that may become enabled or disabled.
			//
			setSelection(getSelection());
		}

		if (!removedResources.isEmpty()) {
			if (handleDirtyConflict()) {
				getSite().getPage().closeEditor(AggregatorEditor.this, false);
			} else {
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
			}
		} else if (!changedResources.isEmpty()) {
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
		}

		AggregatorEditorPlugin.INSTANCE.setActiveEditingDomain(editingDomain);
		contextActivation = getSite().getWorkbenchWindow().getWorkbench().getAdapter(IContextService.class)
				.activateContext(AGGREGATOR_EDITOR_SCOPE);
	}

	/**
	 * Handles what to do with changed resources on activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void handleChangedResources() {
		if (!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict())) {
			ResourceSet resourceSet = editingDomain.getResourceSet();
			if (isDirty()) {
				changedResources.addAll(resourceSet.getResources());
			}
			editingDomain.getCommandStack().flush();

			updateProblemIndication = false;
			for (Resource resource : changedResources) {
				if (resource.isLoaded()) {
					resource.unload();
					try {
						resource.load(resourceSet.getLoadOptions());
					} catch (IOException exception) {
						if (!resourceToDiagnosticMap.containsKey(resource)) {
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
					}
				}
			}

			if (AdapterFactoryEditingDomain.isStale(editorSelection)) {
				setSelection(StructuredSelection.EMPTY);
			}

			updateProblemIndication = true;
			updateProblemIndication();
		}
	}

	/**
	 * This deals with how we want selection in the outliner to affect the other views.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void handleContentOutlineSelection(ISelection selection) {
		if (selectionViewer != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection) selection).iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				ArrayList<Object> selectionList = new ArrayList<>();
				selectionList.add(selectedElement);
				while (selectedElements.hasNext()) {
					selectionList.add(selectedElements.next());
				}

				// Set the selection to the widget.
				//
				selectionViewer.setSelection(new StructuredSelection(selectionList));
			}
		}
	}

	protected void handleDeactivate() {
		AggregatorEditorPlugin.INSTANCE.setActiveEditingDomain(null);

		if (contextActivation != null)
			getSite().getWorkbenchWindow().getWorkbench().getAdapter(IContextService.class)
					.deactivateContext(contextActivation);
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean handleDirtyConflict() {
		return MessageDialog.openQuestion(getSite().getShell(), getString("_UI_FileConflict_label"),
				getString("_WARN_FileConflict"));
	}

	/**
	 * If there is just one page in the multi-page editor part,
	 * this hides the single tab at the bottom.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void hideTabs() {
		if (getPageCount() <= 1) {
			setPageText(0, "");
			if (getContainer() instanceof CTabFolder) {
				Point point = getContainer().getSize();
				Rectangle clientArea = getContainer().getClientArea();
				getContainer().setSize(point.x, 2 * point.y - clientArea.height - clientArea.y);
			}
		}
	}

	/**
	 * This is called during startup.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		site.setSelectionProvider(this);
		site.getPage().addPartListener(partListener);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener,
				IResourceChangeEvent.POST_CHANGE);
	}

	/**
	 * This sets up the editing domain for the model editor.
	 *
	 * @generated NOT
	 */
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		// Assign specific images to resources
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory() {
			// Present only the main resource and loaded MDR's (not detached contributions)
			@Override
			public Adapter createResourceSetAdapter() {
				AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
						adapterFactory);
				Comparator<String> stringComparator = CommonPlugin.INSTANCE.getComparator();
				Comparator<Object> objectComparator = new Comparator<>() {
					@Override
					public int compare(Object o1, Object o2) {
						return stringComparator.compare(adapterFactoryItemDelegator.getText(o1),
								adapterFactoryItemDelegator.getText(o2));
					}
				};

				return new ResourceSetItemProvider(this) {
					@Override
					public Collection<?> getChildren(Object object) {
						ResourceSet resourceSet = (ResourceSet) object;
						List<Object> filtered = new ArrayList<>();
						List<Object> others = new ArrayList<>();
						List<Resource> resources = new ArrayList<>(resourceSet.getResources());
						for (Resource resource : resources) {
							if (resource instanceof AggregatorResource) {
								EList<EObject> contents = resource.getContents();
								if (contents.size() == 1) {
									EObject obj = resource.getContents().get(0);
									if (obj instanceof Aggregation) {
										filtered.add(obj);
									} else {
										others.add(obj);
									}
								}
							}
						}

						if (repositoryBrowser != null) {
							filtered.add(repositoryBrowser);
						}

						others.sort(objectComparator);
						filtered.addAll(others);

						return filtered;
					}
				};
			}
		});

		adapterFactory.addAdapterFactory(new StatusProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new AggregatorItemProviderAdapterFactory());

		// override item providers that should be more specific to aggregator
		adapterFactory.addAdapterFactory(new P2viewItemProviderAdapterFactory());

		adapterFactory.addAdapterFactory(new P2viewItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with
		// focus.
		//
		commandStack.addCommandStackListener(new CommandStackListener() {

			@Override
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {

					@Override
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);

						// Try to select the affected objects.
						//
						Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
						if (mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand.getAffectedObjects());
						}
						if (propertySheetPage != null && !propertySheetPage.getControl().isDisposed()) {
							propertySheetPage.refresh();
						}
					}

				});
			}

		});

		// Create the editing domain with a special command stack and a shared clipboard.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<>()) {

			{
				final ResourceSet resourceSet = getResourceSet();

				resourceSet.setResourceFactoryRegistry(new ResourceFactoryRegistryImpl() {

					private OverrideMap<String, Object> extensionToFactoryOverrideMap = new OverrideMap<>(
							Collections.singletonMap(Resource.Factory.Registry.DEFAULT_EXTENSION,
									new AggregatorResourceFactoryImpl()));

					@Override
					protected Resource.Factory delegatedGetFactory(URI uri, String contentTypeIdentifier) {
						return convert(getFactory(uri, Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap(),
								// override the default extension resource factory
								extensionToFactoryOverrideMap
										.override(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()),
								Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap(), contentTypeIdentifier,
								false));
					}

					@Override
					protected Map<?, ?> getContentDescriptionOptions() {
						return resourceSet.getLoadOptions();
					}

					@Override
					protected URIConverter getURIConverter() {
						return resourceSet.getURIConverter();
					}

				});
			}

			@Override
			public Command createCommand(Class<? extends Command> commandClass, CommandParameter commandParameter) {
				if (commandClass == DeleteCommand.class) {
					Collection<?> collection = commandParameter.getCollection();
					List<Object> expandedCollection = new ArrayList<>();
					for (Object object : collection) {
						Object unwrappedObject = AdapterFactoryEditingDomain.unwrap(object);
						if (unwrappedObject instanceof InternalEObject) {
							InternalEObject eObject = (InternalEObject) unwrappedObject;
							if (eObject.eDirectResource() != null && eObject.eContainer() != null) {
								expandedCollection.addAll(eObject.eContents());
							}
						}
						expandedCollection.add(object);
					}
					return new DeleteCommand(this, expandedCollection);
				}
				return super.createCommand(commandClass, commandParameter);
			}

			@Override
			public Collection<Object> getClipboard() {
				return CLIPBOARD;
			}

			@Override
			public boolean isReadOnly(Resource resource) {
				if (resource instanceof MetadataRepositoryResourceImpl)
					return true;

				return super.isReadOnly(resource);
			}

			@Override
			public void setClipboard(Collection<Object> clipboard) {
				CLIPBOARD = clipboard;
			}

		};
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply tests the command stack.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
	}

	/**
	 * This is for implementing {@link IRevertablePart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void doRevert() {
		ResourceSet resourceSet = editingDomain.getResourceSet();
		List<Resource> resources = resourceSet.getResources();
		List<Resource> unloadedResources = new ArrayList<>();
		updateProblemIndication = false;
		for (int i = 0; i < resources.size(); ++i) {
			Resource resource = resources.get(i);
			if (resource.isLoaded() && isPersisted(resource)) {
				resource.unload();
				unloadedResources.add(resource);
			}
		}

		resourceToDiagnosticMap.clear();
		for (Resource resource : unloadedResources) {
			try {
				resource.load(resourceSet.getLoadOptions());
			} catch (IOException exception) {
				if (!resourceToDiagnosticMap.containsKey(resource)) {
					resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
				}
			}
		}

		editingDomain.getCommandStack().flush();

		if (AdapterFactoryEditingDomain.isStale(editorSelection)) {
			setSelection(StructuredSelection.EMPTY);
		}

		for (Resource resource : unloadedResources) {
			if (resource instanceof AggregatorResourceImpl) {
				EList<EObject> contents = resource.getContents();
				if (contents.size() == 1 && contents.get(0) instanceof Aggregation) {
					AggregatorResourceImpl aggregatorResource = (AggregatorResourceImpl) resource;
					aggregatorResource.analyzeResource();
					break;
				}
			}
		}

		for (Resource resource : resources) {
			if (resource instanceof MetadataRepositoryResourceImpl) {
				((MetadataRepositoryResourceImpl) resource).startAsynchronousLoad(false);
			}
		}

		selectionViewer.setInput(selectionViewer.getInput());

		updateProblemIndication = true;
		updateProblemIndication();
	}

	protected boolean isPersisted(Resource resource) {
		return (resource instanceof MetadataRepositoryResourceImpl) ? false : isPersistedGen(resource);
	}

	/**
	 * This returns whether something has been persisted to the URI of the specified resource.
	 * The implementation uses the URI converter from the editor's resource set to try to open an input stream.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean isPersistedGen(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		} catch (IOException e) {
			// Ignore
		}
		return result;
	}

	/**
	 * This always returns true because it is not currently supported.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions from the Edit menu.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
		((IMenuListener) getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
	}

	/**
	 * This is used to track the active viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void pageChange(int pageIndex) {
		super.pageChange(pageIndex);

		if (contentOutlinePage != null) {
			handleContentOutlineSelection(contentOutlinePage.getSelection());
		}
	}

	public void registerFindIUArguments(Pattern idPattern, VersionRange versionRange) {
		findIUIdPattern = idPattern;
		findIUVersionRange = versionRange;
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/**
	 * This makes sure that one content viewer, either for the current page or the outline view, if it has focus,
	 * is the current one.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentViewer(Viewer viewer) {
		// If it is changing...
		//
		if (currentViewer != viewer) {
			if (selectionChangedListener == null) {
				// Create the listener on demand.
				//
				selectionChangedListener = new ISelectionChangedListener() {
					// This just notifies those things that are affected by the section.
					//
					@Override
					public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
						setSelection(selectionChangedEvent.getSelection());
					}
				};
			}

			// Stop listening to the old one.
			//
			if (currentViewer != null) {
				currentViewer.removeSelectionChangedListener(selectionChangedListener);
			}

			// Start listening to the new one.
			//
			if (viewer != null) {
				viewer.addSelectionChangedListener(selectionChangedListener);
			}

			// Remember it.
			//
			currentViewer = viewer;

			// Set the editors selection based on the current viewer's selection.
			//
			setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFocus() {
		getControl(getActivePage()).setFocus();
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to set this editor's overall selection.
	 * Calling this result will notify the listeners.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
		setStatusLineManager(selection);
	}

	/**
	 * This sets the selection into whichever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		// Make sure it's okay.
		//
		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					// Try to select the items in the current content viewer of the editor.
					//
					if (currentViewer != null) {
						currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
					}
				}
			};
			getSite().getShell().getDisplay().asyncExec(runnable);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusLineManager(ISelection selection) {
		IStatusLineManager statusLineManager = currentViewer != null && currentViewer == contentOutlineViewer
				? contentOutlineStatusLineManager
				: getActionBars().getStatusLineManager();

		if (statusLineManager != null) {
			if (selection instanceof IStructuredSelection) {
				Collection<?> collection = ((IStructuredSelection) selection).toList();
				switch (collection.size()) {
					case 0: {
						statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
						break;
					}
					case 1: {
						String text = new AdapterFactoryItemDelegator(adapterFactory)
								.getText(collection.iterator().next());
						statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
						break;
					}
					default: {
						statusLineManager
								.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size())));
						break;
					}
				}
			} else {
				statusLineManager.setMessage("");
			}
		}
	}

	/**
	 * Returns whether the outline view should be presented to the user.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean showOutlineView() {
		return false;
	}

	/**
	 * If there is more than one page in the multi-page editor part,
	 * this shows the tabs at the bottom.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void showTabs() {
		if (getPageCount() > 1) {
			setPageText(0, getString("_UI_SelectionPage_label"));
			if (getContainer() instanceof CTabFolder) {
				Point point = getContainer().getSize();
				Rectangle clientArea = getContainer().getClientArea();
				getContainer().setSize(point.x, clientArea.height + clientArea.y);
			}
		}
	}

	/**
	 * Updates the problems indication with the information described in the specified diagnostic.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void updateProblemIndication() {
		if (updateProblemIndication) {
			BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, "org.eclipse.cbi.p2repo.aggregator.editor",
					0, null, new Object[] { editingDomain.getResourceSet() });
			for (Diagnostic childDiagnostic : resourceToDiagnosticMap.values()) {
				if (childDiagnostic.getSeverity() != Diagnostic.OK) {
					diagnostic.add(childDiagnostic);
				}
			}

			int lastEditorPage = getPageCount() - 1;
			if (lastEditorPage >= 0 && getEditor(lastEditorPage) instanceof ProblemEditorPart) {
				((ProblemEditorPart) getEditor(lastEditorPage)).setDiagnostic(diagnostic);
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					setActivePage(lastEditorPage);
				}
			} else if (diagnostic.getSeverity() != Diagnostic.OK) {
				ProblemEditorPart problemEditorPart = new ProblemEditorPart();
				problemEditorPart.setDiagnostic(diagnostic);
				problemEditorPart.setMarkerHelper(markerHelper);
				try {
					addPage(++lastEditorPage, problemEditorPart, getEditorInput());
					setPageText(lastEditorPage, problemEditorPart.getPartName());
					setActivePage(lastEditorPage);
					showTabs();
				} catch (PartInitException exception) {
					AggregatorEditorPlugin.INSTANCE.log(exception);
				}
			}

			if (markerHelper.hasMarkers(editingDomain.getResourceSet())) {
				try {
					markerHelper.updateMarkers(diagnostic);
				} catch (CoreException exception) {
					AggregatorEditorPlugin.INSTANCE.log(exception);
				}
			}
		}
	}

	private IEditorPart openEditor(EObject eObject) throws PartInitException {
		if (eObject != null) {
			Resource resource = eObject.eResource();
			if (resource != null) {
				URI uri = resource.getURI();
				if (uri != null) {
					IEditorInput editorInput = null;
					if (uri.isPlatformResource()) {
						String path = uri.toPlatformString(true);
						IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot()
								.findMember(new Path(path));
						if (workspaceResource instanceof IFile) {
							editorInput = new FileEditorInput((IFile) workspaceResource);
						}
					} else {
						editorInput = new URIEditorInput(uri);
					}
					if (editorInput != null) {
						IWorkbench workbench = PlatformUI.getWorkbench();
						IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
						IEditorPart editorPart = page.openEditor(editorInput, getEditorSite().getId());
						return editorPart;
					}
				}
			}
		}
		return null;
	}

}
