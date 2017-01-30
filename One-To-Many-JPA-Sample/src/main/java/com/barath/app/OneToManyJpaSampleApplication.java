package com.barath.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class,DataSourceAutoConfiguration.class})
@EnableJpaRepositories
public class OneToManyJpaSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyJpaSampleApplication.class, args);
	}
}
