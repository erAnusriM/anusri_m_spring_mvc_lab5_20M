package com.grl.anusrim.springmvcgradedlab5.service;

import java.util.List;

import com.grl.anusrim.springmvcgradedlab5.entity.Employee;

public interface EmployeeService {

	public List<Employee> fetchAll();
	public Employee findById(long id);
	public void save(Employee employee);
	public void deleteById(long id);
	
}
