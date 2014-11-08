<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="caddata.bean.Mensagem"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html manifest="resources/cache.manifest">
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Datas</title>
	<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
	<h2>Cadastro de Datas</h2><hr>
	<h3><c:out value="${msg.texto}" /></h3>
	<p><input type="button" value="Voltar"
				onclick="window.location.replace('<c:out value="${msg.url}" />');"></p>
</body>
</html>
