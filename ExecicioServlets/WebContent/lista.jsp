<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Efetuado</title>
</head>
<body>

<h2> Cadastro efetuado com sucesso</h2>

<p>Nome: <c:out value="${cadas.nome}"/>
<p>Endereço: <c:out value="${cadas.end}" />.
<p>Fone: <c:out value="${cadas.fone}" />
<p>E-mail: <c:out value="${cadas.email}" />

<p><input type="button" value="Voltar" onclick="window.location.replace('index.html')">


</body>
</html>