/**
 * Mar 26, 2009
 */
package sorting;

/**
 * @author 432873
 * Jorge Pinochet
 * version 1.0
 */
public final class Sorts2
{
	public static void bubbleSort(int[] a, int n)
	{
		for(int i =0; i < n; i++)
		{
			for(int j = n - 1; j > i; j--)
			{
				if(a[j-1] > a[j])
				{
					int temp = a[j-1];
					a[j-1]= a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	public static double recursive(double baseNumber, int exponent)
	{
		if(exponent == 0)
		{
			return 1;
		}
		else
		{
			double result = baseNumber * recursive(baseNumber, exponent - 1);
			return result;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(recursive(5, 9));
	}
}
