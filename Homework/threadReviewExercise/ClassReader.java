/**
 * Created on Aug 1, 2006
 *
 * Project: threadExample
 */
package threadReviewExercise;

import fileHandling.*;
import java.util.*;

/**
 * @author dwatson
 * @version 1.0
 * 
 */
public class ClassReader extends Observable implements Runnable
{
	//Attributes
	private FileInput			fin;
	private String				fileName;
	private int					classNum;
	private static int			counter;

	/**
	 * User defined constructor.
	 * @param fileName name of file being read from.
	 */
	public ClassReader(String fileName)
	{
		this.fileName = "res/"+fileName;
		classNum = ++counter;
	}
	
	/**
	 * @return Returns the classNum.
	 */
	public int getClassNum()
	{
		return classNum;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		fin = new FileInput(fileName);
		
		String line = fin.readLine();
		
		while(line != null)
		{
			Student student = parseData(line);
			setChanged();
			notifyObservers(student);
			line = fin.readLine();
			
			try
			{
				Thread.sleep((long)(Math.random()*500));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		fin.closeInputFile();
	}
	
	public synchronized Student parseData(String line)
	{
		StringTokenizer st = new StringTokenizer(line);
		return new Student(Long.parseLong(st.nextToken()),
				Double.parseDouble(st.nextToken()));
	}
}
