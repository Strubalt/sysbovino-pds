<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	
	
	
  	<script src="js/jquery.js"></script>
  	 <script src="js/bootstrap.min.js"></script>
  	


<title>Mastrinder - Sitema Bovino</title>
</head>
<body>

	  <div class="container-fluid">
	  	<div class="row">
	  		<nav class="navbar navbar-default">
			  <div class="container">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#"><img alt="Mastrinder" src="img/mastrinder.png" style="height: 50px; width: 50px; margin-top: -12px;"> </a>
			    </div>
			
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			         
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="#">Home</a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usu�rio <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">Perfil</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="#">Sair</a></li>
			          </ul>
			        </li>
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
	  	</div>
	  	<div class="row">
		  	<div class="col-lg-2">
			  	<ul class="nav nav-pills nav-stacked ">
					<li role="presentation" class="active"><a href="#">Lote</a></li>
				  	<li role="presentation"><a href="#">Animal</a></li>
				  	<li role="presentation"><a href="#">Veterin�rio</a></li>
				</ul>
			</div>
			<div class="col-lg-10">
				<iframe class="col-lg-12" src="dashboard-resumo.jsp" style=" border: 0px; height: 500px;">
				</iframe>
			</div>
	  	</div>
	  </div>
</body>
</html>