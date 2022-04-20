package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.employeemanagement.entity.User;

//user repository extends jpa repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.username= ?1")
	public User getUserByUsername(String username); // class variable

}