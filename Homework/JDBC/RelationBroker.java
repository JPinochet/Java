import java.sql.*;
/**
* RelationBroker.java - a class to establish the connection
* to the database given the connection informtion
*/

public class RelationBroker
{
	//ATTRIBUTES
	private Connection con = null;
	
	public void connect(String driver, String URL)
	{
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(URL);
		}
		catch(ClassNotFoundException cExp)
		{
			System.out.println("Unable to find Driver");
			System.exit(-1);
		}
		catch(SQLException sExp)
		{
			System.out.println("Problem opening Table "+
						sExp.getMessage());
			System.exit(-1);
		}
	}
	
	public void connect(String driver, String URL,
						String user, String pass)
	{
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(URL, user, pass);
		}
		catch(ClassNotFoundException cExp)
		{
			System.out.println("Unable to find Driver");
			System.exit(-1);
		}
		catch(SQLException sExp)
		{
			System.out.println("Problem opening Table "+
						sExp.getMessage());
			System.exit(-1);
		}
	}
	
	public ResultSet getResults(String query)
	{
		Statement statement = null;
		ResultSet results = null;
		
		try
		{
			statement = con.createStatement();
			results = statement.executeQuery(query);
		}
		catch(SQLException se)
		{
			System.out.println("sql error = "+se.getMessage());
			se.printStackTrace();
		}
		return results;
	}
	
	public void closeConnection()
	{
		try
		{
			con.close();
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
}
