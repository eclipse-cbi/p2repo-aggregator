#!/usr/bin/env bash
#*******************************************************************************
# Copyright (c) 2019 Eclipse Foundation and others.
# This program and the accompanying materials are made available
# under the terms of the Eclipse Public License 2.0
# which is available at http://www.eclipse.org/legal/epl-v20.html
# SPDX-License-Identifier: EPL-2.0
#*******************************************************************************

# Write composite repo files. 
# This script needs to run on the CBI JIPP.

# Bash strict-mode
set -o errexit
set -o nounset
set -o pipefail

IFS=$'\n\t'

function writeArtifactsHeader {
  local outfile=$1
  local nChildren=$2

  cat <<EOF > ${outfile}
<?xml version='1.0' encoding='UTF-8'?>
<?compositeArtifactRepository version='1.0.0'?>
<repository name='Eclipse CBI p2 Repository Aggregator' type='org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository' version='1.0.0'>
  <properties size='3'>
    <property name='p2.timestamp' value='1313779613118'/>
    <property name='p2.compressed' value='true'/>
    <property name='p2.atomic.composite.loading' value='true'/>
  </properties>
  <children size='${nChildren}'>
EOF
}

function writeContentHeader {
  local outfile=$1
  local nChildren=$2

  cat <<EOG > ${outfile}
<?xml version='1.0' encoding='UTF-8'?>
<?compositeMetadataRepository version='1.0.0'?>
<repository name='Eclipse CBI p2 Repository Aggregator' type='org.eclipse.equinox.internal.p2.artifact.repository.CompositeMetadataRepository' version='1.0.0'>
  <properties size='3'>
    <property name='p2.timestamp' value='1313779613118'/>
    <property name='p2.compressed' value='true'/>
    <property name='p2.atomic.composite.loading' value='true'/>
  </properties>
  <children size='${nChildren}'>
EOG
}

function writeFooter {
  local outfile=$1
  cat <<EOH >> "${outfile}"
  </children>
</repository>
EOH
}

function writeCompositeP2Index {
  local outfile=$1
  cat <<EOI > "${outfile}"
version=1
metadata.repository.factory.order=compositeContent.xml
artifact.repository.factory.order=compositeArtifacts.xml
EOI
}

function writeChildren {
  local outfile=$1
  local dirs=$2
  local nChildren=$3

  children=$(printf "${dirs}\n" | head -n ${nChildren})

  for child in ${children}
  do
    printf "%s%s%s\n" "    <child location='" ${child} "' />"  >> ${outfile}
  done
}

downloadRepoRoot="/home/data/httpd/download.eclipse.org/cbi/updates/aggregator"
for repoRoot in "ide/4.13" "headless/4.13"
do
  echo -e "[DEBUG] repoRoot: ${repoRoot}\n"
  mkdir -p "${repoRoot}"
  
  # xargs -d works on projects-storage.eclipse.org, but not on default jnlp agent!
  dirs=$(ssh genie.cbi@projects-storage.eclipse.org "ls -1rd ${downloadRepoRoot}/${repoRoot}/I20* | xargs -d '\n' -n 1 basename")
  
  artifactsCompositeFile="${repoRoot}/compositeArtifacts.xml"
  contentCompositeFile="${repoRoot}/compositeContent.xml"
  p2Index="${repoRoot}/p2.index"

  writeArtifactsHeader "${artifactsCompositeFile}" "3"
  writeChildren "${artifactsCompositeFile}" "${dirs}" "3"
  writeFooter "${artifactsCompositeFile}"

  writeContentHeader "${contentCompositeFile}" "3"
  writeChildren "${contentCompositeFile}" "${dirs}" "3"
  writeFooter "${contentCompositeFile}"

  writeCompositeP2Index "${p2Index}"

  echo "[DEBUG]:";
  #ls -al ${repoRoot}
  cat ${artifactsCompositeFile}
  
  #scp dirs to projects-storage.eclipse.org
  scp ${repoRoot}/* genie.cbi@projects-storage.eclipse.org:${downloadRepoRoot}/${repoRoot}/
done
