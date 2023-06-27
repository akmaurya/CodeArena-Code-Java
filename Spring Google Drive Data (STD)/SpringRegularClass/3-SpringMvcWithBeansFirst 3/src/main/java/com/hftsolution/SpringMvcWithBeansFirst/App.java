package com.hftsolution.SpringMvcWithBeansFirst;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext f= new ClassPathXmlApplicationContext("bean.xml");
        
//        ((ClassPathXmlApplicationContext)f).close();
        
        
        first first= (first) f.getBean("first");
        first.getData();
//        first first2= (first) f.getBean("first");
//        System.out.println(first.equals(first2));       
        
        
    }
}
