/**
 * 
 */
package exceptions;

/**
 * @author 432873
 *
 */
@SuppressWarnings("serial")
public class InvalidNoteStringException extends Exception
{
	public InvalidNoteStringException()
	{
		
	}
	
	public InvalidNoteStringException(String message)
	{
		super(message);
	}
}

