/**
 * Mar 13, 2009
 */
package utilities;

import java.io.*;

/**
 * @author 432873
 * Jorge Pinochet
 * 
 * Implementation of a singly linked list node.
 * The node consists of an element and reference 
 * to the next door in the list.
 *
 */
public class SLLNode implements Serializable
{
	//Attributes
	private Object 					element;
	private SLLNode					next;
	
	//Constructor
	/**
	 * Constructs a SLLNode with an element and a reference
	 * to a successor node.
	 * @param element - object containing the data being stored in list
	 * @param next - reference to the next node
	 */
	public SLLNode(Object element, SLLNode next)
	{
		this.element = element;
		this.next = next;
	}

	/**
	 * Constructs a SLLNode with an element and a reference
	 * to null.
	 * @param element - object containing the data being stored in list.
	 */
	public SLLNode(Object element)
	{
		this.element = element;
		this.next = null;
	}

	/**
	 * @return the element
	 */
	public Object getElement()
	{
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(Object element)
	{
		this.element = element;
	}

	/**
	 * @return the next
	 */
	public SLLNode getNext()
	{
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(SLLNode next)
	{
		this.next = next;
	}
	
	
	
	
}
