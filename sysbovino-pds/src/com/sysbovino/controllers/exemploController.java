package com.sysbovino.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class exemploController
 */
@WebServlet("/exemploController")
public class exemploController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exemploController() {
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
		String texto = request.getParameter("text");
		String opcao = request.getParameter("opcao");
		String comentario = request.getParameter("comentario");
		
		
		//mostra no console o resultado
		System.out.println("Chegou "+texto);
		
		//nesse espeço vai ser tratado a logica e enviado para as classes de inserção
		//após informado o retorno a tela
		//retorno será tanto uma confirmação de inserção como uma lista de bovinos ou lote
		
		
	}

}
