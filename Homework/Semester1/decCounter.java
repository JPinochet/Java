/*
  Jorge Pinochet
  Oct 6, 08
  decCounter
*/

import java.io.*;
import java.util.Scanner;

public class decCounter
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    char type;
    int numLocal = 0;
    int numLongDist = 0;
    int counter = 0;
    int calls = 0;
    System.out.print("Please enter then numbe of calls you made today: ");
    calls = sc.nextInt();
    counter = 1;
    while(counter <= calls)
    {
      System.out.printf("Please enter the type of call made for the number %d call \nD-Long Distance \nL-Local \n", counter);
      type = sc.next().toUpperCase().charAt(0);
      
      switch (type)
      {
        case 'L':
        {
          numLocal = numLocal + 1;
          break;
        } //end case l
        case 'D':
        {
          numLongDist = numLongDist + 1;
          break;
        } //end case d
        default:
        {
          System.out.println("Error, invalid phone call type");
          counter = counter - 1;
          break;
        } //end error check
      } //end switch
      counter = counter + 1;
    } //end loop
    System.out.printf("\n Total local calls made is %d \n", numLocal);
    System.out.printf("\n Total long distance calls made is %d \n", numLongDist);
  } // end main method
} // end class decCounter