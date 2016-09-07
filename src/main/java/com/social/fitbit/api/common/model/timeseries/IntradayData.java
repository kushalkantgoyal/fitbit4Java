package com.social.fitbit.api.common.model.timeseries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kushalkant
 * 
 */

public class IntradayData {

    private String time;
    private double value;
    private Integer level;

    public IntradayData(String time, double value) {
        this.time = time;
        this.value = value;
    }

    public IntradayData(JSONObject json) throws JSONException {
        this(json, null);
    }
    
    public IntradayData(JSONObject json, String date) throws JSONException {
        value = json.getDouble("value");
        time = (date == null ? "" : date + " ");
        time = time + json.getString("time");
        if(json.has("level")) {
            level = json.getInt("level");
        }
    }

    public String getTime() {
        return time;
    }

    public double getValue() {
        return value;
    }

    public Integer getLevel() {
        return level;
    }

    public static List<IntradayData> jsonArrayToDataList(JSONArray array) throws JSONException {
        return jsonArrayToDataList(array, null);
    }
    
    public static List<IntradayData> jsonArrayToDataList(JSONArray array, String date) throws JSONException {
        List<IntradayData> intradayDataList = new ArrayList<IntradayData>(array.length());
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonData = array.getJSONObject(i);
            intradayDataList.add(new IntradayData(jsonData, date));
        }
        return intradayDataList;
    }

	@Override
	public String toString() {
		return "IntradayData [time=" + time + ", value=" + value + ", level="
				+ level + "]";
	}
}
