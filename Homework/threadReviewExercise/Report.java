/**
 * Created on Aug 1, 2006
 *
 * Project: threadExample
 */
package threadReviewExercise;

import java.util.Observable;
import java.util.Observer;

/**
 * @author dwatson
 * @version 1.0
 * 
 */
public class Report implements Observer
{
	//Attributes
	private double			total1;
	private double			total2;
	private int				count1;
	private int 			count2;

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public synchronized void update(Observable o, Object s)
	{
		ClassReader cr = (ClassReader)o;
		Student student = (Student)s;
		
		System.out.println("Class "+cr.getClassNum()+"   "+student);
		
		if(cr.getClassNum() == 1)
		{
			total1 += student.getMark();
			count1++;
		}
		else
		{
			total2 += student.getMark();
			count2++;
		}		
	}
	
	public void classAverage()
	{
		System.out.println("\nClass 1 average "+total1 / count1);
		System.out.println("Class 2 average "+total2 / count2);
	}
	
	public void overallAverage()
	{
		double total = total1 + total2;
		int count = count1 + count2;
		System.out.println("Overall average "+total / count);
	}

}
