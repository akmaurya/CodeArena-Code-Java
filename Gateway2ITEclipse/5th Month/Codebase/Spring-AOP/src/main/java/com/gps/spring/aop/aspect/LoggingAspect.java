package com.gps.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
public class LoggingAspect {

	// Apply this advice to public String getName() method called for any
	// classes
//	@Before("execution(public String getName())")
//	public void loggingAdvice() {
//		System.out.println("Advice run, Get Method called");
//	}

	// Apply this advice to public String getName() method called for
	// com.gps.spring.aop.pojo.Customer class
//	 @Before("execution(public String com.gps.spring.aop.pojo.Customer.getName())")
//	 public void loggingAdvice() {
//	 System.out.println("Advice run, Get Method called");
//	 }

	// Apply this advice to any of the get method of any classes
//	@Before("execution(public * get*())")
//	public void loggingAdvice() {
//		System.out.println("Advice run, Get Method called");
//	}

	// Apply an advice on any method start with “get” & weather have
	// arguments or not
	// @Before("execution(* get*(..))")
	// public void loggingAdvice() {
	// System.out.println("Advice run, Get Method called");
	// }

	// @Before("execution(public String getName())")
	// public void loggingAdvice() {
	// System.out.println("Advice run, Get Method called");
	// }
	//
	// @Before("execution(public String getName())")
	// public void secondAdvice() {
	// System.out.println("Second Advice run, Get Method called");
	// }

	// Define a point for any complex expression
	@Pointcut("execution(public String getName())")
	public void pointcutForGetName() {
	}
//
//	// Use defined pointcut reference instead to use complex expression
	@Before("pointcutForGetName()")
	@Order(1)
	public void loggingAdvice() {
		System.out.println("Advice run, Get Method called");
	}
//
//	// Use defined pointcut reference instead to use complex expression
	@Before("pointcutForGetName()")
	@Order(0)
	public void secondAdvice() {
		System.out.println("Second Advice run, Get Method called");
	}
}
