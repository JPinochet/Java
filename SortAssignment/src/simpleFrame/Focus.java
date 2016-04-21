/**
 * 
 */
package simpleFrame;

import java.util.regex.*;
import java.awt.Toolkit;
import utilities.*;

/**
 * @author 432873
 *
 */
@SuppressWarnings("unused")
public class Focus
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String input = " ";
		for(int i = 0; i < args.length; i++)
		{
			input = input + args[i];
		}
		System.out.println(input);
		
		int numberOfFrames = 0;
		char sortType = 'k', compareType = 'd';
		
		Pattern comType = Pattern.compile("[wWhHaAcC]");
		Matcher cType = comType.matcher(input);
		if(cType.find())
		{
			String temp = cType.group();
			compareType = temp.toLowerCase().charAt(0);
			System.out.println(compareType + " ");
		}
		
		Pattern sorType = Pattern.compile("[bBiImMzZqQsS]");
		Matcher sType = sorType.matcher(input);
		if(sType.find())
		{
			String temp = sType.group();
			sortType = temp.toLowerCase().charAt(0);
			System.out.println(sortType + " ");
		}
		
		Pattern numFrames = Pattern.compile("[0-9][0-9]");
		Matcher nFrames = numFrames.matcher(input);
		if(nFrames.find())
		{
			String temp = nFrames.group();
			numberOfFrames = Integer.parseInt(temp);
			System.out.println(numberOfFrames + 0);
		}
		
		SimpleFrame frames[] = new SimpleFrame[numberOfFrames];
		
		for(int i = 0; i < numberOfFrames; i++)
		{
			SimpleFrame frame = new SimpleFrame(compareType);
			System.out.println(frame);
			frame.setBounds(50, 50, (int)Math.random() * 100, (int)Math.random() * 100);
			frames[i] = frame;
		}
		
		long 	start, stop;
		
		switch(sortType)
		{
			case 'b': 
				BubbleSort bSort = new BubbleSort();
				
				start = System.currentTimeMillis();
				//bSort.bubbleSortComparable(frames[], numberOfFrames);
				stop = System.currentTimeMillis();
				
				System.out.println("Amount of time to sort: " + (stop - start));
				break;
			case 'i': 
				InsertionSort iSort = new InsertionSort();
				
				start = System.currentTimeMillis();
				//iSort.insertionSort(frames[], numberOfFrames);
				stop = System.currentTimeMillis();
				
				System.out.println("Amount of time to sort: " + (stop - start));
				break;
			case 'm': 
				MergeSort mSort = new MergeSort();
				
				start = System.currentTimeMillis();
				//mSort.mergeSort(frames[], numberOfFrames);
				stop = System.currentTimeMillis();
				
				System.out.println("Amount of time to sort: " + (stop - start));
				break;
			case 's': 
				//SelectionSort sSort = new SelectionSort();
				
				start = System.currentTimeMillis();
				SelectionSort.selectionSort(frames, numberOfFrames);
				stop = System.currentTimeMillis();
				
				System.out.println("Amount of time to sort: " + (stop - start));
				break;
			case 'z': 
				ShellSort zSort = new ShellSort();
				
				start = System.currentTimeMillis();
				//sSort.shellSort(frames[], numberOfFrames);
				stop = System.currentTimeMillis();
				
				System.out.println("Amount of time to sort: " + (stop - start));
				break;
			case 'q': 
				QuickSort qSort = new QuickSort();
				
				start = System.currentTimeMillis();
				//qSort.quickSort(frames[], numberOfFrames);
				stop = System.currentTimeMillis();
				
				System.out.println("Amount of time to sort: " + (stop - start));
				break;
		}
		
		for(int i = 0; i < frames.length; i++)
		{
			frames[i].setVisible(true);
		}
	}
}
