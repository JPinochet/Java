<<<<<<< HEAD
/**
 * 
 */
package serverSide;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Observable;
import java.util.*;

/**
 * @author 432873
 *
 */
public class ClientHandler extends Thread implements Observer
{
	private ObjectOutputStream		oos1,oos2;
	private Socket					cs1,cs2;
	private InputListener			lis1,lis2;
	
	public ClientHandler(Socket s1, Socket s2)
	{
		cs1 = s1;
		cs2 = s2;
		try
		{
			oos1 = new ObjectOutputStream(cs1.getOutputStream());
			oos2 = new ObjectOutputStream(cs2.getOutputStream());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Operational Methods
	@Override
	public void update(Observable o, Object arg)
	{
		InputListener listener = (InputListener)o;
		Message m = (Message)arg;
		try
		{
			if(listener.getListenerNumber() == 1)
			{
				oos2.writeObject(m);
			}
			else
			{
				oos1.writeObject(m);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		try
		{
			System.out.println("Chat client handler running with 2 clients");
			
			lis1 = new InputListener(1, cs1, this);
			lis2 = new InputListener(2, cs2, this);
			
			Thread t1 = new Thread(lis1);
			t1.start();
			Thread t2 = new Thread(lis2);
			t2.start();
			
			Message m = new Message("Server",
					"Client1 you can start chatting with Client 2",
					new Date());
			oos1.writeObject(m);
			
			m = new Message("Server",
					"Client2 you can start chatting with Client 1",
					new Date());
			oos2.writeObject(m);
			while(cs1.isConnected() && cs2.isConnected());
			cs1.close();
			cs2.close();
			lis1 = null;
			lis2 = null;
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
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Observable;
import java.util.*;

/**
 * @author 432873
 *
 */
public class ClientHandler extends Thread implements Observer
{
	private ObjectOutputStream		oos1,oos2;
	private Socket					cs1,cs2;
	private InputListener			lis1,lis2;
	
	public ClientHandler(Socket s1, Socket s2)
	{
		cs1 = s1;
		cs2 = s2;
		try
		{
			oos1 = new ObjectOutputStream(cs1.getOutputStream());
			oos2 = new ObjectOutputStream(cs2.getOutputStream());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Operational Methods
	@Override
	public void update(Observable o, Object arg)
	{
		InputListener listener = (InputListener)o;
		Message m = (Message)arg;
		try
		{
			if(listener.getListenerNumber() == 1)
			{
				oos2.writeObject(m);
			}
			else
			{
				oos1.writeObject(m);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		try
		{
			System.out.println("Chat client handler running with 2 clients");
			
			lis1 = new InputListener(1, cs1, this);
			lis2 = new InputListener(2, cs2, this);
			
			Thread t1 = new Thread(lis1);
			t1.start();
			Thread t2 = new Thread(lis2);
			t2.start();
			
			Message m = new Message("Server",
					"Client1 you can start chatting with Client 2",
					new Date());
			oos1.writeObject(m);
			
			m = new Message("Server",
					"Client2 you can start chatting with Client 1",
					new Date());
			oos2.writeObject(m);
			while(cs1.isConnected() && cs2.isConnected());
			cs1.close();
			cs2.close();
			lis1 = null;
			lis2 = null;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
>>>>>>> origin/master
