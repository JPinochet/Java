/**
 * Feb 11, 2009
 */
package shapesClass;
import static java.lang.Math.*;

/**
 * @author 432873
 *
 */

public class Circle
{
  public double area;
  public double circumference;
  public double radius;
  
  public Circle()
  {
    //initialize instance variables - we have 3 instance variable for this class and that are area,radius, circumference
    area =0;
    radius =0;
    circumference=0;
  } //end constructor
  public Circle(double radius)
  {
    this.radius = radius;
  }
  public double calcCircleA(double radius)
  {
    if (radius > 0)
    {
      area = PI*Math.pow(radius,2);
      return area;
    }
    else
    {
      System.out.println("Invalid input");
      return 0;
    }
  } //actual work being done
  public double calcCircleC(double radius)
  {
    if (radius > 0)
    {
      circumference = PI*radius*2;
      return circumference;
    }
    else
    {
      System.out.println("Invalid input");
      return 0;
    }
  }
} //end class