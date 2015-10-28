package com.sysbovino.daos;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.sysbovino.entidades.Medicamento;
import com.sysbovino.hibernate.GenericDAO;

public class MedicamentoDAO extends GenericDAO<Medicamento> {
	
	 public MedicamentoDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
}