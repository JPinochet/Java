<<<<<<< HEAD
/**
 * 
 */
package serverSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author 432873
 *
 */
public class Server
{
	public static void main(String[] args)
	{
		ArrayList<Socket> sockets = new ArrayList<Socket>(5);
		try
		{
			ServerSocket ss = new ServerSocket(4444);
			System.out.println("Server ready for all comers!!!!");
			while(true)
			{
				Socket cs = ss.accept();
				System.out.println("Connection accepted from " + cs.getInetAddress());
				sockets.add(cs);
				
				if(sockets.size() == 2)
				{
					ClientHandler ch = new ClientHandler(sockets.get(0),sockets.get(1));
					ch.start();
					sockets.clear();
				}
				
				System.out.println("Waiting for next client!");
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
=======
/**
 * 
 */
package serverSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author 432873
 *
 */
public class Server
{
	public static void main(String[] args)
	{
		ArrayList<Socket> sockets = new ArrayList<Socket>(5);
		try
		{
			ServerSocket ss = new ServerSocket(4444);
			System.out.println("Server ready for all comers!!!!");
			while(true)
			{
				Socket cs = ss.accept();
				System.out.println("Connection accepted from " + cs.getInetAddress());
				sockets.add(cs);
				
				if(sockets.size() == 2)
				{
					ClientHandler ch = new ClientHandler(sockets.get(0),sockets.get(1));
					ch.start();
					sockets.clear();
				}
				
				System.out.println("Waiting for next client!");
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
>>>>>>> origin/master
