# CBI p2 Aggregator

The CBI p2 Aggregator is a tool to combine, i.e., aggregate, several p2 repositories into a single, consistent p2 repository.
The aggregator does a number of things above and beyond simply mirroring the different repositories as directly supported by p2.
- It ensures that all transitive dependencies can be resolved,
  to guarentee that all content of the p2 repository can actually be installed.
- It also offers custom categories since the aggregated repository in most cases will not want to use the same categories as each individual repository uses.
- It can also be configured to produce a hybrid p2/Maven2 repository.

There are many situations where using aggregated repositories is a good solution.
The reasons vary from licensing issues to organizational requirements:

1. **Owners of a p2 repo for a given project may not be in position to host all required or recommended components due to licensing issues** 
   - SVN support one example as it requires components available through the main Eclipse p2 repo as well as third-party components.
     Hence users would normally have to visit several repos for a complete install, but by using the aggregator an institution could create a custom repository that has everything needed.
2. **Projects want to provide convenient access to their products**
   - Installation instructions requiring the user to visit several repos for a complete install are not uncommon.
     An aggregated repo for all those locations provides a convenient one-stop strategy.
     The aggregation may support mirroring all consumed p2 repos or simply providing an indirection via a composite repo.
3. **Organizations or teams want control over internally used components**
   - It may be necessary to have gated access to relevant p2 repos and do an organizational "healthcheck" of those before internal distribution.
     Furthermore, internally used aggregated repos can provide a common basis for all organizational users.
4. **Increase repository availability**
    - By aggregating and mirroring what is used from multiple update sites into an internally controlled server (or several).
5. **Distributed Development Support**
    - An overall product repository is produced by aggregating contributions from multiple teams.

The aggregator is focused on supporting these specific requirements.
It is used in scenarios outside of the traditional "build domain"
and this has been reflected in the user interface which does not delve into the details of "building" and should therefore be relatively easy to use by non build experts.

# Functional Overview

The CBI Aggregator performs aggregation and validation of repositories.
The input to the aggregator engine (that tells it what to do) is an `*.aggr` EMF model.
Such a model is most conveniently created by using the CBI Aggregator editor.
This editor provides both editing and interactive execution of aggregation commands.
The editor is based on a standard EMF "tree and properties view" style editor
where nodes are added to and removed from tree,
and the details of nodes are edited in a separate properties view.
Once a `*.aggr` model has been created,
it is possible to use the command line / headless aggregator to perform aggregation (and other related commands).
Note that since the `*.aggr` is "just an EMF model", it can be produced via EMF APIs, transformation tools, etc., and thus supports advanced use cases.

The model mainly consists of `Contributions`,
i.e., specifications of what to include from different repositories,
and `Validation Repositories`,
i.e., repositories that are used when validating the transtive closure of dependencies,
but which the content of which are not copied to the aggregation result.
`Contributions` and `Validation Repositories` are grouped into `Validation Sets`.
Everything in a `Validation Set`* will be validated as one unit,
i.e., it must be possible to install everything in a `Validation Set` together.
The model also contains specification of various processing rules (exclusions, transformation of names, etc.),
and specification of `Contacts`, i.e.,  individualsand mailing-lists to inform when processing fails.

Here are some of the important features supported by the CBI Aggregator:

* **p2** and **maven2** format
  - The aggregator can aggregate from and to both p2 and maven2 repositories.
* **Maven2 name mapping support**
  - Names in the p2 domain are automatically mapped to maven2 names using built-in rules.
    Custom rules are also supported.
* **Mirroring**
  - Artifacts from repositories are mirrored/downloaded/copied to a single location.
* **Selective mirroring**
  - An aggregation can produce an aggregate consisting of a mix of references to repositories and mirrored repositories.
* **Cherry picking**
  - It is possible to pick individual items when the entire content of a repository is not wanted.
    Detailed picking is supported as well as picking transitive closures like a product,
    or a category to get everything it contains/requires.
* **Pruning** 
  - It is possible to specify mirroring based on version ranges.
    This can be used to reduce the size of the produced result when historical versions are not needed in the aggregated result.
* **Categorization** 
  - Categorization of installable units is important to the consumers of the aggregated repository.
    Categories are often choosen by repository publishers in a fashion that makes sense when looking at a particular repository in isolation,
    but when they are combined with othersit can be very difficult for the user to understand what they relate to.
    An important task for the constructor of an aggregation is to be able to organize the aggregated material in an easily consumable fashion.
    The CBI Aggregator has support for category prefixing, category renaming, addition of custom categories, as well as adding and removing features in categories.
* **Validation** 
  - The CBI Aggregator validates the aggregated.
    `Validation Sets` ensure that everything in them is installable at the same time.
* **Blame Email** 
  - When issues are found during validation, the aggregator supports sending emails describing the issue.
    This is very useful when aggregating the result of many different projects.
    Advanced features include specifying contacts for parts of the aggregation,
    which is useful in large multi-layer project structures where issues may be related to the combination of a group of projects rather than one individual project&mdash;someone
    responsible for the aggregation itself should be informed about these cross-project issues.
    The aggregator supports detailed control over email generation, including handling of mock emails when testing aggregation scripts.

# Installation

The CBI repository aggregator is built by 
[https://ci.eclipse.org/cbi/job/cbi.p2repo.aggregator-build/](https://ci.eclipse.org/cbi/view/p2RepoRelated/job/cbi.p2repo.aggregator-build/).

This job's builds produce updates sites for the 
[tools](https://download.eclipse.org/cbi/updates/p2-aggregator/tools/) and the 
[products](https://download.eclipse.org/cbi/updates/p2-aggregator/products/).
The former can be used to install the tools into an IDE.
The latter contains the headless installer,
including packaged products.


### Providing a repo indirection

Mirroring all repo artifacts of your aggregated contributions is a very valuable and important feature when performing aggregation,
but there are also many cases where this is not necessary.
It is possible to turn off artifact mirroring/copying by changing one property for a defined contribution.
Each `Mapped Repository` has a boolean property called `Mirror Artifacts` which can be set to `false` in order to prevent copying all artifacts of the contributed repo to the aggregated repo.

## Creating a Maven-conformant p2 repo

A powerful feature of the aggregator is the ability to create aggregated repos that can be consumed as Maven repos,
i.e., providing the directory/file structure and artifacts required by Maven.
An aggregated repository that supports Maven can be consumed both as a p2 and a Maven repo at the same time.
This flexibility is possible thanks to p2's separation of dependency meta-data and the actual location of the referenced artifacts.

In order to create a Maven-conformant aggregate repo all that is required is to set the property `Maven Result` property of the `Aggregation` to `true`.
The aggregation deployed to the `Build Root` location will be a Maven repo.
In this repo all `.source` artifacts will be co-located with their main artifact,
sharing the same artifactId but with qualifier `-sources`, as expected by Maven.

Additionally, the property `Version Format` of the `Aggregation` allows to select between three strategies for version numbers:
- Normal
  - Versions numbers are kept unmodified
- Strict Maven
  - Use a '-' (dash) to separate three-part versions from any qualifier,
    to make the resulting versions parsable by Maven,
    so `3.12.2.v20161117-1814` will be converted to `3.12.2`**-**`v20161117-1814`.
- Maven Release
  - Truncate any qualifier, i.e., produce three-part version numbers to tell Maven that all artifacts are "releases".

If more fine grained control over version formats is needed,
each [Maven Mapping](#maven-mapping) can be fine tuned with a pair of `Version Pattern` and `Version Template`,
which will only be applied to artifacts matching the corresponding `Maven Mapping`.
In this case, the existing version will be matched against the pattern, and if it matches,
the version will be replaced by applying the corresponding template,
where $1, $2, &hellip;  represent match groups from the pattern.
As an example consider the case where the micro digit of a version should be omitted if it is equal to '0',
so `4.12.0.v201504281640` will be translated to `4.12`:
```
Version Pattern: ([^.]+)\.([^.]+)\.0(?:\..*)?
Version Template: $1.$2
```

### Maven Snapshots

The aggregator supports produces artifacts that Maven recognizes as snapshots.
The solution consists of several parts:

- Individual [Maven Mapping](#maven-mapping) elements can be marked with `snapshot="true"`.
  The aggregator will attempt to transform all matched artifacts to snapshot artifacts.
- The internal version identifying an individual snapshot in maven (something like `1.2.3-20201253.235900-123`) will be constructed from the following:
  -  The date and time will be extracted from the qualifier part of the OSGi version.
  -  A build number needs to be passed as a command line argument to the aggregator like this, e.g., `--mavenBuildNumber 123`.g
     Build numbers should monotonically grow, but now further constraints apply.

The OSGi version qualifier (*like "v20201224-2359-nightly"*) will be matched against the following pattern:
```
(.*[^0-9])?(\\d\\d\\d\\d\\d\\d\\d\\d)-?(\\d\\d\\d\\d(\\d\\d)?).*
```
* An optional prefix ending in a non-digit will be ignored, e.g., `v`.
* The next 8 chars must be digits interpreted as the date, e.g., `20201231`.
* An optional `-` separator will be skipped,
* The next, 4 or 6 digits are expected, and are interpreted as the time, f only 4 digits they will be right-padded, e.g., `235900`.
* An arbitrary postfix is again ignored, e.g., `nightly`.

Version qualifiers not matching that pattern cannot be used for creating a maven snapshot.

By marking individual [Maven Mappings](#maven-mapping) as snapshot,
it is possible to create snapshot artifacts which then depend on release versions of other artifacts.

### Example

A sample aggr file,
[SDK4Mvn.aggr](https://github.com/eclipse-platform/eclipse.platform.releng.aggregator/blob/master/eclipse.platform.releng/publish-to-maven-central/SDK4Mvn.aggr),
shows an easy-to-use example of how to create a Maven-conformant p2 repository, i.e. one that works with Maven or p2.
In this case the aggregator is used to transform a p2 repository into a subset of content that can be published to Maven Central.

# Headless support

You will need a [headless installation](https://download.eclipse.org/cbi/updates/p2-aggregator/products/nightly/latest).

## Running from the command line

Just type:

    cbiAggr aggregate <options>

Note: if you install the aggregator into an Eclipse SDK or Platform
(rather than a pure headless installation), you can run from the command
line, by using

    eclipse -application org.eclipse.cbi.p2repo.cli.headless aggregate <options>

For a detailed listing of the available options consult the next
section.

## Command line options


<table>
<thead>
  <tr class="header"><th><p>Option</p></th><th><p>Value</p></th><th><p>Default</p></th><th><p>Description</p></th></tr>
</thead>
<tbody>
<tr class="odd"><td><p><strong>--buildModel</strong></p></td><td><p><path to build model></p></td><td><p>This value is required</p></td><td><p>
Appoints the aggregation definition that drives the execution.
The value must be a valid path to a file (absolute or relative to current directory).
</p></td></tr>
<tr class="even"><td><p><strong>--action</strong></p></td><td><p>VALIDATE</p><p>BUILD</p><p>CLEAN</p><p>CLEAN_BUILD</p></td><td><p>BUILD</p></td><td><p>
Specifies the type of the execution.
</p><ul>
<li><strong>VALIDATE</strong> - verifies model validity and resolves dependencies; no artifacts are copied or created</li>
<li><strong>BUILD</strong> - performs the aggregation and creates the aggregated repository in the target location</li>
<li><strong>CLEAN</strong> - cleans all traces of previous aggregations in the specified target location</li>
<li><strong>CLEAN_BUILD</strong> - performs a CLEAN followed by a BUILD</li>
</ul></td></tr>
<tr class="odd"><td><p><strong>--buildId</strong></p></td><td><p><string></p></td><td><p>build-<timestamp in the format yyyyMMddHHmm></p></td><td><p>
Assigns a build identifier to the aggregation.
The identifier is used to identify the build in notification emails.
Defaults to: build-&lt;timestamp>` where &lt;timestamp> is formatted according as yyyyMMddHHmm, e.g, build-200911031527.
</p></td></tr>
<tr class="even"><td><p><strong>--buildRoot</strong></p></td><td><p><path to directory></p></td><td><p><em>buildRoot</em> declared in the aggregation model</p></td><td><p>
Controls the output.
Defaults to the build root defined in the aggregation definition.
The value must be a valid path to a directory (absolute or relative to current folder).
If the desired directory structure does not exist then it is created.
</p></td></tr>
<tr class="odd"><td><p><strong>--agentLocation</strong></p></td><td><p><path to directory></p></td><td><p><strong><buildRoot></strong>/p2</p></td><td><p>
Controls the location of the p2 agent.
When specified as outside of the build root, the agent will not be cleaned out by the aggregator and thus retain its cache.
</p></td></tr>
<tr class="even"><td><p><strong>--production</strong></p></td><td><p>N/A</p></td><td><p>N/A</p></td><td><p>
Indicates that the build is running in real production.
That means that no mock emails will be sent.
Instead, the contacts listed for each contribution will get emails when things go wrong.
<br/>
<br/>
<strong>CAUTION: Use this option only if you are absolutely sure that you know what you are doing, especially when using models "borrowed" from other production builds without changing the emails first.</strong>
</p></td></tr>
<tr class="odd"><td><p><strong>--emailFrom</strong></p></td><td><p><email></p></td><td><p>Address of build master</p></td><td><p>
Becomes the sender of the emails sent from the aggregator.
</p></td></tr>
<tr class="even"><td><p><strong>--emailFromName</strong></p></td><td><p><name></p></td><td><p>If --emailFrom is set then this option sets the real name of the email sender.</p></td><td></td></tr>
<tr class="odd"><td><p><strong>--mockEmailTo</strong></p></td><td><p><email></p></td><td><p><em>no value</em></p></td><td><p>
Becomes the receiver of the mock-emails sent from the aggregator.
If not set, no mock emails are sent.
</p></td></tr>
<tr class="even"><td><p><strong>--mockEmailCC</strong></p></td><td><p><email></p></td><td><p><em>no value</em></p></td><td><p>
Becomes the CC receiver of the mock-emails sent from the aggregator.
If not set, no mock CC address is used.
</p></td></tr>
<tr class="odd"><td><p><strong>--logURL</strong></p></td><td><p><url></p></td><td><p>N/A</p></td><td><p>
The URL that will be pasted into the emails.
Should normally point to the a public URL for output log for the aggregator so that the receiver can browse the log for details on failures.
</p></td></tr>
<tr class="even"><td><p><strong>--logLevel</strong></p></td><td><p>DEBUG</p><p>INFO</p><p>WARNING</p><p>ERROR</p></td><td><p>INFO</p></td><td><p>
Controls the verbosity of the console trace output.
Defaults to global settings.
</p></td></tr>
<tr class="odd"><td><p><strong>--eclipseLogLevel</strong></p></td><td><p>DEBUG</p><p>INFO</p><p>WARNING</p><p>ERROR</p></td><td><p>INFO</p></td><td><p>
Controls the verbosity of the eclipse log trace output.
Defaults to global settings.
</p></td></tr>
<tr class="even"><td><p><strong>--stacktrace</strong></p></td><td><p>---</p></td><td><p><em>no value</em></p></td><td><p>
Display stack trace on uncaught error.
</p></td></tr>
<tr class="odd"><td><p><strong>--subjectPrefix</strong></p></td><td><p><string></p></td><td><p>?</p></td><td><p>
The prefix to use for the subject when sending emails.
Defaults to the label defined in the aggregation definition.
The subject is formatted as: "[<subjectPrefix>] Failed for build <buildId>".
</p></td></tr>
<tr class="even"><td><p><strong>--smtpHost</strong></p></td><td><p><host name></p></td><td><p><em>localhost</em></p></td><td><p>
The SMTP host to talk to when sending emails.
Defaults to "localhost".
</p></td></tr>
<tr class="odd"><td><p><strong>--smtpPort</strong></p></td><td><p><port number></p></td><td><p><em>25</em></p></td><td><p>
The SMTP port number to use when talking to the SMTP host.
Default is 25.
</p></td></tr>
<tr class="even"><td><p><strong>--packedStrategy</strong></p></td><td><p>COPY</p><p>VERIFY</p><p>UNPACK_AS_SIBLING</p><p>UNPACK</p><p>SKIP</p></td><td><p><em>value from the model</em></p></td><td><p>
<em>Deprecated (Use only with on-the-fly transformation from deprecated build models)</em>.
Controls how mirroring is done of packed artifacts found in the source repository.x
Defaults to the setting in the aggregation definition.
</p></td></tr>
<tr class="odd"><td><p><strong>--trustedContributions</strong></p></td><td><p><comma separated list></p></td><td><p><em>no value</em></p></td><td><p>
<em>Deprecated (Use only with on-the-fly transformation from deprecated build models)</em>.
A comma separated list of contributions with reposiories that will be referenced directly (through a composite repository) rather than mirrored into the final repository
(even if the repository is set to mirror artifacts by default).
</p><p>
<em>Note: this option is mutually exclusive with option --mavenResult (see below)</em>
</p></td></tr>
<tr class="even"><td><p><strong>--validationContributions</strong></p></td><td><p><comma separated list></p></td><td><p><em>no value</em></p></td><td><p>
<em>Deprecated (Use only with on-the-fly transformation from deprecated build models)</em>.
A comma separated list of contributions with repositories that will be used for aggregation validation only rather than mirrored or referenced into the final repository.
</p></td></tr>
<tr class="odd"><td><p><strong>--mavenResult</strong></p></td><td><p>---</p></td><td><p><em>no value</em></p></td><td><p>
<em>Deprecated (Use only with on-the-fly transformation from deprecated build models)</em>.
Tells the aggregator to generate a hybrid repository that is compatible with p2 and maven2.
<em>Note: this option is mutually exclusive with option --trustedContributions (see above)</em>
</p></td></tr>
<tr class="even"><td><p><strong>--mirrorReferences</strong></p></td><td><p>---</p></td><td><p><em>no value</em></p></td><td><p>
Mirror meta-data repository references from the contributed repositories.
Note the current recommendation is to not have update sites in feature definitions, but instead in "products",
that is, to allow adopters or consumers to specify where to get updates from and what "extras" to offer. 
But, this option can still useful for some situations.
</p></td></tr>
<tr class="odd"><td><p><strong>--referenceIncludePattern</strong></p></td><td><p><regexp></p></td><td><p><em>no value</em></p></td><td><p>
Include only those references that matches the given regular expression pattern.
</p></td></tr>
<tr class="even"><td><p><strong>--referenceExcludePattern</strong></p></td><td><p><regexp></p></td><td><p><em>no value</em></p></td><td><p>
Exclude all references that matches the given regular expression pattern.x
An exclusion takes precedence over an inclusion in case both patterns match a reference.
</p></td></tr>
<tr class="odd"><td><p><strong>--mavenBuildNumber</strong></p></td><td><p><number></p></td><td><p><em>no value</em></p></td><td><p>
When producing a <a href="#maven-snapshots"">maven snapshot</a> the build number is supposed to uniquely identify a particular snapshot build.
</p></td></tr>
</tbody>
</table>

# Aggregation model components and specific actions

This section provides an in-depth description and reference of the aggregation model, listing all model components, properties and available actions.

## Global actions

The following aggregator-specific actions are available via the context menu that can be invoked on any node in the model editor:

* **Clean Aggregation**
  - Cleans all traces of previous aggregations in the specified target location `Build Root`.
* **Validate Aggregation**
  - Verifies model validity and resolves dependencies; no artifacts are copied or created
* **Build Aggregation** 
  - Performs the aggregation and creates the aggregated repository in the target location `Build Root`.
* **Clean then Build Aggregation** 
  - Performs a *Clean* followed by a *Build*.

## Aggregation

The root node of any aggregation model is the Aggregation node.
It specifies a number of global properties including the `Build Root` (the target location of the aggregated repository)
as well as the repo structure (maven-conformant or classic p2 setup).
There are several child components some of which can be reference in other parts of the model:
[Configuration](#configuration),
[Contact](#contact),
[Validation Set](#validation-set),
[Custom Category](#custom-category),
[Maven Mapping](#maven-mapping).

<table>
<thead><tr class="header"><th><p>Property</p></th><th><p>Value(s)</p></th><th><p>Default Value</p></th><th><p>Comment</p></th></tr></thead>
<tbody>
<tr class="odd"><td><p>Buildmaster</p></td><td><p>&lt;<a href="#contact">Contact</a>&gt;</p></td><td><p>-</p></td><td><p>
Specifies an optional build master that will be notified of progress and problems if sending of mail is enabled.
This is a reference to any <a href="#contact">Contact</a> that has been added to this Aggregation model.
</p></td></tr>
<tr class="even"><td><p>Build Root</p></td><td><p><urn></p></td><td><p>-</p></td><td><p>
This is a required property specifying the target location of the aggregated repository.
</p></td></tr>
<tr class="odd"><td><p>Description</p></td><td><p><string></p></td><td><p>-</p></td><td><p>
An optional description of the aggregated repository that will be shown when accessing the aggregated repository via the p2 update manager.
</p></td></tr>
<tr class="even"><td><p>Label</p></td><td><p><string></p></td><td><p>-</p></td><td><p>
A required label that will be used for the aggregated repository.
This will be shown as the repo label when accessing the aggregated repository via the p2 update manager.
</p></td></tr>
<tr class="odd"><td><p>Maven Mappings</p></td><td><p>&lt;<a href="#maven-mapping">Maven Mapping</a>&gt;</p></td><td><p>-</p></td><td><p>
References <a href="#maven-mapping">Maven Mappings</a> added as children to the Aggregation model root node.
See <a href="#maven-mapping">Maven Mapping</a> for details.
</p></td></tr>
<tr class="even"><td><p>Maven Result</p></td><td><p><strong>true</strong> <strong>false</strong></p></td><td><p>false</p></td><td><p>
Controls the output structure of the aggregated repo.
If <strong>true</strong>, the aggregated repo will be Maven-conformant.
Both the structure and meta-data of the aggregated repository will follow the conventions required by Maven.
NOTE that due to the flexibility of p2 (separation of meta-data about dependencies and location of artifacts) the aggregated repo will at the same time also function as a valid p2 repository.
</p></td></tr>
<tr class="odd"><td><p>Packed Strategy</p></td><td><p><strong>Copy</strong> <strong>Verify</strong></p><p><strong>Unpack as Sibling</strong></p><p><strong>Unpack</strong></p><p><strong>Skip</strong></p></td><td><p>Copy</p></td><td><p>
This property controls how packed artifacts found in contributed repositories are handled when building the Aggregation:</p>
<ul>
<li><strong>Copy</strong> - if the source contains packed artifacts, copy and store them verbatim. No further action</li>
<li><strong>Verify</strong> - same as <em>copy</em> but unpack the artifact and then discard the result</li>
<li><strong>Unpack as Sibling</strong> - same as <em>copy</em> but unpack the artifact and store the result as a sibling</li>
<li><strong>Unpack</strong> - use the packed artifact for data transfer but store it in unpacked form</li>
<li><strong>Skip</strong> - do not consider packed artifacts. This option will require unpacked artifacts in the source</li>
</ul></td></tr>
<tr class="even"><td><p>Sendmail</p></td><td><p><strong>false</strong> <strong>true</strong></p></td><td><p>false</p></td><td><p>
Controls whether or not emails are sent when errors are detected during the aggregation process.
A value of <code>false</code> disables sending of emails (including mock emails).</p></td></tr>
<tr class="odd"><td><p>Type</p></td><td><p><strong>S</strong> <strong>I</strong></p><p><strong>N</strong></p><p><strong>M</strong></p><p><strong>C</strong></p><p><strong>R</strong></p></td><td><p>S</p></td><td><p>
Indicates the Aggregation type.
This is an annotation merely for the benefit of the build master.
It is not visible in the resulting repo.
</p><ul>
<li><strong>S</strong> - stable</li>
<li><strong>I</strong> - integration</li>
<li><strong>N</strong> - nightly</li>
<li><strong>M</strong> - milestone</li>
<li><strong>C</strong> - continuous</li>
<li><strong>R</strong> - release</li></ul>
</td></tr>
</tbody></table>

### Configuration

An `Aggregation` may have one or more `Configuration` definitions.
The aggregated repo will be verified for all added configurations.
If dependencies for any of the given configurations fails the aggregation as a whole fails.
It is however possible to specify exceptions for individual [Contributions](#contribution).

A Configuration is a combination of the following properties :

<table><thead><tr class="header"><th><p>Property</p></th><th><p>Value(s)</p></th><th><p>Default Value</p></th><th><p>Comment</p></th></tr></thead>
<tbody>
<tr class="odd"><td><p>Architecture</p></td><td>
<p><strong>X86</strong></p>
<p><strong>PPC</strong></p>
<p><strong>X86_64</strong></p>
<p><strong>IA64</strong></p>
<p><strong>IA64_32</strong></p>
<p><strong>Sparc</strong></p>
<p><strong>PPC64</strong></p>
<p><strong>S390</strong></p>
<p><strong>S390x</strong></p>
</td><td><p><strong>X86</strong></p></td>
<td><p>Specifies the architecture for which this configuration should be verified.</p></td></tr>
<tr class="even"><td><p>Enabled</p></td><td>
<p><strong>true</strong> <strong>false</strong></p></td>
<td><p>true</p></td>
<td><p>Disables (false) or enables (true) the configuration for the aggregation process.</p></td></tr>
<tr class="odd"><td><p>Operating System</p></td><td>
<p><strong>Win32</strong></p>
<p><strong>Linux</strong></p>
<p><strong>MacOSX</strong></p><p>
<strong>AIX</strong></p>
<p><strong>HPUX</strong></p>
<p><strong>Solaris</strong></p>
<p><strong>QNX</strong></p>
</td><td><p><strong>Win32</strong></p></td>
<td><p>Specifies the operating system for which this configuration should be verified.</p></td></tr>
<tr class="even"><td><p>Window System</p></td><td>
<p><strong>Win32</strong></p>
<p><strong>GTK</strong></p>
<p><strong>Carbon</strong></p>
<p><strong>Cocoa</strong></p>
<p><strong>Motif</strong></p><p>
<strong>Photon</strong></p></td>
<td><p><strong>Win32</strong></p></td>
<td><p>Specifies the windowing system for which this configuration should be verified.</p></td></tr>
</tbody></table>

The supported values are likely to evolve over time.

### Validation Set

The aggregator uses the p2 planner tool to determine what needs to be copied.
The validation set determines the scope of one such planning session per valid configuration.
This vouches for that everything that is contained within a validation set will be installable into the same target.
Sometimes it is desirable to have more than one version of a feature in a repository even though multiple versions cannot be installed.
This can be done using one validation set for each version.

A validation set can extend other validation set and thereby provide a convenient way for sharing common things that multiple validation sets will make use of.
An extended validation set will not be validated by its own.
It will only be validated as part of the sets that extend it.

A validation set can have two types of children:
[Contribution](#contribution)
and [Validation Repository](#validation-repository).

| Property    | Value(s)                                               | Default Value | Comment                                                                                                                                                                           |
| ----------- | ------------------------------------------------------ | ------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Description | \<string>                                              | -             | An optional description of the validation set. For documentation purposes only.                                                                                                   |
| Enabled     | **true** **false**                                     | true          | Disables (false) or enables (true) the validation set to be considered in the aggregation process. Note that this may lead to missing dependencies and hence verification errors. |
| Extends     | **\<[Validation Set](#validation-set)\>***             | -             | Zero or more references to [Validation Sets](#validation-set) defined in the given Aggregation model that this validation set extends.                                            |
| Label       | \<string>                                              | -             | Mandatory label for this validation set.                                                                                                                                          |

### Contribution

Contributions are the key element of any aggregation.
Contributions specify which repositories (or parts thereof (category, feature, product, IU)) to include,
and the constraints controlling their inclusion in the aggregated repository.
A contribution definition may consist of several [Mapped Repository](#mapped-repository)
and [Maven Mapping](#maven-mapping) components.

| Property       | Value(s)                                 | Default Value | Comment                                                                                                                                                                                                         |
| -------------- | -----------------------------------------| ------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Contacts       | **\<[Contact](#contact)\>***            | -            | Zero or more references to [Contacts](#contact) defined in the given Aggregation model. The referenced contacts will be notified if aggregation errors related to the contribution as a whole occur.              |
| Description    | <string>                                 | -             | Optional description of the contribution. This is for documentation purposes only and will not end up in the aggregated repository.                                                                             |
| Enabled        | **true** **false**                       | true          | Disables (false) or enables (true) the contribution to be considered in the aggregation process. Note that this may lead to missing dependencies and hence verification errors.                                 |
| Label          | <string>                                 | -             | Mandatory label for this contribution.                                                                                                                                                                          |
| Maven Mappings | **\<[Maven Mapping](#maven-mapping)\>*** | -             | See [Maven Mapping](#maven-mapping) for details                                                                                                                                                                 |

#### Mapped Repository

A [Contribution](#contribution) may define several Mapped Repositories defining the actual content of the contribution.
The Aggregator provides fine-grained control over the contribution from each Mapped Repository through references to
[Products](#product),
[Bundles](#bundle),
[Features](#feature),
[Categories](#category),
[Exclusion Rules](#exclusion-rule),
[Valid Configuration Rules](#valid-configuration-rule).

| Property         | Value(s)           | Default Value | Comment                                                                                                                                                                                                                                                          |
| ---------------- | ------------------ | ------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Category Prefix  | <string>           | -            | A prefix added to the label of this repository when displayed in the p2 update manager. In the absence of custom categories this allows a useful grouping of repositories in an aggregated repository to be specified.                                            |
| Description      | <string>           | -            | Description of the Mapped Repository. For documentation purposes only.                                                                                                                                                                                            |
| Enabled          | **true** **false** | true          | Controls whether a Mapped Repository is considered as part of the Contribution. Setting this property to `false` excludes the repository from the verification and aggregation process.                                                                          |
| Location         | <URL>              |               | This (required property) specifies the location of the repository that should be added to the enclosing Contribution.                                                                                                                                            |
| Mirror Artifacts | **true** **false** | true          | Controls whether the contents (artifacts) of the specified repository will be copied to the target location of the aggregated repository.                                                                                                                        |
| Nature           | <nature>           | p2            | This specifies the nature of the repository, i.e. which loader should be used for loading the repository. The number of available repository loaders depends on installed extensions. By default, **p2** and **maven2** loaders are present in the installation. |

##### Product

Defining Product components allows the addition of individual Eclipse products to the aggregation to be specified
(as opposed to mapping the complete contents of a given [Mapped Repository](#mapped-repository).
This naturally requires that products are present in the repositories being mapped.

| Property             | Value(s)                                  | Default Value | Comment                                                                                                                                                                                                       |
| -------------------- | ------------------------------------------| ------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Description          | \<description\>                           | -             | Optional description of the mapping.                                                                                                                                                                          |
| Enabled              | **true** **false**                        | true          | Controls whether a Product is considered as part of the Contribution. Setting this property to `false` excludes the product from the verification and aggregation process.                                    |
| Name                 | \<product IU's id\>                       | -             | The id of the product to be included in the aggregation. A drop-down of available names is provided.                                                                                                          |
| Valid Configurations | \<[Configuration](#configuration)\>**\*** | -             | References to zero or more configurations for which this product should be verified. If no references are given the product is verified for all [Configurations](#configuration) defined for the aggregation. |
| Version Range        | \<version range\>                         | 0.0.0         | A version range that specifies acceptable versions for this installable unit. A pop-up editor is available.                                                                                                   |

##### Category

Defining Category components allows the addition of the content in specific categories (provided by the contributed repository)
rather than the complete contents of a given [Mapped Repository](#mapped-repository).

| Property             | Value(s)                             | Default Value | Comment                                                                                                                                                                                                                 |
| -------------------- | -------------------------------------| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Description          | \<description>                       | *no value*    | Optional description of the mapping.                                                                                                                                                                                    |
| Enabled              | **true** **false**                   | true          | Controls whether a repository Category is considered as part of the Contribution. Setting this property to `false` excludes the category from the verification and aggregation process.                                 |
| Name                 | \<category IU id>                    | -             | The id of the category to be included in the aggregation. A drop-down of available names is provided.                                                                                                                   |
| Label Override       | \<string>                            | -             | New category name used instead of the default name.                                                                                                                                                                     |
| Valid Configurations | \<[Configuration](#configuration)\>* | -             | References to zero or more configurations for which the category contents should be verified. If no references are given the category is verified for all [Configurations](#configuration) defined for the aggregation. |
| Version Range        | \<version range>                     | 0.0.0         | A version range that specifies acceptable versions for this installable unit. A pop-up editor is available.                                                                                                             |

##### Bundle

Defining Bundle components allows addition of individual Eclipse bundles to the aggregation to be specified
(rather than the complete contents of a given [Mapped Repository](#mapped-repository)).

| Property             | Value(s)                             | Default Value | Comment                                                                                                                                                                                                                     |
| -------------------- | -------------------------------------| ------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Description          | \<description>                       | *no value*    | Optional description of the mapping.                                                                                                                                                                                        |
| Enabled              | **true** **false**                   | true          | Controls whether a referenced bundle is considered as part of the Contribution. Setting this property to `false` excludes the bundle from the verification and aggregation process.                                         |
| Name                 | \<bundle IU id>                      | -             | The id of the bundle to be included in the aggregation. A drop-down of available names is provided.                                                                                                                         |
| Valid Configurations | \<[Configuration](#configuration)\>* | -             | References to zero or more configurations for which the referenced bundle has to be verified. If no references are given the bundle has to be verified for all [Configurations](#configuration) defined for the aggregation.|
| Version Range        | \<version range>                     | 0.0.0         | A version range that specifies acceptable versions for this installable unit. A pop-up editor is available.                                                                                                                 |

##### Feature

Defining Feature components allows the addition of individual Eclipse features to the aggregation to be specified
(rather than the complete contents of a given [Mapped Repository](#mapped-repository)).
The features to include must be present in the mapped repository.

Furthermore, this component provides the means to group features implicitly into [Custom Categories](#custom-category).

| Property             | Value(s)                                 | Default Value | Comment                                                                                                                                                                                                                                                                                                                                                 |
| -------------------- | -----------------------------------------| ------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Categories           | \<[Custom Category](#custom-category)\>* | -             | Optionally references the [Custom Category](#custom-category) definitions into which the feature should be placed upon aggregation. The relationship to the custom category is bi-directional so adding the feature to a custom category will update this property automatically in the [Custom Category](#custom-category) definition, and vice versa. |
| Description          | \<description>                           | *no value*    | Optional description of the mapping.                                                                                                                                                                                                                                                                                                                    |
| Enabled              | **true** **false**                       | true          | Controls whether a referenced feature is considered as part of the Contribution. Setting this property to `false` excludes the feature from the verification and aggregation process.                                                                                                                                                                   |
| Name                 | \<feature IU id>                         | -             | The id of the feature to be included in the aggregation. A drop-down of available names is provided.                                                                                                                                                                                                                                                    |
| Valid Configurations | \<[Configuration](#configuration)\>*     | -             | References to zero or more configurations for which the referenced feature should be verified. If no references are given the feature is verified for all [Configurations](#configuration) defined for the aggregation.                                                                                                                                 |
| Version Range        | \<version range>                         | 0.0.0         | A version range that specifies acceptable versions for this installable unit. A pop-up editor is available.                                                                                                                                                                                                                                             |

##### Exclusion Rule

The Exclusion Rules provides an alternative way to control the content of the aggregated repository.
An exclusion rule may specify exclusion of any bundle, feature or product.
The excluded IU will not be considered in the aggregation and verification process.
 Each exclusion rule can only reference one IU id.

| Property      | Value(s)         | Default Value | Comment                                                                                                         |
| ------------- | ---------------- | ------------- | --------------------------------------------------------------------------------------------------------------- |
| Description   | \<string>        | -             | Description for documentation purposes.                                                                         |
| Name          | \<IU id>         | -             | The id of the installable unit to be excluded from the aggregation. A drop-down of available names is provided. |
| Version Range | \<version range> | 0.0.0         | A version range that specifies versions of this IU to be excluded. A pop-up editor is available.                |

##### Valid Configuration Rule

By default all contributed contents of a [Mapped Repository](#mapped-repository) will be verified for all [Configurations](#configuration) defined for the aggregation.
A Valid Configuration Rule provides more control over validation.
When using a Valid Configuration Rule, the referenced IUs (product, feature, or bundle) will only be verified and aggregated for the configurations specified in the rule.
The rule only applies if the whole repository is mapped, 
i.e. when no explicit features, products, bundles or categories are mapped,
regardless if they are enabled or disabled.

| Property             | Value(s)                             | Default Value | Comment                                                                                                                                                                                                                                |
| -------------------- | -------------------------------------| ------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Description          | \<string>                            | -             | Description for documentation purposes.                                                                                                                                                                                                |
| Name                 | \<IU id>                             | -             | The id of the IU to be included in the verification process. A drop-down of available names is provided.                                                                                                                               |
| Valid Configurations | \<[Configuration](#configuration)\>* | -             | References to one or more configurations for which the referenced IU should be verified. This implicitly excludes verification and aggregation for all other [Configurations](#configuration) defined as part of the aggregation model.|
| Version Range        | \<version range>                     | 0.0.0         | A version range that specifies versions of this installable unit for which the rule should apply. A pop-up editor is available.                                                                                                        |

#### Maven Mapping

See [Maven Mapping Details](#maven-mapping-details) for a detailed description and list of properties.

### Contact

Defines a resuseable contact element which can be referenced in other parts of the model and may be used to send notifications about the aggregation process.

| Property | Value(s)   | Default Value | Comment                                                                                          |
| -------- | -----------| ------------- | ------------------------------------------------------------------------------------------------ |
| Email    | \<email>   | -             | The email to be used when notifying the contact.                                                 |
| Name     | o\<string> | -             | Full name of the contact. May be displayed as label when referenced in other parts of the model. |

### Custom Category

A Custom Category provides a grouping mechanism for features in the aggregated repository.
A custom category can be referenced by [Features](#feature) defined for inclusion from a [Mapped Repository](#mapped-repository).
The relationship to between Custom Category and a [Feature](#feature) is bi-directional.
Thus, adding the feature to a custom category will update this property automatically in the [Feature](#feature) definition, and vice versa.

| Property    | Value(s)                 | Default Value | Comment                                                                                              |
| ----------- | -------------------------| ------------- | ---------------------------------------------------------------------------------------------------- |
| Description | \<string>                | -             | Description of the category as displayed when accessing the aggregated repository.                   |
| Features    | \<[Feature](#feature)\>* | -             | [Features](#feature) included in this category by reference.                                         |
| Identifier  | \<string>                | -             | Category id. Required Eclipse category property.                                                     |
| Label       | \<string>                | -             | Label displayed for the category when accessing the aggregated repository via the p2 update manager. |

### Validation Repository

A Validation Repository is used to define that a repository should be used when validating dependencies for the aggregation but whose contents should not be included in the aggregated repository.
It supports the cases where the objective is to create a repository that is not self sufficient,
but rather a complement to something else;
the typical use case is an aggregation of everything produced by an organization with validation against the main Eclipse repository.

| Property | Value(s)           | Default Value | Comment                                                                                                                                                                                                                                                          |
| -------- | ------------------ | ------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Enabled  | **true** **false** | true          | Controls whether a Validation Repository is considered during the verification and aggregation process. Setting this property to `false` excludes the repository from the verification and aggregation process.                                                  |
| Location | \<URL>             |               | Specifies the location of the repository.                                                                                                                                                                                                                        |
| Nature   | \<nature>          | p2            | This specifies the nature of the repository, i.e. which loader should be used for loading the repository. The number of available repository loaders depends on installed extensions. By default, **p2** and **maven2** loaders are present in the installation. |

### Maven Mapping Details

The Aggregator supports the creation of Maven-conformant repositories.
A Maven repository requires a structure and use of naming conventions that may have to be achieved by a transformation of the Bundle-SymbolicName (BSN) when working with Eclipse bundles.
There is a default translation from BSN naming standard to Maven naming.
If that is not satisfactory,
custom transformations are supported by the definition of one or more Maven Mappings which can be defined at the
[Aggregator](#aggregation) and the
[Contribution](#contribution) level.

This only applies when the `Maven Result` property of the [Aggregator](#aggregation) model is set to true.
In that case all defined Maven Mappings are applied in the order in which they appear in the model starting from the most specific to the most generic.
That means for each artifact that a [Contribution](#contribution) adds to the aggregated repository:

1. First Maven Mappings defined as children of a [Contribution](#contribution) are applied
   in the order in which they appear as children of the parent [Contribution](#contribution) node.
2. Second Maven Mappings defined as children of the [Aggregator](#aggregation) model are applied
   in the order in which they appear as children of the parent [Aggregator](#aggregation) node.
3. Finally the default Maven Mapping is applied.

The most generic mapping is a default pattern that is applied whenever a Maven artifact is created.
It does not need to be added explicitly to the model.
A mapping is specified using a regular expression that is applied to each BSN.
The regular expression must specify two replacements;
one for the maven groupId, and one for the maven artifactId.
The group and artifact ids have an effect on the resulting Maven repo structure.
The default pattern is:
```
^([^.]+(?:\.[^.]+(?:\.[^.]+)?)?)(?:\.[^.]+)*$
```

The default maven mapping uses the replacement **`$1`** for groupId and **`$0`** for artifactId.
Hence, when applying the default maven mapping regular expression to a BSN, up to 3 segments
(with dots as segment delimiters)
are taken as the group id,
and the entire BSN is taken as the artifact name.
If this is a applied to something like `org.eclipse.cbi.p2repo.aggregator`,
the groupId would be `org.eclipse.cbi.p2repo`
and the artifactId `org.eclipse.cbi.p2repo.aggregator`.
The resulting Maven repo will have the folder structure:

    org
       |
       eclipse
          |
          cbi
             |
             org.eclipse.cbi.p2repo.aggregator
                |
                <folder name after version>
                   |
                   org.eclipse.cbi.p2repo.aggregator-<version>.jar
                   ...

<table>
<thead><tr class="header"><th><p>Property</p></th><th><p>Value(s)</p></th><th><p>Default Value</p></th><th><p>Comment</p></th></tr></thead>
<tbody>
<tr class="odd"><td><p>Name Pattern</p></td><td><p>regex</p></td><td><p>-</p></td><td><p>
A regular expression which is applied to the Bundle-SymbolicName (BSN).
Pattern groups may be referenced in the replacement properties.
</p></td></tr>
<tr class="even"><td><p>Group Id</p></td><td><p><string> (may contain pattern group references (i.e. $1, ...))</p></td><td><p>-</p></td><td><p>
Group Id applied in a maven mapping structure (groupId/artifactId).
The group Id replacement may contain pattern group references (i.e. $1, ...).
</p></td></tr>
<tr class="odd"><td><p>Artifact Id</p></td><td><p><string> (may contain pattern group references (i.e. $1, ...))</p></td><td><p>-</p></td><td><p>
Artifact Id applied in a maven mapping structure (groupId/artifactId).
The Artifact Id replacement may contain pattern group references (i.e. $1, ...).
</p></td></tr>
<tr class="even"><td><p>Version Pattern</p></td><td><p>regex</p></td><td><p>-</p></td><td><p>
An optional regular expression which is applied to the Version.
Pattern groups may be referenced in the Version Template property.
</p></td></tr>
<tr class="odd"><td><p>Version Template</p></td><td><p><string> (may contain pattern group references (i.e. $1, ...))</p></td><td><p>-</p></td><td><p>
If Version Pattern matched the given Version,
then this Version Template is used to construct the version as seen in Maven; 
useful in particular to shorten versions ending in ".0" to 2-part versions etc.
The Version Template may contain pattern group references (i.e. $1, ...).
<br />
Since the special token "-SNAPSHOT" can be used after the main version part to denote a snapshot version.
<br />
If no Version Pattern is given or if the Version Pattern doesn't match, then the global strategy from Version Format is applied.
</p></td></tr></tbody></table>

# What else should be documented

1. version editor (version formats...)
2. how enable/disable on the context menu wor
3. drag\&amp;drop support
4. 'available versions' tree
5. context menu actions (mapping IUs from repository view, searching
   for IUs from 'available version' tree...)

## Questions

- How is blame-mail handled when running in the UI? Are the options "production" etc. available then?
  - When launched from IDE, only --buildModel and --action options are set (all other options have default values).
    Perhaps it's worth adding a launching dialog which would enable setting all options that are available in headless mode.

- How do you know what the "log output url" is? How can it be set?
  - You can, for example, redirect a copy of the console output to a publicly available resource (a text file served by a http server).
    The public URL should be passed in the --logURL option so that a link to it would appear in the informational email.

- Some configurations seems to be missing - or is the list open ended?
  (Sparc, Motif, etc..) - I assume user can put anything there?
  - Only listed configurations are supported (they are a part of the model).
    Adding an option means changing the model and creation of a new aggregator build.*

- It seems that it is possible to load maven repositories.
  I suppose the result of aggregation is a valid p2 repository (or a combination of p2/maven)?
  - Yes, it is possible to load p2 and maven2 repositories by default (if someone adds a custom loader then he can load any type of repository).
    The output is always p2 compatible, optionally combined with maven2 (with no extensibility - at least now).
    However, if a maven2 repo is loaded and the result is also maven2 compatible, it is not identical to the original (not all attributes loaded from maven are stored in the p2 model).
