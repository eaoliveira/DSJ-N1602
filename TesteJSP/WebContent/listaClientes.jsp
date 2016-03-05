<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ApagaDados" method="post">
		<c:choose>
			<c:when test="${clientes.size() > 0}">
				<table>
					<tr>
						<th>Del</th>
						<th>Nome</th>
						<th>e-Mail</th>
					</tr>
					<c:forEach items="${clientes}" var="reg">
						<tr>
							<td><input type="checkbox" value="${reg.id}" name="id"></td>
							<td><c:out value="${reg.nome}" /></td>
							<td><c:out value="${reg.email}" /></td>
						</tr>
					</c:forEach>
				</table>
				<br />
				<input type="submit" value="Voltar" formaction="index.html"
					formmethod="get">
				<input type="submit" value="Apaga os itens selecionados">
			</c:when>
			<c:otherwise>
				<h3>Não existem Clientes cadastrados!</h3><hr/>
				<input type="submit" value="Voltar" formaction="index.html"
					formmethod="get">
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>