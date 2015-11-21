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

import com.sysbovino.daos.LoteDAO;
import com.sysbovino.daos.PessoaDAO;
import com.sysbovino.daos.PropriedadeDAO;
import com.sysbovino.entidades.Lote;
import com.sysbovino.entidades.Pessoa;
import com.sysbovino.entidades.Propriedade;
import com.sysbovino.hibernate.HibernateUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");   
        PrintWriter out = response.getWriter();   
		
		//recebe tipo, assim identifica o deve ser feito
		String tipo = request.getParameter("tipoFlag");
		JSONObject objJson = new JSONObject();
		JSONArray objJsonArray = new JSONArray();
		
		if(tipo.equals("listar")){
			objJsonArray = listaLote();
			out.print(objJsonArray);
			
		}else if(tipo.equals("dadosLote")){
			Integer codLote = Integer.parseInt(request.getParameter("codLote"));
			System.out.println(codLote);
			objJson = dadosLote(codLote);
			out.print(objJson);
			
		}else if(tipo.equals("excluir")){
			System.out.println("oii");
			Integer codLote = Integer.parseInt(request.getParameter("codLote"));
			Lote lote = new Lote();
			lote.setCodLote(codLote);
			LoteDAO loteDao = new LoteDAO(HibernateUtil.getSessionFactory(), lote.getClass());
			loteDao.Apagar(lote);
			out.print("Excluído");
			
		}else if(tipo.equals("propriedade")){
			objJsonArray = listaPropriedades();
			out.print(objJsonArray);
		}else{
				//recebe o resto dos paramentros
				Integer codLote = Integer.parseInt(request.getParameter("codLote"));
				int codPropriedade = Integer.parseInt(request.getParameter("codPropriedade"));
				String comentario =  request.getParameter("descricaoLote");
				String dataCriacao = request.getParameter("dataCricao");
				String dataEncerramento = request.getParameter("dataEncerramento");
				Lote lote = new Lote();
				
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
				try {
					Date dateCricao = (Date)formatter.parse(dataCriacao);
					Date dateEncerramento = (Date)formatter.parse(dataEncerramento);
				
					
					lote.setCodLote(codLote);
					lote.setDescricaoLote(comentario);
					lote.setCodPropriedade(codPropriedade);
					lote.setDataCriacao(dateCricao);
					lote.setDataEncerramento(dateEncerramento);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				LoteDAO loteDao = new LoteDAO(HibernateUtil.getSessionFactory(), lote.getClass());
			if(tipo.equals("salvar")){	
				loteDao.Salvar(lote);
			}else if(tipo.equals("alterar")){
				loteDao.Update(lote);
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/loteCadastro.jsp").forward(request, response);
		}
	}
	
	public JSONArray listaLote() {
		System.out.println("chegou");
		Lote lote = new Lote();
		JSONArray objJsonArray = new JSONArray();
		
		LoteDAO loteDao = new LoteDAO(HibernateUtil.getSessionFactory(), lote.getClass());
		List list = loteDao.Listar();
				for(int i=0;i<list.size();i++){
					Lote lot = new Lote();
					JSONObject objJsonLote = new JSONObject();
					lot = (Lote) list.get(i);
					lot.getCodLote();
					objJsonLote.put("codLote", lot.getCodLote());
					
					lot.getCodPropriedade();//pegar o nome da propriedade
					objJsonLote.put("codPropriedade", lot.getCodPropriedade());
					lot.getDataCriacao();
					objJsonLote.put("dataCriacao", lot.getDataCriacao());
					lot.getDescricaoLote();
					objJsonLote.put("descricao", lot.getDescricaoLote());
					
					objJsonArray.put(objJsonLote);
				}
			
			return objJsonArray;
			
		//monatar o json e enviar para a tela 
		
	}
	
	public JSONObject dadosLote(int codLote){
		System.out.println("dadosLotes");
		Lote lote = new Lote();
		JSONObject objJsonLote = new JSONObject();
		
		LoteDAO loteDao = new LoteDAO(HibernateUtil.getSessionFactory(), lote.getClass());
		Lote lot = new Lote();
		lot = loteDao.Carregar(codLote);
		objJsonLote.put("codLote", lot.getCodLote());
		objJsonLote.put("codPropriedade", lot.getCodPropriedade());
		objJsonLote.put("dataCriacao", lot.getDataCriacao());
		objJsonLote.put("descricao", lot.getDescricaoLote());
		
		return objJsonLote;
	}
	
	public JSONArray listaPropriedades(){
		Propriedade objProp = new Propriedade();
		JSONArray objJsonArray = new JSONArray();
		PropriedadeDAO propDao = new PropriedadeDAO(HibernateUtil.getSessionFactory(), objProp.getClass());
		List list = propDao.Listar();
				for(int i=0;i<list.size();i++){
					Propriedade prop = new Propriedade();
					JSONObject objJsonLote = new JSONObject();
					prop = (Propriedade) list.get(i);
					
					objJsonLote.put("codPropriedade", prop.getCodPropriedade());
					
					Pessoa objPessoa = new Pessoa();
					PessoaDAO pessoaDao = new PessoaDAO(HibernateUtil.getSessionFactory(), objPessoa.getClass());
						Pessoa pessoa = new Pessoa();
						pessoa = pessoaDao.Carregar(prop.getCodPessoa());
						objJsonLote.put("nomePessoa",pessoa.getNomePessoa());
						
					objJsonLote.put("numIncra", prop.getNumIncra());
					objJsonArray.put(objJsonLote);
				}
		
		return objJsonArray;
	}
	
}
