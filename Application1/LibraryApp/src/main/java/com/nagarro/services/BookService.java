package com.nagarro.services;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.nagarro.utility.AppContext;
import com.nagarro.utility.RestCommunication;


public class BookService {

	
	public JSONArray getBooksFromServer() {
		String req="/books";
		ApplicationContext ac=AppContext.getContext();		
		RestCommunication rc=ac.getBean("restCommunication", RestCommunication.class);
		String res=rc.sendGetRequest(req);
		Object obj;
		JSONArray ja=null;
		try {
			
			obj = new JSONParser().parse(res);
			ja=(JSONArray)obj;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ja;
	}
	
	
	public JSONArray getAuthorsFromServer() {
		String req="/authors";
		ApplicationContext ac=AppContext.getContext();		
		RestCommunication rc=ac.getBean("restCommunication", RestCommunication.class);
		String res=rc.sendGetRequest(req);
		Object obj;
		JSONArray ja=null;
		try {
			
			obj = new JSONParser().parse(res);
			ja=(JSONArray)obj;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ja;
	}
	public static void main(String[] args) {
		System.out.println(AppContext.getContext().getBean("bookService",BookService.class).getBooksFromServer());
	}
}
