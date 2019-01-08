package com.mindtree.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mindtree.entity.Project;

public interface ProjectService {
	List<Project> viewAll(ApplicationContext con);
	Project viewById(int id,ApplicationContext con);
}
