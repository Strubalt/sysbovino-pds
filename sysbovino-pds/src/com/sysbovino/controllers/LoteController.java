package com.sysbovino.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sysbovino.daos.LoteDAO;
import com.sysbovino.entidades.Lote;
import com.sysbovino.entidades.Medicamento;
import com.sysbovino.hibernate.HibernateUtil;

/**
 * Servlet implementation class LoteController
 */
@WebServlet("/LoteController")
public class LoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		
		//recebe os os valores da tela
		Integer codLote = Integer.parseInt(request.getParameter("codLote"));
		int codPropriedade = Integer.parseInt(request.getParameter("codPropriedade"));
		String comentario =  request.getParameter("descricaoLote");
		String dataCriacao = request.getParameter("dataCriacao");
		//String dataEncerramento = request.getParameter("dataEnc");
		
		System.out.println("Chegou: "+comentario);
		
		Date date = new Date();
		
		Lote lote = new Lote();
		lote.setCodLote(codLote);
		lote.setDescricaoLote("Teste de lote");
		lote.setCodPropriedade(codPropriedade);
		lote.setDataCriacao(date);
		lote.setDataEncerramento(date);
		
		LoteDAO loteDao = new LoteDAO(HibernateUtil.getSessionFactory(), lote.getClass());
		
		loteDao.Salvar(lote);
		
	}
	
	public static void insert(Lote lote) throws Exception {

		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = session.beginTransaction();
		session.save(lote);
		tx.commit();
		session.close();
	}

}
