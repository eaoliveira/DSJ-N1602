<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${titulo}" /></title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
	<h2><c:out value="${titulo}" /></h2>
	<hr>
		<p><c:out value="${msg}" /></p>
		<p><input type="button" value="Voltar"
			onclick="window.location.replace('cadturma.html')"></p>
</body>
</html>