package com.nextcoach.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashUtils {

	private static final String NEXT_COACH = "nextCoach";

	private static MessageDigest MD5_ALGORITHM;

	static {
		try {
			MD5_ALGORITHM = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// do nothing
		}
	}

	public static String hash(String str) {
		byte[] digest = MD5_ALGORITHM.digest((str + NEXT_COACH).getBytes());
		return Base64.getEncoder().encodeToString(digest);
	}

}
