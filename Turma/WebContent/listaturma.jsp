<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Turmas Cadastradas</title>
	<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
<h2>Turmas Cadastradas</h2><hr/>
<p>Total de Turmas cadastradas: <c:out value="${turmas.quantidade}" />
<form action="DeletaTurmas">
    <c:if test="${turmas.quantidade >0}">
	<table border="1">
		<tr><th>Del</th><th>Título</th><th>Início</th><th>Horas</th></tr>
		<c:forEach items="${turmas.lista}" var="obj" >
			<tr>
				<td><input type="checkbox" value="${obj.id}" name="del"></td>
				<td><c:out value="${obj.titulo}" /></td>
				<td><fmt:formatDate value="${obj.inicio}" dateStyle="medium"/></td>
				<td><c:out value="${obj.numhoras}" /></td>
			</tr>
		</c:forEach>
		</table>
		</c:if>
		<p><c:if test="${turmas.quantidade >0}">
		<input type="submit" value="Deletar os itens selecionados"></c:if>
		<input type="button" value="Inserir Turmas" onclick="window.location.replace('cadturma.html')">
		<input type="button" value="Voltar" onclick="window.location.replace('gerturma.html')">
		</p>
</form>
</body>
</html>