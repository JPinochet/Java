/**
 * Feb 6, 2009
 */
package myExceptions;

/**
 * @author 432873
 *
 */
public class TestException
{
	public static double findSquareRoot(double x) throws SquareRootNegativeException
	{
		if(x < 0.0)
		{
			throw new SquareRootNegativeException("Can't take the square root of a negative number "+x);
		}
		return Math.pow(x, 0.5);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		double y = 9;
		
		try
		{
			double answer = TestException.findSquareRoot(y);
			System.out.println("The square root = "+answer);
			y = 16.44;
			answer = TestException.findSquareRoot(y);
			System.out.println("The square root = "+answer);
		} 
		catch (SquareRootNegativeException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("This is coming from the finally block!");
		}
	}

}
