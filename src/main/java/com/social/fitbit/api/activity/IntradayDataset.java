package com.social.fitbit.api.activity;

import java.util.List;

/**
 * @author Kushalkant
 * 
 */

public class IntradayDataset {

    private int datasetInterval;
    private String datasetType;
    private List<IntradayData> dataset;

	public int getDatasetInterval() {
		return datasetInterval;
	}

	public void setDatasetInterval(int datasetInterval) {
		this.datasetInterval = datasetInterval;
	}

	public String getDatasetType() {
		return datasetType;
	}

	public void setDatasetType(String datasetType) {
		this.datasetType = datasetType;
	}

	public List<IntradayData> getDataset() {
		return dataset;
	}

	public void setDataset(List<IntradayData> dataset) {
		this.dataset = dataset;
	}

}
