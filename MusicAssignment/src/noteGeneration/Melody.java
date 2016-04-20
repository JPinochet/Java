/**
 * 
 */
package noteGeneration;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.Note;
import fileHandling.FileInput;

/**
 * @author 432873
 * No clue what makes melody different from song... basically just use compare
 */
public class Melody
{
	public Piano piano = new Piano();
	public Note note = new Note(0);
	
	/**
	 * Simple constructor to be able to use song to play music using this class.
	 */
	public Melody()
	{
		
	}
	
	/**
	 * This method takes in the name of the file (path must be included), reads in the file and plays the notes 
	 * inside the files.
	 * 
	 * @param file the file to read in from the res directory.
	 */
	public void loadMelody(String file)
	{	
		FileInput fin = new FileInput(file);
		String line = fin.readLine();
		String note;
		
		while(line != null)
		{
			StringTokenizer st = new StringTokenizer(line,",");
			while(st.hasMoreElements())
			{
				note = st.nextToken();
				playNote(note);
			}
			line = fin.readLine();
		}
	}
	
	/**
	 * This method actually plays the music, however the sleep method is invoked when the appropriate 
	 * characters are read in(r and r-)
	 * 
	 * @param input the note to be played.
	 */
	private void playNote(String input) 
	{
		if(input.length() == 0)
		{
		}
		else if(input.length() == 1)
		{
			Pattern inputPattern = Pattern.compile("^[-rR]");
			Matcher matchPattern = inputPattern.matcher(input);
			
			if(matchPattern.find())
			{
				char found = input.toLowerCase().charAt(0);
				
				switch(found)
				{
					case 'r': sleep(200); break;
					case '-': sleep(400); break;
				}
			}
		}
		else if(input.length() == 2)
		{
			if(input.charAt(0) == 'r' && input.charAt(1) == '-')
			{
				Pattern inputPattern = Pattern.compile("^[-rR]");
				Matcher matchPattern = inputPattern.matcher(input);
				
				if(matchPattern.find())
				{
					char found = input.toLowerCase().charAt(0);
					
					switch(found)
					{
						case 'r': sleep(200); break;
						case '-': sleep(400); break;
					}
				}
			}
			else
			{
				try
				{
					note = new Note(input);
					piano.playNote(note.getMIDIAbsoluteNumber(), 50);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
		else if(input.length() == 3)
		{
			if(input.charAt(2) == '-')
			{
				try
				{
					String s = input.substring(0,2);
					note= new Note(s);
					piano.playNote(note.getMIDIAbsoluteNumber(),400);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
			else
			{
				try
				{
					note = new Note(input);
					piano.playNote(note.getMIDIAbsoluteNumber(),100);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
		else if(input.length()==4)
		{
			if(input.charAt(3)=='-')
			{
				try
				{
					String s = input.substring(0,3);
					note= new Note(s);
					piano.playNote(note.getMIDIAbsoluteNumber(),400);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
			else
			{
				try
				{
					note = new Note(input);
					piano.playNote(note.getMIDIAbsoluteNumber(), 100);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
		else if(input.length()==5)
		{
			try
			{
				String s = input.substring(0,4);
				note= new Note(s);
				piano.playNote(note.getMIDIAbsoluteNumber(),400);
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Puts the current thread to sleep for a certain amount of time
	 * 
	 * @param pause the amount of time to stop the thread.
	 */
	private void sleep(int pause)
	{
	       try
	       {
	    	   Thread.sleep(pause);
	       }
	       catch(InterruptedException ie)
	       {
	    	   ie.printStackTrace();
	       }
	}
}
