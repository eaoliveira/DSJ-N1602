<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="servlets.beans4.Mensagem"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${msg.titulo}" /></title>
	<link rel="stylesheet" type="text/css" href="../style/paginas.css">
</head>
<body>
	<h2><c:out value="${msg.titulo}" /></h2><hr>
	<p><c:out value="${msg.texto}" /></p>
	<br>
	<c:choose>
		<c:when test="${empty msg.url}">
			<input type="button" value="Voltar" onclick="window.history.back(-1);">
		</c:when>
		<c:otherwise>
			<input type="button" value="Voltar"
				onclick="window.location.replace('<c:out value="${msg.url}" />');">
		</c:otherwise>
	</c:choose>
</body>
</html>
