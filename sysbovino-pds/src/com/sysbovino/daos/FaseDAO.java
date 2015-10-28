package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Cidade;
import com.sysbovino.entidades.Fase;
import com.sysbovino.hibernate.GenericDAO;

public class FaseDAO  extends GenericDAO<Fase> {
	
	 public FaseDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
