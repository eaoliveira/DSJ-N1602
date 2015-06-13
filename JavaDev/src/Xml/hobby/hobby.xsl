<?xml version="1.0"?>
<html xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
   xsl:version="1.0">
  <head><title>Meu XML</title></head>
  <body><h2>Meu XML</h2>
    <table border="1">
      <tr>
        <th align="center"><b>Nome</b></th>
        <th align="center"><b>Idade</b></th>
        <th align="center"><b>Hobby</b></th>
      </tr>
      <xsl:for-each select="/pessoas/pessoa">
      <tr>
        <td align="left"><xsl:value-of select="nome/prenome"/></td>
        <td align="center"><xsl:value-of select="@idade"/></td>
        <td align="left"><xsl:value-of select="hobby"/></td>
      </tr>
      </xsl:for-each>
    </table>
</body></html>
