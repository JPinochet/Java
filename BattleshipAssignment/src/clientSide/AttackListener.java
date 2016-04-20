package clientSide;

import java.awt.event.*;

public class AttackListener implements ActionListener
{
	public void actionPerformed(ActionEvent v)
	{						
		Battleship.getPlayers(Battleship.getYou()).humanAttack(v);				
	}
}
