package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Lote;
import com.sysbovino.entidades.LoteAlimentacaoId;
import com.sysbovino.hibernate.GenericDAO;

public class LoteDAO extends GenericDAO<Lote> {
	
	 public LoteDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
