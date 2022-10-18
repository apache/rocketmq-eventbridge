 /*
  * Licensed to the Apache Software Foundation (ASF) under one or more
  * contributor license agreements.  See the NOTICE file distributed with
  * this work for additional information regarding copyright ownership.
  * The ASF licenses this file to You under the Apache License, Version 2.0
  * (the "License"); you may not use this file except in compliance with
  * the License.  You may obtain a copy of the License at
  *
  *     http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */

package org.apache.rocketmq.eventbridge.tools;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.lang3.StringUtils;

public class NetUtil {
    public static boolean isIpv4(String ip) {
        ip = ip.trim();

        try {
            InetAddress address = InetAddress.getByName(ip);
            if (address instanceof Inet4Address) {
                return true;
            }
            return false;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    public static boolean isNetSegment(String netSegment) {
        netSegment = netSegment.trim();
        if (StringUtils.isNotBlank(netSegment) && netSegment.contains("/")) {
            String[] parts = netSegment.split("/");
            if (parts.length == 2) {
                try {
                    String net = parts[0];
                    int maskLength = Integer.parseInt(parts[1]);
                    return isIpv4(net) && maskLength >= 0 && maskLength <= 32;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }
}
