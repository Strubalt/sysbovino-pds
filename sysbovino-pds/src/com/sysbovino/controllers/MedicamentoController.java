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

import com.sysbovino.daos.MedicamentoDAO;
import com.sysbovino.daos.ProdutoAlimenticioDAO;
import com.sysbovino.entidades.Medicamento;
import com.sysbovino.entidades.ProdutoAlimenticio;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		// recebe tipo, assim identifica o deve ser feito
		String tipo = request.getParameter("tipoFlag");
		JSONObject objJson = new JSONObject();
		JSONArray objJsonArray = new JSONArray();

		if (tipo.equals("listar")) {
			objJsonArray = listaMedicamento();
			out.print(objJsonArray);

		} else if (tipo.equals("dadosMedicamento")) {
			Integer codMedicamento = Integer.parseInt(request.getParameter("codMedicamento"));
			System.out.println(codMedicamento);
			objJson = dadosMedicamento(codMedicamento);
			out.print(objJson);

		} else if (tipo.equals("excluir")) {
			System.out.println("oii");
			Integer codMedicamento = Integer.parseInt(request.getParameter("codMedicamento"));
			Medicamento medicamento = new Medicamento();
			// medicamento.setCodMedicamento(codMedicamento);
			MedicamentoDAO medicamentoDao = new MedicamentoDAO(HibernateUtil.getSessionFactory(),
					medicamento.getClass());
			medicamento = medicamentoDao.Carregar(codMedicamento);
			if (medicamento != null) {
				medicamentoDao.Apagar(medicamento);
				out.print("Excluído");
			}

		} // else if(tipo.equals("propriedade")){
			// objJsonArray = listaPropriedades();
			// out.print(objJsonArray);
			// }
		else {

			// recebe o resto dos paramentros
			

			String nomeMedicamento = request.getParameter("nomeMedicamento");

			Medicamento medicamento = new Medicamento();

			
			medicamento.setNomeMedicamento(nomeMedicamento);

			MedicamentoDAO medicamentoDao = new MedicamentoDAO(HibernateUtil.getSessionFactory(),
					medicamento.getClass());
			if (tipo.equals("salvar")) {
				try {
					medicamentoDao.Salvar(medicamento);
				} catch (Exception e) {
					medicamentoDao.Update(medicamento);
				}
			} else if (tipo.equals("alterar")) {
				Integer codMedicamento = Integer.parseInt(request.getParameter("codMedicamento"));
				medicamento.setCodMedicamento(codMedicamento);
				medicamentoDao.Update(medicamento);
			}
			
		}
	}
	// request.setCharacterEncoding("UTF-8");
	// response.setCharacterEncoding("UTF-8");
	// response.setContentType("application/json");
	// PrintWriter out = response.getWriter();
	//
	// //recebe tipo, assim identifica o deve ser feito
	// String tipo = request.getParameter("tipoFlag");
	// JSONObject objJson = new JSONObject();
	// JSONArray objJsonArray = new JSONArray();
	//
	// if(tipo.equals("listar")){
	// objJsonArray = listaMedicamento();
	// out.print(objJsonArray);
	//
	// }
	//
	// }

	public JSONObject dadosMedicamento(int codMedicamento) {
		System.out.println("dadosMedicamento");
		Medicamento medicamento = new Medicamento();
		JSONObject objJsonLote = new JSONObject();

		MedicamentoDAO medicamentoDao = new MedicamentoDAO(HibernateUtil.getSessionFactory(), medicamento.getClass());
		Medicamento med = new Medicamento();
		med = medicamentoDao.Carregar(codMedicamento);
		objJsonLote.put("codMedicamento", med.getCodMedicamento());
		objJsonLote.put("nomeMedicamento", med.getNomeMedicamento());
		return objJsonLote;
	}

	public JSONArray listaMedicamento() {
		System.out.println("chegou");
		Medicamento remedio = new Medicamento();
		JSONArray objJsonArray = new JSONArray();

		MedicamentoDAO remedioDAO = new MedicamentoDAO(HibernateUtil.getSessionFactory(), remedio.getClass());
		List list = remedioDAO.Listar();
		for (int i = 0; i < list.size(); i++) {
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
