/**
 * Apr 2, 2009
 */
package bookExercises;

/**
 * @author 432873
 *
 */
public class BankAccount
{
	//Attributes
	private double 					balance;
	
	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount()
	{
		balance = 0;
	}
	
	/**
	 * Constructs a bank account with a given balance.
	 * @param initialBalance the initial Balance
	 */
	public BankAccount(double initialBalance)
	{
		balance = initialBalance;
	}
	
	/**
	 * @param accountNumber
	 * @param initialBalance
	 */
	public BankAccount(int accountNumber, double initialBalance)
	{
		
	}
	
	/**
	 * Deposits money into the bank account.
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount)
	{
		double newBalance = balance + amount;
		balance = newBalance;
	}
	
	/**
	 * Withdraws  money from the bank amount.
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount)
	{
		double newBalance = balance - amount;
		balance = newBalance;
	}
	
	/**
	 * Gets the current balance of the bank account.
	 * @return the current balance
	 */
	public double getBalance()
	{
		return balance;
	}

	public int getAccountNumber()
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
