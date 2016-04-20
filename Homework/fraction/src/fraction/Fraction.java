/**
 * 
 */
package fraction;

/**
 * @author 432873
 *
 */
public class Fraction
{
	private int numerator;
	private int denominator;
	/**
	 * 
	 */
	public Fraction()
	{
	}
	/**
	 * @param numerator
	 * @param denominator
	 */
	public Fraction(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
		System.out.println("constructor from Fraction class");
	}
	/**
	 * @return the numerator
	 */
	public int getNumerator()
	{
		return numerator;
	}
	/**
	 * @param numerator the numerator to set
	 */
	public void setNumerator(int numerator)
	{
		this.numerator = numerator;
	}
	/**
	 * @return the denominator
	 */
	public int getDenominator()
	{
		return denominator;
	}
	/**
	 * @param denominator the denominator to set
	 */
	public void setDenominatore(int denominator)
	{
		this.denominator = denominator;
	}
	public String toString()
	{
		return numerator +"/" + denominator;
	}
	
}
