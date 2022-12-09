package com.hibernate.java.service;

import java.util.List;

import com.hibernate.java.pojo.Users;
import com.hibernate.java.service.impl.UsersServiceImpl;

public interface UsersService {

	public static UsersService createInstance() {
		return new UsersServiceImpl();
	}

	public abstract List<Users> getUser();
	public abstract List<Users> getAuthen(String email,String password);
}
