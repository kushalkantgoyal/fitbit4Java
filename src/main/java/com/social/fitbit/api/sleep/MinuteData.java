package com.social.fitbit.api.sleep;

import java.util.Date;

/**
 * @author Kushalkant
 * 
 */

public class MinuteData {

    private Date time;
    private double value;

    public MinuteData() {}
    
	public MinuteData(Date time, double value) {
        this.time = time;
        this.value = value;
    }

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
