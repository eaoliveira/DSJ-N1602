<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Catalogo de Datas</title>
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
			<div id="logo">Catalogo de Datas</div>
		</header>

		<div id="content" role="main">
		
		<fieldset>
			<h2>Cadastro de Cursos</h2>
			<h3>Total de Cursos Cadastrados: <c:out value="${cursos.size()}" /></h3>
			<form id="form1">
				<div>
					<label>Data de Nascimento</label>
					<span><fmt:formatDate value="${nascimento}"/></span>
				</div><div>
					<label>Data de Formatura</label>
					<span><fmt:formatDate value="${formatura}" /></span>
				</div><div>
					<input type="submit" id="submit" value="Voltar" formaction="index.html">
				</div>
			</form>
		</fieldset>
		</div>

	</div>
</body>
</html>