/**
 * 
 */
package test;

import exceptions.InvalidNoteStringException;
import junit.framework.TestCase;
import utilities.*;

/**
 * @author 432873
 *
 */
public class TestNote extends TestCase
{
	boolean test = false;
	
	public void testConstructor()
	{
		try
		{
			Note note = new Note("C#-1");
			int testMidiValue = note.getMIDIAbsoluteNumber();
			if(testMidiValue == 1)
			{
				test = true;
			}
			assertTrue(test);
		}
		catch(InvalidNoteStringException inse)
		{
			inse.printStackTrace();
		}
	}
	
	public void testConstructor2()
	{
		try
		{
			Note note = new Note("Cb-1");
			int testMidiValue = note.getMIDIAbsoluteNumber();
			if(testMidiValue == 0)
			{
				test = true;
			}
			assertTrue(test);
		}
		catch(InvalidNoteStringException inse)
		{
			inse.printStackTrace();
		}
	}
	
	public void testConstructor3()
	{
		try
		{
			Note note = new Note("G#9");
			int testMidiValue = note.getMIDIAbsoluteNumber();
			if(testMidiValue == 127)
			{
				test = true;
			}
			assertTrue(test);
		}
		catch(InvalidNoteStringException inse)
		{
			inse.printStackTrace();
		}
	}
	
	public void testConstructor4()
	{
		Note note = new Note(-400);
		int testMidiValue = note.getMIDIAbsoluteNumber();
		if(testMidiValue == 40)
		{
			test = true;
		}
		assertTrue(test);
	}
	public void testConstructor5() throws InvalidNoteStringException
	{
		Note note = new Note(-480);
		int testMidiValue = note.getMIDIAbsoluteNumber();
		if(testMidiValue == 0)
		{
			test = true;
		}
		assertTrue(test);
	}
	public void testConstructor6()
	{
		Note note = new Note(-310);
		int testMidiValue = note.getMIDIAbsoluteNumber();
		if(testMidiValue == 127)
		{
			test = true;
		}
		assertTrue(test);
	}
	
	public void testConstructor7()
	{
		Note note = new Note(440.00);
		int testMidiValue = note.getMIDIAbsoluteNumber();
		if(testMidiValue == 69)
		{
			test = true;
		}
		assertTrue(test);
	}
	
	public void testConstructor8()
	{
		Note note = new Note(1.50);
		int testMidiValue = note.getMIDIAbsoluteNumber();
		if(testMidiValue == 0)
		{
			test = true;
		}
		assertTrue(test);
	}
	
	public void testConstructor9()
	{
		Note note = new Note(5000.00);
		int testMidiValue = note.getMIDIAbsoluteNumber();
		if(testMidiValue == 127)
		{
			test = true;
		}
		assertTrue(test);
	}
	
	public void testCompareTo()
	{
		try
		{
			Note note = new Note("A#-1");
			Note note2 = new Note("C#-1");
			
			int testDifference = note.compareTo(note2);
			
			if(testDifference != 0)
			{
				test = true;
			}
			assertTrue(test);
		}
		catch (InvalidNoteStringException e)
		{
			e.printStackTrace();
		}
	}
	
	public void testCompareTo2()
	{
		try
		{
			Note note = new Note("C#-1");
			Note note2 = new Note("C#-1");
			
			int testDifference = note.compareTo(note2);
			
			if(testDifference == 0)
			{
				test = true;
			}
			assertTrue(test);
		}
		catch (InvalidNoteStringException e)
		{
			e.printStackTrace();
		}
	}
	
	public void testCompareTo3()
	{
		try
		{
			Note note = new Note("C#-1");
			Note note2 = new Note("Db-1");
			
			int testDifference = note.compareTo(note2);
			
			if(testDifference != 0)
			{
				test = true;
			}
			assertTrue(test);
		}
		catch (InvalidNoteStringException e)
		{
			e.printStackTrace();
		}
	}
	
	public void testFormOctave()
	{
		try
		{
			Note note = new Note("C0");
			Note note2 = new Note("C1");
			
			if(note.formOctave(note2))
			{
				test = true;
			}
			assertTrue(test);
		}
		catch (InvalidNoteStringException e)
		{
			e.printStackTrace();
		}
	}
	
	public void testFormOctave2()
	{
		try
		{
			Note note = new Note("C#2");
			Note note2 = new Note("C9");
			
			if(note.formOctave(note2))
			{
				test = true;
			}
			assertTrue(test);
		}
		catch (InvalidNoteStringException e)
		{
			e.printStackTrace();
		}
	}
	
	public void testModifyNoteBySemitones()
	{
		try
		{
			Note note = new Note("A4");
			note.modifyNoteBySemitones(50);
			
			if(note.getMIDIAbsoluteNumber() == 490)
			{
				test = true;
			}
			assertTrue(test);
		}
		catch (InvalidNoteStringException e)
		{
			e.printStackTrace();
		}
	}
}
