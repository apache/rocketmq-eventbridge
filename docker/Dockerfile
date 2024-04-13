#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

FROM eclipse-temurin:8-jdk-centos7 AS builder

RUN set -eux \
    && yum -y update \
    && yum -y install curl gnupg unzip \
    && yum clean all -y

ENV EVENTBRIDGE_USER=apps \
    EVENTBRIDGE_HOME=/home/apps/rocketmq-eventbridge \
    EVENTBRIDGE_LOG_DIR=/home/apps/logs \
    EVENTBRIDGE_LOG_FILE=/home/apps/logs/rocketmq-eventbridge.log

RUN set -x \
    && adduser "$EVENTBRIDGE_USER" \
    && mkdir -p "$EVENTBRIDGE_LOG_DIR" \
    && touch "$EVENTBRIDGE_LOG_FILE"

WORKDIR /home/apps
ARG version
# Rocketmq eventbridge version
ENV ROCKETMQ_EVENTBRIDGE_VERSION ${version}

ADD rocketmq-eventbridge-dist-${ROCKETMQ_EVENTBRIDGE_VERSION}.zip /home/apps
RUN cd /home/apps && unzip rocketmq-eventbridge-dist-${ROCKETMQ_EVENTBRIDGE_VERSION}.zip && rm -rf rocketmq-eventbridge-dist-${ROCKETMQ_EVENTBRIDGE_VERSION}.zip

RUN chown -R "$EVENTBRIDGE_USER:$EVENTBRIDGE_USER" "$EVENTBRIDGE_HOME"  "$EVENTBRIDGE_LOG_DIR"
COPY docker-entrypoint.sh /home/apps/rocketmq-eventbridge/bin
RUN chmod 755 /home/apps/rocketmq-eventbridge/bin/docker-entrypoint.sh

EXPOSE 8083 7001 7002
USER apps
WORKDIR /home/apps/rocketmq-eventbridge

ENTRYPOINT ["./bin/docker-entrypoint.sh"]
