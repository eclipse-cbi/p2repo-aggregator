

export TMP_DIR=/shared/TMP
export LOCAL_REPO=/shared/LOCALMVNREPO
#export POM_DIR=~/gitb3/b3/org.eclipse.b3.releng.parent
export POM_DIR=~/gitb3mirror/b3/org.eclipse.b3.releng.parent

if [[ $1 == -clean ]]
then
  rm -fr ${TMP_DIR}
  rm -fr ${LOCAL_REPO}
fi
mkdir -p ${TMP_DIR}
mkdir -p ${LOCAL_REPO}

# But, without the ANT_OPTS, we do get messages about "to get repeatable builds, to ignore sysclasspath"
export ANT_HOME=${ANT_HOME:-/shared/common/apache-ant-1.9.6}
export ANT_OPTS=${ANT_OPTS:-"-Dbuild.sysclasspath=ignore -Dincludeantruntime=false"}
export MAVEN_OPTS=${MAVEN_OPTS:--Xms1048m -Xmx2096m -Djava.io.tmpdir=${TMP_DIR} -Dtycho.localArtifacts=ignore ${MIRROR_SETTING}}
export JAVA_HOME=/shared/common/jdk1.8.0_x64-latest
export JAVA_CMD=${JAVA_HOME}/jre/bin/java
export MAVEN_PATH=${MAVEN_PATH:-/shared/common/apache-maven-latest/bin}
export PATH=$JAVA_HOME/bin:$MAVEN_PATH:$ANT_HOME/bin:$PATH

cd ${POM_DIR}

mvn -version

java -version

mvn clean verify -X -e -DskipTests=true -Dmaven.repo.local=$LOCAL_REPO -Pbree-libs  2>&1 | tee ~/temp/out.txt

