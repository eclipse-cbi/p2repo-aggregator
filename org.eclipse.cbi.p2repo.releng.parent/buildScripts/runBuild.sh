#!/usr/bin/env bash

build_home=${WORKSPACE:-/home/davidw/gitCBI}
cleanableDir=${build_home}/cleanable
export tmp_dir=${cleanableDir}/tmp
export local_mvn_repo=${cleanableDir}/localMvnRepo

parent_dir=${build_home}/org.eclipse.cbi.p2repo.aggregator/org.eclipse.cbi.p2repo.releng.parent

out_file=${build_home}/buildOutput.txt
# remove any previous top level output files, if they exist
rm -f *.txt
rm -f *.html
rm -f *.properties
rm -f *.shsource
rm -f *.php

# This first write does not "append", the rest need to.
echo -e "Build log\n" | tee ${out_file}

echo -e "\n\t[INFO] all args passed to ${0##*/}:" | tee -a ${out_file}
for arg in "$@" 
do
    echo -e "\t\t>$arg<" | tee -a ${out_file}
done
echo -e "\n"

echo -e "\n\t[INFO] All env properties\n" | tee -a ${out_file}
env | tee -a ${out_file}

cleanLocal=$1

signjars=$2

if [[ -z "${cleanLocal}" ]]
then
  cleanLocal="NotSpecified"
fi

if [[ "${cleanLocal}" == "true" ]]
then
  rm -fr ${tmp_dir}
  rm -fr ${local_mvn_repo}
  # there should be nothing left in 'cleanable', but we will delete it 
  # anyway, to be sure.
  rm -fr ${cleanableDir}
  printf "\n\t[INFO] %s\n\n" "cleanLocal argument was true so tmp and local maven repo were removed" | tee -a ${out_file}
else
  printf "\n\t[WARNING] %s\n\n" "cleanLocal argument was not true so tmp and local maven repo were not removed" | tee -a ${out_file}
fi
mkdir -p ${tmp_dir}
mkdir -p ${local_mvn_repo}

if [[ -z "${signJars}" ]]
then
  signJars="NotSpecified"
fi

if [[ "${signJars}" == "true" ]] 
then
  sign_jars_arg="-Peclipse-sign"
fi

# Without the ANT_OPTS, we do get messages about "to get repeatable builds, to ignore sysclasspath"
export ANT_HOME=${ANT_HOME:-/shared/common/apache-ant-1.10.1}
export ANT_OPTS=${ANT_OPTS:-"-Dbuild.sysclasspath=ignore -Dincludeantruntime=false"}
export MAVEN_OPTS="-Xms1048m -Xmx2096m -Djava.io.tmpdir=${tmp_dir} ${MIRROR_SETTING}"
TYCHO_ARGS="-Djava.io.tmpdir=${tmp_dir} -Dtycho.localArtifacts=ignore -Dtycho.debug.artifactcomparator ${MIRROR_SETTING} ${DIRTY_SETTING} ${COMPARATOR_SETTING}"
export JAVA_HOME=/shared/common/jdk1.8.0_x64-latest
export JAVA_CMD=${JAVA_HOME}/jre/bin/java
export MAVEN_PATH=${MAVEN_PATH:-/shared/common/apache-maven-latest/bin}
export PATH=$JAVA_HOME/bin:$MAVEN_PATH:$ANT_HOME/bin:$PATH

cd ${parent_dir}

printf "\n\t[INFO] %s\n" "mvn clean verify ...:" | tee -a ${out_file}
printf "\n\t[INFO] %s\n" "MAVEN_OPTS: ${MAVEN_OPTS}" | tee -a ${out_file}
printf "\n\t[INFO] %s\n\n" "TYCHO_ARGS: ${TYCHO_ARGS}" | tee -a ${out_file}
# All -D type settings need to come before the -P settings, apparently.
# Note: signJars and cleanLocal values are passed in as -D values simply so they can be captured in 
#       the "saveproperties/mavenproperties.properties" file.
mvn clean verify -X -e --update-snapshots -DsignJars=${signJars} -DcleanLocal=${cleanLocal} -DskipTests=true -Dmaven.repo.local=$local_mvn_repo ${TYCHO_ARGS} -Pbree-libs ${sign_jars_arg} 2>>${out_file} | tee -a ${out_file}
RC=${PIPESTATUS[0]}

printf "\n\t[INFO] %s\n\n" "Build Output in ${out_file}"

if [[ $RC != 0 ]]
then
  echo -e "[ERROR] mvn returned a non-zero error code: $RC. Exiting.\n" | tee -a ${out_file}
  exit $RC
fi

# = = = = = = Build is over, now for some follow-up work. = = = = =
# In this section we convert the mavenproperties.properties into a format 
# that can be read by bash an by PHP. 
propertiesfile="${build_home}/org.eclipse.cbi.p2repo.aggregator/org.eclipse.cbi.p2repo.cli.product/target/mavenproperties.properties"
sourceProperties="${build_home}/mavenproperties.shsource"
phpProperties="${build_home}/mavenproperties.php"

function convertProperties
{
  file=$1
  outfileSource=$2
  outfilephp=$3
  if [ -f "$file" ]
  then
    #echo -e "\n[DEBUG] properties found at expected location: \n\t$file\n"
    echo "# Ant properties translated to bash shell variables" > $outfileSource
    # Note: we intentionally leave php file "unclosed" since it is included
    # in another php file, we assume.
    echo -e "<?php\n// Ant properties translated to PHP variables" > $outfilephp

    while IFS='=' read -r key value
    do
      # Technically, we only need 'buildId' and 'updateRelease' for now (no periods in var name) so 
      # we do not need the space and period translations. But, would in more
      # complicated cases.
      if [[ -n $key ]] 
      then
        # first handle comments. Lines that start with an "ant comment character" ('!' or '#') are 
        # written verbatim, but with approperite comment character ('#' for bash and '//' for php).
        if [[ $key =~ ^!(.*)$ || $key =~ ^#(.*)$ ]]
        then
          echo "#"${BASH_REMATCH[1]} >> $outfileSource
          echo "//"${BASH_REMATCH[1]} >> $outfilephp
        else
          # We only write variables if value is defined. (Otherwise, 
          # can easily provide "illegal" values.) We may want to provide some
          # default value such as "NOT_DEFINED" in come use-cases, but will 
          # wait until we have such a use-case.
          if [[ -n "${value}" && ! "${value}" =~ ^\$\{.*\}$ ]]
          then
            key=$(echo $key | tr ' ' '_')
            key=$(echo $key | tr '.' '_')
            key=$(echo $key | tr '-' '_')
            eval "${key}=\"${value}\""
            #echo -e "[DEBUG] key   =" ${key}
            #echo -e "[DEBUG] value =" ${value}
            # we quote to account for spaces in values
            echo "${key}=\"${value}\"" >> $outfileSource
            echo "\$${key}=\"${value}\";" >> $outfilephp
          fi
        fi
      fi
    done < "$file"
    echo -e "\n[INFO] source properties created in $outfileSource\n"
    echo -e "\n[INFO] php properties created in $outfilephp\n"
  else
    echo -e "\n[ERROR] property file not found at expected location: \n\t$file\n"
  fi
}
convertProperties $propertiesfile $sourceProperties $phpProperties
# we copy up to root, for simpler "archiving". 
cp $propertiesfile ${build_home}/mavenproperties.properites

# Test our own repository!
${build_home}/org.eclipse.cbi.p2repo.aggregator/org.eclipse.cbi.p2repo.releng.parent/buildScripts/testOurRepo.sh
