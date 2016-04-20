/**
 * Feb 19, 2009
 */
package gizmoInventory;

/**
 * @author 432873
 *
 */
/**
 * Created on Dec 3, 2007
 *
 * Project: reviewArrays
 */

import java.util.*;
import fileHandling.*;

/**
 * @author dwatson
 * @version 1.0
 * 
 */
public class ArrayListManagedInventory
{
	//Attributes
	//Singleton Pattern requires a static reference to itself.
	private static ArrayListManagedInventory 	almi;
	private ArrayList 		inventory;
	
	
	
	//Constructors
	/**
	 * Default constructor to initialize class
	 * level attributes to user specified values.
	 * As part of a Singleton Pattern the constructor
	 * has to be private.
	 */
	private ArrayListManagedInventory()
	{
		inventory = new ArrayList();
	}
	
	//Operational Methods
	
	/**
	 * This method is required in a Singleton Pattern design to
	 * return the instance of the class.  This method checks to
	 * see if a reference already exists and if not creates one
	 * otherwise returns the current existing reference.
	 * @return reference to this class.
	 */
	public static ArrayListManagedInventory getArrayListManagedInventory()
	{
		if(almi == null)
		{
			almi = new ArrayListManagedInventory();
		}
		return almi;
	}
	/**
	 * Method to fill the inventory array with gizmo
	 * objects from the text file gizmos.txt.
	 */
	public void loadInventoryArray()
	{
		FileInput fin = new FileInput("res/gizmos.txt");
		
		String line = fin.readLine();
		
		while(line != null)
		{
			Gizmo g = new Gizmo(line);
			inventory.add(g);
			line = fin.readLine();
		}
		fin.closeInputFile();
	}
	
	/**
	 * Method takes in a Gizmo object and adds
	 * the new item to the end of the current
	 * list.
	 * @param g - Gizmo object being added
	 * @return boolean to indicate the item has been added successfully.
	 */
	public boolean addGizmoItemToInventory(Gizmo g)
	{
		return inventory.add(g);
	}
	
	/**
	 * Method to search the inventory by id number and return
	 * the Gizmo object if one is found or null if no match to
	 * the id is found.
	 * @param numToSearch - id that is being searched for.
	 * @return a Gizmo object if found and null if nothing is found.
	 */
	public Gizmo searchGizmosByItemNumber(int numToSearch)
	{
		boolean found = false;
		Gizmo g = null;
		
		for(int i = 0; i < inventory.size() && found == false; i++)
		{
			g = (Gizmo)inventory.get(i);
			if(g.getItem() == numToSearch)
			{
				found = true;
			}
		}
		return g;
	}
	
	/**
	 * Method to delete a Gizmo object from the inventory.
	 * @param numToDelete - id number of the Gizmo object to delete.
	 * @return a true value if the object has been deleted and false if it has not.
	 */
	public boolean deleteGizmoItem(int numToDelete)
	{
		Gizmo g = searchGizmosByItemNumber(numToDelete);
		return inventory.remove(g);
	}
	
	/**
	 * Method that searches the inventory for all items above
	 * a minimum price and returns all those items as a list.
	 * @param minPrice - the set minimum price for the search
	 * @return a list of all items with a minimum price > the search price.
	 */
	public ArrayList<Object> searchHigherPrices(double minPrice)
	{
		ArrayList higher = new ArrayList();
		
		for(int i = 0; i < inventory.size(); i++)
		{
			Gizmo g = (Gizmo)inventory.get(i);
			if(g.getPrice() > minPrice)
			{
				higher.add(g);
			}
		}
		return higher;
	}
	
	/**
	 * Method prints all gizmo items in the current
	 * inventory. 
	 */
	public void printInventory()
	{
		for(int i = 0; i < inventory.size(); i++)
		{
			System.out.println(inventory.get(i));
		}
	}
}
