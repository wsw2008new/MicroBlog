package com.microblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Document(collection = "users")
public class User extends GenericModel implements UserDetails {

	@TextIndexed(weight = 2)
	private String firstName;

	@TextIndexed(weight = 3)
	private String lastName;

	@TextIndexed
	private String userName;

	private String password;

	private Role role;

	public User(String firstName, String lastName, String userName, String password, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	@JsonProperty("username")
	public String getUsername() {
		return userName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();

		Role role = this.getRole();
		if (role != null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
			authorities.add(authority);
		}
		return authorities;
	}

	public UsernamePasswordAuthenticationToken toAuthenticationToken() {
		return new UsernamePasswordAuthenticationToken(userName, password, getAuthorities());
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
}
