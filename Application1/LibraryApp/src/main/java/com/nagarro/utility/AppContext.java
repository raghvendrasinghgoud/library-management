package com.nagarro.utility;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext {

	public static ApplicationContext getContext() {
		return new ClassPathXmlApplicationContext("spring.xml");
			}

}
