package com.barath.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource("context.xml")
@EnableAutoConfiguration(exclude = {
        JpaRepositoriesAutoConfiguration.class
})
@RestController
public class SpringHibernateSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateSampleApplication.class, args);
	}
	
	
}
