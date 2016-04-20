/**
 * Jan 23, 2009
 */
package addingGUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

/**
 * @author 432873
 * @version1
 */

public class AddingMachine
{
	//Attributes
	private JFrame			frame;
	
	//center block attributes 
	private JTextField 		valueOneTF;
	private JTextField 		valueTwoTF;
	private JTextField 		answerTF;
	
	//bottom block attributes
	private JButton 		addButton;
	private JButton 		clearButton;
	private JButton 		closeButton;
	
	//Constructor 
	public AddingMachine()
	{
		createWindow();
	}
	
	//Operational Methods
	private void createWindow()
	{
		frame = new JFrame("Zippy Adding Machine");
		frame.setBounds(75, 75, 350, 200);
		Container mainPane = frame.getContentPane();
		mainPane.setLayout(new BorderLayout(5,5));
		
		//Upper panel holding the title of the calculator
		mainPane.add(createTitleBlock(),BorderLayout.NORTH);
		
		//Center panel holding the labels and textfields for the Calculator
		mainPane.add(createCenterCalculatorBlock(), BorderLayout.CENTER);
		
		//Bottom panel holding the buttons for add, clear and close
		mainPane.add(createBottomButtonBlock(),BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private JPanel createTitleBlock()
	{
		JPanel titlePanel = new JPanel();
		JLabel titleL = new JLabel("My Addition Calculator");
		//titleL.setForeground(Color)
		titleL.setForeground(new Color(123, 145, 67));
		titleL.setFont(new Font("TimesRoman",Font.BOLD,24));
		
		titlePanel.add(titleL);
		
		return titlePanel;
	}
	
	private JPanel createCenterCalculatorBlock()
	{
		JPanel centerPanel = new JPanel(new GridLayout(3,2));
		
		//row 1
		JLabel valueOneL = new JLabel("First Value: ", SwingConstants.RIGHT);
		centerPanel.add(valueOneL);
		JPanel row1r = new JPanel();
		valueOneTF = new JTextField(20);
		valueOneTF.setBackground(Color.WHITE);
		valueOneTF.setFont(new Font("Courier",Font.PLAIN,12));
		row1r.add(valueOneTF);
		centerPanel.add(row1r);
		
		//row 2
		JLabel valueTwoL = new JLabel("Second Value: ", SwingConstants.RIGHT);
		centerPanel.add(valueTwoL);
		JPanel row2r = new JPanel();
		valueTwoTF = new JTextField(20);
		valueTwoTF.setBackground(Color.WHITE);
		valueTwoTF.setFont(new Font("Courier",Font.PLAIN,12));
		row2r.add(valueTwoTF);
		centerPanel.add(row2r);
		
		//row 3
		JLabel answerL = new JLabel("Answer: ", SwingConstants.RIGHT);
		centerPanel.add(answerL);
		JPanel row3r = new JPanel();
		answerTF = new JTextField(20);
		answerTF.setBackground(Color.WHITE);
		answerTF.setFont(new Font("Courier",Font.PLAIN,12));
		answerTF.setEditable(false);
		row3r.add(answerTF);
		centerPanel.add(row3r);
		
		return centerPanel;
	}
	
	private JPanel createBottomButtonBlock()
	{
		JPanel bottomPanel = new JPanel();
		Border buttonEdge = BorderFactory.createRaisedBevelBorder();
		
		addButton = new JButton(" Add ");
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
	
	/*****************************************INNER CLASSES*********************************/
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == addButton)
			{
				double v1, v2, ans;
				
				v1 = Double.parseDouble(valueOneTF.getText());
				v2 = Double.parseDouble(valueTwoTF.getText());
				ans = v1 + v2;
				
				answerTF.setText(""+ans);
			}
			
			if(e.getSource() == clearButton)
			{
				valueOneTF.setText("");
				valueTwoTF.setText("");
				answerTF.setText("");
				valueOneTF.requestFocus();
			}
			
			if(e.getSource() == closeButton)
			{
				System.exit(1);
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new AddingMachine();
		
	}

}
