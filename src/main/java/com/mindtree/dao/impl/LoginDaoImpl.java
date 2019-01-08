package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.mindtree.dao.LoginDao;
import com.mindtree.entity.Login;

public class LoginDaoImpl implements LoginDao{

	private HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public LoginDaoImpl() {
		super();
	}

	@Override
	public String createUser(Login obj) {
		Session session=template.getSessionFactory().openSession();
		session.save(obj);
		session.beginTransaction().commit();
		return "User Added successfully...";
	}

	@Override
	public List<Login> getUsers() {
		return template.loadAll(Login.class);
	}

}
