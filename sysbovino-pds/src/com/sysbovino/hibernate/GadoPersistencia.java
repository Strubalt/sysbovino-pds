package com.sysbovino.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sysbovino.entidades.Gado;

public class GadoPersistencia {

	public static void inserir(Gado gado){
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = session.beginTransaction();
		session.save(gado);
		tx.commit();
		session.close();
	}
}
