/**
 * 
 */
package utilities;

/**
 * @author 432873
 * Class that sorts comparable arrays using the merge algorithm.
 */
public class MergeSort
{
	/**
	 * A simple constructor.
	 */
	public MergeSort()
	{
		
	}
	
	/**
	 * This method merges 2 arrays to produce a third. This method utilizes the merge sort algorithm to do this.
	 * 
	 * @param a1 the first array to merge together.
	 * @param l1 length of the first array.
	 * @param r1 looping variable.
	 * @param a2 the second array to merge together.
	 * @param l2 length of the second array.
	 * @param r2 looping variable.
	 * @param a3 the resulting array after being merged.
	 * @param l3 length of the final array 
	 * @param r3 looping variable.
	 * @return final merged array.
	 */
	@SuppressWarnings("unchecked")
	public static int mergeSort(Comparable[] a1, int l1, int r1, Comparable[] a2, int l2, int r2, Comparable[] a3, int l3, int r3)
	{
		int i = l1, j = l2, k = l3;
		while (i <= r1 && j <= r2) 
		{		
			int comp = a1[i].compareTo(a2[j]);	
			if (comp <= 0)
			{
				a3[k++] = a1[i++];
			}
			else
			{
				a3[k++] = a2[j++];
			}
		} 
		while (i <= r1)  a3[k++] = a1[i++];
		while (j <= r2)  a3[k++] = a2[j++];
		return 0;
	}
}
