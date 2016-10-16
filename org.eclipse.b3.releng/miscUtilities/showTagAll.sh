#!/usr/bin/env bash


function usage () 
{
    printf "\n\t%s\n" "This script requires one argument, the tag to show"
    printf "\t\t%s\n" "Example: $(basename $0) R4_2_2"
    exit 1
}

TAG=$1

if [[ -z "${TAG}" ]]
then
    usage
    exit 1
fi

currdir=$PWD
allrepos=$( find $currdir -maxdepth 1 -type d )

echo -e "\tThe following projects are tagged with $TAG\n\n" > tagged$TAG.txt
echo -e "\tThe following projects are NOT tagged with $TAG\n\n" > taggedNot$TAG.txt



for repo in $allrepos
do
    #echo $repo
    cd $repo
    git show -s --oneline $TAG  1>>../out.txt 2>>../err.txt
    RC=$?
    if [[ $RC == 0 ]]
    then
        echo "${repo##*/}" >> ../tagged$TAG.txt
    else
        echo "${repo##*/}" >> ../taggedNot$TAG.txt
    fi
    cd ..
done


