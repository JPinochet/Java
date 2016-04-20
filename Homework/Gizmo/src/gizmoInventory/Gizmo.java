package gizmoInventory;

import java.util.*;

/**
*	Demo of RandomFileAccess class and how it works
*	for reading and writing to binary files.
*	Gizmo.java - data container class for a gizmo.
*/

public class Gizmo
{
	// Attributes
	private int				item; 
	private String			description; 
	private int				quantity; 
	private double			price;  
	
	public Gizmo()
	{
	}
	
	public Gizmo(int item, String desc, int quantity, double price)
	{		
		this.item = item;
		this.description = desc;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Gizmo(String line)
	{
		StringTokenizer st = new StringTokenizer(line, ";");
		
		item = Integer.parseInt(st.nextToken());
		description = st.nextToken();
		quantity = Integer.parseInt(st.nextToken());
		price = Double.parseDouble(st.nextToken());
	}
	
	// Accessor Methods
	public int getItem()
	{
		return item;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	// Modifier Methods
	public void setItem(int item)
	{
		this.item = item;
	}
	
	public void setDescription(String desc)
	{
		description = desc;
	}
	
	public void setQuantity(int quant)
	{
		quantity = quant;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	// Operational Methods
	public String toString()
	{		
		return 	String.format("%6s %15s %6d %8.2f", item,description,quantity,price);
	}
}

