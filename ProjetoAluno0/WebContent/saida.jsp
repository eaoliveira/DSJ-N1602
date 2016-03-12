<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Cadastro de Alunos</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
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
			<div id="logo">Cadastro de Alunos</div>
			<nav role="navigation">
				<ul id="mainNav">
					<li><a href="cadaluno.html">Cadastro de Alunos</a></li>
					<li><a href="ListaAluno">Listar  Alunos</a></li>
				</ul>
			</nav>
		</header>

		<div id="content" role="main">
			<fieldset>
				<h2>Cadastro de Alunos</h2>
				<h3><c:out value="${msg.texto}"/></h3>
				<form id="form1"><div>
				<c:choose>
					<c:when test="${msg.pag != null }">
						<input type="submit" id="submit" value="Voltar" 
          					formaction="${msg.pag}"/>
					</c:when>
					<c:otherwise>
						<input type="submit" id="submit" value="Voltar" 
          					formaction="index.html"/>
					</c:otherwise>
				</c:choose>
				</div></form>
			</fieldset>
		</div>

	</div>
</body>
</html>