package org.springframework.social.fitbit.api.device;

import org.springframework.social.fitbit.api.impl.AbstractFitbitApiOperations;
import org.springframework.web.client.RestTemplate;

public class DeviceTemplate extends AbstractFitbitApiOperations implements DeviceOperations {

	public DeviceTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	@Override
	public Device[] getDevices() {
		Device[] deviceList = get(DEVICE_URL, Device[].class);
		return deviceList;
	}
}