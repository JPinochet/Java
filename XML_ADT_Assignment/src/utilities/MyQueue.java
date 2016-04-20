/**
 * 
 */
package utilities;

import java.util.Vector;

/**
 * @author 432873
 *
 */
public class MyQueue<E> extends QueueADT<E>
{
	//attribute
	@SuppressWarnings("unchecked")
	private Vector vector = new Vector();

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object obj)
	{
		if(vector.isEmpty())
		{
			vector.add(obj);
			return true;
		}
		
		vector.addElement(obj);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E element()
	{
		if (isEmpty())
		    return null;
		return (E) vector.elementAt(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean offer(Object obj)
	{
		if(vector.isEmpty())
		{
			vector.add(obj);
			return true;
		}
		
		vector.addElement(obj);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek()
	{
		if (isEmpty())
		    return null;
		return (E) vector.elementAt(0);

	}

	private boolean isEmpty()
	{
		return vector.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E poll()
	{
		Object object = peek();
		if (object != null)
		    vector.removeElementAt(0);
		return (E) object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove()
	{
		Object temp = vector.get(0);
		vector.removeElementAt(0);
		return (E) temp;
	}

}
