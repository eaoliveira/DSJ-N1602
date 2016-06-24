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
			<h2>Pedido de Compra</h2>
			<form id="form1" action="gravaPedido" method="post">
				<div>
					<label data-tipo="1" for="cliente">Razão Social do Cliente</label>
					<input data-tipo="2" type="text" name="cliente" required>
				</div><div>
					<label data-tipo="1" for="produto">Código do Produto</label>
					<input data-tipo="2" type="text" name="produto" required>
				</div><div>
					<label data-tipo="1" for="endereco">Endereço de Entrega</label>
					<select name="endereco">
						<c:forEach var="end" items="${enderecos}">
							<option value="${end.id}"><c:out value="${end.logradouro}" /></option>
						</c:forEach>
					</select>					
				</div><div>
					<input type="submit" id="submitL" value="Voltar" formaction="inicio">
					<input type="submit" id="submit" value="Salvar"> 
				</div>
			</form>
		</fieldset>
		</div>

	</div>
</body>
</html>