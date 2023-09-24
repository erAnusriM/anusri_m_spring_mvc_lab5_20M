package com.grl.anusrim.springmvcgradedlab5.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.grl.anusrim.springmvcgradedlab5.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {

}
