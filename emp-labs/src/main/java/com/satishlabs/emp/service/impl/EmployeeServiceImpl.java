package com.satishlabs.emp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.satishlabs.emp.model.Employee;
import com.satishlabs.emp.repository.EmployeeRespository;
import com.satishlabs.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRespository empRespository;

	@Override
	public Page<Employee> getAllEmployees(Pageable pageable, String department) {
		if(department != null && !department.isEmpty()) {
			return empRespository.findAll(pageable)
					.map(emp ->emp.getDepartment().equalsIgnoreCase(department) ? emp : null)
					.map(emp ->emp);
		}
		return empRespository.findAll(pageable);
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return empRespository.findById(id);
	}

}
