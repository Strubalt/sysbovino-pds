package com.sysbovino.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sysbovino.daos.GadoDAO;
import com.sysbovino.daos.MedicamentoDAO;
import com.sysbovino.entidades.Gado;
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
		response.setContentType("text/plain");
		
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
		//nesse espe�o vai ser tratado a logica e enviado para as classes de inser��o
		//ap�s informado o retorno a tela
		//retorno ser� tanto uma confirma��o de inser��o como uma lista de bovinos ou lote
	}
	public void main(String[] args){
		
	}
}
