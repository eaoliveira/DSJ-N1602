<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:template match="/">
		<html>
			<head>
				<title>Hobbies</title>
				<meta charset="UTF-8" />
				<link rel="stylesheet"  type="text/css" href="style.css" />
			</head>
			<body>
				<h2>Meu XML</h2>
				<table border="1">
					<tr>
						<th align="center">Nome</th>
						<th align="center">Idade</th>
						<th align="center">Hobby</th>
					</tr>
					<xsl:apply-templates />
				</table>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="pessoa">
		<tr>
			<td><xsl:value-of select="nome/prenome" /></td>
			<td><xsl:value-of select="@idade" /></td>
			<td><xsl:value-of select="hobby" /></td>
		</tr>
	</xsl:template>
	
</xsl:stylesheet>