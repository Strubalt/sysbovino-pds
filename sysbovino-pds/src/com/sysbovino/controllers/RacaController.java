package com.sysbovino.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sysbovino.daos.GadoDAO;
import com.sysbovino.daos.LoteDAO;
import com.sysbovino.daos.MedicamentoDAO;
import com.sysbovino.daos.PessoaDAO;
import com.sysbovino.daos.PropriedadeDAO;
import com.sysbovino.daos.RacaDAO;
import com.sysbovino.entidades.Gado;
import com.sysbovino.entidades.Lote;
import com.sysbovino.entidades.Pessoa;
import com.sysbovino.entidades.Propriedade;
import com.sysbovino.entidades.Raca;
import com.sysbovino.hibernate.HibernateUtil;

@WebServlet("/RacaController")
public class RacaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RacaController() {
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
		//response.setContentType("text/plain");
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");   
        PrintWriter out = response.getWriter(); 
		
		//recebe tipo, assim identifica o deve ser feito
		String tipo = request.getParameter("tipoFlag");
		JSONObject objJson = new JSONObject();
		JSONArray objJsonArray = new JSONArray();
		
		if (tipo.equals("comboRaca")){
			out.print(listaComboRaca());
		}
		
	}
	
	public JSONArray listaComboRaca() {
		Raca objRaca = new Raca();
		JSONArray objJsonArray = new JSONArray();
		RacaDAO racaDao = new RacaDAO(HibernateUtil.getSessionFactory(), objRaca.getClass());
		List list = racaDao.Listar();
				for(int i=0;i<list.size();i++){
					Raca raca = new Raca();
					JSONObject objJsonRaca = new JSONObject();
					raca = (Raca) list.get(i);
					
					objJsonRaca.put("codRaca", raca.getCodRaca());
					objJsonRaca.put("nomeRaca", raca.getNomeRaca());
					objJsonArray.put(objJsonRaca);
				}
		
		return objJsonArray;
		
	}
	
	public void main(String[] args){
		
	}
}
