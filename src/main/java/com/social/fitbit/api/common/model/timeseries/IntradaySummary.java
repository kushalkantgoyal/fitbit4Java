package com.social.fitbit.api.common.model.timeseries;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Kushalkant
 * 
 */

public class IntradaySummary {

    private Data summary;
    private IntradayDataset intradayDataset;

    public IntradaySummary(JSONObject json, ResourceType resourceType, boolean addDateToIntradayTime) throws JSONException {
        String timeSeriesJsonName = resourceType.getResourcePath().replace('/', '-');
        String intradayDataJsonName = timeSeriesJsonName + "-intraday";
        summary = Data.jsonArrayToDataList(json.getJSONArray(timeSeriesJsonName)).get(0);
        if (json.has(intradayDataJsonName)) {
        	if(!addDateToIntradayTime){
        		intradayDataset = new IntradayDataset(json.getJSONObject(intradayDataJsonName));
        	}else{
        		intradayDataset = new IntradayDataset(json.getJSONObject(intradayDataJsonName), summary.getDateTime());
        	}
        }
    }
    
    public IntradaySummary(JSONObject json, ResourceType resourceType) throws JSONException {
    	this(json, resourceType, false);
    }
    
    public IntradaySummary(Data summary, IntradayDataset intradayDataset) {
        this.summary = summary;
        this.intradayDataset = intradayDataset;
    }

    public Data getSummary() {
        return summary;
    }

    public IntradayDataset getIntradayDataset() {
        return intradayDataset;
    }

	@Override
	public String toString() {
		return "IntradaySummary [summary=" + summary + ", intradayDataset="
				+ intradayDataset + "]";
	}
}
