/*  Jorge Pinochet
    Sept 9,08
    decFormPrac.java
*/

import java.text.DecimalFormat;

public class decFormPrac
{
  public static void main(String[] args)
  {
    double a,b,c;    //three reals
    a = 30000.259;
    b = 400.10;
    c = a + b;
    DecimalFormat nf = new DecimalFormat("#,###,##0.00");
    System.out.println("The value of c is " + nf.format(c));
  }
}