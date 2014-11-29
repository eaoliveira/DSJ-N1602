<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html manifest="cache.manifest">
<head>
	<meta charset="UTF-8">	
	<title>Cadastro Efetuado</title>
	<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
	<h2>Sucesso no Cadastro do serviço abaixo</h2>
	<hr>
	<p>Nome: <c:out value="${srv.nome}"/>
	<p>Email: <c:out value="${srv.email}" />
	<p>Matricula: <c:out value="${srv.matricula}" />
	<p><input type="button" value="Voltar" onclick="window.location.replace('index.html')">
</body>
</html>