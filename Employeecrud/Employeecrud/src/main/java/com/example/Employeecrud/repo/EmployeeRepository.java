package com.example.Employeecrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employeecrud.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
     
}
