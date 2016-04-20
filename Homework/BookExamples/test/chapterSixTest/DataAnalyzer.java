/**
 * Apr 6, 2009
 *
 */
package chapterSixTest;

import java.util.*;
import chapterSix.DataSet;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 * 
 * This program computes the average and maximum of a set
 * of input values.
 */
public class DataAnalyzer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		DataSet data = new DataSet();
		
		boolean done = false;
		while(!done)
		{
			System.out.print("Enter value, Q to quit: ");
			String input = in.next();
			
			if(input.equalsIgnoreCase("Q"))
			{
				done = true;
			}
			else
			{
				double x = Double.parseDouble(input);
				data.add(x);
			}
		}
		System.out.println("Average = " + data.getAverage());
		System.out.println("Maximum = " + data.getMaximum());
	}

}
