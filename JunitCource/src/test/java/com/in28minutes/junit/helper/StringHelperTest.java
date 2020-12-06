package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	StringHelper helper = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirstPositions() {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}

	@Test
	public void testTruncateAInFirst2Positions_AinMiddlePositions() {
		assertEquals("CAD", helper.truncateAInFirst2Positions("CAAD"));
	}
	
	//ABCD =>false, ABAB => true, AB= true, A= false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicnegativeScenario(){
		
		assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame(){
		
		assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
}
