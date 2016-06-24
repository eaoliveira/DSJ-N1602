<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Pedido de Compra</title>
<link rel="stylesheet" type="text/css" href="styles/style.css"/>
<script src="scripts/jquery-1.7.1.js"></script>
<script src="scripts/js-webshim/minified/extras/modernizr-custom.js"></script>
<script src="scripts/js-webshim/minified/polyfiller.js"></script>
<script>
	$.webshims.setOptions('forms-ext', { replaceUI : false });
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
					<c:if test="${count > 0}">
						<li><a href="listarEnderecos">Listar Endereços</a></li>
						<li><a href="carregaEnderecos">Emitir Pedido</a></li>
					</c:if>
				</ul>
			</nav>
		</header>

		<div id="content" role="main">
			<fieldset>
				<h2>Cadastro de Endereço</h2>
				<form id="form1" action="gravaEndereco" method="post">
					<div>
						<label for="logr">Logradouro</label>
						<input type="text" name="logr" required>
					</div><div>
						<label for="num">Nº</label>
						<input type="text"  name="num"  required />
					</div><div>
						<label for="bairro">Bairro</label>
						<input type="text"  name="bairro"  required />
					</div><div>
						<input type="submit" id="submit" value="Salvar"> 
					</div>
				</form>
			</fieldset>
		</div>

	</div>
</body>
</html>