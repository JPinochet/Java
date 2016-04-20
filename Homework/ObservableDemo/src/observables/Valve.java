/**
 * 
 */
package observables;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 432873
 *
 */
public class Valve implements Observer
{
	//Constants
	private final int LOWER = 50;
	private final int UPPER = 125;

	@Override
	public void update(Observable p, Object arg)
	{
		Pipe pipe = (Pipe)p;
		
		if(pipe.getPressure() <= LOWER)
		{
			System.out.println("Closing Valve, pressure at "+pipe.getPressure());
		}
		else if (pipe.getPressure() >= UPPER)
		{
			System.out.println("Opening Valve, pressure at "+pipe.getPressure());
		}
		else
		{
			System.out.println("Pressure Normal at "+pipe.getPressure());
		}
	}
}
