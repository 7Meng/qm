package com.xtu.qm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MessageDigestWapper {
	private static MessageDigest md = null;
	
	static {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private MessageDigestWapper() {}
	
	public static String toMd5HexString (byte[] bytes) {
		md.update(bytes);
		return ToStringUtil.byteArrayToHexString(md.digest());
	}
}
