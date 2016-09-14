package org.springframework.social.fitbit.api.activity;

import java.util.Date;



public interface ActivityOperations {

	public static final String DEVICE_URL = "device.json";
	//Steps
	IntradaySummary getIntradaySteps(DetailLevel detailLevel, Date baseDate);
	IntradaySummary getIntradaySteps(DetailLevel detailLevel, String baseDate);
	IntradaySummary getIntradaySteps(DetailLevel detailLevel, Date baseDate, Date startTime, Date endTime);
	IntradaySummary getIntradaySteps(DetailLevel detailLevel, String baseDate,String startTime, String endTime);
	
	//Heart
	IntradaySummary getIntradayHeart(DetailLevel detailLevel, Date baseDate);
	IntradaySummary getIntradayHeart(DetailLevel detailLevel, String baseDate);
	IntradaySummary getIntradayHeart(DetailLevel detailLevel, Date baseDate, Date startTime, Date endTime);
	IntradaySummary getIntradayHeart(DetailLevel detailLevel, String baseDate,String startTime, String endTime);
	
	/*String getIntradayCalories();
	String getIntradayCaloriesBMR();
	String getDistance();
	String getIntradayFloors();
	String getIntradayElevation();
	String getIntradayMinutesSedentary();
	String getIntradayMinutesLightlyActive();
	String getIntradayMinutesFairlyActive();
	String getIntradayMinutesVeryActive();
	String getIntradayActivityCalories();
	*/
		
}
