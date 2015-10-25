package com.sysbovino.hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	static Session session = null;

	public static Session getSessionFactory() {

		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		return session = factory.openSession();
	}
}