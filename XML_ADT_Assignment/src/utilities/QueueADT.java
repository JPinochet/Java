/**
 * 
 */
package utilities;

/**
 * @author 432873
 *
 */
public abstract class QueueADT<E>
{
	/**
	 * Inserts the element into the queue if at all possible
	 * @param obj object to add
	 * @return true/false
	 */
	public abstract boolean add(Object obj);
	
	/**
	 * Inserts the element into the queue if at all possible
	 * @param obj object to add
	 * @return true/false
	 */
	public abstract boolean offer(Object obj);
	
	/**
	 * Dequeue an object from queue
	 * 
	 * @return the object dequeued
	 */
	public abstract E remove();
	
	/**
	 * Retrieves and removes the head of the queue
	 * 
	 * @return the head of the queue
	 */
	public abstract E poll();
	
	/**
	 * Retrieves and removes the head of the queue, however if the queue is empty throws and exception
	 * @return the head of the queue
	 */
	public abstract E element();
	
	/**
	 * Look at but do not remove the head of the queue
	 * @return the head of the queue
	 */
	public abstract E peek();
}