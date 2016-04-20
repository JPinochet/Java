/**
 * 
 */
package xmlValidation;

import java.util.*;

/**
 * @author 432873
 *
 */
public class XMLValidator
{
	public static void Main(String[] args)
	{
		StringTokenizer  st = new StringTokenizer (">");
		Queue<String> qe = new LinkedList<String>();
		Stack<String> invalid = new Stack<String>();
		
		for(int i = 0; i < args.length; i++)
		{
			String input = st.nextToken();
			input = removeChar(input, '<');
			input = removeChar(input, '>');
			
			if(input.charAt(0) != '/')
			{
				qe.add(input);
			}
			else
			{
				input = removeChar(input, '/');
				if(qe.equals(input))
				{
					qe.remove(input);
				}
				else
				{
					invalid.push(input);
				}
			}
		}
		
		System.out.println("Validated XML");
		while(qe.isEmpty())
		{
			System.out.println(qe.poll());
		}
		
		System.out.println("Error validating");
		while(invalid.isEmpty())
		{
			System.out.println(invalid.pop());
		}
	}
	
	public static String removeChar(String s, char c) 
	{
		String r = "";
		for (int i = 0; i < s.length(); i ++) 
		{
			if (s.charAt(i) != c) 
				r += s.charAt(i);
		}
		return r;
	}
}
