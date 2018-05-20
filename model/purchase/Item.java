package model.purchase;

public class Item 
{
	
	private int id;
	private int count;
	private Description desc;
	private Price price;
	
	public Item(int id, double price, String desc)
	{
		this.id = id;
		this.count = 1;
		this.desc = new Description(desc);
		this.price = new Price(price);
	}

	/**
	 * Getter for item id
	 * @return id
	 */
	public int getId()
	{
		return id;	
	}
	
	/**
	 * Getter for count
	 * @return count
	 */
	public int getCount()
	{
		return count;	
	}
	
	/**
	 * Getter for description
	 * @return description
	 */
	public Description getDescription()
	{
		return desc;
	}
	
	/**
	 * Getter for price
	 * @return price
	 */
	public Price getPrice()
	{
		return price;
	}
	
	/**
	 * Increments the count of the item by one. 
	 */
	public void incrementCount()
	{
		count++;
	}

}
