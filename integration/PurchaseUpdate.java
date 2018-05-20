package integration;

import model.purchase.Purchase;

/**
 * Handles the update that needs to be done to external systems as a result of a completed purchase. 
 */
public class PurchaseUpdate
{
	
	Purchase purchase;
	ErrorLogHandler elh;
	
	public PurchaseUpdate(Purchase purchase, ErrorLogHandler elh)
	{
		this.purchase = purchase;
		this.elh = elh;
	}
	
	/**
	 * Executes the update of a purchase to the external InventorySystem and AccountSystem via their respective handlers. 
	 * Also creates a LogEntry of the purchase. 
	 */
	public void execute()
	{
		
		LogEntry entry = new LogEntry(purchase, elh);
		InventoryManager im = new InventoryManager(elh);
		AccountManager am = new AccountManager();
		
		im.clearItems(purchase.getItems());
		am.updateAccount(purchase);
		entry.enter();
		
	}

}
