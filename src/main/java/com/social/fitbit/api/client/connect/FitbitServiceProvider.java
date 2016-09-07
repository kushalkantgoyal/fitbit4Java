/*
 * Copyright 2015 the original author or authors.
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
package com.social.fitbit.api.client.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

import com.social.fitbit.api.Fitbit;
import com.social.fitbit.api.client.impl.FitbitTemplate;

/**
 * Facebook ServiceProvider implementation.
 * @author Keith Donald
 * @author Craig Walls
 */
public class FitbitServiceProvider extends AbstractOAuth2ServiceProvider<Fitbit> {

	public FitbitServiceProvider(String clientId, String clientSecret) {
		super(new FitbitOAuth2Template(clientId, clientSecret));
	}

	@Override
	public Fitbit getApi(String accessToken) {
		return new FitbitTemplate(accessToken);
	}	
}
