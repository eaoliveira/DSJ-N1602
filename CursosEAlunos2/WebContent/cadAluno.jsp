<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Escola</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<link rel="stylesheet" type="text/css" href="styles/jquery-ui.css">
<script src="scripts/jquery-1.7.1.js"></script>
<script src="scripts/js-webshim/minified/extras/modernizr-custom.js"></script>
<script src="scripts/js-webshim/minified/polyfiller.js"></script>
<script src="scripts/jquery-ui.js"></script>
<script>
	$.webshims.setOptions('forms-ext', { replaceUI : false });
	$.webshims.polyfill('forms-ext');
</script>
</head>
<body>
	<div id="wrapper">
		<header role="banner" class="group">
			<div id="logo">Escola 1/2 Boca</div>
			<nav role="navigation">
				<ul id="mainNav">
					<li><a href="gestaoCursos.html">Gestão de Cursos</a></li>
					<li><a href="gestaoAlunos.html">Gestão de Alunos</a></li>
				</ul>
			</nav>
		</header>

		<div id="content" role="main">
			<fieldset>
				<form id="form1" action="CadAluno" method="post">
					<div>
						<label for="nome">Nome</label>
		 				<input type="text" size="25" name="nome" required aria-required="true">
		 			</div><div>
						<label for="email">E-Mail</label>
						<input type="email" size="25" name="email" required aria-required="true">
					</div><div>
						<label for="curso">Curso</label>
						<select name="curso">
						<c:forEach var="curso" items="${cursos}">
							<option value="${curso.id}"><c:out value="${curso.nome}" /></option>
						</c:forEach>
						</select>
					</div><div>
						<input type="submit" id="submitL" value="Voltar"
							onclick="window.location.replace('gestaoAlunos.html');">
						<input type="submit" id="submit" value="Salvar">
					</div>
				</form>
			</fieldset>
		</div>
	</div>	
</body>
</html>