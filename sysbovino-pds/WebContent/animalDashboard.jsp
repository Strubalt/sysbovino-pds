<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lote</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
  	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/purl.js"></script>
	<script>
	  	$('.datepicker').datepicker({
	  	    format: 'mm/dd/yyyy',
	  	})
  	</script>
	<script type="text/javascript">
	$(document).ready ( function(){
		listaGado();
	});	
	
	function listaGado(){
		$.ajax({
			type:"post",
			data:{tipoFlag:"listar"},
			url:"GadoController",
			success: function(result){
				var linhas = "";  
		          for (var i = 0, length = result.length; i < length; i++) {  
                     var re = result[i];  
                     linhas += "<tr>"+  
                               "<th>"+re.codGado+"</th>"+
                               "<th>"+re.codRaca+"</th>"+
                               "<th>"+re.dataNascimento+"</th>"+
                               "<th>"+re.localNascimento+"</th>"+
                               "<th>"+re.observacao+"</th>"+
                               "<th>"+re.codSisbov+"</th>"+
                               "<th>"+re.racaPai+"</th>"+
                               "<th>"+re.racaMae+"</th>"+
                               "<th>"+re.procedencia+"</th>"+
                               "<th>"+re.status+"</th>"+
                               "<th>"+re.sexo+"</th>"+
                               "<th><a href='animalCadastro.jsp?tipo=1&gado="+re.codGado+"'>Alterar</a></th>"+
                               "<th><a href='#' onclick='excluirGado("+re.codGado+")'>Excluir</a></th>"+
                          "</tr>";                                     
	       }      
	       var divCorpo = document.getElementById("linhaTabela");  
	       divCorpo.innerHTML=linhas;  
	     },  
	     error: function() {  
	       alert("Ocorreu um erro na requisição ajax");  
	     }  
		});
	}
	

	function excluirGado(codGado){
		$.ajax({
			type:"post",
			data:{tipoFlag:"excluir",codGado:codGado},
			dataType: "json",
			url:"GadoController",
			success: function(result){
				alert(result);
			}
		});
	}
	</script>
<style type="text/css">
	body{
	background-color: #F4FFFA;
	}
	
	</style>

</head>
<body>

<div class="container">
	<div class="page-header"><h1>Bovino</h1></div>
	
	<div class="col-sm-12">
		<div class="col-sm-3">
			<div class="list-group">
			  <a href="animalCadastro.jsp" class="list-group-item">Novo Bovino</a>
			</div>
		</div>
		
		<div class="col-sm-9">
			<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Codigo</th>
		        <th>Raça</th>
		        <th>Idade</th>
		        <th>Local Nascimento</th>
		        <th>Observacao</th>
		        <th>Cód. SISBOV</th>
		        <th>Raça Pai</th>
		        <th>Raça Mãe</th>
		        <th>Flag Procedência</th>
		        <th>Flag Status</th>
		        <th>Sexualidade</th>
		      </tr>
		    </thead>
		    <tbody id="linhaTabela">
		    </tbody>
		  </table>
		</div>
		
	</div>
	
</div>

</body>
</html>