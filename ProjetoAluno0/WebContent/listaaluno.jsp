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
				<h2>Listar Alunos</h2>
				<h3>Total de registros encontrados: <c:out value="${alunos.size()}"/></h3>
			</fieldset>
			<fieldset>
				<c:choose>
				<c:when test="${alunos.size() > 0}">
					<form id="form1" action="ExcluiAluno">
						<div id="flex">
							<b data-col='1'>Del</b>
							<b data-col='2'>Nome</b>
							<b data-col='3'>Matrícula</b>
							<c:forEach items="${alunos}" var="aluno">
								<input type="checkbox" name="alunoid" value="${aluno.id}" data-col="1"/>
								<span id="data-col=2"><c:out value="${aluno.nome }" /></span>
								<span id="data-col=3"><c:out value="${aluno.matricula }" /></span>
							</c:forEach>
						</div><div>
							<input type="submit" id="submit" value="Inserir Alunos" formaction="cadaluno.html">
							<input type="submit" id="submitL" value="Deletar os itens selecionados">
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<form id="form1" action="cadaluno.html">
						<input type="submit" id="submit" value="Inserir Alunos">
					</form>
				</c:otherwise>
				</c:choose>
			</fieldset>
		</div>

	</div>
</body>
</html>