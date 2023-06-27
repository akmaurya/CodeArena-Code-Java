package com.gps.spring.ioc.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.gps.spring.ioc.pojo.SimpleBean;

public class SimpleBeanFactory implements ApplicationContextAware {

	private ApplicationContext applicationContext = null;
	private int count = 0;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("Injecting ApplicationContext");
		this.applicationContext = applicationContext;
	}

	public SimpleBean getSimpleBean() {
		SimpleBean simpleBean = (SimpleBean) applicationContext.getBean("template");
		simpleBean.setSimpleProp("SimpleBean Count:" + ++count);
		return simpleBean;
	}
}