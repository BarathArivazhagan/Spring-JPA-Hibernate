package com.barath.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaSampleApplication.class, args);
	}
	
	
	@Entity
	@Table(name="USER")
	protected static class User implements Serializable{	

		
		private static final long serialVersionUID = -3740149288617227418L;
		
		@Id
		@Column(name="USER_ID")
		private int userId;
		
		
		@Column(name="USER_NAME")
		private String userName;

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public User(int userId, String userName) {
			super();
			this.userId = userId;
			this.userName = userName;
		}

		public User() {
			super();
		
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + "]";
		}
		
		
		
		
	}
	
	
	@Configuration
	protected static class JPAConfiguration{
		

		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
			LocalContainerEntityManagerFactoryBean entityManagerFactory=new LocalContainerEntityManagerFactoryBean();
			entityManagerFactory.setPackagesToScan("com.barath.app");
			entityManagerFactory.setPersistenceUnitName("spring-data-jpa-sample");
			entityManagerFactory.setDataSource(dataSource());
			entityManagerFactory.setJpaDialect(jpaDialect());
			entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
			return entityManagerFactory;
		}
		
		@Bean
		public DataSource dataSource(){
			
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
			transactionManager.setDataSource(dataSource());
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
