#!/usr/bin/env bash

BUILD_HOME=/home/davidw/gitCBI/
export TMP_DIR=${BUILD_HOME}/aggr/TMP
export LOCAL_REPO=${BUILD_HOME}/aggr/LOCALMVNREPO

REPO_DIR=${BUILD_HOME}/org.eclipse.cbi.p2repo.aggregator
export POM_DIR=${REPO_DIR}/org.eclipse.b3.releng.parent

out_file=${BUILD_HOME}/aggr/buildOutput.txt

# This first write does not "append", the rest need to.
env | tee ${out_file}


if [[ $1 == -clean ]]
then
  rm -fr ${TMP_DIR}
  rm -fr ${LOCAL_REPO}
  printf "\n\t[INFO] %s\n\n "-clean argument was specified on command line, so tmp and local maven repo were removed" | tee -a ${out_file}
else
  printf "\n\t[WARNING] %s\n\n "No -clean argument was specified on command line, so tmp and local maven repo were not removed" | tee -a ${out_file}
fi
mkdir -p ${TMP_DIR}
mkdir -p ${LOCAL_REPO}

# Without the ANT_OPTS, we do get messages about "to get repeatable builds, to ignore sysclasspath"
export ANT_HOME=${ANT_HOME:-/shared/common/apache-ant-1.9.6}
export ANT_OPTS=${ANT_OPTS:-"-Dbuild.sysclasspath=ignore -Dincludeantruntime=false"}
export MAVEN_OPTS=${MAVEN_OPTS:--Xms1048m -Xmx2096m -Djava.io.tmpdir=${TMP_DIR} -Dtycho.localArtifacts=ignore ${MIRROR_SETTING}}
export JAVA_HOME=/shared/common/jdk1.8.0_x64-latest
export JAVA_CMD=${JAVA_HOME}/jre/bin/java
export MAVEN_PATH=${MAVEN_PATH:-/shared/common/apache-maven-latest/bin}
export PATH=$JAVA_HOME/bin:$MAVEN_PATH:$ANT_HOME/bin:$PATH

cd ${POM_DIR}

printf "\n\t[INFO] %s\n\n" "Maven Version:" | tee -a ${out_file}
mvn -version | tee -a ${out_file}

printf "\n\t[INFO] %s\n\n" "Java Version:" | tee -a ${out_file}
java -version | tee -a ${out_file}

printf "\n\t[INFO] %s\n\n" "mvn clean verify ...:" | tee -a ${out_file}
mvn clean verify -X -e -DskipTests=true -Dmaven.repo.local=$LOCAL_REPO -Pbree-libs  2>&1 | tee -a ${out_file}

printf "\n\t[INFO] %s\n\n" "Build Output in ${out_file}"
