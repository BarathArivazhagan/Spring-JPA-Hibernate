package com.barath.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.app.SpringDataJpaSampleApplication.User;

public  interface UserRepository extends JpaRepository<User, Integer>{
	
} 
