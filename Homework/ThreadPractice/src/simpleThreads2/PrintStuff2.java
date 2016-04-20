package simpleThreads2;
public class PrintStuff2 implements Runnable
{
	//Attributes
	private String 		s;

	//Constructor
	public PrintStuff2(String s)
	{
		this.s = s;
	}
	
	//Operational Methods
	public void run()
	{
		for(int i = 0; i < 30; i++)
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
