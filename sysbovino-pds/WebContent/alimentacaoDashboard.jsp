<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alimentação</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
  	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>


<script type="text/javascript">
	$(document).ready ( function(){
	  listaAlimentos();
	});
	
	function listaAlimentos(){
		$.ajax({
			type:"post",
			data:{tipoFlag:"listar"},
			url:"AlimentacaoController",
			success: function(result){
				var linhas = "";  
		          for (var i = 0, length = result.length; i < length; i++) {  
	                     var re = result[i];  
	                     linhas += "<tr>"+  
	                                    "<th>"+re.codProduto+"</th>"+
	                                   // "<th>"+re.codPessoa+"</th>"+
	                                    "<th>"+re.nomeProduto+"</th>"+
	                                    "<th>"+re.observacao+"</th>"+
	                                    "<th><a href='alimentoCadastro.jsp?tipo=1&codProduto="+re.codProduto+"'>Alterar</a></th>"+
	                                    "<th><a href='javascript:void(0);' onclick='excluirAlimento("+re.codProduto+")'>Excluir</a></th>"+
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
	

	function excluirAlimento(codLote){
		
		$.ajax({
			type:"post",
			data:{tipoFlag:"excluir",codProduto:codProduto},
			url:"AlimentacaoController",
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
	<div class="page-header"><h1>Alimentação</h1></div>
	
	<div class="col-sm-12">
		<div class="col-sm-3">
			<div class="list-group">
			  <a href="tipoAlimCadastro.jsp" class="list-group-item">Nova Alimentação</a>
			</div>
		</div>
		
		<div class="col-sm-9">
			<table class="table table-striped">
			 
			 <thead>
		      <tr>
		        <th>Codigo</th>
		        <th>Nome</th>
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