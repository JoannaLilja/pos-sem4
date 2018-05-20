package model.purchase;

import java.io.IOException;
import java.util.LinkedList;
import integration.PurchaseUpdate;
import model.payment.Payment;
import integration.ErrorLogHandler;
import integration.InventoryManager;
import integration.ItemNotFoundException;

/**
 * Handles the purchase itself, that is the items to be bought. 
 * Also holds a Payment, which in turn handles the payment made by the customer. 
 */
public class Purchase
{
	
	private Payment payment;
	private InventoryManager im;
	private LinkedList<Item> items = new LinkedList<Item>();
	private ErrorLogHandler elh;
	
	/**
	 * Instantiates a purchase with a printer connection. 
	 * @param elh
	 */
	public Purchase()
	{
		try {
			elh = new ErrorLogHandler();
		} catch (IOException e) 
		{
			System.err.println("ErrorLogHandler could not be created");
			e.printStackTrace();
		}
		payment = new Payment(elh);
		im = new InventoryManager(elh);
	}
	
	/**
	 * Getter for the Payment. 
	 * @return payment
	 */
	public Payment getPayment()
	{
		return payment;
	}
	/**
	 * Getter for the list of items in the purchase
	 * @return itemList
	 */
	public LinkedList<Item> getItems()
	{
		return items;
	}
	
	/**
	 * Adds an Item 
	 * @param id
	 * @return
	 * @throws ItemNotFoundException 
	 */
	public DisplayItems addItem(int id) throws ItemNotFoundException
	{
		Item foundItem = null;
		Item newItem = null;
		
		for(Item item : items)
		{
			if(item.getId() == id)
			{
				foundItem = item;
				break;
			}
		}
		
		if(foundItem != null)
		{
			foundItem.incrementCount();
			payment.addToTotal(foundItem.getPrice().getAmount());
			payment.addToTotal(foundItem.getPrice().getTax().getAmount());

		}
		else
		{
			newItem = im.getItem(id);

			items.add(newItem);
			payment.addToTotal(newItem.getPrice().getAmount());
			payment.addToTotal(newItem.getPrice().getTax().getAmount());

		}
		
		return new DisplayItems(items, payment.getTotal());
		
	}
	
	/**
	 * Called when a purcase is done and updates must be executed. 
	 */
	public void finalize()
	{
		
		PurchaseUpdate update = new PurchaseUpdate(this, elh);
		update.execute();
		
	}
	
	/**
	 * Resets the purchase
	 */
	public void reset()
	{
		items.clear();
		payment.reset();
	}


	
}
