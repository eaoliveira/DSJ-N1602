<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<f:view>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Funcion&aacute;rios Cadastrados</title>
  </head>
  <body>
    <center>
        <h1>Funcion&aacute;rios Cadastrados</h1>
        <h:form>
          <h:dataTable border="1" value="#{funcLista.dados}" var="funcItem" >
          <h:column>
            <f:facet name="header"><h:outputText value="Del" /></f:facet>
            <h:selectBooleanCheckbox value="#{funcItem.del}" onclick="submit()" />
          </h:column><h:column>
            <f:facet name="header"><h:outputText value="Nome" /></f:facet>
            <h:outputText value="#{funcItem.nome}" />
          </h:column><h:column>
            <f:facet name="header"><h:outputText value="Matrícula" /></f:facet>
            <h:outputText value="#{funcItem.matricula}" />
          </h:column>
          </h:dataTable><br/>
          <h:commandButton action="#{funcLista.deleta}" value="Deletar os ítens selecionados" 
            rendered="#{funcLista.dados.rowCount > 0}" />&nbsp;
          <h:commandButton action="cadFunc" value="Voltar" />&nbsp;
          <h:commandButton action="menu" value="Página Inicial" />
       </h:form>
       <hr/><p><h:messages /></p>
	 </center>
  </body>
</f:view>
</html>
