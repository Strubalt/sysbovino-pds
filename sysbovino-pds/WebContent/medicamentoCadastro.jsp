<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- bootstrap -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
  	
  	<script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
  	<script src="js/bootstrap-datetimepicker.min.js"></script>
  	<script src="js/purl.js"></script>

<title>Mastrinder - Cadastro de Medicamento</title>

<style type="text/css">
	body{
	background-color: #FFFAF3;
	}
	
	</style>
 	
<script type="text/javascript">
var tipoFlag = "salvar";
$(document).ready ( function(){
	  //necessário purl.js
	  //pega o parametros da url
	   var url = $.url();
	   var tipo = url.param('tipo');
	   var codMedicamento = url.param('codMedicamento');
	   
	   if(tipo != null){	
		   carregaCompos(codMedicamento);
		   tipoFlag = "alterar";
	   }
	   
	   //Usado no datetimepicker
        $("#dateValidade").datetimepicker({
        	language: 'pt-BR',
        	pickTime: false //não aparecer a hora
        });

        
        //populaPropriedade();
	});

function enviar(){
	//Estou pegando as informaçoes do formulário
	var codMedicamento = $("#codMedicamento").val();//document.getElementById("codigo").value;
	var nomeMedicamento = $("#nomeMedicamento").val();//document.getElementById("fornecedora").value;
	
	
	//vamos criar a ajax para enviar e receber os dados do controller
	$.ajax({
		type:"POST",
		data:{tipoFlag:tipoFlag, 
			codMedicamento:codMedicamento,  
			nomeMedicamento:nomeMedicamento},
		url:"MedicamentoController",
		success: function(result){
			//alert(result.length);
			//$("#resultado").html(result);
		}
	});
	location.href='medicamentoDashboard.jsp';
}

function carregaCompos(codMedicamento){
	
	$.ajax({
		type:"post",
		data:{tipoFlag:"dadosMedicamento",codMedicamento:codMedicamento},
		dataType: "json",
		url:"MedicamentoController",
		success: function(result){
			$("#codMedicamento").val(result.codMedicamento);
			$("#nomeMedicamento").val(result.nomeMedicamento);
		}
	});
}
</script>
</head>
<body>
	<div class="container">
	
		 <div class="page-header"><h1>Cadastro de Medicamento</h1></div> 
		 
		 <form class="form-horizontal" role="form">
		 
		 <div class="form-group">
		 <label class="control-label col-sm-2" for="codigo">Codigo Medicamento:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="codMedicamento"  readonly="true" placeholder="Gerado pelo Sistema">
	      </div>
	    </div>
	  
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="pwd">Nome medicamento:</label>
	      <div class="col-sm-10">          
	        <input type="text" class="form-control" id="nomeMedicamento" placeholder="DWWE33242">
	      </div>
	    </div>
	    
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	      <input type="button" class="btn btn-default"; onclick="enviar()"; return false;" value="Salvar">
	        <button type="button"  class="btn btn-danger" onclick="location.href='medicamentoDashboard.jsp';">Cancelar</button>
	      </div>
	    </div>
	  </form>
	</div>
</div> <!-- fim container principal -->
</body>
</html>