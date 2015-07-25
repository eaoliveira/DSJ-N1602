<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="expires" content="Mon, 17 jul 2000 10:10:00 GMT" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Curso</title>
</head>
<body>
	<h3>Cadastro Curso</h3>
	<hr/>
	<form action="ValidarCurso">
		<p>Nome: <input type="text" name="nome"></p>
		<p>Descrição :</p>
		<p><textarea name="desc" rows="4" cols="30"></textarea></p>
		<input type="submit" value="Enviar" >
		<input type="button" value="Voltar" onclick="window.location='../ListaCurso.jsp'">
	</form>
</body>
</html>