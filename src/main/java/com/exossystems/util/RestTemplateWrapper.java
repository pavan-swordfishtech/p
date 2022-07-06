package com.exossystems.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

import com.exossystems.api.exceptions.ExosExternalServiceInvocationException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestTemplateWrapper {
	@Autowired
	RestTemplate restTemplate;

	public <T, R> T postForEntity(Class<T> clazz, String url, R body, Object... uriVariables)
			throws ExosExternalServiceInvocationException {
		HttpEntity<R> request = new HttpEntity<>(body);
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseEntity<String> response = null;
		JavaType javaType;
		try {

			response = restTemplate.postForEntity(url, request, String.class, uriVariables);
			javaType = objectMapper.getTypeFactory().constructType(clazz);
		} catch (Exception exception) {
			throw new ExosExternalServiceInvocationException(
					"App services API execution failed with error : " + exception.getMessage());
		}

		return readValue(response, javaType);
	}

	private <T> T readValue(ResponseEntity<String> response, JavaType javaType)
			throws ExosExternalServiceInvocationException {
		T result = null;
		ObjectMapper objectMapper = new ObjectMapper();
		if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
			try {
				result = objectMapper.readValue(response.getBody(), javaType);
			} catch (Exception exception) {
				throw new ExosExternalServiceInvocationException(exception.getMessage());
			}
		} else {
			throw new ExosExternalServiceInvocationException("No data found {}" + response.getStatusCode());

		}
		return result;
	}
}