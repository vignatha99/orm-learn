package com.handson.ormlearn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.ormlearn.model.Employee;
import com.handson.ormlearn.repository.EmployeeRepository;
import com.handson.ormlearn.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee findEmployee(int id) {

		return employeeRepository.findById(id).get();
	}

	@Override
	public void saveEmployee(Employee employee) {

		employeeRepository.save(employee);
	}

	@Override
	public void removeEmployee(int id) {
		
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findAllPermanentEmployees() {
		
		return employeeRepository.getAllPermanentEmployees();
	}

	@Override
	public double findAverageSalaryofEmployees() {
		
		return employeeRepository.getAverageSalary();
	}

	@Override
	public double findAverageSalaryBasedOnDeptId(int id) {
		
		return employeeRepository.getAverageSalaryBasedOnDeptId(id);
	}

	@Override
	public List<Employee> getAllEmployeesUsingNativeQuery() {
		
		return employeeRepository.getAllEmployeesNative();
	}

}