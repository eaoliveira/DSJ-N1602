<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Turmas</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
	<h2>Cadastro de Turmas</h2>
	<hr>
	Total de Turmas Cadastrados:
	<c:out value="${emp.count}" />
	<form action="DeletaTurma">
		<!--  incluiTurma tem que ser um servlet -->
		<p>
		<table border="1">
			<tr>
				<th>Del</th>
				<th>Titulo</th>
				<th>Descrição</th>
				<th>Data de inicio</th>
				<th>Numero de horas</th>
			</tr>
			<c:forEach var="obj" items="${emp.itens}">
				<tr>
					<td><input type="checkbox" name="del" value="${obj.idTurma}"></td>
					<td><c:out value="${obj.titulo}" /></td>
					<td><c:out value="${obj.descricao}" /></td>
					<td><c:out value="${obj.inicio}" /></td>
					<td><c:out value="${obj.numHoras}" /></td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<input type="submit" value="Deleta os Itens Selecionados"> <input
				type="button" value="Incluir Turma"
				onclick="window.location.replace('inserir.jsp')">
		</p>
	</form>
</body>
</html>