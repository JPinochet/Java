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
 * Jorge Pinochet
 */
public class MainWindow extends JFrame
{
	//Attributes
	private Container				mainPane;
	private JButton					mainButton;
	private JButton					clientButton;
	private JButton					residentialButton;
	private JButton					commercialButton;
	private Vector<JPanel>			panelList;
	
	//Constructor
	public MainWindow()
	{
		panelList = new Vector<JPanel>(4);
		
		//fill panelList with JPanel associated with the 4 different screens 
		JPanel tempPanel = this.createMainPanel();
		panelList.add(tempPanel);
		
		ClientWindowMyOwn cw =  new ClientWindowMyOwn();
		panelList.add(cw.createClientPanel());
		
		ResidentialWindow rw = new ResidentialWindow();
		panelList.add(rw.createResidentialPanel());
		
		CommercialWindow cWindow = new CommercialWindow();
		panelList.add(cWindow.createCommercialPanel());
		
	}
	
	//operational Methods
	public void createMainWindow()
	{
		this.setBounds(100,100, 800, 600);
		this.setTitle("Sait MLS Client/Property Management System");
		
		mainPane = this.getContentPane();
		mainPane.setLayout(new BorderLayout(5,5));
		
		//panel for the buttons in the north section (to tab through all the screens
		JPanel buttonPanel = new JPanel(new GridLayout(1,4));
		Border buttonEdge = BorderFactory.createRaisedBevelBorder();
		
		mainButton = new JButton ("Main");
		mainButton.setBorder(buttonEdge);
		mainButton.addActionListener(new ButtonListener());
		buttonPanel.add(mainButton);
		
		clientButton = new JButton ("Client");
		clientButton.setBorder(buttonEdge);
		clientButton.addActionListener(new ButtonListener());
		buttonPanel.add(clientButton);
		
		residentialButton = new JButton ("Residential");
		residentialButton.setBorder(buttonEdge);
		residentialButton.addActionListener(new ButtonListener());
		buttonPanel.add(residentialButton);
		
		commercialButton = new JButton ("Commercial");
		commercialButton.setBorder(buttonEdge);
		commercialButton.addActionListener(new ButtonListener());
		buttonPanel.add(commercialButton);
		
		mainPane.add(buttonPanel, BorderLayout.NORTH);
		mainPane.add(panelList.get(0),BorderLayout.CENTER);  //Defaults this panel as the main Panel
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Main panel that when you click the NORTH buttons this will pop up.
	 * 
	 * Method that generates the main panel for the main screen.
	 * 
	 * @return a JPanel containing the main screen components
	 */
	private JPanel createMainPanel()
	{
		JPanel mainPanel = new JPanel();
		
		JLabel mainLabel = new JLabel("The Main Screen",SwingConstants.CENTER);
		mainLabel.setForeground(Color.BLUE);
		mainLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD ,48));
		mainPanel.add(mainLabel);
		
		return mainPanel;
	}
	
	/*************************************INNER CLASSES**************************************************/
	private class ButtonListener implements ActionListener
	{
		//Attributes
		private JPanel temp;

		@Override
		public void actionPerformed(ActionEvent e)
		{
			for(int i =0; i < panelList.size(); i++)
			{
				temp = panelList.get(i);
				mainPane.remove(temp);
				temp.setVisible(false);
			}
			
			if(e.getSource() == mainButton)
			{
				temp = panelList.get(0);
				mainPane.add(temp);
				temp.setVisible(true);
			}			
			if(e.getSource() == clientButton)
			{
				temp = panelList.get(1);
				mainPane.add(temp);
				temp.setVisible(true);
			}
			if(e.getSource() == residentialButton)
			{
				temp = panelList.get(2);
				mainPane.add(temp);
				temp.setVisible(true);
			}
			if(e.getSource() == commercialButton)
			{
				temp = panelList.get(3);
				mainPane.add(temp);
				temp.setVisible(true);
			}
		}
	}
}
