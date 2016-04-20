package serializationExample;

import java.io.*;

public class Event implements Serializable
{
	public static final long serialVersionUID = -7651845092852514603L;
	private String description;
	private Location location;
	
	public Event (String description, Location location)
	{
		this.description = description;
		this.location = location;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setLocation(Location loaction)
	{
		this.location = location;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public String toString()
	{
	    return "\n" + getDescription() + "  " + getLocation().toString();
	}
}
