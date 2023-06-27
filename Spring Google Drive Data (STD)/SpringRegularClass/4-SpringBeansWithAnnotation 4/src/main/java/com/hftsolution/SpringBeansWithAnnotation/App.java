package com.hftsolution.SpringBeansWithAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext abc = new ClassPathXmlApplicationContext("config.xml");
      firstClass f =(firstClass) abc.getBean("first");
       f.firstFunc();
       
       
    }
}
