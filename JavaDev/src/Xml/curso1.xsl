<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:template match="/">
<html>
<head>
<title>Tabela de Cursos</title>
</head><body>
	<table border="1">
		<xsl:for-each select="/cursos/curso">
		  <tr>
		    <td><xsl:value-of select="materia"/></td>
		    <td>
		      <table border="1">
		      <tr>
		         <xsl:for-each select="modulo">
			        <td><xsl:value-of select="." /></td>
		         </xsl:for-each>
		      </tr>
		    </table>
		   </td>
		</tr>
		</xsl:for-each>
		</table>
	</body>
</html>
</xsl:template>
</xsl:stylesheet>