package com.nagarro.controller;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.utility.AppContext;
import com.nagarro.utility.RestCommunication;

@Controller
public class BookController {

	@RequestMapping("addbook")
	public ModelAndView getBooks(HttpServletRequest request,HttpServletResponse response) {
		RestCommunication rc=AppContext.getContext().getBean("restCommunication",RestCommunication.class);
		ModelAndView mv=new ModelAndView();
		try {
		int code=Integer.parseInt(request.getParameter("bcode"));
		
		//check if book alredy exists
			if(rc.sendGetRequest("/bookexist/"+code).equals("true")) {
				mv.setViewName("add_book");
				mv.addObject("error",code+" already registered");
				return mv;
			}
			
			
		try {
		String name=request.getParameter("bname");
		int authorId=Integer.parseInt(request.getParameter("author"));
		String author=rc.sendGetRequest("/author/"+authorId);
		String authorName=null;
		try {
			Object o=new JSONParser().parse(author);
			JSONObject ao=(JSONObject)o;
			authorName=(String)ao.get("name");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String adon=LocalDate.now().toString();
		
		System.out.println(String.format("code=%s name=%s author=%s date=%s",code,name,author,adon));
		
		JSONObject jo=new JSONObject();
		jo.put("code",code);
		jo.put("name",name);
			Map au=new LinkedHashMap<>(2);
				au.put("aid", authorId);
				au.put("name", authorName);
		jo.put("author",au);
		jo.put("addedOn",adon);
				
		System.out.println("book"+jo);
		rc.sendPostRequest("/book", jo);
						
		mv.setViewName("books");
		}catch(Exception e) {
			
		}
		}catch(NullPointerException e) {
			mv.setViewName("add_book");
			mv.addObject("error"," all fields mandatory");
		}
		return mv;	
	}
	
	@RequestMapping("editbookpath")
	public ModelAndView editBook(HttpServletRequest request,HttpServletResponse response) {
		RestCommunication rc=AppContext.getContext().getBean("restCommunication",RestCommunication.class);
		ModelAndView mv=new ModelAndView();
		String code=request.getParameter("bcode");
		mv.setViewName("edit_book");
		JSONObject jo;
		try {
			jo = (JSONObject)new JSONParser().parse(rc.sendGetRequest("/book/"+code));
			mv.addObject("bookobj",jo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("editbook")
	public ModelAndView updateBook(HttpServletRequest request,HttpServletResponse response) {
		
		RestCommunication rc=AppContext.getContext().getBean("restCommunication",RestCommunication.class);
		ModelAndView mv=new ModelAndView();
		try {
		int code=Integer.parseInt(request.getParameter("bcode"));
		String name=request.getParameter("bname");
		int authorId=Integer.parseInt(request.getParameter("author"));
		String adon=request.getParameter("adon");
		String author=rc.sendGetRequest("/author/"+authorId);
		String authorName=null;
		try {
			Object o=new JSONParser().parse(author);
			JSONObject ao=(JSONObject)o;
			authorName=(String)ao.get("name");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(String.format("code=%s name=%s author=%s date=%s",code,name,author,adon));
		
		JSONObject jo=new JSONObject();
		jo.put("code",code);
		jo.put("name",name);
			Map au=new LinkedHashMap<>(2);
				au.put("aid", authorId);
				au.put("name", authorName);
		jo.put("author",au);
		jo.put("addedOn",adon);
				
		System.out.println("book"+jo);
		rc.sendPutRequest("/book", jo);
				
				
		mv.setViewName("books");
		}catch(NullPointerException e) {
			mv.setViewName("edit_book");
			mv.addObject("error"," all fields mandatory");
		}
		return mv;	
		
	}
	
	@RequestMapping("deletebook")
	public String deleteBook(HttpServletRequest request) {
		    
		    HttpSession ss=request.getSession();
			String user=(String)ss.getAttribute("user");
			if(user==null){
				return "index";
			}
		   
		
		RestCommunication rc=AppContext.getContext().getBean("restCommunication",RestCommunication.class);
		String code=request.getParameter("bcode");
		rc.sendDeleteRequest("/book/"+code);
		return "books";
	}
	
	@RequestMapping("addbookpath")
	public String addBook() {
		return "add_book";
	}
	
	@RequestMapping("bookspath")
	public String goToBooks() {
		return "books";
	}
}
