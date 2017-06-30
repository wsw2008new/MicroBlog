package com.microblog.config;

import com.microblog.filters.StatelessAuthenticationFilter;
import com.microblog.filters.StatelessLoginFilter;
import com.microblog.security.TokenAuthenticationService;
import com.microblog.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private UserService userService;

	private TokenAuthenticationService tokenAuthenticationService;

	public SecurityConfig(UserService userService, TokenAuthenticationService tokenAuthenticationService) {
		super(true);
		this.userService = userService;
		this.tokenAuthenticationService = tokenAuthenticationService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.exceptionHandling()
			.and().anonymous()
			.and().servletApi()
			.and().headers().cacheControl();

		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/posts/**").permitAll()
			.antMatchers(HttpMethod.POST, "/api/posts/**").hasRole("USER")
			.antMatchers(HttpMethod.GET, "/api/users").hasRole("USER");

		http.addFilterBefore(
			new StatelessLoginFilter("/api/login", tokenAuthenticationService, userService, authenticationManager()),
			UsernamePasswordAuthenticationFilter.class);

		http.addFilterBefore(
			new StatelessAuthenticationFilter(tokenAuthenticationService),
			UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userService;
	}
}
