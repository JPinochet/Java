package guiWindows;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Class to create the main window
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame {
//Attributes
	private Container		mainPane;
	private JButton			mainButton;
	private JButton			clientButton;
	private JButton			residentialButton;
	private JButton			commercialButton;
	private Vector<JPanel>	panelList;
	private	ClientWindow 	cw;
	private	ResWindow 		rw;
	private	ComWindow	 	cmw;
	
//Constructors
	/**
	 * Default constructor
	 */
	public MainWindow() {
		panelList = new Vector<JPanel>(4);
		
	//Fill panelList with JPanels for the 4 different pages
		JPanel tempPanel = this.createMainPanel();
		panelList.add(tempPanel);
		
		cw = new ClientWindow();
		panelList.add(cw.createClientPanel());
		
		rw = new ResWindow();
		panelList.add(rw.createResPanel());
		
		cmw = new ComWindow();
		panelList.add(cmw.createComPanel());
	}
	
//Operational Methods
	/**
	 * Creates the main program window
	 */
	public void createMainWindow() {
		this.setBounds(100, 100, 800, 600);
		this.setTitle("Sait MLS Client/Property Managment System");
		
		mainPane = this.getContentPane();
		mainPane.setLayout(new BorderLayout(5,5));
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,4));
		Border buttonEdge = BorderFactory.createRaisedBevelBorder();
		
		mainButton = new JButton("Main");
		mainButton.setBorder(buttonEdge);
		mainButton.addActionListener(new ButtonListener());
		buttonPanel.add(mainButton);
		
		clientButton = new JButton("Client");
		clientButton.setBorder(buttonEdge);
		clientButton.addActionListener(new ButtonListener());
		buttonPanel.add(clientButton);
		
		residentialButton = new JButton("Residential");
		residentialButton.setBorder(buttonEdge);
		residentialButton.addActionListener(new ButtonListener());
		buttonPanel.add(residentialButton);
		
		commercialButton = new JButton("Commercial");
		commercialButton.setBorder(buttonEdge);
		commercialButton.addActionListener(new ButtonListener());
		buttonPanel.add(commercialButton);
		
		mainPane.add(buttonPanel,BorderLayout.NORTH);
		mainPane.add(panelList.firstElement(),BorderLayout.CENTER);

		this.addWindowListener(new WL());
		this.setVisible(true);
	}
	
//***Private Methods***
	/**
	 * Method that generates the main panel for the main screen
	 * @return a JPanel containing the main screen components
	 */
	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		JLabel mainLabel = new JLabel("The Main Screen",SwingConstants.CENTER);
		mainLabel.setForeground(Color.blue);
		mainLabel.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,48));
		mainPanel.add(mainLabel);
		
		return mainPanel;
	}
	
	
//***Inner Classes***
	/**
	 * Button listener for the main window
	 */
	private class ButtonListener implements ActionListener {
	//Attributes
		private JPanel temp;

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < panelList.size(); i++) {
				temp = panelList.get(i);
				mainPane.remove(temp);
				temp.setVisible(false);
			}
			
			if(e.getSource() == mainButton) {
				temp = panelList.get(0);
				mainPane.add(temp);
				temp.setVisible(true);
			} else if(e.getSource() == clientButton) {
				temp = panelList.get(1);
				mainPane.add(temp);
				temp.setVisible(true);
			} else if(e.getSource() == residentialButton) {
				temp = panelList.get(2);
				mainPane.add(temp);
				temp.setVisible(true);
			} else if(e.getSource() == commercialButton) {
				temp = panelList.get(3);
				mainPane.add(temp);
				temp.setVisible(true);
			}
		}		
	}
	
	/**
	 * Window listener for the main window
	 */
	private class WL implements WindowListener {

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowActivated(WindowEvent e) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowClosed(WindowEvent e) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowClosing(WindowEvent e) {
			cw.close();
			rw.close();
			cmw.close();
			System.exit(0);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowDeactivated(WindowEvent e) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowIconified(WindowEvent e) {
		}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowOpened(WindowEvent e) {
		}
	}
}
