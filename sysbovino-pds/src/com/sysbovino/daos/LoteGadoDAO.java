package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Lote;
import com.sysbovino.entidades.LoteGado;
import com.sysbovino.hibernate.GenericDAO;

public class LoteGadoDAO extends GenericDAO<LoteGado> {
	
	 public LoteGadoDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
