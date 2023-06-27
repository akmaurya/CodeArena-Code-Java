package com.src.java.java6;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.src.java.java6.HelloWorld", targetNamespace = "http://my.java6.com/")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}
}