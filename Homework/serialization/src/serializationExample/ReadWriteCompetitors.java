/**
 * Mar 19, 2009
 */
package serializationExample;

import java.io.*;
import java.util.*;

/**
 * @author 432873
 *
 */
public class ReadWriteCompetitors
{
	//Attributes
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public void writeCompetitors()
	{
		ArrayList bob = new ArrayList(100000);
		try
		{
			oos = new ObjectOutputStream(new FileOutputStream("res/competitors.ser"));
			//Location loc = new Location("Lindsey Pool","1823 McLeod Trail SW");
			//Event event = new Event("100 meter Free Style", loc);
			//Competitor comp = new Competitor("Jorge the great!", event);
			for(int i =1; i<=100000; i++)
			{
				Location loc = new Location("Lindsey Pool","1823 McLeod Trail SW");
				Event event = new Event("100 meter Free Style", loc);
				Competitor comp = new Competitor(i+"  times! Jorge the great!", event);
				bob.add(comp);
			}
			oos.writeObject(bob);
			oos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void readCompetitors()
	{
		try
		{
			ois = new ObjectInputStream(new FileInputStream("res/competitors.ser"));
			ArrayList ted = (ArrayList)ois.readObject();
			ois.close();
			
			for(int i=0; i<ted.size();i++)
			{
				System.out.println(ted.get(i));
				System.out.println(((Competitor)ted.get(i)).getYob());
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ReadWriteCompetitors rwc = new ReadWriteCompetitors();
		//rwc.writeCompetitors();
		rwc.readCompetitors();
	}

}
