/**
 * Mar 13, 2009
 */
package utilities;

import java.io.*;
import java.util.*;

/**
 * @author 432873
 * Jorge Pinochet
 * 
 */
public class SLL implements List, Serializable
{
	//Attributes
	private SLLNode 		head;
	private int 			size;
	
	//Constructor
	public SLL()
	{
		head = null;
		size = 0;
	}
	
	/* (non-Javadoc)
	 * @see utilities.List#add(java.lang.Object)
	 */
	@Override
	public boolean add(Object o)
	{
		if(isEmpty())
		{
			head = new SLLNode(o);
			size++;
		}
		else 
		{
			SLLNode curr = head;
			SLLNode insert = new SLLNode(o);
			//OR: SLLNode insert = new SLLNode(o,head);
			head = insert;
			insert.setNext(curr);
			size++;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see utilities.List#add(java.lang.Object, int)
	 */
	@Override
	public boolean add(Object o, int position) throws IndexOutOfBoundsException
	{
		SLLNode curr = head;
		for(int x = 0; x < size ; x++, curr=curr.getNext())
		{
			if(x == position)
			{
				SLLNode insert = new SLLNode(o);
				curr.setNext(insert);
				return true;
			}
			else
			{
				System.out.println("Position does not exist.");
				return false;
			}
				
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see utilities.List#append(java.lang.Object)
	 */
	@SuppressWarnings("null")
	@Override
	public boolean append(Object o)
	{
		SLLNode curr = head;
		SLLNode insert = new SLLNode(o);
		
		
		if (curr != null)
		{
			
			for (int x = 0; x < size; x++, curr = curr.getNext())
			{
				if (curr.getNext() == null)
				{
					
					curr.setNext(insert);
					size++;
					return true;
				}
			}
			
		}
		else
		{
			curr.setElement(insert);
			size++;
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see utilities.List#clear()
	 */
	@Override
	public void clear()
	{
		head = null;
		size = 0;
	}

	/* (non-Javadoc)
	 * @see utilities.List#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o)
	{
		SLLNode curr = head;
		
		for(int x = 0; x < size ; x++, curr=curr.getNext())
		{
			if(curr.getElement() == o)
			{
				return true;
			}
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see utilities.List#get()
	 */
	@Override
	public Object get()
	{
		if(!isEmpty())
		{
			Object item = head.getElement();
			return item;
		}
		else
		{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see utilities.List#get(int)
	 */
	@Override
	public Object get(int position) throws IndexOutOfBoundsException
	{
		SLLNode curr = head;
		
		for(int x = 0; x < size ; x++, curr=curr.getNext())
		{
			if(x == position)
			{
				return curr.getElement();
			}
			else
			{
				System.out.println("Position does not exist.");
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see utilities.List#getLast()
	 */
	@SuppressWarnings("null")
	@Override
	public Object getLast()
	{
		SLLNode curr = head;
		SLLNode temp = null;
		
		while(curr.getNext()!=null)
		{
			curr=temp;
		}
		return temp.getElement();
	}

	/* (non-Javadoc)
	 * @see utilities.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object o)
	{
		SLLNode curr = head;
		
		for(int x = 0; x < size ; x++, curr=curr.getNext())
		{
			if(curr.getElement() == o)
			{
				return x;
			}
		}
		return -1;
	}

	/* (non-Javadoc)
	 * @see utilities.List#isEmpty()
	 */
	@Override
	public boolean isEmpty()
	{
		return head == null;
	}

	/* (non-Javadoc)
	 * @see utilities.List#remove()
	 */
	@Override
	public Object remove()
	{
		if(head == null) throw new NoSuchElementException();
		Object element = head.getElement();
		head = head.getNext();
		size--;
		return element;
	}

	/* (non-Javadoc)
	 * @see utilities.List#remove(int)
	 */
	@Override
	public Object remove(int position) throws IndexOutOfBoundsException
	{
		SLLNode curr = head;
		for(int x = 0; x < size ; x++, curr=curr.getNext())
		{
			if(position == x)
			{
				Object element = curr.getElement();
				curr = curr.getNext();
				size--;
				return element;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see utilities.List#removeLast()
	 */
	@Override
	public Object removeLast()
	{
		//Not sure why...but wasn't working with the old code, tried new and past my test.
		 SLLNode previous,curr;
	     previous=null;
	     curr=head;
	       
	     while((curr!=null) &&  (curr.getNext()!= null))
	     {  
	    	 previous=curr;
	         curr=curr.getNext();
	         size--;
	     }
	     if(previous!=null) 
	     {
	    	 previous = null;
	     } 
	     else 
	     {
	    	 head = null;
	     }
	     return curr.getElement();
	}

	/* (non-Javadoc)
	 * @see utilities.List#size()
	 */
	@Override
	public int size()
	{
		return size;
	}
	
	public void printList()
	{
		SLLNode curr = head;
		for(int x = 0; x < size ; x++, curr=curr.getNext())
		{
			System.out.println(curr.getElement());
		}
	}

}
