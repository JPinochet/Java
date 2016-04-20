/**
 * Apr 6, 2009
 *
 */
package chapterSixTest;

import java.util.*;

import chapterSix.Word;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 * 
 * This program counts the syllables of all words in a sentence.
 */
public class SyllableCount
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a sentence ending in a period.");
		
		String input;
		do
		{
			input = in.next();
			Word w = new Word(input);
			int syllables = w.countSyllables();
			System.out.println("Syllables in " + input + ": " + syllables);
		} while (!input.endsWith("."));

	}

}
