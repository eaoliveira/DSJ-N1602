<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Respostas do Quiz</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
<h2>Quiz Porreta</h2>
<hr>
<table border="1">
<tr><th>Qtd.</th><th>Resposta</th></tr>
<tr><td><c:out value="${ate18}" /></td><td>at&eacute; 18</td></tr>
<tr><td><c:out value="${ate26}" /></td><td>de 19 at&eacute; 26</td></tr>
<tr><td><c:out value="${ate35}" /></td><td>de 27 at&eacute; 35</td></tr>
<tr><td><c:out value="${ate99}" /></td><td>acima de 35</td></tr>
</table>
<br>
<input type="button" value="Voltar"
		 onclick="window.location.replace('index.html');" >
</body>
</html>