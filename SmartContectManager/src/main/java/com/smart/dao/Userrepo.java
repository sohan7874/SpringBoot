package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.Entity.User;

public interface Userrepo extends JpaRepository<User,Integer> {
	boolean existsByEmail(String email);
	boolean existsByName(String name);
	
	@Query("Select u from User u where u.email=:email")
	public User getUserbyUsername(@Param("email") String email);
}
