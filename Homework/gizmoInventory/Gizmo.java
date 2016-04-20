/**
 * 
 */
package gizmoInventory;

/**
 * @author 432873
 * created: January 9, 2009
 * modified:
 */
public class Gizmo
{
	//Attributes
	private int 	itemID;
	private String 	itemName;
	private int		itemQuantity;
	private double 	itemPrice;
	
	public Gizmo()
	{
	}

	/**
	 * @param itemID
	 * @param itemName
	 * @param itemQuantity
	 * @param itemPrice
	 */
	public Gizmo(int itemID, String itemName, int itemQuantity, double itemPrice)
	{
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the itemID
	 */
	public int getItemID()
	{
		return itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(int itemID)
	{
		this.itemID = itemID;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName()
	{
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	/**
	 * @return the itemQuantity
	 */
	public int getItemQuantity()
	{
		return itemQuantity;
	}

	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(int itemQuantity)
	{
		this.itemQuantity = itemQuantity;
	}

	/**
	 * @return the itemPrice
	 */
	public double getItemPrice()
	{
		return itemPrice;
	}

	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(double itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	public String toString()
	{
		return		"Item ID:			"+itemID+"\n"+
			   		"Item Name:			"+itemName+"\n"+
			   		"Quantity of Item:		"+itemQuantity+"\n"+
			   		"Item Price per Unit:		"+itemPrice+"\n";	
	}
	
}
