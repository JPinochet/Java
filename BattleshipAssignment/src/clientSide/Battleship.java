/**
 * 
 */
package clientSide;

import javax.swing.*;
import javax.swing.border.*;
import serverSide.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author 432873
 *
 */
public class Battleship extends JFrame implements ActionListener, Observer
{
	//Constants
	private static final long	serialVersionUID = -5787162844649899811L;
	private static int 			GRIDSIZE = 11;
	
	//General Attributes
	private JFrame 			frame;
	private JLabel			youLabel;
	private JLabel			enemyLabel;
	
	private static JButton ok = new JButton("OK"),	//closes stats menu
						   done =new JButton("Done");	//closes options menu
	private static JFrame statistics= new JFrame("Statistics"),	//holds stats
						  options=new JFrame("Options");	//holds opts
	private static JLabel data,	//used for stats menu
						  title;	//used for options menu
	private static JPanel stats=new JPanel(),	//used for stats menu
						  opts, 	//used for options menu
						  inputpanel;  	//for manually inputting ships
	private static Container b,c,d; 	 //board and input panel 
	private JPanel input; 	 //input bar	
	private static JMenuItem m,pvp,pvc,cvc;  //menu items	
	private static String[] cletters = {" ","A","B","C","D","E","F","G","H","I","J"}, 	//array of letters used for combo boxes
			    	 cnumbers = {" ","1","2","3","4","5","6","7","8","9","10"}, 		//array of numbers used for combo boxes
					 ships = {"Carrier","Battleship","Submarine","Destroyer",
					 "Patrol Boat"},													//strings used for ship combo box
					 direction = {"Horizontal","Vertical"},								//directions
					 level={"Normal", "Ridiculously Hard"}, 
					 layout={"Manual","Automatic"},
					 colors={"Cyan", "Green", "Yellow", "Magenta", "Pink", "Red",
					 "White"},
					 first={"Player 1", "Player 2", "Random"};							//used for options
	
	private JComboBox cshi = new JComboBox(ships),										//ships
					  cdir = new JComboBox(direction);									//directions
	
	private static JComboBox aiLevel=new JComboBox(level),
						     shipLayout=new JComboBox(layout),
							 shipColor=new JComboBox(colors),
							 playsFirst=new JComboBox(first);							//used for options menu
	private JTextField mbar = new JTextField();											//message bar
	
	private static int enemy = 1,
				i, j, //counters							
				length = 5,
				you = 0,
				prevcolor = 0, //index of previous color
				prevFirst = 0,
				prevLayout = 0,
				prevLevel = 0, //tracks changes in corresponding combo boxes
				ready = 0,
				sindex = 0,	//stores index of array
				dindex = 0;	//direction	
	private static Player players[] = new Player[2];
	private static JButton deploy = new JButton("DEPLOY");
	
	//counters to track the use of all ships
	private static int 	carrierCheck = 0, 		//variable that determines whether or not a carrier has been placed
						battleShipCheck = 0, 	//variable that determines whether or not a battleship has been placed
						submarineCheck = 0, 	//variable that determines whether or not a submarine has been placed
						destroyCheck = 0,		//variable that determines whether or not a destroyer has been placed
						patrolBoatCheck = 0;	//variable that determines whether or not a patrol boat has been placed
	
	private static String user, user2;
	private static Color[] color = {Color.cyan,Color.green,Color.yellow,Color.magenta,
									Color.pink,	Color.red,	Color.white};		 	
	private static Object selectedValue = " ",
						  gametype;
	private static BSClient me;
	private static boolean gameover = false;

	//Chat window attributes
	private JTextArea 		chatDisplay;
	private JScrollPane		chatTA;
	private JTextField 		chatTF;
	private JButton			sendB;
	
	//Connection window attributes
	private JButton 		connectButton;
	private JButton			disConnectButton;
	
	//Functionality attributes
	private Socket			socket;
	private String			userName;
	private ObjectOutputStream 	oos;
	private InputListener  	listener;
	
	/**
	 * Simple Constructor
	 */
	public Battleship()
	{
		userName = JOptionPane.showInputDialog("Please enter your username");
		guiWindow();
	}
	
	/**
	 * Creates the method that makes the playing field when the player
	 * places the ships on the grid.
	 * 
	 * @param n indicates which player the grid is being made for
	 * @return JPanel with created grid and board.
	 */
	public JPanel setBoard(int n)
	{
		players[n].setMyBoard(new JPanel(new GridLayout(11,11)));//panel to store board		
		JTextField k;		
		for (i = 0; i < GRIDSIZE; i++)
		{			
			for (j = 0; j < GRIDSIZE; j++)
			{
				if ((j!=0)&&(i!=0))
				{					
					players[n].getBboard(i-1,j-1).addActionListener(new BoardListener());
					players[n].getMyBoard().add(players[n].getBboard(i-1,j-1));
				}				
				if (i == 0)
				{				
					if (j != 0)
					{	
						//used to display row of numbers
						k = new JTextField(Battleship.getCnumbers(j));
						k.setEditable(false);
						k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					}									
					else 
					{	
						//used to display column of numbers
						k = new JTextField();
						k.setEditable(false);						
					}
					players[n].getMyBoard().add(k);
				}
				else if (j == 0)					
				{	
					k = new JTextField(Battleship.getCletters(i));	
					k.setEditable(false);
					k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					players[n].getMyBoard().add(k);
				}				
			}
		}
		return players[n].getMyBoard();		
	}
	
	/**
	 *  Method creates board and automatically places ship.
	 *  
	 * @param u which player the board is created for
	 * @param t 
	 * @return JPanel with grid and auto placed ship.
	 */
	public JPanel autoBoard(int u,int t) 
	{
		players[u].setGBoard(new JPanel(new GridLayout(11,11)));//panel to store board		
		JTextField k;	
		if (!players[u].getUser().equals("Unknown"))
			for (i = 0; i < 5; i++)
			{				
				players[u].setBoats(i,players[u].getBoats(i).compinput(i,u));
			}		
		for (i = 0; i < GRIDSIZE; i++)
		{			
			for (j = 0; j < GRIDSIZE; j++)
			{
				if ((j != 0) && (i != 0))
				{								
					if ((players[u].getUser().equals("Computer"))||(isLocal()))						
					{						
						players[u].getBboard(i - 1,j - 1).addActionListener(new AttackListener());									
					}						
					else if
						((players[t].getUser().equals("Computer")) || (players[t].getUser().equals("CPU1")) || (players[t].getUser().equals("CPU2")) || (players[t].getUser().equals("Unknown")))			
					{
						if (players[u].getHitOrMiss(i - 1,j - 1))
							players[u].setBboard(i - 1,j - 1,getColor());						
					}
					else
					{
						players[u].getBboard(i - 1,j - 1).addActionListener(new InternetListener());		
					}
					players[u].getGBoard().add(players[u].getBboard(i - 1,j - 1));
				}				
				if (i == 0)
				{				
					if (j != 0)
					{	
						//used to display row of numbers
						k = new JTextField(Battleship.getCnumbers(j));
						k.setEditable(false);
						k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					}									
					else 
					{	
						//used to display column of numbers
						k = new JTextField();
						k.setEditable(false);						
					}
					players[u].getGBoard().add(k);
				}
				else if (j == 0)					
				{	
					k = new JTextField(Battleship.getCletters(i));	
					k.setEditable(false);
					k.setHorizontalAlignment((int)JFrame.CENTER_ALIGNMENT); 
					players[u].getGBoard().add(k);
				}				
			}			
		}
		return players[u].getGBoard();		
	}
	
	/**
	 * Method to randomize who goes first.
	 */
	public void whoGoesFirst()
	{
		int x=0;
		if (playsFirst.getSelectedIndex()!=2)
		{
			if (playsFirst.getSelectedIndex()!=you)
				flipYou();	
			players[playsFirst.getSelectedIndex()].getTimer().start();
			x=playsFirst.getSelectedIndex();
		}
		else
		{		
			int rand=(int)(Math.random()*2);					
			JOptionPane.showMessageDialog(null,players[rand].getUser()+" will "
			+"go first.","",JOptionPane.PLAIN_MESSAGE);
			if (rand!=you)
				flipYou();	
			players[rand].getTimer().start();
			x=rand;
		}
		if
		((!players[x].getUser().equals("Computer"))||(!players[x].getUser().equals("CPU1"))||(!players[x].getUser().equals("CPU2")))
			players[x].setMove(true);
	}
	
	/**
	 *  Method that switches whose turn it is.
	 */
	public static void flipYou()
	{
		if (you==1)
		{	
			you=0;
			enemy=1;
		}
		else
		{
			you=1;
			enemy=0;
		}	
	}
	
	/**
	 * Method that determines whether or not shipLayout is automatic or not.
	 * 
	 * @return true/false
	 */
	public static boolean isAutoSet()
	{
		if (shipLayout.getSelectedIndex() == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Method checks if the game takes place on the computer or over the internet
	 * 
	 * @return true/false 
	 */
	public static boolean isLocal()
	{
		if ((gametype==pvp) && (selectedValue.equals("Local")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//creates panels that used to place ships
	public JPanel shipinput()
	{
		input= new JPanel();
		
		mbar.setText("Select a ship, its front position and direction.");
		mbar.setFont(new Font("Courier New", Font.BOLD, 14));
		mbar.setEditable(false);
		
		cshi.setSelectedIndex(0);	
		cshi.addActionListener(new ShipsListener());
		
		TitledBorder title;	//used for titles around combo boxes
		title = BorderFactory.createTitledBorder("Ships");
		
		cshi.setBorder(title);	
		input.add(cshi);		
		cdir.setSelectedIndex(0);	
		cdir.addActionListener(new DirectListener());
		
		input.add(cdir);
		title = BorderFactory.createTitledBorder("Direction");
		cdir.setBorder(title);		
		deploy.setEnabled(false);
		deploy.addActionListener(new DeployListener());
		input.add(deploy);
		
		return input;
	}
	
	/***********************************Private methods***********************************************************/
	
	/**
	 *  Method that creates the GUI window
	 */
	private void guiWindow()
	{
		frame = new JFrame("Battleship");
		frame.setBounds(50, 50, 1200, 550);
		
		setJMenuBar(createMenuBar());
		
		Container mainPanel = frame.getContentPane();
		mainPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		mainPanel.add(titlePanel(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		players[you] = new Player (userName);
		b = getContentPane();
		b.add(setBoard(you));
		mainPanel.add(b, gbc);
		mainPanel.add(setBoard(you), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		players[enemy] = new Player ("Computer");
		d = getContentPane();
		inputpanel = shipinput();
		d.add(inputpanel);
		c = getContentPane();
		mainPanel.add(c, gbc);
		mainPanel.add(d, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.PAGE_END;
		mainPanel.add(youPanel(), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.PAGE_END;
		mainPanel.add(enPanel(), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		mainPanel.add(bottomLeftPanel(), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.PAGE_END;
		mainPanel.add(bottomRightPanel(), gbc);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	
	/**
	 * Creates Panel displaying enemy username
	 * @return simplePanel, with enemy username
	 */
	private JPanel enPanel()
	{
		JPanel simplePanel = new JPanel();
		
		enemyLabel = new JLabel("Enemy");
		
		simplePanel.add(enemyLabel);
		
		return simplePanel;
	}
	
	/**
	 * Panel that creates the username.
	 * @return simplePanel with label displaying username
	 */
	private JPanel youPanel()
	{
		JPanel simplePanel = new JPanel();
		
		youLabel = new JLabel(userName);
		
		simplePanel.add(youLabel);
		
		return simplePanel;
	}
	
	/**
	 * Method creates the connection board
	 * @return connectionPanel
	 */
	private JPanel bottomRightPanel()
	{
		JPanel connectionPanel = new JPanel(new BorderLayout());
		connectionPanel.setBorder(new TitledBorder(new EtchedBorder(), "Connection Board"));
		
		connectButton = new JButton("Connect");
		connectButton.addActionListener(this);
		connectionPanel.add(connectButton, BorderLayout.WEST);
		
		disConnectButton = new JButton("Disconnect");
		disConnectButton.addActionListener(this);
		connectionPanel.add(disConnectButton, BorderLayout.EAST);
		
		return connectionPanel;
	}
	
	/**
	 * Method creates the player chat panel
	 * @return chatPanel
	 */
	private JPanel bottomLeftPanel()
	{
		JPanel chatPanel = new JPanel(new BorderLayout());
		chatPanel.setBorder(new TitledBorder(new EtchedBorder(), "Chat Window"));
		
		chatDisplay = new JTextArea(5, 30);
		chatDisplay.setEditable(false);
		chatTA = new JScrollPane();
		chatTA.setViewportView(chatDisplay);
		
		JPanel chatPanelTA = new JPanel();
		chatPanelTA.add(chatTA);
		
		chatPanel.add(chatPanelTA, BorderLayout.CENTER);
		
		chatTF = new JTextField(25);
		sendB = new JButton("Send");
		sendB.addActionListener(this);
		JPanel chatPanelSend = new JPanel(new BorderLayout());
		chatPanelSend.add(chatTF, BorderLayout.WEST);
		chatPanelSend.add(sendB, BorderLayout.EAST);
		
		chatPanel.add(chatPanelSend, BorderLayout.SOUTH);
		
		return chatPanel;
	}
	
	/**
	 * Method that creates the title block.
	 * 
	 * @return JPanel with the title on the panel
	 */
	private JPanel titlePanel()
	{
		JPanel titlePanel = new JPanel();
		
		JLabel titleL = new JLabel("Battleship");
		titleL.setForeground(new Color(123, 145, 67));
		titleL.setFont(new Font("TimesRoman",Font.BOLD,24));
		
		titlePanel.add(titleL);
		
		return titlePanel;
	}
	
	/*
	 * Places the grid boards.
	 */
	private JPanel whoseBoard()
	{
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(new JLabel(players[you].getUser()+"'s Board",SwingConstants.LEFT),BorderLayout.WEST);
		panel.add(new JLabel(players[enemy].getUser()+"'s Board",SwingConstants.RIGHT),BorderLayout.EAST);
		return panel;
	}
	
	/**
	 * Method that creates the game grid. 
	 * This grid does nothing, the entire 
	 * purpose was for spacing during the original layout.
	 * 
	 * @returns JPanel was right size grid.
	 */
//	private JPanel gridPanel()
//	{
//		JPanel gridPanel = new JPanel(new GridLayout(11,11));
//		
//		for(int i = 0; i < GRIDSIZE; i++)
//		{
//			for(int j = 0; j < GRIDSIZE; j++)
//			{
//				if (i == 0 && j == 0)
//				{
//					gridPanel.add(new JButton());
//				}
//				else if (i == 0)
//				{
//					gridPanel.add(new JButton(""+j));
//				}
//				else if (j == 0 && i ==1)
//				{
//					gridPanel.add(new JButton("a"));
//				}
//				else if (j == 0 && i ==2)
//				{
//					gridPanel.add(new JButton("b"));
//				}
//				else if (j == 0 && i ==3)
//				{
//					gridPanel.add(new JButton("c"));
//				}
//				else if (j == 0 && i ==4)
//				{
//					gridPanel.add(new JButton("d"));
//				}
//				else if (j == 0 && i == 5)
//				{
//					gridPanel.add(new JButton("e"));
//				}
//				else if (j == 0 && i == 6)
//				{
//					gridPanel.add(new JButton("f"));
//				}
//				else if (j == 0 && i == 7)
//				{
//					gridPanel.add(new JButton("g"));
//				}
//				else if (j == 0 && i == 8)
//				{
//					gridPanel.add(new JButton("h"));
//				}
//				else if (j == 0 && i == 9)
//				{
//					gridPanel.add(new JButton("i"));
//				}
//				else if (j == 0 && i == 10)
//				{
//					gridPanel.add(new JButton("j"));
//				}
//				else if (j == 0 && i == 11)
//				{
//					gridPanel.add(new JButton("k"));
//				}
//				else
//				{
//					gridPanel.add(new JButton());
//				}
//			}
//		}
//		
//		return gridPanel;
//	}
	
	public JMenuBar createMenuBar()
	{
		JMenu menu;//menu
      
		// create the menu bar
		JMenuBar menuBar = new JMenuBar();

		// build the Game menu
		menu = new JMenu("Game");
		menuBar.add(menu);
		m = new JMenu("New Game");		
		menu.add(m);
		
		//submenu of New Game
		GameListener stuff = new GameListener();
		pvp = new JMenuItem("Player vs. Player");		
		pvp.addActionListener(stuff);
		m.add(pvp);
		pvc = new JMenuItem("Player vs. Computer");
		pvc.addActionListener(stuff);
		m.add(pvc);
		cvc = new JMenuItem("Computer vs. Computer");
		cvc.addActionListener(stuff);
		m.add(cvc);
		
		m = new JMenuItem("Rules");
		m.addActionListener(new RulesListener());
		menu.add(m);
		m = new JMenuItem("Statistics");
		m.addActionListener(new StatsListener());		
		menu.add(m);
		m = new JMenuItem("Options");
		m.addActionListener(new OptionsListener());		
		menu.add(m);
		m = new JMenuItem("Exit");
		m.addActionListener(new ExitListener());
		menu.add(m);	
		return menuBar;
	}
	
	/************************************Generated methods and listeners****************************************/

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == connectButton)
		{
			System.out.println("The connect button works!");
			
			try
			{
				String ipAddress = JOptionPane.showInputDialog("Enter IP: ");
				socket = new Socket(ipAddress,4444);
				
				// Output Stream to write information to the date server		
				OutputStream os = socket.getOutputStream();
				oos = new ObjectOutputStream(os);
				
				//start listener thread
				listener = new InputListener(socket, Battleship.this);
				Thread t1 = new Thread(listener);
				t1.start();
			}
			catch(ConnectException ce)
			{
				System.out.println("Could not get a connection with server");
			}
			catch(IOException ioe)
			{
				System.out.println("Could not read or write message to/from server");
			}
		}
		
		if(ae.getSource() == sendB)
		{
			System.out.println("The send button works!");
			
			try
			{
				Message m = new Message(userName,chatTF.getText(),
							new Date());
				//Output Stream to write information to the date server put in connect
				//OutputStream os = socket.getOutputStream(); 
				//oos = new ObjectOutputStream(os); //put in connect

				oos.writeObject(m);	
				chatTF.setText("");
			}
			catch(IOException ioe)
			{
				System.out.println("Could not read or write message to/from server");
			}
		}
		
		if(ae.getSource() == disConnectButton)
		{
			System.out.println("The disconnect button works!");
			
			try
			{
				oos.close();
				socket.close();
				listener = null;
			}
			catch(IOException ioe)
			{
				System.out.println("Could not close socket");
			}
		}
	}

	/*
	 * Method that places the ships on the grid
	 */
	private class ShipsListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{				
			sindex=cshi.getSelectedIndex();
			if (players[you].getBoats(sindex)!=null)
				cdir.setSelectedIndex(players[you].getBoats(sindex).getDirect());
			switch (sindex)
			{
				case 0:		length=5;
				break;
				case 1:		length=4;
				break;
				case 2:		length=3;	
				break;
				case 3:		length=3;
				break;
				case 4:		length=2;
				break;							
			}
			if (players[you].getBoats(sindex) != null)
			{
				Ship boat=new Ship(ships[sindex],players[you].getBoats(sindex).getDirect()
				,length,players[you].getBoats(sindex).getX(),players[you].getBoats(sindex).getY());		
				players[you].getBoats(sindex).clearship();
				players[you].setBoats(sindex,boat);
				players[you].getBoats(sindex).placeship();			
			}							
		}
	}
	
	/*
	 * Changes the direction the ship is being placed on the board	
	 */
	private class DirectListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{						
			dindex = cdir.getSelectedIndex();					
			if (players[you].getBoats(sindex) != null)
			{
				Ship boat=new Ship(ships[sindex],dindex,players[you].getBoats(sindex).getLength(),
			   	players[you].getBoats(sindex).getX(),players[you].getBoats(sindex).getY());		   
				players[you].getBoats(sindex).clearship();
				players[you].setBoats(sindex,boat);
				players[you].getBoats(sindex).placeship();		   
			}						
		}
	}				
	
	/*
	 * Changes the colour on the grid for boats	
	 */
	private class BoardListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{				
			if (ready==0)
			{
				if (players[you].getBoats(sindex)!=null)
					players[you].getBoats(sindex).clearship();
				Object source = v.getSource();
				outer:						
				for (i=0;i<10;i++)
				{				
					for (j=0;j<10;j++)
					{
						if (source==players[you].getBboard(i,j))
						{						
							switch (sindex)
							{
								case 0:	{											
											if (carrierCheck==0)
												carrierCheck++;														
										}
								break;						
								case 1:	{											
											if (battleShipCheck==0)
												battleShipCheck++;														
										}
								break;
								case 2:	{								
											if (submarineCheck==0)								
												submarineCheck++;
										}
								break;
								case 3:	{									
											if (destroyCheck==0)
												destroyCheck++;													
										}
							break;
							case 4:	{								
										if (patrolBoatCheck==0)
											patrolBoatCheck++;															
									}
							break;							
						}	
						players[you].setBoats(sindex,new Ship(ships[sindex],dindex,length,i,j));																									
						break outer;						
					}					
				}
			}			
			players[you].getBoats(sindex).placeship();
			}						
		}
    }
	
	//Listener for exit choice on Game menu	
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int r= JOptionPane.showConfirmDialog(null,"Are you sure you would l"
			+"ike to exit Battleship?", "Exit?", JOptionPane.YES_NO_OPTION);
			if (r==0)
				System.exit(0);	
		}	
	}

	//listener for New Game submenu		
	private class GameListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{	
			int q= JOptionPane.showConfirmDialog(null,"Are you sure you would l"
			+"ike to start a new game?", "New Game?", JOptionPane.YES_NO_OPTION);
			if (q==0)
			{					
				//resets variables
				b.removeAll();
				c.removeAll();
				d.removeAll();				
				you=0;
				enemy=1;
				ready=0;
				
				if (players[you].getTimer()!=null)
					if (players[you].getTimer().isRunning())
						players[you].getTimer().stop();
				if (players[enemy].getTimer()!=null)
					if (players[enemy].getTimer().isRunning())
						players[enemy].getTimer().stop();									
				
				gametype = e.getSource();			
			
				if (gametype==pvp)
				{
					if (!selectedValue.equals("no server"))
					{
						String[] possibleValues = { "Local", "Online"};
						selectedValue = JOptionPane.showInputDialog(null, 
						"Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null,
						possibleValues, possibleValues[0]);
					}
					if (!players[you].getUser().equals("CPU1"))
					{
						if (players[you].getUser().equals("Stupid"))
						{
							int w=JOptionPane.showConfirmDialog(null,"Would you"
							+" like to try inputting your name again?","",
							JOptionPane.YES_NO_OPTION);
							if (w==JOptionPane.YES_OPTION)
							{	
								user=JOptionPane.showInputDialog("Enter your name.");
								int dummy=0;
								while (((user==null)||(user.equals("")))&&(dummy<3))
								{				
									user=JOptionPane.showInputDialog("You have to input something.");
									if ((user!=null)&&(!user.equals("")))
										dummy=4;
									else
										dummy++;
								}
								if (dummy==3)
								{
									JOptionPane.showMessageDialog(null,"Still a"
									+"cting stupid.  Oh well, we'll run with it."
									,"",JOptionPane.INFORMATION_MESSAGE);
									user="Stupid";
								}
								else
									JOptionPane.showMessageDialog(null,"That wasn't"
									+" so hard now, was it?","YEAH!",
									JOptionPane.INFORMATION_MESSAGE);									
							}							
						}
						players[you]=new Player (players[you].getUser());
					}
					else									
						players[you]=new Player (user);								
					if (selectedValue.equals("Online"))
					{
						players[enemy]=new Player ("Unknown");
						if (!isAutoSet())
						{
							b.add(setBoard(you),BorderLayout.CENTER);							
							deploy.setEnabled(false);
							d.add(inputpanel,BorderLayout.NORTH);					
						}
						else
						{
							b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
							c.add(autoBoard(enemy,you),BorderLayout.EAST);
							ready=1;																
						}					
					}
					else
					{
						//gets user to input name
						if((players[enemy].getUser().equals("Computer"))||(players[enemy].getUser().equals("CPU2"))||(players[enemy].getUser().equals("Unknown")))
						{							
							user2=JOptionPane.showInputDialog("Enter your name.");					
							while ((user2==null)||(user2.equals("")))
							{				
								user2=JOptionPane.showInputDialog("You have to input something.");							
							}						
						}
						else
							user2=players[enemy].getUser();
						players[enemy]=new Player (user2);	
						b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
						c.add(autoBoard(enemy,you),BorderLayout.EAST);
						d.add(whoseBoard(),BorderLayout.NORTH);						
						whoGoesFirst();
						ready=1;
					}
					//ready=1;
				}
				else if (gametype==pvc)//Player vs Computer
				{						
					if (!players[you].getUser().equals("CPU1"))
					{
						if (players[you].getUser().equals("Stupid"))
						{
							int w=JOptionPane.showConfirmDialog(null,"Would you"
							+" like to try inputting your name again?","",
							JOptionPane.YES_NO_OPTION);
							if (w==JOptionPane.YES_OPTION)
							{	
								user=JOptionPane.showInputDialog("Enter your name.");
								int dummy=0;
								while (((user==null)||(user.equals("")))&&(dummy<3))
								{				
									user=JOptionPane.showInputDialog("You have to input something.");
									if ((user!=null)&&(!user.equals("")))
										dummy=4;
									else
										dummy++;
								}
								if (dummy==3)
								{
									JOptionPane.showMessageDialog(null,"Still a"
									+"cting stupid.  Oh well, we'll run with it."
									,"",JOptionPane.INFORMATION_MESSAGE);
									user="Stupid";
								}
								else
									JOptionPane.showMessageDialog(null,"That wasn't"
									+" so hard now, was it?","YEAH!",
									JOptionPane.INFORMATION_MESSAGE);									
							}							
						}
						players[you]=new Player (players[you].getUser());
					}
					else									
						players[you]=new Player (user);								
					players[enemy]=new Player ("Computer");			
					if (!isAutoSet())
					{
						b.add(setBoard(you),BorderLayout.CENTER);							
						deploy.setEnabled(false);
						d.add(inputpanel,BorderLayout.NORTH);					
					}
					else
					{
						b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
						c.add(autoBoard(enemy,you),BorderLayout.EAST);
						whoGoesFirst();	
					}
				}
				else if (gametype==cvc)//Computer vs Computer
				{										
					mbar.setText("Battleship Demo");					
					mbar.setEditable(false);					
					d.add(mbar,BorderLayout.NORTH);
					players[you]=new Player ("CPU1");
					players[enemy]=new Player ("CPU2");					
					b.add(autoBoard(you,enemy),BorderLayout.WEST);																				
					c.add(autoBoard(enemy,you),BorderLayout.EAST);					
					whoGoesFirst();		
				}				
			}									
		}	
	}
	
	//Listener for Stats menu
	private class StatsListener implements ActionListener
	{	
		//
		public void setup()
		{			
			stats=new JPanel();
			ok.addActionListener(new OkListener());		
			statistics.setSize(300,300);
			statistics.setResizable(false);		
			statistics.getContentPane().add(ok,BorderLayout.SOUTH);		
		}	
		
		public void actionPerformed(ActionEvent e)
		{				
			if (data==null)
				setup();
			else
				stats.removeAll();
			stats.setLayout(new GridLayout(6,3));					
			data=new JLabel("");
			stats.add(data);
			data=new JLabel("Player 1",SwingConstants.CENTER);
			stats.add(data);
			data=new JLabel("Player 2",SwingConstants.CENTER);
			stats.add(data);				
			data=new JLabel("Names");
			stats.add(data);
			if (you == 0)
			{								
				data=new JLabel(players[you].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[enemy].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Shots Taken");
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Hits");
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Shot Accuracy");
				stats.add(data);
				data=new JLabel(players[you].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[enemy].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Ships Left");
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
			}		
			else 
			{					
				data=new JLabel(players[enemy].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[you].getUser(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Shots Taken");
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShots()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Hits");
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getHits()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Shot Accuracy");
				stats.add(data);
				data=new JLabel(players[enemy].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(players[you].getAcc(),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel("Ships Left");
				stats.add(data);
				data=new JLabel(Integer.toString(players[enemy].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
				data=new JLabel(Integer.toString(players[you].getShipsLeft()),SwingConstants.CENTER);
				stats.add(data);
			}
			statistics.getContentPane().add(stats);			
			statistics.pack();
			statistics.setVisible(true);			
		}	
	}
	
	//Listener for ok button in statistics menu
	private class OkListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{	
			statistics.dispose();
		}	
	}
	
	//Listener for Rules menu
	private class RulesListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{	
			
		}	
	}
	
	//Listener for Deploy Button 
	private class DeployListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent v)
		{	
			int r= JOptionPane.showConfirmDialog(null,"Are you sure you would l"
			+"ike to deploy your ships?", "Deploy Ships?", 
			JOptionPane.YES_NO_OPTION);
			if (r==0)
			{	
				carrierCheck=0;
				battleShipCheck=0;
				submarineCheck=0;
				destroyCheck=0;
				patrolBoatCheck=0;									
				d.remove(input);						
				b.add(players[you].getMyBoard());
				ready=1;	
				c.add(autoBoard(enemy,you),BorderLayout.EAST);													
				d.add(new JPanel(),BorderLayout.CENTER);
				if (!selectedValue.equals("Online"))
					whoGoesFirst();									
			}
		}	
	}
	
	//Listener for Options menu
	public class OptionsListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{		
			if (opts==null)
				setup();
			else
				options.setVisible(true);					
		}		
		
		public void setup()
		{			
			opts=new JPanel(new GridLayout(4,2));
			title=new JLabel("Computer AI");
			opts.add(title);			
			aiLevel.setSelectedIndex(0);			
			opts.add(aiLevel);
			title=new JLabel("Ship Layout");
			opts.add(title);			
			shipLayout.setSelectedIndex(0);			
			opts.add(shipLayout);
			title=new JLabel("Ship Color");
			opts.add(title);				
			shipColor.addActionListener(new SColorListener());
			shipColor.setSelectedIndex(0);	
			opts.add(shipColor);
			title=new JLabel("Who Plays First?");
			opts.add(title);			
			playsFirst.setSelectedIndex(0);			
			opts.add(playsFirst);		
			options.getContentPane().add(opts,BorderLayout.CENTER);
			//options.setSize(600,800);
			options.setResizable(false);
			done.addActionListener(new DoneListener());		
			options.getContentPane().add(done,BorderLayout.SOUTH);
			options.setLocation(200,200);
			options.pack();
			options.setVisible(true);		
		}
		
		//Listener for the Colors combo box		
		private class SColorListener implements ActionListener
		{	
			public void actionPerformed(ActionEvent v)
			{	
				for (i=0;i<10;i++)
					for (j=0;j<10;j++)
					{
						if (players[you].getBboard(i,j).getBackground()==color[prevcolor])
							players[you].setBboard(i,j,color[shipColor.getSelectedIndex()]);				
						if (players[enemy].getBboard(i,j).getBackground()
							==color[prevcolor])
							players[enemy].setBboard(i,j,color[shipColor.getSelectedIndex()]);		
					}
				prevcolor=shipColor.getSelectedIndex();	
			}
		}	
		
		//Listener for ok button in statistics menu
		private class DoneListener implements ActionListener
		{	
			public void actionPerformed(ActionEvent e)
			{	
				if ((shipLayout.getSelectedIndex()!=prevLayout)||
					(aiLevel.getSelectedIndex()!=prevLevel)||
					(playsFirst.getSelectedIndex()!=prevFirst))
				{
					JOptionPane.showMessageDialog(null,"Changes will take"+
					" place at the start of a new game.",""
					,JOptionPane.PLAIN_MESSAGE);
					if (shipLayout.getSelectedIndex()!=prevLayout)
						prevLayout=shipLayout.getSelectedIndex();
					if (playsFirst.getSelectedIndex()!=prevFirst)
						prevFirst=playsFirst.getSelectedIndex();
					if (aiLevel.getSelectedIndex()!=prevLevel)
						prevLevel=aiLevel.getSelectedIndex();
				}
				options.dispose();
			}	
		}	
	}
	
	@Override
	public void update(Observable obs, Object o)
	{
		//InputListener lis = (InputListener)o;
		Message m  = (Message)o;
		
		String message = "From "+m.getUser()+": "+m.getMsg()+
						" ("+m.getTimeStamp()+")";
		chatDisplay.append(message+"\n");
	}
	
	/**********************************Getters and Setters****************************************/
	
	/**
	 * Method changes the colour of the ship depending on hit/miss/placement etc...
	 * 
	 * @return ship color
	 */
	public static Color getColor()
	{			
		return (color[shipColor.getSelectedIndex()]);	
	}
	
	public static boolean isGameover()
	{
		return gameover;
	}

	public static void setGameover(boolean gameover)
	{
		Battleship.gameover = gameover;
	}
	
	public static int getCarrierCheck()
	{
		return carrierCheck;	
	}
	
	public static int getBattleShipCheck()
	{
		return battleShipCheck;	
	}
	
	public static int getSubmarinceCheck()
	{
		return submarineCheck;	
	}
	
	public static int getDestroyerCheck()
	{
		return destroyCheck;	
	}
	
	public static int getPatrolBoatCheck()
	{
		return patrolBoatCheck;	
	}		
	
	public static int getReady()
	{
		return ready;	
	}
	
	public static JFrame getStatistics()
	{
		return statistics;	
	}
	
	public static void setData(JLabel x)
	{
		data=x;	
	}
	
	public static JLabel getData()
	{
		return data;	
	}
	
	public static JPanel getStats()
	{
		return stats;	
	}	
	
	public static void setDeploy(boolean k)
	{
		deploy.setEnabled(k);	
	}	
	
	public static Player getPlayers(int x)
	{
		return players[x];	
	}
	
	public static String getDirection(int i)
	{
		return direction[i];	
	}
	
	public static String getCletters(int i)
	{
		return cletters[i];	
	}	
	
	public static String getShips(int i)
	{
		return ships[i];	
	}
	
	public static String getCnumbers(int i)
	{
		return cnumbers[i];	
	}	
	
	public static int getSIndex()
	{
		return sindex;	
	}
	
	public static int getDIndex()
	{
		return dindex;	
	}	
	
	public static int getYou()
	{
		return you;	
	}
	
	public static int getEnemy()
	{
		return enemy;	
	}	
	
	public static void setYou(int x)
	{
		you=x;	
	}
	
	public static void setEnemy(int x)
	{
		enemy=x;	
	}
	/****************************************Main***************************************************/
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Battleship gui= new Battleship();
		
		while (gui.isActive())
		{
			while (selectedValue.equals(" "))
			{	
				
			}
			System.out.println("Object = " + selectedValue);
			if (selectedValue.equals("Online"))
			{	
				selectedValue = " ";
				while (ready != 1)
				{ }			
				
				try
				{
					me = new BSClient();
					if (!me.getServerName().equals("invalid"))
					{
						me.sendShips();
						while (!gameover)
						{
							if (!players[you].getMove())	
							{
								try
								{
									me.listen();							
								}
								catch (IOException e){ System.out.println("Aw naw."); }					
							}
							while (players[you].getMove())
								{ }
							me.results();
						}								
					}
					else
					{
						b.removeAll();
						c.removeAll();
						d.removeAll();
						players[you]=new Player (user);
						players[enemy]=new Player ("Computer");					
						b.add(gui.setBoard(you),BorderLayout.CENTER);					
						inputpanel=gui.shipinput();
						d.add(inputpanel,BorderLayout.NORTH);
					}					
				}					
				catch (IOException e)
				{ 
					e.printStackTrace(); 
				}
			}			
		}		
	}
}
