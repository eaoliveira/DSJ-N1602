<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="servlets.beans4.Mensagem"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlets</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Servlets</title>
<link rel="stylesheet" type="text/css" href="../style/style.css">
</head>
<body>
	<div id="wrapper">
		<header role="banner" class="group">
			<div id="logo"><a href="/">Utilizando Java Beans</a></div>
			<nav role="navigation">
				<ul id="mainNav">
					<li><a href="ThreeParamsForm.html">Argumentos</a></li>
					<li><a href="ApplesAndOranges.xls">Planilha</a></li>
					<li><a href="WrongDestination">Redirecionamento</a></li>
					<li><a href="ShadowedText.html">Texto</a></li>
					<li><a href="telaDados.html">Entrada de dados</a></li>
					<li><a href="cookie.html">Cookies</a></li>
					<li><a href="bean.html">Java Beans</a></li>
				</ul>
			</nav>
		</header>

		<div id="content" role="main">
			<h2><c:out value="${msg.titulo}" /></h2>
			<p><c:out value="${msg.texto}" /></p>
		</div>

	</div>
</body>
</html>