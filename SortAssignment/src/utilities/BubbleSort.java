/**
 * 
 */
package utilities;

import java.util.Comparator;

/**
 * @author 432873
 * This class uses the algorithm for the bubble sort. It takes in an array of integers and sorts them according to its
 * algorithm. 
 */
public class BubbleSort
{
	/**
	 * Simple constructor 
	 */
	public BubbleSort()
	{
		
	}
	
	/**
	 *	This method takes in an array of integers and a variable indicating it's size, then using this information
	 *	sorts the array into proper ascending order.
	 * 
	 * @param a an array of integers to be sorted.
	 * @param n the number of things in the array.
	 */
	public void bubbleSort(int []a, int n)
	{
		for(int i = 0; i < n; i++)
		{
			for(int j = n - 1; j > i; j--)
			{
				if(a[j-1] > a[j])
				{
					int temp = a[j -1];
					a[j -1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
		
	/**
	 * This method sorts an array of objects using the comparator object to help sort the algorithm.
	 * 
	 * @param a an array of objects
	 * @param n the number of items in the array
	 * @param comp how the array will be compared to other objects
	 */
	@SuppressWarnings("unchecked")
	public void bubbleSort(Object []a, int n, Comparator comp)
	{
		if(comp!=null)
		{
			for(int i = 0; i < n; i++)
			{
				for(int j = n - 1; j > i; j--)
				{
					if(comp.compare(a[j-1], a[j]) > 0)
					{
						Object temp = a[j -1];
						a[j -1] = a[j];
						a[j] = temp;
					}
				}
			}
		}
		else
		{
			for (int i = 0; i < n; i++)
			{
				for(int j = n - 1; j > i; j--)
				{
					if (((Comparable)a[j-1]).compareTo(a[j])>0)
					{
						Object temp = a[j-1];
						a[j-1] = a[j];
						a[j] = temp;
					}
				}
			}
		}	
	}
	
	/**
	 * This method sorts an array of comparable objects.
	 * 
	 * @param a an array of comparable objects to be sorted.
	 * @param n the number of items in the array of comparable objects.
	 */
	@SuppressWarnings("unchecked")
	public void bubbleSortComparable(Comparable []a, int n)
	{
		for(int i = 0; i < n; i++)
		{
			for(int j = n - 1; j > i; j--)
			{
				if(a[j-1].compareTo(a[j]) > 0)
				{
					Comparable temp = a[j -1];
					a[j -1] = a[j];
					a[j] = temp;
				}
			}	
		}
	}
}
