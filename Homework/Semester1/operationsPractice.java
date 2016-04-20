/*
  Jorge Pinochet
  Sept 14, 2008
  Operations Practice operationsPractice
*/

import java.util.Scanner;
import java.text.DecimalFormat;
import static java.lang.Math.pow;

public class operationsPractice
{
 public static void main(String[] args)
 {
    float answerOne, answerTwo, answerThree, answerFive;
    answerOne = 16/3+3*20%6;
    answerTwo = 27%2*4-9+11;
    answerThree = 10-5*3+16%2;
    int x = 5, y = 2;
    double answerFour;
    answerFour = (double) (y/x);
    answerFive = 11+6*2-16%4/4;
    System.out.println("These are you answers: " + answerOne+"," + answerTwo+"," + answerThree+","+ answerFour+"," + answerFive);
 }
}