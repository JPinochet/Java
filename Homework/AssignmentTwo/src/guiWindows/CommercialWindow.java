/**
 * Feb 18, 2009
 */
package guiWindows;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import saitMLS.exceptions.InvalidGarageTypeException;
import saitMLS.exceptions.InvalidPhoneNumberException;
import saitMLS.exceptions.InvalidPostalCodeException;
import saitMLS.exceptions.InvalidQuadrantException;
import saitMLS.exceptions.InvalidZoneException;

import saitMLS.persistance.CommercialPropertyBroker;
import saitMLS.problemDomain.Client;
import saitMLS.problemDomain.CommercialProperty;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * @author 432873
 *
 */
public class CommercialWindow
{
	CommercialPropertyBroker cb = CommercialPropertyBroker.getBroker();
	
	//Attributes
	private long							id;
	private String							name;
	private String							address;
	private String							quadrant;
	private String							zone;
	private double							askingPrice;
	private String							comments;
	private String								type;
	private int								floorNumber;
	private Vector							listVector;
	private String 							tempQ;
	private String							tempZ;
	private String							tempT;
	
	
	//The boxes, called fields in java
	private JTextField						idTextBox;
	private JTextField						nameTextBox;
	private JTextField						addressTextBox;
	private JTextField						quadrantTextBox;
	private JTextField						zoneTextBox;
	private JTextField						askingPriceTextBox;
	private JTextField						commentsTextBox;
	private JTextField						floorNumberTextBox;
	
	//Text Manipulation
	private JList							listArea;
	private JScrollPane 					listScrollPane;
	
	//BorderAttributes
	Border 									rightBorder;
	
	//ButtonAttributes
	private JButton							addButton;
	private JButton							clearButton;
	private JButton							closeButton;
	private JTextField 						tf;
	private JTextField						textField;
	private String 							text;
	JTextField search = new JTextField(20);
	
	//default Constructor
	public CommercialWindow()
	{
		
	}
	
	public JPanel createCommercialPanel()
	{
		JPanel commercialPanel = new JPanel();
		
		JLabel commercialLabel = new JLabel("The Commercial Property Screen",SwingConstants.CENTER);
		commercialLabel.setForeground(Color.CYAN);
		commercialLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD ,35));
		commercialPanel.add(commercialLabel);
		
		tf = new JTextField(20);
		commercialPanel.add(tf);
		
		textField = new JTextField(15);
        textField.addFocusListener(new TextHandler());
        commercialPanel.add(textField);
		
		return commercialPanel;
	}
	
	/*********************************INNER CLASSES****************************************************/
	
	
	private JPanel createRightBorder()
	{
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(11,1));
		rightPanel.setBorder(new TitledBorder(new EtchedBorder(),"Commercial Property Information"));
		rightPanel.add(idLayout());
		rightPanel.add(legalDescriptionLayout());
		rightPanel.add(addressLayout());
		rightPanel.add(quadrantLayout());
		rightPanel.add(zoneLayout());
		rightPanel.add(askingPriceLayout());
		rightPanel.add(commentsLayout());
		rightPanel.add(typeLayout());
		rightPanel.add(radioBoxLayout());
		rightPanel.add(floorNumberLayout());
		rightPanel.add(createBottomRightButtonBlock(), BorderLayout.SOUTH);
		
		
		return rightPanel;
	}
	
	
	
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
	
	private JPanel legalDescriptionLayout()
	{
		JPanel nameLayout = new JPanel();
		nameLayout.add(new JLabel("Legal Description: "));
		nameTextBox = new JTextField(20);
		nameTextBox.addFocusListener(new TextHandler());
		nameTextBox.setEditable(false);
		nameLayout.add(nameTextBox);
		
		return nameLayout;
	}
	
	private JPanel addressLayout()
	{
		JPanel addressLayout = new JPanel();
		addressLayout.add(new JLabel("Address: "));
		addressTextBox = new JTextField(80);
		addressTextBox.addFocusListener(new TextHandler());
		addressLayout.add(addressTextBox);
		
		return addressLayout;
	}
	
	private JPanel quadrantLayout()
	{
		JComboBox quadrantComboBox = new JComboBox();
		quadrantComboBox.addItem("NW");
		quadrantComboBox.addItem("NE");
		quadrantComboBox.addItem("Sw");
		quadrantComboBox.addItem("Nw");
		quadrantComboBox.setEditable(true);
		//clientTypeComboBox.addActionListener(listener);
		
		JPanel quadrantPanel = new JPanel();
		quadrantPanel.add(quadrantComboBox);
		
		tempQ = (String)quadrantComboBox.getSelectedItem();
		
		return quadrantPanel;
	}
	
	private JPanel zoneLayout()
	{
		
		JComboBox zoneComboBox = new JComboBox();
		zoneComboBox.addItem("R1");
		zoneComboBox.addItem("R2");
		zoneComboBox.addItem("R3");
		zoneComboBox.addItem("R4");
		zoneComboBox.addItem("I1");
		zoneComboBox.addItem("I2");
		zoneComboBox.addItem("I3");
		zoneComboBox.addItem("I4");
		zoneComboBox.setEditable(true);
		//clientTypeComboBox.addActionListener(listener);
		
		JPanel zonePanel = new JPanel();
		zonePanel.add(zoneComboBox);
		
		tempZ = (String)zoneComboBox.getSelectedItem();
		
		return zonePanel;
	}
	
	private JPanel askingPriceLayout()
	{
		JPanel askingPriceLayout = new JPanel();
		askingPriceLayout.add(new JLabel("Asking Price: "));
		askingPriceTextBox = new JTextField(20);
		askingPriceTextBox.addFocusListener(new TextHandler());
		askingPriceTextBox.setEditable(false);
		askingPriceLayout.add(askingPriceTextBox);
		
		return askingPriceLayout;
	}
	
	private JPanel commentsLayout()
	{
		JPanel commentLayout = new JPanel();
		commentLayout.add(new JLabel("Comments: "));
		commentsTextBox = new JTextField(20);
		commentsTextBox.addFocusListener(new TextHandler());
		commentsTextBox.setEditable(false);
		commentLayout.add(commentsTextBox);
		
		return commentLayout;
	}
	
	private JPanel typeLayout()
	{
		JComboBox typeComboBox = new JComboBox();
		typeComboBox.addItem("m");
		typeComboBox.addItem("o");
		typeComboBox.setEditable(true);
		//typeComboBox.addActionListener(listener);
		
		JPanel typePanel = new JPanel();
		typePanel.add(new JLabel("Type: "));
		typePanel.add(typeComboBox);
		
		tempT = (String)typeComboBox.getSelectedItem();
		
		return typePanel;
	}
	
	private JPanel radioBoxLayout()
	{
		JPanel radioBoxPanel = new JPanel();
		
		JRadioButton clientIdButton   = new JRadioButton("Id"  , false);
		JRadioButton lastNameButton    = new JRadioButton("Name"   , false);
		JRadioButton clientTypeButton = new JRadioButton("Price", false);
		JRadioButton quadrantTypeButton = new JRadioButton("Quadrant", false);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(clientIdButton);
		bgroup.add(lastNameButton);
		bgroup.add(clientTypeButton);
		bgroup.add(quadrantTypeButton);

		radioBoxPanel.setLayout(new GridLayout(4, 1));
		radioBoxPanel.add(clientIdButton);
		radioBoxPanel.add(lastNameButton);
		radioBoxPanel.add(clientTypeButton);
		radioBoxPanel.add(quadrantTypeButton);
		radioBoxPanel.add(search);
		
		radioBoxPanel.setBorder(BorderFactory.createTitledBorder(
		           BorderFactory.createEtchedBorder(), "Search by:"));
		
		return radioBoxPanel;
	}
	
	private JPanel floorNumberLayout()
	{
		JPanel floorNumberLayout = new JPanel();
		floorNumberLayout.add(new JLabel("Number of floors: "));
		floorNumberTextBox = new JTextField(2);
		floorNumberTextBox.addFocusListener(new TextHandler());
		floorNumberTextBox.setEditable(false);
		floorNumberLayout.add(floorNumberTextBox);
		
		return floorNumberLayout;
	}
	
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
	
	private JPanel createLeftBorder()
	{
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2,1));
		leftPanel.setBorder(new TitledBorder(new EtchedBorder(), "Select type of search to be performed."));
		leftPanel.add(createTopLeftPanel(), BorderLayout.NORTH);
		leftPanel.add(createBottomLeftPanel(), BorderLayout.SOUTH);
		
		return leftPanel;
	}
	
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
	
	private JPanel createTopLeftPanel()
	{
		JPanel topLeftPanel = new JPanel();
		topLeftPanel.add(radioBoxLayout());
		
		return topLeftPanel;
	}
	
	
	/*
	 * Text Handler
	 */
	public class TextHandler implements FocusListener
    {    
	    public void focusGained(FocusEvent e)
	    {	        
	    }
	
	    public void focusLost(FocusEvent e)
	    {
	        text = textField.getText();
	        
	    }
        
    }
	
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == addButton)
			{
				id = (0);
				name = nameTextBox.getText();
				quadrant = quadrantTextBox.getText();
				address = addressTextBox.getText();
				zone = zoneTextBox.getText();
				askingPrice = Double.parseDouble(askingPriceTextBox.getText());
				comments = commentsTextBox.getText();
				floorNumber = Integer.parseInt(floorNumberTextBox.getText());
				
				CommercialProperty c = new CommercialProperty(id, name, address, quadrant, zone, askingPrice, comments, type, floorNumber);
				
				try
				{
					cb.validate(c);
				} 
				catch (InvalidQuadrantException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidZoneException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidGarageTypeException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(cb.persist(c));
			}
			
			if(e.getSource() == clearButton)
			{
				idTextBox.setText("0");
				nameTextBox.setText("");
				quadrantTextBox.setText("");
				addressTextBox.setText("");
				zoneTextBox.setText("");
				askingPriceTextBox.setText("");
				commentsTextBox.setText("");
				floorNumberTextBox.setText("");
			}
			
			if(e.getSource() == closeButton)
			{
				System.exit(1);
			}
		}
		
	}
	
	public abstract class RadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String line;
			if(e.getActionCommand() == "Id")
			{
				
				line = search.getText();
				//cb.search(line, id);
			}
			if(e.getActionCommand() == "Name")
			{
				line = search.getText();
				cb.search(line, name);
			}
			if(e.getActionCommand() == "Type")
			{
				line = search.getText();
				cb.search(line, type);
			}
			if(e.getActionCommand() == "Quadrant")
			{
				line = search.getText();
				cb.search(line, quadrant);
			}
		}
	}
	
}
