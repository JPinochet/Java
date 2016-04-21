<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
		<xsl:template match="/wells">
			<html>
				<body>
					<xsl:for-each select="well" >
						<b>Location:</b> <xsl:value-of select="location" />						<br />
						<b>Well Depth:</b> <xsl:value-of select="wellDepth" />						<br />
						<b>Perforation Depth:</b> <xsl:value-of select="perfDepth" />						<br />
						<b>Perforation Zone:</b> <xsl:value-of select="perdZone" />						<br />
						<b>Stroke Length:</b> <xsl:value-of select="strokeLength" />						<br />
						<b>Stroke Per Minute:</b> <xsl:value-of select="strokePM" />						<br />
						<hr /><br />
					</xsl:for-each>
				</body>
			</html>
		</xsl:template>
</xsl:stylesheet>
