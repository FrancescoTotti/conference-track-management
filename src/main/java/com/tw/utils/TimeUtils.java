package com.tw.utils;

import com.tw.exception.CommonException;

public class TimeUtils {

	public TimeUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getTimeStr(long minutes) throws CommonException {
		
		if (minutes > 17 * 60 || minutes < 9 * 60) {
//			System.out.println("times exceed the limit");
			throw new CommonException("times exceed the limit");
		}
		String hour = String.format("%02d", ((minutes)/60 -1) % 12 + 1);
		String minute = String.format("%02d", minutes % 60);
		String amOrPm = minutes < 720 ? "AM" : "PM";
		
		return hour + ":" + minute + amOrPm;
	}

}
