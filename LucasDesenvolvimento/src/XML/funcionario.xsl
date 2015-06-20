<?xml version="1.0"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xsl:version="1.0">
	<head>
		<title>Cadastro Funcionario</title>
	</head>
	<body>
		<h2>Cadastro Funcionario</h2>
		<table border="1">
			<tr>
				<th align="center">Nome</th>
				<th align="center">Telefone</th>
				<th align="Left">DDD</th>
				<th align="left">Ramal</th>
				<th align="center">Nome Deparatmento</th>
			</tr>
			<xsl:for-each select="/departamento/funcionario">

				<tr>
					<td align="center"><xsl:value-of select="nome" />
					</td>
					<td align="center"><xsl:value-of select="telefone/numero" />
					</td>
					<td align="Left"><xsl:value-of select="telefone/ddd" />
					</td>
					<td align="left"><xsl:value-of select="telefone/ramal" />
					</td>
					<td align="center"><xsl:value-of select="nomedept" />
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</body>
</html>