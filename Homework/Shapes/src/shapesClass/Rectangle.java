/**
 * Feb 11, 2009
 */
package shapesClass;
import static java.lang.Math.*;

/**
 * @author 432873
 *
 */

public class Rectangle
{
  public double area;
  public double perimeter;
  public double length;
  public double width;
  public Rectangle()
  {
    //initialize instance variables
    area =0;
    perimeter=0;
    length =0;
    width=0;
  } //end constructor
  public Rectangle(double length, double width)
  {
    this.length=length;
    this.width=width;
  }
  public double calcRectangleA(double length, double width)
  {
    if((width<=0)||(length<=0))
    {
      System.out.println("Invalid input");
      return 0;
    }
    else
    {
      area = length*width;
      return area;
    }
  }
  public double calcRectangleP(double length, double width)
  {
    if((width<=0)||(length<=0))
    {
      System.out.println("Invalid input");
      return 0;
    }
    else
    {
      perimeter = length*2+width*2;
      return perimeter;
    }
  }
} //end class