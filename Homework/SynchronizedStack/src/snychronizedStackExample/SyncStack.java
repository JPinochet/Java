package snychronizedStackExample;
import java.util.*;
public class SyncStack
{
	// Attributes
	private List<Character> buffer = new ArrayList<Character>();
	
	public List<Character> getBuffer()
	{
		return buffer;
	}
	
	// Operational Methods
	public char pop()
	{
		char c;
		while(buffer.size() == 0)
		{
			try
			{
				this.wait();
			}
			catch(InterruptedException e)
			{
				// Ignore it......
			}
		}
		c = buffer.remove(buffer.size() - 1).charValue();
		return c;
	}
	
	public void push(char c)
	{
		Character charObject = new Character(c);
		buffer.add(charObject);
		this.notify();
	}
}
