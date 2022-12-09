package com.hibernate.java.controller;



import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.java.hibernateUtil.HibernateUtil;
import com.hibernate.java.pojo.Category;
import com.hibernate.java.pojo.Manufacture;
import com.hibernate.java.pojo.Product;

@RestController
public class ProductController {
	@RequestMapping("/product/list")
	public String product() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// goi thuc thi (ko co ko save)
			session.getTransaction().begin();
			
			Category c = session.get(Category.class,1);
			
			Manufacture m1 = session.get(Manufacture.class,1);
			Manufacture m2 = session.get(Manufacture.class,2);
			
			Product p = new Product();
			p.setName("dm may");
			p.setPrice(100);
			p.setCategory(c);
			
			//manu add nhieu
			Set<Manufacture> m = new HashSet<>();
			m.add(m1);
			m.add(m2);
			p.setManufacture(m);
			
			session.save(p);
			session.getTransaction().commit(); // dave db
		}
		return "/product/list/list ";
	}
}
