<?xml version="1.0"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xsl:version="1.0">
<head>
<title>Meus contatos</title>
</head>
<body>
<table border="1">
  <xsl:for-each select="/contatos/contato">
   <tr>
    <td><xsl:value-of select="nome"/></td>
    <td><xsl:value-of select="departamento"/></td>
    <td><xsl:value-of select="empresa"/></td>
    <td>
     <table border="0" width="100%">
      <xsl:for-each select="telefone">
      <tr>
       <td width="30%"><xsl:value-of select="@ddd"/></td>
       <td width="40%"><xsl:value-of select="@numero"/></td>
       <td width="30%"><xsl:value-of select="@ramal"/></td>
      </tr>
      </xsl:for-each>
     </table>
    </td>
   </tr>
  </xsl:for-each>
</table>
</body>
</html>
