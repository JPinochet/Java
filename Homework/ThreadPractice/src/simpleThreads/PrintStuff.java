/**
 * 
 */
package simpleThreads;

/**
 * @author 432873
 *
 */
public class PrintStuff extends Thread
{
	//Attributes
	private String 		s;

	//Constructors
	public PrintStuff(String s)
	{
		super();
		this.s = s;
	}
	
	//Operational Methods
	public void run()
	{
		for(int i = 0; i < 3; i++)
		{
			System.out.println(s);
			
			try
			{
				sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
