package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessimplStubMockTest {

	@Test
	public void testRetrieveTodorelatedToSpring_usingAMock() {
		TodoService todoServiceMock= mock(TodoService.class);
		
		List<String> todos= Arrays.asList("Learn MVC Spring ","Learn Spring","Learn Dance");
		
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		
		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos =todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
		
		
	}
	
	@Test
	public void testRetrieveTodorelatedToSpring_withEmptyList() {
		TodoService todoServiceMock= mock(TodoService.class);
		
		List<String> todos= Arrays.asList();
		
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		
		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos =todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
		
		
	}
	
	/*- BDD-(Behavior-driven development) syntax writing, for code more readable*/
	@Test
	public void testRetrieveTodorelatedToSpring_usingBDD() {
		
		//Given//
		TodoService todoServiceMock= mock(TodoService.class);
		List<String> todos= Arrays.asList();
		/*-given is BDD kind of setup, its same as when but only syntak */
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//when
		List<String> filteredTodos =todobusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		
		//then
		assertThat(filteredTodos.size(), is(0));
		
		
	}


	

	@Test
	public void testDeleteTodoNotRelatedToSpring_withoutBDD() {
		

		TodoService todoServiceMock= mock(TodoService.class);
		
		List<String> todos= Arrays.asList("Learn MVC Spring ","Learn Spring","Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
	    todobusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
	
	    //to verify, is deleteTodo called with "Learn to Dance" as argument, no times metion then its for any time.
	    verify(todoServiceMock).deleteTodo("Learn to Dance");
	    
	    //to specify how many times() it called.
	    verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
	    
	    //to specify how many atlist() it called.
	    verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Dance");
	    
	    //verifying that a method is not called. use never().
	    verify(todoServiceMock,never()).deleteTodo("Learn Spring");
	    
	}
	
	@Test
	public void testDeleteTodoNotRelatedToSpring_usingBDD() {
		
		//Given//
		TodoService todoServiceMock= mock(TodoService.class);
		
		List<String> todos= Arrays.asList("Learn MVC Spring ","Learn Spring","Learn to Dance");
		/*-given is BDD kind of setup, its same as when but only syntak */
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		/*- when*/
	    todobusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		
		/*-Then*/
	    
	    //to verify, is deleteTodo called with "Learn to Dance" as argument, no times metion then its for any time.
	   // verify(todoServiceMock).deleteTodo("Learn to Dance");
	    then(todoServiceMock).should().deleteTodo("Learn to Dance");
	    
	    //to specify how many times() it called.
	   //verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
	    then(todoServiceMock).should(times(1)).deleteTodo("Learn to Dance");
	    
	    //to specify how many atlist() it called.
	    //verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Dance");
	    then(todoServiceMock).should(atLeast(1)).deleteTodo("Learn to Dance");
	    
	    //verifying that a method is not called. use never().
	    //verify(todoServiceMock,never()).deleteTodo("Learn Spring");
	    then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
	    
	}
	
	
	@Test
	public void testDeleteTodoNotRelatedToSpring_usingBDD_argumentCapture() {
		
		//Declare an Argument captor
		ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
		
		
		//Given//
		TodoService todoServiceMock= mock(TodoService.class);
		
		List<String> todos= Arrays.asList("Learn MVC Spring ","Learn Spring","Learn to Dance");
		/*-given is BDD kind of setup, its same as when but only syntak */
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		/*- when*/
	    todobusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		
		/*-Then*/
	    
	    then(todoServiceMock).should().deleteTodo(stringArgCaptor.capture());
	    
	    assertThat(stringArgCaptor.getValue(), is("Learn to Dance"));

	}
	
	@Test
	public void testDeleteTodoNotRelatedToSpring_usingBDD_argumentCapture_multipleTimes() {
		
		//Declare an Argument captor
		ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
		
		
		//Given//
		TodoService todoServiceMock= mock(TodoService.class);
		
		List<String> todos= Arrays.asList("Learn XYZ ","Learn Spring","Learn to Dance");
		/*-given is BDD kind of setup, its same as when but only syntak */
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todobusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		/*- when*/
	    todobusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		
		/*-Then*/
	    
	    then(todoServiceMock).should(atLeast(1)).deleteTodo(stringArgCaptor.capture());
	    
	    assertThat(stringArgCaptor.getAllValues().size(), is(2));

	}

}
