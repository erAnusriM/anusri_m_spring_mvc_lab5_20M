package com.grl.anusrim.springmvcgradedlab5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grl.anusrim.springmvcgradedlab5.dao.EmployeeRespository;
import com.grl.anusrim.springmvcgradedlab5.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRespository empRepository;

	@Override
	public List<Employee> fetchAll() {
		// TODO Auto-generated method stub
		List<Employee> empList = empRepository.findAll();
		return empList;
	}

	@Override
	public Employee findById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = empRepository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		throw new RuntimeException("Employee Not Found");
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		empRepository.save(employee);
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		empRepository.deleteById(id);
	}
	
	
	
}
