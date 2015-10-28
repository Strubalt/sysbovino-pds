package com.sysbovino.hibernate;

import java.util.List;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDAO<T> {

	private Class classePersistencia;
	protected Session sessao;

	public GenericDAO(Session sessao, Class classePersistencia) {
		this.sessao = sessao;
		this.classePersistencia = classePersistencia;
	}

	public void Salvar(T t) {
		Transaction tx = this.sessao.beginTransaction();
		sessao.save(t);
		tx.commit();
		sessao.close();
	}

	public void Apagar(T t) {
		Transaction tx = this.sessao.beginTransaction();
		sessao.delete(t);
		tx.commit();
		sessao.close();
	}

	public void Atualizar(T t) {
		Transaction tx = this.sessao.beginTransaction();
		sessao.merge(t);
		tx.commit();
		sessao.close();
	}

	
	public void Update(T t) {
		Transaction tx = this.sessao.beginTransaction();
		sessao.update(t);
		tx.commit();
		sessao.close();
	}
	
	@SuppressWarnings("unchecked")
	public T Carregar(int id) {
		return (T) sessao.load(classePersistencia, id);
	}

	@SuppressWarnings("unchecked")
	public List Listar() {
		return sessao.createCriteria(classePersistencia).list();
	}
}