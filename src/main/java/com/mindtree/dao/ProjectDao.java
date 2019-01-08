package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Project;

public interface ProjectDao {

	String addProject(Project project);
	String deleteProject(int projectId);
	List<Project> displayAll();
}
