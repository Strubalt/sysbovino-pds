<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saúde animal</title>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">

<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/purl.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		listaAplicacao();
	});

	function listaAplicacao() {
		$
				.ajax({
					type : "post",
					data : {
						tipoFlag : "listar"
					},
					url : "AplicacaoController",
					success : function(result) {
						var linhas = "";
						for (var i = 0, length = result.length; i < length; i++) {
							var re = result[i];
							linhas += "<tr>" 
									+ "<th>"+ re.codHistoricoMedicacao+ "</th>"
									+ "<th>"+ re.codGado+ "</th>"
									+ "<th>"+ re.codPessoa+ "</th>"
									+ "<th>"+ re.codMedicamento+ "</th>"
									+ "<th>"+ re.loteMedicamento+ "</th>"
									+ "<th>"+ re.dataMedicacao+ "</th>"
									+ "<th>"+ re.oservacao+ "</th>"
									+ "<th>"+ re.dosagem+ "</th>"
									+ "<th><a href='aplicacaoCadastro.jsp?tipo=1&codHistoricoMedicacao="
									+ re.codHistoricoMedicacao
									+ "'>Alterar</a></th>"
									+ "<th><a href='javascript:void(0);' onclick='excluirAplicacao("
									+ re.codHistoricoMedicacao
									+ ")'>Excluir</a></th>" + "</tr>";
						}
						var divCorpo = document.getElementById("linhaTabela");
						divCorpo.innerHTML = linhas;
					},
					error : function() {
						alert("Ocorreu um erro na requisição ajax");
					}
				});
	}
	function excluirAplicacao(codHistoricoMedicacao) {

		$.ajax({
			type : "post",
			data : {
				tipoFlag : "excluir",
				codMedicamento : codHistoricoMedicacao
			},
			url : "aplicacaoController",
			success : function(result) {
				alert(result);
			}
		});
		location.reload(true);
	}
</script>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Aplicacao</h1>
		</div>

		<div class="col-sm-12">
			<div class="col-sm-3">
				<div class="list-group">
					<a href="aplicacaoCadastro.jsp" class="list-group-item">Nova
						Aplicacao</a>
				</div>
			</div>

			<div class="col-sm-9" style="border: 0px; height: 250px;">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Cod Historico</th>
							<th>Cod Gado</th>
							<th>Cod Pessoa</th>
							<th>Cod Medicamento</th>
							<th>Lote Medicamento</th>
							<th>Data Medicacao</th>
							<th>Observacao</th>
							<th>Dosagem</th>
						</tr>
					</thead>
					<tbody id="linhaTabela">

					</tbody>
				</table>
			</div>
			<hr>

		</div>

	</div>
</body>
</html>