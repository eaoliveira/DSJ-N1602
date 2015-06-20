<?xml version="1.0" encoding="UTF-8"?>
<html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<head><title>Clientes</title></head>
	<body>
		<table border="1">
				<td>Nome</td>
				<!-- >td>DDD</td-->
				<td>Telefone</td>
				<td>Ramal</td>
				<td>Departamento</td>
				<td>Empresa</td>
			<xsl:for-each select="/cadastro/cliente">
				<tr>
					<td><xsl:value-of select="nome" /></td>
					<!--  td><xsl:value-of select="ddd" /></td--> 
					<td><xsl:value-of select="ddd" />-<xsl:value-of select="telefone" /></td>
					<td><xsl:value-of select="telefone/@ramal" /></td>
					<td><xsl:value-of select="departamento" /></td> 
					<td><xsl:value-of select="empresa" /></td> 
				</tr>
			 </xsl:for-each>
		</table>
	</body>
</html>
