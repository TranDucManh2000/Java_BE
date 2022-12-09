package com.hibernate.java.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.hibernate.java.hibernateUtil.HibernateUtil;
import com.hibernate.java.pojo.Category;
import com.hibernate.java.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategory() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Category> query = session.createQuery("from Category");
			List<Category> cats = query.list();
			session.close();
			return cats;
		} catch (Exception e) {
			return null;
		}
	}
}