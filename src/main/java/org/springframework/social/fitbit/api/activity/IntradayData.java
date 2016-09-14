package org.springframework.social.fitbit.api.activity;


/**
 * @author Kushalkant
 * 
 */

public class IntradayData {

    private String time;
    private double value;
    private Integer level;
    private Integer mets;
    
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getMets() {
		return mets;
	}
	public void setMets(Integer mets) {
		this.mets = mets;
	}
}
