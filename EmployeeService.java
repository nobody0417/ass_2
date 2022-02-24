package com.employee.demo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.model.Employee;
import com.employee.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = repo.findAll();
		Collections.sort(employees);
		return employees;
	}
	
	public Employee getEmployee(int id) {
		return repo.getById(id);
	}
	
	public boolean createEmployee(Employee s) {
		repo.save(s);
		return true;
	}
	
	public Employee updateEmployee(Employee s) {
		repo.save(s);
		return s;
	}
	
	public boolean deleteEmployee(int id) {
		repo.deleteById(id);
		return true;
	}
}