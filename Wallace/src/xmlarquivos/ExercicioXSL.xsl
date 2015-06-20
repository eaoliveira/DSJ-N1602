<?xml version="1.0"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xsl:version="1.0">
	<head>
		<META charset="ISO-8859-1" />
		<link rel="stylesheet" href="style.css" type="text/css" />
	</head>
	<body>
		<table border="1" align="center">
			<tr>
				<td>0</td>
				<td>Nome</td>
				<td>DDD</td>
				<td>Numero</td>
				<td>Ramal</td>
				<td>Departamento</td>
				<td>Empresa</td>
			</tr>
			<xsl:for-each select="/informacoes/contato">
				<tr>
					<td>1</td>
					<td><xsl:value-of select="nome" /></td>
					<td><xsl:value-of select="telefone/@ddd" /></td>
					<td><xsl:value-of select="telefone/@numero" /></td>
					<td><xsl:value-of select="telefone/@ramal" /></td>
					<td><xsl:value-of select="nomedepart" /></td>
					<td><xsl:value-of select="nomeempresa" /></td>
				</tr>
			</xsl:for-each>

		</table>
	</body>
</html>