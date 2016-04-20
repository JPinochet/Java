/**
 * Apr 3, 2009
 *
 */
package recursiveExercise;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 * 
 * This class contains the recursive method to solve
 * a fibonacci number sequence is the defined as follows:
 * f1 =1
 * f2 = 1
 * fn = fn-1 + fn-2
 * 
 * That is, each value of the sequence is the sum of 
 * the two preceeding values. The first ten terms of the sequence are:
 * 1,1,2,3,4,5,8,13,21,34,55
 */
public class Fibonacci
{

	public static int fibonacci(int n, String s)
	{
		int answer;
		
		if(n <= 2)
		{
			answer = 1;
			System.out.println("if " +s +" " +answer +" n = "+n);
		}
		else
		{
			System.out.println("in else");
			answer = fibonacci(n-2, "first")+fibonacci(n-1, "second");
			System.out.println("else "+s+" "+answer+"n ="+n);
		}
		return answer;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int finalNum = fibonacci(92, "very first call");
		System.out.println("Final answer = "+finalNum);
	}

}
