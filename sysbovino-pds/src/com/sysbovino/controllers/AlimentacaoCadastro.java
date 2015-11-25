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
import com.sysbovino.daos.ProdutoAlimenticioDAO;
import com.sysbovino.daos.PropriedadeDAO;
import com.sysbovino.entidades.Lote;
import com.sysbovino.entidades.Pessoa;
import com.sysbovino.entidades.ProdutoAlimenticio;
import com.sysbovino.entidades.Propriedade;
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
		request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");   
        PrintWriter out = response.getWriter();  
		
        
        

		//recebe tipo, assim identifica o deve ser feito
		String tipo = request.getParameter("tipoFlag");
		JSONObject objJson = new JSONObject();
		JSONArray objJsonArray = new JSONArray();
		
		if(tipo.equals("listar")){
			objJsonArray = listaAlimentos();
			out.print(objJsonArray);
			
		}else if(tipo.equals("dadosProduto")){
			Integer codProduto = Integer.parseInt(request.getParameter("codProduto"));
			System.out.println(codProduto);
			objJson = dadosAlimento(codProduto);
			out.print(objJson);
			
		}else if(tipo.equals("excluir")){
			System.out.println("oii");
			Integer codProduto = Integer.parseInt(request.getParameter("codProduto"));
			ProdutoAlimenticio produto = new ProdutoAlimenticio();
			produto.setCodProduto(codProduto);
			ProdutoAlimenticioDAO produtoDao = new ProdutoAlimenticioDAO(HibernateUtil.getSessionFactory(), produto.getClass());
			produtoDao.Apagar(produto);
			out.print("Excluído");
			
		}else if(tipo.equals("propriedade")){
			objJsonArray = listaPropriedades();
			out.print(objJsonArray);
		}else{
						
				//recebe o resto dos paramentros
				Integer codProduto = Integer.parseInt(request.getParameter("codProduto"));
				Integer codPessoa = Integer.parseInt(request.getParameter("codPessoa"));
				String observacao =  request.getParameter("observacao");
				String dataValidade = request.getParameter("dataValidade");
				String nomeProduto = request.getParameter("nomeProduto");
				ProdutoAlimenticio produto = new ProdutoAlimenticio();
				
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
				try {
					
					Date dateVal = (Date)formatter.parse(dataValidade);
					//Date dateEncerramento = (Date)formatter.parse(dataEncerramento);
				
					
					produto.setCodProduto(codProduto);
					produto.setCodPessoa(codPessoa);
					produto.setNomeProduto(nomeProduto);
					produto.setDataValidade(dateVal);
					produto.setObservacaoComposicao(observacao);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ProdutoAlimenticioDAO produtoDao = new ProdutoAlimenticioDAO(HibernateUtil.getSessionFactory(), produto.getClass());
			if(tipo.equals("salvar")){	
				produtoDao.Salvar(produto);
			}else if(tipo.equals("alterar")){
				produtoDao.Update(produto);
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/alimentoCadastro.jsp").forward(request, response);
		}
 	}
	

	public JSONArray listaAlimentos() {
		System.out.println("chegou");
		ProdutoAlimenticio produto = new ProdutoAlimenticio();
		JSONArray objJsonArray = new JSONArray();
		
		ProdutoAlimenticioDAO produtoDao = new ProdutoAlimenticioDAO(HibernateUtil.getSessionFactory(), produto.getClass());
		List list = produtoDao.Listar();
				for(int i=0;i<list.size();i++){
					ProdutoAlimenticio lot = new ProdutoAlimenticio();
					JSONObject objJsonLote = new JSONObject();
					lot = (ProdutoAlimenticio) list.get(i);
					lot.getCodProduto();
					objJsonLote.put("codProduto", lot.getCodProduto());
					
					lot.getNomeProduto();//pegar o nome da propriedade
					objJsonLote.put("nomeProduto", lot.getNomeProduto());
					lot.getObservacaoComposicao();
					objJsonLote.put("observacao", lot.getObservacaoComposicao());
					//lot.getDescricaoLote();
					//objJsonLote.put("descricao", lot.getDescricaoLote());
					
					objJsonArray.put(objJsonLote);
				}
			
			return objJsonArray;
			
		//monatar o json e enviar para a tela 
		
	}
	
	public JSONObject dadosAlimento(int codLote){
		System.out.println("dadosAlimento");
		ProdutoAlimenticio produto = new ProdutoAlimenticio();
		JSONObject objJsonLote = new JSONObject();
		
		ProdutoAlimenticioDAO produtoDao = new ProdutoAlimenticioDAO(HibernateUtil.getSessionFactory(), produto.getClass());
		ProdutoAlimenticio prod = new ProdutoAlimenticio();
		prod = produtoDao.Carregar(codLote);
		objJsonLote.put("codProduto", prod.getCodProduto());
		objJsonLote.put("codPessoa", prod.getCodPessoa());
		objJsonLote.put("dataValidade", prod.getDataValidade());
		objJsonLote.put("observacao", prod.getObservacaoComposicao());
		objJsonLote.put("nomeProduto", prod.getNomeProduto());
		
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

