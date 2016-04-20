/*
  Jorge Pinochet
  Oct 27, 2008
  characterTest
*/

import javax.swing.JOptionPane;

public class characterTest
{
  public static void main(String[] args)
  {
    String input;
    char ch;
    input = JOptionPane.showInputDialog("Enter a single character");
    ch = input.charAt(0);
    
    if(Character.isLetter(ch))
    {
      JOptionPane.showMessageDialog(null, "That is a letter");
    }
    
    if(Character.isDigit(ch))
    {
      JOptionPane.showMessageDialog(null, "That is a digit");
    }
    
     if(Character.isLowerCase(ch))
    {
      JOptionPane.showMessageDialog(null, "That is a lower case letter");
    }
    
     if(Character.isUpperCase(ch))
    {
      JOptionPane.showMessageDialog(null, "That is a upper case letter");
    }
    
     if(Character.isSpaceChar(ch))
    {
      JOptionPane.showMessageDialog(null, "That is a space");
    }
    
     if(Character.isWhitespace(ch))
    {
      JOptionPane.showMessageDialog(null, "That is a whitespace character");
    }
    System.exit(0);
  }//end main
}