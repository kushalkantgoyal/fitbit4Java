package com.social.fitbit.api.activity;

import java.util.Date;

import org.springframework.web.client.RestTemplate;

import com.social.fitbit.api.impl.AbstractFitbitApiOperations;
import com.social.fitbit.util.TimeUtils;

public class ActivityTemplate extends AbstractFitbitApiOperations implements ActivityOperations {

	public ActivityTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	private String buildIntradayActivityEndpoint(ResourceType resourceType, DetailLevel detailLevel, 
    		String baseDate, String startTime, String endTime) {
    	StringBuilder url = new StringBuilder()
        .append(resourceType.getResourcePath())
        .append("/date/" + baseDate)
        .append("/1d/" + detailLevel.getDetailFormat())
        .append(endTime == null ? "" : "/time/" + startTime + "/" + endTime)
        .append(".json");
        return url.toString();
    }
	
	private IntradaySummary getData(ResourceType resourceType, DetailLevel detailLevel, 
    		String baseDate, String startTime, String endTime){
		String url = buildIntradayActivityEndpoint(resourceType, detailLevel, baseDate , startTime, endTime);
		return getEntity(url, IntradaySummary.class);
	}
	
	@Override
	public IntradaySummary getIntradaySteps(DetailLevel detailLevel, Date baseDate) {
		return getIntradaySteps(detailLevel, TimeUtils.LOCAL_DATE_FORMATTER.format(baseDate), 
				null, null);
	}

	@Override
	public IntradaySummary getIntradaySteps(DetailLevel detailLevel, String baseDate) {
		return getIntradaySteps(detailLevel, baseDate, null, null);
	}

	@Override
	public IntradaySummary getIntradaySteps(DetailLevel detailLevel, Date baseDate, Date startTime, Date endTime) {
		return getIntradaySteps(detailLevel, TimeUtils.LOCAL_DATE_FORMATTER.format(baseDate), 
				TimeUtils.LOCAL_TIME_HOURS_MINUTES_FORMATTER.format(startTime),
				TimeUtils.LOCAL_TIME_HOURS_MINUTES_FORMATTER.format(endTime));
	}

	@Override
	public IntradaySummary getIntradaySteps(DetailLevel detailLevel, String baseDate, String startTime, String endTime) {
		return getData(ResourceType.STEPS, detailLevel, baseDate , startTime, endTime);
	}
}