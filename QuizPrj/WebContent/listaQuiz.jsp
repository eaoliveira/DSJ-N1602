<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<form id="form1" action="index.html">
					<div id="center">
						<div id="toLeft">
							<p><b>Qtd.</b></p>
							<p><em><c:out value="${ate18}" /></em></p>
							<p><em><c:out value="${ate26}" /></em></p>
							<p><em><c:out value="${ate35}" /></em></p>
							<p><em><c:out value="${ate99}" /></em></p>
						</div>
						<div id="toRight">
							<p><b>Resposta</b></p>
							<p><span>até 18</span></p>
							<p><span>de 19 até 26</span></p>
							<p><span>de 27 até 35</span></p>
							<p><span>acima de 35</span></p>
						</div>
					</div>
					<div data-row>
						<input type="submit" id="submit" value="Voltar">
					</div>
				</form>
			</fieldset>
		</div>

	</div>
</body>
</html>