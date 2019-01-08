package com.mindtree.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mindtree.entity.Employee;

public interface EmployeeService {
	String addUser(Employee emp,ApplicationContext con);
	List<Employee> viewAll(ApplicationContext con);
	Employee viewById(String id,ApplicationContext con);
}
