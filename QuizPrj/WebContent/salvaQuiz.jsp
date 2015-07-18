<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="cache-control"   content="no-cache" />
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="expires" content="Mon, 17 jul 2000 10:10:00 GMT" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Quiz</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
<div class="mensagem">
<h2><c:out value="${msg}" /></h2>
<hr>
<c:if test="${fn:startsWith(msg, 'Obrigado')}">
<input type="button" value="Lista Respostas"
			 onclick="window.location.replace('ListaQuiz');" >&nbsp;
</c:if>
<input type="button" value="Voltar"
		 onclick="window.location.replace('index.html');" >
</div>
</body>
</html>