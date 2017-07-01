package com.microblog.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microblog.domain.User;
import com.microblog.security.TokenAuthenticationService;
import com.microblog.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatelessLoginFilter extends AbstractAuthenticationProcessingFilter {
	private final TokenAuthenticationService tokenAuthenticationService;
	private final UserService userService;

	public StatelessLoginFilter(String urlMapping, TokenAuthenticationService tokenAuthenticationService, UserService userService, AuthenticationManager authenticationManager) {
		super(urlMapping);
		this.tokenAuthenticationService = tokenAuthenticationService;
		this.userService = userService;
		setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		final User user = toUser(request);
		final UsernamePasswordAuthenticationToken loginToken = user.toAuthenticationToken();
		return getAuthenticationManager().authenticate(loginToken);
	}

	private User toUser(HttpServletRequest request) throws IOException {
		return new ObjectMapper().readValue(request.getInputStream(), User.class);
	}
}
