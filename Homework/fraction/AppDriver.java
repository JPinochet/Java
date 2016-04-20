/**
 * 
 */
package fraction;

/**
 * @author 432873
 *
 */
public class AppDriver
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		WholeFraction wf = new WholeFraction(6, 5, 9);
		System.out.println(wf);
		
		Fraction f = wf;
		System.out.println(f);
		
		Fraction frac = new WholeFraction(3, 5, 6);
		System.out.println(frac);
	}

}
