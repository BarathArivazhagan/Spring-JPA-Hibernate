package com.barath.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.app.Application.User;

public  interface UserRepository extends JpaRepository<User, Integer>{
	
} 
