/*
Program: markconverter.java
Written by: Jesse Marshall
Date: October 2, 2008
*/

import java.util.Scanner;

public class markConverter
{
  public static void main(String[] args)
  {
    String studentname;
    Scanner keyboard = new Scanner(System.in);
    double markin;
    double markout;
    char converter;
    


    System.out.println("\nA. Convert a mark out of 24 to a mark out of 15");
    System.out.println("B. Convert a mark out of 15 to a mark out of 24");
    System.out.println("C. End the program");
    System.out.print("\nPlease select a choice from the above menu: ");
    converter = keyboard.next().toUpperCase().charAt(0);
    
    while(converter!='C')
    {
      switch(converter)
      {
        case 'A': //to convert to a mark out of 15
        {
          System.out.println("Please enter the student's name: ");  //get the students name
          studentname = keyboard.nextLine();
          
          System.out.print("Please enter the mark out of 24: ");  //get the students mark
          markin = keyboard.nextDouble();
          
          markout = (markin * 15) / 24; //convert the mark
          
          System.out.printf("\n%s's mark of %.2f/24 has been converted to a mark of %.2f/15.\n",studentname,markin,markout);  //display message
          break;
        }
        
        case 'B': //to convert to a mark out of 24
        {
          System.out.print("Please enter the student's name: ");  //get the students name
          studentname = keyboard.nextLine();
          
          System.out.print("Please enter the mark out of 15: ");  //get the students mark
          markin = keyboard.nextDouble();
          
          markout = (markin * 24) / 15; //convert the mark
          
          System.out.printf("\n%s's mark of %.2f/15 has been converted to a mark of %.2f/24.\n",studentname,markin,markout);  //display message
          break;
        }
        
        default:  //error checking
        {
          System.out.println("\nSorry, that is not one of the option listed. Please try again.\n");
        }
        
      } //end switch
      
      System.out.println("A. Convert a mark out of 24 to a mark out of 15");
      System.out.println("B. Convert a mark out of 15 to a mark out of 24");
      System.out.println("C. End the program.");
      System.out.print("\nPlease select a choice from the above menu: ");
      
      converter = keyboard.next().toUpperCase().charAt(0);
      
    } //end loop
    
  System.out.println("\nGoodbye!");
  
  } //end main
  
}//end class