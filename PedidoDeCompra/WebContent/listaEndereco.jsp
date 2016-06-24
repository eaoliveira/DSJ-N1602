<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Pedido de Compra</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="scripts/jquery-1.7.1.js"></script>
<script src="scripts/js-webshim/minified/extras/modernizr-custom.js"></script>
<script src="scripts/js-webshim/minified/polyfiller.js"></script>
<script>
	$.webshims.setOptions('forms-ext', { replaceUI: false });
	$.webshims.polyfill('forms-ext');
</script>
</head>
<body>
	<div id="wrapper">
		<header role="banner" class="group">
			<div id="logo">Pedido de Compra</div>
			<nav role="navigation">
				<ul id="mainNav">
					<li><a href="inicio">Cadastro de Endereços</a></li>
					<c:if test="${enderecos.size() > 0}">
						<li><a href="listarEnderecos">Listar Endereços</a></li>
						<li><a href="carregaEnderecos">Emitir Pedido</a></li>
					</c:if>
				</ul>
			</nav>
		</header>

		<div id="content" role="main">
		
		<fieldset>
			<h2>Lista de Endereços</h2>
				<c:choose>
				<c:when test="${enderecos.size() > 0}">
					<form id="form1" action="excluiEndereco">
						<div id="flex">
							<b data-col='1'>Del</b>
							<b data-col='2'>Logradouro</b>
							<b data-col='3'>Bairro</b>
							<c:forEach items="${enderecos}" var="end">
								<input type="checkbox" name="endid" value="${end.id}" data-col="1"/>
								<span data-col="2"><c:out value="${end.logradouro }, ${end.numero}" /></span>
								<span data-col="3"><c:out value="${end.bairro }" /></span>
							</c:forEach>
						</div><div>
							<input type="submit" id="submit" value="Cadastrar Endereços" formaction="inicio">
							<input type="submit" id="submitL" value="Deletar os itens selecionados">
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<form id="form1" action="inicio">
						<input type="submit" id="submit" value="Cadastrar Endereços">
					</form>
				</c:otherwise>
				</c:choose>
		</fieldset>
		</div>

	</div>
</body>
</html>