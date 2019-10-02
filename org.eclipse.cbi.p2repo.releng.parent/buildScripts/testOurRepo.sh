#!/usr/bin/env bash
#*******************************************************************************
# Copyright (c) 2019 Eclipse Foundation and others.
# This program and the accompanying materials are made available
# under the terms of the Eclipse Public License 2.0
# which is available at http://www.eclipse.org/legal/epl-v20.html
# SPDX-License-Identifier: EPL-2.0
#*******************************************************************************

# After we build, we will check the repository we just produced, to make sure it is basically compliant.
# This script needs to run on the CBI JIPP.

# Bash strict-mode
set -o errexit
set -o nounset
set -o pipefail

IFS=$'\n\t'

updateRelease=${1:-"4.13"}
analyzer_url=${2:-"http://download.eclipse.org/cbi/updates/analyzers/4.6/I20161201-1633/org.eclipse.cbi.p2repo.analyzers.product_I20161201-1633_linux.gtk.x86_64.tar.gz"}

build_home=${WORKSPACE}
repo_dir=${build_home}
testarea_dir=${build_home}/testarea


# download and extract cbi.p2repo.analyzer
mkdir -p ${testarea_dir}
wget --no-verbose -P ${testarea_dir} ${analyzer_url}
tar xzf ${testarea_dir}/org.eclipse.cbi.p2repo.analyzers.product_*_linux.gtk.x86_64.tar.gz -C ${testarea_dir}

# Since the version of our "site product" can change, it is best to "find" the latest built version based on filename pattern except for 
# the version, which would match anything (".*"). We expect there to always be only one version in the target directory, so this is safe.
createdRepo=$(find ${build_home}/org.eclipse.cbi.p2repo.site.eclipse/target/ -name "org.eclipse.cbi.p2repo.site.eclipse-*.zip")
if [[ -n "$createdRepo" ]]; then 
  printf "[INFO] %s\n" "Found the built repo in $createdRepo"
else
  printf "[ERROR] %s\n" "Did not find the target repository to test?!"
  exit 1
fi
unzip -q "${createdRepo}" -d ${testarea_dir}/repoToTest

repoRoot="/home/data/httpd/download.eclipse.org/cbi/updates/aggregator/ide/${updateRelease}"

# find reference repo
computedReferenceRepo=$(ssh genie.cbi@projects-storage.eclipse.org find "${repoRoot}" -maxdepth 1 -name "I20*" -type d | sort | tail -1)

printf "\n[INFO] %s\n" "computedReferenceRepo: ${computedReferenceRepo}"
referenceRepo=${referenceRepo:-${computedReferenceRepo}}
printf "\n[INFO] %s\n" "referenceRepo: ${referenceRepo}"
if [[ ${computedReferenceRepo} != ${referenceRepo} ]]; then
  printf "\n[WARNING] %s\n" "referenceRepo is different than computedReferenceRepo!"
fi

# copy reference repo to workspace
scp -r genie.cbi@projects-storage.eclipse.org:${referenceRepo} ${build_home}/referenceRepo

${build_home}/testarea/p2analyze/p2analyze -data workspace-report -vmargs -DreportRepoDir=${testarea_dir}/repoToTest -DreferenceRepo=${build_home}/referenceRepo -DreportOutputDir=${build_home} 2>&1
