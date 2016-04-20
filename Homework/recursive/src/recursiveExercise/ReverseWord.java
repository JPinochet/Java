/**
 * Apr 2, 2009
 *
 */
package recursiveExercise;

/**
 *
 * @author 432873
 * Jorge Pinochet
 *
 * version 1.0
 *
 */
public class ReverseWord
{
	public static void wordReversed(String word, int length)
	{
		if(length >= 1)
		{
			String reversed = word.substring(0,1);
			System.out.println(reversed);
			
			wordReversed(word.substring(1,word.length()), (word.length()-1));
		}
		else
		{
			
		}
	}
	
	public static void reverseWord(String word, int length)
	{ 
		String wordReversed = "";
		if(word.length() > 1)
		{
			//System.out.println(word);
			wordReversed = wordReversed + word.charAt(0);
			System.out.println(wordReversed);
			reverseWord(word.substring(1,word.length()-1), word.length());
			//System.out.println(word);
			
		}
		else
		{
			System.out.println("before recursive call Sub word = " + wordReversed);
			//reverseWord(word, length);
			System.out.println("after recursive call word = " + wordReversed);
		}
	}
	
	 public static String reverse(String arg) 
	 { 
			String tmp = "";
			
			if (arg.length() == 1)
			{
				return arg;
			}
			
			else
			{
				String lastChar = arg.substring(arg.length()-1,arg.length());
				
				String remainingString = arg.substring(0, arg.length() -1);
				
				tmp = lastChar + reverse(remainingString);
				System.out.println(tmp);
			}
			return arg;
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String testword = "something";
		wordReversed(testword, testword.length());
	}

}
