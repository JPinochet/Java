/**
 * Mar 11, 2009
 */
package saitMLS.exceptions;

/**
 * @author 432873
 * Exception class thrown when the postal code is in an invalid 
 * format.
 *
 */
public class InvalidPostalCodeException extends Exception
{
	public InvalidPostalCodeException()
	{
		
	}
	
	public InvalidPostalCodeException(String message)
	{
		super(message);
	}
}
