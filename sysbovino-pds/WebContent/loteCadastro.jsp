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
	      <label class="control-label col-sm-2" for="data">Data:</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" id="data" placeholder="21/10/2015">
	      </div>
	    </div>
	  
	   <div class="form-group">
      <label class="control-label col-sm-2" for="fase">Fase:</label>
      <div class="col-sm-10">
        <select id="" class="form-control"> <!-- select -->
          <option>option 1</option> 	<!-- option são exeplos, vão ser populados confirmoações do BD -->
          <option>option 2</option>
          <option>option 4</option>
        </select>
      </div>
    </div>
	      
	    <div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <button type="submit" class="btn btn-default">Salvar</button>
	        <button type="button"  class="btn btn-danger" onclick="location.href='loteDashboard.jsp';">Cancelar</button>
	      </div>
	    </div>
	  </form>
	</div>
</div> <!-- fim container principal -->
</body>
</html>