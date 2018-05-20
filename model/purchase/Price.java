package model.purchase;

/**
 * Holds the logic related to price
 */
public class Price
{
	double price;
	Tax tax;
	
	/**
	 * Constructor for price. Takes an argument amount. 
	 * @param price
	 */
	Price(double price)
	{
		this.price = price;
		tax = new Tax(price);
	}
	
	/**
	 * getter for amount
	 * @return amount
	 */
	public double getAmount()
	{
		return price;
	}
	
	/**
	 * Getter for Tax
	 * @return tax
	 */
	public Tax getTax() 
	{
		return tax;
	}

}
