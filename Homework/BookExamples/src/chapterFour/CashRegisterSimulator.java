/**
 * Apr 6, 2009
 *
 */
package chapterFour;

import java.util.*;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 * This program simulates a transaction in which a user pays for an item 
 * and receives change.
 */
public class CashRegisterSimulator
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		CashRegister register = new CashRegister();
		
		System.out.print("Enter price: ");
		double price = in.nextDouble();
		register.recordPurchase(price);
		
		System.out.print("Enter dollars: ");
		int dollars = in.nextInt();
		System.out.print("Enter quarters: ");
		int quarters = in.nextInt();
		System.out.print("Enter dimes: ");
		int dimes = in.nextInt();
		System.out.print("Enter nickles: ");
		int nickles = in.nextInt();
		System.out.print("Enter Pennies: ");
		int pennies = in.nextInt();
		register.enterPayment(dollars, quarters, dimes, nickles, pennies);
		
		System.out.print("Your change: ");
		System.out.println(register.giveChange());
	}
}
