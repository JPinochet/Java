/**
 * 
 */
package utilities;

import java.util.Arrays;

/**
 * @author 432873
 * @param <E>
 *
 */
public class MyArrayList<E> implements List<E>
{
	private static final long	serialVersionUID	= -8327322027309261252L;
	//Attributes
	private int size;
	private transient Object[] bufferedList;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException,
			IndexOutOfBoundsException
	{
		RangeCheck(index);

		@SuppressWarnings("unused")
		E oldValue = (E) bufferedList[index];
		bufferedList[index] = toAdd;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException,
			IndexOutOfBoundsException
	{
		bufferedList[size++] = toAdd;
		return true;
	}

	@Override
	public boolean addAll(List<? extends E> toAdd) throws NullPointerException
	{
		for(int i = 0; i < toAdd.size(); i++)
		{
			bufferedList[size++] = toAdd;
		}
		return false;
	}

	@Override
	public void clear()
	{
		for (int i = 0; i < size; i++)
		{
		    bufferedList[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException
	{
		return indexOf(toFind) >= 0;
	}
	
	/**
	 * Checks if the current arrayList contains the object 0. 
	 * @param o the object being looked for.
	 * @return -1 if not found, otherwise the index of the object where it was found
	 */
	public int indexOf(Object o) 
	{
		if (o == null) 
		{
		    for (int i = 0; i < size; i++)
			if (bufferedList[i]==null)
			{
			    return i;
			}
		}
		else 
		{
		    for (int i = 0; i < size; i++)
		    {
		    	if (o.equals(bufferedList[i]))
				{
			    	return i;
				}
		    }
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException
	{
		RangeCheck(index);

		return (E) bufferedList[index];
	}

	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}

	@Override
	public Iterator<E> iterator()
	{
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException
	{
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(E toRemove) throws NullPointerException
	{
		if (toRemove == null) 
		{
            for (int index = 0; index < size; index++)
		if (bufferedList[index] == null) 
		{
		    remove(index);
		    return (E) bufferedList[index];
		}
		} 
		else 
		{
			for (int index = 0; index < size; index++)
			{
				if (toRemove.equals(bufferedList[index]))
				{
					remove(index);
					return (E) bufferedList[index];
				}
			}
		}
		return (E) bufferedList;
	}
		
	

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException
	{
		RangeCheck(index);
		
		E oldValue = (E)bufferedList[index];
		bufferedList[index]= toChange;
		return oldValue;
	}

	@Override
	public int size()
	{
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException
	{
		for(int i = 0; i < toHold.length; i++)
		{
			bufferedList[i] = (E[]) toHold[i];
		}
		return (E[]) bufferedList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray()
	{
		return (E[]) Arrays.copyOf(bufferedList, size);
	}
	
	 private void RangeCheck(int index) 
	 {
		 if (index >= size) throw new IndexOutOfBoundsException
		 ("Index: " + index + ", Size: " + size);
	 }
}
