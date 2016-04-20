package serializationExample;

import java.io.*;

public class Location implements Serializable
{
	private static final long serialVersionUID = -4079935984221661078L;
	private String description;
	private String address;
	
	public Location(String description, String address)
	{
		this.description = description;
		this.address = address;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public String toString()
	{
		return "\n" + getDescription() + "   " + getAddress();
	}
}