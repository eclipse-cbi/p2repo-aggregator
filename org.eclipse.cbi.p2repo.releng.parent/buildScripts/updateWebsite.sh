#!/usr/bin/env bash
#*******************************************************************************
# Copyright (c) 2019 Eclipse Foundation and others.
# This program and the accompanying materials are made available
# under the terms of the Eclipse Public License 2.0
# which is available at http://www.eclipse.org/legal/epl-v20.html
# SPDX-License-Identifier: EPL-2.0
#*******************************************************************************

# Write latest ${buildId}/buildResults.html to our website/index.html
# This script needs to run on the CBI JIPP.

# Bash strict-mode
set -o errexit
set -o nounset
set -o pipefail

IFS=$'\n\t'

# Clone www.eclipse.org/cbi.git
git clone --quiet ssh://genie.cbi@git.eclipse.org:29418/www.eclipse.org/cbi

pushd ${WORKSPACE}/cbi

#git config --global push.default simple
git config  --global --add core.autocrlf input

downloadRepoRoot="/home/data/httpd/download.eclipse.org/cbi/updates/aggregator/headless/4.13"
latestBuildId=$(ssh genie.cbi@projects-storage.eclipse.org "ls -1td ${downloadRepoRoot}/I20* | head -1")

echo "latestBuildId: ${latestBuildId}"

# The "latest aggregator downloads" index.html will go into ${WORKSPACE}/cbi/downloads/aggregatorLatest/
# but then we still need to commit and push (with the CBI bot user)
scp genie.cbi@projects-storage.eclipse.org:${latestBuildId}/buildResults.html ${WORKSPACE}/cbi/downloads/aggregatorLatest/index.html

printf "\n[INFO] %s\n" "Confirming there is a change before 'adding' and 'committing'..."

if ! git diff --quiet; then
  printf "[INFO] %s\n\n" "=> Differences found!"
  git diff

  git config --global user.email "cbi-bot@eclipse.org"
  git config --global user.name "Common Build Infrastructure Bot"

  # Add and Commit 
  echo "Add and commit"
  git commit -a --verbose -m "Auto commit from Jenkins 'cbi.p2repo.aggregator_addComposites' job"

  printf "\n[DEBUG] %s\n" "Confirm status should show 'ahead by one commit'"
  git status

  git push --verbose origin master:refs/heads/master
else 
  printf "[INFO] %s\n\n" "=> No differences found, so nothing added or committed to 'www' repo. Probably due to multiple runs?"
fi

popd
