<<<<<<< HEAD
/**
 * 
 */
package serverSide;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import clientSide.*;

/**
 * @author 432873
 * Listener for the buttons on the board while playing game
 */
public class InternetListener implements ActionListener
{	
	int i, j; //iterators
		
	public void actionPerformed(ActionEvent v)
	{						
		System.out.println(Battleship.getPlayers(0).getMove());
		if(Battleship.getPlayers(0).getMove())			
		{				
			System.out.println("Working at this point!");
			Object source = v.getSource();
			outer:						
			for (i = 0; i < 10; i++)
			{				
				for (j = 0; j < 10; j++)
				{					
					if (source == Battleship.getPlayers(1).getBboard(i, j))
					{								
						if ((Battleship.getPlayers(1).getBboard(i, j).getBackground()==Color.black)||
							(Battleship.getPlayers(1).getBboard(i, j).getBackground()==Color.orange)||
							(Battleship.getPlayers(1).getBboard(i, j).getBackground()==Color.blue))
						{
							JOptionPane.showMessageDialog(null, "You tried that spot already.", "Wasted Shot", JOptionPane.ERROR_MESSAGE);
							BSClient.fireShot();
						}
						else
						{
							BSClient.fireShot(i, j);							
						}
						break outer;						
					}
					else if (source == (Battleship.getPlayers(0).getBboard(i, j)))
					{
						JOptionPane.showMessageDialog(null,"You fired your own board!","Lost Turn", JOptionPane.WARNING_MESSAGE);
						BSClient.fireShot();		
						break outer;							
					}			
				}
			}						
			Player.isStatsOpen();
			Battleship.getPlayers(0).setMove(false);													
		}
		else
		{
			if (!Battleship.isGameover())
			{
				JOptionPane.showMessageDialog(null,"You cannot not play yet.","Wait",JOptionPane.WARNING_MESSAGE);				
			}
			else
			{
				for (i = 0; i < 10; i++)
				{				
					for (j = 0; j < 10; j++)
					{
						Battleship.getPlayers(0).getBboard(i, j).setEnabled(false);
						Battleship.getPlayers(0).getBboard(i, j).setEnabled(false);
					}
				}
			}
		}								
	}
}	

=======
/**
 * 
 */
package serverSide;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import clientSide.*;

/**
 * @author 432873
 * Listener for the buttons on the board while playing game
 */
public class InternetListener implements ActionListener
{	
	int i, j; //iterators
		
	public void actionPerformed(ActionEvent v)
	{						
		System.out.println(Battleship.getPlayers(0).getMove());
		if(Battleship.getPlayers(0).getMove())			
		{				
			System.out.println("Working at this point!");
			Object source = v.getSource();
			outer:						
			for (i = 0; i < 10; i++)
			{				
				for (j = 0; j < 10; j++)
				{					
					if (source == Battleship.getPlayers(1).getBboard(i, j))
					{								
						if ((Battleship.getPlayers(1).getBboard(i, j).getBackground()==Color.black)||
							(Battleship.getPlayers(1).getBboard(i, j).getBackground()==Color.orange)||
							(Battleship.getPlayers(1).getBboard(i, j).getBackground()==Color.blue))
						{
							JOptionPane.showMessageDialog(null, "You tried that spot already.", "Wasted Shot", JOptionPane.ERROR_MESSAGE);
							BSClient.fireShot();
						}
						else
						{
							BSClient.fireShot(i, j);							
						}
						break outer;						
					}
					else if (source == (Battleship.getPlayers(0).getBboard(i, j)))
					{
						JOptionPane.showMessageDialog(null,"You fired your own board!","Lost Turn", JOptionPane.WARNING_MESSAGE);
						BSClient.fireShot();		
						break outer;							
					}			
				}
			}						
			Player.isStatsOpen();
			Battleship.getPlayers(0).setMove(false);													
		}
		else
		{
			if (!Battleship.isGameover())
			{
				JOptionPane.showMessageDialog(null,"You cannot not play yet.","Wait",JOptionPane.WARNING_MESSAGE);				
			}
			else
			{
				for (i = 0; i < 10; i++)
				{				
					for (j = 0; j < 10; j++)
					{
						Battleship.getPlayers(0).getBboard(i, j).setEnabled(false);
						Battleship.getPlayers(0).getBboard(i, j).setEnabled(false);
					}
				}
			}
		}								
	}
}	

>>>>>>> origin/master
