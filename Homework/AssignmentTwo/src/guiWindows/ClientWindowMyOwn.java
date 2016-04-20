/**
 * Feb 4, 2009
 */
package guiWindows;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import saitMLS.exceptions.*;
import saitMLS.persistance.*;
import saitMLS.problemDomain.Client;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;



/**
 * @author 432873
 * This ClientWindow is based off the one done in class, however I remade it for the purpose of
 * learning the material better and to add my own variable names.
 * 
 * The tab with client displays this panel
 */
public class ClientWindowMyOwn
{
	//Attributes
	private long							id;
	private String							firstName;
	private String							lastName;
	private String							address;
	private String							postalCode;
	private String							phoneNumber;
	char									clientType;
	private Vector							listVector;
	String 									tempClientType;
	
	ClientBroker cb = ClientBroker.getBroker();
	
	//The boxes, called fields in java
	private JTextField						idTextBox;
	private JTextField						firstNameTextBox;
	private JTextField						lastNameTextBox;
	private JTextField						addressTextBox;
	private JTextField						postalCodeTextBox;
	private JTextField						phoneNumberTextBox;
	JTextField search = new JTextField(20);
	
	//Text Manipulation
	private JList							listArea;
	private JScrollPane 					listScrollPane;
	
	//BorderAttributes
	Border 									rightBorder;
	
	//ButtonAttributes
	private JButton							addButton;
	private JButton							clearButton;
	private JButton							closeButton;
	
	//Default Constructors
	public ClientWindowMyOwn()
	{
		
	}
	
	/*
	 * This is the panel that I want to appear when the client tab is clicked. This is a panel and not a frame 
	 * because you are adding it on top of the frame, and there is no point in making another frame when a panel 
	 * works the same.
	 * @return clientPanel
	 */
	public JPanel createClientPanel()
	{
		JPanel clientPanel = new JPanel();
		
		//This is the main greeting at the top of the panel when client is clicked.
		JLabel clientGreetingMessage = new JLabel("The Client Screen",SwingConstants.CENTER);
		clientGreetingMessage.setForeground(Color.RED);
		clientGreetingMessage.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 48));
		clientPanel.add(clientGreetingMessage);
		
		//Right Display cause with the names, dates and labels to manipulate information.
		clientPanel.add(createRightBorder(), BorderLayout.EAST);
		
		//Left Display case with the names, dates and labels to manipulate information.
		clientPanel.add(createLeftBorder(), BorderLayout.WEST);
		
		cb.closeBroker();
		
		return clientPanel;
	}
	
	/****************************************INNER CLASSES*********************************************/
	
	/*
	 * @return rightPanel
	 * This is the creation of the right half of the client page
	 */
	private JPanel createRightBorder()
	{
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(8,1));
		rightPanel.setBorder(new TitledBorder(new EtchedBorder(),"Client Information"));
		rightPanel.add(idLayout());
		rightPanel.add(firstNameLayout());
		rightPanel.add(lastNameLayout());
		rightPanel.add(addressLayout());
		rightPanel.add(postalCodeLayout());
		rightPanel.add(phoneNumberLayout());
		rightPanel.add(clientTypeLayout());
		rightPanel.add(createBottomRightButtonBlock(), BorderLayout.SOUTH);
		
		
		return rightPanel;
	}
	
	/*
	 * @return leftPanel
	 * Left half of the screen
	 */
	private JPanel createLeftBorder()
	{
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2,1));
		leftPanel.setBorder(new TitledBorder(new EtchedBorder(), "Select type of search to be performed."));
		leftPanel.add(createTopLeftPanel(), BorderLayout.NORTH);
		leftPanel.add(createBottomLeftPanel(), BorderLayout.SOUTH);
		
		return leftPanel;
	}
	
	/*
	 * Returns the id name Jlabel and Jtextfield, meaning that it will display it horizontally.
	 * @return firstNameLayout
	 */
	
	/**********************************LAYOUT METHODS ****************************************/
	private JPanel idLayout()
	{
		JPanel idLayout = new JPanel();
		idLayout.add(new JLabel("ID: "));
		idTextBox = new JTextField(20);
		idTextBox.addFocusListener(new TextHandler());
		idTextBox.setEditable(false);
		idLayout.add(idTextBox);
		
		return idLayout;
	}
	
	
	/*
	 * Returns the first name Jlabel and Jtextfield, meaning that it will display it horizontally.
	 * @return firstNameLayout
	 */
	private JPanel firstNameLayout()
	{
		JPanel firstNameLayout = new JPanel();
		firstNameLayout.add(new JLabel("First Name: "));
		firstNameTextBox = new JTextField(20);
		firstNameTextBox.addFocusListener(new TextHandler());
		firstNameLayout.add(firstNameTextBox);
		
		return firstNameLayout;
	}
	
	/*
	 * Returns the last name JLabel and JTextfield, meaning that it will display it horizontally.
	 * @return lastNameLayout
	 */
	private JPanel lastNameLayout()
	{
		JPanel lastNameLayout = new JPanel();
		lastNameLayout.add(new JLabel("Last Name: "));
		lastNameTextBox = new JTextField(20);
		lastNameTextBox.addFocusListener(new TextHandler());
		
		return lastNameLayout;
	}
	
	/*
	 * Returns the address JLabel and JTextfield, meaning that it will display it horizontally.
	 * @return addressLayout
	 */
	private JPanel addressLayout()
	{
		JPanel addressLayout = new JPanel();
		addressLayout.add(new JLabel("Address: "));
		addressTextBox = new JTextField(20);
		addressTextBox.addFocusListener(new TextHandler());
		addressLayout.add(addressTextBox);
		
		return addressLayout;
	}
	
	/*
	 * Returns the postal code JLabel and JTextfield, meaning that it will display it horizontally.
	 * @return postalCodeLayout
	 */
	private JPanel postalCodeLayout()
	{
		JPanel postalCodeLayout = new JPanel();
		postalCodeLayout.add(new JLabel("Postal Code: "));
		postalCodeTextBox = new JTextField(20);
		postalCodeTextBox.addFocusListener(new TextHandler());
		postalCodeLayout.add(postalCodeTextBox);
		
		return postalCodeLayout;
	}
	
	/*
	 * Returns the phone number name JLabel and JTextfield, meaning that it will display it horizontally.
	 * @return phoneNumberLayout
	 */
	private JPanel phoneNumberLayout()
	{
		JPanel phoneNumberLayout = new JPanel();
		phoneNumberLayout.add(new JLabel("Phone Number: "));
		phoneNumberTextBox = new JTextField(20);
		phoneNumberTextBox.addFocusListener(new TextHandler());
		phoneNumberLayout.add(phoneNumberTextBox);
		
		return phoneNumberLayout;
	}
	
	/*
	 * Returns the clientType name JLabel and JTextfield, meaning that it will display it horizontally.
	 * @return clientTypeLayout
	 */
	private JPanel clientTypeLayout()
	{
		JComboBox clientTypeComboBox = new JComboBox();
		clientTypeComboBox.addItem("R");
		clientTypeComboBox.addItem("C");
		clientTypeComboBox.setEditable(true);
		//clientTypeComboBox.addActionListener(listener);
		
		JPanel clientTypePanel = new JPanel();
		clientTypePanel.add(clientTypeComboBox);
		
		String tempClientType = (String)clientTypeComboBox.getSelectedItem();
		clientType = tempClientType.charAt(0);
		
		return clientTypePanel;
	}
	
	/*
	 * @return radioBoxPanel
	 * creation of the top right radio buttons
	 */
	private JPanel radioBoxLayout()
	{
		JPanel radioBoxPanel = new JPanel();
		
		JRadioButton clientIdButton   = new JRadioButton("Client Id"  , false);
		JRadioButton lastNameButton    = new JRadioButton("Last Name"   , false);
		JRadioButton clientTypeButton = new JRadioButton("Client Type", false);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(clientIdButton);
		bgroup.add(lastNameButton);
		bgroup.add(clientTypeButton);

		radioBoxPanel.setLayout(new GridLayout(4, 1));
		radioBoxPanel.add(clientIdButton);
		radioBoxPanel.add(lastNameButton);
		radioBoxPanel.add(clientTypeButton);
		radioBoxPanel.add(search);
		
		radioBoxPanel.setBorder(BorderFactory.createTitledBorder(
		           BorderFactory.createEtchedBorder(), "Search by:"));
		
		return radioBoxPanel;
	}
	
	
	/***********************************Panel Creation****************************************/
	
	/*
	 * @return bottomPanel
	 */
	private JPanel createBottomRightButtonBlock()
	{
		JPanel bottomPanel = new JPanel();
		Border buttonEdge = BorderFactory.createRaisedBevelBorder();
		
		addButton = new JButton(" Submit/Add ");
		addButton.setBorder(buttonEdge);
		addButton.addActionListener(new ButtonListener());
		bottomPanel.add(addButton);
		
		clearButton = new JButton(" Clear ");
		clearButton.setBorder(buttonEdge);
		clearButton.addActionListener(new ButtonListener());
		bottomPanel.add(clearButton);
		
		closeButton = new JButton(" Close ");
		closeButton.setBorder(buttonEdge);
		closeButton.addActionListener(new ButtonListener());
		bottomPanel.add(closeButton);
		
		return bottomPanel;
	}
	
	/*
	 * @return topLeftPanel
	 */
	private JPanel createTopLeftPanel()
	{
		JPanel topLeftPanel = new JPanel();
		topLeftPanel.add(radioBoxLayout());
		
		return topLeftPanel;
	}
	
	/*
	 * @return centerPanel
	 */
	private JPanel createBottomLeftPanel()
    {
        JPanel centerPanel = new JPanel();
        listArea = new JList();        
        String width = "12345678901234567890123456789";
        listArea.setPrototypeCellValue(width);
        listArea.setFont(new Font("Courier New",Font.BOLD,12));
        listArea.setVisibleRowCount(15);
		listScrollPane = new JScrollPane(listArea);
		
		//listVector.add("Before Run");		
		
		listArea.setListData(listVector);
		
        centerPanel.add(listScrollPane);
        return centerPanel;  
    }
	
	
	/******************************Listeners***************************************/
	
	/*
	 * List Listener is the box with the search 
	 */
	public abstract class RadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String line;
			if(e.getActionCommand() == "Client Id")
			{
				
				line = search.getText();
				//cb.search(line, id);
			}
			if(e.getActionCommand() == "lastName")
			{
				line = search.getText();
				cb.search(line, lastName);
			}
			if(e.getActionCommand() == "Client Type")
			{
				line = search.getText();
				cb.search(line, tempClientType);
			}
		}
	}
	
	/*
	 * Why do I have this again...
	 */
	private class TextHandler implements FocusListener
    {    
	    public void focusGained(FocusEvent e)
	    {	        
	    }
	
	    public void focusLost(FocusEvent e)
	    {
	        
	    }
        
    }
	
	/*
	 * Button listener, click a button and it does this!
	 */
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == addButton)
			{
				firstName = firstNameTextBox.getText();
				lastName = lastNameTextBox.getText();
				address = addressTextBox.getText();
				postalCode = postalCodeTextBox.getText();
				phoneNumber = phoneNumberTextBox.getText();
				
				Client c = new Client(id, firstName, lastName, address, postalCode, phoneNumber, clientType);
				
				try
				{
					cb.validate(c);
					System.out.println(cb.persist(c));
				} 
				catch (InvalidPostalCodeException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				catch (InvalidPhoneNumberException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//v1 = Double.parseDouble(valueOneTF.getText());
				//v2 = Double.parseDouble(valueTwoTF.getText());
				//ans = v1 + v2;
				//answerTF.setText(""+ans);
			}
			
			if(e.getSource() == clearButton)
			{
				idTextBox.setText("");
				firstNameTextBox.setText("");
				lastNameTextBox.setText("");
				addressTextBox.setText("");
				postalCodeTextBox.setText("");
				phoneNumberTextBox.setText("");
			}
			
			if(e.getSource() == closeButton)
			{
				System.exit(1);
			}
		}
		
	}
}


