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
public class Multiply
{
	public static int multiply(int m, int n)
	{
		int ans = 0;
		if(n == 1)
		{
			System.out.println("in stopping case m = "+m);
			return m;
		}
		else
		{
			System.out.println("before recursive call n = "+(n-1));
			ans = m+ multiply(m, n-1);
			System.out.println("after recursive call ans = "+ans);
		}
		return ans;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int result = Multiply.multiply(7, 6);
		System.out.println(result);
	}

}
