<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">

<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/purl.js"></script>

<title>Mastrinder - Aplicação de Medicamento</title>

<style type="text/css">
body {
	background-color: #FFFAF3;
}
</style>

<script type="text/javascript">
	var tipoFlag = "salvar";
	$(document).ready(function() {
		//necessário purl.js
		//pega o parametros da url
		var url = $.url();
		var tipo = url.param('tipo');
		var codHistoricoMedicacao = url.param('codHistoricoMedicacao');

		if (tipo != null) {
			carregaCompos(codHistoricoMedicacao);
			tipoFlag = "alterar";
		}

		//Usado no datetimepicker
		$("#datePickerMedicacao").datetimepicker({
			language : 'pt-BR',
			pickTime : false
		//não aparecer a hora
		});

		populaPessoa();
		populaMedicamento();
		populaGado();
	});

	function enviar() {//Estou pegando as informaçoes do formulário
		var codHistoricoMedicacao = $("#codHistoricoMedicacao").val();//document.getElementById("identificacaoQualquer").value;
		var codGado = $("#gado").val();//document.getElementById("opcao").value;
		var codPessoa = $("#pessoa").val(); //document.getElementById("comment").value;
		var codMedicamento = $("#medicamento").val();
		var loteMedicamento = $("#loteMedicamento").val();
		var dataMedicacao = $("#datePickerMedicacao").val();
		var observacao = $("#observacao").val();
		var dosagem = $("#dosagem").val();

		//vamos criar a ajax para enviar e receber os dados do controller
		$.ajax({
			type : "POST",
			data : {
				tipoFlag : tipoFlag,
				codHistoricoMedicacao : codHistoricoMedicacao,
				codGado : codGado,
				codPessoa : codPessoa,
				codMedicamento : codMedicamento,
				loteMedicamento : loteMedicamento,
				dataMedicacao : dataMedicacao,
				observacao : observacao,
				dosagem : dosagem
			},
			url : "AplicacaoController",
			success : function(result) {

			}

		});
		location.href='AplicacaoDashboard.jsp';
	}

	function carregaCompos(codHistoricoMedicacao) {

		$.ajax({
			type : "post",
			data : {
				tipoFlag : "dadosAplicacao",
				codHistoricoMedicacao : codHistoricoMedicacao
			},
			dataType : "json",
			url : "AplicacaoController",
			success : function(result) {
				$("#codHistoricoMedicacao").val(result.codHistoricoMedicacao);
				$("#gado").val(result.codGado);
				$("#pessoa").val(result.codPessoa);
				$("#medicamento").val(result.codMedicamento);
				$("#loteMedicamento").val(result.loteMedicamento);
				$("#datePickerMedicacao").val(result.dataMedicacao);
				$("#observacao").val(result.observacao);
				$("#dosagem").val(result.dosagem);
				
			}
		});
	}
	function populaMedicamento() {
		$.ajax({
			type : "post",
			data : {
				tipoFlag : "medicamento"
			},
			dataType : "json",
			url : "AplicacaoController",
			success : function(result) {
				var linhas = "";
				for (var i = 0, length = result.length; i < length; i++) {
					var re = result[i];
					linhas += "<option value='"+re.codMedicamento+"'>"
							+ re.codMedicamento + " - " + re.nomeMedicamento
							+ "</option>";
				}
				var divCorpo = document.getElementById("medicamento");
				divCorpo.innerHTML = linhas;
			}
		});
	}

	function populaPessoa() {
		$.ajax({
			type : "post",
			data : {
				tipoFlag : "pessoa"
			},
			dataType : "json",
			url : "AplicacaoController",
			success : function(result) {
				var linhas = "";
				for (var i = 0, length = result.length; i < length; i++) {
					var re = result[i];
					linhas += "<option value='"+re.codPessoa+"'>"+ re.codPessoa + " - " + re.nomePessoa
							+ "</option>";
				}
				var divCorpo = document.getElementById("pessoa");
				divCorpo.innerHTML = linhas;
			}
		});
	}

	function populaGado() {
		$.ajax({
			type : "post",
			data : {
				tipoFlag : "gado"
			},
			dataType : "json",
			url : "AplicacaoController",
			success : function(result) {
				var linhas = "";
				for (var i = 0, length = result.length; i < length; i++) {
					var re = result[i];
					linhas += "<option value='"+re.codGado+"'>" + re.codGado
							+ " - " + re.codSisbov + "</option>";
				}
				var divCorpo = document.getElementById("gado");
				divCorpo.innerHTML = linhas;
			}
		});
	}
</script>
</head>
<body>
	<div class="container">

		<div class="page-header">
			<h1>Aplicação de medicamentos</h1>
		</div>

		<form class="form-horizontal" role="form">

			<div class="form-group">
				<label class="control-label col-sm-2" for="codigo">Codigo
					Historico Medicação:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="codHistoricoMedicacao"
						placeholder="potenay">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="gado">Codido do
					gado:</label>
				<div class="col-sm-10">
					<select id="gado" class="form-control">
						<!-- select -->

					</select>
				</div>
			</div>



			<div class="form-group">
				<label class="control-label col-sm-2" for="pessoa">Codigo
					Pessoa:</label>
				<div class="col-sm-10">
					<select id="pessoa" class="form-control">
						<!-- select -->

					</select>
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-2" for="medicamento">Codigo Medicamento:</label>
				<div class="col-sm-10">
					<select id="medicamento" class="form-control">
						<!-- select -->

					</select>
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Lote
					Medicamento:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="loteMedicamento"
						placeholder="DWWE33242">
				</div>
			</div>

			<div class="form-group ">
				<label class="control-label col-sm-2" for="dataMedicacao">Data medicacao:</label>
				<div class="col-sm-10">
					<div class="input-append" id="datePickerMedicacao">
						<input type="text" class="form-control" id="dataMedicacao" placeholder="dd/mm/aaaa" data-format="dd-MM-yyyy">
						
					</div>
				</div>
			</div>
	

	<div class="form-group">
		<label class="control-label col-sm-2" for="pwd">Observacao:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="observacao"
				placeholder="DWWE33242">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="pwd">Dosagem:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control col-sm-10" id="dosagem"
				placeholder="DWWE33242">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-12">
			<input type="button" class="btn btn-default" ; onclick="enviar()"; return false;" value="Salvar">
			<button type="button" class="btn btn-danger"
				onclick="location.href='AplicacaoDashboard.jsp';">Cancelar</button>
		</div>
	</div>
	</form>
	</div>

	<!-- fim container principal -->
</body>
</html>