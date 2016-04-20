package clientSide;

import java.net.*;
import java.io.*;
import serverSide.*;

public class BSThread extends Thread
{
	//Attributes
    private PrintWriter out;
	private BufferedReader in;
	private String letter,results;
	private String me;
	private String[][] pboard = new String [10][10];
			 
	int x , y; //coordinates
	boolean gameover = false, myturn = false; //keeps track of who's turn it is an if the game is over or not.
	
	/**
	 * Constructor for battleship game thread. Requires a socket.
	 * 
	 * @param socket passes in the Internet connection to start.
	 * @throws IOException input/output handled.
	 */
	public BSThread(Socket socket) throws IOException
	{
		super("BattleshipThread");
		
		this.out = new PrintWriter(socket.getOutputStream(), true);
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		me=in.readLine();
		
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				pboard[i][j] = in.readLine();
				System.out.println(pboard[i][j]);
			}
		}
	}

    public void run()
	{	
		while (!gameover)
		{	
			while (!this.myturn)
			{ }				
			this.out.println("play");
			try
			{				
				while ((letter = in.readLine()) == null)
				{ }
				if (!myturn)
					letter = "wastedturn";
			  	if (!letter.equals("wastedturn"))
				{				  
					x = Integer.parseInt(letter);
					y = Integer.parseInt(in.readLine());
					System.out.println("shot received: " + x + "," + y);
					results = BSServer.getProtocol().results(x, y);
					this.out.println("results");
					System.out.println("results:  "+results);
					this.out.println(results);
					System.out.println("results sent");
				}				 
			}
			catch(IOException e){}			
			myturn = false;			
		}	
	}	
	
	public String[][] sendBoard()
	{
		return pboard;
	}
		
	public void getShot()
	{
		try
			{
				x = Integer.parseInt(in.readLine());
				y = Integer.parseInt(in.readLine());
			}
			catch(IOException e){}
			notifyAll();
			out.println(BSServer.getProtocol().results(x,y));
	}
		
	
	/**
	 * Method that passes the last shot made, however it was not
	 * valid therefore they lost their turn.
	 */
	public void sendResults()  
	{
	  	this.out.println("results");
		out.println("Turn lost");		
	}
	
	/**
	 * Method that passes the last shot made on the board by opposite player.
	 * @param x coordinate of the shot made
	 * @param y coordinate of the shot made
	 */
	public void sendResults(int x, int y)  
	{
		this.out.println("results");
		out.println("Shot at " + x + " " + y);		
	}
		
	/**
	 * Simple getter.
	 * @return me. String variable.
	 */
	public String getMyName()
	{
		return me;	
	}
		
	/**
	 * Method myTurn to true when it is the hosts turn.
	 */
	public void playNow()
	{
		this.myturn = true;	
	}

	/**
	 * Method returns true/false indicating that their turn is over
	 * @return false/true depending on who's turn it is
	 */
	public boolean turnOver()
	{
		return this.myturn;	
	}
	
	/**
	 * Notifies players that their turn is lost
	 */
	public void setTurnOver()
	{
		this.myturn = false;
		out.println("Turn lost.");
	}
	
	/**
	 * Output the message sent 
	 * @param x outputs the message passed into the method
	 */
	public void sendMessage(String x)
	{
		if (x.equals("gameover"))
		  gameover = true;
		out.println(x);	
	}
}
