<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
<head>
<meta charset="UTF-8" />
<title>Cadastro 1/2 Boca</title>
</head>
<body>
	<h2>Cadastro 1/2 Boca</h2>
	<hr />
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Idade</th>
			<th>E-Mail</th>
		</tr>
		<xsl:apply-templates />
	</table>
</body>
		</html>
	</xsl:template>

	<xsl:template match="cliente">
		<tr>
			<td><xsl:value-of select="nome"/></td>
			<td><xsl:value-of select="nome/@idade"/></td>
			<td><xsl:value-of select="email"/></td>
		</tr>
	</xsl:template>

</xsl:stylesheet>