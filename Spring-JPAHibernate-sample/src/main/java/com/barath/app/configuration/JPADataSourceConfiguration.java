package com.barath.app.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
public class JPADataSourceConfiguration {
	
	private static final Logger logger=LoggerFactory.getLogger(JPADataSourceConfiguration.class);
	private static final String PERSISTENCE_UNIT_NAME="competition";
	
	@Value("${spring.profiles.active:local}")
	private String[] profiles;
	
	
	@Value("${datasource.connection.${spring.profiles.active:local}.url}")
	private String dataSourceConnectionUrl;
	
	

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory=new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setPackagesToScan("com.barath.app.entities");
		entityManagerFactory.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaDialect(jpaDialect());
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		return entityManagerFactory;
	}
	
	@Bean
	public DriverManagerDataSource dataSource(){
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl(dataSourceConnectionUrl);
		dataSource.setUsername("sa");
		dataSource.setPassword("");
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
	
	@Bean(name="jpaTransactionManager")
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager=new JpaTransactionManager();
		transactionManager.setDataSource(dataSource());
		transactionManager.setJpaDialect(jpaDialect());
		return transactionManager;
	}
	
	

}
