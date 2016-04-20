/*
  Jorge Pinochet
  Oct 27, 08
  IndexOfItStart
*/

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class IndexOfItStart
{
  public static void main(String[] args) throws IOException
  {
    int first;
    int last;
    int position;
    int counter = 0;
    int startAt;
    String word;
    String str = "Romeo, Romeo, wherefore art thou, Romeo";
    str = str.toLowerCase(); //need to transliterate the string
    System.out.println("Enter the string to search");
    Scanner sc= new Scanner (System.in);
    word = sc.nextLine(); //this is the text you are going to look for 
    System.out.println("Enter the index at which to start the search");
    startAt = sc.nextInt(); //this is the value of the INDEX at which you wish to start the search - use 8 when you do the run
    position = str.indexOf(word, startAt); //word is the word (can just be a string or character) you are searching for
    // startAt is the value of the INDEX you want to start at
    System.out.println("The word is " + word);
  } //end main method
} //end class