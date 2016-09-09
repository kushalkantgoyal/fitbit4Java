package com.social.fitbit.api.activity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Kushalkant
 * 
 */

public class IntradaySummary {

    private List<Data> summary;
    private IntradayDataset intradayDataset;
    
    
	
	public IntradayDataset getIntradayDataset() {
		return intradayDataset;
	}
	
	public void setIntradayDataset(IntradayDataset intradayDataset) {
		this.intradayDataset = intradayDataset;
	}
		
	/*@JsonAnySetter
	public void setDataAndIntradayDataset(String name, Object value) {
		
		switch(name){
		case "activities-calories-intraday" :
		case "activities-caloriesBMR-intraday" :
		case "activities-steps-intraday" :
		case "activities-distance-intraday" :
		case "activities-minutesSedentary-intraday" :
		case "activities-minutesLightlyActive-intraday" :
		case "activities-minutesFairlyActive-intraday" :
		case "activities-minutesVeryActive-intraday" :
		case "activities-activityCalories-intraday" :
		case "activities-floors-intraday" :
		case "activities-elevation-intraday" :
		case "activities-heart-intraday" :		setIntradayDataset((new ObjectMapper()).convertValue(value, IntradayDataset.class));
												break;
		case "activities-calories" :
		case "activities-caloriesBMR" :
		case "activities-steps" :
		case "activities-distance" :
		case "activities-minutesSedentary" :
		case "activities-minutesLightlyActive" :
		case "activities-minutesFairlyActive" :
		case "activities-minutesVeryActive" :
		case "activities-activityCalories" :
		case "activities-floors" :
		case "activities-elevation" :
		case "activities-heart" :				setSummary(Arrays.asList( (new ObjectMapper()).convertValue(value, Data[].class)));
												break;
		}
	}*/

	public List<Data> getSummary() {
		return summary;
	}

	public void setSummary(List<Data> summary) {
		this.summary = summary;
	}
}
