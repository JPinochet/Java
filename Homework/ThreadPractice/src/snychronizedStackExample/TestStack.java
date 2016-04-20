/**
 * 
 */
package snychronizedStackExample;

/**
 * @author 432873
 *
 */
import java.util.*;

 class TestStack
{

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		SyncStack stack	= new SyncStack();
		ThreadGroup group1 = new ThreadGroup("Thread Group One");
		
		Producer p1 = new Producer(stack);
		Thread t1 = new Thread(group1,p1);
		t1.start();
		
		Producer p2 = new Producer(stack);
		Thread t2 = new Thread(group1,p2);
		t2.start();
		
		Producer p3 = new Producer(stack);
		Thread t3 = new Thread(group1,p3);
		t3.start();
		
		Consumer c1 = new Consumer(stack, group1);
		c1.start();
		
		Consumer c2 = new Consumer(stack, group1);
		c2.start();
		
		while(group1.activeCount() > 0);
		ArrayList buffer = (ArrayList)stack.getBuffer();
		Iterator it = buffer.iterator();
		
		System.out.println("\n\nThe following are the characters left on the stack\n");
		while(it.hasNext())
		{
			System.out.print(it.next()+", ");
		}
	}
}

