package com.in28minutes.data.api;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> score = Arrays.asList(99,100,101,105);
		
		//score has 4 iteams
		assertThat(score, hasSize(4));
		
		assertThat(score, hasItems(99,100));
		
		//every iteam :>90
		assertThat(score, everyItem(greaterThan(90)));
		
		assertThat(score, everyItem(lessThan(190)));
		
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		
		//Arrays
		Integer [] marks = {1,2,3};
		
		assertThat(marks, arrayWithSize(3));
		assertThat(marks, arrayContaining(1,2,3));
		assertThat(marks, arrayContainingInAnyOrder(2,1,3));
		
	}

}
