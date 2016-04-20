package utilities;

/**
 *The List interface described below is the basis for learning Linear data
 *types.  It is not a involved as the <code>java.util.List</code>.  
 *It will not define any searching or iteration methods that would normally
 *be a part of the List interface.
 */

public interface List
{
	//ADD OPERATIONS

	/**
	 *Method to append an element to the end of a List.  If the list is
	 *empty the element will be added to the first position.
	 *
	 *@param o - element to be added to the list
	 *@return true if element if added correctly and false if not.
	 */
	public boolean append(Object o);

	/**
	 *Method to add an element to the FIRST position in the
	 *list.  If the list is empty, the element will be added to the
	 *first position.
	 *
	 *
	 *@param o - element to be added to the list
	 */
	 public boolean add(Object o);

	 /**
	  *Method to add an element to a specific position in the
	  *list.  If the position is an index outside of the bounds
	  *of the list an exception is raised.
	  *
	  *@param o - element to be added to the list
	  *@param position - index that the element should be placed at
	  *@throws IndexOutOfBoundsException when the index is (position<0 || position > size())
	  *
	  */
	 public boolean add(Object o, int position) throws IndexOutOfBoundsException;

	//REMOVE OPERATIONS

	/**
	 *Clears the list, all elements are lost
	 */
	 public void clear();

	 /**
	  *Removes the <b>FIRST</b> element in the list and changes the index
	  *for all the remaining elements by (-1).<br>
	  *
	  *@return Object element at the first position of the list.  If the list
	  *is empty, returns a <code>null</code> reference.
	  */
	 public Object remove();

	 /**
	  *Removes the <b>LAST</b> element in the list.
	  *
	  *@return Object element at the last postion of the list.  If list
	  *is empty, returns a <code>null</code> reference.
	  */
	 public Object removeLast();

	 /**
	  *Removes the element at the provided index, if the index
	  *is outside the bounds of the the list an exception is thrown
	  *
	  *@param position the position in the list of the element to be removed
	  *@return Object element being removed from the list
	  *@throws IndexOutOfBoundsException when the index is (position<0 || position > size())
	  */
	 public Object remove(int position) throws IndexOutOfBoundsException;

	 //UTILITY METHODS

	 /**
	  *Gets a refernce to the first element in the list without
	  *disturbing the list structure.
	  *
	  *@return Object reference to the fist element in the list, if
	  *the list is empty, returns a <code>null</code> reference.
	  */
	 public Object get();

	 /**
	  *Gets a reference to the last element in the list, without
	  *distrubing the list structure.
	  *
	  *@return Object reference to the last element in the list, if
	  *the list is empty, returns a <code>null</code> reference.
	  */
	 public Object getLast();


	 /**
	  *Gets a reference to the element at the specified postion. If the List
	  *is empty returns a <code>null</code> reference.
	  *
	  *@param position the location within the list of the desired element
	  *@return Object reference to the specified element
	  *@throws IndexOutOfBoundsException when the index is (position<0 || position > size())
	  */
	 public Object get(int position) throws IndexOutOfBoundsException;
	 
	 
	 /**
	  *Checks the list and determines if the object exists in the list, if 
	  *the object is present in the list, the method returns true.
	  *
	  *@return <code>boolean</code> true if object is in list,
	  *otherwise false.
	  */
	 public boolean contains(Object o);
	 
	 
	 /**
	  *Returns the index in this list of the first occurrence of the
	  *specified element, or -1 if the List does not contain this element. 
	  *
	  *@return <code>int</code>, the index in this list of the first
	  *occurrence of the specified element, or -1 if the list does not
	  *contain this element.
	  */
	 public int indexOf(Object o);	 

	 /**
	  *Gets the current number of elements in the list, if list is empty
	  *returns a 0 (zero).
	  *
	  *@return <code>int</code>, an integer greater or equal to zero
	  */
	 public int size();

	 /**
	  *Returns the current status of the list.
	  *
	  *@return <code>boolean</code> false if the list contains any elements.
	  */
	 public boolean isEmpty();
}