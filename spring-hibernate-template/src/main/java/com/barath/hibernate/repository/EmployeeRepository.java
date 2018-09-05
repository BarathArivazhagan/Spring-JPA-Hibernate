package com.barath.hibernate.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barath.hibernate.model.Employee;

@Repository
public class EmployeeRepository {
	
	private static final Logger logger =LoggerFactory.getLogger(EmployeeRepository.class);
	private static final String FIND_BY_NAME_QUERY="from Employee where employee_name=:employeeName";
	private SessionFactory sessionFactory;
	
	@Autowired
	public EmployeeRepository(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	
	public Employee addEmployee(Employee emp){		
		Session session=getSession();
		if(logger.isInfoEnabled()){
			logger.info("Adding the employee "+emp.toString());
		}
		session.save(emp);
		session.flush();
		return emp;
	}
	
	public Employee getEmployee(long employeeId){
		Session session=getSession();
		if(logger.isInfoEnabled()){
			logger.info("Getting the employee with emp id"+employeeId);
		}
		Employee employee=session.get(Employee.class,employeeId);
		return employee;
	}
	
	public Employee loadEmployee(long employeeId){
		Session session=getSession();
		if(logger.isInfoEnabled()){
			logger.info("Getting the employee with emp id"+employeeId);
		}
		Employee employee=session.load(Employee.class,employeeId);
		return employee;
	}
	
	
	public void updateEmployee(Employee emp){
		Session session=getSession();
		if(logger.isInfoEnabled()){
			logger.info("Updating the employee with emp id"+emp.toString());
		}
		session.beginTransaction();
		Employee employee=session.get(Employee.class,emp.getEmployeeId());
		if(employee !=null){
			session.update(emp);
		}	
		
		
	}
	
	
	public void deleteEmployee(long employeeId){
		Session session=getSession();
		if(logger.isInfoEnabled()){
			logger.info("Deleting the employee with emp id"+employeeId);
		}
		Employee employee=session.get(Employee.class,employeeId);
		if(employee !=null){
			session.delete(employee);
		}	
	}
	
	public List<Employee> findEmployeesBelowAge(int employeeAge){
		
		Session session=getSession();		
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.le("employeeAge", employeeAge));
		List<Employee> employees= criteria.list();
		employees.stream().forEach(System.out::println);
		return employees;
	}
	
	public Employee findEmployeeByEmployeeName(String employeeName){
		Session session=getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employeeName", employeeName));
		Employee employee= (Employee) criteria.list().get(0);
		if(employee !=null){
			if(logger.isInfoEnabled()){
				logger.info("Found employee with emp name "+employeeName+" Employee "+employee.toString());
			}
		}
		
		return employee;
	}
	
	public Employee findEmployeeByEmployeeNameUsingQuery(String employeeName){
		Session session=getSession();
		Query query=session.createQuery(FIND_BY_NAME_QUERY);
		query.setParameter("employeeName", employeeName);
		List<Employee> employees=query.list();
		if(employees !=null){
			if(logger.isInfoEnabled()){
				logger.info("Found employee with emp name "+employeeName+" Employee "+employees.stream().findFirst().get().toString());
			}
		}
		
		return employees.stream().findFirst().get();
	}
	
	
	public List<Employee> findAllEmployees() {
		Session session=getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		return criteria.list();
	}


	public List<String> findAllEmployeeNames() {
		Session session=getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee> employees=criteria.list();
		List<String> employeeNames=null;
		if(employees !=null && !employees.isEmpty()){
			employeeNames=employees.stream().map(Employee::getEmployeeName).collect(Collectors.toList());
		}
		return employeeNames;
	}
	
	public List<String> findAllEmployeeNamesByProjection() {
		Session session=getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.setProjection(Property.forName("employeeName"));
		List<String> employeeNames=criteria.list();
		if(employeeNames !=null && !employeeNames.isEmpty()){
			employeeNames.stream().forEach(System.out::println);
		}
		return employeeNames;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession(){
		return this.sessionFactory.openSession();
	}


	


}
