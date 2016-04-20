/**
 * Apr 6, 2009
 *
 */
package chapterFive;

import java.util.Scanner;
import chapterFive.TaxReturn;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 * This program calculates a simple tax return.
 */
public class TaxCalculator
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter your income: ");
		double income = in.nextDouble();
		
		System.out.println("Are you married? (Y/N) ");
		String input = in.next();
		
		int status;
		
		if(input.equalsIgnoreCase("Y"))
		{
			status = TaxReturn.MARRIED;
		}
		else
		{
			status = TaxReturn.SINGLE;
		}
		TaxReturn aTaxReturn = new TaxReturn(income, status);
		
		System.out.println("Tax: " + aTaxReturn.getTax());
	}

}
