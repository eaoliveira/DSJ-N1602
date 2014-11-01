<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Datas</title>
	<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
<h2>Cadastro de Datas</h2><hr/>
<p>Total de Dadas cadastradas: <c:out value="${datas.quantidade}" />
<form action="DeletaDatas">
    <c:if test="${datas.quantidade >0}">
	<table border="1">
		<tr><th>Del</th><th>Data</th></tr>
		<c:forEach items="${datas.data}" var="obj" >
			<tr>
				<td><input type="checkbox" value="${obj.id}" name="del"></td>
				<td><fmt:formatDate value="${obj.data}" dateStyle="medium"/></td>
			</tr>
		</c:forEach>
		</table>
		</c:if>
		<p><c:if test="${datas.quantidade >0}">
		<input type="submit" value="Deletar os itens selecionados"></c:if>
		<input type="button" value="Inserir Datas" onclick="window.location.replace('index.html')">
		</p>
</form>
</body>
</html>