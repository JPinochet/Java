/**
 * Created on Aug 1, 2006
 *
 * Project: threadExample
 */
package threadReviewExercise;

/**
 * @author dwatson
 * @version 1.0
 * 
 */
public class Student
{
	//Attribute
	private long 		id;
	private double		mark;
	
	//Constructors
	/**
	 * Default constructor
	 */	
	public Student()
	{
		
	}
	/**
	 * User defined constructor.
	 * @param id holds student id number
	 * @param mark holds student test mark
	 */
	public Student(long id, double mark)
	{
		this.id = id;
		this.mark = mark;
	}
	
	//Getters and Setters
	/**
	 * @return Returns the id.
	 */
	public long getId()
	{
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(long id)
	{
		this.id = id;
	}
	/**
	 * @return Returns the mark.
	 */
	public double getMark()
	{
		return mark;
	}
	/**
	 * @param mark The mark to set.
	 */
	public void setMark(double mark)
	{
		this.mark = mark;
	}
	
	//Operational Methods
	public String toString()
	{
		return id+" "+mark;
	}
	

}
