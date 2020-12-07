package com.in28minutes.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;

public class TodoBusinessimplStubTest {

	@Test
	public void testRetrieveTodorelatedToSpring_usingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos =todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
		
		
	}
	
	@Test
	public void testRetrieveTodorelatedToSpring_usingAStub2() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos =todobusinessImpl.retrieveTodosRelatedToSpring("Dummy1");
		assertEquals(1, filteredTodos.size());
	}

}
