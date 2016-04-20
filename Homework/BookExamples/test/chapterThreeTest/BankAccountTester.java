/**
 * Apr 6, 2009
 *
 */
package chapterThreeTest;

import chapterThree.*;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 * A class to test the BankAccount class.
 */
public class BankAccountTester
{

	/**
	 * Tests the methods of the BankAccount class.
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		BankAccount harrysChecking = new BankAccount();
		harrysChecking.deposit(2000);
		harrysChecking.withdraw(500);
		System.out.println(harrysChecking.getBalance());
		System.out.println("Expected: 1500");
	}

}
