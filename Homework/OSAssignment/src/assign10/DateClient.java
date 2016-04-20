/**
 * Apr 7, 2009
 *
 */
package assign10;

import java.net.*;
import java.io.*;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 * Date Client
 */
public class DateClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			//make connections to server socket
			Socket sock = new Socket("localhost", 6013);
			InputStream in = sock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			
			//read the date from the socket
			String line;
			while((line = bin.readLine()) != null)
			{
				System.out.println(line);
			}
			
			//close the socket connection
			sock.close();
		} 
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		} 
		catch (IOException ioe)
		{
			System.err.println(ioe);
		}
	}

}
