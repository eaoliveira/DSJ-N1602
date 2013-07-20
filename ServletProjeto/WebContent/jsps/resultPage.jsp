<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="servlets.beans4.Mensagem"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <% Mensagem msg = (Mensagem)session.getAttribute("msg"); %>
    <title><%= msg.getTitulo() %></title>
  </head>
  <body>
    <center>
      <h1><%= msg.getTitulo() %></h1>
      <p><%= msg.getTexto() %></p><br>
    <%if(msg.getUrl().equals("")) { %>
      <input type="button" value="Voltar" onclick="window.history.back(-1);" >
    <% } else { %>
      <input type="button" value="Voltar"
             onclick="window.location.replace('<%= msg.getUrl() %>');" >
    <% } %>
    </center>
  </body>
</html>
