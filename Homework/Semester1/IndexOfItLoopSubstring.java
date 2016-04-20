/*
  Jorge Pinochet
  Oct 27, 08
  IndexOfItLoopSubString
*/

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class IndexOfItLoopSubstring
{
  public static void main(String[] args) throws IOException
  {
    String subWord;
    int endAt;
    int startAt;
    
    String str = "Romeo, Romeo, wherefore art thou, Romeo";
    str = str.toLowerCase(); //when this line is commented out the first instance of r is at index 17
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the index at which to tart the search");
    startAt = sc.nextInt(); //this value of the INDEX at which you wish to start the search - use 8 when you do the run
    System.out.println("Enter the index at which to end the search");
    endAt = sc.nextInt(); //this is the value of the index at which you wish to END the search
    subWord = str.substring(startAt, endAt);
    
    System.out.println("the text you are looking in thi text is " + subWord);
  } //end main
} //end class