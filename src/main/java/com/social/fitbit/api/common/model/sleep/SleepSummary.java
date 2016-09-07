package com.social.fitbit.api.common.model.sleep;


/**
 * @author Kushalkant
 * 
 */

public class SleepSummary {

    int totalSleepRecords;
    int totalMinutesAsleep;
    int totalTimeInBed;

    public SleepSummary(int totalSleepRecords, int totalMinutesAsleep, int totalTimeInBed) { 
        this.totalSleepRecords = totalSleepRecords;
        this.totalMinutesAsleep = totalMinutesAsleep;
        this.totalTimeInBed = totalTimeInBed;
    }

    public void addSleepLog(SleepLog sleepLog) {
        this.totalSleepRecords ++;
        this.totalMinutesAsleep = this.totalMinutesAsleep + sleepLog.getMinutesAsleep();
        this.totalTimeInBed = this.totalTimeInBed + sleepLog.getTimeInBed();
    }

    public int getTotalSleepRecords() {
        return totalSleepRecords;
    }

    public int getTotalMinutesAsleep() {
        return totalMinutesAsleep;
    }

    public int getTotalTimeInBed() {
        return totalTimeInBed;
    }
}
