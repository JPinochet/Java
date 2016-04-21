<<<<<<< HEAD
/**
 * 
 */
package serverSide;

import java.io.IOException;

/**
 * @author 432873
 *
 */
public class ServerRunner
{

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		Server chatServer = new Server();
		chatServer.main(args);
		
		BSServer bsServer = new BSServer();
		try
		{
			bsServer.main(args);
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

/**
 * @author 432873
 *
 */
public class ServerRunner
{

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		Server chatServer = new Server();
		chatServer.main(args);
		
		BSServer bsServer = new BSServer();
		try
		{
			bsServer.main(args);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
>>>>>>> origin/master
