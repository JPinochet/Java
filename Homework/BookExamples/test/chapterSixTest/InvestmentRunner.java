/**
 * Apr 6, 2009
 *
 */
package chapterSixTest;

import chapterSix.Investment;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 * This program computes how long it takes for an investment
 * to double.
 * This program computes how much an investment grows in 
 * a given number of years.
 */
public class InvestmentRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		final double INITIAL_BALANCE = 10000;
		final double RATE = 5;
		Investment invest = new Investment(INITIAL_BALANCE, RATE);
		//invest.waitForBalance(2*INITIAL_BALANCE);
		//int years = invest.getYears();
		//System.out.println("The investment doubled after " + years + " years");
		
		final int YEARS = 20;
		invest.waitYears(YEARS);
		double balance = invest.getBalance();
		System.out.printf("The balance after %d years is %.2f\n", YEARS, balance);
	}

}
