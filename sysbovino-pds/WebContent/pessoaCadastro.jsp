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

<title>Mastrinder - Cadastro de Pessoas</title>
<script type="text/javascript">
	function enviar(){
		//Estou pegando as informaçoes do formulário
		var codigo = $("#codigo").val();//document.getElementById("codigo").value;
		var nome = $("#nome").val();//document.getElementById("nome").value;
		var cidade = $("#cidade").val(); //document.getElementById("cidade").value;
		var endereco = $("#endereco").val(); //document.getElementById("endereco").value;
		var fone = $("#fone").val(); //document.getElementById("fone").value;
		var nascimento = $("#nascimento").val(); //document.getElementById("nascimento").value;
		var email = $("#email").val(); //document.getElementById("email").value;
		
		//para conferir que as informações estão vindo como certo
		//var re = codigo + lote + raca
		alert(codigo);
		//também pode textar indivudualmente
		//alert(text);
		
		//vamos criar a ajax para enviar e receber os dados do controller
		$.ajax({
			//tipo de envio vai ser post
			type:"POST",
			//os dados que vamos enviar sendo o nome da variavel aqui e o nome que vai ser chamado pelo controller
			data:{codigo:codigo,  nome:nome, cidade:cidade, endereco:endereco, fone:fone, nascimento:nascimento, email:email},
			//dataType: "json",
			//endereco do controller
			url:"exemploController",
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
	 <div class="page-header"><h1>Cadastro de Pessoas</h1></div> 
	<div class="col-md-6 col-sm-6">
	  <form class="form-horizontal" role="form">
	    <div class="form-group">
	      <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Código:</label>
	      <div class="col-sm-5">          
	        <input type="text" class="form-control" id="codigo" placeholder="">
	      </div>
	      </div>
	      <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Nome:</label>
	      <div class="col-sm-5">          
	        <input type="text" class="form-control" id="nome" placeholder="">
	      </div>
	      </div>
	      <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Cidade:</label>
	      <div class="col-sm-5">          
	        <select id="cidade" class="form-control"> <!-- select -->
          		<option>option 1</option> 	<!-- option são exemplos, vão ser populados confirmações do BD -->
          		<option>option 2</option>
          		<option>option 3</option>
          		<option>option 4</option>
          		<option>option 5</option>
        	</select>
	      </div>
	      </div>	      
	      <label class="control-label col-sm-4" for="codigo">Endereço:</label>
	      <div class="col-sm-5">
	        <input type="text" class="form-control" id="endereco" placeholder="">
	      </div>
	    </div>
		<div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Fone: </label>
	      <div class="col-sm-5">          
	        <input type="text" class="form-control" id="fone" placeholder="">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Nascimento: </label>
	      <div class="col-sm-5">          
	       <input type="text" class="form-control" id="nascimento" placeholder="">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Email: </label>
	      <div class="col-sm-5">          
	       <input type="text" class="form-control" id="email" placeholder="">
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