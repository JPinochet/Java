/**
 * Mar 11, 2009
 */
package saitMLS.exceptions;

/**
 * @author 432873
 * Exception class that checks the phone number of the client to 
 * make sure it's in the appropriate form.
 *
 */
public class InvalidPhoneNumberException extends Exception
{
	public InvalidPhoneNumberException()
	{
		
	}
	
	public InvalidPhoneNumberException(String message)
	{
		super(message);
	}
}
