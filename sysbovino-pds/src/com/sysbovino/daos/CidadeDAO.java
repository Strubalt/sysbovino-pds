package com.sysbovino.daos;
import org.hibernate.Session;
import com.sysbovino.entidades.Cidade;
import com.sysbovino.hibernate.GenericDAO;

public class CidadeDAO extends GenericDAO<Cidade> {
	
	 public CidadeDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
