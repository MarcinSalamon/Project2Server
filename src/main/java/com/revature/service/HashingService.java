package com.revature.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

/*
 * Here is our service for Hashing
 */
@Service
public class HashingService {
	
	/**
	 * takes in a password and returns the hashed password
	 * 
	 * @param password to be hashed
	 * @return hashed password
	 */
	public String hashPassword(String password) {
		System.out.println("[LOG] - In ERSService.hashPassword()");
		try {
			// Use SHA-256 algorithm to generate a 256-bit (32-byte) hash
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return bytesToHex(digest.digest((password).getBytes("UTF-8")));
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			return null;
		}
	}

	/**
	 * takes in a byte array and returns it hashed
	 * 
	 * @param bytes array of bytes to be hashed
	 * @return hashed String
	 */
	public String bytesToHex(byte[] bytes) {
		System.out.println("[LOG] - In ERSService.bytesToHex()");
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
