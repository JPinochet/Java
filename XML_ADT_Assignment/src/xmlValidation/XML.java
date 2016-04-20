/**
 * 
 */
package xmlValidation;

/**
 * @author 432873
 *
 */
public class XML implements Comparable<Object>
{
	public String xmlDesc;
	
	public XML(String uml)
	{
		this.xmlDesc = uml;
	}

	public String getXmlDesc()
	{
		return xmlDesc;
	}

	public void setXmlDesc(String xmlDesc)
	{
		this.xmlDesc = xmlDesc;
	}

	public String toString()
	{
		return xmlDesc;
	}
	
	@Override
	public int compareTo(Object o)
	{
		return this.xmlDesc.compareToIgnoreCase(((XML) o).getXmlDesc());
	}
}
