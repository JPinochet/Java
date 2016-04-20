/**
 * Mar 26, 2009
 */
package testSort;

import java.util.*;

/**
 * @author 432873
 * Jorge Pinochet
 * version 1.0
 */
public final class Sorts
{
	public static void bubbleSort(Object []a, int n, Comparator comp)
	{
		if(comp != null)
		{
			for(int i =0; i < n; i++)
			{
				for(int j = n - 1; j > i; j--)
				{
					if(comp.compare(a[j-1], a[j]) > 0)
					{
						Object temp = a[j-1];
						a[j-1]= a[j];
						a[j] = temp;
					}
				}
			}
		}
		else 
		{
			for(int i =0; i < n; i++)
			{
				for(int j = n - 1; j > i; j--)
				{
					if(((Comparable)a[j-1]).compareTo(a[j]) > 0)
					{
						Object temp = a[j-1];
						a[j-1]= a[j];
						a[j] = temp;
					}
				}
			}
		}
	}
	
	public static void insertionSort(Comparable []a, int n)
	{
		for(int i=0; i < n; i++)
		{
			Comparable currItem = a[i];
			int index = i;
			
			while(index > 0 && a[index - 1].compareTo(currItem)>0)
			{
				a[index] = a[index - 1];
				index--;
				a[index] = currItem;
			}
		}
	}
	
	public static void selectionSort(Comparable []a, int n)
	{
		for(int i=0; i < n; i++)
		{
			int smallest = findLowestIndex(a,i,n);
			
			Comparable temp = a[i];
			a[i] = a[smallest];
			a[smallest] = temp;
		}
	}
	
	private static int findLowestIndex(Comparable []a, int start, int end)
	{
		int index = start;
		for(int i = start; i < end; i++)
		{
			if(a[i].compareTo(a[index]) < 0)
			{
				index = i;
			}
		}
		return index;
	}
}
