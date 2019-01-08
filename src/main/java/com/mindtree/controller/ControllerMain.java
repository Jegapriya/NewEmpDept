package com.mindtree.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Login;
import com.mindtree.service.impl.EmployeeServiceImpl;
import com.mindtree.service.impl.LoginServiceImpl;



@Controller
public class ControllerMain {
	
	private ApplicationContext con=new ClassPathXmlApplicationContext("Beans.xml");
	
	private Login log=con.getBean("loginObj",Login.class);
	private LoginServiceImpl loginService=con.getBean("objLoginService",LoginServiceImpl.class);
	private Employee emp=con.getBean("objEmployee",Employee.class);
	private EmployeeServiceImpl employeeService=con.getBean("objEmployeeService",EmployeeServiceImpl.class);
	
	@RequestMapping("/hello")
	public ModelAndView showLogin()
	{
		System.out.println("hi1");
		String message="HelloWorld";
		/*log.setUserId("Admin");
		log.setPassword("admin");
		System.out.println(loginService.createUser(log, con));*/
		return new ModelAndView("Login","message",message);
	}
	
	@RequestMapping("/login")
	public String validateLogin(HttpServletRequest request)
	{
		log.setUserId(request.getParameter("userId"));
		log.setPassword(request.getParameter("password"));
		System.out.println("Entered into login ...."+log.getUserId()+log.getPassword());
		emp=loginService.getUser(log, con);
		
		if(emp==null)
			return "failure";
		else if(emp.getUserId().equals(""))
			return "admin";
		else
			return "user";
	}
	
	@RequestMapping("/reloadAdmin")
	public String reloadOrgAdmin()
	{
		return "admin";
	}
	
	@RequestMapping("/addNewUser")
	public String addingUser()
	{
		
		return "addUser";
	}
	
	@RequestMapping("/cancel")
	public String cancelLogin()
	{
		return "failure";
	}
	
	@RequestMapping("/signup")
	public String signupLogin()
	{
		
		return "CreateUser";
	}
	
	@RequestMapping("/clear")
	public String clearLogin()
	{
		return "Login";
	}
	
	@RequestMapping("/createNew")
	public String createNewUser(HttpServletRequest request)
	{
		String rePassword=request.getParameter("rePassword");
	
		log.setUserId(request.getParameter("userId"));
		log.setPassword(request.getParameter("password"));
		System.out.println(loginService.createUser(log, rePassword, con));
		
		return "Login";
	}
	
	@RequestMapping("/createNewUser")
	public String createNew(HttpServletRequest request)
	{
		System.out.println(request.getParameter("userId"));
		return "admin";
		
	}
	
	@RequestMapping("/createEmployee")
	public ModelAndView createNewEmployee(@ModelAttribute Employee emp)
	{
		//System.out.println(emp.getUserName());
		System.out.println("Creating new Employee..."+emp.getEmail());
		employeeService.addUser(emp, con);
		log.setPassword(emp.getPassword());
		log.setUserId(emp.getUserId());
		loginService.createUser(log, con);
		return new ModelAndView("admin");
	}
	
	@RequestMapping("/viewAllUsers")
	public ModelAndView displayUsers()
	{
		return new ModelAndView("viewAllUsers","allEmployees",employeeService.viewAll(con));
	}
	
	@RequestMapping("/viewByIdMain")
	public ModelAndView viewByIdMain()
	{
		return new ModelAndView("viewById");
	}
	
	@RequestMapping("/viewById")
	public ModelAndView viewById(HttpServletRequest request)
	{
		return new ModelAndView("viewById","employee",employeeService.viewById(request.getParameter("empId"), con));
	}
}
