import java.sql.*;
/**
* Driver class to connect to an Access database.
* Required to set the DNS in the Windows
* at start-settings-control panel-administrative tools-
* Data Sources(ODBC) select add then select the database
* driver you need i.e. Microsoft access driver
* the give the database a name eg. company.  The description
* is optional then press select button and browse for the
* location of the access database file.
*/

public class TestAccess
{
	public static void main(String [] args)
	{
		Employee emp = new Employee();
		Department dept = new Department();
		DepartmentBroker dBroker = DepartmentBroker.getDepartmentBroker();
		EmployeeBroker eBroker = EmployeeBroker.getEmployeeBroker();
		
		eBroker.connect("sun.jdbc.odbc.JdbcOdbcDriver",
						"jdbc:odbc:company");
						
		dBroker.connect("sun.jdbc.odbc.JdbcOdbcDriver",
						"jdbc:odbc:company");
						
		try
		{
			String query = "SELECT empno, ename, job, sal, deptno FROM emp";
			ResultSet empResults = eBroker.getResults(query);
			while(empResults.next())
			{
				System.out.println(eBroker.getNext(empResults));
			}
		
			String dquery = "SELECT deptno, dname FROM dept";
			ResultSet deptResults = dBroker.getResults(dquery);
			while(deptResults.next())
			{
				System.out.println(dBroker.getNext(deptResults));
			}
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle.getErrorCode());
		}
		dBroker.closeConnection();
		eBroker.closeConnection();
	}
}
