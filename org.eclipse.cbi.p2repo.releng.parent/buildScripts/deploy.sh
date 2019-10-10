#!/usr/bin/env bash
#*******************************************************************************
# Copyright (c) 2019 Eclipse Foundation and others.
# This program and the accompanying materials are made available
# under the terms of the Eclipse Public License 2.0
# which is available at http://www.eclipse.org/legal/epl-v20.html
# SPDX-License-Identifier: EPL-2.0
#*******************************************************************************

# Deploy artifacts to download.eclipse.org.
# This script needs to run on the CBI JIPP.

# Bash strict-mode
set -o errexit
set -o nounset
set -o pipefail

IFS=$'\n\t'

# The default for build home is simply where I do my local build. Feel free to change in your local copy. 
build_home=${WORKSPACE:-/home/davidw/gitCBI}
propertiesfile="${build_home}/org.eclipse.cbi.p2repo.cli.product/target/mavenproperties.properties"
userAtHost="genie.cbi@projects-storage.eclipse.org"

function getProperty {
   local key=$1
   local value=`cat ${propertiesfile} | grep "${key}" | cut -d'=' -f2`
   echo ${value}
}

buildId=$(getProperty "buildId")
updateRelease=$(getProperty "updateRelease")

function deployRepos {
  local newRepo=$1
  local builtRepo=$2
  ssh ${userAtHost} mkdir -p ${newRepo}
  scp -r ${builtRepo}/* ${userAtHost}:${newRepo}/
  #TODO: add mirror URL, etc.
}

DLRoot=/home/data/httpd
DLPath=download.eclipse.org/cbi/updates/aggregator
DLPath_escaped="download.eclipse.org\/cbi\/updates\/aggregator"
baseDL=${DLRoot}/${DLPath}
ideUpdate=${baseDL}/ide/${updateRelease}/${buildId}
headlessUpdate=${baseDL}/headless/${updateRelease}/${buildId}

deployRepos ${ideUpdate} ${build_home}/org.eclipse.cbi.p2repo.site.eclipse/target/repository
deployRepos ${headlessUpdate} ${build_home}/org.eclipse.cbi.p2repo.cli.product/target/repository

# save away "data" from the build, as well as the deployable headless products
scp ${propertiesfile} ${userAtHost}:${headlessUpdate}

windowsProd=headless_${buildId}_win32.win32.x86_64.zip
linuxProd=headless_${buildId}_linux.gtk.x86_64.tar.gz
macProd=headless_${buildId}_macosx.cocoa.x86_64.tar.gz

# copy products
productroot=${build_home}/org.eclipse.cbi.p2repo.cli.product/target/products
scp ${productroot}/org.eclipse.cbi.p2repo.cli.product-linux.gtk.x86_64.tar.gz ${userAtHost}:${headlessUpdate}/${linuxProd}
scp ${productroot}/org.eclipse.cbi.p2repo.cli.product-macosx.cocoa.x86_64.tar.gz ${userAtHost}:${headlessUpdate}/${macProd}
scp ${productroot}/org.eclipse.cbi.p2repo.cli.product-win32.win32.x86_64.zip ${userAtHost}:${headlessUpdate}/${windowsProd}

#TODO
#scp -r ${build_home}/reporeports ${userAtHost}:${headlessUpdate}/

# create an easy to read file for location of these specific repositories
# TODO: eventually should turn this into a proper "download page"
DLfile=buildResults.html
DLpage=${build_home}/${DLfile}
# Notice how we "pick" the headless site to jump to, if someone clicks on the buildId they are looking at. 
# We have the same file in two places, 'ide' and 'headless', so some users may be surprised by that?

template_file="org.eclipse.cbi.p2repo.releng.parent/buildScripts/template_index.html"
# replace variables in template with actual values
sed -e "s/\$DLPath/${DLPath_escaped}/g" -e "s/\$updateRelease/${updateRelease}/g" -e "s/\${buildId}/${buildId}/g" -e "s/\$buildId/${buildId}/g" ${template_file} > ${DLpage}

#cat ${DLpage}

scp ${DLpage} ${userAtHost}:${headlessUpdate}
scp ${DLpage} ${userAtHost}:${ideUpdate}