package com.example.Employeecrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Employeecrud.entity.Employee;
@Service 
public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee>getAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Long id, Employee employee);
	void deleteEmployee(Long id);
     
}
