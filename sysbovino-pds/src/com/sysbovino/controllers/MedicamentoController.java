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

import com.sysbovino.daos.MedicamentoDAO;
import com.sysbovino.entidades.Medicamento;
import com.sysbovino.hibernate.HibernateUtil;

/**
 * Servlet implementation class medicamentoController
 */
@WebServlet("/MedicamentoController")
public class MedicamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicamentoController() {
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
      			objJsonArray = listaMedicamento();
      			out.print(objJsonArray);
      			
      		}
      		
	}
	
	public JSONArray listaMedicamento(){
		System.out.println("chegou");
		Medicamento remedio = new Medicamento();
		JSONArray objJsonArray = new JSONArray();
		
		MedicamentoDAO remedioDAO = new MedicamentoDAO(HibernateUtil.getSessionFactory(), remedio.getClass());
		List list = remedioDAO.Listar();
		for(int i = 0;i<list.size();i++){
			Medicamento rem = new Medicamento();
			JSONObject objJsonRem = new JSONObject();
			rem = (Medicamento) list.get(i);
			objJsonRem.put("codMedicamento", rem.getCodMedicamento());
			objJsonRem.put("nomeMedicamento", rem.getNomeMedicamento());
			objJsonArray.put(objJsonRem);
		}
		
		return objJsonArray;
	}

}
