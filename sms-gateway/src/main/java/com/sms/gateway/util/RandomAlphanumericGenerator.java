package com.sms.gateway.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomAlphanumericGenerator {

	// these are the characters used to form a alphanumeric trackingid
	private static char[] tackingCharSet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	public  String randomAlpha(int size) {
		Random random = new Random();
		char[] trackingCode = new char[size];
		for (int i = 0; i < size; i++) {
			trackingCode[i] = tackingCharSet[random.nextInt(tackingCharSet.length)];
		}
		return trackingCode.toString(); 
	}

}