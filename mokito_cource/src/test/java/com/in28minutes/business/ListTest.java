package com.in28minutes.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void mockListSizemethod() {

		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());

	}

	@Test
	public void mockListSize_ReturnmultipleValue() {

		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);

		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(4, listMock.size());

	}

	@Test
	public void mockListGetMethod() {

		List listMock = mock(List.class);
		// when(listMock.get(0)).thenReturn("i am java developer");
		// Argument matchers
		when(listMock.get(anyInt())).thenReturn("i am java developer");
		assertEquals("i am java developer", listMock.get(0));
		// assertEquals(null, listMock.get(1));
		assertEquals("i am java developer", listMock.get(1));

	}

	@Test(expected = RuntimeException.class)
	public void mockListGetmethod_exception() {

		List listMock = mock(List.class);

		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));

		listMock.get(0);

	}

}
