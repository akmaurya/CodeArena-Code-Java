package com.gps.spring.aop.pojo;

import com.gps.spring.aop.aspect.Loggable;

public class RoleVO {
	int roleId;
	String roleName;

	@Loggable
	public int getRoleId() {
		System.out.println("Getter called for RoleId");
		return roleId;
	}

	public void setRoleId(int roleId) {
		System.out.println("Setting Role Id[" + roleId + "]");
		this.roleId = roleId;
	}

	public String getRoleName() {
		System.out.println("Getter called for Rolename");
		return roleName;
	}

	public void setRoleName(String roleName) {
		System.out.println("Setting Role Name[" + roleName + "]");
		this.roleName = roleName;

		if (roleName.equalsIgnoreCase("JobSeeker")) {
			throw new RuntimeException("Role Exception occured...");
		}
	}
}
