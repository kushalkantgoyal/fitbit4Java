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
package org.springframework.social.fitbit.connect;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

/**
 * Google-specific extension to OAuth2Template.
 * @author Gabriel Axel
 */
public class FitbitOAuth2Template extends OAuth2Template {
	
	public FitbitOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret,
				"https://www.fitbit.com/oauth2/authorize",
				"https://api.fitbit.com/oauth2/token");
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(parameters, headers);
		ResponseEntity<Map> responseEntity = getRestTemplate().exchange(accessTokenUrl, HttpMethod.POST, requestEntity, Map.class);
		Map<String, Object> responseMap = responseEntity.getBody();
		return extractAccessGrant(responseMap);
	}
	
	private AccessGrant extractAccessGrant(Map<String, Object> result) {
		String accessToken = (String) result.get("access_token");
		String scope = (String) result.get("scope");
		String refreshToken = (String) result.get("refresh_token");
		
		// result.get("expires_in") may be an Integer, so cast it to Number first. 	
		Number expiresInNumber = (Number) result.get("expires_in");
		Long expiresIn = (expiresInNumber == null) ? null : expiresInNumber.longValue();
		
		//overriding expiresIn to 1 year always
		expiresIn = 31536000L;
		return createAccessGrant(accessToken, scope, refreshToken, expiresIn, result);
	}
	
}
