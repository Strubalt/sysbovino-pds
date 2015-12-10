package com.sysbovino.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sysbovino.daos.LoteAlimentacaoDAO;
import com.sysbovino.daos.LoteAlimentacaoIdDAO;
import com.sysbovino.entidades.LoteAlimentacao;
import com.sysbovino.entidades.LoteAlimentacaoId;
import com.sysbovino.hibernate.HibernateUtil;

/**
 * Servlet implementation class LoteAlimentacaoController
 */
@WebServlet("/LoteAlimentacaoController")
public class LoteAlimentacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoteAlimentacaoController() {
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
		
		
		
		Integer codLote = Integer.parseInt(request.getParameter("codLote"));
		Integer codAlimentacao = Integer.parseInt(request.getParameter("codAlimentacao"));
		String stDataIni = request.getParameter("dataInicio");
		String stDataFim = request.getParameter("dataFimPrev");
		Integer codItem = Integer.parseInt(request.getParameter("item"));
		
		double pesoLote = Double.parseDouble(request.getParameter("pesoLote"));
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		
		LoteAlimentacaoId objLoteAlimId = new LoteAlimentacaoId();
		LoteAlimentacao objLoteAlim = new LoteAlimentacao();
		
		try {
			Date dateInicio = (Date)formatter.parse(stDataIni);
			Date dateFim = (Date)formatter.parse(stDataFim);
			
			objLoteAlimId.setCodLote(codLote);
			objLoteAlimId.setSeqItem(codItem);
			
			objLoteAlim.setId(objLoteAlimId);
			objLoteAlim.setCodAlimentacao(codAlimentacao);
			objLoteAlim.setDataInicio(dateInicio);
			objLoteAlim.setDataPrevistoFim(dateFim);
			BigDecimal bd = new BigDecimal(pesoLote);
			objLoteAlim.setPesoInicialLote(bd);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//LoteAlimentacaoIdDAO objLoteAlimIdDAO = new LoteAlimentacaoIdDAO(HibernateUtil.getSessionFactory(), objLoteAlimId.getClass());
			LoteAlimentacaoDAO objLoteAlimDAO = new LoteAlimentacaoDAO(HibernateUtil.getSessionFactory(), objLoteAlim.getClass());
		if(tipo.equals("salvar")){

			//objLoteAlimIdDAO.Salvar(objLoteAlimId);
			objLoteAlimDAO.Salvar(objLoteAlim);
		}
	}

}
