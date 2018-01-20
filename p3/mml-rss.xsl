<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <rdf:RDF    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                xmlns="http://purl.org/rss/1.0/">
        <xsl:variable name="anio" select="/Movies/Anio"/>
        <channel rdf:about="http://gssi.det.uvigo.es/users/agil/public_html/SINT/17-18/mml{$anio}.xml">
                <title><xsl:value-of select="/Movies/Anio"/></title>
                <link>http://gssi.det.uvigo.es/users/agil/public_html/SINT/17-18/mml<xsl:value-of select="$anio"/>.xml</link>
                <description>Peliculas del año: <xsl:value-of select="$anio"/></description>
                <items>
                    <rdf:Seq>
                        <xsl:for-each select="/Movies/Pais/Pelicula">
                            <xsl:variable name="id" select="Titulo"/>
                            <xsl:variable name="contador" select="position()"/>
                            <rdf:li rdf:resource="http://localhost/{$contador}.xml"/>
                        </xsl:for-each>
                    </rdf:Seq>
                </items>
            </channel>
            <xsl:for-each select="/Movies/Pais/Pelicula">
                <xsl:variable name="id" select="Titulo"/>
                <xsl:variable name="contador" select="position()"/>
                <item rdf:about="http://localhost/{$contador}.xml">
                    <title><xsl:value-of select="$id"/></title>
                    <link>http://localhost/<xsl:value-of select="$contador"/>.xml</link>
                    <description>
                        Generos: <xsl:value-of select="Generos"/>, Duracion: <xsl:value-of select="Duracion"/>
                    </description>
                </item>
            </xsl:for-each>
    </rdf:RDF>
</xsl:template>
</xsl:stylesheet>
