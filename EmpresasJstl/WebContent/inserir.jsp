<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir Empresas</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
	<h2>Cadastro de Empresas</h2>
	<hr>
	<form action="incluiEmpresa">
		<p>Razão Social: <input type="text" name="razao"></p>
		<p>Nome Fantasia: <input type="text" name="nome"></p>
		<p>CNPJ: <input type="text" name="cnpj"></p>
		<p>
			<input type="submit" value="Enviar">&nbsp;
			<input type="button" value="Voltar"
				onclick="window.location.replace('index.html');">
		</p>
	</form>
</body>
</html>