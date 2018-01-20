<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
<html>
    <head>
        <title>Transformacion XSLT</title>
        <link rel="stylesheet" type="text/css" href="mml.css"/>
    </head>
    <body>
        <div class="principal">
        <h2>Transformacion XSLT del fichero del año: <xsl:value-of select="/Movies/Anio"/></h2>
        <div>
        <table border="2" align="center">  
            <tr>
                <th style="text-align:center">Pais</th>
                <th style="text-align:center">Lang</th>
                <th style="text-align:center">Pelicula</th>
                <th style="text-align:center">IP</th>
                <th style="text-align:center">Langs</th>
                <th style="text-align:center">Generos</th>
                <th style="text-align:center">Duracion</th>
                <th style="text-align:center">Nombre</th>
                <th style="text-align:center">Personaje</th>
                <th style="text-align:center">Oscar</th>
                <th style="text-align:center">Otra Pelicula</th>
                <th style="text-align:center">Anio</th>
                <th style="text-align:center">MML</th>
            </tr>
            <xsl:for-each select="Movies/Pais">
                <xsl:variable name="pais" select="@pais"/>
                <xsl:variable name="lang" select="@lang"/>
                <xsl:for-each select="Pelicula">
                    <xsl:variable name="pelicula" select="Titulo"/>
                    <xsl:variable name="ip" select="@ip"/>
                    <xsl:variable name="langs" select="@langs"/>
                    <xsl:variable name="generos" select="Generos"/>
                    <xsl:variable name="duracion" select="Duracion"/>
                        <xsl:for-each select="Reparto">
                        <tr>
                            <td><xsl:value-of select="$pais"/></td>
                            <td><xsl:value-of select="$lang"/></td>
                            <td><xsl:value-of select="$pelicula"/></td>
                            <td><xsl:value-of select="$ip"/></td>
                            <td><xsl:value-of select="$langs"/></td>
                            <td><xsl:value-of select="$generos"/></td>
                            <td><xsl:value-of select="$duracion"/></td>
                            <td><xsl:value-of select="Nombre"/></td>
                            <td><xsl:value-of select="Personaje"/></td>
                            <td><xsl:value-of select="Oscar"/></td>
                            <td colspan="3"/>
                        </tr>
                            <xsl:for-each select="OtraPelicula">
                            <tr>
                                <td colspan="10"/>
                                <td><xsl:value-of select="Titulo"/><xsl:value-of select="ip"/></td>
                                <td><xsl:value-of select="@anio"/></td>
                                <td><xsl:value-of select="MML"/></td>
                            </tr>
                            </xsl:for-each>
                        </xsl:for-each>
                    </xsl:for-each>

            </xsl:for-each>
        </table>
        </div>
        <footer>
            <p>Diseñado por: Adrián Vázquez Saavedra</p>
        </footer>
        </div>
    </body>
</html>
</xsl:template>
</xsl:stylesheet>
