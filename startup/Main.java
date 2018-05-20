package startup;

import controller.Controller;
import view.TotalRevenueView;
import view.View;


/**
 * Holds the main method which takes care of the startup process
 */
class Main 
{
	public static void main(String[] args) 
	{
			Controller contr = new Controller();
			contr.addPurchaseObserver(new TotalRevenueView());
			new View(contr);		
	}
}

