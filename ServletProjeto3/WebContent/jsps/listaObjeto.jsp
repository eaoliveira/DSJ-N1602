<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.text.SimpleDateFormat"%>
<%! SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); %>
<!DOCTYPE html>
<html>
  <head>
    <jsp:useBean id="objeto" class="java.util.Date" scope="session"/>
    <jsp:useBean id="objeto2" class="java.util.Date" scope="session"/>
    <jsp:useBean id="objeto3" class="java.util.Date" scope="session"/>
    <meta charset="UTF-8">
    <title>Listar Objetos</title>
	<link rel="stylesheet" type="text/css" href="../style/paginas.css">
  </head>
  <body>
     <form>
      <h2>Objeto Repassado na Sessão</h2><hr>
	  <p><%= sdf.format(objeto) %>
	  <p><%= sdf.format(objeto2) %>
	  <p><%= sdf.format(objeto3) %>
	  <br><br>
      <input type="button" value="Voltar"
	         onclick="window.location.replace('bean.html');">
      </form>
  </body>
</html>
