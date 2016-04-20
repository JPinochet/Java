/**
 * Apr 12, 2009
 *
 */
package chapterSevenTest;

import java.util.*;
import chapterSeven.TicTacToe;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 * 
 * This program runs a TicTacToe game. It prompts the 
 * user to set positions on the board and prints out the
 * result.
 *
 */
public class TicTacToeRunner
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String player = "x";
		TicTacToe game = new TicTacToe();
		boolean done = false;
		while(!done)
		{
			System.out.println(game.toString());
			System.out.print("Row for " + player + " (-1 to exit): ");
			int rows = in.nextInt();
			if(rows < 0)
			{
				done = true;
			}
			else
			{
				System.out.print("Column for " + player + ": ");
				int column = in.nextInt();
				game.set(rows, column, player);
				if(player.equals("x"))
				{
					player = "o";
				}
				else
				{
					player = "x";
				}
			}
		}
	}
}