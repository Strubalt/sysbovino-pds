package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Pais;
import com.sysbovino.entidades.Pecuarista;
import com.sysbovino.hibernate.GenericDAO;

public class PecuaristaDAO extends GenericDAO<Pecuarista> {
	
	 public PecuaristaDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}

