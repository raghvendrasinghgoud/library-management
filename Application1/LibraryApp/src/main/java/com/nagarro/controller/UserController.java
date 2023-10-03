package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.utility.AppContext;
import com.nagarro.utility.RestCommunication;

@Controller
public class UserController {
	
	@RequestMapping("/")
	public String goHome() {
		
		System.out.println("inside home controller");
		return "index";
	}
	
	@RequestMapping("index")
	public String goIndex() {
		
		System.out.println("inside home controller");
		return "index";
	}
	
	@RequestMapping("loginpath")
	public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		HttpSession ss=request.getSession();
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		
		System.out.println("inside login");
		if(username.length()<=5) {
			mv.setViewName("index");
			mv.addObject("error","username length should be > 5");
			return mv;
		}else {
			if(password.length()<5) {
			mv.setViewName("index");
			mv.addObject("error","password length should be >= 5");
			return mv;
			}else {
				
				String req="/user/"+username+"/"+password;
				ApplicationContext ac=AppContext.getContext();		
				RestCommunication rc=ac.getBean("restCommunication", RestCommunication.class);
				String res=rc.sendGetRequest(req);
				
				if(res.equals("loggedin")) {
					
					ss.setAttribute("user",username);
					
					mv.setViewName("books");
				}else {
					mv.setViewName("index");
					mv.addObject("error",res);
				}
				
				return mv;
			}
		}
	}
	
	@RequestMapping("/logoutpath")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();

		
		String name[]=session.getValueNames();
		for(String s:name) {
			session.removeAttribute(s);
		}
        session.invalidate();
        
        System.out.println("you got logout");
        return "index";
	}
}
