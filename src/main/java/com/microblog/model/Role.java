package com.microblog.model;

import java.util.List;

public class Role {

	// Default role
	private String roleName = "user";

	private List<User> userRoles;

	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<User> userRoles) {
		this.userRoles = userRoles;
	}
}
