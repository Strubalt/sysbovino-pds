package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.LoteGado;
import com.sysbovino.entidades.LoteGadoId;
import com.sysbovino.hibernate.GenericDAO;

public class LoteGadoIdDAO extends GenericDAO<LoteGadoId> {
	
	 public LoteGadoIdDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}