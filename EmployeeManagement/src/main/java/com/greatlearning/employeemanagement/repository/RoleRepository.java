package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeemanagement.entity.Role;

//role repository extends jparepository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}