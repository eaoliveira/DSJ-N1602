<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
<h2><c:out value="${msg}" /></h2>
<hr>
<c:if test="${fn:startsWith(msg, 'Obrigado')}">
<input type="button" value="Lista Respostas"
			 onclick="window.location.replace('ListaQuiz');" >&nbsp;
</c:if>
<input type="button" value="Voltar"
		 onclick="window.location.replace('index.html');" >
</body>
</html>