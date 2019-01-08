package com.mindtree.service.impl;

import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.dao.LoginDao;
import com.mindtree.dao.impl.EmployeeDaoImpl;
import com.mindtree.dao.impl.LoginDaoImpl;
import com.mindtree.entity.Employee;
import com.mindtree.entity.Login;
import com.mindtree.entity.Project;
import com.mindtree.service.LoginService;

public class LoginServiceImpl implements LoginService{

	
	public LoginServiceImpl() {
		super();
	}

	public Employee getUser(Login obj,ApplicationContext con) {
		LoginDao objLoginDao=con.getBean("objLoginDao",LoginDaoImpl.class);
		Login loginObj=con.getBean("loginObj",Login.class);
		System.out.println("I created loginDao...");
		try
		{
			loginObj.setLogin(objLoginDao.getUsers().stream().filter(loginUser->loginUser.getUserId().equals(obj.getUserId()) && loginUser.getPassword().equals(obj.getPassword())).collect(Collectors.toList()).get(0));
			
			EmployeeDao objEmployeeDao=con.getBean("objEmployeeDao",EmployeeDaoImpl.class);
			Employee objEmployee=con.getBean("objEmployee",Employee.class);
			Project objProject=con.getBean("objProject",Project.class);
			objProject.setProject();
			try
			{
				objEmployee.setEmployee(objEmployeeDao.displayAll().stream().filter(objEmp->objEmp.getUserId().equalsIgnoreCase(loginObj.getUserId())).collect(Collectors.toList()).get(0));
				return objEmployee;
			}
			catch(Exception e)
			{
				objEmployee.setEmployee();
				return objEmployee;
			}
//			if(objEmployee.getUserId().equals(""))
//				return "admin";
//			else
//				return "user";
					
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public String createUser(Login obj,String password,ApplicationContext con) {
		
		LoginDao objLoginDao=con.getBean("objLoginDao",LoginDaoImpl.class);
		if(obj.getPassword().equals(password))
			return objLoginDao.createUser(obj);
		else
			return "Not Successfully";
	}

	@Override
	public String createUser(Login obj,ApplicationContext con) {
		LoginDao objLoginDao=con.getBean("objLoginDao",LoginDaoImpl.class);
		objLoginDao.createUser(obj);
		return "success";
	}
	@Override
	public String changePassword(Login obj, ApplicationContext con) {
		return null;
	}

}
