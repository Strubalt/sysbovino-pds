package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.TipoAlimentacaoProduto;
import com.sysbovino.entidades.TipoAlimentacaoProdutoId;
import com.sysbovino.hibernate.GenericDAO;

public class TipoAlimentacaoProdutoIdDAO   extends GenericDAO<TipoAlimentacaoProdutoId> {
	
	 public TipoAlimentacaoProdutoIdDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
