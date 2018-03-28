#!/usr/bin/env bash
#
# Utility script to start build in this directory
# Copyright 2018 

# The gitCBIREPOdir variable MUST be set to the directory that contains (i.e. is the parent of) the local clone of org.eclipse.cbi.p2repo.aggregator.

# This runlocalBuild.sh file is typically copied up to that same directory, so its initial contents look as follows:
#  runLocalBuild.sh
#  org.eclipse.cbi.p2repo.aggregator

# once ran, the runBuild.sh file creates a "cleanable" directory under gitCBIREPOdir also. This cleanable directory
# in turn contains tmp and localMvnRepo which, as the name implies, can be removed for a "clean" run. 

gitCBIREPOdir=~/gitCBIPhoton

export WORKSPACE="${gitCBIREPOdir}"

export build_home=${WORKSPACE:-"${gitCBIREPOdir}"}

execDir="${build_home}/org.eclipse.cbi.p2repo.aggregator/org.eclipse.cbi.p2repo.releng.parent/buildScripts"

if [[ ! -d "${execDir}" ]]
then
  printf "[ERROR] %s\n\t%s\n" "The required directory did not exist. Did you correctly specify 'gitCBIREPOdir'?" "gitCBIREPOdir: ${gitCBIREPOdir}"
  exit 1
fi

execCMD="${execDir}/runBuild.sh"

printf "[INFO] %s\n" "gitCBIREPOdir: ${gitCBIREPOdir}"
printf "[INFO] %s\n" "WORKSPACE: ${WORKSPACE}"
printf "[INFO] %s\n" "build_home: ${build_home}"


"${execCMD}" 2>&1 | tee buildoutput.txt


