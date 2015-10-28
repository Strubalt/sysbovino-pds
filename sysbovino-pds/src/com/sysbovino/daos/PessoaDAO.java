package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Pecuarista;
import com.sysbovino.entidades.Pessoa;
import com.sysbovino.hibernate.GenericDAO;

public class PessoaDAO extends GenericDAO<Pessoa> {
	
	 public PessoaDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
