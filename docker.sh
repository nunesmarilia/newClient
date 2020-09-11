#!/bin/bash

BUILD_ORG="marcelonunes"
BUILD_NAME="examplespringboot"
BUILD_VERSION="latest"
BUILD_PUSH=0

while getopts "pt:" OPT; do
  case "$OPT" in
  "t") BUILD_VERSION=$OPTARG;; # exibir ajuda
  "p") BUILD_PUSH=1;;
  esac
  done

echo "Docker BUILD for $BUILD_VERSION....."

docker build -t $BUILD_ORG/$BUILD_NAME:$BUILD_VERSION .

echo "Docker BUILD:$BUILD_VERSION Finished!"

if [ $BUILD_PUSH = 1 ]; then
	
	echo "Docker PUSH for $BUILD_VERSION....."
	
	docker login $BUILD_ORG
	
	docker push $BUILD_ORG/$BUILD_NAME:$BUILD_VERSION
	
	echo "Docker PUSH:$BUILD_VERSION Finished!"
	
fi
