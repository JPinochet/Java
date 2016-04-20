package simpleThreads2;

public class TestPrintStuff2
{
	public static void main(String[] args)
	{
		ThreadGroup bob = new ThreadGroup("Bob");
		
		PrintStuff2 ps1  = new PrintStuff2("Thread One");
		Thread t1 = new Thread(bob,ps1);
		t1.start();
		
		PrintStuff2 ps2  = new PrintStuff2("Thread Two");
		Thread t2 = new Thread(bob,ps2);
		t2.start();
		
		PrintStuff2 ps3  = new PrintStuff2("Thread Three");
		Thread t3 = new Thread(bob,ps3);
		t3.start();
		
		PrintStuff2 ps4  = new PrintStuff2("Thread Four");
		Thread t4 = new Thread(bob,ps4);
		t4.start();
		
		while(bob.activeCount() > 1);
		//while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive());
		System.out.println("All threads have died");

	}
}
