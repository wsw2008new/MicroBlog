package com.microblog.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Document(collection = "roles")
public class Role {

	@Id
	private String id;

	@NotNull
	@Size(max = 50)
	private String roleName;

	@DBRef
	private List<User> userRoles;

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
