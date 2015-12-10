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

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import com.sysbovino.daos.GadoDAO;
import com.sysbovino.daos.GadoPesagemDAO;
import com.sysbovino.daos.LoteDAO;
import com.sysbovino.daos.MedicamentoDAO;
import com.sysbovino.daos.RacaDAO;
import com.sysbovino.entidades.Gado;
import com.sysbovino.entidades.GadoPesagem;
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
			
			try{
				Date data = new Date();
			
				String tipo_flag = request.getParameter("tipoFlag");
				
				int cod_raca = Integer.parseInt(request.getParameter("raca"));
				Date data_nascimento =  data; //request.getParameter("dataNascimento");
				int raca_pai = Integer.parseInt(request.getParameter("racaPai"));
				int raca_mae = Integer.parseInt(request.getParameter("racaMae"));
				String flag_status = request.getParameter("status");
				String flag_procedencia = request.getParameter("procedencia");
				String sexualidade = request.getParameter("sexualidade");
				String observacao = request.getParameter("observacoes");
				int cod_sisbov = Integer.parseInt(request.getParameter("sisbov"));
				double peso = Double.parseDouble(request.getParameter("peso"));
				
				Gado gado = new Gado();
				gado.setCodRaca(cod_raca);
				gado.setDataNascimento(data_nascimento);
				gado.setRacaPai(raca_pai);
				gado.setRacaMae(raca_mae);
				gado.setFlagStatus(flag_status.charAt(0));
				gado.setSexualidade(sexualidade.charAt(0));
				gado.setObservacao(observacao);
				gado.setCodSisbov(cod_sisbov);
				gado.setFlagProcedencia(flag_procedencia.charAt(0));
				
				GadoDAO gadoDao = new GadoDAO(HibernateUtil.getSessionFactory(), gado.getClass()); 
			
				if(tipo_flag.equals("alterar")){
					gadoDao.Atualizar(gado);;
				}else{
					gadoDao.Salvar(gado);	
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				out.print("ERRO");
			}
		}
	}
	
	public JSONObject salvou(){
		JSONObject objJsonGado = new JSONObject();
		objJsonGado.put("Salvou", true);
		return(objJsonGado);
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
