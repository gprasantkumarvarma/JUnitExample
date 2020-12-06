package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickBeforeAfterTest {
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before Class");
	}
	
	@Before
	public void setup(){
		System.out.println("before");
	}

	@Test
	public void test1() {
		System.out.println("test1 excuted");
	}
	
	@Test
	public void test2() {
		System.out.println("test2 excuted");
	}
	
	@After
	public void teardown(){
		System.out.println("After");
		
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("after Class");
	}

	
}
