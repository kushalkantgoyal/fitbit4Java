package org.springframework.social.fitbit.util;

import java.text.SimpleDateFormat;

/**
 * @author Kushalkant
 * 
 */

public class TimeUtils {
	public static final String LOCAL_DATE_PATTERN = "yyyy-MM-dd";
    public static final String LOCAL_DATE_TIME_LONG_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String LOCAL_TIME_HOURS_MINUTES_PATTERN = "HH:mm";
    public static final String LOCAL_TIME_HOURS_MINUTES_SECONDS_PATTERN = "HH:mm:ss";
    
    public static final SimpleDateFormat LOCAL_DATE_FORMATTER = new SimpleDateFormat(LOCAL_DATE_PATTERN);
    public static final SimpleDateFormat LOCAL_DATE_TIME_LONG_FORMATTER = new SimpleDateFormat(LOCAL_DATE_TIME_LONG_PATTERN);
    public static final SimpleDateFormat LOCAL_DATE_TIME_FORMATTER = new SimpleDateFormat(LOCAL_DATE_TIME_PATTERN);
    public static final SimpleDateFormat LOCAL_TIME_HOURS_MINUTES_FORMATTER = new SimpleDateFormat(LOCAL_TIME_HOURS_MINUTES_PATTERN);
}
