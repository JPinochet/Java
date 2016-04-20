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

public class CommercialWindow
{
	public CommercialWindow()
	{
		
	}
	
	public JPanel createCommercialPanel()
	{
		JPanel cmp = new JPanel();
		
		JLabel cl = new JLabel("The Commercial Screen",SwingConstants.CENTER);
		cl.setForeground(Color.BLACK);
		cl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD ,48));
		cmp.add(cl);
		
		return cmp;
	}
}
