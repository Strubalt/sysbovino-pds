<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saúde animal</title>
	<!-- bootstrap -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
  	
  	<script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
  	<script src="js/bootstrap-datetimepicker.min.js"></script>
  	<script src="js/purl.js"></script>

<script type="text/javascript">
$(document).ready ( function(){
	  listaMedicamentos();
	});
	
function listaMedicamentos(){
	$.ajax({
		type:"post",
		data:{tipoFlag:"listar"},
		url:"MedicamentoController",
		success: function(result){
			var linhas = "";  
	          for (var i = 0, length = result.length; i < length; i++) {  
                     var re = result[i];  
                     linhas += "<tr>"+  
                                    "<th>"+re.codMedicamento+"</th>"+
                                    "<th>"+re.nomeMedicamento+"</th>"+
                                    "<th><a href='medicamentoCadastro.jsp?tipo=1&codMedicamento="+re.codMedicamento+"'>Alterar</a></th>"+
                                    "<th><a href='javascript:void(0);' onclick='excluirMedicamento("+re.codMedicamento+")'>Excluir</a></th>"+
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
function excluirMedicamento(codMedicamento){
	
}

</script>
</head>
<body>
<div class="container">
	<div class="page-header"><h1>Medicação</h1></div>
	
	<div class="col-sm-12">
		<div class="col-sm-3">
			<div class="list-group">
			  <a href="medicamentoCadastro.jsp" class="list-group-item">Novo Medicamento</a>
			  <a href="#" class="list-group-item">Nova Aplicação</a>
			</div>
		</div>
		
		<div class="col-sm-9" style=" border: 0px; height: 250px;">
			
			<ul class="nav nav-tabs">
			  <li class="active"><a href="#">Medicamentos</a></li>
			  <li><a href="#">Veterinários</a></li>
			  <li><a href="#">Aplicações</a></li>
			</ul>
			
			<table class="table table-striped" >
		    <thead>
		      <tr>
		        <th>Codigo</th>
		        <th>Medicamento</th>
		        <th></th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody id="linhaTabela">
		      
		    </tbody>
		  </table>
		</div>
		<hr>
		<div class="col-sm-9" >
			<table class="table table-striped" >
		    <thead>
		      <tr>
		        <th>Codigo</th>
		        <th>Medicamento</th>
		        <th></th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody id="fff">
		      <tr>
		      	<th>1</th>
		      	<th>1</th>
		      	<th></th>
		      	<th></th>
		      </tr>
		    </tbody>
		  </table>
		</div>
		
	</div>
	
</div>
</body>
</html>