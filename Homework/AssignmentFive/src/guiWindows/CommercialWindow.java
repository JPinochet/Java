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
 * Displays the commercial tab window.
 */
public class CommercialWindow
{
	//Default Constructor
	public CommercialWindow()
	{
		
	}

	/**
	 * Method that generates the actual commercial tab.
	 * @return the items to be shown in the commercial tab.
	 */
	public JPanel createCommercialPanel()
	{
		JPanel cpp = new JPanel();
		
		JLabel cl = new JLabel("The Commercial Window",SwingConstants.CENTER);
		cl.setForeground(Color.BLACK);
		cl.setFont(new Font("Cooperplate Gothic Bold", Font.BOLD, 48));
		cpp.add(cl);
		
		return cpp; 
	}

}
