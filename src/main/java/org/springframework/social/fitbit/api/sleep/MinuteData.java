package org.springframework.social.fitbit.api.sleep;

import com.fasterxml.jackson.annotation.JsonSetter;


/**
 * @author Kushalkant
 * 
 */

public class MinuteData {

    private String time;
    private double value;

    public MinuteData() {}
    
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getTime() {
		return time;
	}

	@JsonSetter("dateTime")
	public void setTime(String time) {
		this.time = time;
	}

}
