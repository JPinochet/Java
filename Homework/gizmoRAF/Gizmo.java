/**
 * Feb 19, 2009
 */
package gizmoRAF;

/**
 * @author 432873
 *
 */

import java.util.*;

/**
*	Demo of RandomFileAccess class and how it works
*	for reading and writing to binary files.
*	Gizmo.java - data container class for a gizmo.
*/

public class Gizmo
{
	//Constant
	protected static final int 				SIZE = 40;
	
	// Attributes
	private int				item; // 4 bytes
	private String			description; // 21 bytes for characters plus 2 bytes
	private int				quantity;  // 4 bytes
	private double			price;  // 8 bytes
	private boolean			active; //1 byte
	
	public Gizmo()
	{
		active = true;
	}
	
	public Gizmo(int item, String desc, int quantity, double price)
	{		
		this.item = item;
		this.description = desc;
		this.quantity = quantity;
		this.price = price;
		active = true;
	}
	
	public Gizmo(String line)
	{
		StringTokenizer st = new StringTokenizer(line, ";");
		
		item = Integer.parseInt(st.nextToken());
		description = st.nextToken();
		quantity = Integer.parseInt(st.nextToken());
		price = Double.parseDouble(st.nextToken());
		active = true;
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
	
	/**
	 * @return the active
	 */
	public boolean isActive()
	{
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active)
	{
		this.active = active;
	}
	
	// Operational Methods
	public String toString()
	{		
		return 	String.format("%6d %15s %6d %8.2f", item,description,quantity,price);
	}

}


