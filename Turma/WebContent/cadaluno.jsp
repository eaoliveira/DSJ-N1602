<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Matricula Alunos</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
	<h2>Matricula Alunos</h2>
	<hr>
	<form action="CadAluno">
		<p>Nome <input type="text" size="25" name="nome"></p>
		<p>E-Mail <input type="text" size="25" name="email"></p>
		<p>Turma <select name="turma">
			<c:forEach var="turma" items="${turmas}">
				<option value="${turma.id}"><c:out value="${turma.titulo}" /></option>
			</c:forEach>
		</select></p>
		<p><input type="submit" value="Salvar">
		<input type="button" value="Voltar"
			onclick="window.location.replace('index.html')"></p>
	</form>
</body>
</html>