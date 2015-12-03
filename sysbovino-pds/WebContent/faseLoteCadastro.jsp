
<!-- Vai ser feito na tela de cadastro de lote -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vincular fase ao lote</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<!-- bootstrap -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
  	<script src="js/jquery.js"></script>
  	<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready ( function(){
	  carregaLotes();
	  //carregaFases();
	});
	
function carregaLotes(){
	$.ajax({
		type:"post",
		data:{tipoFlag:"populaLotes"},
		dataType: "json",
		url:"FaseLoteController",
		success: function(result){
			var linhas = "";  
		        for (var i = 0, length = result.length; i < length; i++) {  
		            var re = result[i];  
		            linhas += "<option value='"+re.codLote+"'>"+re.codLote+" - "+re.nomePessoa+"("+re.codPropriedade+")</option>";                                            
				}      
			var divCorpo = document.getElementById("lote");  
			divCorpo.innerHTML=linhas;  
		}
});
}


</script>

</head>
<body>
<div class="container">

		<div class="page-header"><h1>Cadastro de Fase</h1></div> 
	 
		<form class="form-horizontal" role="form"> 
		
		  <div class="form-group">
		      <label class="control-label col-sm-2" for="propriedade">Lote:</label>
		      <div class="col-sm-10">
		        <select id="lote" class="form-control"> <!-- select -->
		          
		        </select>
		      </div>
    	</div>
    	
    	<div class="form-group">
		      <label class="control-label col-sm-2" >Fase:</label>
		      <div class="col-sm-8">
		        <select id="fase" class="form-control"> <!-- select -->
		          
		        </select>
		      </div>
		      <div class="col-sm-2">
		      	<button type="button"  class="btn btn-default" onclick="location.href='faseLoteCadastro.jsp';">+ fase</button>
		      </div>
    	</div>
	    
	     <div class="form-group">
	      <label class="control-label col-sm-2" for="nome">Nome:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="nome" placeholder="Nome">
	      </div>
	    </div>
	    
	      <div class="form-group">	
	      <label class="control-label col-sm-2" for="observacao">Observação:</label> 
	      <div class="col-sm-10">
	        <textarea class="form-control" rows="5" id="observacao" placeholder="teste"></textarea> 
	      </div>
	    </div>
	    
	      <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">Salvar</button>
	        <button type="button" class="btn btn-danger">Cancelar</button>
	      </div>
	    </div>
	  </form>
	</div>

</body>
</html>