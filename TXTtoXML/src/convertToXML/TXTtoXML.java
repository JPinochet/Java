/**
 * 
 */
package convertToXML;

import fileHandling.*;
import java.util.*;

/**
 * @author 432873
 *
 */
public class TXTtoXML 
{
	public TXTtoXML()
	{
		
	}
	
	/**
	 * Method reads a txt file from the res directory and reads it in. Afterwards
	 * it converts it into an xml document
	 */
	public void readWellDataAndLoadWellXML()
	{
		FileInput fin = new FileInput("res/wellDataFile.txt");
		FileOutput out = new FileOutput("res/wells.xml");
		String line = fin.readLine();
		
		String location;
		double wellDepth, perforationDepth, perforationZone, strokeLength;
		int strokesPerMinutes;
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("\n");
		out.println("\n");
		out.println("<!DOCTYPE wells SYSTEM \"wellDataDTD.dtd\">");
		out.println("\n");
		out.println("\n");
		out.println("<wells>");
		out.println("\n");
		out.println("\n");
		
		while(line != null)
		{
			StringTokenizer st = new StringTokenizer (line," ;");
			location = st.nextToken();
			wellDepth = Double.parseDouble(st.nextToken());
			perforationDepth = Double.parseDouble(st.nextToken());
			perforationZone = Double.parseDouble(st.nextToken());
			strokeLength = Double.parseDouble(st.nextToken());
			strokesPerMinutes = Integer.parseInt(st.nextToken());
			
			out.println("\t<well>");
			out.println("\n");
			out.println("\t\t<location>" + location + "</location>");
			out.println("\n");
			out.println("\t\t<wellDepth>" + wellDepth + "</wellDepth>");
			out.println("\n");
			out.println("\t\t<perfDepth>" + perforationDepth + "</perfDepth>");
			out.println("\n");
			out.println("\t\t<perdZone>" + perforationZone + "</perdZone>");
			out.println("\n");
			out.println("\t\t<strokeLength>" + strokeLength + "</strokeLength>");
			out.println("\n");
			out.println("\t\t<strokePM>" + strokesPerMinutes + "</strokePM>");
			out.println("\n");
			out.println("\t</well>");
			out.println("\n");
			out.println("\n");
			
			line = fin.readLine();
		}
		
		out.println("</wells>");
		
		fin.closeInputFile();
		out.closeOutputFile();
	}
	
	/**
	 * Method reads a txt file from the res directory and reads it in. Afterwards
	 * it converts it into an xsl to convert to html from xml.
	 */
	public void createXMLToHTML()
	{
		FileOutput out = new FileOutput("res/wellsAsHTML.xsl");
		
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("\n");
		out.println("<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
		out.println("\n");
		out.println("\t<xsl:output method=\"html\"/>");
		out.println("\n");
		out.println("\t\t<xsl:template match=\"/wells\">");
		out.println("\n");
		out.println("\t\t\t<html>");
		out.println("\n");
		out.println("\t\t\t\t<body>");
		out.println("\n");
		out.println("\t\t\t\t\t<xsl:for-each select=\"well\" >");
		out.println("\n");
			
		out.println("\t\t\t\t\t\t<b>Location:</b> <xsl:value-of select=\"location\" />");
		out.print("\t\t\t\t\t\t<br />");
		out.println("\n");
		out.println("\t\t\t\t\t\t<b>Well Depth:</b> <xsl:value-of select=\"wellDepth\" />");
		out.print("\t\t\t\t\t\t<br />");
		out.println("\n");
		out.println("\t\t\t\t\t\t<b>Perforation Depth:</b> <xsl:value-of select=\"perfDepth\" />");
		out.print("\t\t\t\t\t\t<br />");
		out.println("\n");
		out.println("\t\t\t\t\t\t<b>Perforation Zone:</b> <xsl:value-of select=\"perdZone\" />");
		out.print("\t\t\t\t\t\t<br />");
		out.println("\n");
		out.println("\t\t\t\t\t\t<b>Stroke Length:</b> <xsl:value-of select=\"strokeLength\" />");
		out.print("\t\t\t\t\t\t<br />");
		out.println("\n");
		out.println("\t\t\t\t\t\t<b>Stroke Per Minute:</b> <xsl:value-of select=\"strokePM\" />");
		out.print("\t\t\t\t\t\t<br />");
		out.println("\n");
		out.println("\t\t\t\t\t\t<hr /><br />");
		out.println("\n");
		
				
		out.println("\t\t\t\t\t</xsl:for-each>");
		out.println("\n");
		out.println("\t\t\t\t</body>");
		out.println("\n");
		out.println("\t\t\t</html>");
		out.println("\n");
		out.println("\t\t</xsl:template>");
		out.println("\n");
		out.println("</xsl:stylesheet>");
		out.println("\n");
		
		out.closeOutputFile();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		TXTtoXML convert = new TXTtoXML();
		convert.readWellDataAndLoadWellXML();
		convert.createXMLToHTML();
	}
}
