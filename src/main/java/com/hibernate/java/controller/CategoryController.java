package com.hibernate.java.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.java.pojo.Category;
import com.hibernate.java.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	CategoryService cateDAO = CategoryService.createInstance();

	@GetMapping
	public List<Category> getCategory() {
		return cateDAO.getCategory();
	}
}
