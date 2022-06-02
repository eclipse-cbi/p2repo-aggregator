/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.cbi.p2repo.aggregator.engine.internal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.cbi.p2repo.aggregator.engine.Engine;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.internal.p2.core.helpers.LogHelper;
import org.eclipse.equinox.internal.p2.core.helpers.OrderedProperties;
import org.eclipse.equinox.internal.p2.metadata.repository.Messages;
import org.eclipse.equinox.internal.p2.metadata.repository.MetadataRepositoryIO;
import org.eclipse.equinox.internal.p2.metadata.repository.io.MetadataParser;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.MetadataFactory;
import org.eclipse.equinox.p2.metadata.MetadataFactory.InstallableUnitDescription;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.expression.ExpressionUtil;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.spi.AbstractMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.spi.AbstractMetadataRepository.RepositoryState;
import org.eclipse.equinox.p2.repository.spi.RepositoryReference;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.BundleContext;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
@Deprecated
public class InternalMetadataRepositoryIO extends MetadataRepositoryIO {

	private class InternalParser extends MetadataParser implements XMLConstants {

		protected class InternalInstallableUnitHandler extends InstallableUnitHandler {

			private List<InstallableUnitDescription> unitsPointer;

			private InternalRequirementsHandler requirementsHandler = null;

			public InternalInstallableUnitHandler(AbstractHandler parentHandler, Attributes attributes,
					List<InstallableUnitDescription> units) {
				super(parentHandler, attributes, units);
				unitsPointer = units;
			}

			@Override
			protected void finished() {
				if(isValidXML()) {
					super.finished();
					// get the recently added unit and add requirements
					InstallableUnitDescription currentUnit = unitsPointer.get(unitsPointer.size() - 1);
					IRequirement[] requiredCapabilities = (requirementsHandler == null
							? new IRequirement[0]
							: requirementsHandler.getRequirements());
					currentUnit.setRequiredCapabilities(requiredCapabilities);
				}
			}

			@Override
			public void startElement(String name, Attributes attributes) {
				checkCancel();

				if(REQUIREMENTS_ELEMENT.equals(name)) {
					if(requirementsHandler == null) {
						requirementsHandler = new InternalRequirementsHandler(this, attributes);
					}
					else {
						duplicateElement(this, name, attributes);
					}
				}
				else
					super.startElement(name, attributes);
			}
		}

		protected class InternalInstallableUnitsHandler extends AbstractMetadataHandler {
			private ArrayList<InstallableUnitDescription> units;

			public InternalInstallableUnitsHandler(AbstractHandler parentHandler, Attributes attributes) {
				super(parentHandler, INSTALLABLE_UNITS_ELEMENT);
				units = new ArrayList<InstallableUnitDescription>();
			}

			public IInstallableUnit[] getUnits() {
				int size = units.size();
				IInstallableUnit[] result = new IInstallableUnit[size];
				int i = 0;
				for(InstallableUnitDescription desc : units)
					result[i++] = MetadataFactory.createInstallableUnit(desc);
				return result;
			}

			@Override
			public void startElement(String name, Attributes attributes) {
				if(name.equals(INSTALLABLE_UNIT_ELEMENT)) {
					new InternalInstallableUnitHandler(this, attributes, units);
				}
				else {
					invalidElement(name, attributes);
				}
			}
		}

		private final class InternalRepositoryDocHandler extends DocHandler {

			public InternalRepositoryDocHandler(String rootName, RootHandler rootHandler) {
				super(rootName, rootHandler);
			}

			@Override
			public void processingInstruction(String target, String data) throws SAXException {
				if(PI_REPOSITORY_TARGET.equals(target)) {
					Version repositoryVersion = extractPIVersion(target, data);
					if(!XMLConstants.XML_TOLERANCE.isIncluded(repositoryVersion)) {
						throw new SAXException(
							NLS.bind(Messages.io_IncompatibleVersion, repositoryVersion, XMLConstants.XML_TOLERANCE));
					}
				}
			}

		}

		private final class InternalRepositoryHandler extends RootHandler {

			private final String[] required = new String[] { NAME_ATTRIBUTE, TYPE_ATTRIBUTE, VERSION_ATTRIBUTE };

			private final String[] optional = new String[] { DESCRIPTION_ATTRIBUTE, PROVIDER_ATTRIBUTE };

			private InternalInstallableUnitsHandler unitsHandler = null;

			private PropertiesHandler propertiesHandler = null;

			private RepositoryReferencesHandler repositoryReferencesHandler = null;

			private AbstractMetadataRepository repository = null;

			private RepositoryState state = new RepositoryState();

			public InternalRepositoryHandler() {
				super();
			}

			@Override
			protected void finished() {
				if(isValidXML()) {
					state.Properties = (propertiesHandler == null
							? new OrderedProperties(0) //
							: propertiesHandler.getProperties());
					state.Units = (unitsHandler == null
							? new IInstallableUnit[0] //
							: unitsHandler.getUnits());
					state.Repositories = repositoryReferencesHandler == null
							? new RepositoryReference[0]
							: repositoryReferencesHandler.getReferences();
					try {
						// can't create repository if missing type - this is already logged when parsing attributes
						if(state.Type == null)
							return;
						Class<?> clazz = Class.forName(state.Type);
						Object repositoryObject = clazz.newInstance();
						if(repositoryObject instanceof AbstractMetadataRepository) {
							repository = (AbstractMetadataRepository) repositoryObject;
							repository.initialize(state);
						}
					}
					catch(InstantiationException e) {
						// TODO: Throw a SAXException
						e.printStackTrace();
					}
					catch(IllegalAccessException e) {
						// TODO: Throw a SAXException
						e.printStackTrace();
					}
					catch(ClassNotFoundException e) {
						// TODO: Throw a SAXException
						e.printStackTrace();
					}
				}
			}

			public IMetadataRepository getRepository() {
				return repository;
			}

			@Override
			protected void handleRootAttributes(Attributes attributes) {
				String[] values = parseAttributes(attributes, required, optional);
				Version version = checkVersion(this.elementHandled, VERSION_ATTRIBUTE, values[2]);
				state.Name = values[0];
				state.Type = values[1];
				state.Version = version;
				state.Description = values[3];
				state.Provider = values[4];
				state.Location = null;
			}

			@Override
			public void startElement(String name, Attributes attributes) {
				checkCancel();
				if(PROPERTIES_ELEMENT.equals(name)) {
					if(propertiesHandler == null) {
						propertiesHandler = new PropertiesHandler(this, attributes);
					}
					else {
						duplicateElement(this, name, attributes);
					}
				}
				else if(INSTALLABLE_UNITS_ELEMENT.equals(name)) {
					if(unitsHandler == null) {
						unitsHandler = new InternalInstallableUnitsHandler(this, attributes);
					}
					else {
						duplicateElement(this, name, attributes);
					}
				}
				else if(REPOSITORY_REFERENCES_ELEMENT.equals(name)) {
					if(repositoryReferencesHandler == null) {
						repositoryReferencesHandler = new RepositoryReferencesHandler(this, attributes);
					}
					else {
						duplicateElement(this, name, attributes);
					}
				}
				else {
					invalidElement(name, attributes);
				}
			}
		}

		protected class InternalRequirementHandler extends AbstractHandler {
			private List<IRequirement> requirements;

			private String namespace;

			private String name;

			private Set<Version> versions = null;

			private Set<VersionRange> versionRanges = null;

			private TextHandler filterHandler = null;

			private InternalRequirementVersionsHandler versionsHandler = null;

			public InternalRequirementHandler(AbstractHandler parentHandler, Attributes attributes,
					List<IRequirement> requirements) {
				super(parentHandler, REQUIREMENT_ELEMENT);
				this.requirements = requirements;
				String[] values = parseAttributes(
					attributes, MANDATORY_REQIUREMENT_ATTRIBUTES, OPTIONAL_REQIUREMENT_ATTRIBUTES);
				namespace = values[0];
				name = values[1];
			}

			@Override
			protected void finished() {
				if(isValidXML()) {
					IMatchExpression<IInstallableUnit> filter = null;
					if(filterHandler != null)
						filter = ExpressionUtil.getFactory().matchExpression(
							ExpressionUtil.parse(filterHandler.getText()));
					if(versionsHandler != null) {
						versions = versionsHandler.getVersions();
						versionRanges = versionsHandler.getVersionRanges();
					}
					requirements.add(new MultiRangeRequirement(name, namespace, versions, versionRanges, filter));
				}
			}

			@Override
			public void startElement(String name, Attributes attributes) {
				if (name.equals(REQUIREMENT_FILTER_ELEMENT)) {
					filterHandler = new TextHandler(this, REQUIREMENT_FILTER_ELEMENT, attributes);
				}
				else if(name.equals(REQUIREMENT_VERSIONS_ELEMENT)) {
					versionsHandler = new InternalRequirementVersionsHandler(this);
				}
				else {
					invalidElement(name, attributes);
				}
			}
		}

		protected class InternalRequirementsHandler extends AbstractMetadataHandler {
			private List<IRequirement> requirements;

			public InternalRequirementsHandler(AbstractHandler parentHandler, Attributes attributes) {
				super(parentHandler, REQUIREMENTS_ELEMENT);
				requirements = new ArrayList<IRequirement>();
			}

			public IRequirement[] getRequirements() {
				return requirements.toArray(new IRequirement[requirements.size()]);
			}

			@Override
			public void startElement(String name, Attributes attributes) {
				if(name.equals(REQUIREMENT_ELEMENT)) {
					if(attributes.getIndex(VERSION_RANGE_ATTRIBUTE) != -1)
						new RequirementHandler(this, attributes, requirements);
					else
						new InternalRequirementHandler(this, attributes, requirements);
				}
				else {
					invalidElement(name, attributes);
				}
			}
		}

		protected class InternalRequirementVersionHandler extends AbstractHandler {
			private Version version;

			private Set<Version> versions;

			public InternalRequirementVersionHandler(InternalRequirementVersionsHandler parentHandler,
					Attributes attributes, Set<Version> versions) {
				super(parentHandler, REQUIREMENT_VERSION_ELEMENT);
				this.versions = versions;

				String[] versionString = parseAttributes(
					attributes, new String[] { REQUIREMENT_VERSION_SERIALIZED_ATTRIBUTE }, new String[0]);
				version = Version.create(versionString[0]);
			}

			@Override
			protected void finished() {
				if(isValidXML())
					versions.add(version);
			}

			@Override
			public void startElement(String name, Attributes attributes) throws SAXException {
				invalidElement(name, attributes);
			}
		}

		protected class InternalRequirementVersionRangeHandler extends AbstractHandler {
			private VersionRange versionRange;

			private Set<VersionRange> versionRanges;

			public InternalRequirementVersionRangeHandler(InternalRequirementVersionsHandler parentHandler,
					Attributes attributes, Set<VersionRange> versionRanges) {
				super(parentHandler, REQUIREMENT_VERSION_RANGE_ELEMENT);
				this.versionRanges = versionRanges;

				String[] versionRangeString = parseAttributes(
					attributes, new String[] { REQUIREMENT_VERSION_SERIALIZED_ATTRIBUTE }, new String[0]);
				versionRange = new VersionRange(versionRangeString[0]);
			}

			@Override
			protected void finished() {
				if(isValidXML())
					versionRanges.add(versionRange);
			}

			@Override
			public void startElement(String name, Attributes attributes) throws SAXException {
				invalidElement(name, attributes);
			}
		}

		protected class InternalRequirementVersionsHandler extends AbstractHandler {
			private Set<Version> versions;

			private Set<VersionRange> versionRanges;

			public InternalRequirementVersionsHandler(InternalRequirementHandler parentHandler) {
				super(parentHandler, REQUIREMENT_VERSIONS_ELEMENT);
				versions = new LinkedHashSet<Version>();
				versionRanges = new LinkedHashSet<VersionRange>();
			}

			public Set<VersionRange> getVersionRanges() {
				return versionRanges;
			}

			public Set<Version> getVersions() {
				return versions;
			}

			@Override
			public void startElement(String name, Attributes attributes) throws SAXException {
				if(name.equals(REQUIREMENT_VERSION_ELEMENT)) {
					new InternalRequirementVersionHandler(this, attributes, versions);
				}
				else if(name.equals(REQUIREMENT_VERSION_RANGE_ELEMENT)) {
					new InternalRequirementVersionRangeHandler(this, attributes, versionRanges);
				}
				else {
					invalidElement(name, attributes);
				}
			}
		}

		private IMetadataRepository theRepository = null;

		public InternalParser(BundleContext context, String bundleId) {
			super(bundleId);
		}

		@Override
		protected String getErrorMessage() {
			return Messages.io_parseError;
		}

		public IMetadataRepository getRepository() {
			return theRepository;
		}

		@Override
		protected Object getRootObject() {
			return theRepository;
		}

		public synchronized void parse(InputStream stream, IProgressMonitor monitor) throws IOException {
			this.status = null;
			setProgressMonitor(monitor);
			monitor.beginTask(Messages.repo_loading, IProgressMonitor.UNKNOWN);
			try {
				// TODO: currently not caching the parser since we make no assumptions
				// or restrictions on concurrent parsing
				getParser();
				InternalRepositoryHandler repositoryHandler = new InternalRepositoryHandler();
				xmlReader.setContentHandler(new InternalRepositoryDocHandler(REPOSITORY_ELEMENT, repositoryHandler));
				xmlReader.parse(new InputSource(stream));
				if(isValidXML()) {
					theRepository = repositoryHandler.getRepository();
				}
			}
			catch(SAXException e) {
				if(!(e.getException() instanceof OperationCanceledException))
					throw new IOException(e.getMessage());
			}
			catch(ParserConfigurationException e) {
				throw new IOException(e.getMessage());
			}
			finally {
				monitor.done();
				stream.close();
			}
		}

		@Override
		public String toString() {
			// TODO:
			return null;
		}
	}

	protected class InternalWriter extends Writer {

		public InternalWriter(OutputStream output, Class<? extends IMetadataRepository> repositoryClass)
				throws IOException {
			super(output, repositoryClass);
		}

		protected void writeRequiredCapability(IRequirement requirement) {
			if(requirement instanceof MultiRangeRequirement) {
				MultiRangeRequirement req = (MultiRangeRequirement) requirement;
				start(REQUIREMENT_ELEMENT);
				attribute(NAMESPACE_ATTRIBUTE, req.getNamespace());
				attribute(NAME_ATTRIBUTE, req.getName());
				start(REQUIREMENT_VERSIONS_ELEMENT);
				for(Version version : req.getVersions()) {
					start(REQUIREMENT_VERSION_ELEMENT);
					attribute(REQUIREMENT_VERSION_SERIALIZED_ATTRIBUTE, version);
					end(REQUIREMENT_VERSION_ELEMENT);
				}
				end(REQUIREMENT_VERSIONS_ELEMENT);
				if(requirement.getFilter() != null)
					writeTrimmedCdata(REQUIREMENT_FILTER_ELEMENT, requirement.getFilter().toString());
				end(REQUIREMENT_ELEMENT);
			}
			else {
				super.writeRequirement(requirement);
			}
		}

		private void writeTrimmedCdata(String element, String filter) {
			String trimmed;
			if(filter != null && (trimmed = filter.trim()).length() > 0) {
				start(element);
				cdata(trimmed);
				end(element);
			}
		}

	}

	private interface XMLConstants extends org.eclipse.equinox.internal.p2.metadata.repository.io.XMLConstants {

		// Constants defining the structure of the XML for a MetadataRepository

		// A format version number for metadata repository XML.
		public static final Version COMPATIBLE_VERSION = Version.createOSGi(1, 0, 0);

		public static final VersionRange XML_TOLERANCE = new VersionRange(
			COMPATIBLE_VERSION, true, Version.createOSGi(2, 0, 0), false);

		// Constants for processing Instructions
		public static final String PI_REPOSITORY_TARGET = "metadataRepository"; //$NON-NLS-1$

		// Constants for metadata repository elements
		public static final String REPOSITORY_ELEMENT = "repository"; //$NON-NLS-1$
	}

	private static final String NAMESPACE_ATTRIBUTE = "namespace";

	private static final String NAME_ATTRIBUTE = "name";

	private static final String[] MANDATORY_REQIUREMENT_ATTRIBUTES = new String[] {
			NAMESPACE_ATTRIBUTE, NAME_ATTRIBUTE };

	private static final String[] OPTIONAL_REQIUREMENT_ATTRIBUTES = new String[] {};

	private static final String REQUIREMENT_VERSIONS_ELEMENT = "versions";

	private static final String REQUIREMENT_VERSION_ELEMENT = "version";

	private static final String REQUIREMENT_VERSION_RANGE_ELEMENT = "range";

	private static final String REQUIREMENT_VERSION_SERIALIZED_ATTRIBUTE = "serialized";

	public InternalMetadataRepositoryIO(IProvisioningAgent agent) {
		super(agent);
	}

	/**
	 * returns null if operation cancelled
	 */
	@Override
	public IMetadataRepository read(URL location, InputStream input, IProgressMonitor monitor)
			throws ProvisionException {
		BufferedInputStream bufferedInput = null;
		try {
			try {
				bufferedInput = new BufferedInputStream(input);

				InternalParser repositoryParser = new InternalParser(
						Platform.getBundle(Engine.PLUGIN_ID_METADATA_REPOSITORY).getBundleContext(),
						Engine.PLUGIN_ID_METADATA_REPOSITORY);
				repositoryParser.parse(input, monitor);
				IStatus result = repositoryParser.getStatus();
				switch(result.getSeverity()) {
					case IStatus.CANCEL:
						throw new OperationCanceledException();
					case IStatus.ERROR:
						throw new ProvisionException(result);
					case IStatus.WARNING:
					case IStatus.INFO:
						LogHelper.log(result);
				}
				return repositoryParser.getRepository();
			}
			catch(OperationCanceledException e) {
				LogUtils.info("Operation canceled."); //$NON-NLS-1$
			}
			finally {
				if(bufferedInput != null)
					bufferedInput.close();
			}
		}
		catch(IOException ioe) {
			String msg = NLS.bind(Messages.io_failedRead, location);
			throw new ProvisionException(
					new Status(IStatus.ERROR, Engine.PLUGIN_ID_METADATA_REPOSITORY,
							ProvisionException.REPOSITORY_FAILED_READ, msg, ioe));
		}
		// Only returns null if operation cancelled.
		return null;
	}

	@Override
	public void write(IMetadataRepository repository, OutputStream output) throws IOException {
		OutputStream bufferedOutput = null;
		try {
			bufferedOutput = new BufferedOutputStream(output);
			Writer repositoryWriter = new InternalWriter(bufferedOutput, repository.getClass());
			repositoryWriter.write(repository);
		}
		finally {
			if(bufferedOutput != null) {
				bufferedOutput.close();
			}
		}
	}
}
