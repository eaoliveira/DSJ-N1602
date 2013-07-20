<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <jsp:useBean id="msg" type="servlets.beans4.Mensagem" scope="session" />
    <title><jsp:getProperty name="msg" property="titulo"/></title>
  </head>
  <body>
    <center>
      <h1><jsp:getProperty name="msg" property="titulo"/></h1>
      <p><jsp:getProperty name="msg" property="texto"/></p><br>
    <%if(msg.getUrl().equals("")) { %>
      <input type="button" value="Voltar" onclick="window.history.back(-1);" >
    <% } else { %>
      <input type="button" value="Voltar"
             onclick="window.location.replace('<jsp:getProperty name="msg" property="url" />');" >
    <% } %>
    </center>
  </body>
</html>
