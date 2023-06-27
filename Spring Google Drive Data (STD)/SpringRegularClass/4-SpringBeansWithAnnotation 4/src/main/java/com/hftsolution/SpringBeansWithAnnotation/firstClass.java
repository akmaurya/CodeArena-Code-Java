package com.hftsolution.SpringBeansWithAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class firstClass {

	@Autowired
	secondClass secondClass;
	@Autowired
	secondClass secondClassSecond;
	
	public void firstFunc() {
		System.out.println("firstClass");
		System.out.println(secondClass.equals(secondClassSecond));
		secondClass.secFunc();
	}
	
	
}
