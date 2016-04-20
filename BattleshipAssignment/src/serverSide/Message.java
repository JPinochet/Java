/**
 * 
 */
package serverSide;

import java.io.Serializable;
import java.util.*;

/**
 * @author 432873
 *
 */
public class Message implements Serializable
{
	private static final long	serialVersionUID	= -6113573490433081268L;
	private String 			user;
	private String			msg;
	private Date			timeStamp;
	
	public Message()
	{
	}
	
	public Message(String user, String msg, Date timeStamp)
	{
		this.user = user;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	public String getUser()
	{
		return user;
	}
	public void setUser(String user)
	{
		this.user = user;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public Date getTimeStamp()
	{
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp)
	{
		this.timeStamp = timeStamp;
	}
	public String toString()
	{
		return "User Name: "+user+"        "+"Date and Time: "+timeStamp+
				"\nMessage: "+msg;
	}
}
