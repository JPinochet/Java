import java.sql.*;
/**
* DepartmentBroker.java - class to generate results related
* to an employee's department.
*/

public class DepartmentBroker extends RelationBroker
{
	// ATTRIBUTES
	private static DepartmentBroker dBroker; 
	
	// Constructor
	private DepartmentBroker()
	{
	}
	
	public static DepartmentBroker getDepartmentBroker()
	{
		if(dBroker == null)
		{
			dBroker = new DepartmentBroker();
		}
		return dBroker;
	}
	
	public Department getNext(ResultSet depts) throws SQLException
	{
		return new Department(depts.getInt("deptno"),
									depts.getString("dname"));
	}
	
	public Department getDepartment(int id) throws SQLException
	{
		String query = "SELECT deptno, dname FROM dept WHERE deptno = "
							+id;
		ResultSet depts = dBroker.getResults(query);
		depts.next();
		return new Department(depts.getInt("deptno"),
								depts.getString("dname"));
	}
}
