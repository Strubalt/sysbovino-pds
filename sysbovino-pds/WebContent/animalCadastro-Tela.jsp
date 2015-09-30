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
  	
<title>Cadastro Animal - Mastrinder</title>
</head>
<body>
<!-- container principal -->
<div class="container">
	Cadastro de Animal
	<div>
	  <form class="form-horizontal" role="form">
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="codigo">Codigo:</label>
	      <div class="col-sm-10">
	        <input type="email" class="form-control" id="codigo" placeholder="Enter codigo">
	      </div>
	    </div>
	    <div class="form-group">
	     <label class="control-label col-sm-2" for="codigo">Lote:</label>
	    	<select class="form-control">
	    		<option>Lote1</option>
	    	</select>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-2" for="pwd">Nada:</label>
	      <div class="col-sm-10">          
	        <input type="password" class="form-control" id="pwd" placeholder="Enter password">
	      </div>
	    </div>
	    Testando novamento
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">Submit</button>
	      </div>
	    </div>
	  </form>
	</div>
</div> <!-- fim container principal -->
</body>
</html>
