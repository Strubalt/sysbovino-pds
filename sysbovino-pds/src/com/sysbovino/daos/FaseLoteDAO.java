package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Fase;
import com.sysbovino.entidades.FaseLote;
import com.sysbovino.hibernate.GenericDAO;

public class FaseLoteDAO extends GenericDAO<FaseLote> {
	
	 public FaseLoteDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}

