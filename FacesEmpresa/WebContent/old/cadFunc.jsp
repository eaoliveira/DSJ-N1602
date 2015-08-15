<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<f:view>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
  <title>Cadastro de Funcion&aacute;rios</title>
 </head>
 <body>
  <center>
   <h1>Cadastro de Funcion&aacute;rios</h1>
   <h:form>
	 <table>
	  <tr><td>Nome: <h:inputText  value="#{func.nome}" size="25" /></td></tr>
	  <tr><td>Matr&iacute;cula: <h:inputText value="#{func.matricula}" size="6" /></td></tr>
      <tr><td>Telefone: <h:inputText value="#{func.telefone}" size="9" /></td></tr>
     </table>
	 <h:commandButton action="#{func.inclui}" value="Enviar" />&nbsp;
	 <h:commandButton action="listaFunc" value="Lista Funcionarios" 
	         rendered="#{funcLista.temFuncionario}" />&nbsp;
	 <h:commandButton action="menu" value="Voltar" />
	 <h:inputHidden value="#{msg.url}" />
	</h:form>
	<hr/>
      <p><h:messages /></p>
   </center>
  </body>
 </f:view>
</html>
