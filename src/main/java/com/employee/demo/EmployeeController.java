package com.employee.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.*;
//import org.springframework.beans.factory.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.demo.model.Employee;
import com.employee.demo.service.EmployeeService;

@SuppressWarnings("unused")
@RestController("/employee")
//@RequestMapping('/')


public class EmployeeController {
	
	@RequestMapping("/employee")
	@ResponseBody
	public String welcome() {
	    return "tomcat server started.";
	}
	
	@Autowired
	EmployeeService service;
	
	
	
	@GetMapping("/getAll")
	public List<Employee> getAllStduent(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/get/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return service.getEmployee(id);
	}
	
	@PostMapping("/add")
	
	public String createEmployee(@RequestBody Employee s) {
		
		if(service.createEmployee(s)) {
			return "Created Successfully";
		}
		return "Error in Creating";
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee s) {
		return service.updateEmployee(s);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		if(service.deleteEmployee(id)) {
			return "deleted Successfully";
		}
		return "Error in deleting";
	}
	
}
