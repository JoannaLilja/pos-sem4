package integration;


public class DbHandler
{
	
	ErrorLogHandler elh;
	public DbHandler(ErrorLogHandler elh) 
	{
		this.elh = elh;
	}

	/**
	 * Adds a log entry to the database
	 * @param LogEntry entry
	 */
	void addLogEntry(LogEntry entry)
	{
		System.out.println("Entry added to logs. ");
	}
	
	/**
	 * Would contain an SQL query or something asking the database if the user userId is eligible for discount discountId. 
	 * However, this one just returns true every time without any database connection. 
	 * @param discountId
	 * @param userId
	 * @return valid
	 * @throws DbFailureException 
	 */
	public boolean validateDiscount(int discountId, int userId) throws DbFailureException
	{
		if(userId == 1)
				return true;
		if(userId == 2)
			return true;
		if(userId == 3)
			return true;

		
		throw new DbFailureException("Discount " + discountId + " was not available to user " + userId, elh);

	}
	
	/**
	 * Would contain an SQL query or something asking the database for discount of id id. 
	 * However, this one just returns a variety of examples without any database connection. 
	 * @param id
	 * @return discountDTO
	 * @throws DbFailureException 
	 */
	public DiscountDTO getDiscount(int id) throws DbFailureException
	{
		if(id == 1)
			return new DiscountDTO(1, 0.8);
		if(id == 2)
			return new DiscountDTO(2, 0.7);
		
		throw new DbFailureException("Discount " + id + " does not exist. ", elh);
	}
	
}
