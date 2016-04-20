/* Jorge Pinochet
Sept 8, 2008
circle.c */

import java.util.Scanner;
import java.text.DecimalFormat;
import static java.lang.Math.pow;

public class circle
{
  static Scanner sc = new Scanner(System.in);
  static final double PI=3.14159;
  public static void main(String[] args)
  {
    System.out.print("Enter the radius: ");
    double radius = sc.nextDouble();
    double area= pow(radius,2)*PI;
    double circum = 2*radius*PI;
    DecimalFormat nf = new DecimalFormat("#,##0.000");
    System.out.println("Radius is " + nf.format(radius) + " cm.");
    System.out.println("Area is " + nf.format(area) + " sq.cm.");
    System.out.println("Circumference is " + nf.format(circum) + " cm.");
   }
}