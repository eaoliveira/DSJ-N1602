<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir Turma</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
	<h2>Cadastro de Turma</h2>
	<hr>
	<form action="IncluiTurma"> <!--  IncluiTurma tem que ser um servlet -->
		<p>Título: <input type="text" name="titulo"></p>
		<p>Descrição: <input type="text" name="descricao"></p>
		<p>Data Inicial: <input type="text" name="inicio"></p>
		<p>Horas de aulas: <input type="text" name="numHoras"></p>
		<p>
			<input type="submit" value="Enviar">&nbsp;
			<input type="button" value="Voltar"
				onclick="window.location.replace('index.html');">
		</p>
	</form>
</body>
</html>