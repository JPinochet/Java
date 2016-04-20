/**
 * Mar 19, 2009
 */
package serializationExample;

import java.io.*;

public class Competitor implements Serializable
{		
	public static final long serialVersionUID = -3751415807246403471L;
	private String name;
	private Event event;
	private int yob;
	
	public Competitor(String name, Event event)
	{
	    this.name = name;
	    this.event = event;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setEvent(Event e)
	{
		this.event = event;
	}

	public String getName()
	{
		return name;
	}
	
	public Event getEvent()
	{
		return event;
	}
	
	public String toString()
	{
		return "\n\n" + getName() + "  " + getEvent().toString();
	}

	/**
	 * @return the yob
	 */
	public int getYob()
	{
		return yob;
	}

	/**
	 * @param yob the yob to set
	 */
	public void setYob(int yob)
	{
		this.yob = yob;
	}
}
