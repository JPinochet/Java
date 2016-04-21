/**
 * 
 */
package fileHandling;

/**
 * @author 432873
 *
 */

import java.io.*;
public class FileInput 
{
	//Attributes
	private File			file;
	private FileReader 		fr;
	private BufferedReader	in;
	
	//Constructors
	/*
	 * Default Constructor
	 */
	public FileInput()
	{
	}
	
	/**
	 * User defined constructor to open a file
	 * given the name and location of a file as
	 * string parameter.
	 * 
	 * @param String fileName - name of input file
	 */
	public FileInput(String fileName)
	{
		try
		{
			file = new File(fileName);
			fr = new FileReader(file);
			in = new BufferedReader(fr);
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe);
			System.exit(1);
		}
	}
	//Operational Methods
	/**
	 * Method to read a line from the text 
	 * file as a string and return that string to 
	 * the calling method.
	 */
	public String readLine()
	{
		String line = null;
		try
		{
			line = in.readLine();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		return line;
	}
	
	/**
	 * Method to close the input data file;
	 */
	public void closeInputFile()
	{
		try
		{
			in.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
