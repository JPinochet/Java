/**
 * 
 */
package echoClientSocketDemo;

import java.awt.HeadlessException;
import java.io.*;
import java.net.*;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * @author 432873
 *
 */
public class Message implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 414789592093193050L;
	private String 			userName;
	private String			message;
	private Date 			Date;
	
	
	
	public String getUserName()
	{
		return userName;
	}



	public void setUserName(String userName)
	{
		this.userName = userName;
	}



	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	public Date getDate()
	{
		return Date;
	}



	public void setDate(Date date)
	{
		Date = date;
	}



	public Message()
	{
		
	}
	
	public Message(String incUserName, String incMessage)
	{
		incUserName = userName;
		incMessage = message;
		
		
	}
	
	public String toString()
	{
		return message + userName + Date;
		
	}
	
	/*****************************Main************************************************/
	
	public static void main(String[] args)
	{
		try
		{
			Socket s1 = new Socket("10.160.8.19", 3542); // sends request to the server to see if it's there
			
			String tempUserName = JOptionPane.showInputDialog("Enter Username: ");
			String tempMessage = JOptionPane.showInputDialog("Enter message: ");
			
			new Message(tempUserName, tempMessage);
			
			OutputStream io = s1.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(io);
			oos.writeUTF(tempUserName);
			oos.writeUTF(tempMessage);
			oos.writeUTF("September 18, 2009");
			
			InputStream is = s1.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			JOptionPane.showMessageDialog(null, ois.readUTF());
			
			s1.close();
			oos.close();
			ois.close();
			
		}
		catch (HeadlessException e)
		{
			e.printStackTrace();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
}
