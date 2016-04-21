/**
 * Feb 19, 2009
 */
package formatColumns;

/**
 * @author 432873
 *
 */
/**
 * Utility Class to format table columns based on formating all data types to
 * strings
 *
 * @author Dave Watson
 * @version 1.0
 */

import java.text.*;

public class Column
{
  /**
   * Method to center a string in a column of size
   * specified by the user.
   *
   * @param s a String to be centered in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the string centered 
	* in the column
   */
  public static String center(String s, int columnSize)
  {
    int length, start;
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();
    
    if(length > columnSize)
    {
    	String sc = s.substring(0,columnSize);
		sb = new StringBuffer(sc);
	}	
	else
    {
    	start = (columnSize - length) / 2 + columnSize % 2;    
	
    	sb.replace(start,start + length, s);    
	}

    return sb.toString();
  }

  /**
   * Method to center a integer in a column of size
   * specified by the user.
   *
   * @param n a int to be centered in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the int centered 
	* in the column
   */
  public static String center(int n, int columnSize)
  {
    int length, start;
    String s = null;
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    s = Integer.toString(n);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = (columnSize - length) / 2 + columnSize % 2;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

  /**
   * Method to center a long in a column of size
   * specified by the user.
   *
   * @param n a long to be centered in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the long centered 
	* in the column
   */
  public static String center(long n, int columnSize)
  {
    int length, start;
    String s = null;
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    s = Long.toString(n);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = (columnSize - length) / 2 + columnSize % 2;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

   /**
   * Method to center a double in a column of size
   * specified by the user and number of decimal
   * places specified by the user.
   *
   * @param n a double to be centered in a column
   * @param columnSize an int representing the size
	* of the column
	* @param numDecimals int containing the number of
	* required decimal places in the real number.
	* @param money boolean if true places a $ at the in
	* the value and if false no $.
   *
   * @return a String representing the double centered 
	* in the column
   */
  public static String center(double n, int columnSize,
                        int numDecimals, boolean money)
  {
    int length, start;
    String s = null, fmtstr = "0.";
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    for(int i = 0; i < numDecimals; i++)
    {
      fmtstr = fmtstr+"0";
    }

    DecimalFormat fmt = new DecimalFormat(fmtstr);
    s = fmt.format(n);

    if(money == true)
    {
      s = "$" + s;
    }

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = (columnSize - length) / 2;

    if(start % 2 != 0)
    {
      start++;
    }

    sb.replace(start,start + length, s);

    return sb.toString();
  }

  /**
   * Method to center a character in a column of size
   * specified by the user.
   *
   * @param n a char to be centered in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the character centered 
	* in the column
   */
  public static String center(char c, int columnSize)
  {
    int length, start;
    String s = " ";
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    s = s + c;

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = (columnSize - length) / 2 + columnSize % 2;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

  //********************** LEFT JUSTIFICATION *******************/

  /**
   * Method to left justify a string in a column of size
   * specified by the user.
   *
   * @param s a String to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the string left justified 
	* in the column
   */
  public static String leftJustify(String s, int columnSize)
  {
    int length, start;
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();
    
    if(length > columnSize)
    {
    	String sc = s.substring(0,columnSize);
		sb = new StringBuffer(sc);
	}	
	else
    {
    	start = 0;
    	sb.replace(start,start + length, s);
	}

    return sb.toString();
  }

  /**
   * Method to left  justify a integer in a column of size
   * specified by the user.
   *
   * @param n a int to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the int left justified 
	* in the column
   */
  public static String leftJustify(int n, int columnSize)
  {
    int length, start;
    String s = null;
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    s = Integer.toString(n);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = 0;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

  /**
   * Method to left justify a long in a column of size
   * specified by the user.
   *
   * @param n a long to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the long left justified 
	* in the column
   */
  public static String leftJustify(long n, int columnSize)
  {
    int length, start;
    String s = null;
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    s = Long.toString(n);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = 0;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

   /**
   * Method to left justify a double in a column of size
   * specified by the user and number of decimal
   * places specified by the user.
   *
   * @param n a double to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
	* @param numDecimals int containing the number of
	* required decimal places in the real number.
	* @param money boolean if true places a $ at the in
	* the value and if false no $.
   *
   * @return a String representing the double left justified 
	* in the column
   */
  public static String leftJustify(double n, int columnSize,
                            int numDecimals, boolean money)
  {
    int length, start;
    String s = null, fmtstr = "0.";
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    for(int i = 0; i < numDecimals; i++)
    {
      fmtstr = fmtstr+"0";
    }

    DecimalFormat fmt = new DecimalFormat(fmtstr);
    s = fmt.format(n);

    if(money == true)
    {
      s = "$" + s;
    }

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = 0;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

  /**
   * Method to left justify a character in a column of size
   * specified by the user.
   *
   * @param n a char to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the character left 
	* justified in the column
   */
  public static String leftJustify(char c, int columnSize)
  {
    int length, start;
    String s = "";
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    s = s+c;

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = 0;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

  //********************** RIGHT JUSTIFICATION *******************/

  /**
   * Method to right justify a string in a column of size
   * specified by the user.
   *
   * @param s a String to be right justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the string right justified 
	* in the column
   */
  public static String rightJustify(String s, int columnSize)
  {
    int length, start;
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();
    
    if(length > columnSize)
    {
    	String sc = s.substring(0,columnSize);
		sb = new StringBuffer(sc);
	}	
	else
    {
    	start = columnSize - length;
    	sb.replace(start,start + length, s);
    }

    return sb.toString();
  }

  /**
   * Method to right  justify a integer in a column of size
   * specified by the user.
   *
   * @param n a int to be right justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the int right justified 
	* in the column
   */
  public static String rightJustify(int n, int columnSize)
  {
    int length, start;
    String s = null;
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    s = Integer.toString(n);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = columnSize - length;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

  /**
   * Method to right justify a long in a column of size
   * specified by the user.
   *
   * @param n a long to be right justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the long right justified 
	* in the column
   */
  public static String rightJustify(long n, int columnSize)
  {
    int length, start;
    String s = null;
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    s = Long.toString(n);

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = columnSize - length;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

   /**
   * Method to right justify a double in a column of size
   * specified by the user and number of decimal
   * places specified by the user.
   *
   * @param n a double to be right justified in a column
   * @param columnSize an int representing the size
	* of the column
	* @param numDecimals int containing the number of
	* required decimal places in the real number.
	* @param money boolean if true places a $ at the in
	* the value and if false no $.
   *
   * @return a String representing the double right justified 
	* in the column
   */
  public static String rightJustify(double n, int columnSize,
                              int numDecimals, boolean money)
  {
    int length, start;
    String s = null, fmtstr = "0.";
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    for(int i = 0; i < numDecimals; i++)
    {
      fmtstr = fmtstr+"0";
    }

    DecimalFormat fmt = new DecimalFormat(fmtstr);
    s = fmt.format(n);

    if(money == true)
    {
      s = "$" + s;
    }

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = columnSize - length;

    sb.replace(start,start + length, s);

    return sb.toString();
  }

  /**
   * Method to right justify a character in a column of size
   * specified by the user.
   *
   * @param n a char to be left justified in a column
   * @param columnSize an int representing the size
	* of the column
   *
   * @return a String representing the character right 
	* justified in the column
   */
  public static String rightJustify(char c, int columnSize)
  {
    int length, start;
    String s = "";
    StringBuffer sb = new StringBuffer();
    sb.setLength(columnSize);

    s = s+c;

    for(int i = 0; i < columnSize; i++)
    {
      sb.replace(i,i+1," ");
    }

    length = s.length();

    start = columnSize - length;

    sb.replace(start,start + length, s);

    return sb.toString();
  }
}
