<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saúde Animal</title>

	<!-- bootstrap -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
  	
  	<script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
  	<script src="js/bootstrap-datetimepicker.min.js"></script>
  	<script src="js/purl.js"></script>

	<base target="destino" /> 
	
	<style type="text/css">
	#imge{
	background-image: url("img/aplicacao.png");
	height: 130px;
	}
	
	</style>
</head>
<body>
<div class="container-fluid">
	  	<div class="row">
	  		
	  	</div>
	  	<div class="row">
	  		<nav class="navbar">
			  <div class="container">
				<div id="imge">
				</div>
			    <div >
			       
			      <ul class="nav navbar-nav navbar-center">
			        <li><a style="border: 1px solid black" href="medicamentoDashboard.jsp" class="active">Medicamento</a></li>
			        <li><a  style="border: 1px solid balck" href="AplicacaoDashboard.jsp">Aplicação</a></li>
			        			        
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
	  	</div>
	  	<div class="row">
				<iframe class="col-lg-12" src="medicamentoDashboard.jsp" name="destino" style=" border: 0px; height: 600px;">
				</iframe>
			</div>
	  
</div>
</body>
</html>