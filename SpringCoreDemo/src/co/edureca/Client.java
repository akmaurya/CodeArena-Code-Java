package co.edureca;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee eRef = new Employee();
		eRef.setEid(101);
		eRef.setEname("Jhon Botson");
		eRef.setEaddress("Redwood Shores");
		
		System.out.println("Employee Details: "+eRef.toString());
		
		Resource resource  = new ClassPathResource("employeebean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		

//		ApplicationContext context = new ClassPathXmlApplicationContext("employeebean.xml");
		
//		Employee e1 = (Employee)context.getBean("emp1");
//		Employee e2 = context.getBean("emp2", Employee.class);
		
		Employee e1 = (Employee)factory.getBean("emp1");
		Employee e2 = (Employee)factory.getBean("emp2");
		Employee e3 = (Employee)factory.getBean("emp3");
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
	}

}
