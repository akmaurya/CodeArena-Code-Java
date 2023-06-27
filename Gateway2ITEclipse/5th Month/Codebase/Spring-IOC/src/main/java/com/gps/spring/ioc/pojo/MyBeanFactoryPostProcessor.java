package com.gps.spring.ioc.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * To override properties of bean definition
 * 
 * @author GPS
 *
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("My bean factory post processor get called...");
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("mylifeCycleBean");
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		propertyValues.add("valueX", "Value of X via Bean Factory Post Processor");
	}

}
