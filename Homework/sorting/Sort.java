/**
 * 
 */
package sorting;

import java.util.*;

/**
 * @author 432873
 *
 */
public final class Sort
{
	public static void bubbleSort(int []a, int n)
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
		
	@SuppressWarnings("unchecked")
	public static void bubbleSort(Object []a, int n, Comparator comp)
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
	@SuppressWarnings("unchecked")
	public static void bubbleSortComparable(Comparable []a, int n)
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
