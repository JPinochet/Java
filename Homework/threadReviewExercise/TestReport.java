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
public class TestReport
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Report rpt = new Report();
		
		ClassReader cr1 = new ClassReader("class1.txt");
		ClassReader cr2 = new ClassReader("class2.txt");
		
		cr1.addObserver(rpt);
		cr2.addObserver(rpt);
		
		Thread t1 = new Thread(cr1);
		Thread t2 = new Thread(cr2);
		
		t1.start();
		t2.start();
		
		while(t1.isAlive() || t2.isAlive());
		
		rpt.classAverage();
		rpt.overallAverage();
	}

}
