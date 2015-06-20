<?xml version="1.0"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
   xsl:version="1.0">

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</meta>
</head>

<body>
<h2>Meu HTML</h2>
<table border="1">
	<tr>
		<th align="center"><b>Nome</b></th>
		<th align="center"><b>Telefone</b></th>
		<th align="center"><b>Departamento</b></th>
		<th align="center"><b>Empresa</b></th>
	</tr>
	
	<xsl:for-each select="/contatos/pessoa">
	    <tr>
        <td align="left"><xsl:value-of select="nome"/></td>
        <td align="center"><xsl:value-of select="telefone/@ddd" /><xsl:value-of select="telefone/@numero"/></td>
        <td align="left"><xsl:value-of select="departamento" /></td>
        <td align="left"><xsl:value-of select="empresa"/></td>
      </tr>
	</xsl:for-each>
	
</table>
</body>
</html>