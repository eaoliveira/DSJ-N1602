<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="cache-control"   content="no-cache" />
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="expires" content="Mon, 17 jul 2000 10:10:00 GMT" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Cadastro de Cursos</title>
<link rel="stylesheet" type="text/css" href="style/paginas.css">
</head>
<body>
<div class="tabela">
<h2>Cadastro de Cursos</h2><hr>
Total de Cursos Cadastrados: <c:out value= "${cursos.count}"/> 
 <c:choose>
 <c:when test="${cursos.count > 0}">
<form action="deletaCurso">
<p><table border="1">
<tr><th>Del</th><th>Nome</th><th>Descrição</th></tr>
<c:forEach var="obj" items="${cursos.itens}">
<tr>
<td><input type="checkbox" name="del" value="${obj.id}"></td>
<td><c:out value="${obj.nome}"/></td>
<td><c:out value="${obj.descr}"/></td>
</tr>
</c:forEach>
</table>
<p><input type="submit" value="Deleta os Cursos Selecionados">
<input type="button" value="Incluir Cursos" 
       onclick="window.location.replace('inserir.jsp')"></p>
</form>
</c:when>
<c:otherwise>
<p><input type="button" value="Incluir Cursos" 
       onclick="window.location.replace('inserir.jsp')"></p>
</c:otherwise>
</c:choose>
</div>
</body>
</html>