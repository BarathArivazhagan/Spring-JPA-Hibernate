package com.barath.app.runner;

import com.barath.app.test.configuration.TestContext;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = TestContext.class)
public class SpringWebRunner extends AbstractSpringRunner {
}
