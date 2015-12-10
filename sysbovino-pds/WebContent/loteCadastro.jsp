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

	<style type="text/css">
	body{
	background-color: #F8F7FF;
	}
	
	</style>
	
  	
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
		   $("#cadastrosFaseAlim").hide();
	   }
	   
	   //Usado no datetimepicker
        $("#datePickerCriacao").datetimepicker({
        	language: 'pt-BR',
        	pickTime: false //não aparecer a hora
        });

        $("#datePickerEncerramento").datetimepicker({
        	language: 'pt-BR',
        	pickTime: false
        });
        
        $("#datePickerIniFase").datetimepicker({
        	language: 'pt-BR',
        	pickTime: false //não aparecer a hora
        });
        
        $("#datePickerFimFase").datetimepicker({
        	language: 'pt-BR',
        	pickTime: false //não aparecer a hora
        });
        
        $("#datePickerIniAlim").datetimepicker({
        	language: 'pt-BR',
        	pickTime: false //não aparecer a hora
        });
        $("#datePickerFimAlim").datetimepicker({
        	language: 'pt-BR',
        	pickTime: false //não aparecer a hora
        });
        
        populaPropriedade();
        populaFase();
	});

function enviar(){
	//Estou pegando as informaçoes do formulário
	var codLote = $("#idLote").val();//document.getElementById("identificacaoQualquer").value;
	var descricaoLote = $("#descricao").val();//document.getElementById("opcao").value;
	var dataCricao = $("#dataCriacao").val(); //document.getElementById("comment").value;
	var codPropriedade = $("#propriedade").val();
	var dataEncerramento = $("#dataEncerramento").val();
	if(tipoFlag =="alterar"){
		var codFase = $("#fase").val();
		var dataIniFase = $("#dataIniFase").val();
		var dataFimFase = $("#dataFimFase").val();
		
		var codAlimentacao = $("#idAlimentacao").val();
		var dataInicio = $("#dataIniAlim").val();
		var dataFimPrev = $("#dataFimAlim").val();
		var pesoLote = $("#pesoLoteAlim").val();
	}
	//vamos criar a ajax para enviar e receber os dados do controller
	$.ajax({
		type:"post",
		dataType:"json",
		url:"LoteController",
		data:{tipoFlag:tipoFlag, 
				codLote:codLote,  
				descricaoLote:descricaoLote, 
				dataCricao:dataCricao, 
				codPropriedade:codPropriedade, 
				dataCricao:dataCricao, 
				dataEncerramento:dataEncerramento},
		//contentType: "application/json; charset=utf-8",
		complete: function (){
			alert("Completo");
		},
		
			
	});
	if(tipoFlag =="alterar"){
		enviaFase(codLote, codFase, dataIniFase, dataFimFase);
		enviaTipoAlimentacao(codLote, codAlimentacao, pesoLote, dataInicio, dataFimPrev);
	}
	//location.href='loteDashboard.jsp';
}

function enviaTipoAlimentacao(codLote, codAlimentacao, pesoLote, dataInicio, dataFimPrev){
	var item = 1;
	$.ajax({
		type:"POST",
		dataType:"JSON",
		data:{tipoFlag:tipoFlag, 
				codLote:codLote,  
				codAlimentacao:codAlimentacao,
				dataInicio:dataInicio,
				dataFimPrev:dataFimPrev,
				pesoLote:pesoLote,
				item:item},
		url:"LoteAlimentacaoController",
		success: function(result){
			
		}
			
	});
	
}

function enviaFase(codLote, codFase, dataIni, dataFim){
	var item = 1;
	$.ajax({
		type:"POST",
		dataType:"JSON",
		data:{tipoFlag:tipoFlag, 
				codLote:codLote,  
				codFase:codFase,
				dataIni:dataIni,
				dataFim:dataFim,
				item:item},
		url:"FaseLoteController",
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
		            linhas += "<option value='"+re.codPropriedade+"'>"+re.codPropriedade+" - "+re.nomePessoa+"("+re.numIncra+")</option>";                                            
				}      
			var divCorpo = document.getElementById("propriedade");  
			divCorpo.innerHTML=linhas;  
		}
	});
}

function populaFase(){
	$.ajax({
		type:"post",
		data:{tipoFlag:"populaFase"},
		dataType: "json",
		url:"FaseController",
		success: function(result){
			var linhas = "";  
		        for (var i = 0, length = result.length; i < length; i++) {  
		            var re = result[i];  
		            linhas += "<option value='"+re.codFase+"'>"+re.codFase+" - "+re.nomeFase+"</option>";                                            
				}      
			var divCorpo = document.getElementById("fase");  
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
		<div class="page"><h3>Lote</h3></div>
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
	    
	  <div class="row col-sm-12">
	   	<div class="form-group col-sm-6">
	      <label class="control-label col-sm-4" for="data">Data Criação:</label>
	      	<div class="col-sm-8">
		      <div class="input-append" id="datePickerCriacao">
		       <span class="add-on">
		        <input type="text" class="form-control" id="dataCriacao" placeholder="dd/mm/aaaa" data-format="dd-MM-yyyy"></input>
			    </span>
		      </div>
		    </div>
		  </div>
	    
	    <div class="form-group col-sm-6">
	      <label class="control-label col-sm-4" for="dataEnc">Data Encerramento:</label>
	      <div class="col-sm-8">
	      	<div class="input-append" id="datePickerEncerramento">
		       <span class="add-on">
	        		<input type="text" class="form-control" id="dataEncerramento" placeholder="dd/mm/aaaa" data-format="dd-MM-yyyy">
	        	</span>
		     </div>
	      </div>
	    </div>
	  </div>
	   <div class="form-group">
		      <label class="control-label col-sm-2" for="propriedade">Propriedade:</label>
		      <div class="col-sm-10">
		        <select id="propriedade" class="form-control"> <!-- select -->
		          
		        </select>
		      </div>
    	</div>
    	
    	<!-- ------------FASE ------------------ -->
    	<div id="cadastrosFaseAlim">
	      <hr>
			<div class="page"><h3>Fase</h3></div>	      
	        <div class="form-group">
		      <label class="control-label col-sm-2" >Fase:</label>
		      <div class="col-sm-8">
		        <select id="fase" class="form-control"> <!-- select -->
		          
		        </select>
		      </div>
		      
    	</div>
	   
	    
	     <div class="row col-sm-12">
	   	<div class="form-group col-sm-6">
	      <label class="control-label col-sm-4">Data inicio fase:</label>
	      	<div class="col-sm-8">
		      <div class="input-append" id="datePickerIniFase">
		       <span class="add-on">
		        <input type="text" class="form-control" id="dataIniFase" placeholder="dd/mm/aaaa" data-format="dd-MM-yyyy"></input>
			    </span>
		      </div>
		    </div>
		  </div>
	    
	    <div class="form-group col-sm-6">
	      <label class="control-label col-sm-4">Data fim fase:</label>
	      <div class="col-sm-8">
	      	<div class="input-append" id="datePickerFimFase">
		       <span class="add-on">
	        		<input type="text" class="form-control" id="dataFimFase" placeholder="dd/mm/aaaa" data-format="dd-MM-yyyy">
	        	</span>
		     </div>
	      </div>
	    </div>
	  </div>
	    <div class="form-group">
	    </div>
	    
	    <!-- ---------------------ALIMENTAÇÃO-------------- -->
	    <hr>
		<div class="page"><h3>Alimentacao</h3></div>
		<div class="row col-sm-12">
		    <div class="form-group col-sm-6">
		      <label class="control-label col-sm-4">Código Alimentação:</label>
		      <div class="col-sm-8">
		        <input type="text" class="form-control" id="idAlimentacao" placeholder="01">
		      </div>
		    </div>
		    <div class="form-group col-sm-6">
		      <label class="control-label col-sm-4">Peso Atual Lote:</label>
		      <div class="col-sm-8">
		        <input type="text" class="form-control" id="pesoLoteAlim" placeholder="01">
		      </div>
		    </div>
	    </div>
	    
	     <div class="row col-sm-12">
	   	<div class="form-group col-sm-6">
	      <label class="control-label col-sm-4">Data inicio:</label>
	      	<div class="col-sm-8">
		      <div class="input-append" id="datePickerIniAlim">
		       <span class="add-on">
		        <input type="text" class="form-control" id="dataIniAlim" placeholder="dd/mm/aaaa" data-format="dd-MM-yyyy"></input>
			    </span>
		      </div>
		    </div>
		  </div>
	    
	    <div class="form-group col-sm-6">
	      <label class="control-label col-sm-4">Data fim previsto:</label>
	      <div class="col-sm-8">
	      	<div class="input-append" id="datePickerFimAlim">
		       <span class="add-on">
	        		<input type="text" class="form-control" id="dataFimAlim" placeholder="dd/mm/aaaa" data-format="dd-MM-yyyy">
	        	</span>
		     </div>
	      </div>
	    </div>
	  </div>
	    			
	     <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10" id="divBotoes">
	        <input type="button" class="btn btn-default"; onclick="enviar()"; return false;" value="Salvar">
	        <button type="button"  class="btn btn-danger" onclick="location.href='loteDashboard.jsp';">Cancelar</button>
	      </div>
	    </div>
	    </div>
	  </form>
	</div><!-- fim container principal -->
</body>
</html>