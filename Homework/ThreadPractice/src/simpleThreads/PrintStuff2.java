/**
 * 
 */
package simpleThreads;

/**
 * @author 432873
 *
 */
public class PrintStuff2 implements Runnable
{
	//Attributes
	private String 		s;

	//Constructors
	public PrintStuff2(String s)
	{
		super();
		this.s = s;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
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
				e.printStackTrace();
			}
		}
	}

}
