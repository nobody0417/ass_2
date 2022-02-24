package com.employee.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee implements Comparable<Employee>{
	@Id
	int id;
	String f_name;
	String l_name;
	String location;
	
	@Override
	public int compareTo(Employee s) {
		
		return this.f_name.compareTo(s.f_name);
		
	}
}