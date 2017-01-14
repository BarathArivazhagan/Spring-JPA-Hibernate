package com.barath.app;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barath.app.User;

@SpringBootApplication
@RestController
public class SpringDataJpaLombokApplication {
	
	@Autowired
	private UserSerivce userSer;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaLombokApplication.class, args);
	}
	
	@GetMapping("/")
	public User getUser(){
		User user=userSer.getUser(100);
		System.out.println(user.toString());
		ObjectMapper mapper=new ObjectMapper();
		System.out.println("Object mapper "+mapper.writeValueAsString(user));
		
		return user;
	}
	
	
	@Configuration
	protected static class JPAConfiguration{
		

		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
			LocalContainerEntityManagerFactoryBean entityManagerFactory=new LocalContainerEntityManagerFactoryBean();
			entityManagerFactory.setPackagesToScan("com.barath.app");
			entityManagerFactory.setPersistenceUnitName("spring-data-jpa-sample");
			entityManagerFactory.setDataSource(embeddedDataSource());
			entityManagerFactory.setJpaDialect(jpaDialect());
			entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
			return entityManagerFactory;
		}
		
		@Bean
		public DataSource embeddedDataSource(){
			
			EmbeddedDatabase dataSource=new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
			return dataSource;
		}
		
	
		
		@Bean
		public HibernateJpaVendorAdapter jpaVendorAdapter(){
			
			HibernateJpaVendorAdapter jpaVendorAdapter=new  HibernateJpaVendorAdapter();
			jpaVendorAdapter.setDatabase(Database.HSQL);
			jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
			jpaVendorAdapter.setGenerateDdl(true);
			jpaVendorAdapter.setShowSql(true);
			return jpaVendorAdapter;
		}

		@Bean
		public HibernateJpaDialect jpaDialect(){
			return new HibernateJpaDialect();
		}
		
		@Bean
		public JpaTransactionManager transactionManager(){
			JpaTransactionManager transactionManager=new JpaTransactionManager();
			transactionManager.setDataSource(embeddedDataSource());
			transactionManager.setJpaDialect(jpaDialect());
			return transactionManager;
		}
		
		
	}
	
	
	
	
	
	//@ConditionalOnBean(UserRepository.class)
	@Service
	protected static class UserSerivce{
		
			
		
		@Autowired
		UserRepository userRep;
		
		
		public void addUser(User user){
			System.out.println("Adding the user "+user.toString());
			userRep.save(user);
		}
		
		public User getUser(int userId){
			System.out.println("Getting the user with userid  "+userId);
			User user=userRep.findOne(userId);
			return user;
		}
		
		@PostConstruct
		public void init(){
			User user=new User(100,"barath");
			addUser(user);
			
			user=getUser(100);
			System.out.println("user found "+user.toString());
		}
	}
}
