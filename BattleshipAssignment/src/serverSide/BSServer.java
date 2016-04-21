<<<<<<< HEAD
package serverSide;


import java.net.*;
import java.io.*;
import java.util.Vector;
import clientSide.*;

public class BSServer
{	
	private static BSProtocol battleShipProtocol;
	private static Socket sockets = null;
		
	public static void main(String[] args) throws IOException 
	{
		boolean gameover = false;
        int numOPlayers = 0; //LOCAL variable keeps tracks of number of players connected to battleship server / separate from chat server
		ServerSocket serverSocket = null;	
		Vector<BSThread> threads = new Vector<BSThread>();		
	   
	   	try 
	   	{
            serverSocket = new ServerSocket(4443);
        } 
		catch (IOException e) 
		{
            System.err.println("Could not listen on port: 4443.");
            System.exit(1);
        }     
		while (numOPlayers != 2)
		{
			if (numOPlayers == 0)
			{
				sockets = serverSocket.accept();				
				threads.add(new BSThread(sockets));
				System.out.println(numOPlayers);
				((Thread)threads.elementAt(numOPlayers)).start();				
			}
			else
			{
				sockets = serverSocket.accept();				
				threads.add(new BSThread(sockets));
				System.out.println(numOPlayers);
				((Thread)threads.elementAt(numOPlayers)).start();					
			}
			numOPlayers++;			
		}
		((BSThread)threads.elementAt(numOPlayers-2)).sendMessage("opponent");
		((BSThread)threads.elementAt(numOPlayers-2)).sendMessage(((BSThread)threads.elementAt(numOPlayers-1)).getMyName());
		((BSThread)threads.elementAt(numOPlayers-1)).sendMessage("opponent");
		((BSThread)threads.elementAt(numOPlayers-1)).sendMessage(((BSThread)threads.elementAt(numOPlayers-2)).getMyName());
		battleShipProtocol = new BSProtocol(((BSThread)threads.elementAt(numOPlayers-2)), ((BSThread)threads.elementAt(numOPlayers-1)));	
		while (!gameover)
		{
			gameover = battleShipProtocol.play();			
		}			
	 }	 
	 
	public static BSProtocol getProtocol()
	 {
		return battleShipProtocol;	 
	 }
}
=======
package serverSide;


import java.net.*;
import java.io.*;
import java.util.Vector;
import clientSide.*;

public class BSServer
{	
	private static BSProtocol battleShipProtocol;
	private static Socket sockets = null;
		
	public static void main(String[] args) throws IOException 
	{
		boolean gameover = false;
        int numOPlayers = 0; //LOCAL variable keeps tracks of number of players connected to battleship server / separate from chat server
		ServerSocket serverSocket = null;	
		Vector<BSThread> threads = new Vector<BSThread>();		
	   
	   	try 
	   	{
            serverSocket = new ServerSocket(4443);
        } 
		catch (IOException e) 
		{
            System.err.println("Could not listen on port: 4443.");
            System.exit(1);
        }     
		while (numOPlayers != 2)
		{
			if (numOPlayers == 0)
			{
				sockets = serverSocket.accept();				
				threads.add(new BSThread(sockets));
				System.out.println(numOPlayers);
				((Thread)threads.elementAt(numOPlayers)).start();				
			}
			else
			{
				sockets = serverSocket.accept();				
				threads.add(new BSThread(sockets));
				System.out.println(numOPlayers);
				((Thread)threads.elementAt(numOPlayers)).start();					
			}
			numOPlayers++;			
		}
		((BSThread)threads.elementAt(numOPlayers-2)).sendMessage("opponent");
		((BSThread)threads.elementAt(numOPlayers-2)).sendMessage(((BSThread)threads.elementAt(numOPlayers-1)).getMyName());
		((BSThread)threads.elementAt(numOPlayers-1)).sendMessage("opponent");
		((BSThread)threads.elementAt(numOPlayers-1)).sendMessage(((BSThread)threads.elementAt(numOPlayers-2)).getMyName());
		battleShipProtocol = new BSProtocol(((BSThread)threads.elementAt(numOPlayers-2)), ((BSThread)threads.elementAt(numOPlayers-1)));	
		while (!gameover)
		{
			gameover = battleShipProtocol.play();			
		}			
	 }	 
	 
	public static BSProtocol getProtocol()
	 {
		return battleShipProtocol;	 
	 }
}
>>>>>>> origin/master
