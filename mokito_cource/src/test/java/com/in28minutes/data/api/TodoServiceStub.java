package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		
		List<String> output=null;
		if(user.equalsIgnoreCase("Dummy")){
			output= Arrays.asList("Learn MVC Spring ","Learn Spring","Learn Dance");
		}
		else if(user.equalsIgnoreCase("Dummy1")){
			output= Arrays.asList("Learn Spring","Learn Dance");
		}
		
		return output;
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
