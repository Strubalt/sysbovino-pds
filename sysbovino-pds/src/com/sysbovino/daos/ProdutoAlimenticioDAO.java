package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.PessoaJuridica;
import com.sysbovino.entidades.ProdutoAlimenticio;
import com.sysbovino.hibernate.GenericDAO;

public class ProdutoAlimenticioDAO extends GenericDAO<ProdutoAlimenticio> {
	
	 public ProdutoAlimenticioDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
