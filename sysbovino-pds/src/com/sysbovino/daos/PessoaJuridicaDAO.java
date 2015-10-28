package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.PessoaFisica;
import com.sysbovino.entidades.PessoaJuridica;
import com.sysbovino.hibernate.GenericDAO;

public class PessoaJuridicaDAO extends GenericDAO<PessoaJuridica> {
	
	 public PessoaJuridicaDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
