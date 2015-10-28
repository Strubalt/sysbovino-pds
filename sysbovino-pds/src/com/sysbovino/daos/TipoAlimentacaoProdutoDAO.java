package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Raca;
import com.sysbovino.entidades.TipoAlimentacaoProduto;
import com.sysbovino.hibernate.GenericDAO;

public class TipoAlimentacaoProdutoDAO  extends GenericDAO<TipoAlimentacaoProduto> {
	
	 public TipoAlimentacaoProdutoDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
