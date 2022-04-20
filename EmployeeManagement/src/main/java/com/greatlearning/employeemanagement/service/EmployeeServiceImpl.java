package com.greatlearning.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.User;
import com.greatlearning.employeemanagement.repository.EmployeeRepository;
import com.greatlearning.employeemanagement.repository.RoleRepository;
import com.greatlearning.employeemanagement.repository.UserRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bcryptEncoder;

	@Override
	@Transactional
	// implimetation for findall
	public List<Employee> findAll() {
		List<Employee> employee = employeeRepository.findAll();
		return employee;
	}

	@Override
	@Transactional
	// to findbyId
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}

		return theEmployee;
	}

	// to add a new employee
	public void addEmployee(Employee theEmployee) {
		employeeRepository.save(theEmployee);
		employeeRepository.flush();
	}

	// to save a new employee
	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
		employeeRepository.flush();
		return;
	}

	// delete a employee by ID
	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

	// search an employee by firstname
	@Override
	public List<Employee> searchByFirstName(String firstName) {
		List<Employee> employee = employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
		return employee;
	}

	// sort an employee with firstname
	@Override
	public List<Employee> sortByFirstName(String order) {
		if (order.equals("desc"))
			return employeeRepository.findAllByOrderByFirstNameDesc();
		else
			return employeeRepository.findAllByOrderByFirstNameAsc();
	}

	// to save a user
	@Override
	public User saveUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);

	}

	// to save a role
	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);

	}

}