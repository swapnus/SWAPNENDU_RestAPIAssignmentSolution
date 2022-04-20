package com.greatlearning.employeemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.employeemanagement.service.UserDetailsServiceImpl;

//web secutiry config to assign user roles
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	// assigning permissions for users
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console/").permitAll().antMatchers("/ems/user", "/ems/role")
				.hasAuthority("ADMIN").antMatchers(HttpMethod.POST, "/ems/employees").hasAnyAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/ems/employee/*").hasAnyAuthority("ADMIN", "USER")
				.antMatchers(HttpMethod.PUT, "/ems/employees").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/ems/employees/*").hasAuthority("ADMIN").anyRequest().authenticated()
				.and().httpBasic().and().cors().and().csrf().disable();
		http.headers().frameOptions().disable();
	}

}