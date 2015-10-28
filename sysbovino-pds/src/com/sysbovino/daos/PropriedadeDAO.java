package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.ProdutoAlimenticio;
import com.sysbovino.entidades.Propriedade;
import com.sysbovino.hibernate.GenericDAO;

public class PropriedadeDAO  extends GenericDAO<Propriedade> {
	
	 public PropriedadeDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
