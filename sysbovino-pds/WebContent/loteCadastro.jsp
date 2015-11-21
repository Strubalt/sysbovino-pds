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
  	
  	
<script type="text/javascript">
var tipoFlag = "salvar";
$(document).ready ( function(){
	  //necessário purl.js
	  //pega o parametros da url
	   var url = $.url();
	   var tipo = url.param('tipo');
	   var codLote = url.param('lote');
	   
	   if(tipo != null){	
		   carregaCompos(codLote);
		   tipoFlag = "alterar";
	   }
	   
        jQuery("#datePickerCriacao").datetimepicker({
        	language: 'pt-BR',
        	pickTime: false
        });
        populaPropriedade();
	});

function enviar(){
	//Estou pegando as informaçoes do formulário
	var codLote = $("#idLote").val();//document.getElementById("identificacaoQualquer").value;
	var descricaoLote = $("#descricao").val();//document.getElementById("opcao").value;
	var dataCricao = $("#dataCriacao").val(); //document.getElementById("comment").value;
	var codPropriedade = 1;
	//var dataCricao = $("#propriedade").val();
	
	
	//vamos criar a ajax para enviar e receber os dados do controller
	$.ajax({
		//tipo de envio vai ser post
		type:"POST",
		//os dados que vamos enviar sendo o nome da variavel aqui e o nome que vai ser chamado pelo controller
		data:{tipoFlag:tipoFlag, codLote:codLote,  descricaoLote:descricaoLote, dataCricao:dataCricao, codPropriedade:codPropriedade, dataCricao:dataCricao},
		//dataType: "json",
		//endereco do controller
		url:"LoteController",
		//sucess indica que tudo deu certo e recebou um retorno.
		success: function(result){
			
		}
	});
}

function carregaCompos(codLote){
	
	$.ajax({
		type:"post",
		data:{tipoFlag:"dadosLote",codLote:codLote},
		dataType: "json",
		url:"LoteController",
		success: function(result){
			$("#idLote").val(result.codLote);
			$("#descricao").val(result.descricao);
			$("#dataCriacao").val(result.dataCriacao);
			$("#dataEncerramento").val(result.dataCriacao);
			$("#propriedade").val(result.codPropriedade);
		}
	});
}

function populaPropriedade(){
	$.ajax({
		type:"post",
		data:{tipoFlag:"propriedade"},
		dataType: "json",
		url:"LoteController",
		success: function(result){
			var linhas = "";  
		        for (var i = 0, length = result.length; i < length; i++) {  
		            var re = result[i];  
		            linhas += "<option>"+re.codPropriedade+" - "+re.nomePessoa+"("+re.numIncra+")</option>";  
		                                                             
				}      
			var divCorpo = document.getElementById("propriedade");  
			divCorpo.innerHTML=linhas;  
		}
	});
}
</script>
</head>
<body>
	<div class="container">

		<div class="page-header"><h1>Cadastro de Lote</h1></div> 
	 
		<form class="form-horizontal" role="form"> 
	
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="codigo">Código:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="idLote" placeholder="01">
	      </div>
	    </div>
	  
	    <div class="form-group">	
	      <label class="control-label col-sm-2" for="descricao">Descrição:</label> <!-- tag <label> é apenas um espaço para colocar o nome do campo -->
	      <div class="col-sm-10">
	        <textarea class="form-control" rows="5" id="descricao" placeholder="teste"></textarea> <!-- textarea campo maior para mais informações-->
	      </div>
	    </div>
	  
	  <div class="form-group">
	      <label class="control-label col-sm-2" for="data">Data Criação:</label>
	      <div class="col-sm-10">
		      <div class="input-append" id="datePickerCriacao">
		       <span class="add-on">
		        <input type="text" class="form-control col-sm-10" id="dataCriacao" placeholder="dd/mm/aaaa" data-format="dd-MM-yyyy"></input>
			    </span>
		      </div>
		    </div>
		  </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="dataEnc">Data Encerramento:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="dataEncerramento" placeholder="21/10/2015">
	      </div>
	    </div>
	  
	   <div class="form-group">
      <label class="control-label col-sm-2" for="propriedade">Propriedade:</label>
      <div class="col-sm-10">
        <select id="propriedade" class="form-control"> <!-- select -->
          
        </select>
      </div>
    </div>
	      
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10" id="divBotoes">
	        <input type="button" class="btn btn-default"; onclick="enviar()"; return false;" value="Salvar">
	        <button type="button"  class="btn btn-danger" onclick="location.href='loteDashboard.jsp';">Cancelar</button>
	      </div>
	    </div>
	  </form>
	</div>
</div> <!-- fim container principal -->
</body>
</html>