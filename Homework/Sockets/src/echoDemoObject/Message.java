/**
 * 
 */
package echoDemoObject;

import java.io.Serializable;
import java.util.*;

/**
 * @author 432873
 *
 */
public class Message implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1988879404542171223L;
	//Constants
	
	//Attributes
	private String 			user;
	private String			msg;
	private Date			timeStamp;
	
	//Constructors
	public Message()
	{
	}
	
	public Message(String user, String msg, Date timeStamp)
	{
		this.user = user;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the user
	 */
	public String getUser()
	{
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user)
	{
		this.user = user;
	}

	/**
	 * @return the msg
	 */
	public String getMsg()
	{
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp()
	{
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp)
	{
		this.timeStamp = timeStamp;
	}
	
	//Operational Methods
	public String toString()
	{
		return "User Name: "+user+"        "+"Date and Time: "+timeStamp+
				"\nMessage: "+msg;
	}
}
