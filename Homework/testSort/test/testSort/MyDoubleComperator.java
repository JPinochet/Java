/**
 * Mar 27, 2009
 */
package testSort;

import java.util.*;

/**
 * Jorge Pinochet
 * @author 432873
 * version 1.0
 */
public class MyDoubleComperator implements Comparator
{

	@Override
	public int compare(Object a, Object b)
	{
		
		return (int)(((MyDouble)a).getValue() -((MyDouble)b).getValue()) ;
	}
}
