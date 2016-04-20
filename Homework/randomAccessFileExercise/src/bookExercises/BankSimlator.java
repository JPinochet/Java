/**
 * Mar 25, 2009
 */
package bookExercises;

import java.io.*;
import java.util.*;

/**
 * @author 432873
 * Jorge Pinochet
 * Pg.829
 * Both programs
 */
public class BankSimlator
{

	private static BankAccount acount;

	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		BankData data = new BankData();
		try
		{
			data.open("bank.dat");
			
			boolean done = false;
			while(!done)
			{
				System.out.println("Account number: ");
				int accountNumber = in.nextInt();
				System.out.println("Amount to deposit: ");
				double amount = in.nextDouble();
				
				int position = data.find(accountNumber);
				BankAccount account;
				if (position >=0)
				{
					account = data.read(position);
					acount.deposit(amount);
					System.out.println("New balance: "+account.getBalance());
				}
				else //Add account
				{
					account = new BankAccount(accountNumber, amount);
					position = data.size();
					System.out.println("Adding new account.");
				}
				data.write(position, account);
				
				System.out.println("Done? (Y/N) ");
				String input = in.next();
				if(input.equalsIgnoreCase("Y")) done = true;
			}
		}
		finally
		{
			data.close();
		}
	}

}
