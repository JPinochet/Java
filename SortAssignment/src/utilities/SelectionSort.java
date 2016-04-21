<<<<<<< HEAD
/**
 * 
 */
package utilities;

/**
 * @author 432873
 * Class that sorts comparable arrays using the selection algorithm.
 */
public class SelectionSort
{
	/**
	 * A simple constructor
	 */
	public SelectionSort()
	{
		
	}
	
	/**
	 * Method sorts a comparable array using the selection sort.
	 * @param a an array of comparable objects.
	 * @param n the number of elements in the array.
	 */
	@SuppressWarnings("unchecked")
	public static void selectionSort (Comparable []a, int n)
	{
		for(int i = 0; i < n; i++)
		{
			int smallest = findLowestIndex(a,i,n);
			
			Comparable temp = a[i];
			a[i] = a[smallest];
			a[smallest] = temp;
		}
	}
	
	/**
	 * Method creates lowest item in the comparable array between 2 reference points.
	 * 
	 * @param a an array of comparable objects.
	 * @param start point in the array to start searching for the lowest variable
	 * @param end point to end looking for searching for the lowest variable
	 * @return the index of the lowest variable.
	 */
	@SuppressWarnings("unchecked")
	public static int findLowestIndex(Comparable []a, int start, int end)
	{
		int index = start;
		for (int i = start; i < end; i++)
		{
			if(a[i].compareTo(a[index])>0)
			{
				index = i;
			}
		}
		return index;
	}
}
=======
/**
 * 
 */
package utilities;

/**
 * @author 432873
 * Class that sorts comparable arrays using the selection algorithm.
 */
public class SelectionSort
{
	/**
	 * A simple constructor
	 */
	public SelectionSort()
	{
		
	}
	
	/**
	 * Method sorts a comparable array using the selection sort.
	 * @param a an array of comparable objects.
	 * @param n the number of elements in the array.
	 */
	@SuppressWarnings("unchecked")
	public static void selectionSort (Comparable []a, int n)
	{
		for(int i = 0; i < n; i++)
		{
			int smallest = findLowestIndex(a,i,n);
			
			Comparable temp = a[i];
			a[i] = a[smallest];
			a[smallest] = temp;
		}
	}
	
	/**
	 * Method creates lowest item in the comparable array between 2 reference points.
	 * 
	 * @param a an array of comparable objects.
	 * @param start point in the array to start searching for the lowest variable
	 * @param end point to end looking for searching for the lowest variable
	 * @return the index of the lowest variable.
	 */
	@SuppressWarnings("unchecked")
	public static int findLowestIndex(Comparable []a, int start, int end)
	{
		int index = start;
		for (int i = start; i < end; i++)
		{
			if(a[i].compareTo(a[index])>0)
			{
				index = i;
			}
		}
		return index;
	}
}
>>>>>>> origin/master
