/**
 * Apr 6, 2009
 *
 */
package chapterSixTest;

import chapterSix.Die;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 */
public class DieSimulator
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Die d = new Die(6);
		final int TRIES = 10;
		for(int i = 1; i <= TRIES; i++)
		{
			int n = d.cast();
			System.out.print(n + " ");
		}
		System.out.println();
	}

}
