package org.springframework.social.fitbit.api.device;

public interface DeviceOperations {

	public static final String DEVICE_URL = "devices.json";
	
	Device[] getDevices();
		
}
