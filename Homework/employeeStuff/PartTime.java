/**
 * Jan 16, 2009
 */
package employeeStuff;

/**
 * @author 432873
 *
 */
public class PartTime extends Employee
{
	//Attributes
	private double		hours;
	private double 		rate;
	
	//Constructors
	/**
	 * 
	 */
	public PartTime()
	{
	}

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param phone
	 * @param socialInsuranceNumber
	 * @param dateOfBirth
	 * @param deptpartment
	 */
	public PartTime(int id, String name, String address, String phone,
			long socialInsuranceNumber, String dateOfBirth, String deptpartment, double hours, double rate)
	{
		super(id, name, address, phone, socialInsuranceNumber, dateOfBirth,
				deptpartment);
		this.hours = hours;
		this.rate = rate;
		// TODO Auto-generated constructor stub
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
	 * @return the rate
	 */
	public double getRate()
	{
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate)
	{
		this.rate = rate;
	}
	/* (non-Javadoc)
	 * @see employeeStuff.Employee#calcPay()
	 */
	@Override
	
	
	public double calcPay()
	{
		return hours*rate;
	}
	public String toString()
	{
		return super.toString()+" "+(hours*rate);
	}

	
}
