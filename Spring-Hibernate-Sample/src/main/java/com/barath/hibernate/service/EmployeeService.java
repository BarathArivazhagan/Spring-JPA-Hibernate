package com.barath.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.barath.hibernate.model.Employee;
import com.barath.hibernate.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRep;
	
	public Employee addEmployee(Employee emp){
		return empRep.addEmployee(emp);
	}
	
	public Employee getEmployee(long employeeId ){
		return empRep.getEmployee(employeeId);
	}
	
	public Employee loadEmployee(long employeeId ){
		return empRep.loadEmployee(employeeId);
	}
	
	
	public void updateEmployee(Employee emp){
		empRep.updateEmployee(emp);
	}
	
	
	public void deleteEmployee(long employeeId){
		empRep.deleteEmployee(employeeId);
	}
	
	public Employee findEmployeeByEmployeeName(String employeeName){
		return empRep.findEmployeeByEmployeeName(employeeName);
	}

	public List<Employee> findEmployeesBelowAge(int employeeAge){
		return empRep.findEmployeesBelowAge(employeeAge);
	}
	
	public Employee findEmployeeByEmployeeNameUsingQuery(String employeeName){
		return empRep.findEmployeeByEmployeeNameUsingQuery(employeeName);
	}

	public List<Employee> findAllEmployees() {		
		return empRep.findAllEmployees();
	}

	public List<String> findAllEmployeeNames() {		
		return empRep.findAllEmployeeNames();
	}


}
