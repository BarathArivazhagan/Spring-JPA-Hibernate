package com.barath.app;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.barath.app.Employee.EmployeeGender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyJpaSampleApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	
	
	public void loadData(){
		
		
		Department department1=new Department(20, "SCIENCE");
		Department department2=new Department(21, "HISTORY");
		Department department3=new Department(22, "ENGLISH");
		Department department4=new Department(23, "COMPUTER");
		Department department5=new Department(24, "TAMIL");
		SimpleDateFormat sf = new SimpleDateFormat("dd-mm-yyyyy"); 
		Employee emp1=new Employee(1000, "barath", 23, EmployeeGender.MALE, new Datsf.format("10-12-1991"), department1);
		
	}

}
