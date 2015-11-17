<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- bootstrap -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
  	<script src="js/jquery.js"></script>
  	<script src="js/bootstrap.min.js"></script>

<title>Mastrinder - Cadastro de Alimento</title>

<script type="text/javascript">
	function enviar(){
		//Estou pegando as informaçoes do formulário
		var codigo = $("#codigo").val();//document.getElementById("codigo").value;
		var fornecedora = $("#fornecedora").val();//document.getElementById("fornecedora").value;
		var nomeProduto = $("#nomeProduto").val(); //document.getElementById("nomeProduto").value;
		var composicao = $("#composicao").val(); //document.getElementById("composicao").value;
		
		
		//para conferir que as informações estão vindo como certo
		//var re = codigo + lote + raca
		//alert(codigo);
		//também pode textar indivudualmente
		//alert(text);
		
		//vamos criar a ajax para enviar e receber os dados do controller
		$.ajax({
			//tipo de envio vai ser post
			type:"POST",
			//os dados que vamos enviar sendo o nome da variavel aqui e o nome que vai ser chamado pelo controller
			data:{codigo:codigo,  fornecedora:fornecedora, nomeProduto:nomeProduto, composicao:composicao},
			//dataType: "json",
			//endereco do controller
			url:"AlimentacaoController",
			//sucess indica que tudo deu certo e recebou um retorno.
			success: function(result){
				alert(result.length);
				$("#resultado").html(result);
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