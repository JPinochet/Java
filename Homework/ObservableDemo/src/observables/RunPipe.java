/**
 * 
 */
package observables;

/**
 * @author 432873
 *
 */
public class RunPipe
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Pipe pipe = new Pipe();
		Valve v1 = new Valve();
		Valve v2 = new Valve();
		
		pipe.addObserver(v1);
		pipe.addObserver(v2);
		
		pipe.setPressure(145);
		pipe.setPressure(29);
		pipe.setPressure(65);
	}

}
