/*
  Jorge Pinochet
  Oct 27, 08
  FindIt
*/

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class FindIt
{
  public static void main(String[] args) throws IOException
  {
    int numLinesRead=0; 
    String infilename;
    String word;
    infilename = getInFileName();
    File file = new File(infilename);
    Scanner sc = new Scanner(System.in);
    Scanner infile = new Scanner(file);
    String[] initialValue = new String[27]; 
    String[] after = new String[27];
    while (infile.hasNext() && numLinesRead < 27) 
    {
      initialValue[numLinesRead++] = infile.nextLine(); 
    } //end loop1
    for (int index=0; index<numLinesRead; index++)
    {
      System.out.println("IN BIG LETTERS - THE INDEX VALUE IS: "+index);
      String tempWord = new String(); 
      for(int jindex=0; jindex<initialValue[index].length(); jindex ++) 
      {
        System.out.println("IN CAPITAL LETTERS JINDEX VALUE IS: "+jindex);
        char ch;
        ch = initialValue[index].charAt(jindex);
        System.out.println("The character at this index is "+ch);
        if (Character.isLetter(ch))
        {
          tempWord = tempWord + Character.toLowerCase(ch);
          System.out.println("Templine is " + tempWord); 
        } //end if statement
      } //end for loop2
      after[index] = tempWord; 
      System.out.println("Templine with all letters is "+after[index]);
     } 
      System.out.println("Enter the character(s) you are matching at end of word: ");
       //end outside loop
      System.out.print("Word to be matched: ");
      word = sc.next();
      
      for(int index=0; index < numLinesRead; index++) 
      {
        if (after[index].endsWith(word)) 
        {
          System.out.println("'" + initialValue[index]+"' is a match."); 
        } //end inner for loop3
      } //end for loop3
      System.out.println("Enter the character(s) you are matching at the beginning of word: "); 
      System.out.print("Word to be matched: ");
      word = sc.next();
      for(int index =0; index<numLinesRead; index++) 
      {
        if (after[index].startsWith(word)) 
        {
          System.out.println("'" + initialValue[index] + "' is a match.");
        } //end nested if statement
      } //end for loop
  } //end main
  public static String getInFileName()
  {
    String file;
    file = JOptionPane.showInputDialog("Enter the filename: ");
    return file;
  } //end getInfilename
} //end class