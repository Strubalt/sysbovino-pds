package com.sysbovino.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sysbovino.daos.FaseDAO;
import com.sysbovino.entidades.Fase;
import com.sysbovino.hibernate.HibernateUtil;

/**
 * Servlet implementation class FaseController
 */
@WebServlet("/FaseController")
public class FaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaseController() {
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
		
		if(tipo.equals("populaFase")){
			objJsonArray = listaFaseToCombo();
			out.print(objJsonArray);
		}else if(tipo.equals("salvar")){
			
			
		}
	}
	
	public JSONArray listaFaseToCombo() {
		Fase objFase = new Fase();
		FaseDAO objFaseDao = new FaseDAO(HibernateUtil.getSessionFactory(), objFase.getClass());
		
		JSONArray jArrayFase = new JSONArray();
		
		List list = objFaseDao.Listar();
		for(int i=0;i<list.size();i++){
			JSONObject jsonFase = new JSONObject();
			Fase objF = new Fase();
			objF = (Fase) list.get(i);
			jsonFase.put("codFase", objF.getCodFase());
			jsonFase.put("nomeFase", objF.getNomeFase());
			jArrayFase.put(jsonFase);
		}
		
		return jArrayFase;
		
	}
	
	

}
