package com.social.fitbit.api.common.model.timeseries;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * @author Kushalkant
 * 
 */

public class IntradayDataset {

    private int datasetInterval;
    private List<IntradayData> dataset;

    public IntradayDataset(int datasetInterval, List<IntradayData> dataset) {
        this.datasetInterval = datasetInterval;
        this.dataset = dataset;
    }

    public IntradayDataset(JSONObject json) throws JSONException {
        this(json, null);
    }

    public IntradayDataset(JSONObject json, String date) {
    	this.datasetInterval = json.getInt("datasetInterval");
    	this.dataset = IntradayData.jsonArrayToDataList(json.getJSONArray("dataset"), date);
	}

	public int getDatasetInterval() {
        return datasetInterval;
    }

    public List<IntradayData> getDataset() {
        return dataset;
    }

	public void setDatasetInterval(int datasetInterval) {
		this.datasetInterval = datasetInterval;
	}

	public void setDataset(List<IntradayData> dataset) {
		this.dataset = dataset;
	}

}
