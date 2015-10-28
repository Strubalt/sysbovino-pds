package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.Pessoa;
import com.sysbovino.entidades.PessoaFisica;
import com.sysbovino.hibernate.GenericDAO;

public class PessoaFissicaDAO extends GenericDAO<PessoaFisica> {
	
	 public PessoaFissicaDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
