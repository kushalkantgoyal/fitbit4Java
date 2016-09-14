package org.springframework.social.fitbit.api.sleep;

import java.util.Date;

public interface SleepOperations {

	public static final String MINUTES_ASLEEP = "sleep/minutesAsleep";
	public static final String MINUTES_AWAKE = "sleep/minutesAwake"; 
	public static final String AWAKENINGS_COUNT = "sleep/awakeningsCount";
	public static final String TIME_IN_BED = "sleep/timeInBed";
	public static final String MINUTES_TO_FALL_ASLEEP = "sleep/minutesToFallAsleep";
	public static final String MINUTES_AFTER_WAKEUP = "sleep/minutesAfterWakeup";
	public static final String TIME_ENTERED_BED = "sleep/startTime";
	public static final String EFFICIENCY = "sleep/efficiency"; 
	public static final String SLEEP = "sleep/date/%1$s.json"; 
	
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
