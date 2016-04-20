/**
 * 
 */
package fraction;

/**
 * @author 432873
 *
 */
public class WholeFraction extends Fraction
{
	//Attributes
	private int number;
	
	//Constructor
	/**
	 * Default Constructor
	 */
	public WholeFraction()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * User defined constructor
	 * @param number
	 * @param numerator
	 * @param denominatore
	 */
	public WholeFraction(int number, int numerator, int denominatore)
	{
		super(numerator, denominatore);
		this.number = number;
		System.out.println("constructor from WholeFraction class");
	}
	
	//Getters and Setters Methods
	/**
	 * @return the number
	 */
	public int getNumber()
	{
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number)
	{
		this.number = number;
	}
	
	//Operational Methods
	public String toString()
	{
		return number +" " +super.toString();
	}
}
