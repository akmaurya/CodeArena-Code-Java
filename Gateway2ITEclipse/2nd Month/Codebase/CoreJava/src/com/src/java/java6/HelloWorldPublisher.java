package com.src.java.java6;

import javax.xml.ws.Endpoint;

//End point publisher
public class HelloWorldPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
	}
}
