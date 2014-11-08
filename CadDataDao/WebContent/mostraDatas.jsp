<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="cache-control" content="max-age=0" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
	<meta http-equiv="pragma" content="no-cache" />
	<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8">
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