package com.hibernate.java.service;

import java.util.List;

import com.hibernate.java.pojo.Category;
import com.hibernate.java.service.impl.CategoryServiceImpl;

public interface CategoryService {

	public static CategoryService createInstance() {
		return new CategoryServiceImpl();
	}

	public abstract List<Category> getCategory();
}
