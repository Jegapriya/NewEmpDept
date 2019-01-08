package com.mindtree.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Login {

	@Id
	private String userId;
	private String password;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(referencedColumnName="empId")
//	private Employee employee;

	public Login() {
		super();
		this.userId="";
		this.password="";
	}
	
	public Login(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	
	public Login(Login login) {
		this.userId=login.userId;
		this.password=login.password;
	}

	public void setLogin(Login login)
	{
		this.userId=login.userId;
		this.password=login.password;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
