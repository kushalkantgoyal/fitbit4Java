package com.social.fitbit.api.common.model.timeseries;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Kushalkant
 * 
 */

public class Data {

    String dateTime;
    String value;

    public Data(JSONObject json) throws JSONException {
        dateTime = json.getString("dateTime");
        value = json.getString("value");
    }

    public static List<Data> jsonArrayToDataList(JSONArray array) throws JSONException {
        List<Data> dataList = new ArrayList<Data>(array.length());
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonData = array.getJSONObject(i);
            dataList.add(new Data(jsonData));
        }
        return dataList;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getValue() {
        return value;
    }

    public long longValue() {
        return Long.valueOf(value);
    }

    public int intValue() {
        return Integer.valueOf(value);
    }

    public short shortValue() {
        return Short.valueOf(value);
    }

    public double doubleValue() {
        return Double.valueOf(value);
    }

	@Override
	public String toString() {
		return "Data [dateTime=" + dateTime + ", value=" + value + "]";
	}
}
