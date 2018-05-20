package model.payment;

import java.util.Observable;

import integration.DbFailureException;
import integration.ErrorLogHandler;
import integration.Printer;
import model.purchase.Purchase;

public class Payment extends Observable
{

	private double total;
	private double amountPaid;
	private Discount discount;
	private Receipt receipt;
	private ErrorLogHandler elh;
	
	public Payment(ErrorLogHandler elh)
	{
		this.receipt = new Receipt();
		this.elh = elh;
	}
	
	/**
	 * Getter for total. 
	 * @return total
	 */
	public double getTotal()
	{
		return total;	
	}
	
	/**
	 * Getter for amountPaid
	 * @return amountPaid
	 */
	public double getAmountPaid()
	{
		return amountPaid;	
	}
	
	/**
	 * Getter for discount. 
	 * @return discount
	 */
	public Discount getDiscount() 
	{
		return discount;
	}
	
	/**
	 * Returns true if a discount exists and has been validated. 
	 * @return
	 */
	public boolean hasDiscount()
	{
		return !(discount == null);
	}
	
	/**
	 * Adds amount to total of Payment
	 * @param amount
	 */
	public void addToTotal(double amount)
	{
		total += amount;
	}
	
	/**
	 * Gets a new discount. Discount class communicates with DbHandler to get discount info. 
	 * @param discountId
	 * @throws DbFailureException 
	 */
	public Discount enterDiscount(int discountId) throws DbFailureException
	{
		discount = new Discount(discountId, elh);
		return discount;
	}
	
	/**
	 * Calculates the discounted value of a given price
	 * @param price
	 * @return discountedPrice
	 */
	public double getDiscountedAmount()
	{
		if (hasDiscount())
			if(discount.isValid())
				return total * discount.getMultiplier();
		return total;
	}

	/**
	 * Takes the amount paid by the customer and returns the change. Also tells the receipt to print and notifies any observers that a payment has been made. 
	 * @param amount
	 * @param purchase
	 * @return change
	 */
	public double pay(double amount, Purchase purchase)
	{
		amountPaid = amount;		
		receipt.print(purchase);
		
		setChanged();
		
		if (hasDiscount() && discount.isValid())
		{
			notifyObservers(total);
			return amount - total * discount.getMultiplier();	
		}
		
		notifyObservers(total);
		return amount-total;

	}

	/**
	 * Resets payment
	 */
	public void reset()
	{
		total = 0;
		discount = null;
	}

	/**
	 * Returns the change
	 * @return change
	 */
	public double getChange()
	{
		if (hasDiscount())
			if(discount.isValid())
			{
				return amountPaid - (total * discount.getMultiplier());
			}
		return amountPaid-total;
	}
	
}
