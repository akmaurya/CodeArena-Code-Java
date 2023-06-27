package com.gps.jaxws;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;


public class HelloWorldClient {
	public static void main(String[] args) {
		String endpoint = "http://localhost:8080/jaxws/Hellows";

		// Make the call
		String str = "Amit Kumar";
		Service service = new Service();
		Call call = null;
		try {
			call = (Call) service.createCall();
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		try {
			call.setTargetEndpointAddress(new java.net.URL(endpoint));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		call.setOperationName(new javax.xml.namespace.QName(
				"http://jaxws.gps.com/", "getHelloWorldAsString"));
		call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);

		String res = null;
		try {
			res = (String) call.invoke(new Object[] { str });
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		System.out.println(res);
	}
}
