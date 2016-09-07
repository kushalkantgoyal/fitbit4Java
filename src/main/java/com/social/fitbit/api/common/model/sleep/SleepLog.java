package com.social.fitbit.api.common.model.sleep;

import java.util.List;

/**
 * @author Kushalkant
 * 
 */

public class SleepLog {
	
    long logId;
    int minutesToFallAsleep;
    int minutesAsleep;
    int minutesAwake;
    int minutesAfterWakeup;
    int awakeningsCount;
    int timeInBed;
    int efficiency;
    long duration;
    boolean isMainSleep;
    String startTime;
    String dateOfSleep;

    List<MinuteData> minuteData;

    public SleepLog(long logId, String startTime, boolean mainSleep, long duration, int minutesToFallAsleep,
                    int minutesAsleep, int minutesAwake, int minutesAfterWakeup, int awakeningsCount, int timeInBed,
                    int efficiency, String dateOfSleep, List<MinuteData> minuteData) {
        this.logId = logId;
        this.startTime = startTime;
        this.isMainSleep = mainSleep;
        this.duration = duration;
        this.minutesToFallAsleep = minutesToFallAsleep;
        this.minutesAsleep = minutesAsleep;
        this.minutesAwake = minutesAwake;
        this.minutesAfterWakeup = minutesAfterWakeup;
        this.awakeningsCount = awakeningsCount;
        this.timeInBed = timeInBed;
        this.efficiency = efficiency;
        this.dateOfSleep = dateOfSleep;
        this.minuteData = minuteData;
    }
    
    
/*    public SleepLog(JSONObject json, boolean addDateToIntradayTime) throws JSONException {
        logId = json.getLong("logId");
        startTime = json.getString("startTime");
        isMainSleep = json.getBoolean("isMainSleep");
        duration = json.getLong("duration");
        minutesToFallAsleep = json.getInt("minutesToFallAsleep");
        minutesAsleep = json.getInt("minutesAsleep");
        minutesAwake = json.getInt("minutesAwake");
        minutesAfterWakeup = json.getInt("minutesAfterWakeup");
        awakeningsCount = json.getInt("awakeningsCount");
        timeInBed = json.getInt("timeInBed");
        efficiency = json.getInt("efficiency");
        dateOfSleep = json.getString("dateOfSleep");
        if(addDateToIntradayTime){
        	minuteData = MinuteData.jsonArrayToMinuteDataList(json.getJSONArray("minuteData"), dateOfSleep);
        }else{
        	minuteData = MinuteData.jsonArrayToMinuteDataList(json.getJSONArray("minuteData"));
        }
    }

    public static List<SleepLog> jsonArrayToSleepLogList(JSONArray array) throws JSONException {
        return jsonArrayToSleepLogList(array, false);
    }
    
    public static List<SleepLog> jsonArrayToSleepLogList(JSONArray array, boolean addDateToIntradayTime) throws JSONException {
        List<SleepLog> sleepLogList = new ArrayList<SleepLog>(array.length());
        for (int i = 0; i < array.length(); i++) {
            JSONObject sleepLog = array.getJSONObject(i);
            sleepLogList.add(new SleepLog(sleepLog, addDateToIntradayTime));
        }
        return sleepLogList;
    }
*/    
    public long getLogId() {
        return logId;
    }

    public String getStartTime() {
        return startTime;
    }

    public boolean isMainSleep() {
        return isMainSleep;
    }

    public long getDuration() {
        return duration;
    }

    public int getMinutesToFallAsleep() {
        return minutesToFallAsleep;
    }

    public int getMinutesAsleep() {
        return minutesAsleep;
    }

    public int getMinutesAwake() {
        return minutesAwake;
    }

    public int getMinutesAfterWakeup() {
        return minutesAfterWakeup;
    }

    public int getAwakeningsCount() {
        return awakeningsCount;
    }

    public int getTimeInBed() {
        return timeInBed;
    }

    public int getEfficiency() {
        return efficiency;
    }

	public List<MinuteData> getMinuteData() {
		return minuteData;
	}

	public String getDateOfSleep() {
		return dateOfSleep;
	}
}
