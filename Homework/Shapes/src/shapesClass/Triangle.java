/**
 * Feb 11, 2009
 */
package shapesClass;

/**
 * @author 432873
 *
 */

import static java.lang.Math.*;

public class Triangle
{
  public double area;
  public double perimeter;
  public double side1;
  public double side2;
  public double side3;
  public Triangle()
  {
    //initialize instance variables
    area =0;
    perimeter=0;
    side1=0;
    side2=0;
    side3=0;
  } //end constructor
  public Triangle(double side1, double side2, double side3)
  {
    this.side1=side1;
    this.side2=side2;
    this.side3=side3;
  } 
  public double calcTriangleP(double side1, double side2, double side3)
  {
    if((side1<=0)||(side2<=0)||(side3<=0))
    {
      System.out.println("Invalid input");
      return 0;

    }
    else
    {
      perimeter = (side1+side2+side3)/2;
      area = sqrt((perimeter*(perimeter-side1)*(perimeter-side2)*(perimeter-side3)));
      if (area<=0)
      {
        System.out.println("This is not a real triangle");
        return 0;
      } //if statement
      else
      {
        perimeter = (side1+side2+side3);
        return perimeter;
      } //return area if triangle is real
    }
  } //end calcperimeter 
  public double calcTriangleA(double side1, double side2, double side3)
  {
    perimeter = (side1+side2+side3)/2;
    area = sqrt((perimeter*(perimeter-side1)*(perimeter-side2)*(perimeter-side3)));
    if((side1<=0)||(side2<=0)||(side3<=0))
    {
      System.out.println("Invalid input");
      return 0;
    } //end error if check
    else
    {
      if (area<=0)
      {
        System.out.println("This is not a real triangle");
        return 0;
      } //if statement
      else
      {
        return area;
      } //return area if triangle is real
    }
  } //end calculating area
} //end class