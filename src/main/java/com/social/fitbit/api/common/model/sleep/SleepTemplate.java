package com.social.fitbit.api.common.model.sleep;

import java.util.Date;

import org.springframework.web.client.RestTemplate;

import com.social.fitbit.api.client.impl.AbstractFitbitApiOperations;
import com.social.fitbit.util.TimeUtils;

public class SleepTemplate extends AbstractFitbitApiOperations implements SleepOperations {

	protected SleepTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	@Override
	public void getMinutesAsleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMinutesAwake() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAwakeningsCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTimeInBed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMinutesToFallAsleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMinutesAfterWakeup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getStartTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEfficiency() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SleepInfo getSleep(Date date) {
		return getSleep(TimeUtils.LOCAL_DATE_FORMATTER.format(date));
	}

	@Override
	public SleepInfo getSleep(String baseDate) {
		SleepInfo sleep = getEntity(String.format(Operations.SLEEP.getResourcePath(), baseDate), SleepInfo.class);
		return sleep;
	}
}
