package testBroker;

import java.sql.*;
import brokerExample.*;

/**
* Driver class to connect to an Oracle database.
*/

public class TestOracle
{
	public static void main(String [] args)
	{
		Employee emp = new Employee();
		Department dept = new Department();
		DepartmentBroker dBroker = DepartmentBroker.getDepartmentBroker();
		EmployeeBroker eBroker = EmployeeBroker.getEmployeeBroker();
		
		eBroker.connect("oracle.jdbc.driver.OracleDriver",
						"jdbc:oracle:thin:@localhost",
						"javaexample", "password");
						
		dBroker.connect("oracle.jdbc.driver.OracleDriver",
						"jdbc:oracle:thin:@localhost",
						"javaexample", "password");
						
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
