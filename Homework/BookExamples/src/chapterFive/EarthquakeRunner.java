/**
 * Apr 6, 2009
 *
 */
package chapterFive;

import java.util.Scanner;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 * This program prints a description of an earthquake of a given magnitude.
 */
public class EarthquakeRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter a magnitude on the Richter scale: ");
		double magnitude = in.nextDouble();
		Earthquake quake = new Earthquake(magnitude);
		System.out.println(quake.getDescription());
	}

}
