package com.sysbovino.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sysbovino.daos.MedicamentoDAO;
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

		// Cidade cidade = new Cidade();
		// cidade.setCodCidade(1);
		// cidade.setCodUf(1);
		// cidade.setNomeCidade("nomeCidade");
		//
		Medicamento medicamento = new Medicamento();
		medicamento.setCodMedicamento(3);
		medicamento.setNomeMedicamento("testeMedicamento zzz");
		MedicamentoDAO dao = new MedicamentoDAO(HibernateUtil.getSessionFactory(), medicamento.getClass());

		
		

		//salvar entidade;
		// dao.Salvar(medicamento);
		
		
		//updade entidade;
	   // dao.Update(medicamento);
		
		
		//delete entidade
		// dao.Apagar(medicamento);
		
		//buscar por id
		//dao.Carregar(medicamento.getCodMedicamento());
		
		//exemplo pra pegar uma lista com todos medicamentos e colocar em uma entidade;
		//List list = dao.Listar();
		//for(int i=0;i<list.size();i++){
		//	Medicamento med = new Medicamento();
		//	med = (Medicamento) list.get(i);
		//	med.getCodMedicamento();
		//	med.getNomeMedicamento();
		//}

		// try {
		// insert(medicamento);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
