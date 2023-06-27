package com.gps.jaxws;

import javax.jws.WebService;

//Service Implementation Bean

@WebService(endpointInterface = "com.gps.jaxws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello : " + name + " Welcome to first JAX-WS service";
	}
}