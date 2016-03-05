<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Cadastro</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">

</head>
<body>
	<div id="wrapper">
		<header role="banner" class="group">
			<div id="logo">Quiz</div>
		</header>

		<div id="content" role="main">
			<fieldset>

				<h2><c:out value="${msg}" /></h2>
				<form id="form1" action="index.html">
					<div data-row>
						<input type="submit" id="submit" value="Voltar">
						<c:if test="${fn:startsWith(msg, 'Obrigado')}">
							<input type="submit" id="submitL" value="Lista Respostas"
								formaction="ListaQuiz">
						</c:if>
					</div>
				</form>
			</fieldset>
		</div>

	</div>
</body>
</html>