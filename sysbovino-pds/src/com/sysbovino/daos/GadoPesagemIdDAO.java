package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.GadoPesagem;
import com.sysbovino.entidades.GadoPesagemId;
import com.sysbovino.hibernate.GenericDAO;

public class GadoPesagemIdDAO extends GenericDAO<GadoPesagemId> {
	
	 public GadoPesagemIdDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
