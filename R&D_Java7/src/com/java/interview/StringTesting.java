package com.java.interview;

public class StringTesting {
	public static void main(String[] args) {
		String OPT_ACCOUNT_SELECT= "\u202D0055130001298001\u202C";
		System.out.println(OPT_ACCOUNT_SELECT);
		System.out.println(OPT_ACCOUNT_SELECT.replaceAll("['\u202D','\u202C','?']", ""));
	}

}
