package com.gps.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * Around advice are always required to have ProceedingJoinPoint as argument and
 * we should use it’s proceed() method to invoke the target object advised
 * method. If advised method is returning something, it’s advice responsibility
 * to return it to the caller program. For void methods, advice method can
 * return null. Since around advice cut around the advised method, we can
 * control the input and output of the method as well as it’s execution
 * behavior.
 * 
 * @author GPS
 *
 */
public class EmployeeAroundAspect {
	@Around("execution(* com.gps.spring.aop.pojo.Employee.getName())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Before invoking getName() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking getName() method. Return value=" + value);
		return value;
	}
}
