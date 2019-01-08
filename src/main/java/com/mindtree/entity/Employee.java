package com.mindtree.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {

	@Id
	private String userId;
	private String userName;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date doj; 
	private String email;
	private String role;
	//private int projectId;
	
	@ManyToOne
	private Project project;
	
	/*@OneToOne
	@JoinColumn(referencedColumnName="userId")
	private Login login;*/
	
	public Employee() {
		super();
		this.userId="";
		this.userName = "";
		this.doj = null;
		this.email = "";
		this.password="";
		this.role = "";
		this.project = null;
	}

	public Employee(String userId, String userName, Date doj, String email,String password, String role,Project project) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.doj = doj;
		this.email = email;
		this.password=password;
		this.role = role;
		this.project = project;
	}	
	
	public void setEmployee()
	{
		this.userId="";
		this.userName = "";
		this.doj = null;
		this.email = "";
		this.password="";
		this.role = "";
		this.project = null;
	}
	
	public void setEmployee(Employee employee)
	{
		this.userId = employee.getUserId();
		this.userName = employee.getUserName();
		this.doj = employee.getDoj();
		this.email = employee.getEmail();
		this.password=employee.getPassword();
		this.role = employee.getRole();
		this.project = employee.getProject();
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	/*public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}*/

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", userName=" + userName + ", doj=" + doj + ", email=" + email + ", role="
				+ role + ", project=" + project + "]";
	}
}
