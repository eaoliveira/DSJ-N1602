<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
  <title>Associa&ccedil;&atilde;o Esportiva - Body Mass</title>
  <!-- base href="http://127.0.0.1"></base -->
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
  <link rel="stylesheet" href="styles/home.css"/>
</head>
<body><center>
<table width="90%">
  <tbody>
    <tr>
      <td align="center"><a href="index.html"><img src="images/header.gif" border="0"/></a></td>
    </tr>
  </tbody>
</table>

<!-- Início Corpo da página  -->

<table width="90%">
  <tbody>
    <tr align="center" valign="top">
   	  <td class="pequeno" width="20%">
   	    <table>
   	      <tr><td><img src="images/percapeso.jpg"/></td></tr>
   	      <tr><td><img src="images/diet.jpg"/></td></tr>
 	    </table>
 	  </td>
   	  <td width="60%" valign="top">
   	    <table class="centro">
   	      <tr><td>
   	        <table class="titulo" width="100%" cellpadding="0" cellspacing="0">
     	      <tr><td width="800px">Administra&ccedil;&atilde;o</td></tr>
     	    </table>
     	  </td></tr>
   	      <tr><td class="coluna">
   	      <!-- Insira aqui seu código -->
   	      <f:view>
             <table width="100%" cellpadding="0" cellspacing="0"><tr id="links">
                 <h:form>
                   <td><h:commandButton   action="#{associado.editar}" disabled="#{associado.edita}" value="Associado" /></td>
                   <td><h:commandButton   action="#{atividade.editar}" disabled="#{atividade.edita}" value="Atividade" /></td>
                 </h:form>
                </tr><tr>
     	           <td colspan="2">
     	              <h:form rendered="#{associado.edita}">
     	                 <p/>
                         <p/>Nome <h:inputText value="#{associado.nome}" size="40" />
                         <p/>Idade <h:inputText value="#{associado.idade}" size="5" />&nbsp;&nbsp;
                         Fone <h:inputText value="#{associado.telefone}" size="10" />
                        <p/>End. <h:inputText value="#{associado.endereco}" size="50" />
                        <p/>E-Mail <h:inputText value="#{associado.email}" size="25" />
                        <p/><h:commandButton value="Enviar" action="#{associado.grava}"/>&nbsp;&nbsp;
                        <h:commandButton value="Cancelar" action="#{associado.naoEditar}"/>
                      </h:form>
     	              <h:form rendered="#{atividade.edita}">
     	                  <p/>
                          <p/>Nome <h:inputText value="#{atividade.nome}" size="20" />&nbsp;&nbsp;
                          Valor <h:inputText value="#{atividade.valor}" size="10" >
                            <f:converter  converterId="ConverteDouble" />
                          </h:inputText>
                          <p/><h:commandButton value="Enviar" action="#{atividade.grava}"/>&nbsp;&nbsp;
                          <h:commandButton value="Cancelar" action="#{atividade.naoEditar}"/>
                      </h:form>
                   </td>
     	          </tr>
     	      </table>
     	   </f:view>
     	   <!-- fim do Insira aqui seu código -->
     	   </td></tr>
   	    </table>
   	  </td>
   	  <td class="pequeno" width="20%">
   	    <table>
   	      <tr><td class="pq_negrito">
   	        A reeducação alimentar associada à atividade física,
   	      </td></tr>
   	      <tr><td><img src="images/bicicletas.jpg"/></td></tr>
   	      <tr><td class="pq_negrito">
  	        com o acompanhamento de excelentes profissionais,
   	      </td></tr>
   	      <tr><td><img src="images/pesos.jpg"/></td></tr>
   	      <tr><td class="pq_negrito">
  	        lhe trará a siluera dos seus sonhos
   	      </td></tr>
   	      <tr><td><img src="images/silueta.jpg"/></td></tr>
   	    </table>
   	  </td>
   	  </tr>
  </tbody>
</table>

<!-- Fim Corpo da página  -->

</center>
</body>
</html>
