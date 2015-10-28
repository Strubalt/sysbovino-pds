package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.GadoPesagemId;
import com.sysbovino.entidades.LoteAlimentacao;
import com.sysbovino.hibernate.GenericDAO;

public class LoteAlimentacaoDAO extends GenericDAO<LoteAlimentacao> {
	
	 public LoteAlimentacaoDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
