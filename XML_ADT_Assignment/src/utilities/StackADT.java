/**
 * 
 */
package utilities;

/**
 * @author 432873
 *
 */
public abstract class StackADT<E>
{	
	/**
	 * Adds an object to the stack
	 * 
	 * @return the element added
	 */
	public abstract E push(E item);
	
	/**
	 * Removes the last object added to the stack
	 * 
	 * @return the element added
	 */
	public abstract E pop();
	
	/**
	 * Returns the first object added to the stack, null if the stack is empty
	 * @return the first element of the stack
	 */
	public abstract E peek();
	
	/**
	 * Checks to see if the stack is empty
	 * @return true/false
	 */
	public abstract boolean empty();
	
	/**
	 * Searches the stack for the object
	 * @param obj object to be searched for
	 * @return the index of the object found.
	 */
	public abstract int search(Object obj);
}
