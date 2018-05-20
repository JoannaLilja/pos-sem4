package integration;

import model.purchase.Purchase;

class LogEntry
{
	
	DbHandler dbh;
	Purchase purchase;
	
	LogEntry(Purchase purchase, ErrorLogHandler elh)
	{
		this.purchase = purchase;
		this.dbh = new DbHandler(elh);
	}

	public void enter() 
	{
		dbh.addLogEntry(this);
	}

}
