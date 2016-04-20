/**
 * Jan 30, 2009
 */
package testClientBackendStuff;

import saitMLS.exceptions.*;
import saitMLS.persistance.*;
import saitMLS.problemDomain.*;
import java.util.*;

/**
 * @author 432873
 * Jorge Pinochet
 */
public class TestClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ClientBroker cb = ClientBroker.getBroker();
		
		Client c = new Client("0;Lucky;Duck;76 Duck Pond Lawn;Z5X YF4;403-926-9165;C");
		
		try
		{
			cb.validate(c);
			System.out.println(cb.persist(c));
		} 
		catch (InvalidPostalCodeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InvalidPhoneNumberException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList list = (ArrayList)cb.search("Duck", "name");
		for(int i =0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		cb.closeBroker();
	}

}
