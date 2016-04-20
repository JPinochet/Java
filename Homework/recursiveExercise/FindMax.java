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
 */
public class FindMax
{
	
	public static int findMax(int []a, int lo, int hi)
	{
		int m = (lo + hi)/2;
		
		if(lo >= hi)
		{
			return a[lo];
		}
		
		System.out.println("before first revursive call m = "+m);
		int v1 = findMax(a, lo, m);
		System.out.println("after first recursive call and before second v1 = "+v1);
		int v2 = findMax(a, m+1, hi);
		System.out.println("after second recursive call v2 = "+v2);
		
		if(v1 > v2)
		{
			System.out.println("v1 = "+v1);
			return v1;
		}
		else
		{
			System.out.println("v2 = " +v2);
			return v2;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int [] array = {14,23,44,7,29,34,56,22,9,24,37,25,30,11};
		System.out.println("Largest = "+FindMax.findMax(array, 0, 13));

	}

}
