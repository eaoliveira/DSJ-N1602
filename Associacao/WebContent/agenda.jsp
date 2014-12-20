<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
  <title>Associa&ccedil;&atilde;o Esportiva - Body Mass</title>
  <!-- base href="http://127.0.0.1"></base -->
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
  <meta http-equiv="expires" content="mon, 27 sep 2010 14:30:00 GMT"/>
  <meta http-equiv="pragma" content="no-cache"/>
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
     	      <tr><td width="800px">Agenda</td></tr>
     	    </table>
     	  </td></tr>
   	      <tr><td class="coluna">
   	      <!-- Insira aqui seu código -->
   	      <f:view>
             <table width="100%" cellpadding="0" cellspacing="0"><tr>
     	           <td colspan="2">
     	              <h:form>
     	              
     	                    <!-- formulario que lista os associados  -->
     	              		<h:dataTable var="ass" value="#{associado.lista}" rendered="#{not agenda.mostra}">
     	              			<h:column>
     	              				<f:facet name="header"><h:outputText value="Codigo" /></f:facet>
     	              				<h:commandLink action="#{agenda.mostrarAgenda}" >
     	              				    <f:setPropertyActionListener target="#{agenda.idAssociado}" value="#{ass.id}" />
     	              				    <f:setPropertyActionListener target="#{agenda.nome}" value="#{ass.nome}" />
     	              				    <h:outputText value="#{ass.id}" >
     	              					  <f:convertNumber pattern="00000"/>
     	              					</h:outputText>
     	              				</h:commandLink>
     	              			</h:column>
     	              			<h:column>
     	              				<f:facet name="header"><h:outputText value="Nome" /></f:facet>
     	              				<h:outputText  value="#{ass.nome}" />
     	              			</h:column>
     	              		</h:dataTable>
     	              		
     	              		<!-- campos que listam a agenda de um associado -->
     	              		<center>
     	              		   <h:outputText value="#{agenda.nome}" rendered="#{agenda.mostra}">
     	              		   </h:outputText>
     	              		   <h:dataTable var="ag" value="#{agenda.lista}" rendered="#{agenda.mostra}">
     	              		   	<h:column>
     	              		   		<f:facet name="header"><h:outputText value="Atividade"/></f:facet>
     	              		   		<h:outputText value="#{ag.atividade.nome}" />
     	              		   	</h:column>
     	              		   	<h:column>
     	              		   		<f:facet name="header"><h:outputText value="Horario"/></f:facet>
     	              		   		<h:outputText value="#{ag.horario.nome}" />
     	              		   	</h:column>
     	              		   </h:dataTable>
     	              		   <hr/>
     	              		   <h:commandButton value="Novo Agendamento" action="#{agenda.mostrarInsere }" rendered="#{agenda.mostra}"/>&nbsp;&nbsp;&nbsp;
     	              		   <h:commandButton value="Voltar" action="#{agenda.escondeAgenda}" rendered="#{agenda.mostra}"/>
     	              		   
     	              		   <!-- campos de inclusão de um novo horario na agenda  -->
     	              		   <br/><br/><h:outputText value="Atividade" rendered="#{agenda.insere}"/>&nbsp;
     	              		   <h:selectOneMenu value="#{agenda.idAtividade}" rendered="#{agenda.insere}">
     	              		   		<f:selectItems value="#{agenda.atividades}"/>
     	              		   </h:selectOneMenu><br/>
     	              		   <h:selectOneRadio value="#{agenda.horario}"  rendered="#{agenda.insere}">
     	              		   		<f:selectItems value="#{agenda.horarios}"/>
     	              		   </h:selectOneRadio><br/>
     	              		   <h:commandButton value="Adiciona" action="#{agenda.gravaHorario}" rendered="#{agenda.insere}"/>&nbsp;&nbsp;&nbsp;
     	              		   <h:commandButton value="Voltar" action="#{agenda.escondeInsere}" rendered="#{agenda.insere}"/>
     	              		</center>
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
  	        lhe trará a silueta dos seus sonhos
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
