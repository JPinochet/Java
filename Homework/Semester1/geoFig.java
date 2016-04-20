/* 
  Jorge Pinochet 
  Sept 23, 2008
  geoFigOtFile
*/

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;
import static java.lang.Math.*;

public class geoFig
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    char figType;
    double radius;
    double length;
    double width;
    double length1;
    double length2;
    double height;
    double area;
    
    SimpleDateFormat jorgeDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
    Date date = new Date();
    System.out.println();
    
    System.out.println(jorgeDateFormat.format(date));
    System.out.println();
    
    System.out.print("Please enter the figure type for which you need to calculate area: ");
    figType = sc.next().toUpperCase().charAt(0);
    
    geoFigOutFile outfile = new geoFigOutFile("c:\\java08\\module4\\figType.rpt");
    outfile.openFile();
    
    switch(figType)
    {
      case 'C':
      {
        System.out.print("Please enter the radius of the circle: ");
        radius = sc.nextDouble();
        area = pow(radius,2)*Math.PI;
        System.out.printf("The radius of the %c is %.2f and the area is %.2f.",figType,radius,area);
        outfile.writeLineToFile("The radius of the %c is %.2f and the area is %.2f.",figType,radius,area);
        break;
      }
      case 'R':
      {
        System.out.print("Please enter the length of the rectangle: ");
        length = sc.nextDouble();
        
        System.out.print("Please enter the width of the rectangle: ");
        width = sc.nextDouble();
        
        area = length*width;
        
        System.out.printf("The length of the %c is %.2f, the width is %.2f and the area is %.2f",figType, length, width, area);
        outfile.writeLineToFile("The length of the %c is %.2f, the width is %.2f and the area is %.2f.",figType,length,width,area);
        break;
      }
      case 'T':
      {
        System.out.print("Please enter the first length of the trapezoid: ");
        length1 = sc.nextDouble();
        System.out.print("Please enter the second length of the trapezoid: ");
        length2 = sc.nextDouble();
        System.out.print("Please enter the height of the trapezoid: ");
        height = sc.nextDouble();
        area = height/2*(length1 + length2);
        
        System.out.printf("The length of the first side, the length of the second side and the height of the %c is %.2f, %.2f, %.2f and the aea is %.2f.",figType, length1, length2, height, area);
        outfile.writeLineToFile("The length of the first side, the length of the second side and the height of the %c is %.2f, %.2f, %.2f and the aea is %.2f.",figType, length1, length2, height, area);
        break;
      }
      default:
      {
        System.out.println("Error, invalid choice");
      }
    }
    outfile.closeFile();
  }
}