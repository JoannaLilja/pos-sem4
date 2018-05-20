package model.payment;

import java.util.LinkedList;

import integration.Printer;
import model.purchase.Item;
import model.purchase.Purchase;

class Receipt 
{
	
	private Printer printer = new Printer();
	private LinkedList<String> receiptTextLines = new LinkedList<String>(); //Each node represents a line on the receipt
	
	Receipt()
	{

	}

	void print(Purchase purchase)
	{
		setreceiptTextLines(purchase);
		printer.printReceipt(receiptTextLines);
	}

	private void setreceiptTextLines(Purchase purchase)
	{
				
		receiptTextLines.add("");

		addItems(purchase);
		
		double total = purchase.getPayment().getTotal();
		double amountPaid = purchase.getPayment().getAmountPaid();
		int discountId;
		int discountPerc;
		//double newTotal;
		
		receiptTextLines.add("-------------");
		receiptTextLines.add("Total: " + total + ":-");
		receiptTextLines.add("-------------");

		
		if(purchase.getPayment().hasDiscount())
		{
			discountId = purchase.getPayment().getDiscount().getId();
			discountPerc =  (int)((1-purchase.getPayment().getDiscount().getMultiplier())*100);
			total = purchase.getPayment().getTotal()*purchase.getPayment().getDiscount().getMultiplier();

			receiptTextLines.add( "Discount " + discountId + " redeemed: " + discountPerc + "% off");
			receiptTextLines.add("New total: " + total + ":-");
			receiptTextLines.add("-------------");
		}
		
		receiptTextLines.add("Entered: " + amountPaid + ":-");
		receiptTextLines.add("Change: " + (amountPaid - total) + ":-");
		receiptTextLines.add("-------------");

		receiptTextLines.add("");

	}
	
	private void addItems(Purchase purchase)
	{
		int id;
		int count;
		double price;
		double tax;
		
		
		receiptTextLines.add("Items: ");
		
		LinkedList<Item> items = purchase.getItems();	
		for(Item item : items)
		{
			id = item.getId();
			String desc = item.getDescription().toString();
			count = item.getCount();
			price = item.getPrice().getAmount();
			tax = item.getPrice().getTax().getAmount();
			
			receiptTextLines.add( " * " + desc + " [ID: " + id + "], " + "amount: " + count 
										+ ", Price: " + price*count + ":- + " + tax*count + ":- tax" );
		}
		
		receiptTextLines.add("");

	}
	
}
