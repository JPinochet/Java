package snychronizedStackExample;
/*
 * Created on Jul 7, 2004
 */

/**
 * @author dwatson
 * 
 * Class Producer generates characters to be added to the SyncStack.
 */
public class Producer implements Runnable
{
	// Attributes
	private SyncStack  		theStack;
	private int 			number;
	private static int		counter = 1;
	
	/**
	 * @param theStack
	 */
	public Producer(SyncStack theStack)
	{
		this.theStack = theStack;
		this.number = counter++;
	}
	// Constructors
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		char c;
		for(int i = 0; i < 20; i++)
		{
			c = (char)(Math.random() * 26 + 'A');
			theStack.push(c);
			System.out.println("Producer "+number+":  "+c);
			try
			{
				Thread.sleep((int)(Math.random() * 300));
			}
			catch(InterruptedException e)
			{
				//Ignore it...........
			}
		}
	}
}
