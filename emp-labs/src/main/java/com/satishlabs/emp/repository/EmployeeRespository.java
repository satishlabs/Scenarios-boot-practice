package com.satishlabs.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.emp.model.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long>{

}
