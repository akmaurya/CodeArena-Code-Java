package com.spring.annotaion.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	
	public static void main(String[] args) {
		
		AbstractApplicationContext abc = new AnnotationConfigApplicationContext(config.class);
//		First First = (First) abc.getBean("first");
//		First.firstFunc();
		
		
		
		abc.close();
	}
	
}
