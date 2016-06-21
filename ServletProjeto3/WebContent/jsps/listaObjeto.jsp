<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
    import="java.text.SimpleDateFormat"%>
<%!SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Servlets</title>
<link rel="stylesheet" type="text/css" href="../style/style.css">

<jsp:useBean id="objeto" class="java.util.Date" scope="session" />
<jsp:useBean id="objeto2" class="java.util.Date" scope="session" />
<jsp:useBean id="objeto3" class="java.util.Date" scope="session" />

</head>
<body>
	<div id="wrapper">
		<header role="banner" class="group">
			<div id="logo"><a href="../">Utilizando Java Beans</a></div>
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
			<h2>Objeto Repassado na Sessão</h2>
			<p><%=sdf.format(objeto)%></p>
			<p><%=sdf.format(objeto2)%></p>
			<p><%=sdf.format(objeto3)%></p>
		</div>

	</div>
</body>
</html>
