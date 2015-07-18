<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="cache-control"   content="no-cache" />
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="expires" content="Mon, 17 jul 2000 10:10:00 GMT" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Respostas do Quiz</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
<div class="menu">
<h2>Quiz Porreta</h2>
<hr>
<table border="1" class="tabela">
<tr><th>Qtd.</th><th>Resposta</th></tr>
<tr><td><c:out value="${ate18}" /></td><td>at&eacute; 18</td></tr>
<tr><td><c:out value="${ate26}" /></td><td>de 19 at&eacute; 26</td></tr>
<tr><td><c:out value="${ate35}" /></td><td>de 27 at&eacute; 35</td></tr>
<tr><td><c:out value="${ate99}" /></td><td>acima de 35</td></tr>
</table>
<br><div class="botoes">
<input type="button" value="Voltar"
		 onclick="window.location.replace('index.html');" ></div>
</div>
</body>
</html>