/* 
  Jorge Pinochet
  Oct 12, 08
  tempHighLow
*/

import java.io.*;
import java.util.Scanner;

public class hopeThisWorks
{
  static final int ZERO = 0;
  static final int TEN = 10;
  static final int TWENTY = 20;
  static final int TWENTYFIVE = 25;
  static final int THIRTY = 30;
  static Scanner scn = new Scanner(System.in);
  
  public static void main(String[] args) throws IOException
  {
    String filename;
    double recordHigh = -210.00;
    int recordHYear =0; //just in case year comes into play later on
    int recordHMonth =0;
    int recordHDay =0;
    double recordLow = 100.00;
    int recordLYear = 0; //just in case
    int recordLMonth =0;
    int recordLDay =0;
    int year; //needed extra for reading infile.
    int month;
		int day;
		double highTemp;
		double lowTemp;
    int counterLessZero =0;
    int counterLessTen =0;
    int counterLessTwenty =0;
    int counterLessTwentyFive =0;
    int counterLessThirty =0;
    int counterPlusThirty =0;

    universalOutFile outfile = new universalOutFile("c\\java08\\module7\\tempHighLow.rpt");
    outfile.openFile();
    
    String name = outfile.printName();   //importing info from outfile for my name
    outfile.writeLineToFile(name); //writing to outfile
    System.out.println(name); //printing name to command prompt
    String date = outfile.printDate(); // importing date from outfie
    outfile.writeLineToFile(date);   //writing date to outfile
    System.out.println(date); //display date
    
    System.out.print("Enter the filename: ");
    filename = scn.nextLine();
    
    System.out.println(); //space in the program
    File file = new File("c:\\java08\\module5\\"+filename); //new instance of infile
    if (!file.exists()) //error check for infile
    {
      System.out.println("Error, cannot open infile");
      System.exit(0);
    } //closing if statement
    Scanner inputFile = new Scanner(file);
    
    System.out.println("Below 0\t 0-10\t 10-20\t 20-25\t 25-30\t 30+");
    outfile.writeLineToFile("Below 0\t 0-10\t 10-20\t 20-25\t 25-30\t 30+");
    
    while (inputFile.hasNext())
    {
      year = inputFile.nextInt();
      month = inputFile.nextInt();
      day = inputFile.nextInt();
      highTemp = inputFile.nextDouble();
      lowTemp = inputFile.nextDouble();
      if (highTemp>recordHigh)
      {
        recordHigh = highTemp;
        recordHMonth = month;
        recordHDay = day;
      } //if for high temps
      if (lowTemp<recordLow)
      {
        recordLow = lowTemp;
        recordLMonth = month;
        recordLDay = day;
      } //if for low temps
      if (highTemp<ZERO)
      {
        counterLessZero = counterLessZero+1;
      } //if loop for lesser then 0
      if (highTemp<TEN)
      {
        counterLessTen = counterLessTen+1;
      } //if loop for lesser then 10
      if (highTemp<TWENTY)
      {
        counterLessTwenty = counterLessTwenty+1;
      } //if loop for lesser then 20
      if (highTemp<TWENTYFIVE)
      {
        counterLessTwentyFive = counterLessTwentyFive+1;
      } //if loop for lesser then 25
      if (highTemp<THIRTY)
      {
        counterLessThirty = counterLessThirty+1;
      } //if loop for lesser then 30
      if (highTemp<THIRTY)
      {
        counterLessThirty = counterLessThirty+1;
      } //if loop for lesser then 30
      if (highTemp>=THIRTY)
      {
        counterPlusThirty = counterPlusThirty+1;
      } //if loop for greater or equal to 30
    } //closing infile loop
    
    System.out.printf("%6d %12d %18d %24d %30d %36d", counterLessZero, counterLessTen, counterLessTwenty, counterLessTwentyFive, counterLessThirty,counterPlusThirty);
    System.out.printf("The highest temperature was %.2f, on the %c of %c.", recordHigh, recordHMonth, recordHDay);
    System.out.printf("The lowest temperature was %.2f, on the %c of %c.", recordLow, recordLMonth, recordLDay);
    
    outfile.writeLineToFile("%6d %12d %18d %24d %30d %36d", counterLessZero, counterLessTen, counterLessTwenty, counterLessTwentyFive, counterLessThirty,counterPlusThirty);
    outfile.writeLineToFile("The highest temperature was %.2f, on the %c of %c.", recordHigh, recordHMonth, recordHDay);
    outfile.writeLineToFile("The lowest temperature was %.2f, on the %c of %c.", recordLow, recordLMonth, recordLDay);
    
    inputFile.close(); //close infile
    outfile.closeFile(); //close outfile
  } //end main method
} //end class