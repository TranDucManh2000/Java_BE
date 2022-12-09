package com.hibernate.java.hibernateUtil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.java.pojo.Category;
import com.hibernate.java.pojo.Manufacture;
import com.hibernate.java.pojo.Product;
import com.hibernate.java.pojo.Users;

public class HibernateUtil {

	private final static SessionFactory FACTORY;
	static {
		Configuration conf = new Configuration();
		Properties pros = new Properties();
		pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		pros.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		pros.put(Environment.URL, "jdbc:mysql://localhost:4306/J6Store");
		pros.put(Environment.USER, "root");
		pros.put(Environment.PASS, "");
		conf.setProperties(pros);
		conf.addAnnotatedClass(Category.class);
		conf.addAnnotatedClass(Product.class);
		conf.addAnnotatedClass(Manufacture.class);
		conf.addAnnotatedClass(Users.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		FACTORY = conf.buildSessionFactory(registry);
	}

	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}

// .xml
//	 private static SessionFactory sessionFactory;
//
//	    private static SessionFactory buildSessionFactory() {
//	        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().
//	                configure("hibernate.cfg.xml").build();
//
//	        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().
//	                build();
//
//	        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();
//
//	        SessionFactory sessionFactory = sessionFactoryBuilder.build();
//
//	        return sessionFactory;
//	    }
//
//	    public static SessionFactory getSessionFactory() {
//	        if (sessionFactory == null) {
//	            sessionFactory = buildSessionFactory();
//	        }
//	        return sessionFactory;
//	    }	

}
