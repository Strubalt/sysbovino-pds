package com.sysbovino.daos;

import org.hibernate.Session;

import com.sysbovino.entidades.LoteGadoId;
import com.sysbovino.entidades.MedicamentoGado;
import com.sysbovino.hibernate.GenericDAO;

public class MedicamentoGadoDAO extends GenericDAO<MedicamentoGado> {
	
	 public MedicamentoGadoDAO(Session sessao, Class<?> classe) {  
	        super(sessao, classe);  
	    }  
	 
}
