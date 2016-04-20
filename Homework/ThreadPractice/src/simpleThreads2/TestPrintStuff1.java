package simpleThreads2;
public class TestPrintStuff1
{
	public static void main(String[] args)
	{
		PrintStuff1 ps1  = new PrintStuff1("Thread One");
		ps1.start();
		
		PrintStuff1 ps2  = new PrintStuff1("Thread Two");
		ps2.start();
		
		PrintStuff1 ps3  = new PrintStuff1("Thread Three");
		ps3.start();
		
		PrintStuff1 ps4  = new PrintStuff1("Thread Four");
		ps4.start();

	}

}
