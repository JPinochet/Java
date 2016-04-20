/*
  Jorge Pinochet
  Oct 27, 2008
  CharacterTest
*/

import javax.swing.JOptionPane;

public class TestCustNum
{
  public static void main(String[] args)
  {
    String input;
    char ch;
    input = JOptionPane.showInputDialog("Enter a customer number LLLNNNN - 3 letters, 4 numbers, no space \n");
    if (isValid(input))
    {
      JOptionPane.showMessageDialog(null, "That is a valid customer number.");
    } //end if
    else
    {
      JOptionPane.showMessageDialog(null, "That is not the proper format of ABC1234");
    } //else end
    System.exit(0);
  } //end main
  
  public static boolean isValid(String custNumber)
  {
    boolean goodSoFar = true; //setting flag to true, woring toward false
    int i =0;
    while (goodSoFar && i<3)
    {
      if (!Character.isLetter(custNumber.charAt(i)))
      {
        goodSoFar = false;
      } //end if
      i++;
    } //end loop1
    while (goodSoFar && i<7)
    {
      if (!Character.isDigit(custNumber.charAt(i)))
      {
        goodSoFar = false;
      } //end if loop2
      i++;
    } //end loop2
    
    return goodSoFar;
  } //end public static boolean, end isValid function
} //end class