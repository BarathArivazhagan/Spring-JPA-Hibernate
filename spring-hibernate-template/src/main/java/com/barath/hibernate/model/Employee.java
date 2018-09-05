package com.barath.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_HIBERNATE")
public class Employee implements Serializable{	


	/**
	 * 
	 */
	private static final long serialVersionUID = -366934818960578006L;
	
	
	@Id
	@Column(name="EMPLOYEE_ID")
	private long employeeId;
	
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	
	
	@Column(name="EMPLOYEE_AGE")
	private int employeeAge;
	
	@Column(name="EMPLOYEE_GENDER")
	@Enumerated(EnumType.STRING)
	private EmployeeGender employeeGender;
	
	public enum EmployeeGender{
		MALE,
		FEMALE
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeAge;
		result = prime * result + ((employeeGender == null) ? 0 : employeeGender.hashCode());
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeAge != other.employeeAge)
			return false;
		if (employeeGender != other.employeeGender)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}

	public Employee(long employeeId, String employeeName, int employeeAge, EmployeeGender employeeGender) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeGender = employeeGender;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge
				+ ", employeeGender=" + employeeGender + "]";
	}

	public Employee() {
		super();
		
	}

	

}
