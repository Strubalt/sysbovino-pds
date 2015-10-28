package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.FaseLoteId;
import com.sysbovino.entidades.Gado;
import com.sysbovino.hibernate.GenericDAO;

public class GadoDAO extends GenericDAO<Gado> {
	
	 public GadoDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}