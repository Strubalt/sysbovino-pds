package com.sysbovino.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sysbovino.daos.LoteDAO;
import com.sysbovino.daos.PessoaDAO;
import com.sysbovino.daos.PropriedadeDAO;
import com.sysbovino.entidades.Lote;
import com.sysbovino.entidades.Pessoa;
import com.sysbovino.entidades.Propriedade;
import com.sysbovino.hibernate.HibernateUtil;

/**
 * Servlet implementation class FaseLoteContorller
 */
@WebServlet("/FaseLoteController")
public class FaseLoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaseLoteController() {
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
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");   
        PrintWriter out = response.getWriter();   
		
		//recebe tipo, assim identifica o deve ser feito
		String tipo = request.getParameter("tipoFlag");
		JSONObject objJson = new JSONObject();
		JSONArray objJsonArray = new JSONArray();
		
		if(tipo.equals("populaLotes")){
			objJsonArray = listaLote();
			out.print(objJsonArray);
			
		}
			
		
	}
	
	public JSONArray listaLote(){
		Lote lote = new Lote();
		JSONArray objJsonArray = new JSONArray();
		
		LoteDAO loteDao = new LoteDAO(HibernateUtil.getSessionFactory(), lote.getClass());
		List list = loteDao.Listar();
				for(int i=0;i<list.size();i++){
					Lote lot = new Lote();
					JSONObject objJsonLote = new JSONObject();
					lot = (Lote) list.get(i);
					objJsonLote.put("codLote", lot.getCodLote());
					
					objJsonLote.put("codPropriedade", lot.getCodPropriedade());
					
					Propriedade objPropriedade = new Propriedade();
					PropriedadeDAO propDAO = new PropriedadeDAO(HibernateUtil.getSessionFactory(), objPropriedade.getClass());
						Propriedade prop = new Propriedade();
						prop = propDAO.Carregar(lot.getCodPropriedade());
						
					Pessoa objPessoa = new Pessoa();
					PessoaDAO pessoaDao = new PessoaDAO(HibernateUtil.getSessionFactory(), objPessoa.getClass());
						Pessoa pessoa = new Pessoa();
						pessoa = pessoaDao.Carregar(prop.getCodPessoa());
						objJsonLote.put("nomePessoa",pessoa.getNomePessoa());
		
					objJsonArray.put(objJsonLote);
				}
			
			return objJsonArray;
	}

}
