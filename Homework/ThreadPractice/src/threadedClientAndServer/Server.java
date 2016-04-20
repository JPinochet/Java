package threadedClientAndServer;
import java.net.*;
import java.io.*;

public class Server
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(3245);
			System.out.println("Server running and waiting for connection");
			
			while(true)
			{
				Socket cs  = ss.accept();
				System.out.println("Connection accepted from: "+cs.getInetAddress());
				
				ClientHandler ch = new ClientHandler(cs);
				ch.start();
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
