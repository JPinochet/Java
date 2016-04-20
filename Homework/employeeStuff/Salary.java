/**
 * 
 */
package employeeStuff;

/**
 * @author 432873
 *
 */
public class Salary extends Employee
{
    //Attributes
	private double 				salary;
	
	/**
	 * 
	 */
	public Salary()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param phone
	 * @param socialInsuranceNumber
	 * @param dateOfBirth
	 * @param deptpartment
	 * @param salary
	 */
	public Salary(int id, String name, String address, String phone,
			long socialInsuranceNumber, String dateOfBirth, String deptpartment, double salary)
	{
		super(id, name, address, phone, socialInsuranceNumber, dateOfBirth,
				deptpartment);
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the salary
	 */
	public double getSalary()
	{
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	/* (non-Javadoc)
	 * @see employeeStuff.Employee#calcPay()
	 */
	@Override
	public double calcPay()
	{
		return salary*4;
	}
	
	public String toString()
	{
		return super.toString()+" "+salary;
	}
	
}
