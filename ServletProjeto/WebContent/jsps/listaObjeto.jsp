<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.text.SimpleDateFormat"%>
<%! SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <jsp:useBean id="objeto" class="java.util.Date" scope="session"/>
    <jsp:useBean id="objeto2" class="java.util.Date" scope="session"/>
    <jsp:useBean id="objeto3" class="java.util.Date" scope="session"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listar Objetos</title>
  </head>
  <body>
    <center>
     <form>
      <h1>Objeto Repassado na Sessão</h1>
	  <p><%= sdf.format(objeto) %>
	  <p><%= sdf.format(objeto2) %>
	  <p><%= sdf.format(objeto3) %>
	  <br><br>
      <input type="button" value="Voltar"
	         onclick="window.location.replace('index.html');">
      </form>
    </center>
  </body>
</html>
