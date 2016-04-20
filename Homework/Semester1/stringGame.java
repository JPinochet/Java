/* 
  Jorge Pinochet
  StringGame
*/

import java.util.Scanner;
import static java.lang.Math.*;
import java.io.*;
import javax.swing.JOptionPane;

public class StringGame
{
   public static void main(String[] args) throws IOException
   {
      String word;
      String infilename;
      String sound;
      
      infilename = getInFileName();
      File file = new File(infilename);
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the rhyming sound you are matching: ");
      sound = sc.nextLine();
      System.out.println("Sound is " + sound);
      Scanner infile = new Scanner(file);
      
      while (infile.hasNext())  //loop condition
      {
          word = infile.nextLine();
          if (word.charAt(0) != word.toUpperCase().charAt(0))
          {
            if ((word.substring(1).equals(sound)) || (word.substring(2).equals(sound) ))
            {
              System.out.println("This word rhymes with " + sound +" " + word);
            } //end inner if statement
            else
            {
              System.out.println("This word is not in the list with " + sound);
            } //end else
          } //end if statement
      } // end while loop
    } //end main
    
   public static String getInFileName()
   {
      String file;
      file = JOptionPane.showInputDialog("Enter the filename: ");
      return file;
   }
    
} //end class