/**
 * Mar 6, 2009
 */
package calculator;

import exceptions.*;

/**
 * @author 432873
 *
 * An interface specifying what functionality any simple calculator should contain.
 */
public interface SimpleCalculator
{
	/**
	 * Method to add the two supplied values and return the answer
	 * @param num1 first value
	 * @param num2 second value
	 * @return the sum of the supplied values as a double.
	 */
	public double add(double num1, double num2);
	
	/**
	 * Method to subtract the second supplied value(num2) from the first(num1).
	 * @param num1 first value
	 * @param num2 second value
	 * @return a double that is the difference between num1 and num2.
	 */
	public double subtract(double num1, double num2);
	
	/**
	 * Method to multiply the second(num2) and first(num1) values.
	 * @param num1 first value
	 * @param num2 second value
	 * @return a double the product of num1 x num2
	 */
	public double multiply(double num1, double num2);
	
	/**
	 * Method to divide num1 by num2. An exception is thrown if the divisor is 0.
	 * @param num1 the quotient
	 * @param num2 the divisor
	 * @return the result of num1/num2
	 * @throws ArithmeticException when the divisor is zero.
	 */
	public double divide(double quotient, double divisor) throws ArithmeticException;
	
	/**
	 * Method to calculate the square of a number.
	 * @param num number to be squared.
	 * @return the square to the number.
	 */
	public double square(double num);
	
	/**
	 * Method calculates the square root of a number. A SquareRootNegativeException
	 * exception is thrown is the number is negative.
	 * @param num number for which the square root is derived.
	 * @return the square root of the number supplied
	 * @throws SquareRootNegativeException when the supplied number is negative
	 */
	public double squareRoot(double num) throws SquareRootNegativeException;
	
}
