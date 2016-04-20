/**
 * Jan 16, 2009
 */
package employeeStuff;
import java.util.*;
import fileHandling.*;

/**
 * @author 432873
 *
 */
public class OfficeManager
{
	//Attributes
	private ArrayList<Employee>		empList; //this is polymorphism
	
	public OfficeManager()
	{
		empList = new ArrayList<Employee>();
		fillArrayListWithEmployees();
	}
	
	public void printEmployeeList()
	{
		Iterator<Employee> it = empList.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	public double calculateAverageEmployeeSalary()
	{
		double sum =0;
		
		for (int i=0; i <empList.size(); i++)
		{
			sum += empList.get(i).calcPay();
		}
		return sum / empList.size();
	}
	
	public Employee findHighestWageEmployee()
	{
		double high=0;
		Employee highest = null;
		
		
		for (int i=0; i <empList.size(); i++)
		{
			if(empList.get(i)instanceof Wage)
			{
				if(empList.get(i).calcPay() > high)
				{
					highest = empList.get(i);
					high = empList.get(i).calcPay();
				}
			}
		}
		return highest;
	}
	/***************************PRIVATE METHODS**********************************************/
	private void fillArrayListWithEmployees()
	{
		FileInput fin = new FileInput("res/employees.txt");
		
		String line = fin.readLine();
		
		while (line != null)
		{
			int firstDigit = Integer.parseInt(line.charAt(0)+"");
			StringTokenizer st = new StringTokenizer(line, ":");
			
			switch(firstDigit)
			{
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
					Employee emp = new Salary(Integer.parseInt(st.nextToken()), 
														   st.nextToken(), 
														   st.nextToken(),
														   st.nextToken(),
														   Long.parseLong(st.nextToken()),
														   st.nextToken(),
														   st.nextToken(),
														   Double.parseDouble(st.nextToken()));
					empList.add(emp);
					break;
					
				case 5:
				case 6:
				case 7:
					 emp = new Wage(Integer.parseInt(st.nextToken()), 
														 st.nextToken(), 
														 st.nextToken(),
														 st.nextToken(),
														 Long.parseLong(st.nextToken()),
														 st.nextToken(),
														 st.nextToken(),
														 Double.parseDouble(st.nextToken()),
														 Double.parseDouble(st.nextToken()));
					empList.add(emp);
					break;
					
				case 8:
				case 9:
					 emp = new PartTime(Integer.parseInt(st.nextToken()), 
														 st.nextToken(), 
														 st.nextToken(),
														 st.nextToken(),
														 Long.parseLong(st.nextToken()),
														 st.nextToken(),
														 st.nextToken(),
														 Double.parseDouble(st.nextToken()),
														 Double.parseDouble(st.nextToken()));
					empList.add(emp);
					break;
				default:
					System.out.println("No such employee type!");
			} //end switch statement
			line = fin.readLine();
		}//end while loop
		
	} //end fillArrayListWithEmployees
}
