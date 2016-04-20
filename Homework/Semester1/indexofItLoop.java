/*
  Jorge Pinochet
  Oct 27, 08
  indexOfItLoop
*/

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class indexofItLoop
{

    public static void main(String[] args) throws IOException
    {
      int first;
      int last;
      int position;
      int counter = 0;
      String str = "Romeo, Romeo, wherefore art thou, Romeo";
      str = str.toLowerCase(); //when this line is commented out the first instance of r is at index 17
      position = str.indexOf('r');
      
      while (position != -1) //flag in OS out of bounds of index of array will thow and exception
      {
        System.out.println("Position is " + position);
        position = str.indexOf('r', position + 1);
        counter = counter + 1;
      }
      
      System.out.println("the string is " + str);
      first = str.indexOf('r');
      last = str.lastIndexOf('r');
      System.out.println("The letter r first appears at the position " + first);
      System.out.println("The letter r appears last at the position " + last);
      System.out.println("The number of r's in this text is " + counter);
      
    }//end main
}//end class indexOfit