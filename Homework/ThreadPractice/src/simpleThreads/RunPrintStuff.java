/**
 * 
 */
package simpleThreads;

/**
 * @author 432873
 *
 */
public class RunPrintStuff
{

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		PrintStuff ps = new PrintStuff("Thread One");
		ps.start();
		
		PrintStuff ps2 = new PrintStuff("Thread Two");
		ps2.start();
		
		PrintStuff ps3 = new PrintStuff("Thread Three");
		ps3.start();
		
		PrintStuff ps4 = new PrintStuff("Thread Four");
		ps4.start();
		
		
		System.out.println(ps.getName());
		System.out.println(ps.getId());
		System.out.println(ps.getState());
		
		while(ps.isAlive() || ps2.isAlive() || ps3.isAlive() || ps4.isAlive());
		{
			System.out.println("All threads are completed");
		}
		
		System.out.println(ps.activeCount());
	}
}
