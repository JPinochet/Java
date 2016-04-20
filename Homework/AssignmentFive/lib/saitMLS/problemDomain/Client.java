/**
 * Mar 12, 2009
 */
package saitMLS.problemDomain;

import java.util.*;
/**
 * @author 432873
 *
 */
public class Client
{
	//Constants
	protected static final int			SIZE = 132;
	
	//Attributes
	private boolean						activeStatus; //1byte
	private long						id; //8 bytes
	private String						firstName; //22bytes
	private String						lastName; //22bytes
	private String						address; //52bytes
	private String						postalCode; //9 bytes
	private String						phoneNumber; //16bytes
	private char						clientType; //2
	
	//default constructor
	public Client()
	{
		setActiveStatus(true);
	}
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param postalCode
	 * @param phoneNumber
	 * @param clientType
	 */
	public Client(long id, String firstName, String lastName, String address,
			String postalCode, String phoneNumber, char clientType)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.clientType = clientType;
		activeStatus = true;
	}
	
	public Client(String line)
	{
		StringTokenizer st = new StringTokenizer(line,";");
		
		id = Long.parseLong(st.nextToken());
		firstName = st.nextToken();
		lastName = st.nextToken();
		address = st.nextToken();
		postalCode = st.nextToken();
		phoneNumber = st.nextToken();
		clientType = st.nextToken().charAt(0);
		activeStatus = true;
	}

	public void setActiveStatus(boolean activeStatus)
	{
		this.activeStatus = activeStatus;
	}

	public boolean isActiveStatus()
	{
		return activeStatus;
	}

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
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
	 * @return the postalCode
	 */
	public String getPostalCode()
	{
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the clientType
	 */
	public char getClientType()
	{
		return clientType;
	}

	/**
	 * @param clientType the clientType to set
	 */
	public void setClientType(char clientType)
	{
		this.clientType = clientType;
	}
	
	public String toString()
	{
		return id+firstName+lastName+address+postalCode+phoneNumber+clientType;
	}
	
}
