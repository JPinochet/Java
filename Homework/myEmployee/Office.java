package myEmployee;

import java.util.StringTokenizer;
import fileHandling.*;

public class Office 
{
	//Attributes
	private Employee[] 		empList;
	private int				count;
	
	//Constructor
	
	/**
	 * it does stuff, this is a test
	 * please please make me care a little bit
	 */
	public Office()
	{
		empList = new Employee[10];
	}
	
	//Operational Methods
	/**
	 * filling the employee array, GEEZ is that so hard to figure out?
	 */
	public void fillEmployeeArray()
	{
		FileInput fin = new FileInput("res/employees.txt");
		
		String line = fin.readLine();
		//reads in file till there is nothing else to read! such a moron GOD
		while(line != null)
		{
			//take apart information from the infile the way you want it to
			StringTokenizer st = new StringTokenizer(line,";");
			
			Employee emp = new Employee(st.nextToken(),
										Integer.parseInt(st.nextToken()),
										Double.parseDouble(st.nextToken()),
										Double.parseDouble(st.nextToken()));
			
			empList[count++]=emp;
			
			line = fin.readLine();
		}
		fin.closeInputFile();
	}
	
	public void printEmployees()
	{
		for(int i=0; i<count; i++)
		{
			System.out.println(empList[i]);
		}
	}
}
