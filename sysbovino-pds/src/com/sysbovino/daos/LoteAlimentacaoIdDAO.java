package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.LoteAlimentacao;
import com.sysbovino.entidades.LoteAlimentacaoId;
import com.sysbovino.hibernate.GenericDAO;

public class LoteAlimentacaoIdDAO extends GenericDAO<LoteAlimentacaoId> {
	
	 public LoteAlimentacaoIdDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}

