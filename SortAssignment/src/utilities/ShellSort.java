/**
 * 
 */
package utilities;

/**
 * @author 432873
 * Class that sorts comparable arrays using the shell algorithm.
 * The complexity analysis for the shall sort is an O(nlogn) notation.
 */
public class ShellSort
{
	/**
	 * A simple constructor.
	 */
	public ShellSort()
	{
		
	}
	
    /**
     * Shellsort, using a sequence suggested by Gonnet.
     * @param a an array of Comparable items.
     */
    @SuppressWarnings("unchecked")
	public static void shellSort(Comparable []a, int b)
    {
        for( int gap = a.length / 2; gap > 0;
                     gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
            for( int i = gap; i < a.length; i++ )
            {
                Comparable tmp = a[ i ];
                int j = i;

                for( ; j >= gap && tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
                    a[ j ] = a[ j - gap ];
                a[ j ] = tmp;
            }
    }
}
