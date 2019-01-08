package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;

public interface EmployeeDao {

	String addEmployee(Employee emp);
	String deleteEmployee(int empId);
	List<Employee> displayAll();
}
