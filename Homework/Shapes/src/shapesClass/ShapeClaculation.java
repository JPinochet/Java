package shapesClass;

import java.util.*;
import java.lang.*;

public class ShapeClaculation
{
  public static void main(String[] args) 
  {
    char shapeType;
    double radius, length, width, side1, side2, side3;
    double area;
    double circumference, perimeter;
    
    Scanner sc = new Scanner(System.in); //gotta get user input somehow
    
   // UniversalOutFile outfile = new UniversalOutFile("c:\\java08\\module11\\AssignmentFive.rpt"); //instance for outfile
   // outfile.openFile(); //just cause it was assigned, here it is, appends to boot!
    printTitles(); //again, only because it was assigned
    System.out.println("Geometry Calculator \nC for Circle\nR for Rectangle\nT for Triangle\nQ to Quit:"); //what shape are we testing for
    shapeType = sc.next().toUpperCase().charAt(0); 
    while (shapeType !='Q') //might need to be used several times
    {
      switch (shapeType)
      {
        case 'C':
        {
          System.out.print("Please enter the radius of the circle: ");  //needed for calculation
          radius = sc.nextDouble();
          
          Circle myCircle = new Circle(radius);  //to use Circle.java
          
          System.out.printf("\nThe area of the circle is %.2f and the circumference of the circle is %.2f\n", myCircle.calcCircleA(radius), myCircle.calcCircleC(radius)); //this was hard to figure out, coffee just used () not return variable types,same with the rest.
          //outfile.writeLineToFile("\nThe area of the circle is %.2f and the circumference of the circle is %.2f\n", (myCircle.calcCircleA(radius)), (myCircle.calcCircleC(radius)));
          break;  //so it doesn't link off to other switch cases
        } //end case for circle
        case 'R':
        {
          System.out.print("Please enter the length of the rectangle: ");       //needed for calculation
          length = sc.nextDouble();
          System.out.print("Please enter the width of the rectangle: ");
          width = sc.nextDouble();
          
          Rectangle myRectangle = new Rectangle(length, width);  //to use Rectangle.java
          
          System.out.printf("\nThe area of the rectangle is %.2f and the perimeter of the rectangle is %.2f\n", (myRectangle.calcRectangleA(length, width)), (myRectangle.calcRectangleP(length, width))); //will print even with errors, just shows 0 and error messages.
          //outfile.writeLineToFile("\nThe area of the rectangle is %.2f and the perimeter of the rectangle is %.2f\n",(myRectangle.calcRectangleA(length, width)), (myRectangle.calcRectangleP(length, width)));
          break;  //so it doesn't link off to other switch cases
        } //end case for Rectangle
        case 'T':
        {
          System.out.print("Please enter the length of the first triangle side: ");          //needed for calculations
          side1 = sc.nextDouble();
          System.out.print("Please enter the length of the second triangle side: ");
          side2 = sc.nextDouble();
          System.out.print("Please enter the length of the third triangle side: ");
          side3 = sc.nextDouble();
          
          Triangle myTriangle = new Triangle(side1, side2, side3); //to use Triangle.java
          
          System.out.printf("\nThe area of the triangle is %.2f and the perimeter of the triangle is %.2f\n", (myTriangle.calcTriangleA(side1, side2, side3)), (myTriangle.calcTriangleP(side1, side2, side3)));
          
          if ((myTriangle.calcTriangleA(side1, side2, side3)) <=0)
          {
        	  System.out.printf("\nThis is not a real triangle.\nThe area of the triangle is %.2f and the perimeter of the triangle is %.2f\n", (myTriangle.calcTriangleA(side1, side2, side3)), (myTriangle.calcTriangleP(side1, side2, side3)));
          }
          else 
          {
            System.out.printf("\nThe area of the triangle is %.2f and the perimeter of the triangle is %.2f\n", (myTriangle.calcTriangleA(side1, side2, side3)), (myTriangle.calcTriangleP(side1, side2, side3)));
          }
          break; //so it doesn't link off to other switch cases
        } //end case for triangle
        default:
        {
          System.out.println("That is an invalid choice.");
          break;
        } //end error check
      } //end switch statement
      System.out.println("Geometry Calculator \nC for Circle\nR for Rectangle\nT for Triangle\nQ to Quit:");
      shapeType = sc.next().toUpperCase().charAt(0);
    } //end while loop
  } //end main
  public static void printTitles() //printing titles to prompt and outfile
  {
    //UniversalOutFile outfile = new UniversalOutFile("c:\\java08\\module11\\AssignmentFive.rpt"); //instance for outfile for the function
    //outfile.openFile(); //opening the file
   // String name = outfile.printName();
   //outfile.writeLineToFile(name);
    //System.out.println(name);
    //Date now = new Date();
    //String message = now.toString();
    //System.out.println("Today's date is: " + message+"\n");
    //outfile.writeLineToFile("Today's date is: " + message+"\n");
  } //end function printTitles
} //end class Shape claculation