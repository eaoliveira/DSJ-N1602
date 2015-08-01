<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="expires" content="Mon, 17 jul 2000 10:10:00 GMT" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title><c:out value="${msg.titulo}"/></title>
	<link rel="stylesheet" type="text/css" href="style/paginas.css">
  </head>
  <body>
  <div class="tabela">
      <h2><c:out value="${msg.titulo}"/></h2><hr>
      <p><c:out value="${msg.texto}"/></p><br>
      <c:choose>
    <c:when test="${empty msg.url}">
      <input type="button" value="Voltar" onclick="window.history.back(-1);" >
    </c:when>
    <c:otherwise>
      <input type="button" value="Voltar"
             onclick="window.location.replace('${msg.url}');" >
     </c:otherwise>
    </c:choose></div>
  </body>
</html>
