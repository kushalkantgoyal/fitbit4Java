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
package org.springframework.social.fitbit.api.impl;

import org.springframework.social.fitbit.api.Fitbit;
import org.springframework.social.fitbit.api.activity.ActivityOperations;
import org.springframework.social.fitbit.api.activity.ActivityTemplate;
import org.springframework.social.fitbit.api.device.DeviceOperations;
import org.springframework.social.fitbit.api.device.DeviceTemplate;
import org.springframework.social.fitbit.api.sleep.SleepOperations;
import org.springframework.social.fitbit.api.sleep.SleepTemplate;
import org.springframework.social.fitbit.api.user.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;

/**
 * <p>
 * The central class for interacting with Google APIs.
 * </p>
 * <p>
 * Most of the APIs, specifically all GData APIs and Google+ usage of "me", require OAuth2 authentication.
 * To use methods that require OAuth2 authentication, {@link FitbitTemplate} must be constructed with
 * an access token which is authorized for the appropriate scope.
 * For using Google+ without authenticating, {@link FitbitTemplate} default constructor can be used.
 * </p>
 * @author Gabriel Axel
 */
public class FitbitTemplate extends AbstractOAuth2ApiBinding implements Fitbit {

	private String accessToken;

	private UserOperations userOperations;
	private SleepOperations sleepOperations;
	private DeviceOperations deviceOperations;
	private ActivityOperations activityOperations;
	
	/**
	 * Creates a new instance of GoogleTemplate.
	 * This constructor creates a new GoogleTemplate able to perform unauthenticated operations against Google+.
	 */
	public FitbitTemplate() {
		initialize();
	}

	/**
	 * Creates a new instance of FitbitTemplate.
	 * This constructor creates the FacebookTemplate using a given access token.
	 * @param accessToken an access token granted by Google after OAuth2 authentication
	 */
	public FitbitTemplate(String accessToken) {
		super(accessToken);
		this.accessToken = accessToken;
		initialize();
	}

	private void initialize() {
		userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
		sleepOperations = new SleepTemplate(getRestTemplate(), isAuthorized());
		deviceOperations = new DeviceTemplate(getRestTemplate(), isAuthorized());
		activityOperations = new ActivityTemplate(getRestTemplate(), isAuthorized());
	}

/*	@Override
	protected List<HttpMessageConverter<?>> getMessageConverters() {

		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		objectMapper.setSerializationInclusion(NON_NULL);
		jsonConverter.setObjectMapper(objectMapper);

		FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
		formHttpMessageConverter.addPartConverter(jsonConverter);

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add();
		messageConverters.add(new ByteArrayHttpMessageConverter());
		messageConverters.add(new StringHttpMessageConverter());
		messageConverters.add(formHttpMessageConverter);
		messageConverters.add(new ResourceHttpMessageConverter());
		return messageConverters;
	}*/

	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.BEARER;
	}

	@Override
	public UserOperations userOperations() {
		return userOperations;
	}

	@Override
	public String getAccessToken() {
		return accessToken;
	}

	@Override
	public SleepOperations sleepOperations() {
		return sleepOperations;
	}

	@Override
	public DeviceOperations deviceOperations() {
		return deviceOperations;
	}

	@Override
	public ActivityOperations activityOperations() {
		return activityOperations;
	}
}