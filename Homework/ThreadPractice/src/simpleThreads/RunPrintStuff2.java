/**
 * 
 */
package simpleThreads;

/**
 * @author 432873
 *
 */
public class RunPrintStuff2
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		PrintStuff2 ps = new PrintStuff2("Thread One");
		Thread t1 = new Thread(ps);
		t1.start();
		
		PrintStuff2 ps2 = new PrintStuff2("Thread Two");
		Thread t2 = new Thread(ps2);
		t2.start();
		
		PrintStuff2 ps3 = new PrintStuff2("Thread Three");
		Thread t3 = new Thread(ps3);
		t3.start();
		
		PrintStuff2 ps4 = new PrintStuff2("Thread Four");
		Thread t4 = new Thread(ps4);
		t4.start();
		
		while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive());
		{
			System.out.println("All threads are completed");
		}
	}

}
