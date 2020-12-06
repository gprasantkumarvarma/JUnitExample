package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class StringHelperParameterizedBoolenTest {
	
	StringHelper helper = new StringHelper();
	
	
	public static Collection<E> testCondition(){
		
		String a [][]={
				{"ABCD", true}
				
		};
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
