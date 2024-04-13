#!/usr/bin/env bash

# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

checkVersion() {
    echo "Version = $1"
	  echo $1 |grep -E "^[0-9]+\.[0-9]+\.[0-9]+" > /dev/null
    if [ $? = 0 ]; then
        return 1
    fi

	echo "Version $1 illegal, it should be X.X.X format(e.g. 4.5.0), please check released versions in 'https://archive.apache.org/dist/rocketmq/'"
    exit -1
}

checkZipFile() {

	  file="../dist/target/rocketmq-eventbridge-dist-${ROCKETMQ_VERSION}.zip"

    if [ -e "$file" ]; then
        return 1
    fi

	  echo "the installation package rocketmq-eventbridge-dist-${ROCKETMQ_VERSION}.zip does not exist in dist/target, please check released package"
    exit -1
}

if [ $# -lt 1 ]; then
    echo -e "Usage: sh $0 Version"
    exit -1
fi
ROCKETMQ_VERSION=$1
checkVersion $ROCKETMQ_VERSION
checkZipFile
# copy package to docker directory
cp ../dist/target/rocketmq-eventbridge-dist-${ROCKETMQ_VERSION}.zip ./

# Build rocketmq-eventbridge

docker build -f Dockerfile -t apache/rocketmq-eventbridge:${ROCKETMQ_VERSION} .
rm -rf rocketmq-eventbridge-dist-${ROCKETMQ_VERSION}.zip

