/**
 * Mar 13, 2009
 */
package linkListTest;

import static org.junit.Assert.*;
import utilities.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 432873
 *
 */
public class SLLTest
{
	//Attributes
	private SLL 	list;
	private Integer one, two, three, four, five;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		list = new SLL();
		one = new Integer(111);
		two = new Integer(222);
		three = new Integer(333);
		four = new Integer(444);
		five = new Integer(555);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		list = null;
		one = null;
		two = null;
		three = null;
		four = null;
		five = null;
	}

	/**
	 * Test method for {@link utilities.SLL#SLL()}.
	 */
	@Test
	public void testSLL()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#add(java.lang.Object)}.
	 */
	@Test
	public void testAddObject()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#add(java.lang.Object, int)}.
	 */
	@Test
	public void testAddObjectInt()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#append(java.lang.Object)}.
	 */
	@Test
	public void testAppend()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#clear()}.
	 */
	@Test
	public void testClear()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#get()}.
	 */
	@Test
	public void testGet1()
	{
		int expected = 111;
		list.add(one);
		Integer i = (Integer)list.get();
		int actual = i.intValue();
		assertEquals("Getting first object in list failed ",expected, actual);
	}
	
	/**
	 * Test method for {@link utilities.SLL#get()}.
	 */
	@Test
	public void testGet2()
	{
		int expected = 222;
		list.add(one);
		list.add(two);
		Integer i = (Integer)list.get();
		int actual = i.intValue();
		list.printList();
		assertEquals("Getting first object in list failed ",expected, actual);
	}

	/**
	 * Test method for {@link utilities.SLL#get(int)}.
	 */
	@Test
	public void testGetInt()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#getLast()}.
	 */
	@Test
	public void testGetLast()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#indexOf(java.lang.Object)}.
	 */
	@Test
	public void testIndexOf()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#isEmpty()}.
	 */
	@Test
	public void testIsEmpty()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#remove()}.
	 */
	@Test
	public void testRemove()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#remove(int)}.
	 */
	@Test
	public void testRemoveInt()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#removeLast()}.
	 */
	@Test
	public void testRemoveLast()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.SLL#size()}.
	 */
	@Test
	public void testSize()
	{
		fail("Not yet implemented");
	}

}
