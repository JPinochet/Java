/**
 * Apr 2, 2009
 *
 */
package recursiveExercise;

/**
 * 
 */
public class Divide
{
	public static int divide(int m, int n)
	{
		int ans = 0; 
		if(m<n)
		{
			System.out.println("in stopping case m = "+m);
			return m;
		}
		else
		{
			System.out.println("before recursive call n = "+(n));
			ans = 1+divide(m-n, n);
			System.out.println("after recursive call ans = "+ans);
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int result = Divide.divide(35000, 7);
		System.out.println(result);
	}

}
