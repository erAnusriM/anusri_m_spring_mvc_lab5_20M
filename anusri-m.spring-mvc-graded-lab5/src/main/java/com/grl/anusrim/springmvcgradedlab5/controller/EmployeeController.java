package com.grl.anusrim.springmvcgradedlab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.grl.anusrim.springmvcgradedlab5.entity.Employee;
import com.grl.anusrim.springmvcgradedlab5.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	public EmployeeService empService;
	
	@Autowired
	public EmployeeController (EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/")
	public String getAllEmployees(Model model) {
			List<Employee> empList = empService.fetchAll();
			model.addAttribute("employees", empList);
			return "employee/empList";
	}
	
	@GetMapping("/new")
	public String showEmployeeForm(Model model) {
			Employee emp = new Employee();
			model.addAttribute("employee", emp);
			return "employee/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		empService.save(emp);
		return "redirect:/employee/";
	}
	
//	@PostMapping("/edit")
//	public String updateForm(@RequestParam("empId") int id, Model model) {
//		Employee emp = empService.findById(id);
//		model.addAttribute("employee", emp);
//		return "employee/employee-update";
//	}
	
	@GetMapping
	@RequestMapping(value = "edit/{id}")
	public String updateForm(@PathVariable("id") long id, Model model) {
		Employee emp = empService.findById(id);
		model.addAttribute("employee", emp);
		return "employee/employee-update";
	}

	@GetMapping
	@RequestMapping(value = "delete/{id}")
	public String deleteemployee(@PathVariable("id") long id, Model model) {
		empService.deleteById(id);
		return "redirect:/employee/";
	}
	
	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("empId") int id, Model model) {
		empService.deleteById(id);
		return "redirect:/employee/";
	}

}
