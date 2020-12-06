package com.java.interview;

public class BasicJavaInterview {
	
	public static void test(Object t){
		System.out.println("Object arg");
	}
	
public static void test(String t){
		
	System.out.println("String arg");
	}

public static void test(StringBuffer t){
	
	System.out.println("StringBuffer arg");
	}

public static void main(String[] args) {
	test("prasant");
}

}
