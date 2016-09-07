package com.social.fitbit.util;

import java.text.SimpleDateFormat;

/**
 * @author Kushalkant
 * 
 */

public class TimeUtils {
	public static final String LOCAL_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
    public static final String TIME_UPDATED_PATTERN = DATE_TIME_PATTERN;
    public static final String LOCAL_TIME_HOURS_MINUTES_PATTERN = "HH:mm";
    public static final String LOCAL_TIME_HOURS_MINUTES_SECONDS_PATTERN = "HH:mm:ss";
    
    public static final SimpleDateFormat LOCAL_DATE_FORMATTER = new SimpleDateFormat(LOCAL_DATE_PATTERN);
    public static final SimpleDateFormat LOCAL_TIME_HOURS_MINUTES_FORMATTER = new SimpleDateFormat(LOCAL_TIME_HOURS_MINUTES_PATTERN);
}
