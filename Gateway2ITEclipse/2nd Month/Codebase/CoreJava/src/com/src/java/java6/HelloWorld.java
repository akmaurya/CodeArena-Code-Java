package com.src.java.java6;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

//Service End point Interface
@WebService(name = "HelloWorld", targetNamespace = "http://my.java6.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorld {
	@WebMethod
	@WebResult(partName = "return")
	public String getHelloWorldAsString(@WebParam(name = "arg0", partName = "arg0") String arg0);
}
