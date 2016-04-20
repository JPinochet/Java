/**
 * Mar 26, 2009
 */
package testSort;

import sorting.*;

/**
 * @author 432873
 * Jorge Pinochet
 * version 1.0
 */
public class TestSorts
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int []array = {15,7,19,21,3,10,12,2,9,16,5};
		
		MyInt [] array1 = new MyInt[8];
		
		array1[0] = new MyInt(15859430);
		array1[1] = new MyInt(75342);
		array1[2] = new MyInt(1932532);
		array1[3] = new MyInt(21);
		array1[4] = new MyInt(33456578);
		array1[5] = new MyInt(10576);
		array1[6] = new MyInt(12453678);
		array1[7] = new MyInt(2);
		
		for(int i=0; i<array1.length; i++)
		{
			System.out.print(array1[i]+" ");
		}
		
		System.out.println("\n");
		Sorts.bubbleSort(array1, array1.length, null);
		
		for(int i=0; i<array1.length; i++)
		{
			System.out.print(array1[i]+" ");
		}
		System.out.println("\n\n");
		

		String [] array2 = {"Bob","Zelda","Alf","Marvin","Homer","Claude"};
		
		for(int i=0; i<array2.length; i++)
		{
			System.out.print(array2[i]+" ");
		}
		
		System.out.println("\n");
		Sorts.bubbleSort(array2, array2.length, null);
		
		for(int i=0; i<array2.length; i++)
		{
			System.out.print(array2[i]+" ");
		}
		System.out.println("\n\n");
		
		MyDouble [] array3 = new MyDouble[8];
		MyDoubleComperator mdc = new MyDoubleComperator();
		
		array3[0] = new MyDouble(158594.30);
		array3[1] = new MyDouble(753.42);
		array3[2] = new MyDouble(19325.32);
		array3[3] = new MyDouble(21.00);
		array3[4] = new MyDouble(334565.78);
		array3[5] = new MyDouble(105.76);
		array3[6] = new MyDouble(124536.78);
		array3[7] = new MyDouble(2.00);
		
		for(int i=0; i<array3.length; i++)
		{
			System.out.print(array3[i]+" ");
		}
		
		System.out.println("\n");
		Sorts.bubbleSort(array3, array3.length, mdc);
		
		for(int i=0; i<array3.length; i++)
		{
			System.out.print(array3[i]+" ");
		}
		System.out.println("\n\n");
	}
}
