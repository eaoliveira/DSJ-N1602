<?xml version="1.0" encoding="UTF-8"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xsl:version="1.0">
	<head>
		<title>Visualizador de XML</title>
	</head>
	<body>
		<h2>Impressão da Informação</h2>
		<table border="1">
			<tr>
				<th>Nome</th>
				<th>DDD</th>
				<th>Telefone</th>
				<th>Ramal</th>
				<th>Departamento</th>
				<th>Empresa</th>
			</tr>
			<xsl:for-each select="/cadastro/pessoa">
				<tr>
					<td><xsl:value-of select="nome" /></td>
					<td><xsl:value-of select="telefone/@ddd" /></td>
					<td><xsl:value-of select="telefone" /></td>
					<td><xsl:value-of select="ramal" /></td>
					<td><xsl:value-of select="departamento" /></td>
					<td><xsl:value-of select="empresa" /></td>
				</tr>
			</xsl:for-each>
		</table>
	</body>
</html>