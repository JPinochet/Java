package threadedClientAndServer;
import java.net.*;
import java.io.*;

public class Client
{
	public static void main(String[] args)
	{
		try
		{
			Socket cs = new Socket("10.163.84.31",3535);
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
			
			BufferedReader  ki = new BufferedReader(
					new InputStreamReader(System.in));
			
			System.out.print("Enter message to be echoed:> ");
			String msg = ki.readLine();
			
			while(!msg.equals("done"))
			{
				dos.writeUTF(msg);
				String svrMsg = dis.readUTF();
				System.out.println("Echoed from server: "+svrMsg);
				
				System.out.print("\n\nEnter message to be echoed:> ");
				msg = ki.readLine();
			}
			cs.close();
			dis.close();
			dos.close();
			ki.close();
		}
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
