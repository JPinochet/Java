/**
 * Apr 6, 2009
 *
 */
package chapterFour;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 * Constructs a cash register with no money in it.
 */
public class CashRegister
{
	//Attributes
	private double purchase;
	private double payment;
	
	//Constants
	public static final double QUARTER_VALUE = 0.25;
	public static final double DIME_VALUE = 0.1;
	public static final double NICKEL_VALUE = 0.05;
	public static final double PENNY_VALUE = 0.01;
	
	/**
	 * Constructs a cash register with no money in it.
	 */
	public CashRegister()
	{
		purchase = 0;
		payment = 0;
	}
	
	/**
	 * Records the purchase price of an item.
	 * @param amount the price of the purchased item.
	 */
	public void recordPurchase(double amount)
	{
		purchase = purchase + amount;
	}
	
	/**
	 * Enters the payment received from the customer.
	 * @param dollars the number of dollars in the payment
	 * @param quarters the number quarters in the payment
	 * @param dimes the number of dimes in the payment
	 * @param nickels then number of nickels in the payment
	 * @param pennies then number of pennies in the payment
	 */
	public void enterPayment(int dollars, int quarters, int dimes, int nickles, int pennies)
	{
		payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE + nickles * NICKEL_VALUE + pennies * PENNY_VALUE;
	}
	
	/**
	 * Computes the change due and resets the machine for the next customer.
	 * @return the change due to the customer
	 */
	public double giveChange()
	{
		double change = payment - purchase;
		purchase = 0;
		payment = 0;
		return change;
	}
}
