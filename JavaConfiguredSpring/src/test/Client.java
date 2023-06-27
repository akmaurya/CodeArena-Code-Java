package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.TestBean;
import resources.JavaConfig;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		TestBean testBean = (TestBean)context.getBean("testBean");
		testBean.printBean();
	}

}
