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

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

import com.social.fitbit.api.Fitbit;
import com.social.fitbit.api.common.model.user.User;

/**
 * Facebook ApiAdapter implementation.
 * @author Keith Donald
 */
public class FitbitAdapter implements ApiAdapter<Fitbit> {

	public boolean test(Fitbit fitbit) {
		try {
			fitbit.userOperations().getUserProfile();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(Fitbit fitbit, ConnectionValues values) {
		User profile = fitbit.userOperations().getUserProfile();
		values.setProviderUserId(profile.getEncodedId());
		values.setDisplayName(profile.getDisplayName());
		//values.setProfileUrl(profile.getLink());
		values.setImageUrl(profile.getAvatar());
	}

	public void updateStatus(Fitbit facebook, String message) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UserProfile fetchUserProfile(Fitbit fitbit) {
		User profile = fitbit.userOperations().getUserProfile();
		return new UserProfileBuilder().setUsername(profile.getEncodedId())
				.setName(profile.getDisplayName()).build();
	}

}
