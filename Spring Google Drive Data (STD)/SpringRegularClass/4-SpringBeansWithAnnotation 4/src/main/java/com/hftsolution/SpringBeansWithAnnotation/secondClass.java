package com.hftsolution.SpringBeansWithAnnotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@Scope("prototype")
public class secondClass {

	
	public void secFunc() {
		System.out.println("secondClass");
	}
}
