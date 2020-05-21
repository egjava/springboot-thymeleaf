package com.eliz.thymeleaf.service;

import java.util.List;

import com.eliz.thymeleaf.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
		
	//GetEmployee by ID
		public Employee findById(int theId);
		
		//save Employee
		public void save(Employee employee);
		
		//Delete Employee by ID
		public void deleteById(int theId);
		
}
