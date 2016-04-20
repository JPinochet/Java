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
 * This class describes triangle objects that can be displayed as shapes
 * like this:
 * []
 * [][]
 * [][][]
 */
public class Triangle
{
	//Attribute
	private int width;
	
	/**
	 * Constructs a Triangle
	 * @param aWidth the number of [] in the last row of the triangle
	 */
	public Triangle(int aWidth)
	{
		width = aWidth;
	}
	
	/**
	 * Computes a string representing the triangle.
	 * @return a string consisting of [] and newline characters
	 */
	public String toString()
	{
		String r = "";
		for(int i = 0; i <= width; i++)
		{
			//Make Triangle row
			for(int j = 1; j <= i; j++)
			{
				r = r + "[]";
			}
			r = r + "\n";
		}
		return r;
	}
}
