<?xml version="1.0" encoding="UTF-8"?>
<html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
<head><title>Cadastro XML</title></head>
 <body><h2>Cadastro XML</h2>
    <table border="1">
      <tr>
      	<th align="center"><b>Nome</b></th>
		<th align="center"><b>Telefone</b></th>
		<th align="center"><b>DDD</b></th>
		<th align="center"><b>Ramal</b></th>
		<th align="center"><b>Departamento</b></th>
		<th align="center"><b>Empresa</b></th>        
      </tr>
      <xsl:for-each select="/cadastroteste/contato">
      <tr>
        <td align="left"><xsl:value-of select="nome"/></td>
        <td align="center"><xsl:value-of select="telefone"/></td>
        <td align="center"><xsl:value-of select="telefone/@ramal"/></td>
        <td align="center"><xsl:value-of select="telefone/@ddd"/></td>
        <td align="left"><xsl:value-of select="departamento"/></td>
        <td align="center"><xsl:value-of select="empresa"/></td>
      </tr>
      </xsl:for-each>
    </table>
</body></html>
		
