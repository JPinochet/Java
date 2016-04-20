public class prefix2
{
  public static void main(String[] args)
  {
    int total = 0;
    int counter =0;
    System.out.println("Counter Current Value TOTAL\n\n");
    for(counter = 5;counter<=10;++counter)
    {
      total = 6 + ++counter;
      System.out.printf("\t\t%d        %d\n", counter, total);
    } //end for
  } //end main
} //end class