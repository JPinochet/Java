/**
 * Jan 29, 2009
 */
package guiWindows;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * @author 432873
 *
 */
public class ClientWindow
{
	//Attributes
	private JTextField 						tf;
	private JLabel							copyL;
	private long							id;
	private String							firstName;
	private String							lastName;
	private String							address;
	private String							postalCode;
	private String							phoneNumber;
	char									clientType;
	
	//Button Attributes
	private JButton							copyB;
	private JButton							clearButton;
	
	//default Constructor
	public ClientWindow()
	{
		
	}
	
	//Operational Methods 
	public JPanel createClientPanel()
	{
		JPanel cp = new JPanel();
		
		JLabel cl = new JLabel("The Client Screen",SwingConstants.CENTER);
		cl.setForeground(Color.RED);
		cl.setFont(new Font("Copperplate Gothic Bold", Font.BOLD ,48));
		cp.add(cl);
		
		tf = new JTextField(50);
		cp.add(tf);
		
		//Action buttons!
		copyB = new JButton("Copy Text");
		copyB.addActionListener(new ButtonListener());
		cp.add(copyB);
		
		
		
		copyL = new JLabel("----------------------");
		cp.add(copyL);
		
		return cp;
		
	}
	
	/********************************INNER CLASSES************************************************/
	
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == copyB)
			{
				String line = tf.getText();
				copyL.setText(line);
			}
			
			if(e.getSource() == clearButton)
			{
				
			}
		}
		
	}
	
	private JPanel createRightButtonBlock()
	{
		JPanel rightPanel = new JPanel();
		Border rightEdge = BorderFactory.createRaisedBevelBorder();
		
		clearButton = new JButton(" Clear ");
		clearButton.setBorder(rightEdge);
		clearButton.addActionListener(new ButtonListener());
		rightPanel.add(clearButton);
		
		return rightPanel;
	}
}
