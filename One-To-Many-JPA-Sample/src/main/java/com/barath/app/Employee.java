package com.barath.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SAMPLE_EMPLOYEE")
public class Employee implements Serializable  {
	
	
	private static final long serialVersionUID = -7732685943864199209L;


	@Id
	@Column(name="EMP_ID")
	private long employeeId;
	
	
	@Column(name="EMP_NAME")
	private String employeeName;
	
	
	@Column(name="EMP_AGE")
	private int employeeAge;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="EMP_GENDER")
	private EmployeeGender employeeGender;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="EMP_DOB")
	private Date employeeDateOfBirth;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinColumn(name="DEPT_ID")
	private Department department;
	
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

	public Date getEmployeeDateOfBirth() {
		return employeeDateOfBirth;
	}

	public void setEmployeeDateOfBirth(Date employeeDateOfBirth) {
		this.employeeDateOfBirth = employeeDateOfBirth;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + employeeAge;
		result = prime * result + ((employeeDateOfBirth == null) ? 0 : employeeDateOfBirth.hashCode());
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
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (employeeAge != other.employeeAge)
			return false;
		if (employeeDateOfBirth == null) {
			if (other.employeeDateOfBirth != null)
				return false;
		} else if (!employeeDateOfBirth.equals(other.employeeDateOfBirth))
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

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAge=" + employeeAge
				+ ", employeeGender=" + employeeGender + ", employeeDateOfBirth=" + employeeDateOfBirth
				+ ", department=" + department + "]";
	}

	public Employee(long employeeId, String employeeName, int employeeAge, EmployeeGender employeeGender,
			Date employeeDateOfBirth, Department department) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAge = employeeAge;
		this.employeeGender = employeeGender;
		this.employeeDateOfBirth = employeeDateOfBirth;
		this.department = department;
	}
	
	

}
