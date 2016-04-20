/**
 * 
 */
package echoServerSocketDemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * @author 432873
 *
 */
public class EchoServer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Socket c1 = null;
		
		try
		{
			server = new ServerSocket(3542);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true)
		{
			try
			{
				System.out.println("Server up and running!!!!!!!");
				c1 = server.accept();
				System.out.println("Accepted a client connection.");
				
				//Read input from client
				dis = new DataInputStream(c1.getInputStream());
				String temp = dis.readUTF();
				temp = c1.getInetAddress()+temp;
				System.out.println(temp);
				
				//Echo text back to client.
				dos = new DataOutputStream(c1.getOutputStream());
				dos.writeUTF(temp);
				
				dis.close();
				dos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
				
			}
		}

	}

}
