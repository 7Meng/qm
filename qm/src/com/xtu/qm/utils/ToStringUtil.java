package com.xtu.qm.utils;

import java.util.Calendar;
import java.util.Date;

public final class ToStringUtil {
	private ToStringUtil () {}
	
	public static String byteArrayToHexString(byte[] bytes) {
		StringBuffer strBuf = new StringBuffer(bytes.length);
		
		for (byte b: bytes) {
			int v = b & 0xff;
			strBuf.append(Integer.toHexString(v));
		}
		
		return strBuf.toString().toUpperCase();
	}
	
	public static String dateToString(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
    	String hour = "" + cal.get(Calendar.HOUR_OF_DAY);
    	String minute;
        if (cal.get(Calendar.MINUTE) > 10) {
        	minute = "" + cal.get(Calendar.MINUTE);
        } else {
        	minute = "0" + cal.get(Calendar.MINUTE);
        }
        
        return hour + ":" + minute;
	}
}
