/**
 * 
 */
package echoDemoObject;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author 432873
 *
 */
public class EchoSeverObj
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ServerSocket server = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Socket c1 = null;
		
		try
		{
			server = new ServerSocket(3333);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		while(true)
		{
			try
			{
				System.out.println("Server up and running!!!!!!!!!!");
				c1 = server.accept();
				System.out.println("Accepted a client connection.");
				
				//Read input from client
				ois = new ObjectInputStream(c1.getInputStream());
				Message msg = (Message)ois.readObject();
				System.out.println(msg);
				
				//Echo message back to client with updated time stamp.
				oos = new ObjectOutputStream(c1.getOutputStream());
				msg.setTimeStamp(new Date());
				oos.writeObject(msg);
				
				ois.close();
				oos.close();
				c1.close();
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
		
	}

}
