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

<script type="text/javascript">
var qtdeCampos = 0;
function novoCampo(){
	var objPai = document.getElementById("childForm");
	//Criando o elemento DIV;
	var objFilho = document.createElement("div");
	//Definindo atributos ao objFilho:
	//objFilho.setAttribute("id", "filho" + qtdeCampos);
	objFilho.setAttribute("class", "form-group");

	//Inserindo o elemento no pai:
	objPai.appendChild(objFilho);
	//Escrevendo algo no filho rec�m-criado:
	objFilho.innerHTML = "<div class='col-md-12 col-sm-12'>					<div class='form-group col-md-3 col-sm-3'>						<label class='control-label' for='pwd'>C�digo:</label>						<div class='ss'>							<input type='text' class='form-control' id='codigo'						placeholder=''>						</div>					</div>					<div class='form-group col-md-3 col-sm-3'>						<label class='control-label ' for='codigo'>Descri��o da							Alimenta��o:</label>						<div>							<input type='text' class='form-control' id='descricao'								placeholder=''>						</div>					</div>					<div class='form-group col-md-3 col-sm-3'>						<label class='control-label' for='pwd'>C�digo do Produto:</label>						<div>							<select id='' class='form-control'>								<!-- select -->								<option>option 1</option>								<!-- option s�o exemplos, v�o ser populados confirma��es do BD -->								<option>option 2</option>								<option>option 3</option>								<option>option 4</option>								<option>option 5</option>							</select>						</div>					</div>					<div class='form-group col-md-3 col-sm-3'>						<label class='control-label' for='pwd'>Descri��o do							Produto: </label>						<div class=>							<input type='composicao' class='form-control' id='composicao'								placeholder=''>						</div>					</div>				</div>";
	qtdeCampos++; 
      
}

</script>

<title>Mastrinder - Cadastro de Tipo de Alimenta��o</title>
</head>
<body>

	<!-- container principal -->
	<div class="container">
		<div class="page-header">
			<h1>Cadastro de Tipo de Alimenta��o</h1>
		</div>
		<form class="form-horizontal" role="form">
			<div class="row" id="mainForm">
				<div class="col-md-12 col-sm-12">
					<div class="form-group col-md-3 col-sm-3">
						<label class="control-label" for="pwd">C�digo:</label>
						<div class="ss">
							<input type="text" class="form-control" id="codigo"
								placeholder="">
						</div>
					</div>
					<div class="form-group col-md-3 col-sm-3">
						<label class="control-label " for="codigo">Descri��o da
							Alimenta��o:</label>
						<div>
							<input type="text" class="form-control" id="descricao"
								placeholder="">
						</div>
					</div>

					<div class="form-group col-md-3 col-sm-3">
						<label class="control-label" for="pwd">C�digo do Produto:</label>
						<div>
							<select id="" class="form-control">
								<!-- select -->
								<option>option 1</option>
								<!-- option s�o exemplos, v�o ser populados confirma��es do BD -->
								<option>option 2</option>
								<option>option 3</option>
								<option>option 4</option>
								<option>option 5</option>
							</select>
						</div>
					</div>

					<div class="form-group col-md-3 col-sm-3">
						<label class="control-label" for="pwd">Descri��o do
							Produto: </label>
						<div class=>
							<input type="composicao" class="form-control" id="composicao"
								placeholder="">
						</div>
					</div>
				</div>
			</div>
			<!-- final row -->
			
			<!-- aqui vai ser acrescentado o novo formulario -->
			<div class="row" id="childForm">
			</div>

			<div>
				<button type="submit" onclick="novoCampo()" class="btn btn-default">+</button>
			</div>
			<br />
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Salvar</button>
					<button type="button" class="btn btn-danger">Cancelar</button>
				</div>
			</div>

		</form>
	</div>
	</div>
	<!-- fim container principal -->
</body>
</html>