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
 * 
 * Data Server 
 */
public class DateServer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			ServerSocket sock = new ServerSocket(6013);
			
			// now listen for connections
			while(true)
			{
				Socket client = sock.accept();
				
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				
				//write the Date to the socket
				pout.println(new java.util.Date().toString());
				
				//close the socket and resume
				//listen for connections
				client.close();
			}
		}
		catch (IOException ioe)
		{
			System.err.println(ioe);
		}
	}
}
