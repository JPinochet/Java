/**
 * 
 */
package myEmployee;

/**
 * @author 432873
 * Jorge Pinochet
 * Created January 7, 09
 * Modified January 8, 09
 */
public class Employee
{
	//Attributes 
	private String	name;
	private int 	age;
	private double 	hours;
	private double 	wage;
	
	/**
	 * 
	 */
	public Employee()
	{
	}

	/**
	 * User defined constructor to et the following class level variables:
	 * @param name the full employee name
	 * @param age the age of the emlpoyee
	 * @param hours the regular hours worked by the employee
	 * @param wage the hourly rate of the paid  to the employee
	 */
	public Employee(String name, int age, double hours, double wage)
	{
		this.name = name;
		this.age = age;
		this.hours = hours;
		this.wage = wage;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	/**
	 * @return the hours
	 */
	public double getHours()
	{
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(double hours)
	{
		this.hours = hours;
	}

	/**
	 * @return the wage
	 */
	public double getWage()
	{
		return wage;
	}

	/**
	 * @param wage the wage to set
	 */
	public void setWage(double wage)
	{
		this.wage = wage;
	}
	
	public String toString()
	{
		return "Name:		"+name+"\n"+
			   "Age:		"+age+"\n"+
			   "Hours worked:		"+hours+"\n"+
			   "Hourly rate:		"+wage+"\n";
	}
	

}
