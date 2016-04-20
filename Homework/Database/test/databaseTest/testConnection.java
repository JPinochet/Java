/**
 * Mar 24, 2009
 */
package databaseTest;

import java.sql.*;
import oracle.sql.*;
import oracle.jdbc.driver.*;

/**
 * @author 432873
 *
 */
public class testConnection
{

	/**
	 * 
	 * @param args
	 */

	//Attributes
	public static Connection conn;
	public static Statement stmt;
	public ResultSet rSet;
	public static String user = "odss2";
	public static String pass = "password";
	
	
	public static void main(String[] args)
	{
		
		
		try
		{
			if(makeConn("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost", user,pass))
			{
				System.out.println("Connection made.");
			}
			else
			{
				System.out.println("Failure to connect - disconnecting");
				System.exit(1);
			}
		}
		catch (Exception selE)
		{
					System.out.println("Failed connection");
		}
	}
	
	public static boolean makeConn(String driver, String URL, String user, String pass)
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			return true;
		} 
		catch (ClassNotFoundException cExp)
		{
			System.out.println("Unable to find class for driver"+cExp.getMessage());
			cExp.printStackTrace();
			return false;
		} 
		catch (SQLException sExp)
		{
			System.out.println("Problem making connection: "+sExp.getMessage());
			sExp.printStackTrace();
			return false;
		}
	}
	
	public void disconnect() throws Exception
	{
		conn.close();
	}

}
