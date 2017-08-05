package com.barath.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
