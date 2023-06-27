package com.hftsolution.SpringMvcWithBeansFirst;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostImplementation implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {		
		System.out.println("bean is creating..."+beanName+" "+bean);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {	
		System.out.println("bean has created... "+beanName+" "+bean);
		return bean;
	}

}
