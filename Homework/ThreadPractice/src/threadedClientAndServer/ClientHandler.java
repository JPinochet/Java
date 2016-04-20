package threadedClientAndServer;
import java.net.*;
import java.io.*;

public class ClientHandler extends Thread
{
	//Attributes
	@SuppressWarnings("unused")
	private Socket				cs;
	private DataInputStream  	dis;
	private DataOutputStream	dos;
	private InetAddress			netAdd;
	
	//Constructor
	public ClientHandler(Socket cs)
	{
		this.cs = cs;
		netAdd = cs.getInetAddress();
		
		try
		{
			dis = new DataInputStream(cs.getInputStream());
			dos = new DataOutputStream(cs.getOutputStream());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//Operational Methods
	public void run()
	{
		String msg = "";
		
		while(true)
		{
			try
			{
				msg = dis.readUTF();
				System.out.println("Message: "+msg+" received from "+netAdd);
				dos.writeUTF("Returned message from server: "+msg);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
