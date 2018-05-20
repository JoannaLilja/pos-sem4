package model.purchase;

/**
 * Holds tax related functionality. For now, the tax is simply declared a percentage of the price by the constructor. 
 *
 */
public class Tax
{

	double tax;
	
	Tax(double price)
	{
		tax = price*0.05;
	}
	
	public double getAmount()
	{
		return tax;
	}
	
	
}
