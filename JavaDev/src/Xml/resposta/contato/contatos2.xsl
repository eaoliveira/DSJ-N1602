<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  
  <xsl:template match="/">
    <html>
      <head>
        <title>Meus contatos</title>
      </head>
      <body>
        <table border="1">
		  <tr>
		    <th align="center">Nome</th>
		    <th align="center">Departamento</th>
		    <th align="center">Empresa</th>
		    <th align="center">Telefone</th>
		  </tr>
		  <xsl:apply-templates />
	    </table>
      </body>
    </html>
  </xsl:template>
		
  <xsl:template match="/contatos/contato">
   <tr>
    <td><xsl:value-of select="nome"/></td>
    <td><xsl:value-of select="departamento"/></td>
    <td><xsl:value-of select="empresa"/></td>
    <td>
     <table border="0" width="100%">
      <xsl:for-each select="telefone">
      <tr>
       <td><xsl:value-of select="@ddd"/></td>
       <td><xsl:value-of select="@numero"/></td>
       <td><xsl:value-of select="@ramal"/></td>
      </tr>
      </xsl:for-each>
     </table>
    </td>
   </tr>
  </xsl:template>
  
</xsl:stylesheet>