package org.springframework.social.fitbit.api.activity;

/**
 * @author Kushalkant
 * 
 */

public enum DetailLevel {
	ONE_MINUTE("1min"),
	FIFTEEN_MINUTES("15min");
	
	private String detailFormat;

	private DetailLevel(String detailFormat) {
		this.detailFormat = detailFormat;
	}
	
	public String getDetailFormat() {
		return detailFormat;
	}

	public void setDetailFormat(String detailFormat) {
		this.detailFormat = detailFormat;
	}
}
