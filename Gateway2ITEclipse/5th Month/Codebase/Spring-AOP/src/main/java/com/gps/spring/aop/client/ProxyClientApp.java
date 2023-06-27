package com.gps.spring.aop.client;

import com.gps.spring.aop.pojo.proxies.RoleVOProxy;
import com.gps.spring.aop.service.FactoryService;

public class ProxyClientApp {
	public static void main(String[] args) {
		FactoryService factoryServce = new FactoryService();
		RoleVOProxy roleProxy = (RoleVOProxy) factoryServce.getBean("rolevo");
		roleProxy.getRoleId();
	}
}
