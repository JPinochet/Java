package utilities;

/**
 * @author 432873
 *
 * My take on the DLL linked list.
 */
public class DLL 
{
	//attributes
	private Link first; 
	private Link last; 

	public DLL() 
	{
		first = null; 
		last = null;
	}

	public boolean isEmpty()
	{
		return first == null;
	}

	public void insertFirst(long ddlData)
	{
		Link newLink = new Link(ddlData); 

		if (isEmpty())
		{
			last = newLink; 
		}
		else
		{
			first.previous = newLink;
		}
		
		newLink.next = first; 
		first = newLink; 
	}

	public void insertLast(long ddlData)
	{
		Link newLink = new Link(ddlData); 
		if (isEmpty())
		{
			first = newLink;
		}	
		else 
		{
			last.next = newLink; 
			newLink.previous = last; 
		}
    
		last = newLink; 
	}

	public Link deleteFirst()
	{ 
		Link temp = first;
		if (first.next == null)
		{
			last = null;
		}
		else
		{
			first.next.previous = null;
		}
    
		first = first.next; 
		return temp;
	}

	public Link deleteLast()
	{ 
		Link temp = last;
		if (first.next == null)
		{
			first = null;
		}
		else
		{
			last.previous.next = null;
		}
    
		last = last.previous; 
		return temp;
	}

	public boolean insertAfter(long key, long ddlData) 
	{ 
		Link current = first; 
    
		while (current.ddlData != key)
		{
			current = current.next;
			if (current == null)
			{
				return false;
			}
		}
    
		Link newLink = new Link(ddlData); 

		if (current == last)
		{
			newLink.next = null; 
			last = newLink; 
		} 
		else
		{
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		
		newLink.previous = current; 
		current.next = newLink; 
		
		return true; 	
	}

	public Link deleteKey(long key)
	{
		Link current = first; 
    
		while (current.ddlData != key)
		{
			current = current.next;
			
			if (current == null)
			{
			return null; 
			}
		}
		
		if (current == first) 
		{
			first = current.next;
		}	
		else
		{
			current.previous.next = current.next;
		}

		if (current == last) 
			last = current.previous; 
		else
			current.next.previous = current.previous;
		
		return current; 	
	}

	public void displayForward() 
	{
		System.out.print("List (first to last): ");
		Link current = first; 
    
		while (current != null) 
		{
			current.displayLink();
			current = current.next; 
		}
		System.out.println("");
	}

	public void displayBackward() 
	{
		System.out.print("List : ");
		Link current = last;
		
		while (current != null)
		{
			current.displayLink();
			current = current.previous;
		}
    
		System.out.println("");
	}
}

/**
 * @author 432873
 *	
 * Class that creates 
 */
class Link 
{
	public long ddlData;
	public Link next; 
	public Link previous;

	public Link(long data)
	{
		ddlData = data;
	}

	public void displayLink()
	{
		System.out.print(ddlData + " ");
	}
}