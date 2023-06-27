package com.gps.spring.aop.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gps.spring.aop.pojo.RoleVO;

public class RoleAopClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("RoleConfig.xml");
		RoleVO roleVO = ctx.getBean("rolevo", RoleVO.class);

		System.out.println(roleVO.getRoleId());
//		System.out.println(roleVO.getRoleName());
		
//		roleVO.setRoleId(2);
//		roleVO.setRoleName("JobSeeker");

		ctx.close();
	}
}
