package model.purchase;

import java.util.LinkedList;

/**
 * DTO grouping the items and total
 */
public class DisplayItems 
{
	
	LinkedList<Item> items;
	double runningTotal;
	
	DisplayItems(LinkedList<Item> items, double runningTotal)
	{
		this.items = items;
		this.runningTotal = runningTotal;
	}
	
	/**
	 * Getter for item list
	 * @return item
	 */
	public LinkedList<Item> getItems()
	{
		return items;
	}
	
	/**
	 * Getter for running total
	 * @return runningTotal
	 */
	public double getTotal()
	{
		return runningTotal;
	}

}
