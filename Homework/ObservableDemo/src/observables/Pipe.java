/**
 * 
 */
package observables;

import java.util.Observable;

/**
 * @author 432873
 *
 */
public class Pipe extends Observable
{
	//Attributes
	private int 		pressure;
	
	//Constructor
	public Pipe()
	{
		
	}
	
	public int getPressure()
	{
		return pressure;
	}
	
	public void setPressure(int pressure)
	{
		this.pressure = pressure;
		setChanged();
		notifyObservers();
	}
}
