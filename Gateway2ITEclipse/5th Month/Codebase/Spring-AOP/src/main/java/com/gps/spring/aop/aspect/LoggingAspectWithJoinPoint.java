package com.gps.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.gps.spring.aop.pojo.Customer;

@Aspect
public class LoggingAspectWithJoinPoint {

	// Apply this advice to public String getName() method called for any
	// classes
	@Before("pointcutForCustomer())")
	public void loggingAdvice() {
		System.out.println("Advice run, Get Method called");
	}
	
	@Before("pointcutForCustomer())")
	public void loggingAdvice(JoinPoint joinPoint) {
		System.out.println("Method full description : " + joinPoint.toLongString());		
		System.out.println("Method short description : " + joinPoint.toShortString());
		System.out.println("Method arguments : " + joinPoint.getArgs());
		System.out.println("Method signature : " + joinPoint.getSignature());
		
		System.out.println("Target object reference : " + joinPoint.getTarget());
		Customer customer = (Customer) joinPoint.getTarget();
		System.out.println("Target object reference : " + customer);
	}

	@Pointcut("within(com.gps.spring.aop.pojo.Customer)")
	public void pointcutForCustomer() {
	}

	@Before("args(String)")
	public void stringArgumentMethods() {
		System.out.println("Method that takes String arguments has been called");
	}
	
	@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("Method that takes String arguments has been called [" + name + "]");
	}
	
}
