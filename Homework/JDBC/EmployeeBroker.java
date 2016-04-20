import java.sql.*;
/**
* EmployeeBroker.java - class to print results related
* to an employee.
*/

public class EmployeeBroker extends RelationBroker
{
	// ATTRIBUTES
	private DepartmentBroker dBroker = 
					DepartmentBroker.getDepartmentBroker();
	private static EmployeeBroker eBroker = null;
	
	// Constructor
	private EmployeeBroker()
	{
	}
	
	public static EmployeeBroker getEmployeeBroker()
	{
		if(eBroker == null)
		{
			eBroker = new EmployeeBroker();
		}
		return eBroker;
	}
	
	public Employee getNext(ResultSet emps) throws SQLException
	{
		return new Employee(emps.getInt("empno"),
							emps.getString("ename"),
							emps.getString("job"),
							emps.getDouble("sal"),
							dBroker.getDepartment(emps.getInt("deptno")));
	}
}
