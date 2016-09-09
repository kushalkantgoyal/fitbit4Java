/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.social.fitbit.api.impl;

import static org.springframework.http.HttpMethod.PATCH;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * Abstract superclass for implementations that work with Google+ APIs.
 * @author Gabriel Axel
 */
public abstract class AbstractFitbitApiOperations {
	
	protected final String FITBIT_BASE_URL = "https://api.fitbit.com/1/user/-/";
	protected final RestTemplate restTemplate;
	protected final boolean isAuthorized;
	private final static Log logger = LogFactory.getLog(AbstractFitbitApiOperations.class);

	protected AbstractFitbitApiOperations(RestTemplate restTemplate, boolean isAuthorized) {
		this.restTemplate = restTemplate;
		this.isAuthorized = isAuthorized;

		restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				if (logger.isWarnEnabled()) {
					String bodyText = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset());
					logger.warn("Fitbit API REST response body:" + bodyText);
				}
			}
		});
	}

	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("fitbit");
		}
	}
	
	protected <T> T getEntity(String url, Class<T> type) {
		return restTemplate.getForObject(FITBIT_BASE_URL + url, type);
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T saveEntity(String url, T entity) {
		return (T) restTemplate.postForObject(url, entity, entity.getClass());
	}
	
	protected void deleteEntity(String baseUrl, String id) {
		restTemplate.delete(baseUrl + '/' + id);
	}
	
	protected <T> T patch(String url, Object request, Class<T> responseType) {
		ResponseEntity<T> response = restTemplate.exchange(url, PATCH, new HttpEntity<Object>(request), responseType);
		return response.getBody();
	}
}
