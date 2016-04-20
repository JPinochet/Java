/**
 * Apr 18, 2009
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
 * Displays the client panel window.
 */
public class ClientWindow
{
	//Constants
	
	//Attributes
	JList selection = new JList();
	
	//Default constructors
	public ClientWindow()
	{
		
	}

	/**
	 * Creates the client tab in the main window tab.
	 * @return the items to be shown in the main window tab.
	 */
	public JPanel createClientPanel()
	{
		JPanel cp = new JPanel();
		
		JLabel cl = new JLabel("The Client Window",SwingConstants.CENTER);
		cl.setForeground(Color.RED);
		cl.setFont(new Font("Cooperplate Gothic Bold", Font.BOLD, 48));
		cp.add(cl);
		
		cp.add(selection);
		
		return cp;
	}
}
