<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="expires" content="Mon, 17 jul 2000 10:10:00 GMT" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Cursos</title>
</head>
<body>
	<h3>Cadastro de Cursos</h3>
Total de Cursos Cadastrados:
	<c:out value="${Cursos.size() }" />
	<form action="removeItens">
		<c:if test="${curso.size() > 0}">
			<table border="1">
				<tr>
					<th>Del</th>
					<th>Nome</th>
					<th>Descrição</th>
				</tr>
				<c:forEach var="curso" items="${curso}">
					<tr>
						<td><input type="checkbox" name="del" value="${curso.id}"></td>
						<td><c:out value="${curso.nome}" /></td>
						<td><c:out value="${curso.desc}" /></td>
						
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<p>
			<input type="button" value="Incluir Curso"
				onclick="window.location.replace('CadastraCurso.jsp')"> 
				<c:if test="${curso.size() > 0}">
					<input type="submit" value="Remover os Itens selecionados">
				</c:if>
		</p>
	</form>
</body>
</html>