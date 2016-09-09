package com.social.fitbit.api.device;

import org.springframework.web.client.RestTemplate;

import com.social.fitbit.api.impl.AbstractFitbitApiOperations;

public class DeviceTemplate extends AbstractFitbitApiOperations implements DeviceOperations {

	public DeviceTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	@Override
	public DeviceList getDevices() {
		DeviceList deviceList = getEntity(DEVICE_URL, DeviceList.class);
		return deviceList;
	}
}