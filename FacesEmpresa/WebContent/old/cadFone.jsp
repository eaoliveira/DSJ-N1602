<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
  <f:view>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Cadastro de Telefones</title>
  </head>
  <body>
    <center>
      <h1>Cadastro de Telefones</h1>
      <h:form id="fone">
        DDD: <h:inputText value="#{fone.ddd}" size="2" /><br/><br/>
        N&uacute;mero: <h:inputText value="#{fone.numero}" size="9" /><br/><br/>
        <h:selectOneMenu value="#{fone.func}" onchange="submit()" 
           valueChangeListener="#{fone.funcChanged}" >
           <f:selectItems value="#{fone.funcLista}" />
        </h:selectOneMenu><br/><br/>
        <h:commandButton action="#{fone.inclui}" value="Enviar" />&nbsp;
        <h:commandButton action="listaFone" value="Lista Telefones" 
         rendered="#{fone.temFone}" />&nbsp;
        <h:commandButton action="#{fone.invalida}" value="Voltar" />
      </h:form>
      <hr/><p><h:messages/></p>
    </center>
  </body>
  </f:view>
</html>
