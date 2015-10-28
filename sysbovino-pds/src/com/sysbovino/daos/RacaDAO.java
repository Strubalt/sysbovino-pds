package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Propriedade;
import com.sysbovino.entidades.Raca;
import com.sysbovino.hibernate.GenericDAO;

public class RacaDAO  extends GenericDAO<Raca> {
	
	 public RacaDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}