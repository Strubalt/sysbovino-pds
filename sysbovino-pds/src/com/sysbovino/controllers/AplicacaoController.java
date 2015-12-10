
package com.sysbovino.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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

import org.apache.tomcat.jni.Time;
import org.json.JSONArray;
import org.json.JSONObject;

import com.sysbovino.daos.GadoDAO;
import com.sysbovino.daos.MedicamentoDAO;
import com.sysbovino.daos.MedicamentoGadoDAO;
import com.sysbovino.daos.PessoaDAO;
import com.sysbovino.daos.PropriedadeDAO;
import com.sysbovino.entidades.Gado;
import com.sysbovino.entidades.Medicamento;
import com.sysbovino.entidades.MedicamentoGado;
import com.sysbovino.entidades.Pessoa;
import com.sysbovino.entidades.Propriedade;
import com.sysbovino.hibernate.HibernateUtil;

@WebServlet("/AplicacaoController")
public class AplicacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AplicacaoController() {
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
			objJsonArray = listaAplicacao();
			out.print(objJsonArray);

		} else if (tipo.equals("dadosAplicacao")) {
			Integer codHistoricoMedicacao = Integer.parseInt(request.getParameter("codHistoricoMedicacao"));
			System.out.println(codHistoricoMedicacao);
			objJson = dadosAplicacao(codHistoricoMedicacao);
			out.print(objJson);

		} else if (tipo.equals("pessoa")) {
			objJsonArray = listaPessoa();
			out.print(objJsonArray);
		} else if (tipo.equals("gado")) {
			objJsonArray = listaGado();
			out.print(objJsonArray);
		} else if (tipo.equals("medicamento")) {
			objJsonArray = listaMedicamento();
			out.print(objJsonArray);
		}

		else if (tipo.equals("excluir")) {
			System.out.println("oii");
			Integer codHistoricoMedicacao = Integer.parseInt(request.getParameter("codHistoricoMedicacao"));
			MedicamentoGado HistoricoMedicacao = new MedicamentoGado();

			// ProdutoAlimenticio produto = new ProdutoAlimenticio();
			// produto.setCodProduto(codProduto);
			MedicamentoGadoDAO produtoDao = new MedicamentoGadoDAO(HibernateUtil.getSessionFactory(),
					HistoricoMedicacao.getClass());
			HistoricoMedicacao = produtoDao.Carregar(codHistoricoMedicacao);
			if (HistoricoMedicacao != null) {
				produtoDao.Apagar(HistoricoMedicacao);
				out.print("Excluído");
			}

		} else if (tipo.equals("propriedade")) {
			objJsonArray = listaAplicacao();
			out.print(objJsonArray);
		} else {

			// recebe o resto dos paramentros
			Integer codHistoricoMedicacao = Integer.parseInt(request.getParameter("codHistoricoMedicacao"));
			Integer codGado = Integer.parseInt(request.getParameter("codGado"));
			Integer codPessoa = Integer.parseInt(request.getParameter("codPessoa"));
			Integer codMedicamento = Integer.parseInt(request.getParameter("codMedicamento"));
			String loteMedicamento = request.getParameter("loteMedicamento");
			String observacao = request.getParameter("observacao");
			String dataMedicacao = request.getParameter("dataMedicacao");
			BigDecimal dosagemMg = new BigDecimal("111");
			MedicamentoGado medicamentoGado = new MedicamentoGado();

			// DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			// try {

			// Date dateVal = (Date) formatter.parse(dataMedicacao);
			// Date dateEncerramento =
			// (Date)formatter.parse(dataEncerramento);

			medicamentoGado.setCodHistoricoMedicacao(codHistoricoMedicacao);
			medicamentoGado.setCodGado(codGado);
			medicamentoGado.setCodPessoa(codPessoa);
			medicamentoGado.setCodMedicamento(codMedicamento);
			medicamentoGado.setLoteMedicamento(loteMedicamento);
			medicamentoGado.setObservacao(observacao);
			medicamentoGado.setDataMedicacao(new Date());
			medicamentoGado.setDosagemMg(dosagemMg);
			//
			// } catch (ParseException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			MedicamentoGadoDAO medicamentoGadoDao = new MedicamentoGadoDAO(HibernateUtil.getSessionFactory(),
					medicamentoGado.getClass());
			if (tipo.equals("salvar")) {
				medicamentoGadoDao.Salvar(medicamentoGado);
			} else if (tipo.equals("alterar")) {
				medicamentoGadoDao.Update(medicamentoGado);
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/aplicacaoDashboard.jsp").forward(request, response);
		}
	}

	public JSONArray listaAplicacao() {
		System.out.println("chegou");

		MedicamentoGado medicamentoGado = new MedicamentoGado();
		JSONArray objJsonArray = new JSONArray();

		MedicamentoGadoDAO medicamentoGadoDao = new MedicamentoGadoDAO(HibernateUtil.getSessionFactory(),
				medicamentoGado.getClass());
		List list = medicamentoGadoDao.Listar();
		for (int i = 0; i < list.size(); i++) {

			MedicamentoGado medicamento = new MedicamentoGado();
			JSONObject objJsonLote = new JSONObject();
			medicamento = (MedicamentoGado) list.get(i);
			// lot.getCodProduto();
			objJsonLote.put("codHistoricoMedicacao", medicamento.getCodHistoricoMedicacao());
			objJsonLote.put("codGado", medicamento.getCodGado());
			objJsonLote.put("codPessoa", medicamento.getCodPessoa());
			objJsonLote.put("codMedicamento", medicamento.getCodMedicamento());
			objJsonLote.put("loteMedicamento", medicamento.getLoteMedicamento());
			objJsonLote.put("dataMedicacao", medicamento.getDataMedicacao());
			objJsonLote.put("observacao", medicamento.getObservacao());
			objJsonLote.put("dosagemMg", medicamento.getDosagemMg());
			// objJsonLote.put("descricao", lot.getDescricaoLote());

			objJsonArray.put(objJsonLote);
		}

		return objJsonArray;

		// monatar o json e enviar para a tela

	}

	public JSONObject dadosAplicacao(int codHistoricoMedicacao) {
		System.out.println("dadosAplicacao");

		MedicamentoGado medicamentoGado = new MedicamentoGado();
		JSONObject objJsonLote = new JSONObject();

		MedicamentoGadoDAO medicamentoGadoDao = new MedicamentoGadoDAO(HibernateUtil.getSessionFactory(),
				medicamentoGado.getClass());

		// ProdutoAlimenticio prod = new ProdutoAlimenticio();
		medicamentoGado = medicamentoGadoDao.Carregar(codHistoricoMedicacao);
		objJsonLote.put("codHistoricoMedicacao", medicamentoGado.getCodHistoricoMedicacao());
		objJsonLote.put("codGado", medicamentoGado.getCodGado());
		objJsonLote.put("codPessoa", medicamentoGado.getCodPessoa());
		objJsonLote.put("codMedicamento", medicamentoGado.getCodMedicamento());
		objJsonLote.put("loteMedicamento", medicamentoGado.getLoteMedicamento());
		objJsonLote.put("dataMedicacao", medicamentoGado.getDataMedicacao());
		objJsonLote.put("observacao", medicamentoGado.getObservacao());
		objJsonLote.put("dosagemMg", medicamentoGado.getDosagemMg());

		return objJsonLote;
	}

	public JSONArray listaGado() {
		Gado objProp = new Gado();
		JSONArray objJsonArray = new JSONArray();
		GadoDAO propDao = new GadoDAO(HibernateUtil.getSessionFactory(), objProp.getClass());
		List list = propDao.Listar();
		for (int i = 0; i < list.size(); i++) {
			Gado prop = new Gado();
			JSONObject objJsonLote = new JSONObject();
			prop = (Gado) list.get(i);

			objJsonLote.put("codGado", prop.getCodGado());

			// Gado objPessoa = new Gado();
			// GadoDAO pessoaDao = new
			// GadoDAO(HibernateUtil.getSessionFactory(), objPessoa.getClass());
			// Gado pessoa = new Gado();
			// pessoa = pessoaDao.Carregar(prop.getCodGado());
			objJsonLote.put("codSisbov", prop.getCodSisbov());

			// objJsonLote.put("numIncra", prop.get));
			objJsonArray.put(objJsonLote);
		}

		return objJsonArray;
	}

	public JSONArray listaPessoa() {
		Pessoa objProp = new Pessoa();
		JSONArray objJsonArray = new JSONArray();
		PessoaDAO propDao = new PessoaDAO(HibernateUtil.getSessionFactory(), objProp.getClass());
		List list = propDao.Listar();
		for (int i = 0; i < list.size(); i++) {
			Pessoa prop = new Pessoa();
			JSONObject objJsonLote = new JSONObject();
			prop = (Pessoa) list.get(i);

			objJsonLote.put("codPessoa", prop.getCodPessoa());

			// Pessoa objPessoa = new Pessoa();
			// PessoaDAO pessoaDao = new
			// PessoaDAO(HibernateUtil.getSessionFactory(),
			// objPessoa.getClass());
			Pessoa pessoa = new Pessoa();
			// pessoa = pessoaDao.Carregar(prop.getCodPessoa());
			objJsonLote.put("nomePessoa", prop.getNomePessoa());

			// objJsonLote.put("numIncra", prop.get));
			objJsonArray.put(objJsonLote);
		}

		return objJsonArray;
	}

	public JSONArray listaMedicamento() {
		Medicamento objProp = new Medicamento();
		JSONArray objJsonArray = new JSONArray();
		MedicamentoDAO propDao = new MedicamentoDAO(HibernateUtil.getSessionFactory(), objProp.getClass());
		List list = propDao.Listar();
		for (int i = 0; i < list.size(); i++) {
			Medicamento prop = new Medicamento();
			JSONObject objJsonLote = new JSONObject();
			prop = (Medicamento) list.get(i);

			objJsonLote.put("codMedicamento", prop.getCodMedicamento());

			// Pessoa objPessoa = new Pessoa();
			// PessoaDAO pessoaDao = new
			// PessoaDAO(HibernateUtil.getSessionFactory(),
			// objPessoa.getClass());
			// Pessoa pessoa = new Pessoa();
			// pessoa = pessoaDao.Carregar(prop.getCodPessoa());
			objJsonLote.put("nomeMedicamento", prop.getNomeMedicamento());

			// objJsonLote.put("numIncra", prop.get));
			objJsonArray.put(objJsonLote);
		}

		return objJsonArray;
	}

}
