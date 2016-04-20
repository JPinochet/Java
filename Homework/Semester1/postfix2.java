public class postfix2
{
  public static void main(String[] args)
  {
    int total = 0;
    int counter;
    System.out.println("Counter's Current Value TOTAL\n");
    
    for(counter = 5; counter<=10;counter++)
    {
      total = 6 + counter++;
      System.out.printf("\t\t%d     %d\n", counter, total);
    }
  } //end main
} //end class