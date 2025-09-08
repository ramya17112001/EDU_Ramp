package com.example.Employeecrud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employeecrud.entity.Employee;
import com.example.Employeecrud.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins="http://localhost:3000")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	
	}
	@PostMapping       
	public Employee create(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	@GetMapping
	public List<Employee>getAll(){
		return employeeService.getAllEmployees();
	}
@GetMapping("/{id}")
public Employee getEmployeeById(@PathVariable Long id) {
	return employeeService.getEmployeeById(id);
	
}

@PutMapping("/{id}")
public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
	return employeeService.updateEmployee(id, employee);
	
	
}
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
	employeeService.deleteEmployee(id);
}
}    
