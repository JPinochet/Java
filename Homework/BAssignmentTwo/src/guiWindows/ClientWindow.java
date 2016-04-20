/**
 * May 5, 2009
 *
 */
package guiWindows;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 */

public class ClientWindow
{
	public ClientWindow()
	{
		
	}
	
	public JPanel createClientPanel()
	{
		JPanel cp = new JPanel();
		
		JLabel cl = new JLabel("The Client Screen",SwingConstants.CENTER);
		cl.setForeground(Color.RED);
		cl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD ,48));
		cp.add(cl);
				
		return cp;
	}
}
