package com.mindtree.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;

import com.mindtree.dao.impl.EmployeeDaoImpl;
import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public String addUser(Employee emp, ApplicationContext con) {
		EmployeeDaoImpl employeeDao=con.getBean("objEmployeeDao",EmployeeDaoImpl.class);
		return employeeDao.addEmployee(emp);
	}

	@Override
	public List<Employee> viewAll(ApplicationContext con) {
		EmployeeDaoImpl employeeDao=con.getBean("objEmployeeDao",EmployeeDaoImpl.class);
		return employeeDao.displayAll();
	}

	@Override
	public Employee viewById(String id, ApplicationContext con) {
		System.out.println("id"+id);
		EmployeeDaoImpl employeeDao=con.getBean("objEmployeeDao",EmployeeDaoImpl.class);
		//System.out.println("Employee:"+employeeDao.displayAll());//.stream().filter(emp->emp.getUserId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0));
		return employeeDao.displayAll().stream().filter(emp->emp.getUserId().equalsIgnoreCase(id)).collect(Collectors.toList()).get(0);
	}

	
}
