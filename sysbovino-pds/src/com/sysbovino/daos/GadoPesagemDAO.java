package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Gado;
import com.sysbovino.entidades.GadoPesagem;
import com.sysbovino.hibernate.GenericDAO;

public class GadoPesagemDAO extends GenericDAO<GadoPesagem> {
	
	 public GadoPesagemDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}