package com.mindtree.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {

	@Id
	private int projectId;
	private String projectName;
	private String projectDescription;
	private String estimatedHrs;
	
	@OneToMany
	private List<Employee> employee;
	
	public Project() {
		super();
		this.projectId = 0;
		this.projectName = "";
		this.projectDescription = "";
		this.estimatedHrs = "";
	}

	public Project(int projectId, String projectName, String projectDescription, String estimatedHrs) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.estimatedHrs = estimatedHrs;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getEstimatedHrs() {
		return estimatedHrs;
	}

	public void setEstimatedHrs(String estimatedHrs) {
		this.estimatedHrs = estimatedHrs;
	}

	public void setProject()
	{
		this.projectId = 0;
		this.projectName = "";
		this.projectDescription = "";
		this.estimatedHrs = "";
	}
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", estimatedHrs=" + estimatedHrs + "]";
	}

	public Project getProject() {
		return new Project();
	}

}

