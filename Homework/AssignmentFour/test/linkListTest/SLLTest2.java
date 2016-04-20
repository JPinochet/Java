package linkListTest;

/**
 * Teacher given code to test my SLL linked list.
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.*;

/**
 * @author dwatson
 *
 */
public class SLLTest2 {

	//Attributes
	SLL 	list;
	Integer	one, two, three, four, five;
	@Before
	public void setUp() throws Exception
	{
		list = new SLL();
		one = new Integer(11);
		two = new Integer(22);
		three = new Integer(33);
		four = new Integer(44);
		five = new Integer(55);
	}

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
	 * Test method for SLL to check that a linked list is created properly.
	 */
	@Test
	public void testSLL()
	{
		assertEquals("Did not create SLL correctly ",true,list.isEmpty());
		assertEquals("The size of the list is not correct ",0,list.size());
	}
	
	/**
	 * Test method for append to check that an object is added properly.
	 */
	@Test
	public void testAppend1()
	{
		boolean expected = true;
		boolean actual = list.append(one);		
		assertEquals("Did not add element correctly, expected",expected,actual);
	}
	
	/**
	 * Test method for append to check proper element is stored in proper location.
	 */
	@Test
	public void testAppend2()
	{
		int expected = 11;
		list.append(one);
		Integer first = (Integer)list.get();
		int actual = first.intValue();		
		assertEquals("Value store was incorrect",expected,actual);
		assertEquals("The size of the list is not correct ",1,list.size());
	}
	
	/**
	 * Test method for append to check proper element is stored in proper location.
	 */
	@Test
	public void testAppend3()
	{
		int expected = 11;
		list.append(one);
		list.append(two);
		list.append(three);
		Integer first = (Integer)list.get();
		int actual = first.intValue();		
		assertEquals("Value store was incorrect",expected,actual);
		assertEquals("The size of the list is not correct ",3,list.size());
	}
	
	/**
	 * Test method for adding an object to the first position
	 * in the list and checking for the boolean.
	 */
	@Test
	public void testAddObject1()
	{
		boolean expected = true;
		boolean actual = list.append(one);		
		assertEquals("Did not add element correctly, expected",expected,actual);
		assertEquals("The size of the list is not correct ",1,list.size());
	}
	
	/**
	 * Test method for adding an object to the first position
	 * in the list and checking the increase in list size.
	 */
	@Test
	public void testAddObject2()
	{
		int expected = 11;
		list.append(one);
		list.append(two);
		Integer i = (Integer) list.get();
		int actual = i.intValue();		
		assertEquals("List size did not incease by one, expected",expected,actual);
		assertEquals("The size of the list is not correct ",2,list.size());
	}
	
	/**
	 * Test method for adding an object to the first position
	 * in the list and checking that the first item is correct.
	 */
	@Test
	public void testAddObject3()
	{
		int expected = 22;
		list.add(two);
		Integer first = (Integer)list.get();
		int actual = first.intValue();		
		assertEquals("Value store was incorrect.",expected,actual);
		assertEquals("The size of the list is not correct ",1,list.size());
	}
	
	/**
	 * Test method for the boolean return after adding an object
	 * at position zero in the list.
	 */
	@Test
	public void testAddObjectInt1()
	{
        boolean expected = true;
        boolean actual = list.add(one,0);
        assertEquals("Did not add node correctly to the list ",expected,actual);
        assertEquals("The size of the list is not correct ",1,list.size());
    }
	
	/**
	 * Test method for the boolean return after adding an object
	 * at position zero in the list.
	 */
	@Test
	public void testAddObjectInt2()
	{
		int expected = 11;
        list.add(five);
        list.add(four);
        list.add(two);
        list.add(three);
        list.add(one, 0);
        Integer added = (Integer)list.get(0);
        int actual = added.intValue();
        assertEquals("Did not add node correctly to the list ",expected,actual);
        assertEquals("The size of the list is not correct ",5,list.size());
    }
	
	/**
	 * Test method for the correct result being stored 
	 * after adding an object at position 2 in the list.
	 */
	@Test
	public void testAddObjectInt3()
	{
        int expected = 33;
        list.add(five);
        list.add(four);
        list.add(two);
        list.add(one);
        list.add(three, 2);
        Integer added = (Integer)list.get(2);
        int actual = added.intValue();
        assertEquals("Did not add node in the correct position ",expected,actual);
        assertEquals("The size of the list is not correct ",5,list.size());
    }
	
	/**
	 * Test method for the correct size after adding an object
	 * at position 2 in the list.
	 */
	@Test
	public void testAddObjectInt4()
	{
        int expected = 33;
        list.add(five);
        list.add(four);
        list.add(two);
        list.add(one);
        list.add(three, 4);
        Integer added = (Integer)list.get(4);
        int actual = added.intValue();
        assertEquals("Did not return the correct list size ",expected,actual);
        assertEquals("The size of the list is not correct ",5,list.size());
    }
	
	/**
	 * Test method for the IndexOutOfBoundsException
	 * being throw correctly.
	 */
	@Test
	public void testAddObjectInt5()
	{
        list.add(five);
        list.add(four);
        list.add(two);
        list.add(one);
        
        try
		{
        	list.add(three, 8);
			fail("IndexOutOfBoundsException should be raised as there is no position 8 in the list");
		} catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
    }

	/**
	 * Test method checking the list is empty.
	 */
	@Test
	public void testClear1()
	{
		list.append(one);
		list.append(two);
		list.append(three);		
		boolean expected = true;
		list.clear();
		boolean actual = list.isEmpty();
		assertEquals("Did not indicate correctly the list is empty ",expected,actual);
		assertEquals("The size of the list is not correct ",0,list.size());
	}
	
	/**
	 * Test method checking the list is empty and size is zero.
	 */
	@Test
	public void testClear2()
	{
		list.append(one);
		list.append(two);
		list.append(three);		
		int expected = 0;
		list.clear();
		int actual = list.size();
		assertEquals("Did not indicate correct list size ",expected,actual);
	}

	/**
	 * Test method for removing first element in list and 
	 * checking for the correct element being removed and
	 * returned.
	 */
	@Test
	public void testRemove1()
	{
		int expected = 11;
		list.append(one);
		list.append(two);
		list.append(three);
		
		Integer n = (Integer)list.remove();
		int actual = n.intValue();
		assertEquals("Did not remove correct object ",expected,actual);
		assertEquals("The size of the list is not correct ",2,list.size());
	}
	
	/**
	 * Test method for removing first element in list and 
	 * checking for the correct element being in the first
	 * position.
	 */
	@Test
	public void testRemove2()
	{
		int expected = 22;
		list.append(one);
		list.append(two);
		list.append(three);
		
		list.remove();
		Integer n = (Integer)list.get();
		int actual = n.intValue();
		assertEquals("The correct object was not in first position ",expected,actual);
		assertEquals("The size of the list is not correct ",2,list.size());
	}
	
	/**
	 * Test method for removing first element from an empty list.
	 */
	@Test
	public void testRemove3()
	{
		Object expected = null;
		Object actual = list.remove();
		assertEquals("The correct size of the list was not returned after the removal ",expected,actual);
		assertEquals("The size of the list is not correct ",0,list.size());
	}
	
	/**
	 * Test method for removing last element in list and 
	 * checking for the correct element being returned as
	 * deleted.
	 */
	@Test
	public void testRemoveLast1()
	{
		int expected = 55;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		Integer last = (Integer)list.removeLast();
		int actual = last.intValue();
		
		assertEquals("The correct element was not returned when removed from the end of list ",expected,actual);
		assertEquals("The size of the list is not correct ",4,list.size());
	}
	
	/**
	 * Test method for removing last element in list and 
	 * checking for the correct element being in the last
	 * position.
	 */
	@Test
	public void testRemoveLast2()
	{
		int expected = 44;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		list.removeLast();
		Integer last = (Integer)list.getLast();
		int actual = last.intValue();
		
		assertEquals("The correct element was not found at the end of list ",expected,actual);
		assertEquals("The size of the list is not correct ",4,list.size());
	}
	
	/**
	 * Test method for removing last element from an empty list.
	 */
	@Test
	public void testRemoveLast3()
	{
		Object expected = null;
		Object actual = list.removeLast();
		assertEquals("The method didn't return null after the removal ",expected,actual);
		assertEquals("The size of the list is not correct ",0,list.size());
	}
	
	/**
	 * Test method for removing an element in the list 
	 * from a selected position and checking to see if
	 * that element removed was correctly returned.
	 */
	@Test
	public void testRemoveInt1()
	{
		int expected = 44;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		Integer item = (Integer)list.remove(3);
		int actual = item.intValue();
		assertEquals("The correct value of the element was not found after removal ",expected,actual);
		assertEquals("The size of the list is not correct ",4,list.size());
	}
	
	/**
	 * Test method for removing an element in the list 
	 * from a selected position and checking to see if
	 * that element removed was correctly returned.
	 */
	@Test
	public void testRemoveInt2()
	{
		int expected = 11;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		Integer item = (Integer)list.remove(0);
		int actual = item.intValue();
		assertEquals("The correct value of the element was not found after removal ",expected,actual);
		assertEquals("The size of the list is not correct ",4,list.size());
	}
	
	/**
	 * Test method for removing an element in the list 
	 * from a selected position and checking to see if
	 * the size of the list was correctly adjusted.
	 */
	@Test
	public void testRemoveInt3()
	{
		int expected = 55;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		Integer i = (Integer) list.remove(4);
		int actual = i.intValue();
		
		assertEquals("The correct correct element was removed from the end of the list ",expected,actual);
		assertEquals("The size of the list is not correct ",4,list.size());
	}
	
	/**
	 * Test method for removing an element in the list 
	 * from a selected position and checking to see if
	 * that element removed was correctly returned.
	 */
	@Test
	public void testRemoveInt4()
	{
		list.add(five);
        list.add(four);
        list.add(three);
        list.add(two);
        list.add(one);
        
        try
		{
        	list.remove(8);
			fail("IndexOutOfBoundsException should be raised as there is no position 8 in the list");
		} catch (IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for removing last element from an empty list.
	 */
	@Test
	public void testRemoveInt5()
	{
		Object expected = null;
		Object actual = list.remove(0);
		assertEquals("The method didn't return null after the removal ",expected,actual);
		assertEquals("The size of the list is not correct ",0,list.size());
	}
	
	/**
	 * Test method for removing an element in the list 
	 * from a selected position and checking to see if
	 * the element now at that position is correct.
	 */
	@Test
	public void testRemoveInt6()
	{
		int expected = 44;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		list.remove(2);
		Integer i = (Integer) list.get(2);
		int actual = i.intValue();
		
		assertEquals("The correct correct element was removed from the end of the list ",expected,actual);
		assertEquals("The size of the list is not correct ",4,list.size());
	}

	/**
	 * Test method for the return of the correct 
	 * object value.
	 */
	@Test
	public void testGet1()
	{
		int expected = 11;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		Integer value = (Integer)list.get();		
		int actual = value.intValue();		
		assertEquals("Didn't find the correct value returned ",expected,actual);
	}
	
	/**
	 * Test method for the return of the correct 
	 * object value.
	 */
	@Test
	public void testGet2()
	{
		Object expected = null;
		Object actual = list.get();		
		assertEquals("Didn't find the correct value returned ",expected,actual);
	}

	/**
	 * Test method for checking for the correct value
	 * return from the last position in the list.
	 */
	@Test
	public void testGetLast1()
	{
		int expected = 55;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		Integer value = (Integer)list.getLast();
		int actual = value.intValue();		
		assertEquals("Didn't return the correct value from the list ",expected,actual);
	}
	
	/**
	 * Test method for checking for the correct value
	 * return from the last position in the list.
	 */
	@Test
	public void testGetLast2()
	{
		Object expected = null;
		Object actual = list.get();			
		assertEquals("Didn't return the correct value from the list ",expected,actual);
	}

	/**
	 * Test method for getting an object at a specific
	 * index position in the list.
	 */
	@Test
	public void testGetInt1()
	{
		int expected = 44;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		Integer value = (Integer)list.get(3);
		int actual = value.intValue();		
		assertEquals("Didn't find the correct value returned from the list ",expected,actual);
	}
	
	/**
	 * Test method for getting an object at a specific
	 * index position in the list.
	 */
	@Test
	public void testGetInt2()
	{
		int expected = 11;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		Integer value = (Integer)list.get(0);
		int actual = value.intValue();		
		assertEquals("Didn't find the correct value returned from the list ",expected,actual);
	}
	
	/**
	 * Test method for getting an object at a specific
	 * index position in the list.
	 */
	@Test
	public void testGetInt3()
	{
		int expected = 55;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		Integer value = (Integer)list.get(4);
		int actual = value.intValue();		
		assertEquals("Didn't find the correct value returned from the list ",expected,actual);
	}
	
	/**
	 * Test method for getting an object at a specific
	 * index position in the list when it is empty.
	 */
	@Test
	public void testGetInt4()
	{
		Object expected = null;
		Object actual = list.get(0);		
		assertEquals("Didn't find the correct value returned from the list ",expected,actual);
	}

	/**
	 * Test method checks for the boolean returned,
	 * in this case, true because the object is in
	 * the list.
	 */
	@Test
	public void testContains1()
	{
		boolean expected = true;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		boolean actual = list.contains(four);		
		assertEquals("Didn't find the correct value in the list ",expected,actual);
	}
	
	/**
	 * Test method checks for the boolean returned,
	 * in this case, false because the object is not
	 * in the list.
	 */
	@Test
	public void testContains2()
	{
		boolean expected = false;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(five);
		
		boolean actual = list.contains(four);		
		assertEquals("Did find the value in the list but should not have ",expected,actual);
	}

	/**
	 * Test method checking for the correct index being
	 * returned of the correct position in the list.
	 */
	@Test
	public void testIndexOf1()
	{
		int expected = 0;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		int actual = list.indexOf(one);		
		assertEquals("Didn't find the correct index value returned from the list ",expected,actual);
	}
	
	/**
	 * Test method checking for the correct index being
	 * returned of the correct position in the list.
	 */
	@Test
	public void testIndexOf2()
	{
		int expected = 2;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		int actual = list.indexOf(three);		
		assertEquals("Didn't find the correct index value returned from the list ",expected,actual);
	}
	
	/**
	 * Test method checking for the correct index being
	 * returned of the correct position in the list.
	 */
	@Test
	public void testIndexOf3()
	{
		int expected = 4;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		int actual = list.indexOf(five);		
		assertEquals("Didn't find the correct index value returned from the list ",expected,actual);
	}

	/**
	 * Test method checking for the correct size of the list.
	 */
	@Test
	public void testSize1()
	{
		int expected = 5;
		list.append(one);
		list.append(two);
		list.append(three);
		list.append(four);
		list.append(five);
		
		int actual = list.size();		
		assertEquals("Append didn't increment size properly ",expected,actual);
	}
	
	/**
	 * Test method checking for the correct size of the list.
	 */
	@Test
	public void testSize2()
	{
		int expected = 5;
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		list.add(five);
		
		int actual = list.size();		
		assertEquals("Add didn't increment size properly ",expected,actual);
	}
	
	/**
	 * Test method checking for the correct size of the list.
	 */
	@Test
	public void testSize3()
	{
		int expected = 5;
		list.add(one,0);
		list.add(two,1);
		list.add(three,2);
		list.add(four,3);
		list.add(five,4);
		
		int actual = list.size();		
		assertEquals("Add at a position didn't increment size properly ",expected,actual);
	}
	
	/**
	 * Test method checking for the correct size of the list.
	 */
	@Test
	public void testSize4()
	{
		int expected = 3;
		list.add(one,0);
		list.add(two,1);
		list.add(three,2);
		list.add(four,3);
		list.add(five,4);
		list.remove();
		list.remove();
		
		int actual = list.size();		
		assertEquals("Remove didn't decrement size properly ",expected,actual);
	}
	
	/**
	 * Test method checking for the correct size of the list.
	 */
	@Test
	public void testSize5()
	{
		int expected = 3;
		list.add(one,0);
		list.add(two,1);
		list.add(three,2);
		list.add(four,3);
		list.add(five,4);
		list.removeLast();
		list.removeLast();
		
		int actual = list.size();		
		assertEquals("RemoveLast didn't decrement size properly ",expected,actual);
	}
	
	/**
	 * Test method checking for the correct size of the list.
	 */
	@Test
	public void testSize6()
	{
		int expected = 3;
		list.add(one,0);
		list.add(two,1);
		list.add(three,2);
		list.add(four,3);
		list.add(five,4);
		list.remove(1);
		list.remove(3);
		
		int actual = list.size();		
		assertEquals("Remove at a position didn't decrement size properly ",expected,actual);
	}

	/**
	 * Test method for checking if the list is empty
	 * or not.
	 */
	@Test
	public void testIsEmpty1()
	{
		boolean expected = true;
		boolean actual = list.isEmpty();
		assertEquals("Remove at a position didn't decrement size properly ",expected,actual);
	}
	
	/**
	 * Test method for checking if the list is empty
	 * or not.
	 */
	@Test
	public void testIsEmpty2()
	{
		boolean expected = false;
		list.add(one,0);
		list.add(two,1);
		list.add(three,2);
		list.add(four,3);
		
		boolean actual = list.isEmpty();
		assertEquals("Remove at a position didn't decrement size properly ",expected,actual);
	}

}

