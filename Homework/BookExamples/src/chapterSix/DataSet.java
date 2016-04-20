/**
 * Apr 6, 2009
 *
 */
package chapterSix;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 * 
 * Computes information about a set of data values.
 */
public class DataSet
{
	//Attributes
	private double sum;
	private double maximum;
	private int count;
	
	/**
	 * Constructs an empty data set.
	 */
	public DataSet()
	{
		sum = 0;
		count = 0;
		maximum = 0;
	}
	
	/**
	 * Adds a data value to the data set.
	 * @param x a data value
	 */
	public void add(double x)
	{
		sum = sum + x;
		if(count == 0 || maximum < x)
		{
			maximum = x;
		}
		count++;
	}
	
	/**
	 * Gets the average of the added data.
	 * @return the average or 0 if no data has been added
	 */
	public double getAverage()
	{
		if (count == 0)
		{
			return 0;
		}
		else
		{
			return sum / count;
		}
	}
	
	/**
	 * Gets the largest of the added data.
	 * @return the maximum or 0 if no data has ben added
	 */
	public double getMaximum()
	{
		return maximum;
	}
}
