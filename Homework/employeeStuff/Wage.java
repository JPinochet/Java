/**
 * Jan 16, 2009
 */
package employeeStuff;

/**
 * @author 432873
 *
 */
public class Wage extends Employee
{
	//Constants
	private final double 		OVER_TIME=40;
	
	//Attributes
	private double 				hours;
	private double 				rate;

	/**
	 * 
	 */
	public Wage()
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
	 * @param hours
	 * @param rate
	 */
	public Wage(int id, String name, String address, String phone,
			long socialInsuranceNumber, String dateOfBirth, String deptpartment, double hours, double rate)
	{
		super(id, name, address, phone, socialInsuranceNumber, dateOfBirth,
				deptpartment);
		this.hours = hours;
		this.rate = rate;
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
		double pay =0;
		if(hours>OVER_TIME)
		{
			pay = (rate*OVER_TIME)+ (rate *1.5*(hours-OVER_TIME));
		}
		else
		{
			pay = pay*hours;
		}
		return pay;
	}
	
	public String toString()
	{
		return super.toString()+" "+rate+" "+hours;
	}

	

}
