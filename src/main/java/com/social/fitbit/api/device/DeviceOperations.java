package com.social.fitbit.api.device;



public interface DeviceOperations {

	public static final String DEVICE_URL = "device.json";
	
	DeviceList getDevices();
		
}
