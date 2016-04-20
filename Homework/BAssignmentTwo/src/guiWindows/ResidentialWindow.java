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

public class ResidentialWindow
{
	public ResidentialWindow()
	{
		
	}
	
	public JPanel createResidentialPanel()
	{
		JPanel rp = new JPanel();
		
		JLabel cl = new JLabel("The Residential Screen",SwingConstants.CENTER);
		cl.setForeground(Color.CYAN);
		cl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD ,48));
		rp.add(cl);
		
		return rp;
	}
}
