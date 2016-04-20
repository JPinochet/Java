/**
 * Apr 6, 2009
 *
 */
package chapterFive;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 * 
 * A class that describes the effects of an earthquake.
 */
public class Earthquake
{
	//Attributes
	private double richter;
	
	/**
	 * Constructs an Earthquake object.
	 * @param magnitude the magnitude on the Richter scale
	 */
	public Earthquake(double magnitude)
	{
		richter = magnitude;
	}
	
	/**
	 * Gets a description of the effect of the earthquake.
	 * @return the description of the effect
	 */
	public String getDescription()
	{
		String r = null;
		if(richter >= 8.0)
			r = "Most structures fall";
		else if (richter >= 7.0)
			r = "Many buildings destroyed";
		else if (richter >= 6.0)
			r = "Many buildigns considerably damaged, some collapse";
		else if (richter >= 4.5)
			r = "Damage to poorly constructed buildings";
		else if (richter >= 3.5)
			r = "Felt by many pepople, no destruction";
		else if (richter >= 0)
			r = "Generally not felt by people";
		else
			r = "Negative numbers are not valid";		
		
		return r;
	}
	
}
