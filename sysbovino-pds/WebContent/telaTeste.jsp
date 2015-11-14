<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	var qtdeCampos = 0;

	function addCampos() {
		var objPai = document.getElementById("campoPai");
		//Criando o elemento DIV;
		var objFilho = document.createElement("div");
		//Definindo atributos ao objFilho:
		objFilho.setAttribute("id", "filho" + qtdeCampos);

		//Inserindo o elemento no pai:
		objPai.appendChild(objFilho);
		//Escrevendo algo no filho recém-criado:
		document.getElementById("filho" + qtdeCampos).innerHTML = "<input type='text' id='campo"+qtdeCampos+"' name='campo[]' value='Campo com id: "+qtdeCampos+"'> <input type='button' onclick='removerCampo("
				+ qtdeCampos + ")' value='Apagar campo'>";
		qtdeCampos++;
	}

	function removerCampo(id) {
		var objPai = document.getElementById("campoPai");
		var objFilho = document.getElementById("filho" + id);

		//Removendo o DIV com id específico do nó-pai:
		var removido = objPai.removeChild(objFilho);
	}
</script>
</head>
<body>
	<center>
		<br> <br>Inserindo Campos em Formulário Dinâmico<br>
		<Br>
		<form name="form1">
			<div id="campoPai"></div>
			<input type="button" value="Adicionar campos" onclick="addCampos()">
			<br>
			<br>
			<input type="submit" value="Enviar">
		</form>
	</center>
</body>
</html>