package com.mainClass;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {

	
	
	public static void main(String[] args) {
		
		
//		BeanFactory factory =  new XmlBeanFactory(new ClassPathResource("Bean.xml"));	
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("Bean.xml");
		
		SecondClass s = (SecondClass) factory.getBean("first");		
		s.funcFirst();
	}
	
}
