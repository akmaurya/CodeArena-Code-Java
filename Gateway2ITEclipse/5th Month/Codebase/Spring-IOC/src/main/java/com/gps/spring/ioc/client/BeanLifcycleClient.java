package com.gps.spring.ioc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.ioc.pojo.LifeCycleBean;

public class BeanLifcycleClient {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-lifecycle-context.xml");

		LifeCycleBean lifeCycleBean = (LifeCycleBean) context.getBean("mylifeCycleBean");
		System.out.println(lifeCycleBean);
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}
