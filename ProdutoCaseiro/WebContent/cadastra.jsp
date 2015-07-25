<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="expires" content="Mon, 17 jul 2000 10:10:00 GMT" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Produtos</title>
</head>
<body>
	<h3>Cadastro de Produtos</h3>
	<hr />
	<form action="cadProduto">
		Nome: <input type="text" name="nome" size="20"> Descricao<br>
		<textarea cols=50 rows=10 name="desc"></textarea>
		<br> Preço: <input type="text" name="preco" size="20">
		Validade: <input type="text" name="validade" size="20"><br>
		<input type="submit" value="enviar">
	</form>
</body>
</html>