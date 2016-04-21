package fileHandling;
/**
 * @author 432873
 *
 */
import java.io.*;

public class FileOutput 
{
	private File			file;
	private FileWriter		fw;
	private PrintWriter		out;
	
	/**
	 * Default Constructor
	 */
	public FileOutput()
	{
	}
	
	/**
	 * 
	 */
	
	public FileOutput(String fileName)
	{
		try 
		{
			file = new File(fileName);
			fw = new FileWriter(file);
			out = new PrintWriter(fw);
		}
		catch (IOException e)
		{
			System.out.println("Could not create output file "+fileName);
			System.exit(1);
		}
	}
	
	public FileOutput(String fileName, boolean append)
	{
		try
		{
			file = new File(fileName);
			fw = new FileWriter(file, append);
			out = new PrintWriter(fw);
		}
		catch (IOException e)
		{
			System.out.println("Could not create output file"+fileName);
			System.exit(1);
		}
	}
	public void print (String a)
	{
		out.print(a);
	}
	
	public void print(int a)
	{
		out.print(a);
	}
	public void print(double a)
	{
		out.print(a);
	}
	public void print(char a)
	{
		out.print(a);
	}
	public void print(long a)
	{
		out.print(a);
	}
	public void print(float a)
	{
		out.print(a);
	}
	public void print(Object a)
	{
		out.print(a);
	}
	public void println (String a)
	{
		out.print(a);
	}
	
	public void println(int a)
	{
		out.println(a);
	}
	public void println(double a)
	{
		out.println(a);
	}
	public void println(char a)
	{
		out.println(a);
	}
	public void println(long a)
	{
		out.println(a);
	}
	public void println(float a)
	{
		out.println(a);
	}
	public void println(Object a)
	{
		out.println(a);
	}
	public void closeOutputFile()
	{
		out.close();
	}
}
