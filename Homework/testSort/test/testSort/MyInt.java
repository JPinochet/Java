/**
 * Mar 26, 2009
 */
package testSort;

/**
 * @author 432873
 *
 */
public class MyInt implements Comparable
{
	private int 		value;

	/**
	 * 
	 */
	public MyInt()
	{

	}

	/**
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
	
	
	/**
	 * @param value
	 */
	public MyInt(int value)
	{

		this.value = value;
	}
	
	public String toString()
	{
		return value+" ";
	}
	
	public int compareTo(Object o)
	{
		return value - ((MyInt)(o)).getValue();
	}

	
}
