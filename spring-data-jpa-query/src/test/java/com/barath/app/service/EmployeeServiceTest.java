package com.barath.app.service;

import com.barath.app.test.configuration.EmployeeRepository;
import com.barath.app.runner.SpringWebRunner;
import com.barath.app.test.configuration.EmployeeService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.invoke.MethodHandles;


public class EmployeeServiceTest extends SpringWebRunner {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSaveEmployee() {
        logger.info("test save empployee start");
        System.out.println(employeeService);

        logger.info("test save empployee end");

    }

}
