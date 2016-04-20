/**
 * 
 */
package employeeStuff;

/**
 * @author 432873
 * Second one made, not the same as employeeDemo
 */
public abstract class Employee
{
	private int 	id;
	private String 	name;
	private String	address;
	private String 	phone;
	private long 	socialInsuranceNumber;
	private String	dateOfBirth;
	private String 	department;
	
	//Constructors 
	/**
	 * Default constructor 
	 */
	public Employee()
	{
	}

	/**
	 * @param id. The ID# of the employee.
	 * @param name. Name of the employee.
	 * @param address. The full address of the employee.
	 * @param phone. The phone number of the employee. 
	 * @param socialInsuranceNumber. Social insurance number of the employee.
	 * @param dateOfBirth. Date of birth of the employee.
	 * @param deptpartment. The Department the employee works in.
	 */
	public Employee(int id, String name, String address, String phone,
			long socialInsuranceNumber, String dateOfBirth, String deptpartment)
	{
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.socialInsuranceNumber = socialInsuranceNumber;
		this.dateOfBirth = dateOfBirth;
		this.department = deptpartment;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
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
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone()
	{
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	/**
	 * @return the socialInsuranceNumber
	 */
	public long getSocialInsuranceNumber()
	{
		return socialInsuranceNumber;
	}

	/**
	 * @param socialInsuranceNumber the socialInsuranceNumber to set
	 */
	public void setSocialInsuranceNumber(long socialInsuranceNumber)
	{
		this.socialInsuranceNumber = socialInsuranceNumber;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the department
	 */
	public String getDeptpartment()
	{
		return department;
	}

	/**
	 * @param deptpartment the department to set
	 */
	public void setDeptpartment(String deptpartment)
	{
		this.department = deptpartment;
	}
	
	//operational Methods
	/**
	 * An abstract method to calculate the amount paid to an employee to be implemented in child class.
	 * @return the amount paid to the employee.
	 * 
	 */
	public abstract double calcPay();
	
	/**
	 * 
	 */
	public String toString()
	{
		return id+" "+name+" "+address+" "+phone+" "+socialInsuranceNumber+" "+dateOfBirth+" "+department;
	}
	
}
