package com.springboot.JPA.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.JPA.Entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	
	 User findByemail(String email);
	 
	 public List<User> findBycity(String city);
}
