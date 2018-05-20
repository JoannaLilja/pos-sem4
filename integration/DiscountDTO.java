package integration;

public class DiscountDTO 
{

	private int id;
	private double multiplier;
	
	DiscountDTO(int id, double multiplier)
	{
		this.id = id;
		this.multiplier = multiplier;	
	}
	
	/**
	 * Getter for discount id
	 * @return id
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Getter for multiplier (percentage discount)
	 * @return multiplier
	 */
	public double getMultiplier()
	{
		return multiplier;
	}
	
}
