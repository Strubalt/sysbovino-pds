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
	        <input type="codigo" class="form-control" id="codigo" placeholder="">
	      </div>
	      </div>
	      <br/>
	      <label class="control-label col-sm-2" for="codigo">Fornecedora: </label>
	      <div class="col-sm-8">
	        <input type="fornecedora" class="form-control" id="fornecedora" placeholder="">
	      </div>
	    </div>
	  <br/>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="pwd">Nome do Produto:</label>
	      <div class="col-sm-8">          
	        <input type="nomeProd" class="form-control" id="nomeProd" placeholder="">
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
	        <button type="submit" class="btn btn-default">Salvar</button>
	        <button type="button" class="btn btn-danger">Cancelar</button>
	      </div>
	    </div>
	  </form>
	</div>
</div> <!-- fim container principal -->
</body>
</html>