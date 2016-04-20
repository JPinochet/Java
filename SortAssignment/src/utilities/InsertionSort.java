/**
 * 
 */
package utilities;

/**
 * @author 432873
 * Class that sorts comparable arrays using the insertion algorithm.
 */
public class InsertionSort
{
	/**
	 * A simple constructor
	 */
	public InsertionSort()
	{
		
	}
	
	/**
	 * This method sorts an array of comparable objects using the insertion sort algorithm.
	 * 
	 * @param a an array of comparable objects.
	 * @param n the number of items in the array.
	 */
	@SuppressWarnings("unchecked")
	public static void insertionSort(Comparable []a, int n)
	{
		for(int i = 0; i < n; i++)
		{
			Comparable currItem = a[i];
			int index = i;
			
			while(index > 0 && a [index -1].compareTo(currItem) > 0)
			{
				a[index] = a[index - 1];
				index --;
				a[index] = currItem;
			}
		}
	}
}
