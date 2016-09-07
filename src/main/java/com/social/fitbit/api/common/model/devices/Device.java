package com.social.fitbit.api.common.model.devices;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Device {
    /**
     * Device id
     */
    private final String id;
    private final DeviceType type;
    /**
     * The battery level of the Fitbit device, one of Low, Medium, High, and Full. The level is "Low" when no
     * information is available.
     */
    private final String battery;

    private final String lastSyncTime;
    private final String deviceVersion;
    private final String mac;

    public Device(JSONObject json) throws JSONException {
        id = json.getString("id");
        type =  DeviceType.valueOf(json.getString("type"));
        battery = json.getString("battery");
        lastSyncTime = json.getString("lastSyncTime");
        deviceVersion = json.getString("deviceVersion");
        mac = json.getString("mac");
    }

    public static List<Device> constructDeviceList(JSONArray array) {
        try {
            return jsonArrayToDeviceList(array);
        } catch (JSONException e) {
            throw new JSONException(e.getMessage() + ':' + array, e);
        }
    }

    private static List<Device> jsonArrayToDeviceList(JSONArray array) throws JSONException {
        List<Device> deviceList = new ArrayList<Device>(array.length());
        for (int i = 0; i < array.length(); i++) {
            JSONObject device = array.getJSONObject(i);
            deviceList.add(new Device(device));
        }
        return deviceList;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type.name();
    }

    public DeviceType type() {
        return type;
    }

    public String getBattery() {
        return battery;
    }

    public String getLastSyncTime() {
        return lastSyncTime;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

	public String getMac() {
		return mac;
	}
}
