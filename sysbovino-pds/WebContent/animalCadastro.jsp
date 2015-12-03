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
  	<script>
  	$('.datepicker').datepicker({
  	    format: 'mm/dd/yyyy',
  	})
  	</script>

<style type="text/css">
	body{
	background-color: #F4FFFA;
	}
	
	</style>

<title>Mastrinder - Cadastro de Animal</title>

<script type="text/javascript">
	function enviar(){
		//Estou pegando as informaçoes do formulário
		var codigo = $("#codigo").val();//document.getElementById("codigo").value;
		var lote = $("#lote").val();//document.getElementById("lote").value;
		var raca = $("#raca").val(); //document.getElementById("raca").value;
		var dataNascimento = $("#dataNascimento").val(); //document.getElementById("dataPesagem").value;
		var peso = $("#peso").val(); //document.getElementById("peso").value;
		var dataPesagem = $("#dataPesagem").val(); //document.getElementById("dataPesagem").value;
		var racaPai = $("#racaPai").val(); //document.getElementById("racaPai").value;
		var racaMae = $("#racaMae").val(); //document.getElementById("racaMae").value;
		var sexualidade = $("#sexualidade").val();
		var observacoes = $("#observacoes").val(); //document.getElementById("observacoes").value;
		
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
			data:{codigo:codigo,  lote:lote, dataNascimento:dataNascimento, raca:raca, peso:peso, dataPesagem:dataPesagem, racaPai:racaPai, racaMae:racaMae, observacoes:observacoes},
			//dataType: "json",
			//endereco do controller
			url:"GadoController",
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
	<div class="page-header"><h1>Cadastro de Animal</h1></div> 
	
	  <form class="form-horizontal" role="form">
	    <div class="form-group">
	      <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Código:</label>
	      <div class="col-sm-5">          
	        <input type="text" class="form-control" id="codigo" placeholder="">
	      </div>
	      </div>
	      <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Lote:</label>
	      <div class="col-sm-5">          
	        <select id="lote" class="form-control"> <!-- select -->
          		<option value="1">option 1</option> 	<!-- option são exemplos, vão ser populados confirmações do BD -->
          		<option value="2">option 2</option>
          		<option value="3">option 3</option>
          		<option value="4">option 4</option>
          		<option value="5">option 5</option>
        	</select>
	      </div>
	      </div>
	      <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Raça:</label>
	        <div class="col-sm-5">          
	        <select id="raca" class="form-control"> <!-- select -->
          		<option value="1">option 1</option> 	<!-- option são exemplos, vão ser populados confirmações do BD -->
          		<option value="2">option 2</option>
          		<option value="3">option 3</option>
          		<option value="4">option 4</option>
          		<option value="5">option 5</option>
        	</select>
	        </div>
	      </div>
		<div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Data Nascimento: </label>
	      <div class="col-sm-5">          
	        <input class="form-control" id="dataNascimento" placeholder="">
	      </div>
	    </div>
	      <div class="form-group">
	      <label class="control-label col-sm-4" for="codigo">Peso:</label>
	        <div class="col-sm-5">
	        <input type="text" class="form-control" id="peso" placeholder="">
	        </div>
	      </div>
		<div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Data de Pesagem: </label>
	      <div class="col-sm-5">          
	        <input type="text" class="form-control" id="dataPesagem" placeholder="">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Raça do Pai:</label>
	      <div class="col-sm-5">          
	        <select id="racaPai" class="form-control"> <!-- select -->
          		<option value="1">option 1</option> 	<!-- option são exemplos, vão ser populados confirmações do BD -->
          		<option value="2">option 2</option>
          		<option value="3">option 3</option>
          		<option value="4">option 4</option>
          		<option value="5">option 5</option>
        	</select>
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Raça da Mãe:</label>
	      <div class="col-sm-5">          
	        <select id="racaMae" class="form-control"> <!-- select -->
          		<option value="1">option 1</option> 	<!-- option são exemplos, vão ser populados confirmações do BD -->
          		<option value="2">option 2</option>
          		<option value="3">option 3</option>
          		<option value="4">option 4</option>
          		<option value="5">option 5</option>
        	</select>
	      </div>
	    </div>
	  
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Sexualidade:</label>
	      <div class="col-sm-5">          
	        <select id="racaMae" class="form-control"> <!-- select -->
         		<option value="M">Macho</option> 	<!-- option são exemplos, vão ser populados confirmações do BD -->
         		<option value="F">Fêmea</option>
        	</select>
	      </div>
	    </div>
	  
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="pwd">Observações: </label>
	      <div class="col-sm-5">          
	        <textarea class="form-control" rows="4" id="observacoes"></textarea>
	      </div>
	    </div>
	    
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default"; onclick="enviar()"; return false;>Salvar</button>
	        <button type="button" class="btn btn-danger"; onclick="location.href='animalDashboard.jsp';">Cancelar</button>
	      </div>
	    </div>
	  </form>
	
</div> <!-- fim container principal -->
</body>
</html>