package integration;

/**
 * Exception to be thrown when an SQL statement fails
 */
public class DbFailureException extends Exception
{
	/**
	 * Takes a message and prints it when the error is thrown
	 * @param msg
	 * @param elh
	 */
	public DbFailureException(String msg, ErrorLogHandler elh) 
	{ 
		super(msg);
		elh.logException(this);
	} 
}
