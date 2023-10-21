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
