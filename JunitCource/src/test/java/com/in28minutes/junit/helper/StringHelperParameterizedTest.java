package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class StringHelperParameterizedTest {
	StringHelper helper = new StringHelper();
	
	private String input;
	private String expectedOutput;
	
	public StringHelperParameterizedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<String[]> testConditions(){
		String expectedoutputs[][] = { 
										{"AACD","CD"},
										{"ACD","CD"} 
									};
		
		return Arrays.asList(expectedoutputs);
		
	}

	@Test
	public void testTruncateAInFirst2Positions_() {
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}
	


}
