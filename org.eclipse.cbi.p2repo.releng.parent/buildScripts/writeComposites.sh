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

# This script is similar to /org.eclipse.cbi.p2repo.analyzers.parent/buildScripts/writeComposites_ssh.sh

# Bash strict-mode
set -o errexit
set -o nounset
set -o pipefail

IFS=$'\n\t'

username="genie.cbi"
host="projects-storage.eclipse.org"
REPO_BASE_DIR="/home/data/httpd/download.eclipse.org/cbi/updates/aggregator"

write_header() {
  local outfile=$1
  local type=$2
  cat > "${outfile}" <<EOL
<?xml version='1.0' encoding='UTF-8'?>
<?compositeMetadataRepository version='1.0.0'?>
<repository name='Eclipse CBI p2 Repository Analyzers'  type='org.eclipse.equinox.internal.p2.metadata.repository.${type}' version='1.0.0'>
  <properties size='3'>
    <property name='p2.timestamp' value='1313779613118'/>
    <property name='p2.compressed' value='true'/>
    <property name='p2.atomic.composite.loading' value='true'/>
  </properties>
EOL
}

write_footer() {
  local outfile=$1
  cat >> "${outfile}" <<EOL
  </children>
</repository>
EOL
}

write_composite_P2Index() {
  local outfile=$1
  cat > "${outfile}" <<EOL
version=1
metadata.repository.factory.order=compositeContent.xml
artifact.repository.factory.order=compositeArtifacts.xml
EOL
}

write_composite_repo() {
  local outfile=$1
  local dirs=$2
  local type=$3
  local nChildren=$4

  write_header "${outfile}" "${type}"

  children=$(printf "${dirs}\n" | head -n ${nChildren})

  nChildren=$(echo -e "${children}" | wc -l)
  echo "  <children size='${nChildren}'>" >> "${outfile}"
  for child in ${children}
  do
    printf "%s%s%s\n" "    <child location='" ${child} "' />" >> "${outfile}"
  done

  write_footer "${outfile}"
}

create_composite_repo() {
  #TODO: use parameter(s) instead of static values
  for repoDir in "ide/4.13" "headless/4.13"
  do
    echo -e "[DEBUG] repoDir: ${repoDir}\n"
    mkdir -p "${repoDir}"
    
    # xargs -d works on projects-storage.eclipse.org, but not on default jnlp agent!
    dirs=$(ssh ${username}@${host} "ls -1rd ${REPO_BASE_DIR}/${repoDir}/I20* | xargs -d '\n' -n 1 basename")
  
    write_composite_repo "${repoDir}/compositeArtifacts.xml" "${dirs}" "CompositeArtifactRepository" "3"
    write_composite_repo "${repoDir}/compositeContent.xml" "${dirs}" "CompositeMetadataRepository" "3"
    write_composite_P2Index "${repoDir}/p2.index"
  
    echo "[DEBUG]:";
    #ls -al "${repoDir}"
    cat "${repoDir}/compositeArtifacts.xml"
  
    #scp dirs to projects-storage.eclipse.org
    scp "${repoDir}"/* "${username}@${host}:${REPO_BASE_DIR}/${repoDir}/"
  done
}

create_composite_repo
