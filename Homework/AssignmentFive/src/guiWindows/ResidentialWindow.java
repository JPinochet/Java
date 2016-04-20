/**
 * Apr 18, 2009
 *
 */
package guiWindows;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 * Dispalys the residential tab window.
 */
public class ResidentialWindow
{
	//Default Constructor
	public ResidentialWindow()
	{
		
	}

	/**
	 * Method that creates the items in the residential tab.
	 * @return the tab
	 */
	public JPanel createResidentialPanel()
	{
		JPanel rp = new JPanel();
		
		JLabel cl = new JLabel("The Residential Window",SwingConstants.CENTER);
		cl.setForeground(Color.ORANGE);
		cl.setFont(new Font("Cooperplate Gothic Bold", Font.BOLD, 48));
		rp.add(cl);
		
		return rp;
	}
}
