package com.hibernate.java.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.hibernate.java.hibernateUtil.HibernateUtil;
import com.hibernate.java.pojo.Users;
import com.hibernate.java.service.UsersService;

@Service
@SuppressWarnings("unchecked")
public class UsersServiceImpl implements UsersService {

	@Override
	public List<Users> getUser() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Users> query = session.createQuery("from Users");
			List<Users> cats = query.list();
			session.close();
			return cats;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Users> getAuthen(String email, String password) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "FROM Users u WHERE u.email = :email and password = :password";
			Query<Users> query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			List<Users> cats = query.list();
			session.close();
			return cats;
		} catch (Exception e) {
			return null;
		}
	}
}