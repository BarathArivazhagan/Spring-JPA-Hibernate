package com.barath.app;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
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
	
	
	
	

	
	

	@Service
	protected static class UserSerivce{		
		
	
		private final UserRepository userRep;	
		
		
		public UserSerivce(UserRepository userRep) {
			super();
			this.userRep = userRep;
		}

		public void addUser(User user){
			System.out.println("Adding the user "+user.toString());
			userRep.save(user);
		}
		
		public User getUser(int userId){

			if(logger.isInfoEnabled()) { logger.info("getting the user with userid {} ",userId); }
			Optional<User> user=userRep.findById(userId);
			user.orElseThrow(() -> new UserNotFoundException(String.format("user with id %s not found",userId)));
			return user.get();
		}
		
		@PostConstruct
		public void init(){
			User user=new User(100,"barath");
			addUser(user);
			User userFound=getUser(100);
			logger.info("user found {}", Objects.toString(user));
		}
	}

	protected  static class UserNotFoundException extends RuntimeException {


		public UserNotFoundException() {
			super();
		}


		public UserNotFoundException(String message) {
			super(message);
		}


	}
}
