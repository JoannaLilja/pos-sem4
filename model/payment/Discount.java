package model.payment;

import integration.DbFailureException;
import integration.DbHandler;
import integration.DiscountDTO;
import integration.ErrorLogHandler;

/**
 * Holds the logic related to discount
 */
public class Discount
{
	
	private DbHandler db;
	
	private int id;
	private double multiplier;
	
	private boolean valid = false;
	
	Discount(int id, ErrorLogHandler elh) throws DbFailureException
	{
		db = new DbHandler(elh);
		DiscountDTO discountDTO = db.getDiscount(id);
		this.id = discountDTO.getId();
		this.multiplier = discountDTO.getMultiplier();
	}
	
	/*
	 * Getter for id
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Getter for multiplier (percentage of discount)
	 * @return multiplier
	 */
	public double getMultiplier()
	{
		return multiplier;
	}
	
	/**
	 * Returns true if the discount has been successfully validated
	 * @return valid
	 */
	public boolean isValid()
	{
		return valid;
	}

	/**
	 * Returns true if the discount is valid
	 * @param userId
	 * @return valid
	 * @throws DbFailureException
	 */
	public boolean validate(int userId) throws DbFailureException 
	{
		valid = db.validateDiscount(this.id, userId);
		return valid;
	}

}
