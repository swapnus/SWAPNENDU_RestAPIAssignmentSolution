package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.User;

//required employee services
public interface EmployeeService {

	public Employee findById(int id);

	public List<Employee> findAll();

	public void save(Employee theEmployee);

	public void deleteById(int id);

	public List<Employee> searchByFirstName(String firstName);

	public List<Employee> sortByFirstName(String order);

	public User saveUser(User user);

	public Role saveRole(Role role);

}