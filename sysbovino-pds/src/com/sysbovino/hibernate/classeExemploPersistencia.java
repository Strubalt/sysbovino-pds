package com.sysbovino.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sysbovino.entidades.Cidade;
import com.sysbovino.entidades.Medicamento;

public class classeExemploPersistencia {

	public static void insert(Medicamento medicamento) throws Exception {
		   
          Session session = HibernateUtil.getSessionFactory();  
          Transaction tx = session.beginTransaction();        
          session.save(medicamento);  
          tx.commit();  
          session.close();
	}

	
	public static void main(String[] args) {
		
		Cidade cidade = new Cidade();
		cidade.setCodCidade(1);
		cidade.setCodUf(1);
		cidade.setNomeCidade("nomeCidade");
		
		Medicamento medicamento = new Medicamento();
		medicamento.setCodMedicamento(1);
		medicamento.setNomeMedicamento("testeMedicamento 3");
		try {
			insert(medicamento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
}
