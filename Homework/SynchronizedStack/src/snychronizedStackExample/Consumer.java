package snychronizedStackExample;
public class Consumer extends Thread
{
	// Attributes
	private SyncStack  		theStack;
	private int 			number;
	private static int		counter = 1;
	public Consumer(SyncStack theStack, ThreadGroup group)
	{
		super(group, "bob");
		this.theStack = theStack;
		this.number = counter++;
	}
	public void run()
	{
		char c;
		for(int i = 0; i < 20; i++)
		{
			c = theStack.pop();
			System.out.println("Consumer "+number+":  "+c);
			try
			{
				sleep((int)(Math.random() * 300));
			}
			catch(InterruptedException e)
			{
				//Ignore it...........
			}
		}
	}
}
