<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<f:view>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<title>Empresa Teste</title>
	</head>
	<body>
	<center>
	<h1>Empresa Teste</h1>
	<h3>Menu Principal</h3>
	<ol>
	    <li><h:outputLink value="cadFunc.jsf">Cadastro de Funcion&aacute;rios</h:outputLink></li>
	    <li><h:outputLink value="cadFone.jsf" disabled="#{fone.foneCount == 0}" >Cadastro de Telefones</h:outputLink></li>
	</ol>
	</center>
	</body>
</f:view>

</html>