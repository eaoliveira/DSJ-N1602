<?xml version="1.0"?>
<html 
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
   xsl:version="1.0">
  <head><title>Meu XML</title></head>
  <body><h2>Meu XML</h2>
    <table border="1">
      <tr>
        <th align="center"><b>Titulo</b></th>
        <th align="center"><b>estilo</b></th>
        <th align="center"><b>idade</b></th>
      </tr><xsl:for-each select="/filmes/filme">
      <tr>
        <td align="left"><xsl:value-of select="titulo"/></td>
        <td align="center"><xsl:value-of select="@estilo"/></td>
        <td align="left"><xsl:value-of select="idade"/></td>
      </tr></xsl:for-each>
    </table>
</body></html>
