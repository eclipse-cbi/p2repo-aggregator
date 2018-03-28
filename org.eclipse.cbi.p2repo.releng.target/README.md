# Updating the .target file for this project

## When to update

Typically the .target file is updated after every release to the Eclipse Platform since typically after every release of the Eclpse Platform there should be a new releasable build that is deployed and added to the composite update site.  Occasionally, such as is there is major change to p2 during a development cycle, then the project needs to be branched with the maintenance branch being based purely on released prerequistes, with the master branch being based on the unreleased version of the Platform and its prerequistes. 

## How to update

### Principles

Ultimately, the .target file should be treated as a ".txt" file so that the comments, spacing, and order of elements are not lost. \(But there are ways around doing this literally, as described below\). 

Also, by convention -- for this project -- the repository location URLs are listed as specifically as possible. 

Similarly, the versions of features and bundles are listed as specifically as possible. 

### Manual Method

The manual method is the hardest way to update the .target file, but is often the safest way to be sure to get prereques which "match" the Eclipse Platform. When using the manual method, but .target file is edit with an ordinary text editor and typically copy/paste is used to update the required values \(when needed -- not all preques will need to be udpated each time, but it is best to check each one to be sure\). 

The URLs are updated based on the specific URLs of the released prerequestes. For example, the Oxygen.3 release of the Eclipse Platform \(4.7.3\) has a \[download page\|http://download.eclipse.org/eclipse/downloads/drops4/R-4.7.3-201803010715/\] that list both a \[general software site\|[http://download.eclipse.org/eclipse/updates/4.7/](http://download.eclipse.org/eclipse/updates/4.7/)\] and a \[specific software site\|[http://download.eclipse.org/eclipse/updates/4.7/R-4.7.3-201803010715/](http://download.eclipse.org/eclipse/updates/4.7/R-4.7.3-201803010715/)\]. For builds, we use the most specific URL available. \(For updating our development installs, the general software site is typically fine\). 

To find out which versions are provided in that most recent site, one must simply go and look -- with by logging in with a shell account and navigating to the directory and then use somethign like "ll" to list the features or bundles of interest, and copy/paste the most recent version to the .target file. 

Or, one may also navigate to the web page of the software site and use the "Show Directory Contents" link to see features and bundles available along with their specific versions. 

### Tools Method




