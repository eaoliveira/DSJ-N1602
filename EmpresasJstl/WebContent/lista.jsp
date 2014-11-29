<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Empresas</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
<h2>Cadastro de Empresas</h2><hr>
Total de Cursos Cadastrados: <c:out value= "${emp.count}"/> 
<form action="deletaEmpresa">
<p><table border="1">
<tr><th>Del</th><th>Razão Social</th><th>Nome Fantasia</th><th>CNPJ</th></tr>
<c:forEach var="obj" items="${emp.itens}">
<tr>
<td><input type="checkbox" name="del" value="${obj.id}"></td>
<td><c:out value="${obj.razao}"/></td>
<td><c:out value="${obj.nome}"/></td>
<td><c:out value="${obj.cnpj}"/></td>
</tr>
</c:forEach>
</table>
<p><input type="submit" value="Deleta os Itens Selecionados">
<input type="button" value="Incluir Empresa" 
       onclick="window.location.replace('inserir.jsp')"></p>
</form>
</body>
</html>