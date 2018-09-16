package com.barath.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@Service
class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	public Employee saveEmployee(Employee employee){

		return this.employeeRepository.save(employee);
	}

	public List<Employee> saveEmployees(List<Employee> employees){

		return this.employeeRepository.saveAll(employees);
	}

	public Employee getEmployee(Long employeeId){

		return this.employeeRepository.findById(employeeId).orElseThrow( () -> new EmployeeNotFoundException("emp not found "));
	}

	public List<Employee> findAll(){

		return this.employeeRepository.findAll();
	}

	@PostConstruct
	public void init(){

		Employee employee1 = new Employee("BARATH",25, Employee.EmployeeGender.MALE);
		Employee employee2 = new Employee("SACHIN",42, Employee.EmployeeGender.MALE);
		Employee employee3 = new Employee("DHONI",36, Employee.EmployeeGender.MALE);
		Employee employee4 = new Employee("HARI",28, Employee.EmployeeGender.MALE);
		Employee employee5 = new Employee("HARIHARAN",30, Employee.EmployeeGender.MALE);
		Employee employee6 = new Employee("PARI",25, Employee.EmployeeGender.FEMALE);
		Employee employee7 = new Employee("MEGHNA",18, Employee.EmployeeGender.FEMALE);
		Employee employee8 = new Employee("DIVYA",55, Employee.EmployeeGender.FEMALE);
		Employee employee9 = new Employee("SWATHI",35, Employee.EmployeeGender.FEMALE);
		Employee employee10 = new Employee("SIMRAN",45, Employee.EmployeeGender.FEMALE);

		this.saveEmployees(Arrays.asList(employee1,employee2,employee3,employee4
		,employee5,employee6,employee7,employee8,employee9,employee10));


	}



}


class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}

	protected EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

 interface  EmployeeRepository extends JpaRepository<Employee,Long> {

	List<Employee> findByEmployeeGender(Employee.EmployeeGender employeeGender);
	List<Employee> findByEmployeeAgeBetween(int start, int end);


	default List<Employee> findAllFemaleEmployees(){
		return this.findByEmployeeGender(Employee.EmployeeGender.FEMALE);
	}

	default List<Employee> findAllMaleEmployees(){
		return this.findByEmployeeGender(Employee.EmployeeGender.MALE);
	}

	/** custom query demonstration **/
	@Query(name = "SELECT emp from EMPLOYEE e where e.emp_name=?1",nativeQuery = true)
	List<Employee> findByEmployeeName(String empName);


}

@Entity
@Table(name="EMPLOYEE")
class Employee{

	@Id
	@GeneratedValue
	@Column(name="EMP_ID")
	private Long employeeId;

	@Column(name="EMP_NAME")
	private String employeeName;

	@Column(name="EMP_AGE")
	private int employeeAge;

	@Column(name="EMP_GENDER")
	@Enumerated(EnumType.STRING)
	private EmployeeGender employeeGender;

	public enum EmployeeGender {
		MALE,FEMALE
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public EmployeeGender getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(EmployeeGender employeeGender) {
		this.employeeGender = employeeGender;
	}

	public Employee() {
	}

	public Employee(String employeeName, int employeeAge, EmployeeGender employeeGender) {
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeGender = employeeGender;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", employeeName='" + employeeName + '\'' +
				", employeeAge=" + employeeAge +
				", employeeGender=" + employeeGender +
				'}';
	}
}