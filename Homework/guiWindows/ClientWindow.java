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

import saitMLS.exceptions.*;
import saitMLS.persistance.*;
import saitMLS.problemDomain.*;

/**
 * Class to control the contents of the client window
 */
public class ClientWindow {
//Attributes
	private		ClientBroker 		cb;
	private		JTextField			searchText;
	private		JComboBox			searchType;
	private		JButton				searchButton;
	private		JList				searchResults;	
	private		DefaultListModel 	lm;
	private		ArrayList<Client> 	results;
	private		JLabel				idLabel;
	private		JTextField			idText;
	private		JLabel				fNameLabel;
	private		JTextField			fNameText;
	private		JLabel				lNameLabel;
	private		JTextField			lNameText;
	private		JLabel				addrLabel;
	private		JTextField			addrText;
	private		JLabel				pstcdLabel;
	private		JTextField			pstcdText;
	private		JLabel				phnLabel;
	private		JTextField			phnText;
	private		JLabel				typeLabel;
	private		JComboBox			typeBox;
	private		JButton				addButton;
	private		JButton				remButton;
	private		JButton				clrButton;
	
//Constructors
	/**
	 * Default Constructor
	 */
	public ClientWindow() {
		cb = ClientBroker.getBroker();
		lm = new DefaultListModel();
	}
	
//Operational Methods
	/**
	 * Creates the panel for the client window
	 * @return a JPanel containing the client window
	 */
	public JPanel createClientPanel() {
		JPanel panel = new JPanel();		
		panel.add(this.createSearchPanel());
		panel.add(this.createDisplayPanel());
		return panel;
	}
	
	/**
	 * Closes any resources related to the client window
	 */
	public void close() {
		cb.closeBroker();
	}
//***Private Methods	
	/**
	 * Creates the panel containing search components for the client window
	 * @return a JPanel containing search components
	 */
	private JPanel createSearchPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Search"));
	//Add the panel containing search input fields	
		panel.add(this.createSearchInputPanel(),BorderLayout.NORTH);		
	//Add the search results list
		panel.add(this.createSearchResultPanel(),BorderLayout.CENTER);		
		return panel;
	}
	
	/**
	 * Creates the panel containing input components for the search panel
	 * @return a JPanel containing input components
	 */
	private JPanel createSearchInputPanel() {
		JPanel panel = new JPanel(new BorderLayout());
	//Add the text field for search text
		searchText = new JTextField("Enter Search Text");
		searchText.addFocusListener(new FL());
		panel.add(searchText,BorderLayout.NORTH);
	//Add the selector for search type
		JPanel panel2  = new JPanel();		
		String[] searchTypes = {"Search by ID","Search by Name","Search by Type"};
		searchType = new JComboBox(searchTypes);
		panel2.add(searchType,BorderLayout.CENTER);
	//Add the search button
		searchButton = new JButton("Search");
		searchButton.addActionListener(new BL());
		panel2.add(searchButton,BorderLayout.CENTER);
		panel.add(panel2);
		
		return panel;
	}
	
	/**
	 * Creates the panel containing search result components for the search panel
	 * @return a JPanel containing search result components
	 */
	private JScrollPane createSearchResultPanel() {
		searchResults = new JList();
		searchResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchResults.setLayoutOrientation(JList.VERTICAL);
		searchResults.setVisibleRowCount(-1);
		searchResults.addListSelectionListener(new LSL());
		
		JScrollPane listScroller = new JScrollPane(searchResults);
		listScroller.setPreferredSize(new Dimension(150, 450));
		listScroller.setBorder(new TitledBorder(new EtchedBorder(), "Search Results"));
		return listScroller;
	}
	
	/**
	 * Creates the panel containing client display components for the client window
	 * @return a JPanel containing client display components
	 */
	private JPanel createDisplayPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Client Data"));
	//Add the grid containing input text boxes
		panel.add(this.createInputGrid(),BorderLayout.CENTER);
		panel.add(this.createDisplayButtons(),BorderLayout.SOUTH);
		return panel;
	}

	/**
	 * Creates the panel containing the input components for the client display panel
	 * @return a JPanel containing input components for the display panel
	 */
	private JPanel createInputGrid() {
		JPanel panel = new JPanel(new GridLayout(8,2));
		
		idLabel = new JLabel("ID: ");
		idText = new JTextField("0");
		idText.setEditable(false);
		panel.add(idLabel);
		panel.add(idText);
		
		fNameLabel = new JLabel("First Name: ");
		fNameText = new JTextField();
		panel.add(fNameLabel);
		panel.add(fNameText);
		
		lNameLabel = new JLabel("Last Name: ");
		lNameText = new JTextField();
		panel.add(lNameLabel);
		panel.add(lNameText);
		
		addrLabel = new JLabel("Address: ");
		addrText = new JTextField();
		panel.add(addrLabel);
		panel.add(addrText);
		
		pstcdLabel = new JLabel("Postal Code: ");
		pstcdText = new JTextField();
		panel.add(pstcdLabel);
		panel.add(pstcdText);
		
		phnLabel = new JLabel("Phone Number: ");
		phnText = new JTextField();
		panel.add(phnLabel);
		panel.add(phnText);
		
		typeLabel = new JLabel("Client Type: ");
		String[] clientType = {"Commercial","Residential"};
		typeBox = new JComboBox(clientType);
		panel.add(typeLabel);
		panel.add(typeBox);
		
		return panel;
	}
	
	/**
	 * Creates the panel containing buttons for the display panel
	 * @return a JPanel containing buttons for the display panel
	 */
	private JPanel createDisplayButtons() {
		JPanel panel = new JPanel();
		addButton = new JButton("Save");
		addButton.addActionListener(new BL());
		panel.add(addButton);
		remButton = new	JButton("Remove");
		remButton.addActionListener(new BL());
		panel.add(remButton);
		clrButton = new	JButton("Clear");
		clrButton.addActionListener(new BL());
		panel.add(clrButton);

		return panel;
	}
	
//***Inner Classes***
	/**
	 * Button Listener for all buttons in the client window
	 */
	private class BL implements ActionListener {
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == searchButton) {
				int i = searchType.getSelectedIndex();
				switch(i) {
					case 0: { //Search by ID
						results = (ArrayList<Client>) cb.search(searchText.getText(), "id");
						break;
					}
					case 1: { //Search by name
						results = (ArrayList<Client>) cb.search(searchText.getText(), "name");
						break;
					}
					case 2: { //Search by type
						results = (ArrayList<Client>) cb.search(searchText.getText(), "type");
						break;
					}
				}
				lm.clear();
				for(i=0 ; i<results.size() ; i++) {
					lm.addElement(results.get(i).getFirstName() + " " + results.get(i).getLastName());
				}
				
				searchResults.setModel(lm);
			} else if(e.getSource() == addButton){
				Client c;
				String type = (typeBox.getSelectedIndex() == 0) ? ("C") : ("R");
				c = new Client(idText.getText()+";"+
								fNameText.getText()+";"+
								lNameText.getText()+";"+
								addrText.getText()+";"+
								pstcdText.getText()+";"+
								phnText.getText()+";"+
								type);
				
				try {
					cb.validate(c);
					cb.persist(c);
					JOptionPane.showMessageDialog(null, "Client data was saved succesfully.",
							"Client Data Saved",
							JOptionPane.INFORMATION_MESSAGE);
					clrButton.doClick();
				} catch (InvalidPostalCodeException e1) {
					JOptionPane.showMessageDialog(null, "Postal Code is incorrect.\nShould be in format A9A 9A9",
													"Error",
													JOptionPane.ERROR_MESSAGE);
					pstcdText.grabFocus();
				} catch (InvalidPhoneNumberException e1) {
					JOptionPane.showMessageDialog(null, "Phone Number is incorrect.\nShould be in format 999-999-9999",
													"Error",
													JOptionPane.ERROR_MESSAGE);
					phnText.grabFocus();
				}
			} else if(e.getSource() == remButton){
				int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to remove this client?", 
															"Remove Client", 
															JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION){
					int i = searchResults.getSelectedIndex();
					if(cb.remove(results.get(i)))
						JOptionPane.showMessageDialog(null, "Client was removed succesfully.",
								"Client Removed",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Client could not be removed.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					
					clrButton.doClick();

					results.remove(i);
					
					searchResults.clearSelection();
					lm.remove(i);

				}
					
			} else if(e.getSource() == clrButton){
				idText.setText("0");
				fNameText.setText("");
				lNameText.setText("");
				addrText.setText("");
				pstcdText.setText("");
				phnText.setText("");
				typeBox.setSelectedIndex(0);
				searchResults.clearSelection();
				fNameText.grabFocus();
			}
		}
	}
	
	/**
	 * Focus Listener for client window
	 */
	private class FL implements FocusListener {
		/* (non-Javadoc)
		 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
		 */
		@Override
		public void focusGained(FocusEvent e) {
			if(e.getSource() == searchText)
				searchText.selectAll();
		}

		/* (non-Javadoc)
		 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
		 */
		@Override
		public void focusLost(FocusEvent e) {
		}
		
	}
	
	/**
	 * ListSelectionListener for client window
	 */
	private class LSL implements ListSelectionListener {
		/* (non-Javadoc)
		 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(e.getSource() == searchResults) {
				int i = searchResults.getSelectedIndex();
				if(i != -1) {
					Client result = results.get(i);
					idText.setText(result.getId() + "");
					fNameText.setText(result.getFirstName());
					lNameText.setText(result.getLastName());
					addrText.setText(result.getAddress());
					pstcdText.setText(result.getPostalCode());
					phnText.setText(result.getPhoneNumber());
					if (result.getClientType() == 'C')
						typeBox.setSelectedIndex(0);
					else if (result.getClientType() == 'R')
						typeBox.setSelectedIndex(1);
				}
			}
		}
		
	}
}
