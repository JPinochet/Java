package simpleThreads2;
public class PrintStuff1 extends Thread
{
	//Attributes
	private String 		s;

	//Constructor
	public PrintStuff1(String s)
	{
		super();
		this.s = s;
	}
	
	//Operational Methods
	public void run()
	{
		for(int i = 0; i < 15; i++)
		{
			System.out.println(s);
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				System.out.println(s+"thread interrupted");
			}
		}
	}

}
