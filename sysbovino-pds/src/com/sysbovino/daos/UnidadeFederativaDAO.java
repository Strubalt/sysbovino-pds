package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.TipoAlimentacaoProdutoId;
import com.sysbovino.entidades.UnidadeFederativa;
import com.sysbovino.hibernate.GenericDAO;

public class UnidadeFederativaDAO   extends GenericDAO<UnidadeFederativa> {
	
	 public UnidadeFederativaDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
