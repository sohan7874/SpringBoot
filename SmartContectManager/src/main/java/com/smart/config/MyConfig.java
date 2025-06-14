package com.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig  extends WebSecurityConfigurerAdapter  {

	

	@Bean
	public UserDetailsService  getUserDetailsService() {
		
		return new CustomUserServiceDetailimpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		
	dap.setUserDetailsService(getUserDetailsService());
	dap.setPasswordEncoder(passwordencoder());
	
	return dap;
	
	}
	
	
	///Configure method

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/admin/***").hasAnyRole("Admin").antMatchers("/user/***").hasAnyRole("USER").antMatchers("/***").permitAll()
		.and().formLogin()
		.loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/user/user_deshboard")
		.and().csrf().disable();
		
	}
	
	
}
