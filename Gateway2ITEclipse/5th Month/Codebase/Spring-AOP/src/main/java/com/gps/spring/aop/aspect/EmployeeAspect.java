package com.gps.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {

	// Pointcut expression
	// It will execute for any Spring Bean method with signature public String
	// getName(). This is a very important point to remember, if we will create
	// Employee bean using new operator the advices will not be applied. Only
	// when we will use ApplicationContext to get the bean, advices will be
	// applied.
	@Before("execution(public String getName())")
	public void getNameAdvice() {
		System.out.println("Executing Advice on getName()");
	}

	// Pointcut expression
	// We can use asterisk (*) as wild card in Pointcut expressions,
	// getAllAdvice() will be applied for all the classes in
	// com.gps.spring.aop.service package whose name starts with get and
	// doesn’t take any arguments.
	@Before("execution(* com.gps.spring.aop.service.*.get*())")
	public void getAllAdvice() {
		System.out.println("Service method getter called");
	}
}
