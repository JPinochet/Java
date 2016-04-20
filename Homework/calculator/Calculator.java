/**
 * Mar 11, 2009
 */
package calculator;

import exceptions.SquareRootNegativeException;

/**
 * @author 432873
 *
 */
public class Calculator implements SimpleCalculator
{

	/* (non-Javadoc)
	 * @see calculator.SimpleCalculator#add(double, double)
	 */
	@Override
	public double add(double num1, double num2)
	{
		return num1+num2;
	}

	/* (non-Javadoc)
	 * @see calculator.SimpleCalculator#divide(double, double)
	 */
	@Override
	public double divide(double quotient, double divisor)
			throws ArithmeticException
	{
		if(divisor == 0)
		{
			throw new ArithmeticException("Can't divide by zero");
		}
		return quotient / divisor;
	}

	/* (non-Javadoc)
	 * @see calculator.SimpleCalculator#multiply(double, double)
	 */
	@Override
	public double multiply(double num1, double num2)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see calculator.SimpleCalculator#square(double)
	 */
	@Override
	public double square(double num)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see calculator.SimpleCalculator#squareRoot(double)
	 */
	@Override
	public double squareRoot(double num) throws SquareRootNegativeException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see calculator.SimpleCalculator#subtract(double, double)
	 */
	@Override
	public double subtract(double num1, double num2)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
