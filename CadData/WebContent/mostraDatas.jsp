<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Datas</title>
</head>
<body>
<h3>Cadastro de Datas</h3><hr/>
<p>Total de Dadas cadastradas: <c:out value="${datas.quantidade}" />
<form action="DeletaDatas">
<table border="1">
<tr><th>Del</th><th>Data</th></tr>
<c:forEach items="${datas.data}" var="obj" varStatus="var" >
<tr>
<td><input type="checkbox" value="${obj.id}" name="del"></td>
<td><fmt:formatDate value="${obj.data}" dateStyle="medium"/></td>
</tr>
</c:forEach>
</table>
<br/><input type="submit" value="Deletar os itens selecionados">
<br/><input type="button" value="Inserir Datas" onclick="window.location.replace('index.html')">
</form>
</body>
</html>