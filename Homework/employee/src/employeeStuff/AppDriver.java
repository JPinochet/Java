/**
 * January 27, 2009
 * 000432873
 * Jorge Pinochet
 */
package employeeStuff;

public class AppDriver
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		OfficeManager om = new OfficeManager();
		om.printEmployeeList();
		System.out.println("Average wage: "+om.calculateAverageEmployeeSalary());
		System.out.println("Person with highest wage is "+om.findHighestWageEmployee());
		Wage w = (Wage)om.findHighestWageEmployee();
		System.out.println("Name of highest is "+w.getName()+" and they worked "+w.getHours()+" hours.");
	}

}
