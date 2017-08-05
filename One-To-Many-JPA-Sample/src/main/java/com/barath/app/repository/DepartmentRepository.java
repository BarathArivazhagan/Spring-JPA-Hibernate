package com.barath.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.app.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
