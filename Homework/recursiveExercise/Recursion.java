/**
 * Apr 2, 2009
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 */
package recursiveExercise;

/**
 * 
 */
public class Recursion
{
	public Recursion()
	{
		
	}
	
	/**
	 * Method that uses recursion to calculate the multiplication of a number (m)
	 * n number of times.
	 * @param m variable that starts the call (which number we are multiplying)
	 * @param n variable that declares the iterator (how many times multiplied)
	 * @return the answer of the multiplication
	 */
	public int multiply(int m, int n)
	{
		int ans;
		if(n == 1)
		{
			ans = m;
		}
		else
		{
			ans = m + multiply(m, n-1);
		}
		return ans;
	}
}
