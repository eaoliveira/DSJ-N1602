<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
 <f:view>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Telefones Cadastrados</title>
  </head>
  <body>
    <center>
        <h1>Telefones Cadastrados</h1>
        <h2><h:outputText value="para #{foneLista.nome}" /></h2><br/>
        <h:form>
          <h:dataTable border="1" value="#{foneLista.dados}" var="foneItem">
            <h:column>
              <f:facet name="header"><h:outputText value="Del" /></f:facet>
              <h:selectBooleanCheckbox value="#{foneItem.del}" onclick="submit()"/>
            </h:column><h:column>
              <f:facet name="header"><h:outputText value="DDD" /></f:facet>
              <h:outputText value="#{foneItem.ddd}" />
            </h:column><h:column>
              <f:facet name="header"><h:outputText value="Número" /></f:facet>
              <h:outputText value="#{foneItem.numero}" />
            </h:column>
          </h:dataTable><br/>
          <h:commandButton action="#{foneLista.deleta}" value="Deletar os ítens selecionados" 
           rendered="#{foneLista.temFone}" />&nbsp;
          <h:commandButton action="cadFone" value="Voltar" />&nbsp;
          <h:commandButton action="#{foneLista.invalida}" value="Página Inicial" />
       </h:form>
        <hr/><p><h:messages /></p>
	 </center>
  </body>
  </f:view>
</html>
