/**
 * Created on Jan 28, 2009
 *
 * Project: simpleGUIWithList
 */
package addingGUI;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

/**
 * @author Jorge!
 * 
 */
public class GUIListener extends JFrame
{
	//Attributes
	private Container			mainPane;
	private JTextField			textField;
    private JTextField			textField2;
    private JLabel				labelArea;
    private	JButton				button1;
    private JList				listArea;
    private Vector				listVector;
    private JScrollPane 		listScrollPane;
    private Border 				panelEdge;
    private String 				text;
	
	
    // Constructor
    public GUIListener()
    {
    	super("JList GUI Demo with Listener");
		this.setBounds(300,200,500,500);
		
		panelEdge = BorderFactory.createEtchedBorder();
		
		mainPane = this.getContentPane();
        JPanel mainPanel = new JPanel(new BorderLayout(10,10));        
        
        mainPanel.add(createUpperPanel(),BorderLayout.NORTH);
        mainPanel.add(createCenterPanel(),BorderLayout.CENTER);
        mainPanel.add(createLowerPanel(),BorderLayout.SOUTH);
        
        mainPane.add(mainPanel);
        
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
	    
	    /**
	     * Method to create the upper panel that will hold the text field,
	     * button and label.  This method creates the panel and returns it
	     * to be added to the container.
	     */
	    private JPanel createUpperPanel()
	    {
	        JPanel upperPanel = new JPanel();
	        Box vBox = Box.createHorizontalBox();
	        Border buttonEdge = BorderFactory.createRaisedBevelBorder();
	        
	        button1 = new JButton("Get Value");
	        button1.setBorder(buttonEdge);
	        button1.addActionListener(new ButtonListener());
	        vBox.add(button1);
	        
	        vBox.add(Box.createHorizontalStrut(50));
	        textField = new JTextField(15);
	        textField.addFocusListener(new TextHandler());
	        vBox.add(textField);
	        
	        vBox.add(Box.createHorizontalStrut(50));
	        labelArea = new JLabel("Before Run");
	        labelArea.setFont(new Font("Times New Roman",Font.ITALIC,12));
	        labelArea.setForeground(Color.RED);
	        vBox.add(labelArea);
	        
	        upperPanel.add(vBox);
	        upperPanel.setBorder(panelEdge);
	        return upperPanel;
	    }   
	    
	    /**
	     * Method to create the center panel that will hold the JList.
	     * This method creates the panel and returns it
	     * to be added to the container.
	     */
	    private JPanel createCenterPanel()
	    {
	        JPanel centerPanel = new JPanel();
	        centerPanel.setBorder(panelEdge);
	        listArea = new JList();        
	        String width = "1234567890123456789012345678901234567890";
	        listArea.setPrototypeCellValue(width);
	        listArea.setFont(new Font("Courier New",Font.BOLD,12));
	        listArea.setVisibleRowCount(15);
	        listArea.addListSelectionListener(new ListListener());
			listScrollPane = new JScrollPane(listArea);
			
			listVector = new Vector();
			listVector.add("Before Run");		
			
			listArea.setListData(listVector);
			
	        centerPanel.add(listScrollPane);
	        return centerPanel;  
	    }
	    
	    /**
	     * Method to create the lower panel that will hold a JTextField and
	     * a JLabel.
	     * This method creates the panel and returns it
	     * to be added to the container.
	     */
	    private JPanel createLowerPanel()
	    {
	        JPanel lowerPanel = new JPanel();
	        JLabel label = new JLabel("Text Transferred from JList:");
	        
	        textField2 = new JTextField(20);
	        
	        lowerPanel.add(label);
	        lowerPanel.add(textField2);
	        return lowerPanel;
	    }
	    
	//******************INNER CLASS COMPONENT LISTENERS****************************
	    
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
	    
	    public class ButtonListener implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        { 
	            if(e.getSource() == button1)
	            { 
	                labelArea.setText(text);
	                
	                listVector.add(text);
	                listArea.setListData(listVector);
	            }
	        }
	    }
	    
	    public class ListListener implements ListSelectionListener
	    {
	        public void valueChanged(ListSelectionEvent e)
			{
	            int index = listArea.getSelectedIndex();
				if(index >= 0)
				{
				    String line = (String)listVector.get(index);
				    textField2.setText(line);
				}
			}
	    }
	    
	//****************************MAIN LAUNCH CLASS********************************
	    /**
	     * Main method to launch the window.
	     * 
	     * @param args
	     */
	    public static void main(String[] args)
	    {
	        new GUIListener();
	    }

}
