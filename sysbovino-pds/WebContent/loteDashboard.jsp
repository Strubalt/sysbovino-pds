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


<script type="text/javascript">
	$(document).ready ( function(){
	  listaLotes();
	});
	
	function listaLotes(){
		$.ajax({
			type:"post",
			data:{tipoFlag:"listar"},
			url:"LoteController",
			success: function(result){
				var linhas = "";  
		          for (var i = 0, length = result.length; i < length; i++) {  
	                     var re = result[i];  
	                     linhas += "<tr>"+  
	                                    "<th>"+re.codLote+"</th>"+
	                                    "<th>"+re.codPropriedade+"</th>"+
	                                    "<th>"+re.dataCriacao+"</th>"+
	                                    "<th>"+re.descricao+"</th>"+
	                                    "<th><a href='loteCadastro.jsp?tipo=1&lote="+re.codLote+"'>Alterar</a></th>"+
	                                    "<th><a href='javascript:void(0);' onclick='excluirLote("+re.codLote+")'>Excluir</a></th>"+
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
	

	function excluirLote(codLote){
		
		$.ajax({
			type:"post",
			data:{tipoFlag:"excluir",codLote:codLote},
			url:"LoteController",
			success: function(result){
				alert(result);
			}
		});
		location.reload(true);
	}
	</script>

</head>
<body>

<div class="container">
	<div class="page-header"><h1>Lote</h1></div>
	
	<div class="col-sm-12">
		<div class="col-sm-3">
			<div class="list-group">
			  <a href="loteCadastro.jsp" class="list-group-item">Novo Lote</a>
			</div>
		</div>
		
		<div class="col-sm-9" id="listaLote">
		
			<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Lote</th>
		        <th>Propriedade</th>
		        <th>Qntde Bovinos</th>
		        <th>Descrição</th>
		        <th></th>
		        <th></th>
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