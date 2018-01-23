#!/usr/bin/env bash

# After we build, we will check the repository we just 
# produced, to make sure it is basically compliant. 
# This script is called directly from "runBuild.sh".

build_home=${WORKSPACE:-/home/davidw/gitCBI}
export tmp_dir=${build_home}/aggr/tmp
export local_mvn_repo=${build_home}/aggr/localMvnRepo
sourceProperties="${build_home}/mavenproperties.shsource"
repo_dir=${build_home}/org.eclipse.cbi.p2repo.aggregator

out_file=${build_home}/repoReportsTestOutputLog.txt

# This function assumes we have not yet deployed the build
# we want to use as the reference repo. 
function latestSimpleRepo
{
  if [[ $# != 2 ]]
  then
    echo "\n\t[ERROR] Program error. ${0##*/} requires parent directory of simple repositories and name pattern of repo required, such as I20*."
    exit 9
  fi
  parentDir=$1
  namePattern=$2
  latestDLrepo=$(find ${parentDir} -maxdepth 1 -name ${namePattern} -type d | sort | tail -1)
  # we want to return only the "last part" of the directory name, since 
  # rest of code is expecting that. Rest of code could be modified so it took
  # "whole path", but that change should be done under separate bug, if/when desired.
  latestDLrepoSegment=${latestDLrepo##*/}
  # this echo is our "return" value, so can not echo anything else
  echo ${latestDLrepoSegment}
}


# This first write does not "append", the rest need to.
env | tee ${out_file}

# remove if it happens to exist
rm -fr ${build_home}/testarea
mkdir -p ${build_home}/testarea

pushd ${build_home}/testarea
wget --no-verbose -O org.eclipse.cbi.p2repo.analyzers.product-linux.gtk.x86_64.tar.gz  http://download.eclipse.org/cbi/updates/analyzers/4.6/I20161201-1633/org.eclipse.cbi.p2repo.analyzers.product_I20161201-1633_linux.gtk.x86_64.tar.gz
tar -xf org.eclipse.cbi.p2repo.analyzers.product-linux.gtk.x86_64.tar.gz
popd

# Since the version of our "site product" can change, it is best to "find" the latest built version based on filename pattern except for 
# the version, which would match anything (".*"). We expect there to always be only one version in the target directory, so this is safe.
createdRepo=$(find ${build_home}/org.eclipse.cbi.p2repo.aggregator/org.eclipse.cbi.p2repo.site.eclipse/target/ -name "org.eclipse.cbi.p2repo.site.eclipse-*.zip")
if [[ -n "$createdRepo" ]]
then 
printf "[INFO] %s\n" "Found the built repo in $createdRepo"
else
printf "[ERROR] %s\n" "Did not find the target repository to test?!"
exit 1
fi
unzip "${createdRepo}" -d ${build_home}/testarea/repoToTest

source $sourceProperties
# Note: 'referenceRepo' can be provided in "sourceProperties", if 
# necessary, which is done in parent pom, but typically the "latest build", 
# is the one we want to use. 
repoRoot="/home/data/httpd/download.eclipse.org/cbi/updates/aggregator/ide/${updateRelease}"
computedReferenceRepoLastSegment=$(latestSimpleRepo "${repoRoot}" "I20*")
computedReferenceRepo=${repoRoot}/${computedReferenceRepoLastSegment}
printf "\n[INFO] %s\n" "computedReferenceRepo: ${computedReferenceRepo}"
referenceRepo=${referenceRepo:-${computedReferenceRepo}}
printf "\n[INFO] %s\n" "referenceRepo: ${referenceRepo}"
if [[ ${computedReferenceRepo} != ${referenceRepo} ]]
  then
    printf "\n[WARNING] %s\n" "referenceRepo is differnt than computedReferenceRepo, which is not the normal case. Be sure desired in this case."
  fi
${build_home}/testarea/p2analyze/p2analyze -data workspace-report -vmargs -DreportRepoDir=${build_home}/testarea/repoToTest -DreferenceRepo=${referenceRepo}  -DreportOutputDir=${build_home} 2>&1 | tee -a ${out_file}
