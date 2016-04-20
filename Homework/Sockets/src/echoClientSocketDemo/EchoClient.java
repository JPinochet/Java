/**
 * 
 */
package echoClientSocketDemo;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

/**
 * @author 432873
 *
 */
public class EchoClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Socket s1 =  new Socket("10.160.8.19", 3542); //send request to the server to see if it's there
			
			String text = JOptionPane.showInputDialog("Enter text");
			
			//Create output stream to send information to server.
			OutputStream os = s1.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(text);
			
			//Create an input stream to receive text from server.
			InputStream is = s1.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			JOptionPane.showMessageDialog(null, dis.readUTF());
			
			s1.close();
			dis.close();
			dos.close();
		}
		catch (UnknownHostException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

}
