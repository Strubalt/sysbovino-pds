package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.MedicamentoGado;
import com.sysbovino.entidades.Pais;
import com.sysbovino.hibernate.GenericDAO;

public class PaisDAO extends GenericDAO<Pais> {
	
	 public PaisDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
