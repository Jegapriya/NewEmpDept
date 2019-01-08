package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Login;

public interface LoginDao {

	String createUser(Login obj);
	List<Login> getUsers();
}
