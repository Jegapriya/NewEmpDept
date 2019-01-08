package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.mindtree.dao.*;
import com.mindtree.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	private HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public EmployeeDaoImpl() {
		super();
	}

	@Override
	public String addEmployee(Employee emp) {
		Session session=template.getSessionFactory().openSession();
		session.save(emp);
		session.beginTransaction().commit();
		return "Added successfully...";
	}

	@Override
	public String deleteEmployee(int empId) {
		template.bulkUpdate("Delete Employee where userId=?",empId);
		return "Deleted successfully...";
	}

	@Override
	public List<Employee> displayAll() {
		List<Employee> list=template.loadAll(Employee.class);
		System.out.println(list);
		return list;
	}

}
