package com.mainClass;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {

	
	
	public static void main(String[] args) {
		
		
		BeanFactory factory =  new XmlBeanFactory(new ClassPathResource("Bean.xml"));
		
		SecondClass s = (SecondClass) factory.getBean("first");
		
		s.funcFirst();
		
	((ConfigurableBeanFactory) abc).destroySingletons();
	}
	
}
