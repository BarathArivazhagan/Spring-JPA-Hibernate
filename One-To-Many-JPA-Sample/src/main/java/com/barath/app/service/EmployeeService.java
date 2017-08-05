package com.barath.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barath.app.entity.Employee;
import com.barath.app.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository empRep;
	
	
	public Employee addEmployee(Employee employee){
		
		if(employee != null){
			employee=empRep.save(employee);
		}
		return employee;
		
	}
	
	public Employee readEmployee(long employeeId){	
				
		return empRep.findOne(employeeId);
	}


	public Employee updateEmployee(Employee employee){
		
		Employee updEmp=null;
		try{
			if(employee !=null){
				updEmp= readEmployee(employee.getEmployeeId());
				if(updEmp !=null){
					updEmp =empRep.save(updEmp);
				}
			}			
		}catch(Exception ex){
			
			logger.error(" Error in updating "+ex.getMessage());
			
		}
		
		return updEmp;
		
	}

	public void deleteEmployee(Employee employee){
		
		if(employee !=null){
			empRep.delete(employee);
		}
		
	}
	
	public void deleteEmployee(long employeeId) throws EmployeeNotFoundException{
		
		Employee employee=readEmployee(employeeId);
		
		if(employee !=null){
			deleteEmployee(employee);
		}else{
			throw  new EmployeeNotFoundException("Employee not found with " +employeeId);
		}
	}
	
	
	public List<Employee> findAllEmployees(){
		return empRep.findAll();
	}

	class EmployeeNotFoundException extends Exception{
		
		public EmployeeNotFoundException() {
			super();
		}
		
		  
		public EmployeeNotFoundException(String message){
			super(message);
		}
	}
	

}
