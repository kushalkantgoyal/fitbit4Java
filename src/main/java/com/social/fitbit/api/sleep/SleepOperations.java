package com.social.fitbit.api.sleep;

import java.util.Date;

public interface SleepOperations {

	public enum Operations {
		
		MINUTES_ASLEEP("sleep/minutesAsleep"),
	    MINUTES_AWAKE("sleep/minutesAwake"),
	    AWAKENINGS_COUNT("sleep/awakeningsCount"),
	    TIME_IN_BED("sleep/timeInBed"),
	    MINUTES_TO_FALL_ASLEEP("sleep/minutesToFallAsleep"),
	    MINUTES_AFTER_WAKEUP("sleep/minutesAfterWakeup"),
	    TIME_ENTERED_BED("sleep/startTime"),
	    EFFICIENCY("sleep/efficiency"),
	    SLEEP("sleep/date/%1$s.json");
		
	    private String resourcePath;

	    Operations(String resourcePath) {
	        this.resourcePath = resourcePath;
	    }

	    public String getResourcePath() {
	        return resourcePath;
	    }
	}
	
	public void getMinutesAsleep();
	public void getMinutesAwake();
	public void getAwakeningsCount();
	public void getTimeInBed();
	public void getMinutesToFallAsleep();
	public void getMinutesAfterWakeup();
	public void getStartTime();
	public void getEfficiency();
	public Sleep getSleep(Date date);
	public Sleep getSleep(String dateString);
	
}
