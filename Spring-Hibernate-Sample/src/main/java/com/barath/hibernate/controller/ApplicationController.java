package com.barath.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.hibernate.model.Employee;
import com.barath.hibernate.service.EmployeeService;

@RestController
public class ApplicationController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String home(){
		return "welcome to hibernate application";
	}
	
	@PostMapping("/emp/add")
	public Employee addEmployee(@RequestBody Employee employee) throws Exception{
		if(employee ==null){
			throw new Exception("employee obj is null ");
		}
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/emp/read")
	public Employee readEmployee(@RequestParam Long employeeId) throws Exception{
		if(employeeId ==null){
			throw new Exception("Error in employee Id input param");
		}
		return employeeService.getEmployee(employeeId);
	}
	
	@GetMapping("/emp/read/load")
	public Employee loadEmployee(@RequestParam Long employeeId) throws Exception{
		if(employeeId ==null){
			throw new Exception("Error in employee Id input param");
		}
		return employeeService.loadEmployee(employeeId);
	}
	
	@GetMapping("/emp/read/{empId}")
	public Employee readEmployeeByVariable(@PathVariable Long employeeId) throws Exception{
		if(employeeId ==null){
			throw new Exception("Error in employee Id input param");
		}
		return employeeService.getEmployee(employeeId);
	}
	
	@PostMapping("/emp/update")
	public void updateEmployee(@RequestBody Employee employee) throws Exception{
		if(employee ==null){
			throw new Exception("employee obj is null ");
		}
		employeeService.updateEmployee(employee);
	}
	
	@GetMapping("/emp/delete")
	public void deleteEmployee(@RequestParam Long employeeId){
		employeeService.deleteEmployee(employeeId);
	}
	
	@GetMapping("/emp/age/lessthan")
	public List<Employee> findEmployeesBelowAge(@RequestParam int employeeAge){
		return employeeService.findEmployeesBelowAge(employeeAge);
	}
	
	@GetMapping("/emp/getByName")
	public Employee findEmployeeByEmployeeName(@RequestParam String employeeName){
		return employeeService.findEmployeeByEmployeeName(employeeName);
	}
	@GetMapping("/emp/getByNameQuery")
	public Employee findEmployeeByEmployeeNameUsingQuery(@RequestParam  String employeeName){
		return employeeService.findEmployeeByEmployeeNameUsingQuery(employeeName);
	}
	
	@GetMapping("/emp/getAll")
	public List<Employee> findAll(){
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/emp/getAllNames")
	public List<String> findAllEmployeeNames(){
		return employeeService.findAllEmployeeNames();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleExcetion(Exception ex){
		ex.printStackTrace();
		return ex.getMessage();
	}
	

}
