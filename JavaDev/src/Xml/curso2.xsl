<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:template match="/">
<html>
<body>
	<h3>Lista de Cursos</h3>
	<hr />
	<table border="1">
		<tr>
			<td>materia</td>
			<td>modulo</td>
		</tr>
		<xsl:for-each select="cursos/curso">
		<tr>
			<td><xsl:value-of select="@materia"/></td>
			<td><xsl:value-of select="@modulo"/></td>
		</tr>
		</xsl:for-each>
	</table>
	<hr />
</body>
</html>
</xsl:template>
</xsl:stylesheet>