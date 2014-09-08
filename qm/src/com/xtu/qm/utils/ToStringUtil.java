package com.xtu.qm.utils;

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
}
