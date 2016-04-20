/**
 * 
 */
package utilities;

/**
 * @author 432873
 *
 */
public class MyStack<E> extends StackADT<E>
{
	//Attributes
	private Object[] stack;

	@Override
	public boolean empty()
	{
		return stack.length == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek()
	{
		return (E) stack[0];
	}

	@Override
	public E pop()
	{
		E	obj;
		int	len = size();

		obj = peek();
		removeElementAt(len - 1);

		return obj;
	}

	private void removeElementAt(int i)
	{
		stack[i] = null;
	}

	private int size()
	{
		int count = 0;
		for(int i = 0; i < stack.length; i++)
		{
			count++;
		}
		return count;
	}

	@Override
	public E push(E item)
	{
		addElement(item);

		return item;
	}

	private void addElement(E item)
	{
		int size = size();
		stack[size++] = item;
	}

	@Override
	public int search(Object obj)
	{
		int i = lastIndexOf(obj);

		if (i >= 0) 
		{
		    return size() - i;
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	private int lastIndexOf(Object obj)
	{
		for(int i = 0; i < stack.length; i++)
		{
			if(stack[i] == (E)obj)
			{
				return i;
			}
		}
		return 0;
	}

}
