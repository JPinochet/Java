<<<<<<< HEAD
/**
 * 
 */
package simpleFrame;

import javax.swing.JFrame;

/**
 * @author 432873
 * Class creates a simple frame with a compareTo interface in it.
 */
public class SimpleFrame extends JFrame implements Comparable<SimpleFrame>
{
	private static final long	serialVersionUID	= -1247582827072276538L;
	private char 				compareType;

	/**
	 * Creates a SimpleFrame Object with a defined compare type.
	 * 
	 * @param cType the variable that identifies how to compare one SimpleFrame object with another and also creates 
	 * another frame.
	 */
	public SimpleFrame(char cType)
	{
		super();
		this.compareType = cType;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(SimpleFrame o)
	{
		int diff;
		
		switch(compareType)
		{
			case 'w': 
				diff = this.getWidth() - o.getWidth();
				return diff;
			case 'h': 
				diff = this.getHeight() - o.getHeight();
				return diff;
			case 'a':
				int thisArea = this.getHeight() * this.getWidth();
				int oArea = o.getHeight() * o.getWidth();
				diff = thisArea - oArea;
				return diff;
			case 'c':
				diff = this.getBackground().getRGB() - this.getBackground().getRGB();
				return diff;
		}
		return -1;
	}

	public char getCompareType()
	{
		return compareType;
	}

	public void setCompareType(char compareType)
	{
		this.compareType = compareType;
	}
}
=======
/**
 * 
 */
package simpleFrame;

import javax.swing.JFrame;

/**
 * @author 432873
 * Class creates a simple frame with a compareTo interface in it.
 */
public class SimpleFrame extends JFrame implements Comparable<SimpleFrame>
{
	private static final long	serialVersionUID	= -1247582827072276538L;
	private char 				compareType;

	/**
	 * Creates a SimpleFrame Object with a defined compare type.
	 * 
	 * @param cType the variable that identifies how to compare one SimpleFrame object with another and also creates 
	 * another frame.
	 */
	public SimpleFrame(char cType)
	{
		super();
		this.compareType = cType;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(SimpleFrame o)
	{
		int diff;
		
		switch(compareType)
		{
			case 'w': 
				diff = this.getWidth() - o.getWidth();
				return diff;
			case 'h': 
				diff = this.getHeight() - o.getHeight();
				return diff;
			case 'a':
				int thisArea = this.getHeight() * this.getWidth();
				int oArea = o.getHeight() * o.getWidth();
				diff = thisArea - oArea;
				return diff;
			case 'c':
				diff = this.getBackground().getRGB() - this.getBackground().getRGB();
				return diff;
		}
		return -1;
	}

	public char getCompareType()
	{
		return compareType;
	}

	public void setCompareType(char compareType)
	{
		this.compareType = compareType;
	}
}
>>>>>>> origin/master
