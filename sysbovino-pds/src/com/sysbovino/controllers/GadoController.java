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
import com.sysbovino.daos.RacaDAO;
import com.sysbovino.entidades.Gado;
import com.sysbovino.entidades.Lote;
import com.sysbovino.entidades.Raca;
import com.sysbovino.hibernate.HibernateUtil;

@WebServlet("/GadoController")
public class GadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GadoController() {
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
		//para listar
		if(tipo.equals("listar")){
			objJsonArray = listaGado();
			out.print(objJsonArray);
		}else if(tipo.equals("dadosGado")){
			Integer codLote = Integer.parseInt(request.getParameter("codLote"));
			System.out.println(codLote);
			objJson = getGado(codLote);
			out.print(objJson);	
		}else{
			Date data = new Date();
			//codigo,  lote, raca, peso, dataPesagem, racaPai, racaMae, observacoes
			//recebe os os valores da tela
			//System.out.println(request.getParameter("procedencia").charAt(0));
			int cod_raca = Integer.parseInt(request.getParameter("raca"));
			Date data_nascimento =  data; //request.getParameter("dataNascimento");
			int raca_pai = Integer.parseInt(request.getParameter("racaPai"));
			int raca_mae = Integer.parseInt(request.getParameter("racaMae"));
			char flag_status = 'B';
			char flag_procedencia = 'S';//request.getParameter("procedencia").charAt(0);
			char sexualidade = 'M'; //request.getParameter("sexo").charAt(0);
			String observacao = request.getParameter("observacao");
			int cod_sisbov = 1234;//Integer.parseInt(request.getParameter("sisbov"));
			
			
			//mostra no console o resultado
			//System.out.println("Chegou "+texto);
			
			Gado gado = new Gado();
			gado.setCodRaca(cod_raca);
			gado.setDataNascimento(data_nascimento);
			gado.setRacaPai(raca_pai);
			gado.setRacaMae(raca_mae);
			gado.setFlagStatus(flag_status);
			gado.setSexualidade(sexualidade);
			gado.setObservacao(observacao);
			gado.setCodSisbov(cod_sisbov);
			gado.setFlagProcedencia(flag_procedencia);
			
			GadoDAO gadoDao = new GadoDAO(HibernateUtil.getSessionFactory(), gado.getClass()); 
			
			gadoDao.Salvar(gado);
			//nesse espeço vai ser tratado a logica e enviado para as classes de inserção
			//após informado o retorno a tela
			//retorno será tanto uma confirmação de inserção como uma lista de bovinos ou lote
		}
	}
	
	
	public JSONObject getGado(int codGado) {
		System.out.println("dadosLotes");
		Gado gado = new Gado();
		JSONObject objJsonGado = new JSONObject();

		GadoDAO gadoDao = new GadoDAO(HibernateUtil.getSessionFactory(), gado.getClass());
		Gado objGado = new Gado();
		objGado = gadoDao.Carregar(codGado);

		Raca objRaca = new Raca();
		RacaDAO racaDao = new RacaDAO(HibernateUtil.getSessionFactory(), objRaca.getClass());
		objRaca = racaDao.Carregar(objGado.getCodRaca());

		objJsonGado.put("codGado", objGado.getCodGado());
		objJsonGado.put("codRaca", objRaca.getNomeRaca());
		objJsonGado.put("dataNascimento", objGado.getDataNascimento());
		objJsonGado.put("observacao", objGado.getObservacao());
		objJsonGado.put("codSisbov", objGado.getCodSisbov());

		objRaca = racaDao.Carregar(objGado.getRacaPai());
		objJsonGado.put("racaPai", objRaca.getNomeRaca());
		objRaca = racaDao.Carregar(objGado.getRacaMae());
		objJsonGado.put("racaMae", objRaca.getNomeRaca());

		objJsonGado.put("procedencia", objGado.getFlagProcedencia());
		objJsonGado.put("status", objGado.getFlagStatus());
		objJsonGado.put("sexo", objGado.getSexualidade());

		return objJsonGado;
	}

	public JSONArray listaGado() {
		System.out.println("chegou");
		Gado gado = new Gado();
		JSONArray objJsonArray = new JSONArray();

		GadoDAO gadoDao = new GadoDAO(HibernateUtil.getSessionFactory(), gado.getClass());
		List list = gadoDao.Listar();
		for (int i = 0; i < list.size(); i++) {
			Gado objGado = new Gado();
			JSONObject objJsonGado = new JSONObject();
			objGado = (Gado) list.get(i);

			Raca objRaca = new Raca();
			RacaDAO racaDao = new RacaDAO(HibernateUtil.getSessionFactory(), objRaca.getClass());
			objRaca = racaDao.Carregar(objGado.getCodRaca());

			objJsonGado.put("codGado", objGado.getCodGado());
			objJsonGado.put("codRaca", objRaca.getNomeRaca());
			objJsonGado.put("dataNascimento", objGado.getDataNascimento());
			objJsonGado.put("observacao", objGado.getObservacao());
			objJsonGado.put("codSisbov", objGado.getCodSisbov());

			objRaca = racaDao.Carregar(objGado.getRacaPai());
			objJsonGado.put("racaPai", objRaca.getNomeRaca());
			objRaca = racaDao.Carregar(objGado.getRacaMae());
			objJsonGado.put("racaMae", objRaca.getNomeRaca());

			objJsonGado.put("procedencia", objGado.getFlagProcedencia());
			objJsonGado.put("status", objGado.getFlagStatus());
			objJsonGado.put("sexo", objGado.getSexualidade());

			objJsonArray.put(objJsonGado);
		}

		return objJsonArray;

		// monatar o json e enviar para a tela

	}

	
	public void main(String[] args){
		
	}
}
