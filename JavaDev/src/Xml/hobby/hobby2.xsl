<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
		<html>
			<head>
				<title>Hobbies</title>
				<meta charset="UTF-8" />
				<link rel="stylesheet" type="text/css"
					href="style.css" />
			</head>
			<body>
				<h2>Meu XML</h2>
				<div class="Tabela">
					<div class="Cabecalho">
						<span class="Celula">Nome</span>
						<span class="Celula">Idade</span>
						<span class="Celula">Hobby</span>
					</div>
					<xsl:apply-templates />
				</div>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="pessoa">
		<div class="Linha">
			<span class="Celula">
				<xsl:value-of select="nome/prenome" />
			</span>
			<span class="Celula Centralizado">
				<xsl:value-of select="@idade" />
			</span>
			<span class="Celula">
				<xsl:value-of select="hobby" />
			</span>
		</div>
	</xsl:template>

</xsl:stylesheet>