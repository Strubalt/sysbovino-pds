package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.FaseLote;
import com.sysbovino.entidades.FaseLoteId;
import com.sysbovino.hibernate.GenericDAO;

public class FaseLoteIdDAO extends GenericDAO<FaseLoteId> {
	
	 public FaseLoteIdDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
