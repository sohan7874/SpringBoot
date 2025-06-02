package com.springboot.validation.entity;

import jakarta.validation.constraints.NotNull;


public class Entity {

	//@NotBlank(message = "Username can not be null")
	//@Size(min = 3,max = 12,message = "name must been between 3 to 12 characters")
	
	@NotNull
	private String Username;
	
	//@NotBlank(message = "Username can not be null")

	private String Email;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Entity [Username=" + Username + ", Email=" + Email + "]";
	}
	
}
