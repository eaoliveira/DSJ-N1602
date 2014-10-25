<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="iso-8859-1" import="servlets.beans4.Mensagem"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title><c:out value="${msg.titulo}" /></title>
</head>
<body>
	<center>
		<h1><c:out value="${msg.titulo}" /></h1>
		<p><c:out value="${msg.texto}" /></p><br>
		<c:choose>
			<c:when test="${empty msg.url}">
				<input type="button" value="Voltar"
					onclick="window.history.back(-1);">
			</c:when>
			<c:otherwise>
				<input type="button" value="Voltar"
					onclick="window.location.replace('<c:out value="${msg.url}" />');">
			</c:otherwise>
		</c:choose>
	</center>
</body>
</html>
