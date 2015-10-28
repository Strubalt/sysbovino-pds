package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.UnidadeFederativa;
import com.sysbovino.entidades.Veterinario;
import com.sysbovino.hibernate.GenericDAO;

public class VeterinarioDAO   extends GenericDAO<Veterinario> {
	
	 public VeterinarioDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
