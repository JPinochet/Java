/**
 * 
 */
package serverSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observer;
import java.util.*;
/**
 * @author 432873
 *
 */
public class InputListener extends Observable implements Runnable
{
	private int					listenerNumber;
	private Socket 				socket;
	private ObjectInputStream	ois;

	public InputListener(Socket socket, Observer obs)
	{
		listenerNumber = 0;
		this.socket = socket;
		this.addObserver(obs);
	}
	
	public InputListener(int num, Socket s, Observer obs)
	{
		listenerNumber = num;
		this.socket = s;
		this.addObserver(obs);
	}
	public int getListenerNumber()
	{
		return listenerNumber;
	}
	public void setListenerNumber(int listenerNumber)
	{
		this.listenerNumber = listenerNumber;
	}

	public void run()
	{
		try
		{
			ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("input listener number "+listenerNumber);
			while(true)
			{
				System.out.println("input listener number "+listenerNumber);
				Object o = ois.readObject();
				Message m = (Message)o;
				this.setChanged();
				this.notifyObservers(m);
			}
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
