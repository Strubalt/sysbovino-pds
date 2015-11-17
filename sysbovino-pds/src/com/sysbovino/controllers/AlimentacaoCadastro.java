package com.sysbovino.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sysbovino.daos.ProdutoAlimenticioDAO;
import com.sysbovino.entidades.ProdutoAlimenticio;
import com.sysbovino.hibernate.HibernateUtil;

@WebServlet("/AlimentacaoController")
public class AlimentacaoCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlimentacaoCadastro() {
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
		

		int codigo = Integer.parseInt(request.getParameter("codigo"));
		int fornecedora =  Integer.parseInt(request.getParameter("fornecedora"));
		String nomeProduto =  request.getParameter("nomeProduto");
		String composicao =  request.getParameter("composicao");
	
		
		
		
		//mostra no console o resultado
		//System.out.println("Chegou "+texto);
		ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio();
		produtoAlimenticio.setCodPessoa(fornecedora);
		produtoAlimenticio.setCodProduto(codigo);
		produtoAlimenticio.setNomeProduto(nomeProduto);
		produtoAlimenticio.setObservacaoComposicao(composicao);
		ProdutoAlimenticioDAO produtoAlimenticioDAO  = new ProdutoAlimenticioDAO(HibernateUtil.getSessionFactory(), produtoAlimenticio.getClass());
		
		produtoAlimenticioDAO.Salvar(produtoAlimenticio);
		//nesse espeço vai ser tratado a logica e enviado para as classes de inserção
		//após informado o retorno a tela
		//retorno será tanto uma confirmação de inserção como uma lista de bovinos ou lote
	}
	public void main(String[] args){
		
	}
}

