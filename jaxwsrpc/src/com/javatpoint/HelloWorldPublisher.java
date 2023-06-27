package com.javatpoint;
import javax.xml.ws.Endpoint;
//Endpoint publisher
public class HelloWorldPublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://192.168.173.1:7779/ws/hello", new HelloWorldImpl());
    }
 
}