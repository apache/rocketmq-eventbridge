/*
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package org.apache.rocketmq.eventbridge.e2etest.util;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Map;

public class Utils {

	public static <T> ResponseEntity<T> request(TestRestTemplate template, String url, HttpMethod method, Object body, Class<T> clazz, Map<String, String> headers) {
		HttpHeaders httpHeaders = devHeaders(headers);
		HttpEntity entity = new HttpEntity(body, httpHeaders);
		return template.exchange(url, method, entity, clazz);
	}

	public static <T> ResponseEntity<T> requestByGet(TestRestTemplate template, String url, Map<String,Object> args, Class<T> clazz) {
		return template.getForEntity(url, clazz ,args);
	}

	public static <T> ResponseEntity<T> requestByPost(TestRestTemplate template, String url, String fileKey, String file, Class<T> clazz, Map<String, String> headers, Object... urlVariables) throws IOException {
		HttpHeaders httpHeaders = devHeaders(headers);
		httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> multipartRequest = new LinkedMultiValueMap<>();
		multipartRequest.add(fileKey, new ClassPathResource(file));
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(multipartRequest, httpHeaders);

		return template.exchange(url, HttpMethod.POST, entity, clazz, urlVariables);
	}

	private static HttpHeaders devHeaders(Map<String, String> headers) {
		HttpHeaders httpHeaders = new HttpHeaders();
		if (headers != null && !headers.isEmpty()) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				httpHeaders.add(entry.getKey(), entry.getValue());
			}
		}
		return httpHeaders;
	}

}
