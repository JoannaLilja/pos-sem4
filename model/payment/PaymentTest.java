package model.payment;

import integration.ErrorLogHandler;
import junit.framework.TestCase;

public class PaymentTest extends TestCase 
{
	Payment payment;
	
	
	public void testDiscount() throws Exception
	{
		Payment payment = new Payment(new ErrorLogHandler());
		
		payment.enterDiscount(1);
		if(!payment.getDiscount().validate(1))
			fail();
	}

}
