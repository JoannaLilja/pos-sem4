package model.purchase;

/**
 * Description of an item. Simplistic class that would allow for more complexity in potential later versions rather than simply having a String description. 
 */
public class Description 
{
	
	private String description;

	Description(String description)
	{
		this.description = description;
	}
	
	@Override
	public String toString()
	{
		return description;
	}
	
}
