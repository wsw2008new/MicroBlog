package com.microblog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microblog.domain.Role;
import com.microblog.domain.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public final class UserDTO {
	private static final String ROLE_USER = "ROLE_USER";

	private final String userName;
	@Size(min = 8, max = 100)
	private final String password;
	private final String firstName;

	public UserDTO(@JsonProperty("username") String userName,
	               @JsonProperty("password") String password,
	               @JsonProperty("firstName") String firstName) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
	}

	public Optional<String> getUserName() {
		return Optional.ofNullable(userName);
	}

	public Optional<String> getEncodedPassword() {
		return Optional.ofNullable(password).map(p -> new BCryptPasswordEncoder().encode(p));
	}

	public Optional<String> getFirstName() {
		return Optional.ofNullable(firstName);
	}

	public User toUser() {
		User user = new User();
		user.setUserName(userName);
		user.setRole(new Role());
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		user.setFirstName(firstName);
		return user;
	}

	public UsernamePasswordAuthenticationToken toAuthenticationToken() {
		return new UsernamePasswordAuthenticationToken(userName, password, getAuthorities());
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(() -> ROLE_USER);
	}
}
