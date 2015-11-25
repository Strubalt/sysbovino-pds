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

<title>Mastrinder - Cadastro de Alimento</title>

 	
<script type="text/javascript">
var tipoFlag = "salvar";
$(document).ready ( function(){
	  //necessário purl.js
	  //pega o parametros da url
	   var url = $.url();
	   var tipo = url.param('tipo');
	   var codProduto = url.param('codProduto');
	   
	   if(tipo != null){	
		   carregaCompos(codProduto);
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
	var codigo = $("#codProduto").val();//document.getElementById("codigo").value;
	var fornecedora = $("#fornecedora").val();//document.getElementById("fornecedora").value;
	var nomeProduto = $("#nomeProduto").val(); //document.getElementById("nomeProduto").value;
	var composicao = $("#composicao").val(); //document.getElementById("composicao").value;
	var dataValidade = $("#dataValidade").val(); //document.getElementById("comment").value;
	
	
	//vamos criar a ajax para enviar e receber os dados do controller
	$.ajax({
		type:"POST",
		data:{tipoFlag:tipoFlag, 
			codProduto:codProduto,  
				fornecedora:fornecedora, 
				nomeProduto:nomeProduto, 
				composicao:composicao,
				dataValidade:dataValidade},
		url:"AlimentacaoController",
		success: function(result){
			
		}
	});
}

function carregaCompos(codProduto){
	
	$.ajax({
		type:"post",
		data:{tipoFlag:"dadosProduto",codProduto:codProduto},
		dataType: "json",
		url:"AlimentacaoController",
		success: function(result){
			$("#codProduto").val(result.codProduto);
			$("#fornecedora").val(result.codPessoa);
			$("#dataValidade").val(result.dataValidade);
			$("#composicao").val(result.observacao);
			$("#nomeProduto").val(result.nomeProduto);
		}
	});
}
</script>
</head>
<body>

<!-- container principal -->
<div class="container">
	 <div class="page-header"><h1>Cadastro de Alimento</h1></div> 
	<div class="col-md-6 col-sm-6">
	  <form class="form-horizontal" role="form">
	    <div class="form-group">
	      <div class="form-group">
	      <label class="control-label col-sm-2" for="pwd"> Código:</label>
	      <div class="col-sm-8">          
	        <input type="text" class="form-control" id="codigo" placeholder="">
	      </div>
	      </div>
	      <br/>
	      <label class="control-label col-sm-2" for="codigo">Fornecedora: </label>
	      <div class="col-sm-8">
	        <input type="text" class="form-control" id="fornecedora" placeholder="">
	      </div>
	    </div>
	  <br/>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="pwd">Nome do Produto:</label>
	      <div class="col-sm-8">          
	        <input type="text" class="form-control" id="nomeProduto" placeholder="">
	      </div>
	    </div>
	    <br/>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="pwd">Composição: </label>
	      <div class="col-sm-8">
	        <textarea class="form-control" rows="5" id="composicao"></textarea>          
	      </div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="data">Data Validade:</label>
	      <div class="col-sm-10">
		      <div class="input-append" id="dateValidade">
		       <span class="add-on">
		        <input type="text" class="form-control" id="dataCriacao" placeholder="dd/mm/aaaa" data-format="dd-MM-yyyy"></input>
			    </span>
		      </div>
		    </div>
		  </div>
	    <br/>
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default"; onclick="enviar()"; return false;>Salvar</button>
	        <button type="button" class="btn btn-danger">Cancelar</button>
	      </div>
	    </div>
	  </form>
	</div>
</div> <!-- fim container principal -->
</body>
</html>