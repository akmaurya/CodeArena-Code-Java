package com.gps.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingRoleAspect {

//	@After("execution(* set*(..))")
//	public void loggingAdvice() {
//		System.out.println("Advice run, after setter get called...");
//	}

	// @AfterReturning("execution(* set*(..))")
	// public void loggingAdvice() {
	// System.out.println("Advice run, after setter get called...");
	// }

	// @AfterThrowing(pointcut = "execution(* set*(..))", throwing = "ex")
	// public void loggingAdvice(JoinPoint joinPoint, Throwable ex) {
	// System.out.println("Okay - we're in the handler...");
	//
	// Signature signature = joinPoint.getSignature();
	// String methodName = signature.getName();
	// String stuff = signature.toString();
	// String arguments = Arrays.toString(joinPoint.getArgs());
	// System.out.println("Write something in the log... We have caught exception in method: "
	// + methodName
	// + " with arguments " + arguments + "\nand the full toString: " + stuff +
	// "\nthe exception is: "
	// + ex.getMessage());
	// }

	// Must have ProceedingJoinPoint as a parameter
	// Before proceed() method we can code for before & after this we can code
	// for after
	// @Around("execution(* getRoleName(..))")
	// public Object loggingAdvice(ProceedingJoinPoint proceedingJoinPoint)
	// throws Throwable {
	// Object returnValue = null;
	// System.out.println("Before run, after getter get called...");
	// returnValue = proceedingJoinPoint.proceed();
	// System.out.println("Advice run, after getter get called... [" +
	// returnValue + "]");
	// return returnValue;
	// }

	@After("@annotation(com.gps.spring.aop.aspect.Loggable)")
	public void loggingAdvice() {
		System.out.println("Advice run, via Loggable annotation after setter get called...");
	}
}
