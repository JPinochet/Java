/**
 * Mar 11, 2009
 */
package testCalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import calculator.*;
/**
 * @author 432873
 *
 */
public class CalculatorTest
{
	//Attributes
	private Calculator c;
	private double num1;
	private double num2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		c = new Calculator();
		num1 = 35.7;
		num2 = 8.35;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		c = null;
		num1 = 0;
		num2 = 0;
	}

	/**
	 * Test method for {@link calculator.Calculator#add(double, double)}.
	 */
	@Test
	public void testAdd()
	{
		
		double expected = 44.05, actual = c.add(num1, num2);
		
		assertEquals("Addition failed ",expected, actual, 0.002);
	}

	/**
	 * Test method for {@link calculator.Calculator#divide(double, double)}.
	 */
	@Test
	public void testDivide1()
	{
		double expected = 4.275, actual = c.divide(num1, num2);
		
		assertEquals("Division failed ",expected, actual, 0.001);	
	}
	
	/**
	 * Test method for {@link calculator.Calculator#divide(double, double)}.
	 */
	@Test
	public void testDivide2()
	{
		try
		{
			double actual = c.divide(num1, 0);
			fail("ArithmeticException should be raised, can't divide by 0");
		} 
		catch (ArithmeticException e)
		{
			//e.printStackTrace();
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link calculator.Calculator#multiply(double, double)}.
	 */
	@Test
	public void testMultiply()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link calculator.Calculator#square(double)}.
	 */
	@Test
	public void testSquare()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link calculator.Calculator#squareRoot(double)}.
	 */
	@Test
	public void testSquareRoot()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link calculator.Calculator#subtract(double, double)}.
	 */
	@Test
	public void testSubtract()
	{
		fail("Not yet implemented");
	}

}
