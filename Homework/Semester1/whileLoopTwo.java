/*
  Jorge Pinochet
  Oct 6, 08
  whileLoop
*/

public class whileLoopTwo
{
  public static void main(String[] args)
  {
    int counter = 0; //initialize loop variable
    while (counter < 0)
    {
      System.out.printf("The number is %d \n", counter);
      counter = counter+1; //update loop variable
    } //ending loop
  }//end main method
} // ending class whileLoop