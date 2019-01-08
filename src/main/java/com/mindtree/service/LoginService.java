package com.mindtree.service;

import org.springframework.context.ApplicationContext;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Login;

public interface LoginService {
	Employee getUser(Login obj,ApplicationContext con);
	String createUser(Login obj,String password,ApplicationContext con);
	String createUser(Login obj,ApplicationContext con);
	String changePassword(Login obj,ApplicationContext con);
}
