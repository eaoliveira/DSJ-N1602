<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="cache-control"   content="no-cache" />
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="expires" content="Mon, 17 jul 2000 10:10:00 GMT" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Inserir Cursos</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
	<div class="tabela">
	<h2>Cadastro de Cursos</h2>
	<hr>
	<form action="incluiCurso">
		<p>Nome: <input type="text" name="nome"></p>
		<p>Descri&ccedil;&atilde;o:</p>
		<textarea rows="10" cols="75" name="desc"></textarea>
		<p>
			<input type="submit" value="Enviar">&nbsp;
			<input type="button" value="Voltar"
				onclick="window.location.replace('index.html');">
		</p>
	</form></div>
</body>
</html>