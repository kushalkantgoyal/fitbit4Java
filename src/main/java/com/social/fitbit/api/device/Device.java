package com.social.fitbit.api.device;

import java.util.Date;
import java.util.List;


public class Device {
	    private String id;
	    private String type;

	    /**
	     * The battery level of the Fitbit device, one of Low, Medium, High, and Full. The level is "Low" when no
	     * information is available.
	     */
	    private String battery;

	    private Date lastSyncTime;
	    private String deviceVersion;
	    private List<String> features;
	    private String mac;
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getBattery() {
			return battery;
		}
		public void setBattery(String battery) {
			this.battery = battery;
		}
		public Date getLastSyncTime() {
			return lastSyncTime;
		}
		public void setLastSyncTime(Date lastSyncTime) {
			this.lastSyncTime = lastSyncTime;
		}
		public String getDeviceVersion() {
			return deviceVersion;
		}
		public void setDeviceVersion(String deviceVersion) {
			this.deviceVersion = deviceVersion;
		}
		public List<String> getFeatures() {
			return features;
		}
		public void setFeatures(List<String> features) {
			this.features = features;
		}
		public String getMac() {
			return mac;
		}
		public void setMac(String mac) {
			this.mac = mac;
		}

}
