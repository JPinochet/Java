/*
  Program: Calculates prefi increment
  Jorge Pinochet
  Oct 14, 08
  prefix1.java
*/

public class prefix1
{
  public static void main(String[] args)
  {
    int total;
    int counter = 5;
    total = 6+ ++counter; //the total will be 12 after this calculation because the value of the counter is incremented then added to 6 for a total of 12
    System.out.println("Counter's Current Value TOTAL");
    System.out.printf("\t%d\t\t %d\n", counter, total); //use 3 spaces before the %d for total
  } //end main method
} //end class postfix1