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
 * Class to control the Commercial Property Window
 * @author Corey Cantley
 * @version 1.0
 */
public class ComWindow {
//Attributes
	private		CommercialPropertyBroker 		cb;
	private		JTextField						searchText;
	private		JComboBox						searchType;
	private		JButton							searchButton;
	private		JList							searchResults;	
	private		DefaultListModel 				lm;
	private		ArrayList<CommercialProperty> 	results;	
	private		JLabel							idLabel;
	private		JTextField						idText;	
	private		JLabel							legalLabel;
	private		JTextField						legalText;	
	private		JLabel							addrLabel;
	private		JTextField						addrText;	
	private		JLabel							quadLabel;
	private		JComboBox						quadBox;	
	private		JLabel							zoneLabel;
	private		JComboBox						zoneBox;	
	private		JLabel							priceLabel;
	private		JTextField						priceText;	
	private		JLabel							commentLabel;
	private		JTextField						commentText;	
	private		JLabel							typeLabel;
	private		JComboBox						typeBox;	
	private		JLabel							floorsLabel;
	private		JSpinner						floorsText;
	private 	SpinnerNumberModel				floorsModel;	
	private		JButton							addButton;
	private		JButton							remButton;
	private		JButton							clrButton;
	
//Constructors
	/**
	 * Default Constructor
	 */
	public ComWindow() {
		cb = CommercialPropertyBroker.getBroker();
		lm = new DefaultListModel();
	}
	
//Operational Methods
	/**
	 * Creates the panel for the Commercial window
	 * @return a JPanel containing the Commercial window
	 */
	public JPanel createComPanel() {
		JPanel panel = new JPanel();	
		panel.add(this.createSearchPanel());
		panel.add(this.createDisplayPanel());
		return panel;
	}

	/**
	 * Closes any resources related to the Commercial window
	 */
	public void close() {
		cb.closeBroker();
	}
//***Private Methods
	/**
	 * Creates the panel containing search components for the commercial window
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
		String[] searchTypes = {"Search by ID","Search by Legal Description","Search by Price","Search by Quadrant"};
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
	 * Creates the panel containing commercial display components for the commercial window
	 * @return a JPanel containing commercial display components
	 */	
	private JPanel createDisplayPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Commercial Property Data"));
	//Add the grid containing input text boxes
		panel.add(this.createInputGrid(),BorderLayout.CENTER);
		panel.add(this.createDisplayButtons(),BorderLayout.SOUTH);
		return panel;
	}

	/**
	 * Creates the panel containing the input components for the commercial display panel
	 * @return a JPanel containing input components for the display panel
	 */
	private JPanel createInputGrid() {
		JPanel panel = new JPanel(new GridLayout(9,2));
		
		idLabel = new JLabel("ID: ");
		idText = new JTextField("0");
		idText.setEditable(false);
		panel.add(idLabel);
		panel.add(idText);
		
		legalLabel = new JLabel("Legal Description: ");
		legalText = new JTextField();
		panel.add(legalLabel);
		panel.add(legalText);
		
		addrLabel = new JLabel("Address: ");
		addrText = new JTextField();
		panel.add(addrLabel);
		panel.add(addrText);
		
		quadLabel = new JLabel("Quadrant: ");
		String[] quadType = {"NE","NW","SE","SW"};
		quadBox = new JComboBox(quadType);
		panel.add(quadLabel);
		panel.add(quadBox);
		
		zoneLabel = new JLabel("Zone: ");
		String[] zoneType = {"I1","I2","I3","I4"};
		zoneBox = new JComboBox(zoneType);
		panel.add(zoneLabel);
		panel.add(zoneBox);
		
		priceLabel = new JLabel("Asking Price: ");
		priceText = new JTextField();
		panel.add(priceLabel);
		panel.add(priceText);
		
		commentLabel = new JLabel("Comments: ");
		commentText = new JTextField();
		panel.add(commentLabel);
		panel.add(commentText);
		
		typeLabel = new JLabel("Type: ");
		String[] garageType = {"Manufacturing","Office"};
		typeBox = new JComboBox(garageType);
		panel.add(typeLabel);
		panel.add(typeBox);
		
		floorsLabel = new JLabel("Floors: ");
		floorsModel = new SpinnerNumberModel(1,1,null,1);
		floorsText = new JSpinner(floorsModel);
		panel.add(floorsLabel);
		panel.add(floorsText);
		
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
	 * Button Listener for all buttons in the commercial window
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
						results = (ArrayList<CommercialProperty>) cb.search(searchText.getText(), "id");
						break;
					}
					case 1: { //Search by legal desc
						results = (ArrayList<CommercialProperty>) cb.search(searchText.getText(), "legal description");
						break;
					}
					case 2: { //Search by price
						results = (ArrayList<CommercialProperty>) cb.search(searchText.getText(), "price");
						break;
					}
					case 3: { //Search by quadrant
						results = (ArrayList<CommercialProperty>) cb.search(searchText.getText(), "quadrant");
						break;
					}
				}
				lm.clear();
				for(i=0 ; i<results.size() ; i++) {
					lm.addElement(results.get(i).getAddress());
				}
				
				searchResults.setModel(lm);
			} else if(e.getSource() == addButton){
				CommercialProperty p;
				String type = (typeBox.getSelectedIndex() == 0) ? ("M") : ("O");
				p = new CommercialProperty(Long.parseLong(idText.getText()),
											legalText.getText(),
											addrText.getText(),
											quadBox.getSelectedItem().toString(),
											zoneBox.getSelectedItem().toString(),
											Double.parseDouble(priceText.getText()),
											commentText.getText(),
											type,
											floorsModel.getNumber().intValue());

				
				
					try {
						cb.validate(p);
						cb.persist(p);
						JOptionPane.showMessageDialog(null, "Property data was saved succesfully.",
								"Property Data Saved",
								JOptionPane.INFORMATION_MESSAGE);
						clrButton.doClick();
					} catch (InvalidQuadrantException e1) {
						JOptionPane.showMessageDialog(null, "Invalid Quadrant",
															"Error",
															JOptionPane.ERROR_MESSAGE);
					} catch (InvalidZoneException e1) {
						JOptionPane.showMessageDialog(null, "Invalid Zone",
															"Error",
															JOptionPane.ERROR_MESSAGE);
					} catch (InvalidGarageTypeException e1) {
						JOptionPane.showMessageDialog(null, "Invalid Garage",
															"Error",
															JOptionPane.ERROR_MESSAGE);
					}
			} else if(e.getSource() == remButton){
				int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to remove this property?", 
															"Remove Property", 
															JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION){
					int i = searchResults.getSelectedIndex();
					if(cb.remove(results.get(i)))
						JOptionPane.showMessageDialog(null, "Property was removed succesfully.",
								"Property Removed",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Property could not be removed.",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					
					clrButton.doClick();

					results.remove(i);
					
					searchResults.clearSelection();
					lm.remove(i);
				}
					
			} else if(e.getSource() == clrButton){
				idText.setText("0");
				legalText.setText("");
				addrText.setText("");
				quadBox.setSelectedIndex(0);
				zoneBox.setSelectedIndex(0);
				priceText.setText("");
				commentText.setText("");
				floorsText.setValue(1);
				typeBox.setSelectedIndex(0);
				searchResults.clearSelection();
				legalText.grabFocus();
			}
		}
	}

	/**
	 * Focus Listener for commercial window
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
	 * ListSelectionListener for commercial window
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
					CommercialProperty result = results.get(i);
					idText.setText(result.getId() + "");
					legalText.setText(result.getLegalDescription());
					addrText.setText(result.getAddress());
					if (result.getQuadrant().equals("NE"))
						quadBox.setSelectedIndex(0);
					else if (result.getQuadrant().equals("NW"))
						quadBox.setSelectedIndex(1);
					else if (result.getQuadrant().equals("SE"))
						quadBox.setSelectedIndex(2);
					else if (result.getQuadrant().equals("SW"))
						quadBox.setSelectedIndex(3);
					if (result.getZone().equals("I1"))
						zoneBox.setSelectedIndex(0);
					else if (result.getZone().equals("I2"))
						zoneBox.setSelectedIndex(1);
					else if (result.getZone().equals("I3"))
						zoneBox.setSelectedIndex(2);
					else if (result.getZone().equals("I4"))
						zoneBox.setSelectedIndex(3);
					priceText.setText(result.getAskingPrice()+"");
					commentText.setText(result.getComments());
					floorsText.setValue(result.getNoFloors());
					typeBox.setSelectedIndex((result.getType().equals("M") ? 0 : 1));
				}
			}
		}
		
	}
}
