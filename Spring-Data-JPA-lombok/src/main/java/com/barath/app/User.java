package com.barath.app;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="USER")
public  class User implements Serializable{	

	
	private static final long serialVersionUID = -3740149288617227418L;
	
	@Id
	@Column(name="USER_ID")
	@Getter
	@Setter
	private int userId;
	
	
	@Column(name="USER_NAME")
	@Getter
	@Setter
	private String userName;

	
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
