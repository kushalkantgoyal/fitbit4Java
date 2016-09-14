package org.springframework.social.fitbit.api.sleep;

import java.util.List;

/**
 * @author Kushalkant
 * 
 */

public class Sleep {

    private SleepSummary summary;

    private List<SleepLog> sleep;

    public Sleep() {}
    
    public Sleep(SleepSummary summary, List<SleepLog> sleep) {
        this.summary = summary;
        this.sleep = sleep;
    }

    public SleepSummary getSummary() {
        return summary;
    }

    public void setSummary(SleepSummary summary) {
        this.summary = summary;
    }

	public List<SleepLog> getSleep() {
		return sleep;
	}

	public void setSleep(List<SleepLog> sleep) {
		this.sleep = sleep;
	}

}
