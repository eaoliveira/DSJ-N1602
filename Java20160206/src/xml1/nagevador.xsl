<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
<head>
<title>Hobbies</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>
	<h2>Testando xsl</h2>
	<table border="1">
		<tr>
			<th align="center">nome</th>
			<th align="center">ddd numero ramal</th>
			<th align="center">dpto / empresa</th>
		</tr>
		<xsl:apply-templates />

	</table>
</body>
		</html>
	</xsl:template>

	<xsl:template match="pessoa">
		<tr>
			<td><xsl:value-of select="nome" /></td>
			<td><xsl:value-of select="ddd" /></td>
			<td><xsl:value-of select="numero" /></td>
			<td><xsl:value-of select="ramal" /></td>
			<td><xsl:value-of select="dpto" /></td>
			<td><xsl:value-of select="empresa" /></td>
		</tr>
	</xsl:template>

</xsl:stylesheet>
