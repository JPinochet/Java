/*
  Jorge Pinochet
  Oct 27, 08
  IndexOfIt
*/

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class IndexOfIt
{
  public static void main(String[] args) throws IOException
  {
    int first;
    
    int last;
    String str = "Romeo, Romeo, wherefore art thou, Romeo";
    // str=str.toLowerCase(); // when this line is comneted out the first instance of r is at index 17
    System.out.println("the string is "+str);
    first = str.indexOf('r');
    last = str.lastIndexOf('r');
    System.out.println("The letter r first appears at position " + first);
    System.out.println("The letter r last appears at position " +last);
  } //end main
} //end class