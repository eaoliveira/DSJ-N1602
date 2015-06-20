<?xml version="1.0"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xsl:version="1.0">
	<head>
		<title>Meu XML</title>
	</head>
	<body>
		<h2>Meu XML</h2>
		<table border="1">
			<tr>
				<th align="center">
					<b>Nome</b>
				</th>
				<th align="center">
					<b>DDD</b>
				</th>
				<th align="center">
					<b>Telefone</b>
				</th>
				<th align="center">
					<b>Ramal</b>
				</th>
				<th align="center">
					<b>Empresa</b>
				</th>
				<th align="center">
					<b>Departamento</b>
				</th>
			</tr>
			<xsl:for-each select="/cadastro/funcionario">
				<tr>
					<td width="10%">
						<xsl:value-of select="nome" />
					</td>
					<td width="10%">
						<xsl:value-of select="telefone/@ddd" />
					</td>
					<td width="10%">
						<xsl:value-of select="telefone" />
					</td>
					<td width="10%">
						<xsl:value-of select="telefone/@ramal" />
					</td>
					<td width="10%">
						<xsl:value-of select="departamento" />
					</td>
					<td width="10%">
						<xsl:value-of select="empresa" />
					</td>
					
				</tr>
			</xsl:for-each>
		</table>
	</body>
</html>
