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

</head>
<body>

<div class="container">
	<div class="page-header"><h1>Lote</h1></div>
	
	<div class="col-sm-12">
		<div class="col-sm-3">
			<div class="list-group">
			  <a href="loteCadastro.jsp" class="list-group-item">Novo Lote</a>
			  <a href="#" class="list-group-item">Alterar</a>
			  <a href="#" class="list-group-item">Excluir</a>
			</div>
		</div>
		
		<div class="col-sm-9">
			<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Lote</th>
		        <th>Alimento</th>
		        <th>Qntde Bovinos</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td>Lote 001</td>
		        <td>Silagem composição 1</td>
		        <td>55</td>
		      </tr>
		      <tr>
		        <td>Lote 025</td>
		        <td>Silagem composiçao 3</td>
		        <td>44</td>
		      </tr>
		      <tr>
		        <td>Lote 57</td>
		        <td>Ração + Silagem</td>
		        <td>50</td>
		      </tr>
		    </tbody>
		  </table>
		</div>
		
	</div>
	
</div>

</body>
</html>