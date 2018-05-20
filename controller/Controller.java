package controller;

import integration.DbFailureException;
import integration.ErrorLogHandler;
import integration.ItemNotFoundException;
import integration.Printer;
import model.purchase.DisplayItems;
import model.purchase.Purchase;
import view.TotalRevenueView;

/**
 * Handles the flow from View to the Model
 */
public class Controller 
{
	private Purchase purchase;
	
	
	public Controller()
	{
		purchase = new Purchase();	
	}
	
	/**
	 * 
	 * @param itemId
	 * @return Items and current total
	 * @throws ItemNotFoundException 
	 */
	public DisplayItems addItem(int id) throws ItemNotFoundException
	{
		return purchase.addItem(id);
	}
	
	public void enterDiscount(int discountId) throws DbFailureException
	{
		purchase.getPayment().enterDiscount(discountId);
	}
	
	public boolean validateDiscount(int customerId) throws DbFailureException
	{
		return purchase.getPayment().getDiscount().validate(customerId);
	}
	
	/**
	 * Pays amount and returns change based on total of Purchase. 
	 * @param amount
	 * @return change
	 */
	public double pay(double amount)
	{
		purchase.finalize();
		return purchase.getPayment().pay(amount, purchase);
	}
	
	/**
	 * Clears the current sale. 
	 */
	public void startSale()
	{
		purchase.reset();
	}

	/**
	 * Gets the discounted payment amount
	 * @return discountedAmount
	 */
	public double getDiscountedAmount()
	{
		return purchase.getPayment().getDiscountedAmount();
	}

	/**
	 * Gets the amount of change on the current payment
	 * @return
	 */
	public double getChange() 
	{
		return purchase.getPayment().getChange();
	}

	/**
	 * Adds an Observer to the Observable Payment
	 * @param totalRevenueView
	 */
	public void addPurchaseObserver(TotalRevenueView totalRevenueView) 
	{
		purchase.getPayment().addObserver(new TotalRevenueView());		
	}

}
