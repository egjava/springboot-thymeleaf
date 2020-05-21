package com.eliz.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eliz.thymeleaf.dao.EmployeeRepository;
import com.eliz.thymeleaf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeRepository employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo) {
		employeeRepo = theEmployeeRepo;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeRepo.findAllByOrderByLastNameAsc();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepo.findById(theId);
		
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
		}
		else {
			throw new RuntimeException("Did not find Employee ID:"+theId);
		}
		
		return employee ;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeRepo.save(employee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeRepo.deleteById(theId);
		
	}

}
