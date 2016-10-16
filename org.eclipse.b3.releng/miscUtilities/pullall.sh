#!/usr/bin/env bash

currdir=$PWD
allrepos=$( find $currdir/*  -maxdepth 0 -type d )

for repo in $allrepos
do
    echo $repo
    cd $repo
    git pull  
    cd ..
done


