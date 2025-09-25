package com.satishlabs.emp.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.satishlabs.emp.model.Employee;

public interface EmployeeService {
	Page<Employee> getAllEmployees(Pageable pageable, String department);
	Optional<Employee> getEmployeeById(Long id);
}
