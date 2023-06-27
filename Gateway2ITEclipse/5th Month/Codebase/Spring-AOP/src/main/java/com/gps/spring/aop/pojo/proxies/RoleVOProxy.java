package com.gps.spring.aop.pojo.proxies;

import com.gps.spring.aop.aspect.ProxyAdvice;
import com.gps.spring.aop.pojo.RoleVO;

public class RoleVOProxy extends RoleVO {
	@Override
	public int getRoleId() {
		System.out.println("Getter called for RoleId from Proxy - Before");
		System.out.println("Supper class called from Proxy..." + super.getRoleId());
		new ProxyAdvice().loggingAdvice();
		System.out.println("Getter called for RoleId from Proxy - After");
		return 1;
	}
}
